package FinalProject;

import java.util.HashMap;

/*
 * Sets up one of the major data structures in the game, the HashMap mapping
 * the name of a move to that move.
 */

public class MoveHashMap{
	private HashMap<String, Move> _move;
	public MoveHashMap() {
		_move = new HashMap<String, Move>();
		this.setupHashMap();
	}
	
	/*
	 * Getter method called by Game
	 */
	public HashMap<String, Move> getHashMap() {
		return _move;
	}
	
	private void setupHashMap() {
		// power, accuracy, pp, type, category, effect
		_move.put("Absorb", new Move(20, 100, 25, "Grass", "special", "raiseHP"));
		_move.put("Acid", new Move(40, 100, 30, "Poison", "special", ""));
		_move.put("Aerial Ace", new Move(60, 100, 20, "Flying", "physical", ""));
		_move.put("Air Cutter", new Move(60, 95, 25, "Flying", "special", ""));
		_move.put("Air Slash", new Move(75, 95, 15, "Flying", "special", ""));
		_move.put("Aqua Tail", new Move(90, 10, 90, "Water", "physical", ""));
		_move.put("Assurance", new Move(60, 100, 10, "Dark", "physical", ""));
		_move.put("Astonish", new Move(30, 100, 15, "Ghost", "physical", ""));
		_move.put("Aura Sphere", new Move(80, 20, 100, "Fighting", "special", ""));
		_move.put("Bite", new Move(60, 100, 25, "Dark", "physical", ""));
		_move.put("Blast Burn", new Move(150, 90, 5, "Fire", "special", ""));
		_move.put("Body Slam", new Move(85, 100, 15, "Normal", "physical", ""));
		_move.put("Brave Bird", new Move(120, 100, 15, "Flying", "physical", ""));
		_move.put("Bubble", new Move(40, 100, 30, "Water", "special", ""));
		_move.put("Bubble Beam", new Move(65, 100, 20, "Water", "special", ""));
		_move.put("Bug Bite", new Move(60, 100, 20, "Bug", "physical", ""));
		_move.put("Bulldoze", new Move(60, 100, 20, "Ground", "physical", ""));
		_move.put("Calm Mind", new Move(0, 100, 15, "Psychic", "status", "raiseSpecialStats"));
		_move.put("Charm", new Move(0, 100, 20, "Fairy", "status", "lowersAttack"));
		_move.put("Close Combat", new Move(120, 100, 5, "Fighting", "physical", ""));
		_move.put("Confusion", new Move(50, 100, 25, "Psychic", "special", ""));
		_move.put("Crunch", new Move(80, 100, 15, "Dark", "physical", ""));
		_move.put("Dark Pulse", new Move(80, 100, 15, "Dark", "special", ""));
		_move.put("Dazzling Gleam", new Move(80, 100, 10, "Fairy", "special", ""));
		_move.put("Disarming Voice", new Move(40, 100, 15, "Fairy", "special", ""));
		_move.put("Discharge", new Move(80, 100, 15, "Electric", "special", ""));
		_move.put("Draco Meteor", new Move(130, 90, 5, "Dragon", "special", ""));
		_move.put("Dragon Claw", new Move(80, 100, 15, "Dragon", "physical", ""));
		_move.put("Dragon Pulse", new Move(85, 100, 10, "Dragon", "special", ""));
		_move.put("Dragon Rush", new Move(100, 75, 10, "Dragon", "physical", ""));
		_move.put("Draining Kiss", new Move(50, 100, 10, "Fairy", "special", "raisesHP"));
		_move.put("Earth Power", new Move(90, 100, 10, "Ground", "special", ""));
		_move.put("Earthquake", new Move(100, 100, 10, "Ground", "physical", ""));
		_move.put("Ember", new Move(40, 100, 25, "Fire", "special", ""));
		_move.put("Eruption", new Move(150, 100, 5, "Fire", "special", ""));
		_move.put("Extrasensory", new Move(80, 100, 20, "Psychic", "special", ""));
		_move.put("Feint Attack", new Move(60, 100, 20, "Dark", "physical", ""));
		_move.put("Fire Fang", new Move(65, 95, 15, "Fire", "physical", ""));
		_move.put("Flame Wheel", new Move(60, 100, 25, "Fire", "physical", ""));
		_move.put("Flamethrower", new Move(90, 100, 15, "Fire", "special", ""));
		_move.put("Flare Blitz", new Move(120, 100, 15, "Fire", "physical", ""));
		_move.put("Flash Cannon", new Move(80, 100, 10, "Steel", "special", ""));
		_move.put("Giga Drain", new Move(75, 100, 10, "Grass", "special", "raisesHP"));
		_move.put("Growl", new Move(0, 100, 40, "Normal", "status", "lowerAttack"));
		_move.put("Gust", new Move(40, 100, 35, "Flying", "special", ""));
		_move.put("Hurricane", new Move(110, 70, 10, "Flying", "special", ""));
		_move.put("Hydro Pump", new Move(110, 80, 5, "Water", "special", ""));
		_move.put("Ice Beam", new Move(90, 100, 10, "Ice", "special", ""));
		_move.put("Ice Fang", new Move(65, 95, 15, "Ice", "physical", ""));
		_move.put("Iron Tail", new Move(100, 75, 15, "Steel", "physical", ""));
		_move.put("Leaf Storm", new Move(130, 90, 5, "Grass", "special", ""));
		_move.put("Light Screen", new Move(0, 100, 20, "Psychic", "status", "raisesSpecialDefense"));
		_move.put("Mega Drain", new Move(40, 100, 15, "Grass", "special", "raisesHP"));
		_move.put("Metal Claw", new Move(50, 95, 35, "Steel", "physical", ""));
		_move.put("Moonblast", new Move(95, 100, 15, "Fairy", "special", ""));
		_move.put("Night Slash", new Move(70, 100, 15, "Dark", "physical", ""));
		_move.put("Ominous Wind", new Move(60, 100, 5, "Ghost", "special", ""));
		_move.put("Peck", new Move(50, 100, 35, "Flying", "physical", ""));
		_move.put("Petal Blizzard", new Move(90, 100, 15, "Grass", "physical", ""));
		_move.put("Play Rough", new Move(90, 90, 10, "Fairy", "physical", ""));
		_move.put("Poison Jab", new Move(80, 100, 20, "Posion", "physical", ""));
		_move.put("Psybeam", new Move(65, 100, 20, "Psychic", "special", ""));
		_move.put("Psychic", new Move(90, 100, 10, "Psychic", "special", ""));
		_move.put("Quick Attack", new Move(40, 100, 30, "Normal", "physical", ""));
		_move.put("Rain Dance", new Move(0, 100, 5, "Water", "status", "rain"));
		_move.put("Razor Leaf", new Move(55, 95, 25, "Grass", "physical", ""));
		_move.put("Reflect", new Move(0, 100, 20, "Psychic", "status", "raisesDefense"));
		_move.put("Scratch", new Move(40, 100, 35, "Normal", "physical", ""));
		_move.put("Shadow Ball", new Move(80, 100, 25, "Ghost", "special", ""));
		_move.put("Skull Bash", new Move(130, 100, 10, "Normal", "physical", ""));
		_move.put("Sky Attack", new Move(140, 90, 5, "Flying", "physical", ""));
		_move.put("Slash", new Move(70, 100, 20, "Normal", "physical", ""));
		_move.put("Spark", new Move(65, 100, 20, "Electric", "physical", ""));
		_move.put("Sunny Day", new Move(0, 100, 5, "Fire", "status", "sun"));
		_move.put("Superpower", new Move(120, 100, 5, "Fighting", "physical", ""));
		_move.put("Surf", new Move(90, 100, 15, "Water", "special", ""));
		_move.put("Tackle", new Move(40, 100, 35, "Normal", "physical", ""));
		_move.put("Tail Whip", new Move(0, 100, 35, "Normal", "status", "lowersDefense"));
		_move.put("Thunder Shock", new Move(40, 100, 30, "Electric", "special", ""));
		_move.put("Vine Whip", new Move(45, 100, 25, "Grass", "physical", ""));
		_move.put("Water Gun", new Move(40, 100, 25, "Water", "special", ""));
		_move.put("Waterfall", new Move(80, 100, 15, "Water", "physical", ""));
		_move.put("Wing Attack", new Move(60, 100, 35, "Flying", "physical", ""));
		_move.put("Withdraw", new Move(0, 100, 40, "Water", "status", "raisesDefense"));
		
		
	}
}