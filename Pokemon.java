package FinalProject;

import javafx.scene.image.ImageView;

/*
 * Class that has variables for the sprites, typing, base stats, and possible moves of a pokemon
 */

public class Pokemon {
	private ImageView _spriteBack;
	private ImageView _spriteFront;
	private String _type1;
	private String _type2;
	private int _hp;
	private int _attack;
	private int _specialAttack;
	private int _defense;
	private int _specialDefense;
	private int _speed;
	private int _evolveLevel;
	private String _evolution;
	private String _move1;
	private String _move2;
	private String _move3;
	private String _move4;
	private String _move5;
	private String _move6;
	
	public Pokemon(String front, String back, String t1, String t2,
		int hp, int attack, int specialAttack, int defense, int specialDefense, int speed,
		String move1, String move2, String move3, String move4, String move5, String move6,
		int level, String pokemon) {
		_spriteBack = new ImageView(back);
		_spriteFront = new ImageView(front);
		_type1 = t1;
		_type2 = t2;
		_hp = hp;
		_attack = attack;
		_specialAttack = specialAttack;
		_defense = defense;
		_specialDefense = specialDefense;
		_speed = speed;
		_evolveLevel = level;
		_evolution = pokemon;
		_move1 = move1;
		_move2 = move2;
		_move3 = move3;
		_move4 = move4;
		_move5 = move5;
		_move6 = move6;
	} 
	
	/*
	 * Getter methods used by NewPokemon, Battle
	 */
	public ImageView getBack() {
		return _spriteBack;
	}
	public ImageView getFront() {
		return _spriteFront;
	}
	public String getType1() {
		return _type1;
	}
	public String getType2() {
		return _type2;
	}
	public int getHP() {
		return _hp;
	}
	public int getAttack() {
		return _attack;
	}
	public int getSpecialAttack() {
		return _specialAttack;
	}
	public int getDefense() {
		return _defense;
	}
	public int getSpecialDefense() {
		return _specialDefense;
	}
	public int getSpeed() {
		return _speed;
	}
	public int getEvolveLevel() {
		return _evolveLevel;
	}
	public String getEvolution() {
		return _evolution;
	}
	public String getMove1() {
		return _move1;
	}
	public String getMove2() {
		return _move2;
	}
	public String getMove3() {
		return _move3;
	}
	public String getMove4() {
		return _move4;
	}
	public String getMove5() {
		return _move5;
	}
	public String getMove6() {
		return _move6;
	}
	
}