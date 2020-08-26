package FinalProject;

/*
 * Creates a new move when given the appropriate arguments; has getter methods
 * for use in the BattleChoices and DamageCalculator classes.
 */

public class Move {
	private int _power;
	private int _accuracy;
	private int _pp;
	private String _type;
	private String _category;
	private String _effect;
	
	public Move(int power, int accuracy, int pp, String type, String category, String effect) {
		_power = power;
		_accuracy = accuracy;
		_pp = pp;
		_type = type;
		_category = category;
		_effect = effect;
	} 
	
	/*
	 * Getter methods used in BattleChoices and DamageCalculator
	 */
	public int getPower() {
		return _power;
	}
	public int getAccuracy() {
		return _accuracy;
	}
	public int getPP() { //used in team class
		return _pp;
	}
	public String getType() {
		return _type;
	}
	public String getCategory() {
		return _category;
	}
	public String getEffect() {
		return _effect;
	}
	
}