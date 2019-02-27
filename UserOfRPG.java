/**
  Exercise the classes in the Role Playing Game.
  Simulates monster encounters of a wandering adventurer.
  Required classes: Protagonist, Monster
 */

// shorthand, used to read from CLI
import java.io.*;   
import java.util.*;

public class UserOfRPG // hw3C#0 // 2019-02-08 Notes
{
    //change this constant to set number of encounters in a game
    public final static int MAX_ENCOUNTERS = 5;
    
    // keeps track of the number of encounters
    private static int encounters;

    //each round, a Protagonist and a Monster will be instantiated...
    private Protagonist pat;   //Is it man or woman?
    private Monster opponent; //Friendly generic monster name?
    private Monster boss; // Boss battle; 

    private int moveCount;
    private boolean gameOver;
    private int difficulty;
    private int character;
    
    /* This is the collection of superclass variables described before. // hw 46#3
    This contains the monsters that the player will battle throughout the course of the game. // hw 46#3
    This horde will be randomly determined when UserOfRPG is initialized.// hw 46#3
    The maximum size of the mob will be determined by MAX_ENCOUNTERS.// hw 46#3
    Once randomly determined, the protagonist will sequentially face off against each element of the mob.// hw 46#3
    The last member wil be much stronger than the others.// hw 46#3

    */
    private Monster[] mob; // hw 46#4

    private InputStreamReader isr;
    private BufferedReader in;


    public UserOfRPG() { // hw3C#0
        // Initializes the variables
        encounters = 0;
        moveCount = 0;
        gameOver = false;
        isr = new InputStreamReader( System.in );
        in = new BufferedReader( isr );
        newGame();
    }


    /*=============================================
    void newGame() -- gathers info to begin a new game
    precondition:  
    post: according to user input, mobifies instance var for difficulty 
    and instantiates a Protagonist
    =============================================*/
    public void newGame() { // hw3C#0
        // Begins a new game
        String s;
        String name = "";
        s = "~~~ Welcome to Ye Olde RPG! ~~~\n";
        // Takes input for a name
        s += "\nChoose your difficulty: \n";
        s += "\t1: Easy\n";
        s += "\t2: Not so easy\n";
        s += "\t3: Beowulf hath nothing on me. Bring it on.\n";
        s += "Selection: ";
        System.out.print( s );
        // The "feeling lucky" code that serves as a framework
        try {
            difficulty = Integer.parseInt( in.readLine() ); 
        } catch ( IOException e ) { }
        // chooses character; out of three clases
        s += "\nChoose your character: \n";  
        s += "\t1: Slayer\n";  
        s += "\t2: Assassin\n"; 
        s += "\t3: Guardian\n";  
        s += "Selection: ";  
        System.out.print( s );  
        
        try {  // hw44#6
            character = Integer.parseInt( in.readLine() );  // hw44#6
        } catch ( IOException e ) { }  // hw44#6
        // offers input
        s = "Intrepid protagonist, what doth thy call thyself? (State your name): ";
        System.out.print( s );

        try {
            name = in.readLine();
        } catch ( IOException e ) { }

        //instantiate the player's character
        //checks if character matches the value needed to construct a new Protagonist of that type, and if it does, generates a new character of that class type.
        if (character == 1) { // hw44#6
            pat = new Slayer(name); // hw44#6
        }
        
        else if (character == 2) { // hw44#6
            pat = new Assassin(name); // hw44#6
        }
        
        else if (character == 3) {  // hw44#6
            pat = new Guardian(name); // hw44#6
        }
        // Prints the protagonist's information for troubleshooting
        System.out.println(pat);
        
        // Begins initializing the array of monsters in the superclass
        System.out.println("Initializing monsters...");
        // mob is formually defined as having up to MAX_ENCOUNTERS slots to have monsters fill
        // Makes an instance of a Monster array to be filled with subclasses
        mob = new Monster[MAX_ENCOUNTERS]; // hw 46#4
        // For each element in the array// hw 46#4
        for (int i = 0; i < mob.length; i++){ // hw 46#4
            // Rolls an integer that could be 0,1,2 to simulate randomly picking one of the monsters at a time // hw 46#6
            int roll = (int)(3 * Math.random());// hw 46#4
            if (roll == 0) { // hw 46#4
                mob[i] = new Golem(); // hw 46#4
            }
            
            if (roll == 1) { // hw 46#4
                mob[i] = new Goblin(); // hw 46#4
            }
            
            if (roll == 2) { // hw 46#4
                mob[i] = new Dragon(); // hw 46#4
            }

               }
        // Troubleshooting, as to ensure the mob is going well
        // for (Monster m : mob) {
        //    System.out.println(m);
        //}
                
    }//end newGame()


