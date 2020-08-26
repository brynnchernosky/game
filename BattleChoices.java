package FinalProject;

import java.util.ArrayList;
import java.util.LinkedList;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

/*
 * Handles the battle flow and computer opponent choices
 */

public class BattleChoices {
	private Battle _battle;
	private int _experience;
	private int _move;
	private Game _game;
	private int _priority; //if positive, player goes first; if negative, opponent goes first
	private Boolean _useMove;
	private String _opponentMove;
	private Dialogue _dialogue;
	private ArrayList<String> _opponentMoves; //decide 2 moves at a time with choose move method for intelligence 3
	private Team _fakePlayer; //used for choose move method for intelligence 3
	private Team _fakeOpponent;
	private String _secondMove1; 
	private String _secondMove2;
	private String _secondMove3;
	private String _secondMove4;
	private String _weather; 
	
	public BattleChoices(int experience, Battle battle, Game game) {
		_experience = experience;
		_battle = battle;
		_move = 0;
		_game = game;
		_priority = 0; 
		_opponentMoves = new ArrayList<String>(); 
		_battle.getRoot().addEventHandler(MouseEvent.MOUSE_CLICKED, new MouseHandler());
		_weather = "";
		this.setupTimeline();
	}
	
	/*
	 * Sets up continuous time handler to control flow of battle
	 */
	private void setupTimeline(){
		KeyFrame kf = new KeyFrame(Duration.seconds(Constants.DURATION), new TimeHandler());
		Timeline timeline = new Timeline(kf);
		timeline.setCycleCount(Animation.INDEFINITE);
		timeline.play();
	}
	private class TimeHandler implements EventHandler<ActionEvent> {
		@Override
		public void handle(ActionEvent event) {
			switch (_move) {
				case 0: //current round has ended
					_battle.addMenu();
					break;
				case 1: //player has just made decision
					_battle.removeMenu();
					if (_battle.getMoveUsed() != null && _battle.getMoveUsed() != "") { 
						_useMove = true;
						if (_game.getMoveHashMap().get(_battle.getMoveUsed()).getEffect().contains("priority")) {
							_priority++;
						}
					} else {
						_priority++;
						_priority++;
					}
					
					switch (_experience) { //opponent decision based on experience argument
						case 0: //random move selected
							int random = (int) (Math.random() * 4);
							switch (random) {
							case 0:
								_opponentMove = _battle.getOpponentTeamHashMap().get(_battle.getOpponentIn()).getMove1();
								break;
							case 1:
								_opponentMove = _battle.getOpponentTeamHashMap().get(_battle.getOpponentIn()).getMove2();
								break;
							case 2:
								_opponentMove = _battle.getOpponentTeamHashMap().get(_battle.getOpponentIn()).getMove3();
								break;
							case 3:
								_opponentMove = _battle.getOpponentTeamHashMap().get(_battle.getOpponentIn()).getMove4();
								break;
							default:
								break;
							}
							break;
						case 1: //use move that will cause most damage
							_opponentMove = BattleChoices.this.getBestMove(_battle.getOpponentTeamHashMap().get(_battle.getOpponentIn()),
									_game.getTeamHashMap().get(_battle.getPlayerIn())); 
							break;
						case 3: //use move that minimizes damage taken next turn and causes most damage next turn
							if (_opponentMoves.isEmpty()) {
								BattleChoices.this.getIntelligentBestMove();
							} 
							_opponentMove = _opponentMoves.get(0);
							_opponentMoves.remove(0);
							break;
						default:
							break;
					}
					if (_opponentMove == "Quick Attack") {
						_priority++; //checks if move should go first
					}
					_move++;
					break;
				case 2: //determine who goes first based on speed stats and move priority
					if (_battle.getOpponentTeamHashMap().get(_battle.getOpponentIn()).getSpeed() < 
						_game.getTeamHashMap().get(_battle.getPlayerIn()).getSpeed()) {
						_priority++;
					} else {
						_priority--;
					}
					
					if (_priority >= 0) { //player first
						if (_battle.getMoveUsed() != null) {
							BattleChoices.this.playerUseMove();
						} else {
							switch(_battle.getPlayerAction()) {
							case "switched pokemon":
								for (int i = 0; i < _game.getPlayerTeamInts().size(); i ++) {
									_battle.updatePlayerPicture(i, _battle.getPlayerIn());
								}
								_battle.updateHP();
								_battle.updateInfo();
								_dialogue = new Dialogue (_battle.getRoot(), _game.getName() + " " +
										_battle.getPlayerAction() + "!");
								break;
							case "used a potion":
								int prevHP = _game.getTeamHashMap().get(_battle.getPlayerIn()).getBattleHP();
								_game.getTeamHashMap().get(_battle.getPlayerIn()).setBattleHP(prevHP + 20);
								_dialogue = new Dialogue (_battle.getRoot(), _game.getName() + " " +
										_battle.getPlayerAction() + "!");
								break;
							case "used a super potion":
								int previousHP = _game.getTeamHashMap().get(_battle.getPlayerIn()).getBattleHP();
								_game.getTeamHashMap().get(_battle.getPlayerIn()).setBattleHP(previousHP + 50);
								_dialogue = new Dialogue (_battle.getRoot(), _game.getName() + " " +
										_battle.getPlayerAction() + "!");
								break;
							case "used a hyper potion":
								int originalHP = _game.getTeamHashMap().get(_battle.getPlayerIn()).getBattleHP();
								_game.getTeamHashMap().get(_battle.getPlayerIn()).setBattleHP(originalHP + 200);
								_dialogue = new Dialogue (_battle.getRoot(), _game.getName() + " " +
										_battle.getPlayerAction() + "!");
								break;
							case "used a poke ball":
								int hpRatio = (_battle.getOpponentTeamHashMap().get(0).getBattleHP()) /
									_battle.getOpponentTeamHashMap().get(0).getHP();
								double random = Math.random();
								if (hpRatio < random) {
									_dialogue = new Dialogue(_battle.getRoot(), _game.getName() + " " +
									"threw a Poke Ball, and caught the wild " + _battle.getOpponentTeamHashMap().get(0).getName() 
									+ "!");
									_game.getTeamHashMap().put(_game.getPlayerTeamInts().size(), _battle.getOpponentTeamHashMap().get(0));
									_game.getPlayerTeamInts().add(_game.getPlayerTeamInts().size());
									_move = 11;
								} else {
									_dialogue = new Dialogue(_battle.getRoot(), _game.getName() + " " +
									"threw a Poke Ball, but it failed.");
								}
							default:
								break;
							}
						}
					} else { //opponent first
						BattleChoices.this.opponentUseMove();
					}
					_battle.updateHP();
					_move++;
					break;
				case 4:
					if (_priority >= 0) { //opponent second
						BattleChoices.this.opponentUseMove();
					} else { //player second
						if (_battle.getMoveUsed() != null) {
							BattleChoices.this.playerUseMove();
						}
					}
					_battle.updateHP();
					_move++;
					break;
				case 6:
					_move = 0; //moves onto next round
					break;
				case 9: //player pokemon has fainted
					_dialogue = new Dialogue(_battle.getRoot(), _game.getTeamHashMap().get(_battle.getPlayerIn()).getNickname() 
						+ " fainted!");
					_move++;
					_move++;
					_move++;
					break;
				case 11: //opponent pokemon has fainted
					if (_opponentMoves.isEmpty() == false) {
						_opponentMoves.clear();
					}
					for (int i = 0; i < _game.getPlayerTeamInts().size(); i++) {
						_game.getTeamHashMap().get(i).levelUp();
					}
					if (_battle.getTrainerBattle() && (_battle.getOpponentIn() == _battle.getTeamNumbers().length-1)) {
						_dialogue = new Dialogue(_battle.getRoot(), 
							_battle.getOpponentTeamHashMap().get(_battle.getOpponentIn()).getName() + " fainted!");
						_move++;
					} else if (_battle.getTrainerBattle() && (_battle.getOpponentIn() != _battle.getTeamNumbers().length-1)) {
						_battle.updateOpponentPicture(_battle.getOpponentIn(), _battle.getOpponentIn()+1);
						_battle.incrementOpponentIn();
						_dialogue = new Dialogue(_battle.getRoot(), "The opponent trainer sent in " +
							_battle.getOpponentTeamHashMap().get(_battle.getOpponentIn()).getName() + " !");
						_battle.updateHP();
						_battle.updateInfo();
						_move = -1;
					} else if (_battle.getTrainerBattle() == false) {
						_dialogue = new Dialogue(_battle.getRoot(), "The wild " + 
								_battle.getOpponentTeamHashMap().get(_battle.getOpponentIn()).getName()  + " fainted!");
						_move++;
					}
					break;
				case 13: //opponent or player has lost all pokemon
					_battle.endBattle();
					_move++;
					break;
				default:
					break;
			}
		}
	}
	
