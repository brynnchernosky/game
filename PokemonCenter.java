package FinalProject;

import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;

/*
 * Creates the pokemon center location
 */
public class PokemonCenter {
	private Pane _this;
	private Pane _root;
	private Game _game;
	
	public PokemonCenter(Game game, Pane root) {
		_this = new Pane();
		_game = game;
		_root = root;
		Rectangle black = new Rectangle(0,0, Constants.APP_X, Constants.APP_Y);
		ImageView background = new ImageView("file:./FinalProject/ObjectSprites/PokemonCenterInside.png");
		background.setX(Constants.CENTER_X_COORDINATE);
		background.setScaleX(Constants.CENTER_INSIDE_SCALE);
		background.setScaleY(Constants.CENTER_INSIDE_SCALE);
		_this.getChildren().addAll(black, background);
		root.getChildren().add(_this);
		this.setupObjects();
		this.setupNPCs();
		
		Door door1 = new Door(game, root, _this, "maingreen", 
			Constants.CENTER_DOOR_X1, Constants.CENTER_DOOR_Y);
		Door door2 = new Door(game, root, _this, "maingreen",
			Constants.CENTER_DOOR_X2, Constants.CENTER_DOOR_Y);
	}
	
	/*
	 * Sets up NPCs in center
	 */
	private void setupNPCs() {
		NPC nurse = new NPC(_game, _root, "nurse", "Nurse: 'Welcome to the Brown University Pokemon Center! All healing is"
			+ " complimentary thanks to the University health services fee. I'll heal your Pokemon for you.'", 
			390, 300, "front");
		NPC student = new NPC(_game, _root, "femalestudent4", "Student: 'I keep losing all of my battles...'", 
			240, 300, "front");
	}
	
	/*
	 * Sets up objects in center; i's and j's not included in constants
	 * class because they wouldn't make sense out of context
	 */
	private void setupObjects() {
		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < Constants.SQUARES_TALL; j++) {
				_game.getObjects()[i][j] = true;
			}
		}
		for (int i = 20; i < Constants.SQUARES_WIDE; i++) {
			for (int j = 0; j < Constants.SQUARES_TALL; j++) {
				_game.getObjects()[i][j] = true;
			}
		}
		for (int i = 0; i < Constants.SQUARES_WIDE; i++) {
			for (int j = 0; j < 10; j++) {
				_game.getObjects()[i][j] = true;
			}
			for (int j = Constants.SQUARES_TALL-1; j < Constants.SQUARES_TALL; j++) {
				_game.getObjects()[i][j] = true;
			}
		}
		_game.getObjects()[19][9] = null;
		_game.getObjects()[16][10] = true;
		_game.getObjects()[8][10] = true;
		for (int i = 9; i < 17; i++) {
			_game.getObjects()[i][11] = true;
		}
	}
	
}