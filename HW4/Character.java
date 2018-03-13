import java.util.Random;
/**
*   Character class, that store all the information of the character
*@author tnguyen452
*@version 1.0
*/
public abstract class Character {
    private String name;
    private int level;
    private int strength;
    private int dexterity;
    private int intelligence;
    private int wisdom;
    private int health;
    private boolean isDead;

    /**
    *   Character constructor
    *@param name That take in the String store name of character
    *@param seed That take in an int value of seed
    *
    */
    public Character(String name, int seed) {
        this.name = name;
        setLevel(1);
        setHealth(5);
        Random rand = new Random(seed);
        setStrength(rand.nextInt(6) + 1);
        setDexterity(rand.nextInt(6) + 1);
        setIntelligence(rand.nextInt(6) + 1);
        setWisdom(rand.nextInt(6) + 1);
    }

    /**
    *   Character constructor
    *@param name That take in the String store name of character
    *@param level That take in an int value of level
    *@param strength That take in an int value of strength
    *@param dexterity That take in an int value of dexterity
    *@param intelligence That take in an int value of intelligence
    *@param wisdom That take in an int value of wisdom
    *
    */
    public Character(String name, int level,
                     int strength, int dexterity,
                     int intelligence, int wisdom) {
        this.name = name;
        this.level = level;
        this.strength = strength;
        this.dexterity = dexterity;
        this.intelligence = intelligence;
        this.wisdom = wisdom;
        setHealth(this.level * 5);
        if (health <= 0) {
            setIsDead(true);
            setHealth(0);
        }
    }

    /**
    *   Getter method for name
    *@return Return the name of the Character
    */
    public String getName() {
        return name;
    }

    /**
    *   Getter method for level
    *@return Return the level of the character
    */
    public int getLevel() {
        return level;
    }

    /**
    *   Setter method for level
    *@param level  Take in the level
    */
    public void setLevel(int level) {
        this.level = level;
    }

    /**
    *   Getter method for strength
    *@return Return the strength of the character
    */
    public int getStrength() {
        return strength;
    }

    /**
    *   Setter method for strength
    *@param strength  Take in the strength
    */
    public void setStrength(int strength) {
        this.strength = strength;
    }

    /**
    *   Getter method for Dexterity
    *@return Return the dexterity of the Character
    */
    public int getDexterity() {
        return dexterity;
    }

    /**
    *   Setter method for dexterity
    *@param dexterity  Take in the dexterity
    */
    public void setDexterity(int dexterity) {
        this.dexterity = dexterity;
    }

    /**
    *   Getter method for Intelligence
    *@return Return the intelligence of the character
    */
    public int getIntelligence() {
        return intelligence;
    }

    /**
    *   Setter method for intelligence
    *@param intelligence  Take in the intelligence
    */
    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }

    /**
    *   Getter method for wisdom
    *@return Return the wisdom of the character
    */
    public int getWisdom() {
        return wisdom;
    }

    /**
    *   Setter method for wisdom
    *@param wisdom  Take in the wisdom
    */
    public void setWisdom(int wisdom) {
        this.wisdom = wisdom;
    }

    /**
    *   Getter method for health
    *@return Return the health of the Character
    */
    public int getHealth() {
        return health;
    }

    /**
    *   Setter method for health
    *@param health  Take in the health
    */
    public void setHealth(int health) {
        this.health = health;
    }

    /**
    *   Getter method for isDead
    *@return Return to determine if the character dead or not
    */
    public boolean getIsDead() {
        return isDead;
    }

    /**
    *   Setter method for isDead
    *@param isDead  Take in the isDead
    */
    public void setIsDead(boolean isDead) {
        this.isDead = isDead;
    }

    /**
    *Abstract method name levelUp() of Character class
    *
    */
    public abstract void levelUp();

    /**
    *Abstract method name attack() of Character class
    *@param c Take in the character
    */
    public abstract void attack(Character c);

    /**
    *Abstract method name toString() of Character class
    *@return Return the String back
    */
    public abstract String toString();

}
