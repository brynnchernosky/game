package FinalProject;

import java.util.HashMap;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;

/*
 * Creates the battle setting and handles player choices. Computer choices
 * and the battle timeline itself are handled in the BattleChoices class
 * instead. The battle class was written to be used for both trainer and 
 * wild battles, at all levels of opponent intelligence. 
 */

public class Battle {
	
	private Pane _fight;
	private Pane _menu;
	private Pane _bag;
	private Pane _team;
	private Pane _menuPane;
	private Pane _backButton;
	private Label _namePlayer;
	private Label _nameOpponent;
	private Label _hpPlayer;
	private Label _hpOpponent;
	private Label _levelPlayer;
	private Label _levelOpponent;
	private String _opponentAction;
	private String _playerAction;
	private Game _game;
	private Boolean _trainer;
	private Pane _battle;
	private BattleChoices _choices;
	private String _moveUsed;
	private HashMap<Integer, Team> _opponentTeam;
	private int[] _teamNumbers;
	private int _playerIn;
	private int _opponentIn;
	private Pane _root;
	private Pane _pokemon;
	private ImageView _playerPokemon0;
	private ImageView _opponentPokemon0; 
	private ImageView _playerPokemon1;
	private ImageView _opponentPokemon1; 
	private ImageView _playerPokemon2;
	private ImageView _opponentPokemon2; 
	private ImageView _playerPokemon3;
	private ImageView _opponentPokemon3; 
	private ImageView _playerPokemon4;
	private ImageView _opponentPokemon4; 
	private ImageView _playerPokemon5;
	private ImageView _opponentPokemon5; 
	
	public Battle(Game game, Pane root, String place, Boolean trainer, int difficulty, HashMap<Integer, Team> opponentTeam,
		int[] teamNumbers) {
		/*
		 * location of battle, game, battle Pane, if it is a trainer battle, level of difficulty, opponent team HashMap
		 * (either HashMap for wild or trainer pokemon), team numbers from 0 to 5 places, use as keys for HashMap
		*/
		
		_battle = new Pane();
		_opponentTeam = opponentTeam;
		_teamNumbers = teamNumbers;
		_playerIn = 0;
	 	_opponentIn = 0;
		_trainer = trainer;
		_root = root;
		_game = game;
		Pane field = this.createBattleField(place);
		_pokemon = this.addPokemon(game, opponentTeam.get(teamNumbers[0]).getName());
		Pane info = this.setupInfo(game, opponentTeam.get(teamNumbers[0]).getName(), opponentTeam.get(teamNumbers[0]));
		_menuPane = this.addMenu(game);
		_battle.getChildren().addAll(field, _pokemon, info, _menuPane);
		root.getChildren().add(_battle);
		_choices = new BattleChoices(difficulty, this, game);
		_game.setPaused(true);
		_game.setPlayerVisible(false);
	}
	
	/*
	 * Methods called by BattleChoices
	 */
	public Pane getRoot() {
		return _root;
	}
	public void removeMenu() {
		_menuPane.setVisible(false);
	}
	public void addMenu() {
		_menuPane.setVisible(true);
	}
	public String getMoveUsed() {
		return _moveUsed;
	}
	public HashMap<Integer, Team> getOpponentTeamHashMap() {
		return _opponentTeam;
	}
	public int[] getTeamNumbers() {
		return _teamNumbers;
	}
	public int getOpponentIn() {
		return _opponentIn;
	}
	public void incrementOpponentIn() {
		_opponentIn++;
	}
	public void incrementPlayerIn() {
		_playerIn++;
	}
	public void setPlayerIn(int i) {
		_playerIn = i;
	}
	public int getPlayerIn() {
		return _playerIn;
	}
	public Boolean getTrainerBattle() {
		return _trainer;
	}
	public String getPlayerAction() {
		return _playerAction;
	}
	