	/*
	 * Finds strongest move by calculating damage taken from each possible move 
	 * and comparing them, then returning name of strongest move
	 */
	private String getBestMove(Team attacker, Team defender) {
		DamageCalculator d1 = new DamageCalculator(attacker.getMove1(), _game.getMoveHashMap(), attacker, defender,
			_game.getPokemonHashMap().get(attacker.getName()).getType1(),
			_game.getPokemonHashMap().get(attacker.getName()).getType2(),
			_game.getPokemonHashMap().get(defender.getName()).getType1(),
			_game.getPokemonHashMap().get(defender.getName()).getType2(), _weather);
		int damage1 = d1.getDamage();
		DamageCalculator d2 = new DamageCalculator(attacker.getMove2(), _game.getMoveHashMap(), attacker, defender,
			_game.getPokemonHashMap().get(attacker.getName()).getType1(),
			_game.getPokemonHashMap().get(attacker.getName()).getType2(),
			_game.getPokemonHashMap().get(defender.getName()).getType1(),
			_game.getPokemonHashMap().get(defender.getName()).getType2(), _weather);
		int damage2 = d2.getDamage();
		DamageCalculator d3 = new DamageCalculator(attacker.getMove3(),_game.getMoveHashMap(), attacker, defender,
			_game.getPokemonHashMap().get(attacker.getName()).getType1(),
			_game.getPokemonHashMap().get(attacker.getName()).getType2(),
			_game.getPokemonHashMap().get(defender.getName()).getType1(),
			_game.getPokemonHashMap().get(defender.getName()).getType2(), _weather);
		int damage3 = d3.getDamage();
		DamageCalculator d4 = new DamageCalculator(attacker.getMove4(),_game.getMoveHashMap(), attacker, defender,
			_game.getPokemonHashMap().get(attacker.getName()).getType1(),
			_game.getPokemonHashMap().get(attacker.getName()).getType2(),
			_game.getPokemonHashMap().get(defender.getName()).getType1(),
			_game.getPokemonHashMap().get(defender.getName()).getType2(), _weather);
		int damage4 = d4.getDamage();
		if (damage1 >= damage2 && damage1 >= damage3 && damage1 >= damage4) {
			return _battle.getOpponentTeamHashMap().get(_battle.getOpponentIn()).getMove1();
		} else if (damage2 > damage1 && damage2 >= damage3 && damage2 >= damage4) {
			return _battle.getOpponentTeamHashMap().get(_battle.getOpponentIn()).getMove2();
		} else if (damage3 > damage1 && damage3 > damage2 && damage3 >= damage4) {
			return _battle.getOpponentTeamHashMap().get(_battle.getOpponentIn()).getMove3();
		} else {
			return _battle.getOpponentTeamHashMap().get(_battle.getOpponentIn()).getMove4();
		}
	}
	
