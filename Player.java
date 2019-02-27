public class Player extends Protagonist {
    public void specialize(){
    // // Does not reset (as to stack buffs!)
        attack *= 1.3;
        defense /= 1.3;
		passive();
    }
    
    public Player (String name) {
        super(name);
    }
    
    public static void main (String[] commandLine) {
        Player w = new Player("huh");
    }
}