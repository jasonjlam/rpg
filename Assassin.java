public class Assassin extends Player { // hw44#3
    public Assassin(String name){ // hw44#3
        // Constructs a Assassin class
        // Calls the super as to construct a Protagonist, just with default stats
        super("Assassin-" + name);
        // Changes up the stats to make it unique'
        // Note it keeps the name of the class along with player input to combine them in order to make a unique name
        strength = 50;
        health = 100;
        
        attack = BASE_ATK = 1;
        defense = BASE_DEF = 10;  
    }
    public String toString(){ // hw44#3 // hw 46#1
        // Adds a quote to the description of the class.
        String desc = ""; // hw 46#1
        desc += name; // hw 46#1
        desc += ": Everybody dies. Some just need a little help."; // hw 46#1
        // Calls upon the toString of the superclass character in order to print out a unique quote, and then combine it with more traditional statistics present in the superclass.
        desc += super.toString(); // hw 46#1 //hw 44#3
        return desc; // hw 46#1
    }
	// Gives the assassin a base strength increase per turn // hw46#moreThinking
	public void passive() {// hw46#moreThinking
		System.out.println("Strength increased by 5."); // hw46#moreThinking
		strength += 5; // hw46#moreThinking
		
	}		
}	