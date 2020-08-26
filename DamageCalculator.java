package FinalProject;

import java.util.HashMap;

/*
 * Calculates damage taken from one pokemon using a move on another, based on
 * the base power of the attack, the ratio of the attacker's (special)
 * attack to the defender's (special) defense, the weeather, same type attack 
 * bonus, and type advantages
*/

public class DamageCalculator {
	
	private int _damage; 
	
	public DamageCalculator(String attack, HashMap<String, Move> _moves,
		Team attacker, Team defender, String attackerType1, String attackerType2,
		String defenderType1, String defenderType2, String weather) {
		
		double attackV = 1;
		double defenseV = 1;
		
		if (_moves.get(attack).getCategory() == "special") { 
			attackV = attacker.getBattleSpecialAttack();
			defenseV = defender.getBattleSpecialDefense();
		} else {
			attackV = attacker.getBattleAttack();
			defenseV = defender.getBattleDefense();
		}
		
		double sameType = 1;
		if (_moves.get(attack).getType().contains(attackerType1) || _moves.get(attack).getType().contains(attackerType2)) {
			sameType = Constants.SMALL_BOOST;
		}
		
		double weatherBoost = 1;
		if ((weather == "rain" && _moves.get(attack).getType() == "Water") || 
			(weather == "sun" && _moves.get(attack).getType() == "Fire")) {
			weatherBoost = Constants.SMALL_BOOST;
		} else if ((weather == "rain" && _moves.get(attack).getType() == "Fire") || 
			(weather == "sun" && _moves.get(attack).getType() == "Water")) {
			weatherBoost = Constants.SMALL_LOSS;
		}
		
		double type1 = this.typeEffectiveness(_moves.get(attack).getType(), defenderType1); 
		double type2 = 1;
		if (defenderType2 != "") {
			type2 = this.typeEffectiveness(_moves.get(attack).getType(), defenderType2);
		}
		
		/*
		 * The below formula is modified from the official damage calculator formula
		 * used in pokemon games
		 */
		_damage = (int) (3*(((((2/5*attacker.getLevel()+2)*_moves.get(attack).getPower()*attackV/defenseV)/50+2) 
			* sameType * weatherBoost * type1 * type2))); 
		if (_moves.get(attack).getCategory().contains("status")) { 
			_damage = 0;
		}
	}
	
	/*
	 * Returns amount of damage
	 */
	public int getDamage() {
		return _damage;
	}
	