	/*
	 * Called by BattleChoices whenever information could change to make sure 
	 * information displayed to player is accurate
	 */
	public void updateInfo() {
		_nameOpponent.setText(_opponentTeam.get(_opponentIn).getName());
		_levelOpponent.setText("Level: " +_opponentTeam.get(_opponentIn).getLevel());
		_namePlayer.setText(_game.getTeamHashMap().get(_playerIn).getName());
		_levelPlayer.setText("Level: " + _game.getTeamHashMap().get(_playerIn).getLevel());
	}
	public void updateHP() {
		_hpPlayer.setText("HP: " + _game.getTeamHashMap().get(_playerIn).getBattleHP() + "/" + _game.getTeamHashMap().get(_playerIn).getHP());
		_hpOpponent.setText("HP: " +  _opponentTeam.get(_opponentIn).getBattleHP() + "/" + _opponentTeam.get(_opponentIn).getHP());
	}
	public void updateOpponentPicture(int original, int newPokemon) {
		switch(original) {
		case 0:
			_opponentPokemon0.setVisible(false);
			break;
		case 1:
			_opponentPokemon1.setVisible(false);
			break;
		case 2:
			_opponentPokemon2.setVisible(false);
			break;
		case 3:
			_opponentPokemon3.setVisible(false);
			break;
		case 4:
			_opponentPokemon4.setVisible(false);
			break;
		case 5:
			_opponentPokemon5.setVisible(false);
			break;
		}
		switch(newPokemon) {
		case 0:
			_opponentPokemon0.setVisible(true);
			break;
		case 1:
			_opponentPokemon1.setVisible(true);
			break;
		case 2:
			_opponentPokemon2.setVisible(true);
			break;
		case 3:
			_opponentPokemon3.setVisible(true);
			break;
		case 4:
			_opponentPokemon4.setVisible(true);
			break;
		case 5:
			_opponentPokemon5.setVisible(true);
			break;
		}
	}
	public void updatePlayerPicture(int original, int newPokemon) {
		switch(original) {
		case 0:
			_playerPokemon0.setVisible(false);
			break;
		case 1:
			_playerPokemon1.setVisible(false);
			break;
		case 2:
			_playerPokemon2.setVisible(false);
			break;
		case 3:
			_playerPokemon3.setVisible(false);
			break;
		case 4:
			_playerPokemon4.setVisible(false);
			break;
		case 5:
			_playerPokemon5.setVisible(false);
			break;
		}
		switch(newPokemon) {
		case 0:
			_playerPokemon0.setVisible(true);
			break;
		case 1:
			_playerPokemon1.setVisible(true);
			break;
		case 2:
			_playerPokemon2.setVisible(true);
			break;
		case 3:
			_playerPokemon3.setVisible(true);
			break;
		case 4:
			_playerPokemon4.setVisible(true);
			break;
		case 5:
			_playerPokemon5.setVisible(true);
			break;
		}
	}
	
