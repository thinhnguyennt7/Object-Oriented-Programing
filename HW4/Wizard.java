/**
*Fighter class that implement all the method in Character
*abstract class. Extens class Character
*@author tnguyen452
*@version 1.0
*/
public class Wizard extends Character {
    /**
    *The fighter constructor take in two parameter, corresponding with each of
    *the constructors of the superclass
    *@param name Take in the name of the fighter
    *@param seed Take in the number of seed
    */
    public Wizard(String name, int seed) {
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
    public void attack(Character c) {
        if (c.getIsDead()) {
            System.out.println("Cannot attack a dead character");
        } else {
            c.setHealth(c.getHealth() - (4 + c.getIntelligence()));
        }
    }

    @Override
    public void levelUp() {
        super.setLevel(super.getLevel() + 1);
        super.setHealth(5 * super.getLevel());
        super.setIntelligence(super.getIntelligence() + 2);
        super.setWisdom(super.getWisdom() + 1);
        super.setStrength(super.getStrength() + 1);
        super.setDexterity(super.getDexterity() + 1);
    }

    /**
    *The multiAttack method of the Wizard class
    *
    *@param c Take in an array of characters
    *
    */
    public void multiAttack(Character ... c) {
        for (Character cha : c) {
            if (cha.getIsDead()) {
                System.out.println("Cannot damage a dead character");
            } else {
                cha.setHealth(cha.getHealth() - (2 + cha.getIntelligence()));
            }
        }
    }

    @Override
    public String toString() {
        return "Level " + super.getLevel() + " wizard named " + super.getName()
                + " with " + super.getStrength() + " strength, "
                + super.getDexterity() + " dexterity, "
                + super.getIntelligence() + " intelligence, and "
                + super.getWisdom() + " wisdom.";
    }
}