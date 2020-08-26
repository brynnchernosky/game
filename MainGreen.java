package FinalProject;

import java.util.HashMap;

import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/*
 * Creates the MainGreen location and its associated building, doors, grass, and NPCs.
 * NOTE: The pokemart (blue) building is inaccessible due to lack of time to program
 * the pokemart. 
 */
public class MainGreen {
	
	private Game _game;
	private Pane _this;
	
	public MainGreen(Game game, Pane root) {
		if (game.getFrame() == 15) {
			game.setFrame(16);
		}
		_game = game;
		_this = new Pane();
		Rectangle pavement= new Rectangle(0, 0, Constants.APP_X, Constants.APP_Y);
		pavement.setFill(Color.GRAY);
		ImageView pokeMart = new ImageView ("file:./FinalProject/ObjectSprites/PokeMartOutside.png");
		pokeMart.setScaleX(Constants.MART_SCALE);
		pokeMart.setScaleY(Constants.MART_SCALE);
		pokeMart.setY(Constants.MART_Y);
		pokeMart.setX(Constants.MART_X);
		ImageView pokemonCenter = new ImageView ("file:./FinalProject/ObjectSprites/PokemonCenterOutside.png");
		pokemonCenter.setScaleX(Constants.CENTER_SCALE);
		pokemonCenter.setScaleY(Constants.CENTER_SCALE);
		pokemonCenter.setX(Constants.CENTEROUT_X);
		pokemonCenter.setY(Constants.CENTEROUT_Y);
		Rectangle salomon = new Rectangle(Constants.SALOMONOUT_X,
			Constants.SALOMONOUT_Y, Constants.SALOMON_WIDTH, Constants.SALOMON_HEIGHT);
		salomon.setFill(Color.BROWN);
		Rectangle salomonDoor = new Rectangle (Constants.DOOR_X, 
			Constants.DOOR_Y, Constants.DOOR_WIDTH, Constants.DOOR_HEIGHT); 
		salomonDoor.setFill(Color.BLACK);
		_this.getChildren().addAll(pavement, pokeMart, pokemonCenter, salomon, salomonDoor);
		this.setupGrass();
		root.getChildren().add(_this);
		for (int i = 0; i < 11; i++) {
			for (int j = 0; j < 3; j++) {
				game.getObjects()[i][j]=pokeMart;
			}
		}
		for (int i = 22; i < 27; i++) {
			for (int j = 2; j < 9; j++) {
				game.getObjects()[i][j]= salomon; 
			}
		}
		Door centerDoor = new Door(game, root, _this, "center", 
			Constants.CENTERDOOR_I, Constants.CENTERDOOR_J);
		Door salDoor = new Door(game, root, _this, "salomon", Constants.DOOR_I,
			Constants.DOOR_J);
		
		this.setupNPCs();
	}
	