	/*
	 * Sets up the names, levels, and hp of the player and opponent in rectangles
	 */
	private Pane setupInfo(Game game, String opponent, Team opponentStats) {
		Pane pane = new Pane();
		Rectangle rectangle1 = new Rectangle(Constants.PLAYER_RX, Constants.PLAYER_RY, Constants.RECTANGLEX, Constants.RECTANGLEY);
		Rectangle rectangle2 = new Rectangle(Constants.OPPONENT_RX, Constants.OPPONENT_RY, Constants.RECTANGLEX, Constants.RECTANGLEY);
		this.infoPresets(rectangle1);
		this.infoPresets(rectangle2);
		_namePlayer = new Label(game.getTeamHashMap().get(_playerIn).getNickname());
		_namePlayer.setLayoutX(Constants.NAMELABELX);
		_namePlayer.setLayoutY(Constants.NAMELABELY);
		_namePlayer.setFont(Constants.DIALOGUE_FONT);
		_nameOpponent = new Label(opponent);
		_nameOpponent.setLayoutX(Constants.NAMELABELX2);
		_nameOpponent.setLayoutY(Constants.NAMELABELY2); 
		_nameOpponent.setFont(Constants.DIALOGUE_FONT);
		_levelPlayer = new Label("Level: " + game.getTeamHashMap().get(_playerIn).getLevel());
		_levelPlayer.setLayoutX(Constants.NAMELABELX);
		_levelPlayer.setLayoutY(Constants.NAMELABELY+Constants.LEVEL_LABEL_INCREMENT);
		_levelPlayer.setFont(Constants.DIALOGUE_FONT);
		_levelOpponent = new Label("Level: " + _opponentTeam.get(_opponentIn).getLevel());
		_levelOpponent.setLayoutX(Constants.NAMELABELX2);
		_levelOpponent.setLayoutY(Constants.NAMELABELY2+Constants.LEVEL_LABEL_INCREMENT);
		_levelOpponent.setFont(Constants.DIALOGUE_FONT);
		_hpPlayer = new Label();
		_hpPlayer.setLayoutX(Constants.NAMELABELX);
		_hpPlayer.setLayoutY(Constants.NAMELABELY+Constants.HP_LABEL_INCREMENT);
		_hpPlayer.setFont(Constants.DIALOGUE_FONT);
		_hpOpponent = new Label();
		_hpOpponent.setLayoutX(Constants.NAMELABELX2);
		_hpOpponent.setLayoutY(Constants.NAMELABELY2+Constants.HP_LABEL_INCREMENT);
		_hpOpponent.setFont(Constants.DIALOGUE_FONT);
		this.updateHP();
		pane.getChildren().addAll(rectangle1, rectangle2, _namePlayer, _nameOpponent, _levelPlayer, _levelOpponent, _hpPlayer, _hpOpponent);
		return pane;
	}
	
	/*
	 * Layout for the rectangle that lists name, level, hp
	 */
	private void infoPresets(Rectangle rectangle) {
		rectangle.setWidth(Constants.BUTTON_LENGTH);
		rectangle.setHeight(Constants.BUTTON_HEIGHT);
		rectangle.setFill(Color.ANTIQUEWHITE);
		rectangle.setStrokeWidth(1);
		rectangle.setStroke(Color.GRAY);
		rectangle.setArcWidth(Constants.LABEL_ROUND_CORNERS);
		rectangle.setArcHeight(Constants.LABEL_ROUND_CORNERS);
	}
	
	/*
	 * Creates a battle field with a background and two platforms, which
	 * change color depending on the location of the battle.
	 */
	private Pane createBattleField(String place) {
		Pane background = new Pane();
		Ellipse platform1 = new Ellipse();
		Ellipse platform2 = new Ellipse();
		switch (place) {
		case "green":
			Rectangle light = new Rectangle(0, 0, Constants.APP_X, Constants.APP_Y);
			light.setFill(Color.LIGHTGREEN);
			background.getChildren().add(light);
			platform1 = this.makePlatforms(place, Constants.PLATFORM1_X, Constants.PLATFORM1_Y);
			platform2 = this.makePlatforms(place, Constants.PLATFORM2_X, Constants.PLATFORM2_Y);
			platform1.setFill(Color.GREEN);
			platform2.setFill(Color.GREEN);
			break;
		default:
			Rectangle gray = new Rectangle(0, 0, Constants.APP_X, Constants.APP_Y);
			gray.setFill(Color.GRAY);
			background.getChildren().add(gray);
			platform1 = this.makePlatforms(place, Constants.PLATFORM1_X, Constants.PLATFORM1_Y);
			platform2 = this.makePlatforms(place, Constants.PLATFORM2_X, Constants.PLATFORM2_Y);
			break;
		}
		background.getChildren().addAll(platform1, platform2);
		return background;
	}
	
