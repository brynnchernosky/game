package FinalProject;

import java.util.HashMap;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

/*
 * Controls the starter selection cut scene
 */
public class StarterSelection {
	
	private Pane _this;
	private Pane _root;
	private ImageView _bulbasaur;
	private ImageView _squirtle;
	private ImageView _charmander;
	private ImageView _chikorita;
	private ImageView _cyndaquil;
	private ImageView _totodile;
	private ImageView _chimchar;
	private ImageView _turtwig;
	private ImageView _piplup;
	
	private Game _game;
	private Label _chooseLabel;
	
	private int _frame;
	private Dialogue _dialogue;
	
	public StarterSelection(Game game, Pane root) {
		_root = root;
		_this = new Pane();
		_game = game;
		_frame = 3;
		
		Rectangle background = new Rectangle(0,0, Constants.APP_X, Constants.APP_Y);
		
		_chooseLabel = new Label("Click on a Pokemon to borrow it from the storage system.");
		_chooseLabel.setTextFill(Color.WHITE);
		_chooseLabel.setLayoutX(Constants.DIALOGUE_X);
		_chooseLabel.setLayoutY(Constants.DIALOGUE_Y);
		_chooseLabel.setFont(Constants.DIALOGUE_FONT);
		
		_this.getChildren().addAll(background, _chooseLabel);
		
		_bulbasaur = new ImageView("file:./FinalProject/PokemonSprites/BulbasaurFront.png");
		this.setupPicture(_bulbasaur, Constants.BULBASAUR_X, Constants.BULBASAUR_Y,
			new BulbasaurHandler());
		Label label1 = new Label("Bulbasaur");
		this.setupLabel(label1, Constants.BULBASAUR_LABELX, Constants.BULBASAUR_LABELY);
		
		_charmander = new ImageView("file:./FinalProject/PokemonSprites/CharmanderFront.png");
		this.setupPicture(_charmander, Constants.CHARMANDER_X, Constants.CHARMANDER_Y,
				new CharmanderHandler());
		Label label2 = new Label("Charmander");
		this.setupLabel(label2, Constants.CHARMANDER_LABELX, Constants.CHARMANDER_LABELY);
		
		_squirtle = new ImageView("file:./FinalProject/PokemonSprites/SquirtleFront.png");
		this.setupPicture(_squirtle, Constants.SQUIRTLE_X, Constants.SQUIRTLE_Y,
				new SquirtleHandler());
		Label label3 = new Label("Squirtle");
		this.setupLabel(label3, Constants.SQUIRTLE_LABELX, Constants.SQUIRTLE_LABELY);
		
		_chikorita = new ImageView("file:./FinalProject/PokemonSprites/ChikoritaFront.png");
		this.setupPicture(_chikorita, Constants.CHIKORITA_X, Constants.CHIKORITA_Y,
				new ChikoritaHandler());
		Label label4 = new Label("Chikorita");
		this.setupLabel(label4, Constants.CHIKORITA_LABELX, Constants.CHIKORITA_LABELY);
		
		_cyndaquil = new ImageView("file:./FinalProject/PokemonSprites/CyndaquilFront.png");
		this.setupPicture(_cyndaquil, Constants.CYNDAQUIL_X, Constants.CYNDAQUIL_Y,
				new CyndaquilHandler());
		Label label5 = new Label("Cyndaquil");
		this.setupLabel(label5, Constants.CYNDAQUIL_LABELX, Constants.CYNDAQUIL_LABELY);
		
		_totodile = new ImageView("file:./FinalProject/PokemonSprites/TotodileFront.png");
		this.setupPicture(_totodile, Constants.TOTODILE_X, Constants.TOTODILE_Y,
				new TotodileHandler());
		Label label6 = new Label("Totodile");
		this.setupLabel(label6, Constants.TOTODILE_LABELX, Constants.TOTODILE_LABELY);
		
		_turtwig = new ImageView("file:./FinalProject/PokemonSprites/TurtwigFront.png");
		this.setupPicture(_turtwig, Constants.TURTWIG_X, Constants.TURTWIG_Y,
				new TurtwigHandler());
		Label label7 = new Label("Turtwig");
		this.setupLabel(label7, Constants.TURTWIG_LABELX, Constants.TURTWIG_LABELY);
		
		_chimchar = new ImageView("file:./FinalProject/PokemonSprites/ChimcharFront.png");
		this.setupPicture(_chimchar, Constants.CHIMCHAR_X, Constants.CHIMCHAR_Y,
				new ChimcharHandler());
		Label label8 = new Label("Chimchar");
		this.setupLabel(label8, Constants.CHIMCHAR_LABELX, Constants.CHIMCHAR_LABELY);
		
		_piplup = new ImageView("file:./FinalProject/PokemonSprites/PiplupFront.png");
		this.setupPicture(_piplup, Constants.PIPLUP_X, Constants.PIPLUP_Y,
				new PiplupHandler());
		Label label9 = new Label("Piplup");
		this.setupLabel(label9, Constants.PIPLUP_LABELX, Constants.PIPLUP_LABELY);
		root.getChildren().add(_this);
		_this.setVisible(false);
		
		root.addEventHandler(MouseEvent.MOUSE_CLICKED, new MouseHandler());
		root.addEventHandler(KeyEvent.KEY_PRESSED, new KeyHandler());
		this.setupTimeline();
	}
	
