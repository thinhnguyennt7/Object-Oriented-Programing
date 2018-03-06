/**
*Rogue class that implement all the method in Character
*abstract class. Extens class Character
*@author tnguyen452
*@version 1.0
*/
public class Rogue extends Character {
    private int dexterity;
    private Character c;

    /**
    *The fighter constructor take in two parameter, corresponding with each of
    *the constructors of the superclass
    *@param name Take in the name of the fighter
    *@param seed Take in the number of seed
    */
    public Rogue(String name, int seed) {
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
    public Rogue(String name, int level, int strength, int dexterity,
                    int intelligence, int wisdom) {
            super(name, level, strength, dexterity, intelligence, wisdom);
    }

    @Override
    public void attack(Character character) {
        character.setHealth((character.getHealth() - 6) + dexterity);
        if (character.getIsDead()) {
            System.out.println("Cannot attack a dead character");
        }
    }

    @Override
    public void levelUp() {
        c.setLevel(c.getLevel() + 1);
        c.setHealth(5 * c.getLevel());
        c.setDexterity(c.getDexterity() + 3);
        c.setIntelligence(c.getIntelligence() + 2);
        c.setWisdom(c.getWisdom() + 2);
        c.setStrength(c.getStrength() + 2);
    }

    @Override
    public String toString() {
        return "Level (" + c.getLevel() + ") rogue named (" + c.getName()
            + ") with + (" + c.getStrength() + ") strength, ("
            + c.getDexterity() + ") dexterity, + (" + c.getIntelligence()
            + ") intelligence, and (" + c.getWisdom() + ") wisdom.";
    }
}