    /*=============================================
    boolean playTurn -- simulates a round of combat
    pre:  Protagonist pat has been initialized
    @return the boolean value of
        "the player survives"
    =============================================*/
    public boolean playTurn() { // hw3C#0
        int d1, d2, d3;
        // Use for difficulty
        if ( Math.random() >= ( difficulty / 3.0 ) )
            System.out.println( "\nNothing to see here. Move along!" );
        else {
            // This generates a boss if on the last encounter.
            if (encounters == MAX_ENCOUNTERS) {
                System.out.println("!!!!! BOSS APPROACHING !!!!!");
                // Makes the stats of the boss much more difficult to deal with.
                mob[encounters].bossify();
				boss = mob[encounters];
            }
            
            System.out.println( "\nLo, yonder monster approacheth!" );
            // Sets the opponent to the term in encounters that the game is up to. Each time encounter increments the element
            // of the array increments as well.
            opponent = mob[encounters];
            
            // Prints the creature's information
            System.out.println(opponent); //hw 46#2
			// Boss warning
			if (boss.equals(opponent)) {
				System.out.println("WARNING: BOSS APPROACHING")
			}
        

            while( opponent.isAlive() && pat.isAlive() ) {

                /* Give the user the option of using a special attack.
                   If you land a hit, you cause greater damage,
                   ...but if you get hit, you incur more damage.
                   */
                int choice = 0;
                // takes input for which move to perform
                try{
                    System.out.println( System.lineSeparator()
                      + "Do you feel lucky?" + System.lineSeparator()
                      + "    1: Nay"         + System.lineSeparator()
                      + "    2: Aye!" );
                    choice = Integer.parseInt( in.readLine() );
                }
                catch( IOException e ) { }

                if ( choice == 2 ) pat.specialize();
                else pat.normalize();
                
                //Damage calculation and embellishing
                d1 = pat.attack( opponent ); //hw 3E#0
                d2 = opponent.attack( pat ); //hw 3E#0

                System.out.println( "\n" + pat.getName() + " dealt " 
                                  + d1 + " points of damage.");

                System.out.println( "\n" + "Ye Olde Monster smacked " 
                                  + pat.getName() + " for "
                                  + d2 + " points of damage.");
			    // If the monster is a boss, attacks twice
				if (opponent.equals(boss)); {
			
					d3 = opponent.attack( pat); //hw 3E#0
					System.out.println( "\n" + "Ye Olde Monster smacked " 
                                  + pat.getName() + " for "
                                  + d3 + " points of damage.");
					
				}
				
                // Reports on the state of both characters.
                System.out.println(pat); // hw 46#1
                System.out.println(opponent); // hw46#2
                                  
            }//end while

            //option 1: you & the monster perish
            if ( !opponent.isAlive() && !pat.isAlive() ) {
                System.out.println( "'Twas an epic battle, to be sure... " + 
                "You cut ye olde monster down, but " +
                "with its dying breath ye olde monster. " +
                "laid a fatal blow upon thy skull." );
                return false;
            }
            //option 2: you slay the beast
            else if ( !opponent.isAlive() ) {
                System.out.println( "HuzzaaH! Ye olde monster hath been slain!" );
                return true;
            }
            //option 3: the beast slays you
            else if ( !pat.isAlive() ) {
                System.out.println( "Ye olde self hath expired. You got dead." );
                return false;
            }
        } //end else

        return true;
    }//end playTurn()


    public static void main( String[] args ) { // hw3C#0

        // //loading...
         UserOfRPG game = new UserOfRPG();
        // Plays the game until either the protagonist is dead or all of the Monsters in mob have been killed.
         while(    encounters < MAX_ENCOUNTERS
               && game.playTurn() ) {
            encounters++;
            System.out.println(encounters);
        }

        System.out.println( "Thy game doth be over." );
    }//end main

}//end class UserOfRPG
