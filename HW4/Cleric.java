/**
*Fighter class that implement all the method in Character
*abstract class. Extens class Character
*@author tnguyen452
*@version 1.0
*/
public class Cleric extends Character {

    /**
    *The fighter constructor take in two parameter, corresponding with each of
    *the constructors of the superclass
    *@param name Take in the name of the fighter
    *@param seed Take in the number of seed
    */
    public Cleric(String name, int seed) {
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
    public Cleric(String name, int level, int strength, int dexterity,
                    int intelligence, int wisdom) {
            super(name, level, strength, dexterity, intelligence, wisdom);
    }

    @Override
    public void attack(Character c) {
        if (c.getIsDead()) {
            System.out.println("Cannot attack a dead character");
        } else {
            c.setHealth(c.getHealth() - (6 + c.getWisdom()));
        }
    }

    @Override
    public void levelUp() {
        super.setLevel(super.getLevel() + 1);
        super.setHealth(5 * super.getLevel());
        super.setWisdom(super.getWisdom() + 2);
        super.setStrength(super.getStrength() + 1);
        super.setIntelligence(super.getIntelligence() + 1);
        super.setDexterity(super.getDexterity() + 1);
    }

    /**
    *The heal method for the Cleric class
    *
    *@param c Take in the character
    */
    public void heal(Character c) {
        if (c.getIsDead()) {
            System.out.println("Cannot heal a dead character");
        } else {
            if ((c.getHealth() + (6 + c.getWisdom())) < (5 * c.getHealth())) {
                c.setHealth(c.getHealth() + (6 + c.getWisdom()));
            }
        }
    }

    @Override
    public String toString() {
        return "Level " + super.getLevel() + " cleric named " + super.getName()
                + " with " + super.getStrength() + " strength, "
                + super.getDexterity() + " dexterity, "
                + super.getIntelligence() + " intelligence, and "
                + super.getWisdom() + " wisdom.";
    }
}