	/*
	 * Takes in opponent move and checks the damage and stat changes 
	 * that would result from that move, then uses the getBestMove method to 
	 * find the player's best move in response to that move and checks the 
	 * damage and stat changes that would result from that, then uses the 
	 * getBestMove method to find the opponent's best move in response
	 * to that, then returns the damage taken by the player on move two minus
	 * the damage taken by the opponent on move two.
	 */
	private int getMoveOutcome(String move, int i) {
		_fakeOpponent = _battle.getOpponentTeamHashMap().get(_battle.getOpponentIn());
		_fakePlayer = _game.getTeamHashMap().get(_battle.getPlayerIn());
		DamageCalculator d1 = new DamageCalculator(move, _game.getMoveHashMap(), 
			_fakeOpponent, _fakePlayer, 
			_game.getPokemonHashMap().get(_fakeOpponent.getName()).getType1(),
			_game.getPokemonHashMap().get(_fakeOpponent.getName()).getType2(),
			_game.getPokemonHashMap().get(_fakePlayer.getName()).getType1(),
			_game.getPokemonHashMap().get(_fakePlayer.getName()).getType2(), _weather);
		int damageOpponent = d1.getDamage();
		this.statMove(_fakeOpponent, _fakePlayer, damageOpponent);
		String playerMove1 = this.getBestMove(_fakePlayer, _fakeOpponent);
		DamageCalculator d2 = new DamageCalculator(playerMove1, _game.getMoveHashMap(), 
			_fakePlayer, _fakeOpponent,
			_game.getPokemonHashMap().get(_fakePlayer.getName()).getType1(),
			_game.getPokemonHashMap().get(_fakePlayer.getName()).getType2(),
			_game.getPokemonHashMap().get(_fakeOpponent.getName()).getType1(),
			_game.getPokemonHashMap().get(_fakeOpponent.getName()).getType2(), _weather);
		int damagePlayer = d1.getDamage();
		this.statMove(_fakePlayer, _fakeOpponent, damagePlayer);
		String secondMove = this.getBestMove(_fakeOpponent, _fakePlayer);
		switch(i) {
		case 1:
			_secondMove1 = secondMove;
			break;
		case 2:
			_secondMove2 = secondMove;
			break;
		case 3:
			_secondMove3 = secondMove;
			break;
		case 4:
			_secondMove4 = secondMove;
			break;
		default:
			break;
		}
		DamageCalculator d3 = new DamageCalculator(secondMove, _game.getMoveHashMap(), 
			_fakeOpponent, _fakePlayer,
			_game.getPokemonHashMap().get(_fakeOpponent.getName()).getType1(),
			_game.getPokemonHashMap().get(_fakeOpponent.getName()).getType2(),
			_game.getPokemonHashMap().get(_fakePlayer.getName()).getType1(),
			_game.getPokemonHashMap().get(_fakePlayer.getName()).getType2(), _weather);
		int damageOpponent2 = d3.getDamage();
		int totalDamage = damageOpponent2-damagePlayer;
		return totalDamage;
	}
	