	/*
	 * Sets up pokemon image presets
	 */
	private void setupPicture(ImageView image, int x, int y, EventHandler event) {
		image.setFitHeight(Constants.SELECT_SIDE);
		image.setFitWidth(Constants.SELECT_SIDE);
		image.setLayoutX(x);
		image.setLayoutY(y);
		image.addEventHandler(MouseEvent.MOUSE_CLICKED, event);
		_this.getChildren().add(image);
	}
	
	/*
	 * Sets up pokemon label presets
	 */
	private void setupLabel(Label label, int x, int y) {
		label.setLayoutX(x);
		label.setLayoutY(y);
		label.setTextFill(Color.WHITE);
		label.setFont(Constants.DIALOGUE_FONT);
		_this.getChildren().add(label);
	} 
	
	/*
	 * Creates handlers for each starter pokemon being selected and added to the player character's team
	 */
	private class BulbasaurHandler implements EventHandler<MouseEvent> {
		@Override
		public void handle(MouseEvent event) {
			NewPokemon b = new NewPokemon("Bulbasaur", 50, _game.getMoveHashMap(), _game.getPokemonHashMap());
			_game.getTeamHashMap().put(0, b.getPokemon());
			StarterSelection.this.selectStarter();
		}
	}

	private class CharmanderHandler implements EventHandler<MouseEvent> {
		@Override
		public void handle(MouseEvent event) {
			NewPokemon b = new NewPokemon("Charmander", 50, _game.getMoveHashMap(), _game.getPokemonHashMap());
			_game.getTeamHashMap().put(0, b.getPokemon());
			StarterSelection.this.selectStarter();
		}
	}
	private class SquirtleHandler implements EventHandler<MouseEvent> {
		@Override
		public void handle(MouseEvent event) {
			NewPokemon b = new NewPokemon("Squirtle", 50, _game.getMoveHashMap(), _game.getPokemonHashMap());
			_game.getTeamHashMap().put(0, b.getPokemon());
			StarterSelection.this.selectStarter();
		}
	}
	private class ChikoritaHandler implements EventHandler<MouseEvent> {
		@Override
		public void handle(MouseEvent event) {
			NewPokemon b = new NewPokemon("Chikorita", 50, _game.getMoveHashMap(), _game.getPokemonHashMap());
			_game.getTeamHashMap().put(0, b.getPokemon());
			StarterSelection.this.selectStarter();
		}
	}
	private class CyndaquilHandler implements EventHandler<MouseEvent> {
		@Override
		public void handle(MouseEvent event) {
			NewPokemon b = new NewPokemon("Cyndaquil", 50, _game.getMoveHashMap(), _game.getPokemonHashMap());
			_game.getTeamHashMap().put(0, b.getPokemon());
			StarterSelection.this.selectStarter();
		}
	}
	private class TotodileHandler implements EventHandler<MouseEvent> {
		@Override
		public void handle(MouseEvent event) {
			NewPokemon b = new NewPokemon("Totodile", 50, _game.getMoveHashMap(), _game.getPokemonHashMap());
			_game.getTeamHashMap().put(0, b.getPokemon());
			StarterSelection.this.selectStarter();
		}
	}
	private class TurtwigHandler implements EventHandler<MouseEvent> {
		@Override
		public void handle(MouseEvent event) {
			NewPokemon b = new NewPokemon("Turtwig", 50, _game.getMoveHashMap(), _game.getPokemonHashMap());
			_game.getTeamHashMap().put(0, b.getPokemon());
			StarterSelection.this.selectStarter();
		}
	}
	private class ChimcharHandler implements EventHandler<MouseEvent> {
		@Override
		public void handle(MouseEvent event) {
			NewPokemon b = new NewPokemon("Chimchar", 50, _game.getMoveHashMap(), _game.getPokemonHashMap());
			_game.getTeamHashMap().put(0, b.getPokemon());
			StarterSelection.this.selectStarter();
		}
	}
	private class PiplupHandler implements EventHandler<MouseEvent> {
		@Override
		public void handle(MouseEvent event) {
			NewPokemon b = new NewPokemon("Piplup", 50, _game.getMoveHashMap(), _game.getPokemonHashMap());
			_game.getTeamHashMap().put(0, b.getPokemon());
			StarterSelection.this.selectStarter();
		}
	}
	private void selectStarter() {
		_frame++;
		_this.setVisible(false);
		_game.setPlayerVisible(true);
	}
	