	/*
	 * Calculates type effectiveness based on move type and defender's type
	 */
	private double typeEffectiveness(String attack, String defend) {
		double effectiveness = 1;
		switch (attack) {
			case "Normal":
				switch (defend) {
				case "Rock":
					effectiveness = Constants.SMALL_LOSS;
					break;
				case "Ghost":
					effectiveness = 0;
					break;
				case "Steel":
					effectiveness = Constants.SMALL_LOSS;
					break;
				default:
					break;
				}
				break;
			case "Fighting":
				switch (defend) {
				case "Normal":
					effectiveness = Constants.BIG_BOOST;
					break;
				case "Flying":
					effectiveness = Constants.SMALL_LOSS;
					break;
				case "Poison":
					effectiveness = Constants.SMALL_LOSS;
					break;
				case "Rock":
					effectiveness = Constants.BIG_BOOST;
					break;
				case "Bug":
					effectiveness = Constants.SMALL_LOSS;	
					break;
				case "Ghost":
					effectiveness = 0;
					break;
				case "Steel":
					effectiveness = Constants.BIG_BOOST;
					break;
				case "Psychic":
					effectiveness = Constants.SMALL_LOSS;
					break;
				case "Ice":
					effectiveness = Constants.BIG_BOOST;
					break;
				case "Dark":
					effectiveness = Constants.BIG_BOOST;
					break;
				case "Fairy":
					effectiveness = Constants.SMALL_LOSS;
					break;
				default:
					break;
				}
				break;
			case "Flying":
				switch (defend) {
				case "Fighing":
					effectiveness = Constants.BIG_BOOST;
					break;
				case "Rock":
					effectiveness = Constants.SMALL_LOSS;	
					break;
				case "Bug":
					effectiveness = Constants.BIG_BOOST;	
					break;
				case "Steel":
					effectiveness = Constants.SMALL_LOSS;
					break;
				case "Grass":
					effectiveness = Constants.BIG_BOOST;	
					break;
				case "Electric":
					effectiveness = Constants.SMALL_LOSS;
					break;
				default:
					break;
				}
				break;
			case "Poison":
				switch (defend) {
				case "Poison":
					effectiveness = Constants.SMALL_LOSS;
					break;
				case "Ground":
					effectiveness = Constants.SMALL_LOSS;	
					break;
				case "Rock":
					effectiveness = Constants.SMALL_LOSS;
					break;
				case "Ghost":
					effectiveness = Constants.SMALL_LOSS;
					break;
				case "Steel":
					effectiveness = 0;
					break;
				case "Grass":
					effectiveness = Constants.BIG_BOOST;	
					break;
				case "Fairy":
					effectiveness = Constants.BIG_BOOST;
					break;
				default:
					break;
				}
				break;
			case "Ground":
				switch (defend) {
				case "Flying":
					effectiveness = 0;
					break;
				case "Poison":
					effectiveness = Constants.BIG_BOOST;
					break;
				case "Rock":
					effectiveness = Constants.BIG_BOOST;	
					break;
				case "Bug":
					effectiveness = Constants.SMALL_LOSS;	
					break;
				case "Steel":
					effectiveness = Constants.BIG_BOOST;
					break;
				case "Fire":
					effectiveness = Constants.BIG_BOOST;	
					break;
				case "Grass":
					effectiveness = Constants.SMALL_LOSS;
					break;
				case "Electric":
					effectiveness = Constants.BIG_BOOST;
					break;
				default:
					break;
				}	
				break;
			case "Rock":
				switch (defend) {
				case "Fighing":
					effectiveness = Constants.SMALL_LOSS;
					break;
				case "Flying":
					effectiveness = Constants.BIG_BOOST;
					break;
				case "Ground":
					effectiveness = Constants.SMALL_LOSS;	
					break;
				case "Bug":
					effectiveness = Constants.BIG_BOOST;
					break;
				case "Stee)l":
					effectiveness = Constants.SMALL_LOSS;	
					break;
				case "Fire":
					effectiveness = Constants.BIG_BOOST;
					break;
				case "Ice":
					effectiveness = Constants.BIG_BOOST;
					break;
				default:
					break;
				}
				break;
			case "Bug":
				switch (defend) {
				case "Fighing":
					effectiveness = 5;
					break;
				case "Flying":
					effectiveness = Constants.SMALL_LOSS;	
					break;
				case "Poison":
					effectiveness = Constants.SMALL_LOSS;
					break;
				case "Ghost":
					effectiveness = Constants.SMALL_LOSS;	
					break;
				case "Steel":
					effectiveness = Constants.SMALL_LOSS;
					break;
				case "Fire":
					effectiveness = Constants.SMALL_LOSS;
					break;
				case "Grass":
					effectiveness = Constants.BIG_BOOST;	
					break;
				case "Psychic":
					effectiveness = Constants.BIG_BOOST;
					break;
				case "Dark":
					effectiveness = Constants.BIG_BOOST;
					break;
				case "Fairy":
					effectiveness = Constants.SMALL_LOSS;
					break;
				default:
					break;
				}
				break;
			case "Ghost":
				switch (defend) {
				case "Normal":
					effectiveness = 0;
					break;
				case "Ghost":
					effectiveness = Constants.BIG_BOOST;	
					break;
				case "Psychic":
					effectiveness = Constants.BIG_BOOST;
					break;
				case "Dark":
					effectiveness = Constants.SMALL_LOSS;	
					break;
				default:
					break;
				}
				break;
			case "Steel":
				switch (defend) {
				case "Rock":
					effectiveness = Constants.BIG_BOOST;
					break;
				case "Steel":
					effectiveness = Constants.SMALL_LOSS;	
					break;
				case "Fire":
					effectiveness = Constants.SMALL_LOSS;
					break;
				case "Water":
					effectiveness = Constants.SMALL_LOSS;	
					break;
				case "Electric":
					effectiveness = Constants.SMALL_LOSS;	
					break;
				case "Ice":
					effectiveness = Constants.BIG_BOOST;
					break;
				case "Fairy":
					effectiveness = Constants.BIG_BOOST;
					break;
				default:
					break;
				}	
				break;
			case "Fire":
				switch (defend) {
				case "Rock":
					effectiveness = Constants.SMALL_LOSS;
					break;
				case "Bug":
					effectiveness = Constants.BIG_BOOST;
					break;
				case "Steel":
					effectiveness = Constants.BIG_BOOST;
					break;
				case "Fire":
					effectiveness = Constants.SMALL_LOSS;
					break;
				case "Water":
					effectiveness = Constants.SMALL_LOSS;	
					break;
				case "Grass":
					effectiveness = Constants.BIG_BOOST;	
					break;
				case "Ice":
					effectiveness = Constants.BIG_BOOST;	
					break;
				case "Dragon":
					effectiveness = Constants.SMALL_LOSS;	
					break;
				default:
					break;
				}	
				break;
			case "Water":
				switch (defend) {
				case "Ground":
					effectiveness = Constants.BIG_BOOST;
					break;
				case "Rock":
					effectiveness = Constants.BIG_BOOST;	
					break;
				case "Fire":
					effectiveness = Constants.BIG_BOOST;
					break;
				case "Water":
					effectiveness = Constants.SMALL_LOSS;
					break;
				case "Grass":
					effectiveness = Constants.SMALL_LOSS;
					break;
				case "Dragon":
					effectiveness = Constants.SMALL_LOSS;
					break;
				default:
					break;
				}
				break;
			case "Grass":
				switch (defend) {
				case "Flying":
					effectiveness = Constants.SMALL_LOSS;	
					break;
				case "Poison":
					effectiveness = Constants.SMALL_LOSS;	
					break;
				case "Ground":
					effectiveness = Constants.BIG_BOOST;
					break;
				case "Rock":
					effectiveness = Constants.BIG_BOOST;
					break;
				case "Bug":
					effectiveness = Constants.SMALL_LOSS;	
					break;
				case "Steel":
					effectiveness = Constants.SMALL_LOSS;
					break;
				case "Fire":
					effectiveness = Constants.SMALL_LOSS;
					break;
				case "Water":
					effectiveness = Constants.BIG_BOOST;
					break;
				case "Grass":
					effectiveness = Constants.SMALL_LOSS;
					break;
				case "Dragon":
					effectiveness = Constants.SMALL_LOSS;
					break;
				default:
					break;
				}	
				break;
			case "Electric":
				switch (defend) {
				case "Flying":
					effectiveness = Constants.BIG_BOOST;
					break;
				case "Ground":
					effectiveness = 0;
					break;
				case "Water":
					effectiveness = Constants.BIG_BOOST;
					break;	
				case "Grass":
					effectiveness = Constants.SMALL_LOSS;
					break;
				case "Electric":
					effectiveness = Constants.SMALL_LOSS;	
					break;
				case "Dragon":
					effectiveness = Constants.SMALL_LOSS;	
					break;
				default:
					break;
				}
				break;
			case "Psychic":
				switch (defend) {
				case "Fighing":
					effectiveness = Constants.BIG_BOOST;
					break;
				case "Poison":
					effectiveness = Constants.BIG_BOOST;
					break;
				case "Steel":
					effectiveness = Constants.SMALL_LOSS;	
					break;
				case "Psychic":
					effectiveness = Constants.SMALL_LOSS;	
					break;
				case "Dark":
					effectiveness = 0;
					break;
				default:
					break;
				}	
				break;
			case "Ice":
				switch (defend) {
				case "Flying":
					effectiveness = Constants.BIG_BOOST;
					break;
				case "Ground":
					effectiveness = Constants.BIG_BOOST;
					break;
				case "Steel":
					effectiveness = Constants.SMALL_LOSS;	
					break;
				case "Fire":
					effectiveness = Constants.SMALL_LOSS;
					break;
				case "Water":
					effectiveness = Constants.SMALL_LOSS;
					break;
				case "Grass":
					effectiveness = Constants.BIG_BOOST;
					break;
				case "Ice":
					effectiveness = Constants.SMALL_LOSS;	
					break;
				case "Dragon":
					effectiveness = Constants.BIG_BOOST;
					break;
				default:
					break;
				}
				break;
			case "Dragon":
				switch (defend) {
				case "Steel":
					effectiveness = Constants.SMALL_LOSS;
					break;
				case "Dragon":
					effectiveness = Constants.BIG_BOOST;
					break;
				case "Fairy":
					effectiveness = 0;
					break;
				default:
					break;
				}	
				break;
			case "Dark":
				switch (defend) {
				case "Fighing":
					effectiveness = Constants.SMALL_LOSS;
					break;
				case "Ghost":
					effectiveness = Constants.BIG_BOOST;
					break;
				case "Psychic":
					effectiveness = Constants.BIG_BOOST;	
					break;
				case "Dark":
					effectiveness = Constants.SMALL_LOSS;
					break;
				case "Fairy":
					effectiveness = Constants.SMALL_LOSS;
					break;
				default:
					break;
				}
				break;
			case "Fairy":
				switch (defend) {
				case "Fighing":
					effectiveness = Constants.BIG_BOOST;
					break;
				case "Poison":
					effectiveness = Constants.SMALL_LOSS;	
					break;
				case "Steel":
					effectiveness = Constants.SMALL_LOSS;
					break;
				case "Fire":
					effectiveness = Constants.SMALL_LOSS;	
					break;
				case "Dragon":
					effectiveness = Constants.BIG_BOOST;
					break;
				case "Dark":
					effectiveness = Constants.BIG_BOOST;
					break;
				default:
					break;
				}
				break;
			default:
				break;
		}
		return effectiveness;
	}
	
}