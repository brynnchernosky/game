package FinalProject;

import java.util.Hashtable;

import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;

/*
 * Creates SunLab location
 */

public class SunLab {
	
	private Game _game;
	private Pane _this;
	private ImageView _pikachu;
	
	public SunLab(Game game, Pane root) {
		_game = game;
		_this = new Pane();
		Rectangle floor = new Rectangle(0, 0, Constants.APP_X, Constants.APP_Y);
		floor.setFill(Color.LIGHTGRAY);
		Rectangle stage = new Rectangle(0, 0, Constants.APP_X, Constants.STAGE_HEIGHT);
		stage.setFill(Color.GRAY);
		Line wall1 = new Line(1, 1, Constants.APP_X+1, 1);
		wall1.setStrokeWidth(1);
		Line wall2 = new Line(1, 1, 1, Constants.MOVEABLE_Y+15);
		wall2.setStrokeWidth(1);
		Line wall3 = new Line(Constants.SQUARE_SIDE, Constants.MOVEABLE_Y+15, Constants.APP_X, Constants.MOVEABLE_Y+15);
		wall3.setStrokeWidth(1);
		Line wall4 = new Line(Constants.MOVEABLE_X-7, 0, Constants.MOVEABLE_X-7, Constants.MOVEABLE_Y+15);
		wall4.setStrokeWidth(1);
		_this.getChildren().addAll(floor, stage, wall1, wall2, wall3, wall4);
		if (game.getFrame() == 2) {
			_pikachu = new ImageView("file:./FinalProject/PokemonSprites/PikachuBack.png");
			game.getObjects()[0][Constants.SQUARES_TALL-1] = _pikachu;
			_pikachu.setFitHeight(Constants.PIKACHU_HEIGHT);
			_pikachu.setFitWidth(Constants.PIKACHU_WIDTH);
			_pikachu.setY((Constants.SQUARES_TALL-1)*Constants.SQUARE_SIDE);
			_pikachu.setX(Constants.PIKACHU_X);
			_this.getChildren().addAll(_pikachu);
		}
		this.setupComputers(_this);
		this.setupNPCs();
		root.getChildren().add(_this);
		Door door = new Door(game, root,_this, "maingreen", 0, 20);
	} 
	
	/*
	 * Sets up computers in sunlab
	 */
	private void setupComputers(Pane root) {
		for (int i = 0; i < Constants.COMPUTER_COLUMNS; i++) {
			for (int j = 0; j < Constants.COMPUTER_ROWS; j++) {
				ImageView computer = new ImageView(Constants.COMPUTER);
				computer.setFitHeight(Constants.COMPUTER_HEIGHT);
				computer.setFitWidth(Constants.COMPUTER_LENGTH);
				computer.setX(Constants.COMPUTER_START_X+i*Constants.COMPUTER_LENGTH);
				computer.setY(Constants.COMPUTER_START_Y+j*Constants.COMPUTER_INCREMENT);
				root.getChildren().add(computer);
				_game.getObjects()[2*i+2][2*j+4] = computer;
				_game.getObjects()[2*i+3][2*j+4] = computer;
			}
		}
	}
	
	
	/*
	 * Sets up NPCs in sublab
	 */
	public void setupNPCs() {
		NPC student1 = new NPC(_game, _this, "malestudent", 
			"Student: 'I've been here for 10 hours.'", Constants.NPC1_X, Constants.NPC1_Y, "back");
		NPC student2 = new NPC(_game, _this, "malestudent2", 
			"Student: 'My final project's due in two hours and I just started it.'", Constants.NPC2_X, Constants.NPC2_Y, "back");
		NPC student3 = new NPC(_game, _this, "femalestudent2", 
			"Student: 'At least Barrus and Holley has a café...'", Constants.NPC3_X, Constants.NPC3_Y, "back");
		NPC student4 = new NPC(_game, _this, "femalestudent4", 
			"Student: 'QuickX is down again. Shocker.'", Constants.NPC4_X, Constants.NPC4_Y, "back");
	}
	
	/*
	 * Used after the player battles the pikachu
	 */
	public void removePikachu() {
		_this.getChildren().remove(_pikachu);
		_game.getObjects()[0][Constants.SQUARES_TALL-1] = null;
	}
}