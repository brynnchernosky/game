package FinalProject;

import java.util.HashMap;

import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

/*
 * Creates grass on the main green. When the player goes on the 
 * grass, there is a chance of a wild pokemon battle starting.
 */
public class Grass implements Interactable {
	private String _area;
	private Game _game;
	private Pane _root;
	
	public Grass(Game game, Pane root, int x, int y, String area) {
		ImageView grass = this.newGrass(x, y);
		if (x/Constants.SQUARE_SIDE < Constants.SQUARES_WIDE && y/Constants.SQUARE_SIDE < Constants.SQUARES_TALL) {
			game.getInteractable()[(int) (x/Constants.SQUARE_SIDE)][(int) (y/Constants.SQUARE_SIDE)] = this;
		}
		ImageView grass2 = this.newGrass(x-Constants.GRASS_OFFSET, y-Constants.GRASS_OFFSET);
		ImageView grass3 = this.newGrass(x, y-Constants.GRASS_OFFSET);
		ImageView grass4 = this.newGrass(x-Constants.GRASS_OFFSET, y);
		root.getChildren().addAll(grass, grass2, grass3, grass4);
		_area = area;
		_game = game;
		_root = root;
	}
	
	/*
	 * Creates patches of grass that are then layered on top of each other
	 */
	private ImageView newGrass(double x, double y) {
		ImageView grass = new ImageView("file:./FinalProject/ObjectSprites/Grass.png");
		grass.setFitHeight(Constants.GRASS_X);
		grass.setFitWidth(Constants.SQUARE_SIDE);
		grass.setX(x);
		grass.setY(y);
		return grass;
	}
	
	/*
	 * Uses random number generation to determine if a wild
	 * pokemon battle should occur, and if so, which pokemon 
	 * will be fought.
	 */
	public void whenInteracted() {
		int random = (int) (Math.random() * 5);
		if (random == 0 && _game.getBattle() == false) {
			switch(_area) {
			case "maingreen":
				_game.setBattle(true);
				int rand = (int) (Math.random() * 5);
				switch(rand) {
				case 0:
					this.generateMainGreenBattle("Pidgey");
					break;
				case 1:
					this.generateMainGreenBattle("Eevee");
					break;
				case 2:
					this.generateMainGreenBattle("Pachirisu");
					break;
				case 3:
					this.generateMainGreenBattle("Teddiursa");
					break;
				case 4:
					this.generateMainGreenBattle("Meowth");
					break;
				}
				break;
			default:
				break;
			}
 		}
	}
	
	/*
	 * Generates wild pokemon battle
	 */
	private void generateMainGreenBattle(String name) {
		HashMap<Integer, Team> h = new HashMap<Integer, Team>();
		NewPokemon w = new NewPokemon(name, 25, _game.getMoveHashMap(), _game.getPokemonHashMap());
		h.put(0, w.getPokemon());
		int[] teamNumbers = new int[1];
		teamNumbers[0] = 0;
		Battle b = new Battle(_game, _root, "green", false, 0, h, teamNumbers);
	}
}