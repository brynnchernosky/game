package FinalProject;

import java.util.HashMap;

/*
 * Creates one of the main data structures in the game, a hashmap
 * that maps a pokemon name to that pokemon. Includes unused variables
 * for pokemon evolution, which was unable to be coded in due to 
 * time constraints.
 */
public class PokemonHashMap{
	private HashMap<String, Pokemon> _pokemon;
	public PokemonHashMap() {
		_pokemon = new HashMap<String, Pokemon>();
		this.setupHashMap();
	}
	
	/*
	 * Gets the hash map created by this class, called by Game
	 */
	public HashMap<String, Pokemon> getHashMap() {
		return _pokemon;
	}
	
	/*
	 * Pokemon(String front, String back, String t1, String t2,
		int hp, int attack, int specialAttack, int defense, int specialDefense, int speed,
		String move1, String move2, String move3, String move4, String move5,
		String move6, String move7, String move8, String move9, String move10,
		int evolveLevel, string evolution)
	 */
	
	private void setupHashMap() {
		_pokemon.put("Absol", new Pokemon(
			"file:./FinalProject/PokemonSprites/AbsolFront.png",
			"file:./FinalProject/PokemonSprites/AbsolBack.png",
			"Dark", "", 65, 130, 60, 75, 60, 75,  
			"Assurance", "Bite", "Scratch", "Dark Pulse", "Feint Attack", "Night Slash",
			101, ""));
		_pokemon.put("Altaria", new Pokemon(
			"file:./FinalProject/PokemonSprites/AltariaFront.png",
			"file:./FinalProject/PokemonSprites/AltariaBack.png",
			"Dragon", "Fairy", 75, 70, 90, 70, 105, 80, 
			"Air Cutter", "Disarming Voice", "Dazzling Gleam", "Moonblast", "Dragon Pulse", "Draco Meteor",
			101, ""));
		_pokemon.put("Ampharos", new Pokemon(
			"file:./FinalProject/PokemonSprites/AmpharosFront.png",
			"file:./FinalProject/PokemonSprites/AmpharosBack.png",
			"Electric", "", 90, 75, 75, 115, 90, 55,
			"Tackle", "Spark", "Discharge", "Thunder Shock", "Body Slam", "Close Combat",
			101, ""));
		_pokemon.put("Arcanine", new Pokemon(
			"file:./FinalProject/PokemonSprites/ArcanineFront.png",
			"file:./FinalProject/PokemonSprites/ArcanineBack.png",
			"Fire", "", 90, 75, 75, 115, 90, 55, 
			"Bite", "Tackle", "Blast Burn", "Ember", "Fire Fang", "Flamethrower",
			101, ""));
		_pokemon.put("Articuno", new Pokemon(
			"file:./FinalProject/PokemonSprites/ArticunoFront.png",
			"file:./FinalProject/PokemonSprites/ArticunoBack.png",
			"Ice", "Flying", 90, 85, 100, 95, 125, 85, 
			"Air Slash", "Peck", "Ice Beam", "Ice Fang", "Hurricane", "Light Screen",
			101, ""));
		_pokemon.put("Bayleef", new Pokemon(
			"file:./FinalProject/PokemonSprites/BayleefFront.png",
			"file:./FinalProject/PokemonSprites/BayleefBack.png",
			"Grass", "", 60, 62, 80, 63, 80, 60,
			"Absorb", "Tackle", "Razor Leaf", "Petal Blizzard", "Body Slam", "Leaf Storm",
			70, "Meganium"));
		_pokemon.put("Beartic", new Pokemon(
			"file:./FinalProject/PokemonSprites/BearticFront.png",
			"file:./FinalProject/PokemonSprites/BearticBack.png",
			"Ice", "", 95, 110, 80, 70, 80, 50, 
			"Tackle", "Bite", "Body Slam", "Ice Beam", "Ice Fang", "Metal Claw",
			101, ""));
		_pokemon.put("Blastoise", new Pokemon(
			"file:./FinalProject/PokemonSprites/BlastoiseFront.png",
			"file:./FinalProject/PokemonSprites/BlastoiseBack.png",
			"Water", "", 79, 83, 100, 85, 105, 78,
			"Tackle", "Water Gun", "Hydro Pump", "Rain Dance", "Withdraw", "Skull Bash",
			101, ""));
		_pokemon.put("Braviary", new Pokemon(
			"file:./FinalProject/PokemonSprites/BraviaryFront.png",
			"file:./FinalProject/PokemonSprites/BraviaryBack.png",
			"Flying", "Normal", 100, 123, 75, 57, 75, 80,
			"Peck", "Aerial Ace", "Air Cutter", "Tackle", "Scratch", "Slash",
			101, ""));
		_pokemon.put("Bulbasaur", new Pokemon(
			"file:./FinalProject/PokemonSprites/BulbasaurFront.png",
			"file:./FinalProject/PokemonSprites/BulbasaurBack.png",
			"Grass", "Poison", 45, 49, 49, 65, 65, 45,
			"Acid", "Tackle", "Razor Leaf", "Growl", "Petal Blizzard", "Poison Jab",
			60, "Ivysaur"));
		_pokemon.put("Charizard", new Pokemon(
			"file:./FinalProject/PokemonSprites/CharizardFront.png",
			"file:./FinalProject/PokemonSprites/CharizardBack.png",
			"Fire", "Flying", 78, 84, 78, 109, 85, 100,
			"Bite", "Blast Burn", "Scratch", "Ember", "Eruption", "Growl",
			101, ""));
		_pokemon.put("Charmander", new Pokemon(
			"file:./FinalProject/PokemonSprites/CharmanderFront.png",
			"file:./FinalProject/PokemonSprites/CharmanderBack.png",
			"Fire", "", 39, 52, 43, 60, 50, 65, 
			"Bite", "Blast Burn", "Scratch", "Ember", "Eruption", "Growl",
			60, "Charmeleon"));
		_pokemon.put("Charmeleon", new Pokemon(
			"file:./FinalProject/PokemonSprites/CharmeleonFront.png",
			"file:./FinalProject/PokemonSprites/CharmeleonBack.png",
			"Fire", "", 58, 64, 58, 80, 65, 80, 
			"Bite", "Blast Burn", "Scratch", "Ember", "Eruption", "Growl",
			70, "Charizard"));
		_pokemon.put("Chikorita", new Pokemon(
			"file:./FinalProject/PokemonSprites/ChikoritaFront.png",
			"file:./FinalProject/PokemonSprites/ChikoritaBack.png",
			"Grass", "", 45, 49, 65, 49, 65, 45, 
			"Absorb", "Tackle", "Razor Leaf", "Petal Blizzard", "Body Slam", "Leaf Storm",
			60, "Bayleef"));
		_pokemon.put("Chimchar", new Pokemon(
			"file:./FinalProject/PokemonSprites/ChimcharFront.png",
			"file:./FinalProject/PokemonSprites/ChimcharBack.png",
			"Fire", "", 44, 58, 44, 58, 44, 61, 
			"Aura Sphere", "Growl", "Ember", "Scratch", "Blast Burn", "Superpower",
			60, "Monferno"));
		_pokemon.put("Croconaw", new Pokemon(
			"file:./FinalProject/PokemonSprites/CroconawFront.png",
			"file:./FinalProject/PokemonSprites/CroconawBack.png",
			"Water", "", 65, 80, 80, 59, 63, 58,
			"Bite", "Crunch", "Tackle", "Water Gun", "Hydro Pump", "Bubble Beam",
			60, "Feraligatr"));
		_pokemon.put("Cubchoo", new Pokemon(
			"file:./FinalProject/PokemonSprites/CubchooFront.png",
			"file:./FinalProject/PokemonSprites/CubchooBack.png",
			"Ice", "", 55, 70, 40, 60, 40, 40, 
			"Tackle", "Bite", "Body Slam", "Ice Beam", "Ice Fang", "Metal Claw",
			50, "Beartic"));
		_pokemon.put("Cyndaquil", new Pokemon(
			"file:./FinalProject/PokemonSprites/CyndaquilFront.png",
			"file:./FinalProject/PokemonSprites/CyndaquilBack.png",
			"Fire", "", 39, 52, 43, 60, 50, 65, 
			"Body Slam", "Tackle", "Ember", "Flame Wheel", "Growl", "Eruption",
			60, "Quilava"));
		_pokemon.put("Dragonair", new Pokemon(
			"file:./FinalProject/PokemonSprites/DragonairFront.png",
			"file:./FinalProject/PokemonSprites/DragonairBack.png",
			"Dragon", "", 61, 84, 65, 70, 70, 70,
			"Ice Beam", "Thunder Shock", "Bubble Beam", "Dragon Rush", "Dragon Pulse", "Air Cutter",
			70, "Dragonite"));
		_pokemon.put("Dragonite", new Pokemon(
			"file:./FinalProject/PokemonSprites/DragoniteFront.png",
			"file:./FinalProject/PokemonSprites/DragoniteBack.png",
			"Dragon", "Flying", 91, 134, 95, 100, 100, 80, 
			"Ice Beam", "Thunder Shock", "Bubble Beam", "Dragon Rush", "Dragon Pulse", "Air Cutter",
			101, ""));
		_pokemon.put("Dratini", new Pokemon(
			"file:./FinalProject/PokemonSprites/DratiniFront.png",
			"file:./FinalProject/PokemonSprites/DratiniBack.png",
			"Dragon", "", 41, 64, 45, 50, 50, 50, 
			"Ice Beam", "Thunder Shock", "Bubble Beam", "Dragon Rush", "Dragon Pulse", "Air Cutter",
			60, "Dragonair"));
		_pokemon.put("Eevee", new Pokemon(
			"file:./FinalProject/PokemonSprites/EeveeFront.png",
			"file:./FinalProject/PokemonSprites/EeveeBack.png",
			"Normal", "", 55, 55, 50, 45, 65, 55, 
			"Bite", "Tackle", "Body Slam", "Scratch", "Feint Attack", "Play Rough",
			50, "Eevee"));
		_pokemon.put("Empoleon", new Pokemon(
			"file:./FinalProject/PokemonSprites/EmpoleonFront.png",
			"file:./FinalProject/PokemonSprites/EmpoleonBack.png",
			"Water", "Steel", 84, 86, 88, 111, 101, 60,
			"Peck", "Water Gun", "Hydro Pump", "Metal Claw", "Growl", "Rain Dance",
			101, ""));
		_pokemon.put("Espeon", new Pokemon(
			"file:./FinalProject/PokemonSprites/EspeonFront.png",
			"file:./FinalProject/PokemonSprites/EspeonBack.png",
			"Psychic", "", 65, 65, 60, 130, 95, 110,
			"Bite", "Tackle", "Psychic", "Psybeam", "Quick Attack", "Dazzling Gleam",
			101, ""));
		_pokemon.put("Feraligatr", new Pokemon(
			"file:./FinalProject/PokemonSprites/FeraligatrFront.png",
			"file:./FinalProject/PokemonSprites/FeraligatrBack.png",
			"Water", "", 85, 105, 100, 79, 83, 78,
			"Bite", "Crunch", "Tackle", "Water Gun", "Hydro Pump", "Bubble Beam",
			101, ""));
		_pokemon.put("Flaaffy", new Pokemon(
			"file:./FinalProject/PokemonSprites/FlaffyFront.png",
			"file:./FinalProject/PokemonSprites/FlaffyBack.png",
			"Electric", "", 70, 55, 55, 80, 60, 45, 
			"Tackle", "Spark", "Discharge", "Thunder Shock", "Body Slam", "Close Combat",
			70, "Ampharos"));
		_pokemon.put("Flareon", new Pokemon(
			"file:./FinalProject/PokemonSprites/FlareonFront.png",
			"file:./FinalProject/PokemonSprites/FlareonBack.png",
			"Fire", "", 65, 130, 60, 95, 110, 65,
			"Tackle", "Bite", "Ember", "Flame Wheel", "Quick Attack", "Sunny Day",
			101, ""));
		_pokemon.put("Gabite", new Pokemon(
			"file:./FinalProject/PokemonSprites/GabiteFront.png",
			"file:./FinalProject/PokemonSprites/GabiteBack.png",
			"Dragon", "Ground", 68, 90, 65, 50, 55, 82,  
			"Bite", "Dragon Pulse", "Earthquake", "Earth Power", "Dragon Rush", "Light Screen",
			70, "Garchomp"));
		_pokemon.put("Garchomp", new Pokemon(
			"file:./FinalProject/PokemonSprites/GarchompFront.png",
			"file:./FinalProject/PokemonSprites/GarchompBack.png",
			"Dragon", "Ground", 108, 130, 95, 80, 85, 102,
			"Bite", "Dragon Pulse", "Earthquake", "Earth Power", "Dragon Rush", "Light Screen",
			101, ""));
		_pokemon.put("Gengar", new Pokemon(
			"file:./FinalProject/PokemonSprites/GengarFront.png",
			"file:./FinalProject/PokemonSprites/GengarBack.png",
			"Ghost", "Poison", 60, 65, 60, 130, 75, 110, 
			"Astonish", "Poison Jab", "Night Slash", "Ominous Wind", "Shadow Ball", "Reflect",
			101, ""));
		_pokemon.put("Gastly", new Pokemon(
			"file:./FinalProject/PokemonSprites/GhastlyFront.png",
			"file:./FinalProject/PokemonSprites/GhastlyBack.png",
			"Ghost", "Poison", 30, 35, 30, 100, 35, 80,
			"Astonish", "Poison Jab", "Night Slash", "Ominous Wind", "Shadow Ball", "Reflect",
			60, "Haunter"));
		_pokemon.put("Gible", new Pokemon(
			"file:./FinalProject/PokemonSprites/GibleFront.png",
			"file:./FinalProject/PokemonSprites/GibleBack.png",
			"Dragon", "Ground", 58, 70, 45, 40, 45, 42, 
			"Bite", "Dragon Pulse", "Earthquake", "Earth Power", "Dragon Rush", "Light Screen",
			60, "Gabite"));
		_pokemon.put("Glaceon", new Pokemon(
			"file:./FinalProject/PokemonSprites/GlaceonFront.png",
			"file:./FinalProject/PokemonSprites/GlaceonBack.png",
			"Ice", "", 65, 60, 110, 130, 95, 65, 
			"Bite", "Tackle", "Ice Beam", "Ice Fang", "Quick Attack", "Reflect",
			101, ""));
		_pokemon.put("Grotle", new Pokemon(
			"file:./FinalProject/PokemonSprites/GrotleFront.png",
			"file:./FinalProject/PokemonSprites/GrotleBack.png",
			"Grass", "", 75, 89, 85, 55, 65, 36, 
			"Absorb", "Body Slam", "Tackle", "Earthquake", "Giga Drain", "Withdraw",
			60, "Torterra"));
		_pokemon.put("Growlithe", new Pokemon(
			"file:./FinalProject/PokemonSprites/GrowlitheFront.png",
			"file:./FinalProject/PokemonSprites/GrowlitheBack.png",
			"Fire", "", 55, 70, 45, 70, 50, 60, 
			"Bite", "Tackle", "Blast Burn", "Ember", "Fire Fang", "Flamethrower",
			50, "Arcanine"));
		_pokemon.put("Gyarados", new Pokemon(
			"file:./FinalProject/PokemonSprites/GyradosFront.png",
			"file:./FinalProject/PokemonSprites/GyradosBack.png",
			"Water", "Flying", 95, 125, 79, 60, 100, 81, 
			"Surf", "Tackle", "Hydro Pump", "Crunch", "Dragon Rush", "Rain Dance",
			101, ""));
		_pokemon.put("Haunter", new Pokemon(
			"file:./FinalProject/PokemonSprites/HaunterFront.png",
			"file:./FinalProject/PokemonSprites/HaunterBack.png",
			"Ghost", "Poison", 45, 50, 45, 115, 55, 95,
			"Astonish", "Poison Jab", "Night Slash", "Ominous Wind", "Shadow Ball", "Reflect",
			70, "Gengar"));
		_pokemon.put("Horsea", new Pokemon(
			"file:./FinalProject/PokemonSprites/HorseaFront.png",
			"file:./FinalProject/PokemonSprites/HorseaBack.png",
			"Water", "", 30, 40, 70, 70, 25, 60, 
			"Bubble", "Water Gun", "Bubble Beam", "Hydro Pump", "Dragon Pulse", "Rain Dance",
			60, "Seadra"));
		_pokemon.put("Houndoom", new Pokemon(
			"file:./FinalProject/PokemonSprites/HoundoomFront.png",
			"file:./FinalProject/PokemonSprites/HoundoomBack.png",
			"Dark", "Fire", 75, 90, 50, 110, 80, 95, 
			"Assurance", "Crunch", "Bite", "Ember", "Dark Pulse", "Flamethrower",
			101, ""));
		_pokemon.put("Houndour", new Pokemon(
			"file:./FinalProject/PokemonSprites/HoundourFront.png",
			"file:./FinalProject/PokemonSprites/HoundourBack.png",
			"Dark", "Fire", 45, 60, 30, 80, 50, 65, 
			"Assurance", "Crunch", "Bite", "Ember", "Dark Pulse", "Flamethrower",
			50, "Houndoom"));
		_pokemon.put("Hydreigon", new Pokemon(
			"file:./FinalProject/PokemonSprites/HydreigonFront.png",
			"file:./FinalProject/PokemonSprites/HydreigonBack.png",
			"Dragon", "Dark", 92, 105, 90, 125, 90, 98, 
			"Assurance", "Crunch", "Dark Pulse", "Dragon Rush", "Dragon Pulse", "Dragon Claw",
			101, ""));
		_pokemon.put("Infernape", new Pokemon(
			"file:./FinalProject/PokemonSprites/InfernapeFront.png",
			"file:./FinalProject/PokemonSprites/InfernapeBack.png",
			"Fire", "Fighting", 76, 104, 71, 104, 71, 108, 
			"Aura Sphere", "Growl", "Ember", "Scratch", "Blast Burn", "Superpower",
			101, ""));
		_pokemon.put("Ivysaur", new Pokemon(
			"file:./FinalProject/PokemonSprites/IvysaurFront.png",
			"file:./FinalProject/PokemonSprites/IvysaurBack.png",
			"Grass", "Poison", 60, 62, 63, 80, 80, 60, 
			"Acid", "Tackle", "Razor Leaf", "Growl", "Petal Blizzard", "Poison Jab",
			70, "Venusaur"));
		_pokemon.put("Jolteon", new Pokemon(
			"file:./FinalProject/PokemonSprites/JolteonFront.png",
			"file:./FinalProject/PokemonSprites/JolteonBack.png",
			"Electric", "", 65, 65, 60, 110, 95, 130, 
			"Bite", "Tackle", "Thunder Shock", "Spark", "Discharge", "Quick Attack",
			101, ""));
		_pokemon.put("Kingdra", new Pokemon(
			"file:./FinalProject/PokemonSprites/KingdraFront.png",
			"file:./FinalProject/PokemonSprites/KingdraBack.png",
			"Water", "Dragon", 75, 95, 95, 95, 95, 85, 
			"Bubble", "Water Gun", "Bubble Beam", "Hydro Pump", "Dragon Pulse", "Rain Dance",
			101, ""));
		_pokemon.put("Lapras", new Pokemon(
			"file:./FinalProject/PokemonSprites/LaprasFront.png",
			"file:./FinalProject/PokemonSprites/LaprasBack.png",
			"Water", "Ice", 130, 85, 80, 85, 95, 60, 
			"Body Slam", "Ice Beam", "Surf", "Ice Fang", "Hydro Pump", "Rain Dance",
			101, ""));
		_pokemon.put("Larvitar", new Pokemon(
			"file:./FinalProject/PokemonSprites/LarvitarFront.png",
			"file:./FinalProject/PokemonSprites/LarvitarBack.png",
			"Rock", "Ground", 50, 64, 50, 45, 50, 41, 
			"Tackle", "Earthquake", "Dark Pulse", "Superpower", "Earth Power", "Night Slash",
			60, "Pupitar"));
		_pokemon.put("Leafeon", new Pokemon(
			"file:./FinalProject/PokemonSprites/LeafeonFront.png",
			"file:./FinalProject/PokemonSprites/LeafeonBack.png",
			"Grass", "", 65, 110, 130, 60, 65, 95, 
			"Bite", "Tackle", "Leaf Storm", "Mega Drain", "Light Screen", "Petal Blizzard",
			101, ""));
		_pokemon.put("Luxray", new Pokemon(
			"file:./FinalProject/PokemonSprites/LuxrayFront.png",
			"file:./FinalProject/PokemonSprites/LuxrayBack.png",
			"Electric", "", 80, 120, 79, 95, 79, 70, 
			"Crunch", "Bite", "Tackle", "Discharge", "Spark", "Thunder Shock",
			101, ""));
		_pokemon.put("Magikarp", new Pokemon(
			"file:./FinalProject/PokemonSprites/MagikarpFront.png",
			"file:./FinalProject/PokemonSprites/MagikarpBack.png",
			"Water", "", 20, 10, 55, 15, 20, 80, 
			"Tackle", "Tackle", "Tackle", "Tackle", "Tackle", "Tackle",
			50, "Gyarados"));
		_pokemon.put("Mareep", new Pokemon(
			"file:./FinalProject/PokemonSprites/MareepFront.png",
			"file:./FinalProject/PokemonSprites/MareepBack.png",
			"Electric", "", 55, 40, 40, 65, 45, 35, 
			"Tackle", "Spark", "Discharge", "Thunder Shock", "Body Slam", "Close Combat",
			60, "Flaaffy"));
		_pokemon.put("Meganium", new Pokemon(
			"file:./FinalProject/PokemonSprites/MeganiumFront.png",
			"file:./FinalProject/PokemonSprites/MeganiumBack.png",
			"Grass", "", 80, 82, 100, 83, 100, 80,
			"Absorb", "Tackle", "Razor Leaf", "Petal Blizzard", "Body Slam", "Leaf Storm",
			70, ""));
		_pokemon.put("Meowth", new Pokemon(
			"file:./FinalProject/PokemonSprites/MeowthFront.png",
			"file:./FinalProject/PokemonSprites/MeowthBack.png",
			"Normal", "", 40, 45, 35, 40, 40, 90, 
			"Bite", "Scratch", "Feint Attack", "Growl", "Slash", "Tail Whip",
			50, "Persian"));
		_pokemon.put("Metagross", new Pokemon(
			"file:./FinalProject/PokemonSprites/MetagrossFront.png",
			"file:./FinalProject/PokemonSprites/MetagrossBack.png",
			"Steel", "Psychic", 80, 135, 130, 95, 90, 70, 
			"Body Slam", "Metal Claw", "Psychic", "Psybeam", "Shadow Ball", "Confusion",
			101, ""));
		_pokemon.put("Milotic", new Pokemon(
			"file:./FinalProject/PokemonSprites/MiloticFront.png",
			"file:./FinalProject/PokemonSprites/MiloticBack.png",
			"Water", "", 95, 60, 79, 100, 125, 81, 
			"Aqua Tail", "Body Slam", "Charm", "Bubble Beam", "Bubble", "Disarming Voice",
			101, ""));
		_pokemon.put("Moltres", new Pokemon(
			"file:./FinalProject/PokemonSprites/MoltresFront.png",
			"file:./FinalProject/PokemonSprites/MoltresBack.png",
			"Fire", "Flying", 90, 100, 90, 125, 85, 90, 
			"Air Slash", "Peck", "Hurricane", "Light Screen", "Flamethrower", "Erruption",
			101, ""));
		_pokemon.put("Monferno", new Pokemon(
			"file:./FinalProject/PokemonSprites/MonfernoFront.png",
			"file:./FinalProject/PokemonSprites/MonfernoBack.png",
			"Fire", "Fighting", 64, 78, 52, 78, 52, 81, 
			"Aura Sphere", "Growl", "Ember", "Scratch", "Blast Burn", "Superpower",
			70, "Infernape"));
		_pokemon.put("Ninetales", new Pokemon(
			"file:./FinalProject/PokemonSprites/NinetalesFront.png",
			"file:./FinalProject/PokemonSprites/NinetalesBack.png",
			"Fire", "", 73, 76, 75, 81, 100, 100, 
			"Fire Fang", "Bite", "Feint Attack", "Flamethrower", "Ember", "Extrasensory",
			101, ""));
		_pokemon.put("Pachirisu", new Pokemon(
			"file:./FinalProject/PokemonSprites/PachirisuFront.png",
			"file:./FinalProject/PokemonSprites/PachirisuBack.png",
			"Electric", "", 60, 45, 70, 45, 90, 95, 
			"Bite", "Tackle", "Tail Whip", "Growl", "Spark", "Discharge",
			101, ""));
		_pokemon.put("Persian", new Pokemon(
			"file:./FinalProject/PokemonSprites/PersianFront.png",
			"file:./FinalProject/PokemonSprites/PersianBack.png",
			"Normal", "", 65, 70, 60, 65, 65, 115, 
			"Bite", "Scratch", "Feint Attack", "Growl", "Slash", "Tail Whip",
			101, ""));
		_pokemon.put("Pidgeot", new Pokemon(
			"file:./FinalProject/PokemonSprites/PidgeotFront.png", 
			"file:./FinalProject/PokemonSprites/PidgeotBack.png",
			"Normal", "", 83, 80, 75, 70, 70, 91,
			"Aerial Ace", "Air Cutter", "Peck", "Hurricane", "Scratch", "Wing Attack",
			101, ""));
		_pokemon.put("Pidgeotto", new Pokemon(
			"file:./FinalProject/PokemonSprites/PidgeottoFront.png", 
			"file:./FinalProject/PokemonSprites/PidgeottoBack.png",
			"Normal", "Flying", 63, 60, 55, 50, 50, 71,
			"Aerial Ace", "Air Cutter", "Peck", "Hurricane", "Scratch", "Wing Attack",
			70, "Pidgeot"));
		_pokemon.put("Pidgey", new Pokemon(
			"file:./FinalProject/PokemonSprites/PidgeyFront.png",
			"file:./FinalProject/PokemonSprites/PidgeyBack.png",
			"Normal", "Flying", 40, 45, 40, 35, 35, 56,
			"Aerial Ace", "Air Cutter", "Peck", "Hurricane", "Scratch", "Wing Attack",
			60, "Pidgeotto"));
		_pokemon.put("Pikachu", new Pokemon(
			"file:./FinalProject/PokemonSprites/PikachuFront.png",
			"file:./FinalProject/PokemonSprites/PikachuBack.png",
			"Electric", "", 35, 55, 35, 50, 45, 90, 
			"Tackle", "Quick Attack", "Thunder Shock", "Discharge", "Tail Whip", "Growl",
			60, "Raichu"));
		_pokemon.put("Piplup", new Pokemon(
			"file:./FinalProject/PokemonSprites/PiplupFront.png",
			"file:./FinalProject/PokemonSprites/PiplupBack.png",
			"Water", "", 53, 51, 53, 61, 56, 40, 
			"Peck", "Water Gun", "Hydro Pump", "Metal Claw", "Growl", "Rain Dance",
			60, "Prinplup"));
		_pokemon.put("Prinplup", new Pokemon(
			"file:./FinalProject/PokemonSprites/PrinplupFront.png",
			"file:./FinalProject/PokemonSprites/PrinplupBack.png",
			"Water", "", 64, 66, 68, 81, 76, 50, 
			"Peck", "Water Gun", "Hydro Pump", "Metal Claw", "Growl", "Rain Dance",
			70, ""));
		_pokemon.put("Pupitar", new Pokemon(
			"file:./FinalProject/PokemonSprites/PupitarFront.png",
			"file:./FinalProject/PokemonSprites/PupitarBack.png",
			"Rock", "Ground", 70, 84, 70, 65, 70, 51, 
			"Tackle", "Earthquake", "Dark Pulse", "Superpower", "Earth Power", "Night Slash",
			70, "Tyranitar"));
		_pokemon.put("Quilava", new Pokemon(
			"file:./FinalProject/PokemonSprites/QuilavaFront.png",
			"file:./FinalProject/PokemonSprites/QuilavaBack.png",
			"Fire", "", 58, 64, 58, 80, 65, 80, 
			"Body Slam", "Tackle", "Ember", "Flame Wheel", "Growl", "Eruption",
			70, "Typhlosion"));
		_pokemon.put("Reuniclus", new Pokemon(
			"file:./FinalProject/PokemonSprites/ReuniclusFront.png",
			"file:./FinalProject/PokemonSprites/ReuniclusBack.png",
			"Psychic", "", 110, 65, 75, 125, 85, 30, 
			"Psychic", "Confusion", "Extrasensory", "Reflect", "Light Screen", "Calm Mind",
			101, ""));
		_pokemon.put("Rhydon", new Pokemon(
			"file:./FinalProject/PokemonSprites/RhydonFront.png",
			"file:./FinalProject/PokemonSprites/RhydonBack.png",
			"Rock", "Ground", 105, 130, 120, 45, 45, 40, 
			"Tackle", "Body Slam", "Earthquake", "Metal Claw", "Iron Tail", "Bulldoze",
			101, ""));
		_pokemon.put("Rotom", new Pokemon(
			"file:./FinalProject/PokemonSprites/RotomFront.png",
			"file:./FinalProject/PokemonSprites/RotomBack.png",
			"Electric", "Ghost", 50, 50, 77, 95, 77, 91, 
			"Astonish", "Shadow Ball", "Dark Pulse", "Thunder Shock", "Discharge", "Calm Mind",
			101, ""));
		_pokemon.put("Salamence", new Pokemon(
			"file:./FinalProject/PokemonSprites/SalamenceFront.png",
			"file:./FinalProject/PokemonSprites/SalamenceBack.png",
			"Dragon", "Flying", 95, 135, 80, 110, 80, 100, 
			"Air Cutter", "Body Slam", "Dragon Pulse", "Dragon Rush", "Aerial Ace", "Flamethrower",
			101, ""));
		_pokemon.put("Seadra", new Pokemon(
			"file:./FinalProject/PokemonSprites/SeadraFront.png",
			"file:./FinalProject/PokemonSprites/SeadraBack.png",
			"Water", "", 55, 65, 95, 95, 45, 85, 
			"Bubble", "Water Gun", "Bubble Beam", "Hydro Pump", "Dragon Pulse", "Rain Dance",
			70, "Kingdra"));
		_pokemon.put("Squirtle", new Pokemon(
			"file:./FinalProject/PokemonSprites/SquirtleFront.png",
			"file:./FinalProject/PokemonSprites/SquirtleBack.png",
			"Water", "", 44, 48, 65, 50, 64, 43,
			"Tackle", "Water Gun", "Hydro Pump", "Rain Dance", "Withdraw", "Skull Bash",
			60, "Wartortle"));
		_pokemon.put("Swanna", new Pokemon(
			"file:./FinalProject/PokemonSprites/SwannaFront.png",
			"file:./FinalProject/PokemonSprites/SwannaBack.png",
			"Water", "Flying", 75, 87, 63, 87, 63, 98, 
			"Air Cutter", "Peck", "Water Gun", "Hurricane", "Aerial Ace", "Charm",
			101, ""));
		_pokemon.put("Teddiursa", new Pokemon(
			"file:./FinalProject/PokemonSprites/TeddiursaFront.png",
			"file:./FinalProject/PokemonSprites/TeddiursaBack.png",
			"Normal", "", 60, 80, 50, 50, 50, 40, 
			"Bite", "Body Slam", "Tackle", "Growl", "Charm", "Play Rough",
			50, "Ursaring"));
		_pokemon.put("Torterra", new Pokemon(
			"file:./FinalProject/PokemonSprites/TorterraFront.png",
			"file:./FinalProject/PokemonSprites/TorterraBack.png",
			"Grass", "Ground", 95, 109, 105, 75, 85, 56, 
			"Absorb", "Body Slam", "Tackle", "Earthquake", "Giga Drain", "Withdraw",
			101, ""));
		_pokemon.put("Totodile", new Pokemon(
			"file:./FinalProject/PokemonSprites/TotodileFront.png",
			"file:./FinalProject/PokemonSprites/TotodileBack.png",
			"Water", "", 50, 65, 64, 44, 48, 43, 
			"Bite", "Crunch", "Tackle", "Water Gun", "Hydro Pump", "Bubble Beam",
			60, "Croconaw"));
		_pokemon.put("Turtwig", new Pokemon(
			"file:./FinalProject/PokemonSprites/TurtwigFront.png",
			"file:./FinalProject/PokemonSprites/TurtwigBack.png",
			"Grass", "", 55, 68, 64, 45, 55, 31, 
			"Absorb", "Body Slam", "Tackle", "Earthquake", "Giga Drain", "Withdraw",
			60, "Grotle"));
		_pokemon.put("Typhlosion", new Pokemon(
			"file:./FinalProject/PokemonSprites/TyphlosionFront.png",
			"file:./FinalProject/PokemonSprites/TyphlosionBack.png",
			"Fire", "", 78, 84, 78, 109, 85, 100, 
			"Body Slam", "Tackle", "Ember", "Flame Wheel", "Growl", "Eruption",
			101, ""));
		_pokemon.put("Tyranitar", new Pokemon(
			"file:./FinalProject/PokemonSprites/TyranitarFront.png",
			"file:./FinalProject/PokemonSprites/TyranitarBack.png",
			"Rock", "Dark", 100, 134, 110, 95, 100, 61, 
			"Tackle", "Earthquake", "Dark Pulse", "Superpower", "Earth Power", "Night Slash",
			101, ""));
		_pokemon.put("Umbreon", new Pokemon(
			"file:./FinalProject/PokemonSprites/UmbreonFront.png",
			"file:./FinalProject/PokemonSprites/UmbreonBack.png",
			"Dark", "", 95, 65, 110, 60, 130, 65, 
			"Assurance", "Bite", "Dark Pulse", "Tackle", "Night Slash", "Feint Attack",
			101, ""));
		_pokemon.put("Ursaring", new Pokemon(
			"file:./FinalProject/PokemonSprites/UrsaringFront.png",
			"file:./FinalProject/PokemonSprites/UrsaringBack.png",
			"Normal", "", 90, 130, 75, 75, 75, 55, 
			"Bite", "Body Slam", "Tackle", "Growl", "Charm", "Play Rough",
			101, ""));
		_pokemon.put("Vaporeon", new Pokemon(
			"file:./FinalProject/PokemonSprites/VaporeonFront.png",
			"file:./FinalProject/PokemonSprites/VaporeonBack.png",
			"Water", "", 130, 65, 60, 110, 95, 65, 
			"Aqua Tail", "Bite", "Tackle", "Hydro Pump", "Ice Beam", "Water Gun",
			101, ""));
		_pokemon.put("Venusaur", new Pokemon(
			"file:./FinalProject/PokemonSprites/VenusaurFront.png",
			"file:./FinalProject/PokemonSprites/VenusaurBack.png",
			"Grass", "Poison", 80, 82, 83, 100, 100, 80, 
			"Acid", "Tackle", "Razor Leaf", "Growl", "Petal Blizzard", "Poison Jab",
			101, ""));
		_pokemon.put("Vulpix", new Pokemon(
			"file:./FinalProject/PokemonSprites/VulpixFront.png",
			"file:./FinalProject/PokemonSprites/VulpixBack.png",
			"Fire", "", 38, 41, 40, 50, 65, 65, 
			"Fire Fang", "Bite", "Feint Attack", "Flamethrower", "Ember", "Extrasensory",
			50, "Ninetales"));
		_pokemon.put("Wartortle", new Pokemon(
			"file:./FinalProject/PokemonSprites/WartortleFront.png",
			"file:./FinalProject/PokemonSprites/WartortleBack.png",
			"Water", "", 59, 63, 80, 65, 80, 58, 
			"Tackle", "Water Gun", "Hydro Pump", "Rain Dance", "Withdraw", "Skull Bash",
			70, "Blastoise"));
		_pokemon.put("Zapdos", new Pokemon(
			"file:./FinalProject/PokemonSprites/ZapdosFront.png",
			"file:./FinalProject/PokemonSprites/ZapdosBack.png",
			"Electric", "Flying", 90, 90, 85, 125, 90, 100, 
			"Air Slash", "Peck", "Hurricane", "Light Screen", "Thunder Shock", "Discharge", 
			101, ""));
	}
}