public class Guardian extends Protagonist { // hw44#3
    public Guardian(String name){ // hw44#3
        // Constructs a Guardian class
        // Calls the super as to construct a Protagonist, just with default stats
        // Changes up the stats to make it unique'
        // Note it keeps the name of the class along with player input to combine them in order to make a unique name
        super("Guardian-" + name);
        strength = 30;
        health = 200;
        attack = BASE_ATK = 1;
        defense = BASE_DEF = 40;
    }       
    public String toString(){ // hw44#3 // hw 46#1
        // Adds a quote to the description of the class.
        String desc = ""; // hw 46#1
        desc += name; // hw 46#1
        desc += ": The shield is only as strong as the hand that wields it."; // hw 46#1
        // Calls upon the toString of the superclass character in order to print out a unique quote, and then combine it with more traditional statistics present in the superclass.
        desc += super.toString(); // hw 46#1 //hw 44#3
        return desc;
    }
	
	// Gives the assassin a defense increase per turn
	public void passive() {
		defense += 5;
		
	}
}	