	/*
	 * Creates an ellipse of constant size in the appropriate place.
	 */
	private Ellipse makePlatforms(String place, int x, int y) {
		Ellipse platform = new Ellipse(Constants.PLATFORM_RAD1, Constants.PLATFORM_RAD2);
		platform.setCenterX(x);
		platform.setCenterY(y);
		switch(place) {
		default:
			platform.setFill(Color.LIGHTGRAY);
		}
		return platform;
	}
	
	/*
	 * Adds sprites for the opponent and player pokemon; break lines deliberately ignored
	 */
	private Pane addPokemon(Game game, String opponent) {
		game.setPaused(true);
		Pane pokemonPane = new Pane();
		switch (_game.getPlayerTeamInts().size()-1) {
		case 5:
			_playerPokemon5 = game.getPokemonHashMap().get(game.getTeamHashMap().get(5).getName()).getBack();
			pokemonPane.getChildren().add(_playerPokemon5);
			this.playerPokemonPresets(_playerPokemon5);
			_playerPokemon5.setVisible(false);
		case 4:
			_playerPokemon4 = game.getPokemonHashMap().get(game.getTeamHashMap().get(4).getName()).getBack(); 
			pokemonPane.getChildren().add(_playerPokemon4);
			this.playerPokemonPresets(_playerPokemon4);
			_playerPokemon4.setVisible(false);
		case 3:
			_playerPokemon3 = game.getPokemonHashMap().get(game.getTeamHashMap().get(3).getName()).getBack(); 
			pokemonPane.getChildren().add(_playerPokemon3);
			this.playerPokemonPresets(_playerPokemon3);
			_playerPokemon3.setVisible(false);
		case 2:
			_playerPokemon2 = game.getPokemonHashMap().get(game.getTeamHashMap().get(2).getName()).getBack(); 
			pokemonPane.getChildren().add(_playerPokemon2);
			this.playerPokemonPresets(_playerPokemon2);
			_playerPokemon2.setVisible(false);
		case 1:
			_playerPokemon1 = game.getPokemonHashMap().get(game.getTeamHashMap().get(1).getName()).getBack(); 
			pokemonPane.getChildren().add(_playerPokemon1);
			this.playerPokemonPresets(_playerPokemon1);
			_playerPokemon1.setVisible(false);
		case 0:
			_playerPokemon0 = game.getPokemonHashMap().get(game.getTeamHashMap().get(0).getName()).getBack(); 
			pokemonPane.getChildren().add(_playerPokemon0);
			this.playerPokemonPresets(_playerPokemon0);
		default:
			break;
		}
		
		switch (_teamNumbers.length-1) {
		case 5:
			_opponentPokemon5 = game.getPokemonHashMap().get(_opponentTeam.get(5).getName()).getFront();
			pokemonPane.getChildren().add(_opponentPokemon5);
			this.opponentPokemonPresets(_opponentPokemon5);
			_opponentPokemon5.setVisible(false);
		case 4:
			_opponentPokemon4 = game.getPokemonHashMap().get(_opponentTeam.get(4).getName()).getFront();
			pokemonPane.getChildren().add(_opponentPokemon4);
			this.opponentPokemonPresets(_opponentPokemon4);
			_opponentPokemon4.setVisible(false);
		case 3:
			_opponentPokemon3 = game.getPokemonHashMap().get(_opponentTeam.get(3).getName()).getFront();
			pokemonPane.getChildren().add(_opponentPokemon3);
			this.opponentPokemonPresets(_opponentPokemon3);
			_opponentPokemon3.setVisible(false);
		case 2:
			_opponentPokemon2 = game.getPokemonHashMap().get(_opponentTeam.get(2).getName()).getFront();
			pokemonPane.getChildren().add(_opponentPokemon2);
			this.opponentPokemonPresets(_opponentPokemon2);
			_opponentPokemon2.setVisible(false);
		case 1:
			_opponentPokemon1 = game.getPokemonHashMap().get(_opponentTeam.get(1).getName()).getFront();
			pokemonPane.getChildren().add(_opponentPokemon1);
			this.opponentPokemonPresets(_opponentPokemon1);
			_opponentPokemon1.setVisible(false);
		case 0:
			_opponentPokemon0 = game.getPokemonHashMap().get(_opponentTeam.get(0).getName()).getFront(); 
			pokemonPane.getChildren().add(_opponentPokemon0);
			this.opponentPokemonPresets(_opponentPokemon0);
		default:
			break;
		}
		
		return pokemonPane;
	}
	
