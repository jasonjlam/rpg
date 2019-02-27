public class Monster extends Character {
    public Monster(){
        // Constructs a monster
        strength = (int)(Math.random() * 45) + 20;
        health = 150;
        attack = 1; 
        defense = 20; 
    }
    
    // Unique part of monster; increases stats to become a boss
    public void bossify() {
        attack *= 1.2;
        defense *= 1.2;
        health *= 1.2;
    }
}	