package FinalProject;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

/*
 * Controls the cut scene where the player creates their ID card
 */

public class CharacterMaker{
	
	private TextField _name;
	private ImageView _pictureRed;
	private ImageView _pictureLeaf;
	private ImageView _pictureEthan;
	private ImageView _pictureLyra;
	private ImageView _pictureLucas;
	private ImageView _pictureDawn;
	
	private Game _game;
	private Pane _this;
	private Pane _root;
	private int _pictureNumber;
	
	public CharacterMaker(Pane root, Game game) {
		_game = game;
		_root = root;
		_this = new Pane();
		_pictureNumber = 0;
		
		ImageView logo = new ImageView("file:./FinalProject/brownLogo.png");
		logo.setX(Constants.LOGO_X);
		logo.setY(Constants.LOGO_Y);
		logo.setFitWidth(Constants.LOGO_LENGTH);
		logo.setFitHeight(Constants.LOGO_HEIGHT);
		
		Rectangle rectangle = new Rectangle(Constants.ID_X, Constants.ID_Y, Constants.ID_LENGTH, Constants.ID_HEIGHT);
		rectangle.setFill(Color.WHITE);
		rectangle.setArcWidth(Constants.ROUND_CORNERS);
		rectangle.setArcHeight(Constants.ROUND_CORNERS);
		
		_name = new TextField("Red");
		_name.setPrefHeight(Constants.NAME_HEIGHT);
		_name.setPrefWidth(Constants.NAME_LENGTH);
		_name.setLayoutX(Constants.NAME_X);
		_name.setLayoutY(Constants.NAME_Y);
		
		_pictureRed = this.createPicture("file:./FinalProject/HumanSprites/RedPicture.png");
		_game.setPlayer("red");
		
		_pictureLeaf = this.createPicture("file:./FinalProject/HumanSprites/LeafPicture.png");
		_pictureLeaf.setVisible(false);
		
		_pictureEthan = this.createPicture("file:./FinalProject/HumanSprites/EthanPicture.png");
		_pictureEthan.setVisible(false);
		
		_pictureLyra = this.createPicture("file:./FinalProject/HumanSprites/LyraPicture.png");
		_pictureLyra.setVisible(false);
		
		_pictureLucas = this.createPicture("file:./FinalProject/HumanSprites/LucasPicture.png");
		_pictureLucas.setVisible(false);
		
		_pictureDawn = this.createPicture("file:./FinalProject/HumanSprites/DawnPicture.png");
		_pictureDawn.setVisible(false);
		
		Rectangle pictureBackground = new Rectangle(Constants.PICTURE_X, Constants.PICTURE_Y, Constants.PICTURE_LENGTH, Constants.PICTURE_HEIGHT);
		pictureBackground.setFill(Color.WHITE);
		pictureBackground.setStroke(Color.BLACK);
		pictureBackground.addEventHandler(MouseEvent.MOUSE_CLICKED, new PictureHandler());
		
		Button continueButton = new Button("Continue");
		continueButton.setLayoutX(Constants.CONTINUE_X);
		continueButton.setLayoutY(Constants.CONTINUE_Y); 
		continueButton.setFont(new Font("Lucida Sans Typewriter Bold", 25));
		continueButton.setOnAction(new ContinueHandler());
		
		Text instructions = new Text("Type your first name in the box, and click on the picture to change it.");
		instructions.setWrappingWidth(Constants.DIALOGUE_LENGTH);
		instructions.setFont(new Font("Lucida Sans Typewriter Bold", 20));
		instructions.setLayoutX(Constants.DIALOGUE_X);
		instructions.setLayoutY(Constants.INSTRUCTIONS_Y);
		
		_this.getChildren().addAll(instructions, rectangle, logo, _name, pictureBackground, _pictureRed, _pictureLeaf,
			_pictureEthan, _pictureLyra, _pictureLucas, _pictureDawn, continueButton);
		root.getChildren().add(_this);
	}

	/*
	 * Creates image of player character that changes when clicked
	 */
	private ImageView createPicture(String image) {
		ImageView picture = new ImageView(image);
		picture.setX(Constants.PICTURE_X);
		picture.setY(Constants.PICTURE_Y);
		picture.setFitWidth(Constants.PICTURE_LENGTH);
		picture.setFitHeight(Constants.PICTURE_HEIGHT);
		picture.setFocusTraversable(true);
		picture.addEventHandler(MouseEvent.MOUSE_CLICKED, new PictureHandler());
		return picture;
	}
	
	/*
	 * Effectively causes image to change when clicked; this method of setting
	 * ImageViews visible/not visible was used as changing the ImageFiew file 
	 * did not work properly
	 */
	private class PictureHandler implements EventHandler<MouseEvent> {
		@Override
		public void handle(MouseEvent event) {
			switch (_pictureNumber) { 
			case 0:
				_pictureRed.setVisible(false);
				_pictureLeaf.setVisible(true);
				_game.setPlayer("leaf");
				break;
			case 1:
				_pictureLeaf.setVisible(false);
				_pictureEthan.setVisible(true);
				_game.setPlayer("ethan"); 
				break;
			case 2:
				_pictureEthan.setVisible(false);
				_pictureLyra.setVisible(true);
				_game.setPlayer("lyra"); 
				break;
			case 3:
				_pictureLyra.setVisible(false);
				_pictureLucas.setVisible(true);
				_game.setPlayer("lucas"); 
				break;
			case 4:
				_pictureLucas.setVisible(false);
				_pictureDawn.setVisible(true);
				_game.setPlayer("dawn"); 
				break;
			case 5:
				_pictureDawn.setVisible(false);
				_pictureRed.setVisible(true);
				_game.setPlayer("red"); 
				break;
			default:
				break;
			}
			_pictureNumber++;
			if (_pictureNumber > 5) {
				_pictureNumber = 0;
			}
		}
	}
	
	/*
	 * When player clicks continue, name is set and cutscene ends
	 */
	private class ContinueHandler implements EventHandler<ActionEvent> {
		@Override
		public void handle(ActionEvent event) {
			_game.setName(_name.getText());
			_game.setFrame(2);
			_root.getChildren().remove(_this);
		}
	}
}