package FinalProject;

import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

/*
 * Creates a dialogue box with specified text, that goes away when the screen
 * is clicked
 */
public class Dialogue {
	
	private Pane _dialogueBox;
	private Pane _root;
	
	public Dialogue(Pane root, String string) {
		_dialogueBox = new Pane();
		
		Rectangle box = new Rectangle(Constants.DIALOGUE_BOX_X, Constants.DIALOGUE_BOX_Y, Constants.DIALOGUE_BOX_LENGTH, Constants.DIALOGUE_BOX_HEIGHT);
		box.setFill(Color.WHITE);
		Text dialogue = new Text(string);
		dialogue.setFont(Constants.DIALOGUE_FONT);
		dialogue.setWrappingWidth(Constants.DIALOGUE_LENGTH);
		dialogue.setLayoutX(Constants.DIALOGUE_X);
		dialogue.setLayoutY(Constants.DIALOGUE_Y);
		
		_dialogueBox.getChildren().addAll(box, dialogue);
		root.getChildren().add(_dialogueBox);
		
		_root = root;
	}
	
	/*
	 * Removes dialogue, called when screen is clicked and dialogue is present
	 */
	public void removeDialogue() {
		_root.getChildren().remove(_dialogueBox);
	}
}