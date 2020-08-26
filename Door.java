package FinalProject;

import javafx.scene.layout.Pane;

/*
 * Creates a door, an interactable object that when interacted with 
 * moves the player character between locations by instantiating 
 * the new location and leaving the old to be garbage collected
 */

public class Door implements Interactable {
	
	private String _goTo;
	private Pane _mainPane;
	private Pane _currentPane;
	private Game _game;
	
	public Door(Game game, Pane main, Pane current, String goTo, int x, int y) {
		game.getInteractable()[x][y] = this;
		_mainPane = main;
		_game = game;
		_currentPane = current;
		_goTo = goTo;
	}
	
	/*
	 * When interacted with, PC location changes based on new location argument
	 */
	public void whenInteracted() { 
		_mainPane.getChildren().remove(_currentPane);
		for (int i = 0; i < Constants.SQUARES_WIDE; i++) {
			for (int j = 0; j < Constants.SQUARES_TALL; j++) {
				_game.getObjects()[i][j] = null;
			}
		}
		for (int i = 0; i < Constants.SQUARES_WIDE; i++) {
			for (int j = 0; j <= Constants.SQUARES_TALL; j++) {
				_game.getInteractable()[i][j] = null;
			}
		}
		switch(_goTo) {
		case "maingreen":
			MainGreen g = new MainGreen(_game, _mainPane);
			break;
		case "sunlab":
			SunLab s = new SunLab(_game, _mainPane);
			break;
		case "salomon":
			Salomon l = new Salomon(_game, _mainPane);
			_game.setPlayerX(Constants.SALOMON_X);
			_game.setPlayerY(Constants.SALOMON_Y);
			break;
		case "center":
			PokemonCenter p = new PokemonCenter(_game, _mainPane);
			_game.setPlayerX(Constants.CENTER_X);
			_game.setPlayerY(Constants.CENTER_Y);
			break;
		default:
			break;
		}
		
	}
}