	/*
	 * Sets up timeline for cut scene
	 */
	public void setupTimeline(){
		KeyFrame kf = new KeyFrame(Duration.seconds(Constants.DURATION), new TimeHandler());
		Timeline timeline = new Timeline(kf);
		timeline.setCycleCount(Animation.INDEFINITE);
		timeline.play();
	}
	/*
	 * Controls dialogue and flow of cut scene
	 */
	private class TimeHandler implements EventHandler<ActionEvent> {
		@Override
		public void handle(ActionEvent event) {
			if (_dialogue == null) {
				if (_frame == 3) {
					_dialogue = new Dialogue(_root, "You've been trapped in the SunLab for hours working out a bug in your final project.");
				} else if (_frame == 4) {
					_dialogue = new Dialogue(_root, "Finally, you run the handin command in the terminal. Time to get out of here.");
				} else if (_frame == 5 && 
					(_game.getPlayerX() == 0 && _game.getPlayerY() == Constants.SQUARE_SIDE*(Constants.SQUARES_TALL-2)|| 
					_game.getPlayerX() == Constants.SQUARE_SIDE && _game.getPlayerY() == Constants.SQUARE_SIDE*(Constants.SQUARES_TALL-1))) {
					_dialogue = new Dialogue(_root, "Of course. There's a Pikachu blocking the exit.");
					_game.setPaused(true);
				} else if (_frame == 6) {
					_dialogue = new Dialogue(_root, _game.getName() + ": 'I have waited way too long for dinner to be stopped by some stupid Pikachu.'");
				} else if (_frame == 7) {
					_dialogue = new Dialogue(_root, "Hmmm. Well, during last lecture, Andy did explain how the Pokemon storage"
						+ " system works. And no one would really mind if you used the SunLab consultant's computer to borrow a Pokemon to deal with the Pikachu...");
				} else if (_frame == 9) { 
					_dialogue = new Dialogue(_root, "It's surprisingly easy to break into the storage system, and soon you are" +
					" given your choice of Pokemon.");
					_game.setPaused(true);
				} else if (_frame == 10) {
					_this.setVisible(true);
					_game.setPlayerVisible(false);
				} else if (_frame == 11) {
					_dialogue = new Dialogue(_root, "With the borrowed " + _game.getTeamHashMap().get(0).getName() + " at your side, you're ready to take on the Pikachu.");
				} else if (_frame == 12 &&
					(_game.getPlayerX() == 0 && _game.getPlayerY() == Constants.SQUARE_SIDE*(Constants.SQUARES_TALL-2)|| 
					_game.getPlayerX() == Constants.SQUARE_SIDE && _game.getPlayerY() == Constants.SQUARE_SIDE*(Constants.SQUARES_TALL-1))) {
					HashMap<Integer, Team> h = new HashMap<Integer, Team>();
					NewPokemon w = new NewPokemon("Pikachu", 25, _game.getMoveHashMap(), _game.getPokemonHashMap());
					h.put(0, w.getPokemon());
					int[] ints = new int[1];
					ints[0] = 0;
					Battle pikachuBattle = new Battle(_game, _root, "", false, 0, h, ints);
					_frame++;
				} else if (_frame == 13 && _game.getPaused() == false) {
					_frame++;
					_game.setFrame(_frame);
				} 
			} 
		}
	}
		
	/*
	 * Used for specific interaction with consultant's computer
	 */
	private class KeyHandler implements EventHandler<KeyEvent> {
		@Override
		public void handle(KeyEvent e) {
			KeyCode keyPressed = e.getCode();

			switch (keyPressed) { 
			case SPACE:	
				if (_frame == 8 && _game.getPlayerFaceX() == 2 && _game.getPlayerFaceY() == 18 && 
					_game.getPlayerX() == Constants.SQUARE_SIDE*2 && _game.getPlayerY() == Constants.SQUARE_SIDE*(Constants.SQUARES_TALL-1)) {
					_frame++;
				}
			}
		}
	}
	
	/*
	 * Handles mouse input for clearing dialogue
	 */
	private class MouseHandler implements EventHandler<MouseEvent> {
		@Override
		public void handle(MouseEvent e) {
			if (_dialogue != null) {
				_dialogue.removeDialogue();
				_dialogue = null;
				if (_frame == 4) {
					_game.setPaused(false);
				} else if (_frame == 7) {
					_game.setPaused(false);
				} else if (_frame == 11) {
					_game.setPaused(false);
				}
				if (_frame != 1 && _game.getNPCDialogue() == false) {
					_frame++;
				} 
				if (_game.getNPCDialogue()) {
					_game.setNPCDialogue(false);
					_game.setPaused(false);
				}
			} 
		}
	}
	
	
}