package FinalProject;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/*
 * Creates the Salomon location
 */
public class Salomon {
	
	private Game _game;
	private Pane _this;
	
	public Salomon(Game game, Pane root) {
		if (game.getFrame() == 17) {
			game.setFrame(18);
		}
		_game = game;
		_this = new Pane();
		Rectangle floor = new Rectangle(0, 0, Constants.APP_X, Constants.APP_Y);
		floor.setFill(Color.web("#CD5C5C"));
		Rectangle stage = new Rectangle(0, 0, Constants.APP_X, Constants.STAGE_HEIGHT*1.2);
		stage.setFill(Color.GOLDENROD);
		Rectangle stageShadow = new Rectangle (0,0,Constants.APP_X, Constants.STAGE_HEIGHT*1.5);
		stageShadow.setFill(Color.DARKGOLDENROD);
		_this.getChildren().addAll(floor, stageShadow, stage);
		this.setupNPCs();
		this.setupSilentNPCs();
		root.getChildren().add(_this);
		
		Door door1 = new Door(game, root, _this, "maingreen", 
			3, Constants.SQUARES_TALL);
		Door door2 = new Door(game, root, _this, "maingreen",
			4, Constants.SQUARES_TALL);
		Door door3 = new Door(game, root, _this, "maingreen", 
			22, Constants.SQUARES_TALL);
		Door door4 = new Door(game, root, _this, "maingreen",
			23, Constants.SQUARES_TALL);
	}
	
	/*
	 * Creates NPCs on left and right sides of middle section 
	 */
	public void setupNPCs() {
		NPC student1 = new NPC(_game, _this, "malestudent2", 
			"Student: 'That was a good lecture.'", 150, 210, "back");
		NPC student2 = new NPC(_game, _this, "femalestudent3", 
			"Student: 'I've been waiting 72 hours to meet with a TA.'", 150, 240, "back");
		NPC student3 = new NPC(_game, _this, "malestudent2", 
			"Student: 'Is it true they have beds in the SunLab?'", 150, 270, "back");
		NPC student4 = new NPC(_game, _this, "femalestudent", 
			"Student: 'It's so close to break...'", 150, 300, "back");
		NPC student5 = new NPC(_game, _this, "malestudent4", 
			"Student: 'I've already lined up an internship with Devon.'", 150, 330, "back");
		NPC student6 = new NPC(_game, _this, "femalestudent4", 
			"Student: 'Better start training.'", 150, 360, "back");
		NPC student7 = new NPC(_game, _this, "malestudent", 
			"Student: 'I've always wanted to work for Silph.'", 150, 390, "back");
		NPC student8 = new NPC(_game, _this, "femalestudent2", 
			"Student: 'Is it true that Silph is working on an upgrade to the Pokemon storage system?'", 150, 420, "back");
		NPC student9 = new NPC(_game, _this, "malestudent3", 
			"Student: 'I heard Andy used to be a great Pokemon battler.", 150, 450, "back");
		NPC student10 = new NPC(_game, _this, "malestudent4", 
			"Student: 'How far are you on the final project?'", 150, 480, "back");
		NPC student11 = new NPC(_game, _this, "malestudent", 
			"Student: '...I'm so done right now...'", 150, 510, "back");
		NPC student12 = new NPC(_game, _this, "femalestudent2", 
			"Student: 'Me and Pikachu are so going to win!", 150, 540, "back");
		NPC student13 = new NPC(_game, _this, "malestudent3", 
			"Student: 'Think you'll do well on the final'", 630, 210, "back");
		NPC student14 = new NPC(_game, _this, "malestudent", 
			"Student: 'The Blue Room muffins though...'", 630, 240, "back");
		NPC student15 = new NPC(_game, _this, "femalestudent3", 
			"Student: 'Didn't the ethics TA's just do a presentation on why Silph is immoral?'", 630, 270, "back");
		NPC student16 = new NPC(_game, _this, "malestudent3", 
			"Student: 'Can't believe they haven't used a Squirtle in a water bottle skit yet...'", 630, 300, "back");
		NPC student17 = new NPC(_game, _this, "malestudent", 
			"Student: 'Looking forward to break?'", 630, 330, "back");
		NPC student18 = new NPC(_game, _this, "femalestudent4", 
			"Student: 'No one stands a chance against me and Charizard!'", 630, 360, "back");
		NPC student19 = new NPC(_game, _this, "malestudent", 
			"Student: 'My Ursaring can totally beat up any Cornell Ursaring.'", 630, 390, "back");
		NPC student20 = new NPC(_game, _this, "femalestudent2", 
			"Student: 'I'm sure the Pokemon Rights League will be protesting this...'", 630, 420, "back");
		NPC student21 = new NPC(_game, _this, "malestudent4", 
			"Student: 'Surprised they aren't already...", 630, 450, "back");
		NPC student22 = new NPC(_game, _this, "malestudent2", 
			"Student: 'I heard this is offered every year.'", 630, 480, "back");
		NPC student23 = new NPC(_game, _this, "malestudent3", 
			"Student: 'I'm sure some jerk with a bunch of dragons is gonna sweep the whole thing...'", 630, 510, "back");
		NPC student24 = new NPC(_game, _this, "femalestudent4", 
			"Student: 'Me and Eevee are so going to win!", 630, 540, "back");
		NPC student25 = new NPC(_game, _this, "femalestudent", 
			"Student: 'I just need finals to be done already.'", 630, 570, "back");
		
		NewPokemon team0 = new NewPokemon("Zapdos", 100, _game.getMoveHashMap(), _game.getPokemonHashMap());
 		NewPokemon team1 = new NewPokemon("Moltres", 50, _game.getMoveHashMap(), _game.getPokemonHashMap());
 		NewPokemon team2 = new NewPokemon("Articuno", 50, _game.getMoveHashMap(), _game.getPokemonHashMap());
 		Team[] team = new Team[3];
		team[0] = team0.getPokemon();
		team[1] = team1.getPokemon();
		team[2] = team2.getPokemon();
		TrainerNPC andy = new TrainerNPC(_game, _this, "andy", "Andy: 'A battle? All right.'", 90, 90, "front",
			"Andy: 'That was a good battle!'", team, 3);
	}
	
