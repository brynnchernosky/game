package FinalProject;

import java.util.ArrayList;
import java.util.HashMap;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

/*
 * Top level class, it controls the general flow of gameplay and sets up
 * the main components of the game.
 */

public class Game {
	
	private Pane _root;
	private Pane _backgroundPane;
	private String _player;
	private String _left;
	private String _right;
	private String _back;
	private String _front;
	private ImageView _playerSprite;
	private Object[][] _objects;
	private Interactable[][] _interactable;
	private Dialogue _dialogue;
	private int _frame;
	private String _name;
	private Boolean _paused;
	private int _facingX;
	private int _facingY;
	private Boolean _npcDialogue;
	private Boolean _battleDialogue;
	private Boolean _inBattle;
	private HBox _menu;
	private HashMap<String, Integer> _bag;
	private HashMap<String, Move> _moves;
	private HashMap<String, Pokemon> _pokemon;
	private HashMap<Integer, Team> _team;
	private ArrayList<Integer> _playerTeamInts;
	private SunLab _lab;
	
	public Game(Pane root) {
		_paused = true;
		_root = root;
		_frame = 0;
		_npcDialogue = false;
		_battleDialogue = false;
		_inBattle = false;
		
		root.setFocusTraversable(true);
		root.addEventHandler(KeyEvent.KEY_PRESSED, new KeyHandler());
		root.addEventHandler(MouseEvent.MOUSE_CLICKED, new MouseHandler());
		
		_objects = new Object[Constants.SQUARES_WIDE][Constants.SQUARES_TALL];
		_interactable = new Interactable[Constants.SQUARES_WIDE][Constants.SQUARES_TALL+1];
		
		_backgroundPane = new Pane();
		
		Rectangle menuBackground = new Rectangle(0, Constants.MOVEABLE_Y, Constants.APP_X, Constants.APP_Y-Constants.MOVEABLE_Y);
		menuBackground.setFill(Color.BLUE);
		_menu = new HBox();
		_menu.setLayoutY(Constants.MOVEABLE_Y);
		Button settingsButton = new Button("Settings"); 
		Button bagButton = new Button("Bag");
		Button teamButton = new Button("Team");
		Button quitButton = new Button("Quit");
		_menu.getChildren().addAll(settingsButton, bagButton, teamButton, quitButton);
		_menu.setVisible(false);
		menuBackground.setVisible(false);
		root.getChildren().addAll(_backgroundPane, menuBackground, _menu);
		this.setupTimeline();
		
		_bag = new HashMap<String, Integer>();
		_bag.put("Potions", Constants.STARTING_POTIONS);
		_bag.put("Super Potions", 0);
		_bag.put("Hyper Potions", 0);
		_bag.put("Poke Balls", Constants.STARTING_BALLS); 
		
		MoveHashMap move = new MoveHashMap();
		_moves = move.getHashMap();
		PokemonHashMap pokemon = new PokemonHashMap();
		_pokemon = pokemon.getHashMap();
		_team = new HashMap<Integer, Team>();
		
		_playerTeamInts = new ArrayList<Integer>();
		_playerTeamInts.add(0);
	}
	
	/*
	 * Getter and setter methods called by cutscenes, locations
	 */
	public Boolean getBattle() {
		return _inBattle;
	}
	public void setBattle(Boolean bool) {
		_inBattle = bool;
	}
	public int getFrame() {
		return _frame;
	}
	public void setFrame(int i) {
		_frame = i;
	}
	public void setDialogue(Pane root, String string) {
		_dialogue = new Dialogue(root, string);
	}
	public void setNPCDialogue(Boolean bool) {
		_npcDialogue = bool;
	}
	public void setBattleDialogue(Boolean bool) {
		_battleDialogue = bool;
	}
	public void setName(String string) {
		_name = string;
	}
	public ImageView getPlayer() {
		return _playerSprite;
	}
	public void setPlayer(String string) {
		_player = string;
	}
	public Object[][] getObjects() {
		return _objects;
	}
	public Interactable[][] getInteractable() {
		return _interactable;
	}
	public void setPaused(Boolean bool) {
		_paused = bool;
	}
	public Boolean getPaused() {
		return _paused;
	}
	public double getPlayerX() {
		return _playerSprite.getX();
	}
	public double getPlayerY() {
		return _playerSprite.getY();
	}
	public void setPlayerX(int i) {
		_playerSprite.setX(i);
	}
	public void setPlayerY(int i) {
		_playerSprite.setY(i);
	}
	public int getPlayerFaceX() {
		return _facingX;
	}
	public int getPlayerFaceY() {
		return _facingY;
	}
	public String getName() {
		return _name;
	}
	public Boolean getNPCDialogue() {
		return _npcDialogue;
	}
	public void setPlayerVisible(Boolean bool) {
		_playerSprite.setVisible(bool);
	}
	public HashMap<String, Integer> getBag() {
		return _bag;
	}
	public HashMap<Integer, Team> getTeamHashMap() {
		return _team;
	}
	public HashMap<String, Move> getMoveHashMap() {
		return _moves;
	}
	public HashMap<String, Pokemon> getPokemonHashMap() {
		return _pokemon;
	}
	public ArrayList<Integer> getPlayerTeamInts() {
		return _playerTeamInts;
	}
	
