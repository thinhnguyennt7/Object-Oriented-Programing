import java.util.Random;
import java.util.Scanner;

/**
 * This function will create a game called guessing word same as hangman.
 * After run this function, people will need to provide a single character
 * this function will determine if that character match with any character
 * inside the String provided. If the user make five incorrect guess then they
 * will lose, otherwise they will win.
 *
 * @author tnguyen452
 * @version 1.0
 */
public class WordGuess {
    static final String[] CANDIDATES = {"cat", "dad", "dog", "mom", "rat"};
    /**
    * A main public method fucntion to run the program
    * @param args taking value when enter at command line
    */
    public static void main(String[] args) {

        String secretWord = args.length > 0
            ? CANDIDATES[Integer.parseInt(args[0])]
            : CANDIDATES[new Random().nextInt(CANDIDATES.length)];

        int totalAttemp = 5;
        char scret;
        String missingLetter = "";
        boolean flag = true;
        String dash = "";

        // Instantiation new Object
        Scanner getWord = new Scanner(System.in);
        for (int i = 0; i < secretWord.length(); i++) {
            dash = dash + "_";
        }
        StringBuilder current = new StringBuilder(dash);

        while ((totalAttemp > 0) && (flag)) {

            System.out.printf("Missed letters (%d left): %s\n",
                    totalAttemp, missingLetter);
            System.out.printf("Current guess: %s\n", current);
            System.out.printf("Guess a letter: ");

            // Keep getting character from user
            scret = getWord.next().charAt(0);
            System.out.println();

            // Get the index of the matching character with String
            int index = secretWord.indexOf(scret);

            if (index >= 0) {

                // Get all the index on the string that match with the character
                while (index >= 0) {
                    current.setCharAt(index, secretWord.charAt(index));
                    index = secretWord.indexOf(scret, index + 1);
                }

                // Comparing builderString with the String object
                if (current.toString().equals(secretWord.toString())) {

                    System.out.printf("Missed letters: %s\n", missingLetter);
                    System.out.printf("Final guess: %s\n", current);
                    System.out.println("Congratulations! You got it!");
                    flag = false;
                }
            } else {

                totalAttemp = totalAttemp - 1;

                missingLetter = missingLetter + scret;

                if (totalAttemp == 0) {
                    // Print the console
                    System.out.printf("Missed letters: %s\n", missingLetter);
                    System.out.printf("Final guess: %s\n", current);
                    System.out.println("Sorry, too many misses."
                        + " The secret word was " + secretWord);
                }
            }
        }
    }
}