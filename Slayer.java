public class Slayer extends Protagonist { // hw44#3
    public Slayer(String name){ // hw44#3
        // Constructs a Guardian class
        // Calls the super as to construct a Protagonist, just with default stats
        // Note it keeps the name of the class along with player input to combine them in order to make a unique name
        super("Slayer-" + name);
        // Changes up the stats to make it unique
        strength = 45;
        health = 15000;
        attack = BASE_ATK = 1;
        defense = BASE_DEF = 15;
    }
    public String toString(){ // hw44#3 // hw 46#1
        // Adds a quote to the description of the class.
        String desc = ""; // hw 46#1
        desc += name; // hw 46#1
        desc += ": No judge or jury. Just the executioner."; // hw 46#1
        // Calls upon the toString of the superclass character in order to print out a unique quote, and then combine it with more traditional statistics present in the superclass.
        desc += super.toString(); // hw 46#1 //hw 44#3
        return desc; // hw 46#1
    }
	// Gives the slayer lifesteal
	public void passive() {
		System.out.println("Healed for " + strength * attack * .1 + ".");
		health += strength * attack * .1;
		
	}
}