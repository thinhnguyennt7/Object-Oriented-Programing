import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.util.Random;

/**
 * This function will play the game between two players where they try to shot
 * all the ship
 * of the opponent side. Whoever lose all the ship will lose, and whoever kill
 * all the ship
 * of the opponent side will be winner.
 *
 * @author tnguyen452
 * @version 1.0
 */
public class Battleship {

    /**
    * This function will control the board and print out the current board
    *
    * @param n - The size of the board
    * @return char[][] - Return the board of batter ship
    **/
    public static char[][] initBoard(int n) {
        // YOUR CODE BELOW: initializes a board of size n * n
        char[][] newGrid = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                newGrid[i][j] = '~';
            }
        }
        return newGrid;
    }
    /**
    * This function will control the board and print out the current board
    *
    * @param playerTurn - Give the player who turn
    * @param board - The 2D array board of the battle
    * @param hitsLeft - The number of the ship has left
    **/
    public static void printBoard(int playerTurn, char[][] board,
        int hitsLeft) {
        System.out.printf("Player %d (%d hits left):\n", playerTurn, hitsLeft);
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (j != board.length - 1) {
                    System.out.print(board[i][j]);
                    System.out.print(' ');
                } else {
                    System.out.print(board[i][j]);
                }
            }
            System.out.println();
        }
    }
    /**
    * This function will returns back the number hitleft
    *
    * @param board - The 2D array board of the battle
    * @param target - The string of the guessing location
    * @param shipLocations - The array that store location of the all ships in
    * the component side
    * @param hitsLeft - The number of the ship has left
    * @return int The number of ship has left of the opponent side
    **/
    public static int fireMissile(char[][] board, String target,
        String[] shipLocations, int hitsLeft) {
        int[] coord = convertLocation(target);

        if (isShip(target, shipLocations)) {
            if (board[coord[0]][coord[1]] == 'X') {
                System.out.printf("%s has already been chosen\n", target);
            } else {
                board[coord[0]][coord[1]] = 'X';
                System.out.println("Hit!");
                hitsLeft = hitsLeft - 1;
            }
        } else {
            if (board[coord[0]][coord[1]] == 'O') {
                System.out.printf("%s has already been chosen\n", target);
            } else {
                board[coord[0]][coord[1]] = 'O';
                System.out.println("Miss!");
            }
        }
        return hitsLeft;
    }
    /**
    * This function will returns true if location is ship.
    * Otherwise, false
    *
    * @param target - The location that user guessed
    * @param shipLocations - The array store all the location of opponent ship
    * location
    * @return boolean - The true or false depend on the if there is location
    * of the ship
    **/
    public static boolean isShip(String target, String[] shipLocations) {
        boolean found = false;
        for (int i = 0; i < shipLocations.length && !found; i++) {
            if (target.equals(shipLocations[i])) {
                found = true;
            } else {
                found = false;
            }
        }
        return found;
    }
    /**
    * This function will returns the new location inside an array
    *
    * @param coordinate - The string of the location that user has guessed
    * @return int[] - Return back a new row and col inside of an array
    *
    **/
    public static int[] convertLocation(String coordinate) {
        coordinate = coordinate.toLowerCase();
        char firstChar = coordinate.charAt(0);
        int secondChar = Integer.parseInt("" + coordinate.charAt(1));
        int letter = 97;
        int convertChar = (int) firstChar;
        int row = convertChar - letter;
        int col = secondChar - 1;
        int[] list = new int[2];
        list[0] = row;
        list[1] = col;
        return list;
    }
    /**
    * A main public method function to run the program
    *
    * @param args taking value when enter at command line
    */
    public static void main(String[] args) {
        int fileInd = (args.length > 0) ? Integer.parseInt(args[0])
            : new Random().nextInt(4);

        String filename = "game" + fileInd + ".txt";

        try {
            Scanner fileReader = new Scanner(new File(filename));
            Scanner inputScanner = new Scanner(System.in);

            int numTimes = fileReader.nextInt();
            fileReader.nextLine();
            String getString = fileReader.nextLine();
            String[] shipLocate1 = getString.split(" ");
            String getString1 = fileReader.nextLine();
            String[] shipLocate2 = getString1.split(" ");

            int hitsLeft1 = shipLocate1.length;
            int hitsLeft2 = shipLocate2.length;
            boolean flag = true;
            int playerTurn = 1;
            char[][] ship1Grid = initBoard(numTimes);
            char[][] ship2Grid = initBoard(numTimes);

            while (flag) {
                if (playerTurn == 1) {
                    printBoard(playerTurn, ship1Grid, hitsLeft1);
                    System.out.printf("Enter missile location: ",
                        playerTurn);
                    String guessLocate1 = inputScanner.nextLine();
                    hitsLeft1 = fireMissile(ship1Grid, guessLocate1,
                    shipLocate2, hitsLeft1);
                    printBoard(playerTurn, ship1Grid, hitsLeft1);
                    System.out.print("\n\n");
                    System.out.println("----------");
                    System.out.print("\n\n");
                    if (hitsLeft1 == 0) {
                        System.out.printf("The winner is Player %d\n",
                            playerTurn);
                        flag = false;
                    }
                    playerTurn = 2;
                } else {
                    printBoard(playerTurn, ship2Grid, hitsLeft2);
                    System.out.printf("Enter missile location: ",
                        playerTurn);
                    String guessLocate2 = inputScanner.nextLine();
                    if (isShip(guessLocate2, shipLocate1)) {
                        hitsLeft2 = fireMissile(ship2Grid, guessLocate2,
                        shipLocate1, hitsLeft2);
                    } else {
                        hitsLeft2 = fireMissile(ship2Grid, guessLocate2,
                        shipLocate1, hitsLeft2);
                    }
                    printBoard(playerTurn, ship2Grid, hitsLeft2);
                    System.out.print("\n\n");
                    System.out.println("----------");
                    System.out.print("\n\n");
                    if (hitsLeft2 == 0) {
                        System.out.printf("The winner is Player %d\n",
                            playerTurn);
                        flag = false;
                    }
                    playerTurn = 1;
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Make sure that " + filename
                + " is in the current directory!");
        }
    }
}