	/*
	 * Sets up the major timeline of the game
	 */
	private void setupTimeline(){
		KeyFrame kf = new KeyFrame(Duration.seconds(Constants.DURATION), new TimeHandler());
		Timeline timeline = new Timeline(kf);
		timeline.setCycleCount(Animation.INDEFINITE);
		timeline.play();
	}
	/*
	 * Controls the timing of the game
	 */
	private class TimeHandler implements EventHandler<ActionEvent> {
		@Override
		public void handle(ActionEvent event) {
			if (_dialogue == null) {
				switch (_frame) {
				case 0:
					_dialogue = new Dialogue(_root, "Welcome to the world of CS15! Before we begin, please customize your student ID.");
					break;
				case 2:
					_lab = new SunLab(Game.this, _backgroundPane);
					_playerSprite = new ImageView();
					_playerSprite.setX(Constants.PLAYER_START_X);
					_playerSprite.setY(Constants.PLAYER_START_Y);
					_root.getChildren().add(_playerSprite);
					switch (_player) {
						case "red":
							Game.this.changeSprite("file:./FinalProject/HumanSprites/RedFront.png");
							_front = new String("file:./FinalProject/HumanSprites/RedFront.png");
							_back = new String("file:./FinalProject/HumanSprites/RedBack.png");
							_left = new String("file:./FinalProject/HumanSprites/RedLeft.png");
							_right = new String("file:./FinalProject/HumanSprites/RedRight.png");
							break;
						case "leaf":
							Game.this.changeSprite("file:./FinalProject/HumanSprites/LeafFront.png");
							_front = new String("file:./FinalProject/HumanSprites/LeafFront.png");
							_back = new String("file:./FinalProject/HumanSprites/LeafBack.png");
							_left = new String("file:./FinalProject/HumanSprites/LeafLeft.png");
							_right = new String("file:./FinalProject/HumanSprites/LeafRight.png");
							break;
						case "ethan":
							Game.this.changeSprite("file:./FinalProject/HumanSprites/EthanFront.png");
							_front = new String("file:./FinalProject/HumanSprites/EthanFront.png");
							_back = new String("file:./FinalProject/HumanSprites/EthanBack.png");
							_left = new String("file:./FinalProject/HumanSprites/EthanLeft.png");
							_right = new String("file:./FinalProject/HumanSprites/EthanRight.png");
							break;
						case "lyra":
							Game.this.changeSprite("file:./FinalProject/HumanSprites/LyraFront.png");
							_front = new String("file:./FinalProject/HumanSprites/LyraFront.png");
							_back = new String("file:./FinalProject/HumanSprites/LyraBack.png");
							_left = new String("file:./FinalProject/HumanSprites/LyraLeft.png");
							_right = new String("file:./FinalProject/HumanSprites/LyraRight.png");
							break;
						case "lucas":
							Game.this.changeSprite("file:./FinalProject/HumanSprites/LucasFront.png");
							_front = new String("file:./FinalProject/HumanSprites/LucasFront.png");
							_back = new String("file:./FinalProject/HumanSprites/LucasBack.png");
							_left = new String("file:./FinalProject/HumanSprites/LucasLeft.png");
							_right = new String("file:./FinalProject/HumanSprites/LucasRight.png");
							break;
						case "dawn":
							Game.this.changeSprite("file:./FinalProject/HumanSprites/DawnFront.png");
					 		_front = new String("file:./FinalProject/HumanSprites/DawnFront.png");
							_back = new String("file:./FinalProject/HumanSprites/DawnBack.png");
							_left = new String("file:./FinalProject/HumanSprites/DawnLeft.png");
							_right = new String("file:./FinalProject/HumanSprites/DawnRight.png");
							break;
						default:
							break;
					}
					StarterSelection selection = new StarterSelection(Game.this, _root);
					_frame++;
					break;
				case 14:
					_lab.removePikachu();
					_frame++;
					break;
				default:
					break;
				}
			} 
		}
	}
	
	/*
	 * Makes dialogue disappear when screen clicked, also controls 
	 * CharacterMaker cutscene
	 */
	private class MouseHandler implements EventHandler<MouseEvent> {
		@Override
		public void handle(MouseEvent e) {
			if (_dialogue != null) {
				_dialogue.removeDialogue();
				_dialogue = null;
				if (_frame == 0){
					CharacterMaker start = new CharacterMaker(_root, Game.this);
				} 
				if (_npcDialogue == false) {
					_frame++;
				} else {
					_npcDialogue = false;
					_paused = false;
				} 
			} 
		}
	}
	
	/*
	 * Changes the direction the player sprite is facing
	 */
	private void changeSprite(String string) {
		int x = (int) (_playerSprite.getX());
		int y = (int) (_playerSprite.getY());
		_root.getChildren().remove(_playerSprite);
		_playerSprite = new ImageView(string);
		_playerSprite.setX(x);
		_playerSprite.setY(y);
		_root.getChildren().add(_playerSprite);
	}
	