	/*
	 * Sets player pokemon sprite size and coordinates
	 */
	private void playerPokemonPresets(ImageView i) {
		i.setX(Constants.PLAYER_X);
		i.setY(Constants.PLAYER_Y);
		i.setFitHeight(Constants.POKEMON_SCALE);
		i.setFitWidth(Constants.POKEMON_SCALE);
	}
	
	/*
	 * Sets opponent pokemon sprite size and coordinates
	 */
	private void opponentPokemonPresets(ImageView i) {
		i.setX(Constants.OPPONENT_X);
		i.setY(Constants.OPPONENT_Y);
		i.setFitHeight(Constants.POKEMON_SCALE);
		i.setFitWidth(Constants.POKEMON_SCALE);
	}
	
	/*
	 * Adds the menu at the bottom of the screen
	 */
	private Pane addMenu(Game game) {
		_menuPane = new Pane();
		
		Rectangle menuBackground = new Rectangle(0, Constants.MOVEABLE_Y, Constants.APP_X, Constants.APP_Y-Constants.MOVEABLE_Y);
		menuBackground.setFill(Color.WHITE);
		menuBackground.setStrokeWidth(1);
		menuBackground.setStroke(Color.BLACK);
		
		_backButton = new Pane();
		Button back = new Button("Back");
		this.buttonPresets(back, Constants.DIALOGUE_FONT);
		back.setPrefWidth(Constants.BACK_BUTTON_LENGTH);
		back.setPrefHeight(Constants.BACK_BUTTON_HEIGHT);
		back.setLayoutX(Constants.BACK_BUTTON_X);
		back.setLayoutY(Constants.BACK_BUTTON_Y);
		back.setOnAction(new BackHandler());
		Rectangle color = this.menuBackPresets(Color.DARKRED);
		color.setWidth(Constants.BACK_BUTTON_LENGTH);
		color.setHeight(Constants.BACK_BUTTON_HEIGHT);
		color.setX(Constants.BACK_BUTTON_X);
		color.setY(Constants.BACK_BUTTON_Y);
		_backButton.getChildren().addAll(color, back);
		_backButton.setVisible(false);
		
		HBox menuText = new HBox();
		this.menuPresets(menuText);
		HBox menuBack = new HBox();
		this.menuPresets(menuBack);
		Button bagButton = new Button("Bag");
		Button fightButton = new Button("Fight");
		Button runButton = new Button("Run");
		Button teamButton = new Button("Team");
		this.buttonPresets(bagButton, Constants.BUTTON_FONT);
		this.buttonPresets(fightButton, Constants.BUTTON_FONT);
		this.buttonPresets(teamButton, Constants.BUTTON_FONT);
		this.buttonPresets(runButton, Constants.BUTTON_FONT);
		bagButton.setOnAction(new BagHandler());
		fightButton.setOnAction(new FightHandler());
		runButton.setOnAction(new RunHandler());
		teamButton.setOnAction(new TeamHandler());
		Rectangle back1 = this.menuBackPresets(Color.BLUE);
		Rectangle back2 = this.menuBackPresets(Color.RED);
		Rectangle back3 = this.menuBackPresets(Color.GOLD);
		Rectangle back4 = this.menuBackPresets(Color.GREEN);
		menuBack.getChildren().addAll(back1, back2, back3, back4);
		menuText.getChildren().addAll(bagButton, fightButton, teamButton, runButton);
		_menu = new Pane();
		_menu.getChildren().addAll(menuBack, menuText);
		this.panePresets(_menu);
		_menuPane.getChildren().addAll(menuBackground, _backButton, _menu);
		
		HBox fightMenu = new HBox();
		this.menuPresets(fightMenu);
		HBox fightBack = new HBox();
		this.menuPresets(fightBack);
		Button move1 = new Button();
		Button move2 = new Button();
		Button move3 = new Button();
		Button move4 = new Button();
		this.buttonPresets(move1, Constants.DIALOGUE_FONT);
		this.buttonPresets(move2, Constants.DIALOGUE_FONT);
		this.buttonPresets(move3, Constants.DIALOGUE_FONT);
		this.buttonPresets(move4, Constants.DIALOGUE_FONT);
		move1.setOnAction(new Move1Handler());
		move2.setOnAction(new Move2Handler());
		move3.setOnAction(new Move3Handler());
		move4.setOnAction(new Move4Handler());
		move1.setText(game.getTeamHashMap().get(_playerIn).getMove1());
		move2.setText(game.getTeamHashMap().get(_playerIn).getMove2());
		move3.setText(game.getTeamHashMap().get(_playerIn).getMove3());
		move4.setText(game.getTeamHashMap().get(_playerIn).getMove4());
		Rectangle back5 = this.menuBackPresets(Color.RED);
		Rectangle back6 = this.menuBackPresets(Color.RED);
		Rectangle back7 = this.menuBackPresets(Color.RED);
		Rectangle back8 = this.menuBackPresets(Color.RED);
		fightBack.getChildren().addAll(back5, back6, back7, back8);
		fightMenu.getChildren().addAll(move1, move2, move3, move4);
		_fight = new Pane();
		_fight.getChildren().addAll(fightBack, fightMenu);
		this.panePresets(_fight);
		_menuPane.getChildren().addAll(_fight);
		_fight.setVisible(false);
		
		return _menuPane;
	}
	
