package FinalProject;

import java.util.HashMap;
import java.util.Hashtable;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

/*
 * A subclass of NPC, TrainerNPC's will battle the main character after
 * being interacted with
 */
public class TrainerNPC extends NPC  {
	
	private String _dialogue2;
	private Team[] _team;
	private Game _game;
	private Pane _root;
	private Boolean _battled;
	private Timeline _timeline;
	private int _delay;
	private int _experience;
	
	public TrainerNPC(Game game, Pane root, String type, String dialogue, 
		int x, int y, String view, String dialogue2, Team[] team, 
		int experience) {
		super(game, root, type, dialogue, x, y, view);
		_dialogue2 = dialogue2; //dialogue after battle is over
		_game = game;
		_root = root;
		_team = team;
		_battled = false;
		_experience = experience;
	}
	
	/*
	 * If NPC has not been interacted with, trigger dialogue then battle. Otherwise,
	 * trigger second dialogue.
	 */
	public void whenInteracted() {
		super.whenInteracted();
		
		if (_battled == false) {
			this.setupTimeline();
			
		}
	}
	
	/*
	 * Sets up the timeline
	 */
	private void setupTimeline(){
		KeyFrame kf = new KeyFrame(Duration.seconds(Constants.DURATION), new TimeHandler());
		_timeline = new Timeline(kf);
		_timeline.setCycleCount(Animation.INDEFINITE);
		_timeline.play();
	}
	/*
	 * Dialogue is briefly displayed, then battle begins
	 */
	private class TimeHandler implements EventHandler<ActionEvent> {
		@Override
		public void handle(ActionEvent event) {
			_delay++;
			switch(_delay) {
			case 5:
				HashMap<Integer, Team> h = new HashMap<Integer, Team>();
				int[] teamNumbers = new int[_team.length];
				for (int i = 0; i < _team.length; i++) {
					h.put(i, _team[i]);
					teamNumbers[i] = i; 
				}
				Battle b = new Battle(_game, _root, "green", true, _experience, h, teamNumbers);
				TrainerNPC.this.setDialogue(_dialogue2);
				_battled = true;
				_delay = 0;
				_timeline.stop();
				break;
			default:
				break;
			}
			
		}
	}
}