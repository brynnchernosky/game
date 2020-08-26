package FinalProject;

import java.util.HashMap;

/*
 * Creates one team member -- a specific iteration of a pokemon
 * derived from the outline supplied by pokemon. 
 */

public class Team {
	private String _name;
	private String _nickname;
	private String _move1; 
	private String _move2; 
	private String _move3; 
	private String _move4; 
	private String _condition;
	private int _level;
	private int _hp;
	private int _attack;
	private int _defense;
	private int _specialAttack;
	private int _specialDefense;
	private int _speed;
	private int _battleHP;
	private int _battleAttack;
	private int _battleDefense;
	private int _battleSpecialAttack;
	private int _battleSpecialDefense;
	private HashMap<String, Pokemon> _pokemon;
	
	public Team(String name, int level, int hp, int attack, 
		int specialAttack, int defense, int specialDefense, int speed,
		String move1, String move2, String move3, String move4,
		HashMap<String, Pokemon> pokemon) {
		_name = name;
		_nickname = name;
		_move1 = move1;
		_move2 = move2;
		_move3 = move3;
		_move4 = move4;
		_level = level;
		_hp = hp;
		_battleHP = hp;
		_attack = attack;
		_battleAttack = attack;
		_defense = defense;
		_battleDefense = defense;
		_specialAttack = specialAttack;
		_battleSpecialAttack = specialAttack;
		_specialDefense = specialDefense;
		_battleSpecialDefense = specialDefense;
		_speed = speed;
		_pokemon = pokemon;
	} 
	
	/*
	 * Resets battle stats except for HP when battle ends
	 */
	public void endBattle() {
		_battleAttack = _attack;
		_battleDefense = _defense;
		_battleSpecialAttack = _specialAttack;
		_battleSpecialDefense = _specialDefense;
	}
	
	/*
	 * Resets HP when at health center
	 */
	public void healthCenter() {
		_battleHP = _hp;
	}
	
	/*
	 * Levels up by incrementing level and appropriately increasing stats
	 */
	public void levelUp() {
		_level++;
		_attack = _attack + (int) (.02*_pokemon.get(_name).getAttack());
		_defense = _defense + (int) (.02*_pokemon.get(_name).getDefense());
		_specialAttack = _specialAttack + (int) (.02*_pokemon.get(_name).getSpecialAttack());
		_specialDefense = _specialDefense + (int) (.02*_pokemon.get(_name).getSpecialDefense());
		_speed = _speed + (int) (.02*_pokemon.get(_name).getSpeed());
		_hp = _attack + (int) (.02*_pokemon.get(_name).getHP());
	}

	/*
	 * Getter and setter methods called by Battle, BattleChoices
	 */
	public String getName() {
		return _name;
	}
	public String getNickname() {
		return _nickname;
	}
	public void setNickname(String string) {
		_nickname = string;
	}
	public String getMove1() {
		return _move1;
	}
	public void setMove1(String string) {
		_move1 = string;
	}
	public String getMove2() {
		return _move2;
	}
	public void setMove2(String string) {
		_move2 = string;
	}
	public String getMove3() {
		return _move3;
	}
	public void setMove3(String string) {
		_move3 = string;
	}
	public String getMove4() {
		return _move4;
	}
	public void setMove4(String string) {
		_move4 = string;
	}
	public String getCondition() {
		return _condition;
	}
	public void setCondition(String string) {
		_condition = string;
	}
	public int getLevel() {
		return _level;
	}
	public void setLevel(int i) {
		_level = i;
	}
	public int getHP() {
		return _hp;
	}
	public void setHP(int i) {
		_hp = i;
	}
	public int getAttack() {
		return _attack;
	}
	public void setAttack(int i) {
		_attack = i;
	}
	public int getDefense() {
		return _defense;
	}
	public void setDefense(int i) {
		_defense = i;
	}
	public int getSpecialAttack() {
		return _specialAttack;
	}
	public void setSpecialAttack(int i) {
		_specialAttack = i;
	}
	public int getSpecialDefense() {
		return _specialDefense;
	}
	public void setSpecialDefense(int i) {
		_specialDefense = i;
	}
	public int getSpeed() {
		return _speed;
	}
	public void setSpeed(int i) {
		_speed = i;
	}
	public int getBattleHP() {
		return _battleHP;
	}
	public void setBattleHP(int i) {
		_battleHP = i;
	}
	public int getBattleAttack() {
		return _battleAttack;
	}
	public void setBattleAttack(int i) {
		_battleAttack = i;
	}
	public int getBattleDefense() {
		return _battleDefense;
	}
	public void setBattleDefense(int i) {
		_battleDefense = i;
	}
	public int getBattleSpecialAttack() {
		return _battleSpecialAttack;
	}
	public void setBattleSpecialAttack(int i) {
		_battleSpecialAttack = i;
	}
	public int getBattleSpecialDefense() {
		return _battleSpecialDefense;
	}
	public void setBattleSpecialDefense(int i) {
		_battleSpecialDefense = i;
	}
}