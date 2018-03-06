/**
*	Flighter class that implement all the method in Character
*	abstract class. Extens class Character
*
*
*/
public class Fighter extends Character {
	private int strength;
	private Character c;

	// Implement the constructor from the super class
	public void attack(Character c) {
		c.health = (c.health - 10) + strength;
		if (c.isDead == true) {
			System.out.println("Cannot attack a dead character");
		}
	}

	public void levelUp() {
		c.level ++;
		c.setHealth(5 * c.level);
		c.strength += 2;
		c.dexterity ++;
		c.intelligence ++;
		c.wisdom ++;
	}

	public String toString() {
		return "Level (" + c.level + ")" + "fighter named (" + c.name + ") with (" + c.strength + ") strength, (" + c.dexterity + ") dexterity, (" + c.intelligence + ") intelligence, and (" + c.wisdom + ") wisdom.";
	}
}