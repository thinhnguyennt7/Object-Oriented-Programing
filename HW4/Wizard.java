/**
*Fighter class that implement all the method in Character
*abstract class. Extens class Character
*@author tnguyen452
*@version 1.0
*/
public class Wizard extends Character {
    private Character c;
    private int intelligence;

    /**
    *The fighter constructor take in two parameter, corresponding with each of
    *the constructors of the superclass
    *@param name Take in the name of the fighter
    *@param seed Take in the number of seed
    */gitString name, int seed) {
        super(name, seed);
    }

    /**
    *The Fighter constructor take in six parameters, corresponding with each of
    *the constructors of the superclass
    *@param name Take in the name of the fighter
    *@param level Take in the level of the fighter
    *@param strength Take in the strength value
    *@param dexterity Take in the dexterity value
    *@param intelligence Take in the intelligence value
    *@param wisdom Take in the wisdom value
    */
    public Wizard(String name, int level, int strength, int dexterity,
                    int intelligence, int wisdom) {
            super(name, level, strength, dexterity, intelligence, wisdom);
    }

    @Override
    public void attack(Character character) {
        character.setHealth((character.getHealth() - 4) + intelligence);
        if (character.getIsDead()) {
            System.out.println("Cannot attack a dead character");
        }
    }

    @Override
    public void levelUp() {
        c.setLevel(c.getLevel() + 1);
        c.setHealth(5 * c.getLevel());
        c.setIntelligence(c.getIntelligence() + 2);
        c.setWisdom(c.getWisdom() + 1);
        c.setStrength(c.getStrength() + 1);
        c.setDexterity(c.getDexterity() + 1);
    }

    /**
    *The multiAttack method of the Wizard class
    *
    *@param character Take in a character
    *
    */
    public void multiAttack(Character character) {

        // Implement this one
		// for(Character newChar : character) {
        //           newChar =
        //       }
        if (c.getIsDead()) {
            System.out.println("Cannot damage a dead character");
        }
    }

    @Override
    public String toString() {
        return "Level (" + c.getLevel() + ") wizard named (" + c.getName()
            + ") with (" + c.getStrength() + ") strength, (" + c.getDexterity()
            + ") dexterity, (" + c.getIntelligence() + ") intelligence, and ("
            + c.getWisdom() + ") wisdom.";
    }
}