	/*
	 * Controls menu presets
	 */
	private void menuPresets(HBox pane) {
		pane.setLayoutX(Constants.BUTTON_STARTX);
		pane.setSpacing(Constants.BUTTON_SPACING);
	}
	private void panePresets(Pane pane) {
		pane.setLayoutY(Constants.BUTTON_TEXTY);
	}
	
	/*
	 * Controls button background presets
	 */
	private Rectangle menuBackPresets(Color color) {
		Rectangle rectangle = new Rectangle();
		rectangle.setWidth(Constants.BUTTON_LENGTH);
		rectangle.setHeight(Constants.BUTTON_HEIGHT);
		rectangle.setFill(color);
		rectangle.setStrokeWidth(2);
		rectangle.setStroke(Color.BLACK);
		rectangle.setArcWidth(Constants.ROUND_CORNERS);
		rectangle.setArcHeight(Constants.ROUND_CORNERS);
		return rectangle;
	}
	
	/*
	 * Controls button presets
	 */
	private void buttonPresets(Button button, Font font) {
		button.setPrefWidth(Constants.BUTTON_LENGTH);
		button.setPrefHeight(Constants.BUTTON_HEIGHT);
		button.setFont(font);
		button.setTextFill(Color.WHITE);
		button.setBackground(null);
	}
	
