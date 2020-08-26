package FinalProject;

import javafx.scene.image.ImageView;
import javafx.scene.text.Font;

/*
 * The constants class contains constants used in the game
 */

public class Constants { 
	//GENERAL
    public static final int APP_X = 810; //app width
    public static final int APP_Y = 800; //app height
    public static final int MOVEABLE_X = 810; //area player can move in
    public static final int MOVEABLE_Y = 600; 
    public static final int START_SCREEN_X = 400; //coordinates for start screen vbox
    public static final int START_SCREEN_Y = 400;
    public static final int SQUARE_SIDE = 30; //each square 20 pixels tall/wide
    public static final int SQUARES_TALL = MOVEABLE_Y/SQUARE_SIDE; //breaking up window into array of squares 
    public static final int SQUARES_WIDE = MOVEABLE_X/SQUARE_SIDE; 
    
    public static final int DIALOGUE_BOX_X = 100; //coordinates for dialogue box
    public static final int DIALOGUE_BOX_Y = 660;
    public static final int DIALOGUE_BOX_LENGTH = 600; //dimensions for dialogue box
    public static final int DIALOGUE_BOX_HEIGHT = 80;
    public static final int DIALOGUE_X = 120; //coordinates for dialogue text start
    public static final int DIALOGUE_Y = 680;
    public static final int DIALOGUE_LENGTH = 560; //length of text before next line begins
    public static final Font DIALOGUE_FONT = new Font("Lucida Sans Typewriter Bold", 15);
    
    public static final int PLAYER_START_X = 90; //starting coordinates of player character
    public static final int PLAYER_START_Y = 510;
    public static final int MOVE_INCREMENT = SQUARE_SIDE; //pixels player character moves with arrow input
    
    public static final double DURATION = .5; //keyframe duration
    
    //START SCREEN
    public static final int BALL_X = 500; //coordinates of center
	public static final int BALL_Y = 750;
	public static final int BALL_RAD = 50; //ball radius
	public static final int BALL_ANGLE = 180; //for semicircle
	public static final int BALL_LENGTH = 180;
	public static final int BALL_STROKE = 10; //for black line
	public static final int CIRCLE_RAD = 12; //radius of inner circle
	public static final double BALL_SCALE = 1.5;
	public static final int BALL_X2 = -230; //final coordinates
	public static final int BALL_Y2 = -450;
	public static final int START_X = 335; //start button coordinates
	public static final int START_Y = 630;
    
    //SPRITES    
    public static final String COMPUTER = "file:./FinalProject/ObjectSprites/Computer.png";
    
    //CHARACTER CREATION
    public static final int ID_X = 150; //id coordinates
    public static final int ID_Y = 320;
    public static final int ID_LENGTH = 500; //id dimensions
    public static final int ID_HEIGHT = 300;
    public static final int ROUND_CORNERS = 50; //arc length and width to produce round corners
    public static final int LOGO_X = 170; //brown logo coordinates
    public static final int LOGO_Y = 350;
    public static final int LOGO_LENGTH = 250; //brown logo dimensions
    public static final int LOGO_HEIGHT = 100;
    public static final int NAME_X = 200; //name coordinates
    public static final int NAME_Y = 500;
    public static final int NAME_LENGTH = 300; //name dimensions
    public static final int NAME_HEIGHT = 60;
    public static final int PICTURE_X = 500; //picture coordinates
    public static final int PICTURE_Y = 350;
    public static final int PICTURE_LENGTH = 100; //picture dimensions
    public static final int PICTURE_HEIGHT = 120;
    public static final int CONTINUE_X = 310; //continue button coordinates
    public static final int CONTINUE_Y = 700;
    public static final int INSTRUCTIONS_Y = 200; //instructions coordinates
    
