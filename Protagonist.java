public abstract class Protagonist extends Character {
    protected String name;
    // base variables as to normalize and specialize, and then return to their default values
        protected double BASE_ATK;
        protected int BASE_DEF;

    public Protagonist(String name){ 
        // initializing a default Protagonist wiht a single parameter
        this.name = name;
        strength = 35;
        health = 150;
        attack = BASE_ATK = 1;
        defense = BASE_DEF = 20;
    }
    // useful for getting names
    public String getName(){
        return name;
    }
    
    // adds a risk factor to battles
    public abstract void specialize();
    // // Does not reset (as to stack buffs!)
        // attack *= 1.3;
        // defense /= 1.3;
		// passive();
    // }
    
    // resets any stat changes
    public void normalize(){
        attack = BASE_ATK;
        defense = BASE_DEF;
		passive();
    }
	// passive  for protagonists
	public void passive() {
		
	}
    
}	