package FinalProject;

import java.util.HashMap;

/*
 * Creates a new team by being given the name of a pokemon, 
 * calculating its stats using the level and that pokemon's stats in
 * the pokemon hash map, and generating moves for it from the six moves
 * in the pokemon hash map for that pokemon
 */

public class NewPokemon {
	
	private Team _pokemon;
	private Pokemon _thisPokemon;
	
	public NewPokemon(String pokemon, int level, 
		HashMap<String, Move> moves, HashMap<String, Pokemon> pokemonList) {
		int multiplier = (int) (1 + level*2/100);
		_thisPokemon = pokemonList.get(pokemon);
		
		/*
		 * this block of code in conjunction with the assignMove method
		 * randomly selects 4 unique moves for the pokemon of 6 it could know
		 */
		int rand1 = (int) (Math.random()*6);
		int rand2 = (int) (Math.random()*6);
		while (rand2 == rand1) {
			rand2 = (int) (Math.random()*6);
		}
		int rand3 = (int) (Math.random()*6);
		while (rand3 == rand1 || rand3 == rand2) {
			rand3 = (int) (Math.random()*6);
		}
		int rand4 = (int) (Math.random()*6);
		while (rand4 == rand1 || rand4 == rand2 || rand4 == rand3) {
			rand4 = (int) (Math.random()*6);
		}
		
		_pokemon = new Team(pokemon, level, (int) (_thisPokemon.getHP()*multiplier),
				(int) (_thisPokemon.getAttack()*multiplier), (int) (_thisPokemon.getSpecialAttack()*multiplier),
				(int) (_thisPokemon.getDefense()*multiplier), (int) (_thisPokemon.getSpecialDefense()*multiplier),
				(int) (_thisPokemon.getSpeed()*multiplier), assignMove(rand1), assignMove(rand2),
				assignMove(rand3), assignMove(rand4), pokemonList);
	}
	
	/*
	 * Used to generate moves for pokemon
	 */
	public String assignMove(int i) {
		String move = "";
		switch(i) {
		case 0:
			move = _thisPokemon.getMove1();
			break;
		case 1:
			move = _thisPokemon.getMove2();
			break;
		case 2:
			move = _thisPokemon.getMove3();
			break;
		case 3:
			move = _thisPokemon.getMove4();
			break;
		case 4:
			move = _thisPokemon.getMove5();
			break;
		case 5:
			move = _thisPokemon.getMove6();
			break;
		default:
			break;
		}
		return move;
	}
	
	/*
	 * Used to get the team created by this method
	 */
	public Team getPokemon() {
		return _pokemon;
	}
}