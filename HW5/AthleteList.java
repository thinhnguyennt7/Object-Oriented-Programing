/**
 * Class to represent an AthleteList
 * @author Tnguyen452
 * @version 14.4.2
 * @param <T> A subtype of Athlete
 */
public class AthleteList<T extends Athlete> implements AthleteListInterface<T> {

    private T[] backingArray;
    private static int size = 0;

    /**
     * Public constructor for Athlete.
     * Initializes the backing array
     */
    public AthleteList() {
        backingArray = (T[]) new Athlete[INITIAL_CAPACITY];
    }

    @Override
    public void add(T t) {
        if (t == null) {
            throw new IllegalArgumentException("Athlete cannot be null");
        }
        if (size == backingArray.length) {
            int newSize = backingArray.length * 2;
            T[] newArray = (T[]) new Athlete[newSize];
            for (int i = 0; i < size; i++) {
                newArray[i] = (T) backingArray[i];
            }
            backingArray = newArray;
        }
        backingArray[size] = t;
        size++;
    }

    @Override
    public T remove(int index) {
        checkIndex(index);
        T value = (T) backingArray[index];
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
    private T[] fixArray(int newSize) {
        T[] newArray = (T[]) new Athlete[newSize];
        for (int i = 0; i < newSize; i++) {
            newArray[i] = (T) backingArray[i];
        }
        backingArray = newArray;
        return (T[]) backingArray;
    }

    @Override
    public T get(int index) {
        checkIndex(index);
        return (T) backingArray[index];
    }

    @Override
    public void clear() {
        T[] newArray = (T[]) new Athlete[INITIAL_CAPACITY];
        backingArray = newArray;
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void train(int index) {
        checkIndex(index);
        Athlete athle = (Athlete) backingArray[index];
        athle.train();
    }

    @Override
    public void rest(int index) {
        checkIndex(index);
        Athlete athle = (Athlete) backingArray[index];
        athle.rest();
    }

    @Override
    public T[] asArray() {
        int count = 0;
        for (int i = 0; i < backingArray.length; i++) {
            if (backingArray[i] != null) {
                count++;
            }
        }
        return finishedArray(count);
    }

    // Helper method that help to handle the null elements
    private T[] finishedArray(int newSize) {
        T[] newArray = (T[]) new Athlete[newSize];
        for (int i = 0; i < newSize; i++) {
            newArray[i] = (T) backingArray[i];
        }
        return newArray;
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
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bound");
        }
    }
}