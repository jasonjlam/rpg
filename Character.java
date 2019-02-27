public class Character{
    
    //modified fields from public to protected
    protected int health; // hw 3C#1/2
    protected int strength; // hw 3C#1/2
    protected double attack; // hw 3C#1/2
    // public double attackNormal;
    protected int defense; // hw 3C#1/2
    // public int defenseNormal;
    // If the character is dead, takes immediate action (usually by ending game)
    public boolean isAlive(){ // hw3C#1/2
        return health > 0;
    }
    // Necessary for calculating armor and damage taken
    private int getDefense(){ // hw3C#1/2
        return defense;
    }
    // The actual changing of the HP value
    private void lowerHP(int dmg){ // hw 3C#1/2
        health -= dmg;
    }
    // Damage calculation
    public int attack(Character target){ // hw 3C#1/2 //hw 3E#0 //hw 42#2
        int damage = (int)((strength * attack) - target.getDefense());
        target.lowerHP(damage);
        return damage;
    //hw 42#2 For this method, the variable type is defined at compile time by the compiler,
    //hw 42#2 and the object time is defined at run time by the JVM.
    // hw 42#2 in other words what can be contained in the variable is defined at compile time,
    // hw 42#2 while what is contained in the variable is determined at run time.
    }
    // Gives a brief overview of the character, namely its stats.
    public String toString() { // hw3C#1/2 // hw 46#1/2
        String desc = "";
        desc += System.lineSeparator() + "ATK: " + attack;
        desc += System.lineSeparator() + "HP: " + health;
        desc += System.lineSeparator() + "DEF: " + defense;
        desc += System.lineSeparator() + "STR: " + strength;
        return desc;
    }
}