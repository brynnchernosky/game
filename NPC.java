package FinalProject;

import java.util.Hashtable;

/*
 * Creates a human or pokemon the player can interact with. Superclass
 * of TrainerNPC.
 */

import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class NPC implements Interactable {
	
	private ImageView _left;
	private ImageView _right;
	private ImageView _front;
	private ImageView _back;
	private Game _game;
	private Hashtable<NPC, String> _npcHashtable;
	private Pane _root;
	private Boolean _nurse;
	private String _dialogue;
	
	public NPC(Game game, Pane root, String type, String dialogue, int x, int y, String view) {
		_game = game;
		_root = root;
		_npcHashtable = new Hashtable<NPC, String>();
		_nurse = false;
		
		/*
		 * Sprite is dependent on which string is entered as the NPC's 'type'
		 */
		switch (type) {
		case "malestudent":
			_left = new ImageView("file:./FinalProject/HumanSprites/StudentMaleLeft.png");
			_right = new ImageView("file:./FinalProject/HumanSprites/StudentMaleRight.png");
			_front = new ImageView("file:./FinalProject/HumanSprites/StudentMaleFront.png");
			_back = new ImageView("file:./FinalProject/HumanSprites/StudentMaleBack.png");
			break;
		case "femalestudent":
			_left = new ImageView("file:./FinalProject/HumanSprites/StudentFemaleLeft.png");
			_right = new ImageView("file:./FinalProject/HumanSprites/StudentFemaleRight.png");
			_front = new ImageView("file:./FinalProject/HumanSprites/StudentFemaleFront.png");
			_back = new ImageView("file:./FinalProject/HumanSprites/StudentFemaleBack.png");
			break;
		case "malestudent2":
			_left = new ImageView("file:./FinalProject/HumanSprites/StudentMaleLeft2.png");
			_right = new ImageView("file:./FinalProject/HumanSprites/StudentMaleRight2.png");
			_front = new ImageView("file:./FinalProject/HumanSprites/StudentMaleFront2.png");
			_back = new ImageView("file:./FinalProject/HumanSprites/StudentMaleBack2.png");
			break;
		case "femalestudent2":
			_left = new ImageView("file:./FinalProject/HumanSprites/StudentFemaleLeft2.png");
			_right = new ImageView("file:./FinalProject/HumanSprites/StudentFemaleRight2.png");
			_front = new ImageView("file:./FinalProject/HumanSprites/StudentFemaleFront2.png");
			_back = new ImageView("file:./FinalProject/HumanSprites/StudentFemaleBack2.png");
			break;
		case "malestudent3":
			_left = new ImageView("file:./FinalProject/HumanSprites/StudentMaleLeft3.png");
			_right = new ImageView("file:./FinalProject/HumanSprites/StudentMaleRight3.png");
			_front = new ImageView("file:./FinalProject/HumanSprites/StudentMaleFront3.png");
			_back = new ImageView("file:./FinalProject/HumanSprites/StudentMaleBack3.png");
			break;
		case "femalestudent3":
			_left = new ImageView("file:./FinalProject/HumanSprites/StudentFemaleLeft3.png");
			_right = new ImageView("file:./FinalProject/HumanSprites/StudentFemaleRight3.png");
			_front = new ImageView("file:./FinalProject/HumanSprites/StudentFemaleFront3.png");
			_back = new ImageView("file:./FinalProject/HumanSprites/StudentFemaleBack3.png");
			break;
		case "malestudent4":
			_left = new ImageView("file:./FinalProject/HumanSprites/StudentMaleLeft4.png");
			_right = new ImageView("file:./FinalProject/HumanSprites/StudentMaleRight4.png");
			_front = new ImageView("file:./FinalProject/HumanSprites/StudentMaleFront4.png");
			_back = new ImageView("file:./FinalProject/HumanSprites/StudentMaleBack4.png");
			break;
		case "femalestudent4":
			_left = new ImageView("file:./FinalProject/HumanSprites/StudentFemaleLeft4.png");
			_right = new ImageView("file:./FinalProject/HumanSprites/StudentFemaleRight4.png");
			_front = new ImageView("file:./FinalProject/HumanSprites/StudentFemaleFront4.png");
			_back = new ImageView("file:./FinalProject/HumanSprites/StudentFemaleBack4.png");
			break;
		case "femaleformal":
			_left = new ImageView("file:./FinalProject/HumanSprites/FormalFemaleLeft.png");
			_right = new ImageView("file:./FinalProject/HumanSprites/FormalFemaleRight.png");
			_front = new ImageView("file:./FinalProject/HumanSprites/FormalFemaleFront.png");
			_back = new ImageView("file:./FinalProject/HumanSprites/FormalFemaleBack.png");
			break;
		case "nurse":
			_left = new ImageView("file:./FinalProject/HumanSprites/StudentFemaleLeft.png");
			_right = new ImageView("file:./FinalProject/HumanSprites/StudentFemaleRight.png");
			_front = new ImageView("file:./FinalProject/HumanSprites/StudentFemaleFront.png");
			_back = new ImageView("file:./FinalProject/HumanSprites/StudentFemaleBack.png");
			_nurse = true;
			break;
		case "andy":
			_left = new ImageView("file:./FinalProject/HumanSprites/AndyLeft.png");
			_right = new ImageView("file:./FinalProject/HumanSprites/AndyRight.png");
			_front = new ImageView("file:./FinalProject/HumanSprites/AndyFront.png");
			_back = new ImageView("file:./FinalProject/HumanSprites/AndyBack.png");
			break;
			
		case "eevee":
			_left = new ImageView("file:./FinalProject/PokemonSprites/EeveeLeftOverworld.png");
			_right = new ImageView("file:./FinalProject/PokemonSprites/EeveeRightOverworld.png");
			_front = new ImageView("file:./FinalProject/PokemonSprites/EeveeFrontOverworld.png");
			_back = new ImageView("file:./FinalProject/PokemonSprites/EeveeBackOverworld.png");
			break;
		case "espeon":
			_left = new ImageView("file:./FinalProject/PokemonSprites/EspeonLeftOverworld.png");
			_right = new ImageView("file:./FinalProject/PokemonSprites/EspeonRightOverworld.png");
			_front = new ImageView("file:./FinalProject/PokemonSprites/EspeonFrontOverworld.png");
			_back = new ImageView("file:./FinalProject/PokemonSprites/EspeonBackOverworld.png");
			break;
		case "umbreon":
			_left = new ImageView("file:./FinalProject/PokemonSprites/UmbreonLeftOverworld.png");
			_right = new ImageView("file:./FinalProject/PokemonSprites/UmbreonRightOverworld.png");
			_front = new ImageView("file:./FinalProject/PokemonSprites/UmbreonFrontOverworld.png");
			_back = new ImageView("file:./FinalProject/PokemonSprites/UmbreonBackOverworld.png");
			break;
			
		default:
			break;
		}
		
		this.setSprite(_left, x, y);
		this.setSprite(_right, x, y);
		this.setSprite(_front, x, y);
		this.setSprite(_back, x, y);
		
		/*
		 * Changes the view of the NPC when they are interacted with from a direction different fro the one they are facing
		 */
		switch (view) {
		case "front":
			_front.setVisible(true);
			break;
		case "back":
			_back.setVisible(true);
			break;
		case "left":
			_left.setVisible(true);
			break;
		case "right":
			_right.setVisible(true);
			break;
		default:
			break;
		}
		
		/*
		 * If the NPC is a nurse, the interactable square is moved down the screen one because
		 * of the counter in the pokemon center separating the nurse from the player
		 */
		game.getObjects()[(int) (x/Constants.SQUARE_SIDE)][(int) (y/Constants.SQUARE_SIDE)] = this;
		if (_nurse) {
			game.getInteractable()[(int) (x/Constants.SQUARE_SIDE)][(int) (y/Constants.SQUARE_SIDE)+1] = this;
		} else {
			game.getInteractable()[(int) (x/Constants.SQUARE_SIDE)][(int) (y/Constants.SQUARE_SIDE)] = this;
		}
		
		_dialogue = dialogue;
		
		root.getChildren().addAll(_front, _left, _right, _back);
	}
	
	/*
	 * Sets sprite location
	 */
	private void setSprite(ImageView view, int x, int y) {
		view.setX(x);
		view.setY(y);
		view.setVisible(false);
	}
	
	/*
	 * When interacted with, changes to face direction player is 
	 * facing and dialogue box is displayed; if nurse is interacted
	 * with, player's team is healed
	 */
	public void whenInteracted() {
		Pane dialoguePane = new Pane();
		_game.setPaused(true);
		_game.setNPCDialogue(true);
		_game.setDialogue(dialoguePane, _dialogue);
		_root.getChildren().add(dialoguePane);
		this.setNotVisible();
		if (_game.getPlayer().getX() < _left.getX()) {
			_left.setVisible(true);
		} else if (_game.getPlayer().getX() > _left.getX()) {
			_right.setVisible(true);
		} else if (_game.getPlayer().getY() < _left.getY()) {
			_back.setVisible(true);
		} else {
			_front.setVisible(true);
		}
		if (_nurse) {
			for (int i = 0; i < _game.getPlayerTeamInts().size() ; i++) {
				_game.getTeamHashMap().get(i).healthCenter();
			}
		}
	}
 	 
	/*
	 * Sets all sprites not visible for NPC
	 */
	private void setNotVisible() {
		_left.setVisible(false);
		_right.setVisible(false);
		_front.setVisible(false);
		_back.setVisible(false);
	}
	
	/*
	 * Setter method used by TrainerNPC to change dialogue after battle
	 */
	public void setDialogue(String d) {
		_dialogue = d;
	}
}