	/*
	 * Handles player key input
	 */
	private class KeyHandler implements EventHandler<KeyEvent> {
		@Override
		public void handle(KeyEvent e) {
			KeyCode keyPressed = e.getCode();

			switch (keyPressed) { 
				case LEFT: //moves player left if possible
					if (_paused == false) {
						Game.this.changeSprite(_left);
					}
					if (Game.this.moveLeftValid() && _paused == false) {
						_playerSprite.setX(_playerSprite.getX()-Constants.MOVE_INCREMENT);
					}
					Game.this.checkInteractable();
					_facingX = (int) (_playerSprite.getX()/Constants.SQUARE_SIDE)-1;
					_facingY = (int) (_playerSprite.getY()/Constants.SQUARE_SIDE);
					break;
				case RIGHT: //moves player right if possible
					if (_paused == false) {
						Game.this.changeSprite(_right);
					}
					if (Game.this.moveRightValid() && _paused == false) {
						_playerSprite.setX(_playerSprite.getX()+Constants.MOVE_INCREMENT);
					}
					Game.this.checkInteractable();
					_facingX = (int) (_playerSprite.getX()/Constants.SQUARE_SIDE)+1;
					_facingY = (int) (_playerSprite.getY()/Constants.SQUARE_SIDE);
					break;
				case DOWN: //moves player down if possible
					if (_paused == false) {
						Game.this.changeSprite(_front);
					}
					if (Game.this.moveDownValid() && _paused == false) {
						_playerSprite.setY(_playerSprite.getY()+Constants.MOVE_INCREMENT);
					}
					Game.this.checkInteractable();
					_facingX = (int) (_playerSprite.getX()/Constants.SQUARE_SIDE);
					_facingY = (int) (_playerSprite.getY()/Constants.SQUARE_SIDE)+1;
					break;
				case UP: //move player up if possible
					if (_paused == false) {
						Game.this.changeSprite(_back);
					}
					if (Game.this.moveUpValid() && _paused == false) {
						_playerSprite.setY(_playerSprite.getY()-Constants.MOVE_INCREMENT);
					}
					Game.this.checkInteractable();
					_facingX = (int) (_playerSprite.getX()/Constants.SQUARE_SIDE);
					_facingY = (int) (_playerSprite.getY()/Constants.SQUARE_SIDE)-1;
					break;
				case SPACE: //interact with person/object if possible
					if (_interactable[_facingX][_facingY] != null && _paused == false) {
						_interactable[_facingX][_facingY].whenInteracted();
					} 
					break;
				default:
					break;
				}
			e.consume();
		}
	}
	
	/*
	 * Checks if player is standing on interactable object e.g. grass,
	 * and runs the whenInteracted method for that object
	 */
	private void checkInteractable() { 
		if (_playerSprite.getX()/Constants.SQUARE_SIDE < Constants.SQUARES_WIDE &&
			_playerSprite.getY()/Constants.SQUARE_SIDE < Constants.SQUARES_TALL) {
			if (_interactable[(int) (_playerSprite.getX()/Constants.SQUARE_SIDE)]
				[(int) (_playerSprite.getY()/Constants.SQUARE_SIDE)] != null) {
				_interactable[(int) (_playerSprite.getX()/Constants.SQUARE_SIDE)]
						[(int) (_playerSprite.getY()/Constants.SQUARE_SIDE)].whenInteracted();
			}
		}
	}
	
	/*
	 * Checks player move validity based on bounds of screen and object
	 * in overworld
	 */
	private Boolean moveLeftValid() {
		if (_playerSprite.getX() - Constants.SQUARE_SIDE < 0) {
			return false;
		} else if (_objects[(int) (_playerSprite.getX()/Constants.SQUARE_SIDE)-1][(int) (_playerSprite.getY()/Constants.SQUARE_SIDE)] != null) {
			return false;
		} else {
			return true;
		}
	}
	private Boolean moveRightValid() {
		if (_playerSprite.getX() + Constants.SQUARE_SIDE >= Constants.MOVEABLE_X) {
			return false;
		} else if (_objects[(int) (_playerSprite.getX()/Constants.SQUARE_SIDE)+1][(int) (_playerSprite.getY()/Constants.SQUARE_SIDE)] != null) {
			return false;
		} else {
			return true;
		}
	}
	private Boolean moveUpValid() {
		if (_playerSprite.getY() - Constants.SQUARE_SIDE < 0) {
			return false;
		} else if (_objects[(int) (_playerSprite.getX()/Constants.SQUARE_SIDE)][(int) (_playerSprite.getY()/Constants.SQUARE_SIDE)-1] != null) {
			return false;
		} else {
			return true;
		}
	}
	private Boolean moveDownValid() {
		if (_playerSprite.getY() + Constants.SQUARE_SIDE >= Constants.MOVEABLE_Y) {
			return false;
		} else if (_objects[(int) (_playerSprite.getX()/Constants.SQUARE_SIDE)][(int) (_playerSprite.getY()/Constants.SQUARE_SIDE)+1] != null) {
			return false;
		} else {
			return true;
		}
	}
}