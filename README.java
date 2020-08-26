/*
README

CONTROLS
	- Click the screen to advance through dialogue
	- Use the up/down/left/right arrows to move the player character
	- Use the space bar to interact with NPCs/doors/the consultant's computer when facing them

DATA STRUCTURES
	- HashMap<Integer, Team>	keeps track of the player's team
		deals with the specific pokemon the player has in their party
	- HashMap<String, Pokemon>  keeps track of all pokemon 'outlines' in game
		does not deal with specific pokemon, instead deals with base stats,
		sprites, potential moves, etc. that are needed to create specific pokemon, 
		which are created as instances of the NewPokemon class
	- HashMap<String, Move> 	keeps track of all moves in game and their stats
	- Arrays to keep track of objects and interactable objects on screen to control
	player movement and interactions with interactable objects


BATTLING ALGORITHMS
	- For wild pokemon, the opponent pokemon will randomly use a move.
	- For normal pokemon trainers, the opponent pokemon will use the move that 
	causes the most damage to the player's pokemon.
	- For experienced pokemon trainers, the opponent pokemon will use the moves
	that causes the least damage to the opponent pokemon and the most damage to
	the player pokemon on the next turn, with two moves selected at a time. In practice
	this means the pokemon will alternate stat and attacking moves. This is based on a 
	modified minimax algorithm, which could go through further recursions as necessary to
	scale difficulty further. 
	
CODING IMAGEVIEWS
	- Two sections using ImageView (Battle and CharacterMaker) were coded un-ideally
	due to problems with ImageView. In battle, for example, I attempted to create one playerImageView
	that would be continuously updated as the player switched pokemon. Java did not like this, despite
	repeated attempts at making this work, so I instead made six separate ImageViews that continuously change
	visibilty as the player switches pokemon. The same issue occurred with the different player portraits
	in CharacterMaker.
	
KNOWN BUGS
	- None. With that being said, it is likely that a bug or two exists SOMEWHERE.
	The most likely area for a bug would be in the PokemonHashMap or MoveHashMap,
	where an inappropriate value could be listed for a stat/sprite/etc. 
	
LOAD TIMES
	- It can take 10+ seconds to load a new location depending on computer used.

ACKNOWLEDGMENTS
	- Sprites and artwork are derived from Generations 3, 4, and 5 Pokemon artwork found online.
	  Human sprites were lightly edited, while Pokemon sprites were unaltered
*/