	/* 
	 * Effectively, this acts as a modified version of the MiniMax algorithm described
	 * in the Othello handout, but adjusted for a different setting. 
	 * 
	 * The intelligent opponent will use the move that causes the least damage to itself
	 * and the most damage to the player on the SECOND turn, using the getMoveOutcome
	 * method on each of its four moves, and determining the next TWO moves it should use 
	 * based on that. (If only one move were determined at a time, the opponent would never
	 * cause damage because only stat moves would be used)
	 * 
	*/
	private void getIntelligentBestMove() {
		int damage1 = this.getMoveOutcome(_battle.getOpponentTeamHashMap().get(_battle.getOpponentIn()).getMove1(), 1);
		int damage2 = this.getMoveOutcome(_battle.getOpponentTeamHashMap().get(_battle.getOpponentIn()).getMove2(), 2);
		int damage3 = this.getMoveOutcome(_battle.getOpponentTeamHashMap().get(_battle.getOpponentIn()).getMove3(), 3);
		int damage4 = this.getMoveOutcome(_battle.getOpponentTeamHashMap().get(_battle.getOpponentIn()).getMove4(), 4);
		if (damage1 >= damage2 && damage1 >= damage3 && damage1 >= damage4) {
			_opponentMoves.add(_battle.getOpponentTeamHashMap().get(_battle.getOpponentIn()).getMove1());
			_opponentMoves.add(_secondMove1);
		} else if (damage2 > damage1 && damage2 >= damage3 && damage2 >= damage4) {
			_opponentMoves.add(_battle.getOpponentTeamHashMap().get(_battle.getOpponentIn()).getMove2());
			_opponentMoves.add(_secondMove2);
		} else if (damage3 > damage1 && damage3 > damage2 && damage3 >= damage4) {
			_opponentMoves.add(_battle.getOpponentTeamHashMap().get(_battle.getOpponentIn()).getMove3());
			_opponentMoves.add(_secondMove3);
		} else {
			_opponentMoves.add(_battle.getOpponentTeamHashMap().get(_battle.getOpponentIn()).getMove4());
			_opponentMoves.add(_secondMove4);
		}
	}
	
	/*
	 * Opponent uses move, dialogue to show this, hp changes based on damage calculator
	 */
	private void opponentUseMove() {
		_dialogue = new Dialogue(_battle.getRoot(),"The wild " + _battle.getOpponentTeamHashMap().get(_battle.getOpponentIn()).getName() 
			+ " used " + _opponentMove + "!");
		String defenderName = _game.getTeamHashMap().get(_battle.getPlayerIn()).getName();
		String attackerName = _battle.getOpponentTeamHashMap().get(_battle.getOpponentIn()).getName();
		DamageCalculator d = new DamageCalculator(_opponentMove,
			_game.getMoveHashMap(), _battle.getOpponentTeamHashMap().get(_battle.getOpponentIn()),
			_game.getTeamHashMap().get(_battle.getPlayerIn()),
			_game.getPokemonHashMap().get(attackerName).getType1(),
			_game.getPokemonHashMap().get(attackerName).getType2(),
			_game.getPokemonHashMap().get(defenderName).getType1(),
			_game.getPokemonHashMap().get(defenderName).getType2(), _weather);
		int damage = d.getDamage();
		int prevHP = _game.getTeamHashMap().get(_battle.getPlayerIn()).getBattleHP();
		_game.getTeamHashMap().get(_battle.getPlayerIn()).setBattleHP(prevHP - damage);
		if (_game.getTeamHashMap().get(_battle.getPlayerIn()).getBattleHP() <= 0) {
			_game.getTeamHashMap().get(_battle.getPlayerIn()).setBattleHP(0);
			_move = 7;
		}
		
		if(_game.getMoveHashMap().get(_opponentMove).getEffect() != "" && 
			_game.getMoveHashMap().get(_opponentMove).getEffect() != null) {
			this.statMove(_battle.getOpponentTeamHashMap().get(_battle.getOpponentIn()),
				_game.getTeamHashMap().get(_battle.getPlayerIn()), damage);
		}
	}
	