	/*
	 * Sets up all of the NPCs and TrainerNPCs on the main green
	 */
	public void setupNPCs() {
		
 		TrainerNPC ryan = new TrainerNPC(_game, _this, "malestudent2", 
 			"Ryan: 'You know what they say—karpi diem!'", 360, 30, "right", 
 			"Ryan: 'Why would you hurt Karpi like that?! And Karpi 2?! And Karpi 3-?!'", 
 			this.createStandardTeamOf3("Magikarp", "Seadra", "Gyarados"), 1);
 		
 		TrainerNPC rebecca = new TrainerNPC(_game, _this, "femalestudent3", 
 			"Rebecca: 'Vee doesn't battle, but the rest of my friends will fight you!'", 
 			360, 60, "right", "Rebecca: 'Oh no!'",
 			this.createStandardTeamOf3("Vaporeon", "Jolteon", "Flareon"), 1);
 		
 		NPC eevee = new NPC(_game, _this, "eevee", "Eevee: ...", 360, 90, "right");
		
 		TrainerNPC kate = new TrainerNPC(_game, _this, "femalestudent", 
 			"Kate: 'Howdy.'", 390, 0, "front", "Kate: 'Oof...'", 
 			this.createStandardTeamOf3("Ampharos", "Vaporeon", "Typhlosion"), 3);
 		
 		TrainerNPC ilana = new TrainerNPC(_game, _this, "femaleformal", 
 			"Ilana: 'Can there ever really be a victor?'", 420, 0, "front", 
 			"Ilana: 'Do you really feel like a winner though? You just beat up a baby penguin...'", 
			this.createStandardTeamOf3("Milotic", "Glaceon", "Piplup"), 1);
 	
 		TrainerNPC jessica = new TrainerNPC(_game, _this, "femalestudent",
 			"Jessica: 'Why are you talking to me?'", 450, 0, "front",
 			"Jessica: 'Well, that wasn't a complete waste of time.'",
 			this.createStandardTeamOf3("Luxray", "Persian", "Houndoom"), 1);
 		
 		NPC espeon = new NPC(_game, _this, "espeon", "Espeon: ...", 480, 30, "left");
 		
 		TrainerNPC brynn = new TrainerNPC(_game, _this, "femalestudent2", 
			"Brynn: 'Hm, I don't think you're ready to battle me just yet, but if "
			+ "you really want to...'", 480, 60, "left",
			"Brynn: 'Good job!'", this.createBrynnTeam(), 3);
		NPC umbreon = new NPC(_game, _this, "umbreon", "Umbreon: ...", 480, 90, "left");
		
 		TrainerNPC ashley = new TrainerNPC(_game, _this, "femalestudent", 
 			"Ashley: 'Ready?'", 570, 30, "right", "Ashley: 'Darn...'", 
 			this.createStandardTeamOf3("Rotom", "Absol", "Arcanine"), 3);
 		
 		TrainerNPC rafe = new TrainerNPC(_game, _this, "malestudent2", 
 			"Rafe: 'Ready?'", 600, 30, "left", "Rafe: 'Darn...'", 
 			this.createStandardTeamOf3("Growlithe", "Cubchoo", "Beartic"), 1);

 		TrainerNPC robin = new TrainerNPC(_game, _this, "femaleformal", 
 			"Robin: 'You want to battle? Okay!'", 540, 120, "right",
 			"Robin: 'That was fun!'",
 			this.createStandardTeamOf3("Altaria", "Swanna", "Kingdra"), 1);
 		
 		TrainerNPC renee = new TrainerNPC(_game, _this, "femalestudent4", "Renee: 'This will be fun!'", 
 			570, 120, "left", "Renee: 'Was not expecting that, but okay.'", 
 			this.createStandardTeamOf3("Pidgeotto", "Braviary", "Charizard"), 1);
	
 		TrainerNPC jacob = new TrainerNPC(_game, _this, "malestudent", 
 	 		"Jacob: 'Ready?'", 600, 210, "right", "Jacob: 'Darn...'", 
 	 		this.createStandardTeamOf3("Teddiursa", "Ursaring", "Metagross"), 1);
 		
 		TrainerNPC chloe = new TrainerNPC(_game, _this, "femalestudent4", 
 	 	 	 "Chloe: 'Ready?'", 600, 240, "right", "Chloe: 'Darn...'", 
 	 	 	 this.createStandardTeamOf3("Wartortle", "Flaaffy", "Lapras"), 1);
 		
 		TrainerNPC alex = new TrainerNPC(_game, _this, "malestudent4", 
 	 	 	  "Alex: 'Ready?'", 600, 270, "right", "Chloe: 'Darn...'", 
 	 	 	  this.createStandardTeamOf3("Gible", "Larvitar", "Dratini"), 1);
 		
 		TrainerNPC anya = new TrainerNPC(_game, _this, "femalestudent2", 
 	 	 	 "Anya: 'Ready?'", 660, 330, "left", "Anya: 'Darn...'", 
 	 	 	 this.createStandardTeamOf3("Charmander", "Bulbasaur", "Squirtle"), 1);
 		 
 		TrainerNPC teddy = new TrainerNPC(_game, _this, "malestudent2", 
 	 	 	"Teddy: 'Ready?'", 660, 360, "left", "Teddy: 'Darn...'", 
 	 	 	this.createStandardTeamOf3("Chimchar", "Turtwig", "Piplup"), 1);
 		
 		TrainerNPC sam = new TrainerNPC(_game, _this, "malestudent", 
 	 	 	"Sam: 'Ready?'", 660, 390, "left", "Sam: 'Darn...'", 
 	 	 	this.createStandardTeamOf3("Cyndaquil", "Chikorita", "Totodile"), 1);	
 		
 		//used for testing minmax algorithm
 		Team[] bugTeam = new Team[1];
 		bugTeam[0] = new Team("Pidgey", 50, 100, 100, 100, 100, 100, 100,
 				"Tackle", "Peck", "Growl", "Tail Whip",
 				_game.getPokemonHashMap());
 		TrainerNPC bug = new TrainerNPC(_game, _this, "malestudent4", 
 	 	 	 "Ben: 'Ready?'", 660, 450, "left", "Ben: 'Darn...'", 
 	 	 	bugTeam, 3);	
	}
	
