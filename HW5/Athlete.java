/**
 * Class to represent an Athlete.
 * @author CS1331 TAs
 * @version 13.3.1
 * @param <T> A subtype of Athlete
 */
public class Athlete<T> implements AthleteListInterface {
    private String name;
    private int energy;
    private int strength;
    private Athlete[] backingArray;
    private static int size = 0;

    /**
     * Public constructor for Athlete. Takes in a name, energy, and strength.
     * @param name Name of the athlete.
     * @param energy Athlete's initial energy.
     * @param strength Athlete's initial strength.
     */
    public Athlete(String name, int energy, int strength) {
        this.name = name;
        this.energy = energy;
        this.strength = strength;
    }
    /**
     * Public constructor for Athlete.
     * Initializes the backing array
     */
    public Athlete() {
        backingArray = new Athlete[INITIAL_CAPACITY];
    }
    /**
     * Public constructor for Athlete. Takes in only a name, and invokes
     * the other constructor with inital energy 15 and initial strength 5.
     * @param name Name of the athlete.
     */
    public Athlete(String name) {
        this(name, 15, 5);
    }
    /**
     * Getter for name.
     * @return Name of the athlete.
     */
    public String getName() {
        return name;
    }
    /**
     * Getter for energy.
     * @return Energy of the athlete.
     */
    public int getEnergy() {
        return energy;
    }
    /**
     * Getter for strength.
     * @return Strength of the athlete.
     */
    public int getStrength() {
        return strength;
    }
    @Override
    public void add(Athlete athle) {
        if (athle == null) {
            throw new IllegalArgumentException("Athlete cannot be null");
        }
        if (size == backingArray.length) {
            int newSize = backingArray.length * 2;
            Athlete[] newArray = new Athlete[newSize];
            for (int i = 0; i < size; i++) {
                newArray[i] = backingArray[i];
            }
            backingArray = newArray;
            newArray = null;
        } else {
            backingArray[size] = athle;
            size++;
        }
    }
    @Override
    public Athlete remove(int index) {
        checkIndex(index);
        Athlete value = backingArray[index];
        for (int i = index; i < backingArray.length - 1; i++) {
            backingArray[i] = backingArray[i + 1];
        }
        backingArray = fixArray(((backingArray.length) - 1));
        size--;
        return value;
    }
    // Helper method to take care the duplicated value in
    // array
    // Return the new array
    private Athlete[] fixArray(int newSize) {
        Athlete[] newArray = new Athlete[newSize];
        for (int i = 0; i < newSize; i++) {
            newArray[i] = backingArray[i];
        }
        backingArray = newArray;
        newArray = null;
        return backingArray;
    }
    @Override
    public Athlete get(int index) {
        checkIndex(index);
        return backingArray[index];
    }
    @Override
    public void clear() {
        Athlete[] newArray = new Athlete[INITIAL_CAPACITY];
        backingArray = newArray;
        size = 0;
    }
    @Override
    public int size() {
        int count = 0;
        for (int i = 0; i < backingArray.length; i++) {
            if (backingArray[i] != null) {
                count++;
            }
        }
        return count;
    }
    @Override
    public boolean isEmpty() {
        int count = 0;
        for (int i = 0; i < backingArray.length; i++) {
            if (backingArray[i] != null) {
                count++;
                return false;
            }
        }
        return true;
    }
    @Override
    public void train(int index) {
        checkIndex(index);
        Athlete athle = backingArray[index];
        athle.train();
    }
    @Override
    public void rest(int index) {
        // if(index < 0 || index >= backingArray.length) {
        //     throw new IndexOutOfBoundsException("Index out of bound");
        // }
        checkIndex(index);
        Athlete athle = backingArray[index];
        athle.rest();
    }
    @Override
    public Athlete[] asArray() {
        int count = 0;
        for (int i = 0; i < backingArray.length; i++) {
            if (backingArray[i] != null) {
                count++;
            }
        }
        return finishedArray(count);
    }
    // Helper method that help to handle the null elements
    private Athlete[] finishedArray(int newSize) {
        Athlete[] newArray = new Athlete[newSize];
        for (int i = 0; i < newSize; i++) {
            newArray[i] = backingArray[i];
        }
        backingArray = newArray;
        newArray = null;
        return backingArray;
    }
    /**
     * Trains the athlete. Increases strength by one, depletes energy by the
     * value of the old strength. You need to fix this method to disallow
     * overtraining of an Athlete as such: if energy < strength,
     * throw an OvertrainedAthleteException.
     *@throws OvertrainedAthleteException Throw error message when the energy
     *less then the strength or the energy is negative value.
     */
    public void train() {
        try {
            if (energy < strength) {
                throw new OvertrainedAthleteException("Energy < Strength");
            }
        } catch (OvertrainedAthleteException o) {
            System.out.println(o.getMessage());
        }
        energy -= strength;
        strength++;
        try {
            if (energy < 0) {
                throw new OvertrainedAthleteException("Negative Energy!");
            }
        } catch (OvertrainedAthleteException o) {
            System.out.println(o.getMessage());
        }
    }
    /**
     * Rests the athlete. Increases the energy by 5.
     */
    public void rest() {
        energy += 5;
    }
    /**
     * toString implementaton for Athlete. Returns something like:
     * "Athlete: Jimmy, energy: 5, strength: 5".
     * @return String representation of Athlete.
     */
    public String toString() {
        return String.format("Athlete: %s, energy: %d, "
            + "strength: %d", name, energy, strength);
    }
    /**
    * Helper method to check for the index
    * if the index if less than 0 or greater or the length of array
    * it should the exception.
    *@param index Take in index
    *@throws IndexOutOfBoundsException if the index is less than zero or is
    *greater than or equal to the number of elements in the AthleteList.
    */
    private void checkIndex(int index) throws IndexOutOfBoundsException {
        if (index < 0 || index >= backingArray.length) {
            throw new IndexOutOfBoundsException("Index out of bound");
        }
    }
}