	/*
	 * Player uses move, dialogue to show this, hp changes based on damage calculator
	 */
	private void playerUseMove() {
		_dialogue = new Dialogue(_battle.getRoot(), _game.getTeamHashMap().get(_battle.getPlayerIn()).getNickname() 
			+ " " + _battle.getPlayerAction() + "!");
		String attackerName = _game.getTeamHashMap().get(_battle.getPlayerIn()).getName();
		String defenderName = _battle.getOpponentTeamHashMap().get(_battle.getOpponentIn()).getName();
		DamageCalculator d = new DamageCalculator(_battle.getMoveUsed(), 
			_game.getMoveHashMap(), _game.getTeamHashMap().get(_battle.getPlayerIn()),
			_battle.getOpponentTeamHashMap().get(_battle.getOpponentIn()),
			_game.getPokemonHashMap().get(attackerName).getType1(),
			_game.getPokemonHashMap().get(attackerName).getType2(),
			_game.getPokemonHashMap().get(defenderName).getType1(),
			_game.getPokemonHashMap().get(defenderName).getType2(), _weather);
		int damage = d.getDamage();
		int prevHP = _battle.getOpponentTeamHashMap().get(_battle.getOpponentIn()).getBattleHP();
		_battle.getOpponentTeamHashMap().get(_battle.getOpponentIn()).setBattleHP(prevHP - damage);
		if (_battle.getOpponentTeamHashMap().get(_battle.getOpponentIn()).getBattleHP() <= 0) {
			_battle.getOpponentTeamHashMap().get(_battle.getOpponentIn()).setBattleHP(0);
			_move = 9;
		}
		
		if (_game.getMoveHashMap().get(_battle.getMoveUsed()).getEffect() != "") {
			this.statMove(_game.getTeamHashMap().get(_battle.getPlayerIn()), 
				_battle.getOpponentTeamHashMap().get(_battle.getOpponentIn()),
				damage);
		}
	}
	
	/*
	 * If player/opponent uses status move, performs appropriate stat/weather changes
	 */
	private void statMove(Team attacker, Team defender, int damage) {
		switch(_game.getMoveHashMap().get(_battle.getMoveUsed()).getEffect()) {
		case "raisesHP":
			int originalHP = attacker.getBattleHP();
			attacker.setBattleHP(originalHP + (int) (.5*damage));
			if (attacker.getBattleHP() > attacker.getHP()) {
				attacker.setBattleHP(attacker.getHP());
			}
			break;
		case "raiseSpecialStats":
			int originalSpecialDef = attacker.getSpecialDefense();
			attacker.setBattleSpecialDefense((int) (originalSpecialDef*Constants.RAISE_STAT));
			int originalSpecialAt = attacker.getSpecialAttack();
			attacker.setBattleSpecialAttack((int) (originalSpecialAt*Constants.RAISE_STAT));
			break;
		case "lowersAttack":
			int originalAttack = defender.getAttack();
			defender.setBattleAttack((int) (originalAttack*Constants.LOWER_STAT));
			break;
		case "lowersDefense":
			int originalDefense = defender.getDefense();
			defender.setBattleDefense((int) (originalDefense*Constants.LOWER_STAT));
			break;
		case "raisesDefense":
			int originalDef = attacker.getDefense();
			attacker.setBattleDefense((int)(originalDef*Constants.RAISE_STAT));
			break;
		case "raisesSpecialDefense":
			int originalSpecDef = attacker.getSpecialDefense();
			attacker.setBattleSpecialDefense((int)(originalSpecDef*Constants.RAISE_STAT));
			break;
		case "rain":
			_weather = "rain";
			break;
		case "sun":
			_weather = "sun";
			break;
		default:
			break;
		}
	}
	
	
	/*
	 * Remove dialogue box when player clicks on screen
	 */
	private class MouseHandler implements EventHandler<MouseEvent> {
		@Override
		public void handle(MouseEvent e) {
			if (_dialogue != null) {
				_dialogue.removeDialogue();
				_dialogue = null;
				_move++;
			}
		}
	}
			
	/*
	 * Called by Battle class to increment move counter after player makes a choice
	 */
	public void incrementMove() {
		_move++;
	}
	
}