	/*
	 * When player clicks menu button, shows the bag menu with buttons 
	 * for items the player can use
	 */
	private class BagHandler implements EventHandler<ActionEvent> {
		@Override
		public void handle(ActionEvent event) {
			_menu.setVisible(false);
			_backButton.setVisible(true);
			HBox bagMenu = new HBox();
			Battle.this.menuPresets(bagMenu);
			bagMenu.setSpacing(20); 
			/*if (_game.getBag().get("Potions") > 0) {
				Button potions = new Button("Potions: " + _game.getBag().get("Potions"));
				potions.setOnAction(new PotionHandler());
				bagMenu.getChildren().add(potions);
			}
			if (_game.getBag().get("Super Potions") > 0) {
				Button superp = new Button("Super Potions: " + _game.getBag().get("Super Potions"));
				superp.setOnAction(new SuperHandler());
				bagMenu.getChildren().add(superp);
			}
			if (_game.getBag().get("Hyper Potions") > 0) {
				Button hyper = new Button("Hyper Potions: " + _game.getBag().get("Hyper Potions"));
				hyper.setOnAction(new HyperHandler());
				bagMenu.getChildren().add(hyper);
			}*/
			if (_game.getBag().get("Poke Balls") > 0 && _trainer == false) {
				Button poke = new Button("Poke Balls: " + _game.getBag().get("Poke Balls"));
				poke.setOnAction(new PokeHandler());
				bagMenu.getChildren().add(poke);
				_bag = new Pane();
				_bag.getChildren().addAll(bagMenu);
				Battle.this.panePresets(_bag);
				_menuPane.getChildren().add(_bag);
			}
		}
	}
	
	/* 
	 * When player clicks potion button, use potion
	 */
	private class PotionHandler implements EventHandler<ActionEvent> {
		@Override
		public void handle(ActionEvent event) {
			_menuPane.getChildren().remove(_bag);
			_game.getBag().put("Potions", _game.getBag().get("Potions")-1);
			_playerAction = "used a potion";
			_moveUsed = null;
			_choices.incrementMove();
		}
	}
	
	/* 
	 * When player clicks super potion button, use super potion
	 */
	private class SuperHandler implements EventHandler<ActionEvent> {
		@Override
		public void handle(ActionEvent event) {
			_menuPane.getChildren().remove(_bag);
			_game.getBag().put("Super Potions", _game.getBag().get("Super Potions")-1);
			_playerAction = "used a super potion";
			_moveUsed = null;
			_choices.incrementMove();
		}
	}
	
	/* 
	 * When player clicks hyper potion button, use hyper potion
	 */
	private class HyperHandler implements EventHandler<ActionEvent> {
		@Override
		public void handle(ActionEvent event) {
			_menuPane.getChildren().remove(_bag);
			_game.getBag().put("Hyper Potions", _game.getBag().get("Hyper Potions")-1);
			_playerAction = "used a hyper potion";
			_moveUsed = null;
			_choices.incrementMove();
		}
	}
	
	/* 
	 * When player clicks poke ball button, use poke ball
	 */
	private class PokeHandler implements EventHandler<ActionEvent> {
		@Override
		public void handle(ActionEvent event) {
			_menuPane.getChildren().remove(_bag);
			_game.getBag().put("Poke Balls", _game.getBag().get("Poke Balls")-1);
			_playerAction = "used a poke ball";
			_moveUsed = null;
			_choices.incrementMove();
		}
	}
	
	/*
	 * When player clicks team button, gives options to switch in different team members
	 */
	private class TeamHandler implements EventHandler<ActionEvent> {
		@Override
		public void handle(ActionEvent event) {
			_menu.setVisible(false);
			_backButton.setVisible(true);
			HBox teamMenu = new HBox();
			Battle.this.menuPresets(teamMenu);
			teamMenu.setSpacing(20); 
			Button b0 = new Button(_game.getTeamHashMap().get(0).getName());
			teamMenu.getChildren().add(b0);
			if (_game.getTeamHashMap().get(1) != null) {
				Button b1 = new Button(_game.getTeamHashMap().get(1).getName());
				teamMenu.getChildren().add(b1);
			}
			if (_game.getTeamHashMap().get(2) != null) {
				Button b2 = new Button(_game.getTeamHashMap().get(2).getName());
				teamMenu.getChildren().add(b2);
			}
			if (_game.getTeamHashMap().get(3) != null) {
				Button b3 = new Button(_game.getTeamHashMap().get(3).getName());
				teamMenu.getChildren().add(b3);
			}
			if (_game.getTeamHashMap().get(4) != null) {
				Button b4 = new Button(_game.getTeamHashMap().get(4).getName());
				teamMenu.getChildren().add(b4);
			}
			if (_game.getTeamHashMap().get(5) != null) {
				Button b5 = new Button(_game.getTeamHashMap().get(5).getName());
				teamMenu.getChildren().add(b5);
			}
			_team = new Pane();
			_team.getChildren().addAll(teamMenu);
			Battle.this.panePresets(_team);
			_menuPane.getChildren().add(_team);
		}
	}
	
