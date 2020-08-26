package FinalProject;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/*
 * Class that creates the Game and start Screen with button to start game
 */

public class PaneOrganizer {
	private Pane _root;
	private Pane _gamePane;
	
	public PaneOrganizer() {
		_root = new Pane();
		_gamePane = new Pane();
		
		Pane startPane = new Pane();
		Button startButton = this.createStartButton();
		startButton.setLayoutX(Constants.START_X);
		startButton.setLayoutY(Constants.START_Y);
		_root.getChildren().addAll(startPane, startButton);
		this.setupStartScreen(this, _root);
	}
	
	/*
	 * Creates button that starts the game when clicked
	 */
	private Button createStartButton() {
		Button button = new Button("Start");
		button.setFocusTraversable(false);
		button.setBackground(null);
		button.setFont(new Font("Lucida Sans Typewriter Bold", 40));
		button.setOnAction(new StartHandler());
		return button;
	}
	
	/*
	 * Main pane cleared and game instantiated when start button clicked 
	 */
	private class StartHandler implements EventHandler<ActionEvent> {
		@Override
		public void handle(ActionEvent e)  {
			_root.getChildren().clear();
			_root.getChildren().add(_gamePane);
			Game game = new Game(_gamePane);
		}
	}
	
	/*
	 * Creates pikachu and poke ball design on start screen
	 */
	public void setupStartScreen(PaneOrganizer organizer, Pane root) {
		ImageView pikachu = new ImageView("file:./FinalProject/PokemonSprites/PikachuStart.png");
		pikachu.setScaleX(1.5);
		pikachu.setScaleY(1.5);
		pikachu.setX(190);
		pikachu.setY(100);
		root.getChildren().addAll(pikachu, this.createBall());
	}
	
	/*
	 * Creates poke ball seen on start screen
	 */
	private Pane createBall() {
		Pane root = new Pane();
		//Creates white base of ball
		Circle ball = new Circle(Constants.BALL_X, Constants.BALL_Y, Constants.BALL_RAD);
		ball.setFill(Color.WHITE);

		//Creates red half of ball
		Arc redPart = new Arc(Constants.BALL_X, Constants.BALL_Y, Constants.BALL_RAD,
				Constants.BALL_RAD, 0, Constants.BALL_LENGTH);
		redPart.setFill(Color.RED);

		//Creates black line separating red and white halves
		Line line = new Line(Constants.BALL_X-Constants.BALL_RAD+3, Constants.BALL_Y+3,
				Constants.BALL_X+Constants.BALL_RAD-3, Constants.BALL_Y+3);
		line.setStrokeWidth(Constants.BALL_STROKE);

		//Creates white circle in center of ball
		Circle circle = new Circle(Constants.BALL_X, Constants.BALL_Y+2, Constants.CIRCLE_RAD);
		circle.setFill(Color.WHITE);
		circle.setStroke(Color.BLACK);
		circle.setStrokeWidth(Constants.BALL_STROKE/2);

		//Combines all parts of ball
		root.getChildren().addAll(ball, redPart, line, circle);
		root.setScaleX(Constants.BALL_SCALE);
		root.setScaleY(Constants.BALL_SCALE);
		root.setLayoutX(Constants.BALL_X2);
		root.setLayoutY(Constants.BALL_Y2);
		return root;
	}
	
	/*
	 * Getter method called by App
	 */
	public Pane getRoot() {
		return _root;
	}
}