	/*
	 * Creates NPCs on left and right sections, and in center of middle section
	 */
	public void setupSilentNPCs() {
		for (int i = 0; i < 15; i++ ) {
			for (int j = 0; j < 13; j++) {
				int rand = (int) (Math.random() * 8);
				String type = "malestudent";
				switch(rand) {
					case 0:
						type = "malestudent";
						break;
					case 1:
						type = "femalestudent";
						break;
					case 2:
						type = "malestudent2";
						break;
					case 3:
						type = "femalestudent2";
						break;
					case 4:
						type = "malestudent3";
						break;
					case 5:
						type = "femalestudent3";
						break;
					case 6:
						type = "malestudent4";
						break;
					case 7:
						type = "femalestudent4";
						break;
					default:
						break;
				}
				NPC student = new NPC(_game, _this, type, "Student: '...'", 
					(int) (180+i*Constants.SQUARE_SIDE), (int) (210+j*Constants.SQUARE_SIDE), "back");
			}
		}
		for (int i = 0; i < 3; i++ ) {
			for (int j = 0; j < 13; j++) {
				int rand = (int) (Math.random() * 8);
				String type = "malestudent";
				switch(rand) {
				case 0:
					type = "malestudent";
					break;
				case 1:
					type = "femalestudent";
					break;
				case 2:
					type = "malestudent2";
					break;
				case 3:
					type = "femalestudent2";
					break;
				case 4:
					type = "malestudent3";
					break;
				case 5:
					type = "femalestudent3";
					break;
				case 6:
					type = "malestudent4";
					break;
				case 7:
					type = "femalestudent4";
					break;
				default:
					break;
				}
				NPC student = new NPC(_game, _this, type, "Student: '...'", 
					(int) (i*Constants.SQUARE_SIDE), (int) (210+j*Constants.SQUARE_SIDE), "back");
			}
		}
		for (int i = 0; i < 3; i++ ) {
			for (int j = 0; j < 13; j++) {
				int rand = (int) (Math.random() * 8);
				String type = "malestudent";
				switch(rand) {
				case 0:
					type = "malestudent";
					break;
				case 1:
					type = "femalestudent";
					break;
				case 2:
					type = "malestudent2";
					break;
				case 3:
					type = "femalestudent2";
					break;
				case 4:
					type = "malestudent3";
					break;
				case 5:
					type = "femalestudent3";
					break;
				case 6:
					type = "malestudent4";
					break;
				case 7:
					type = "femalestudent4";
					break;
				default:
					break;
			}
				NPC student = new NPC(_game, _this, type, "Student: '...'", 
					(int) (720+i*Constants.SQUARE_SIDE), (int) (210+j*Constants.SQUARE_SIDE), "back");
			}
		}
	}
}