	/*
	 * When player clicks run button, shows dialogue if in trainer battle,
	 * or exit battle if in wild battle
	 */
	private class RunHandler implements EventHandler<ActionEvent> {
		@Override
		public void handle(ActionEvent event) {
			if (_trainer) {
				_game.setDialogue(_menuPane, "You can't run from a trainer battle!");
				_game.setBattleDialogue(true);
			} else {
				Battle.this.endBattle();
			}
		}
	}
	
	/*
	 * When player clicks fight button, shows list of moves pokemon can use
	 */
	private class FightHandler implements EventHandler<ActionEvent> {
		@Override
		public void handle(ActionEvent event) {
			_fight.setVisible(true);
			_menu.setVisible(false);
			_backButton.setVisible(true);
		}
	}
	
	/*
	 * When player clicks button, use that move
	 */
	private class Move1Handler implements EventHandler<ActionEvent> {
		@Override
		public void handle(ActionEvent event) {
			_playerAction = "used " + _game.getTeamHashMap().get(_playerIn).getMove1();
			_moveUsed = _game.getTeamHashMap().get(_playerIn).getMove1();
			_choices.incrementMove();
		}
	}
	private class Move2Handler implements EventHandler<ActionEvent> {
		@Override
		public void handle(ActionEvent event) {
			_playerAction = "used " + _game.getTeamHashMap().get(_playerIn).getMove2();
			_moveUsed = _game.getTeamHashMap().get(_playerIn).getMove2();
			_choices.incrementMove();
		}
	}
	private class Move3Handler implements EventHandler<ActionEvent> {
		@Override
		public void handle(ActionEvent event) {
			_playerAction = "used " + _game.getTeamHashMap().get(_playerIn).getMove3();
			_moveUsed = _game.getTeamHashMap().get(_playerIn).getMove3();
			_choices.incrementMove();
		}
	}
	private class Move4Handler implements EventHandler<ActionEvent> {
		@Override
		public void handle(ActionEvent event) {
			_playerAction = "used " + _game.getTeamHashMap().get(_playerIn).getMove4();
			_moveUsed = _game.getTeamHashMap().get(_playerIn).getMove4();
			_choices.incrementMove();
		}
	}
	
	/*
	 * When player clicks back button, return to main menu screen
	 */
	private class BackHandler implements EventHandler<ActionEvent> {
		@Override
		public void handle(ActionEvent event) {
			_fight.setVisible(false);
			_backButton.setVisible(false);
			_menu.setVisible(true);
			if (_menuPane.getChildren().contains(_bag)) {
				_menuPane.getChildren().remove(_bag);
			} else if (_menuPane.getChildren().contains(_team)) {
				_menuPane.getChildren().remove(_team);
			}
		}
	}
	
	/*
	 * End battle when player loses, player winds, or player runs
	 */
	public void endBattle() {
		_root.getChildren().remove(_battle);
		_game.setPaused(false);
		_game.setPlayerVisible(true);
		_game.setBattle(false);
		_playerIn = 0;
		_opponentIn = 0;
		_playerPokemon0.setVisible(true);
		for (int i = 0; i < _game.getPlayerTeamInts().size(); i++) {
			_game.getTeamHashMap().get(i).endBattle();
		}
	}
}