    //STARTER SELECTION
    public static final int BULBASAUR_LABELX = 90; //pokemon name label coordinates
    public static final int BULBASAUR_LABELY = 200;
    public static final int CHARMANDER_LABELX = 350;
    public static final int CHARMANDER_LABELY = 200;
    public static final int SQUIRTLE_LABELX = 610;
    public static final int SQUIRTLE_LABELY = 200;
    public static final int CHIKORITA_LABELX = 90;
    public static final int CHIKORITA_LABELY = 350;
    public static final int CYNDAQUIL_LABELX = 350;
    public static final int CYNDAQUIL_LABELY = 350;
    public static final int TOTODILE_LABELX = 610;
    public static final int TOTODILE_LABELY = 350;
    public static final int TURTWIG_LABELX = 90;
    public static final int TURTWIG_LABELY = 500;
    public static final int CHIMCHAR_LABELX = 350;
    public static final int CHIMCHAR_LABELY = 500;
    public static final int PIPLUP_LABELX = 610;
    public static final int PIPLUP_LABELY = 500;

    public static final int SELECT_SIDE = 150; //x and y dimensions for pokemon images
    public static final int BULBASAUR_X = 50; //pokemon image coordinates
    public static final int BULBASAUR_Y = 50;
    public static final int CHARMANDER_X = 320;
    public static final int CHARMANDER_Y = 50;
    public static final int SQUIRTLE_X = 570;
    public static final int SQUIRTLE_Y = 60;
    public static final int CHIKORITA_X = 50;
    public static final int CHIKORITA_Y = 200;
    public static final int CYNDAQUIL_X = 320;
    public static final int CYNDAQUIL_Y = 200;
    public static final int TOTODILE_X = 570;
    public static final int TOTODILE_Y = 210;
    public static final int TURTWIG_X = 50;
    public static final int TURTWIG_Y = 350;
    public static final int CHIMCHAR_X = 320;
    public static final int CHIMCHAR_Y = 350;
    public static final int PIPLUP_X = 570;
    public static final int PIPLUP_Y = 360;
    
    //SUNLAB
    public static final int STAGE_HEIGHT = 100;
    public static final int COMPUTER_COLUMNS = 11;
    public static final int COMPUTER_ROWS = 8;
    public static final int COMPUTER_INCREMENT = 60;
    public static final int COMPUTER_START_X = 60;
    public static final int COMPUTER_START_Y = 135;
    public static final int COMPUTER_LENGTH = 60;
    public static final int COMPUTER_HEIGHT= 30;
    public static final int PIKACHU_HEIGHT = 60;
    public static final int PIKACHU_WIDTH = 60;
    public static final int PIKACHU_X = -10;
    public static final int NPC1_X = 60; //npc coordinates
    public static final int NPC1_Y = 150;
    public static final int NPC2_X = 180;
    public static final int NPC2_Y = 330;
    public static final int NPC3_X = 240;
    public static final int NPC3_Y = 450;
    public static final int NPC4_X = 360;
    public static final int NPC4_Y = 210;
    
    //SALOMON
    public static final int SALOMON_X = 120; //player sprite coordinates on entering salomon
    public static final int SALOMON_Y = 570; 
    
    //POKEMON CENTER
    public static final int CENTER_X = 390; //player sprite coordinates on entering pokemon center
    public static final int CENTER_Y = 540; 
    public static final int CENTER_X_COORDINATE = -45; //center background x
    public static final double CENTER_INSIDE_SCALE = .47;
    public static final int CENTER_DOOR_X1 = 12; //locations in interactable array of doors
    public static final int CENTER_DOOR_X2 = 13;
    public static final int CENTER_DOOR_Y = 19;
    
