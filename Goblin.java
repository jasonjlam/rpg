public class Goblin extends Monster { // hw44#4
    public Goblin(){ // hw44#4
        // Constructs a goblin
        // Calls the super as to construct a Monster, just with default stats
        super();
        // Changes up the stats to make it unique
        strength = (int)(Math.random() * 60) + 0;
        health = 100;
        attack = 1; 
        defense = 10;       
    }
    
    public String toString(){ // hw44#4 // hw 46#2
        // Adds a quote to the description of the class.
        String desc = ""; // hw 46#2
        desc += "Goblin: More annoying than dangerous."; // hw 46#2
        // Calls upon the toString of the superclass character in order to print out a unique quote, and then combine it with more traditional statistics present in the superclass.
        desc += super.toString(); // hw 46#2 //hw 44#3
        return desc;
    }
}	