	/*
	 * Creates TrainerNPC Brynn's pokemon team
	 */
	private Team[] createBrynnTeam() {
		NewPokemon brynn1 = new NewPokemon("Espeon", 75, _game.getMoveHashMap(), _game.getPokemonHashMap());
 		NewPokemon brynn2 = new NewPokemon("Umbreon", 75, _game.getMoveHashMap(), _game.getPokemonHashMap());
 		NewPokemon brynn3 = new NewPokemon("Altaria", 75, _game.getMoveHashMap(), _game.getPokemonHashMap());
 		NewPokemon brynn4 = new NewPokemon("Dragonair", 75, _game.getMoveHashMap(), _game.getPokemonHashMap());
 		NewPokemon brynn5 = new NewPokemon("Tyranitar", 75, _game.getMoveHashMap(), _game.getPokemonHashMap());
 		NewPokemon brynn6 = new NewPokemon("Charizard", 75, _game.getMoveHashMap(), _game.getPokemonHashMap());
 		Team[] team = new Team[6];
		team[0] = brynn1.getPokemon();
		team[1] = brynn2.getPokemon();
		team[2] = brynn3.getPokemon();
		team[3] = brynn4.getPokemon();
		team[4] = brynn5.getPokemon();
		team[5] = brynn6.getPokemon();
		return team;
	}
	
	/*
	 * Creates a team of three pokemon, all at level 50
	 */
	private Team[] createStandardTeamOf3(String name1, String name2, String name3) {
		NewPokemon team0 = new NewPokemon(name1, 50, _game.getMoveHashMap(), _game.getPokemonHashMap());
 		NewPokemon team1 = new NewPokemon(name2, 50, _game.getMoveHashMap(), _game.getPokemonHashMap());
 		NewPokemon team2 = new NewPokemon(name3, 50, _game.getMoveHashMap(), _game.getPokemonHashMap());
 		Team[] team = new Team[3];
		team[0] = team0.getPokemon();
		team[1] = team1.getPokemon();
		team[2] = team2.getPokemon();
		return team;
	}
	
	/*
	 * Sets up grass; i's a j's not put in constants class because 
	 * they would be very difficult to understand outside of context.
	 * Effectively, four rectangles filled with grass instances are
	 * created using four different collections of nested for loops. 
	 */
	private void setupGrass() {
		for (int i = 0; i < 13; i++) {
			for (int j = 0; j < 13; j++) {
				Grass grass = new Grass(_game, _this, 210+i*Constants.SQUARE_SIDE,
					180+j*Constants.SQUARE_SIDE, "maingreen");
				if (j == 12 || j == 0 || i == 0 || i == 12) {
					_game.getInteractable()[(int) ((210+i*Constants.SQUARE_SIDE)/Constants.SQUARE_SIDE)]
						[(int) ((180+j*Constants.SQUARE_SIDE)/Constants.SQUARE_SIDE)] = null;
				}
			}
		}
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 13; j++) {
				Grass grass = new Grass(_game, _this, i*Constants.SQUARE_SIDE,
					180+j*Constants.SQUARE_SIDE, "maingreen");
				if (j == 12 || j == 0 || i == 3) {
					_game.getInteractable()[(int) ((i*Constants.SQUARE_SIDE)/Constants.SQUARE_SIDE)]
						[(int) ((180+j*Constants.SQUARE_SIDE)/Constants.SQUARE_SIDE)] = null;
				}
			}
		}
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 8; j++) {
				Grass grass = new Grass(_game, _this, 690+i*Constants.SQUARE_SIDE,
					330+j*Constants.SQUARE_SIDE, "maingreen");
				if (j == 7 || j == 0 || i == 0) {
					_game.getInteractable()[(int) ((690+i*Constants.SQUARE_SIDE)/Constants.SQUARE_SIDE)]
							[(int) ((330+j*Constants.SQUARE_SIDE)/Constants.SQUARE_SIDE)] = null;
				}
			}
		}
		
		for (int i = 0; i < 27; i++) {
			for (int j = 0; j < 5; j++) {
				Grass grass = new Grass(_game, _this, i*Constants.SQUARE_SIDE,
					630+j*Constants.SQUARE_SIDE, "maingreen");
			}
		}
		
	}
}