    //MAIN GREEN
    public static final double MART_SCALE = 2.3; //mart scale
    public static final int MART_Y = 25; //mart coordinates
    public static final int MART_X = 60;
    public static final double CENTER_SCALE = 2; //center scale
    public static final int CENTEROUT_Y = 15; //center coordinates
    public static final int CENTEROUT_X = 210;
    public static final int CENTERDOOR_I = 8; //center door coordinates in array of interactable objects
    public static final int CENTERDOOR_J = 2;
    public static final int SALOMONOUT_X = 660; //salomon coordinates
    public static final int SALOMONOUT_Y = 90;
    public static final int SALOMON_WIDTH = 145; //salomon dimensions
    public static final int SALOMON_HEIGHT = 210; 
    public static final int DOOR_X = 715; //salomon door coordinates
    public static final int DOOR_Y = 245;
    public static final int DOOR_WIDTH = 40; //salomon door dimensions
    public static final int DOOR_HEIGHT = 60;
    public static final int DOOR_I = 24; //salomon door coordinates in array of interactable objects
    public static final int DOOR_J = 8;
    
    //GRASS
    public static final double GRASS_X = Constants.SQUARE_SIDE*.8; //grass dimensions
    public static final double GRASS_OFFSET = Constants.SQUARE_SIDE/2; //offset between patches of grass
    
    //BATTLES
    public static final int PLATFORM_RAD1 = 250; //platform dimensions
    public static final int PLATFORM_RAD2 = 70;
    public static final int PLATFORM1_X = 130; //player platform coordinates
    public static final int PLATFORM2_X = 700;
    public static final int PLATFORM1_Y = 550; //opponent platform coordinates
    public static final int PLATFORM2_Y = 300;
    public static final int OPPONENT_X = 520; //opponent pokemon sprite coordinates
    public static final int OPPONENT_Y = 110;
    public static final int PLAYER_X = -10; //player pokemon sprite coordinates
    public static final int PLAYER_Y = 370;
    public static final int POKEMON_SCALE = 300; //pokemon sprite scale
    public static final int BUTTON_SPACING = 40; //button spacing
    public static final int BUTTON_LENGTH = 150; //button dimensions
    public static final int BUTTON_HEIGHT = 70;
    public static final int BUTTON_TEXTY = 620; //button text coordinates
    public static final int BUTTON_STARTX = 40; 
    public static final Font BUTTON_FONT = new Font("Lucida Sans Typewriter Bold", 25);
    public static final int BACK_BUTTON_LENGTH = 100; //back button dimensions
    public static final int BACK_BUTTON_HEIGHT = 50;
    public static final int BACK_BUTTON_X = 350; //back button coordinates
	public static final int BACK_BUTTON_Y = 710;
	public static final int PLAYER_RX = 250; //label rectangle coordinates
	public static final int PLAYER_RY = 500;
	public static final int OPPONENT_RX = 650; //label rectangle coordinates for opponent
	public static final int OPPONENT_RY = 300;
	public static final int RECTANGLEX = 100; //label rectangle dimensions
	public static final int RECTANGLEY = 50;
    public static final int LABEL_ROUND_CORNERS = 25;
	public static final int NAMELABELX = 260; //coordinates of player name label
	public static final int NAMELABELY = 510;
	public static final int NAMELABELX2 = 660; //coordinates of opponent name label
	public static final int NAMELABELY2 = 310;
	public static final int LEVEL_LABEL_INCREMENT = 15; //vertical distance of level label from name label
	public static final int HP_LABEL_INCREMENT = 30; //vertical distance of hp label from name label
	public static final int LABEL_X = 100; 
	public static final int LABEL_Y = 50;
    public static final double RAISE_STAT = 1.2;
    public static final double LOWER_STAT = 1.2;
    public static final double SMALL_BOOST = 1.5; //multipliers used in damage calculations
    public static final double BIG_BOOST = 2;
    public static final double SMALL_LOSS = .5;
	
    //BAG
    public static final int BUTTON_WIDTHBAG = 100; //button dimensions
    public static final int BUTTON_HEIGHTBAG = 50;
    public static final int BAG_SPACING = 20; //button spacing
    public static final int STARTING_POTIONS = 10; //starting quantities
    public static final int STARTING_BALLS = 10;
    
}