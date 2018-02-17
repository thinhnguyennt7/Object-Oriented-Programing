/**
* This function will take in the amount of money student has such as mealSwipes
* dinning Dollars and buzzFund. This function also get and set method for them
*
* @author tnguyen452
* @version 1.0
*/
public class BuzzCard {

    private int mealSwipes;
    private double diningDollars;
    private double buzzFunds;

    /**
    * This is the construction of BuzzCard that will assign value to the
    * the instance variable
    *
    * @param mealSwipes That take in an int value store total amount of meal
    * @param diningDollars That take in the double value of dinning
    * @param buzzFunds That take in the double value of buzzFunds
    *
    */
    public BuzzCard(int mealSwipes, double diningDollars, double buzzFunds) {
        this.mealSwipes = mealSwipes;
        this.diningDollars = diningDollars;
        this.buzzFunds = buzzFunds;
    }

    /**
     * Getter method for the mealSwipe.
     * @return The amount of money in the mealSwipe
     */
    public int getMealSwipes() {
        return mealSwipes;
    }

    /**
     * Setter method for the Meal Swipes
     * @param mealSwipes Get the amount of mealSwipes
     */
    public void setMealSwipes(int mealSwipes) {
        this.mealSwipes = mealSwipes;
    }
    /**
     * Getter method for the dinning dollars.
     * @return The amount of money of the dinning.
     */
    public double getDiningDollars() {
        return diningDollars;
    }

    /**
     * Setter method for the Dinning Dollars
     * @param diningDollars Get the amount of dinningDollars
     */
    public void setDiningDollars(double diningDollars) {
        this.diningDollars = diningDollars;
    }

    /**
     * Getter method for the buzzfunds
     * @return The amount of money in the buzzfunds.
     */
    public double getBuzzFunds() {
        return buzzFunds;
    }

    /**
     * Setter method for the Buzz Funds
     * @param buzzFunds Get the amount of buzzFunds
     */
    public void setBuzzFunds(double buzzFunds) {
        this.buzzFunds = buzzFunds;
    }

    /**
    * Which will return the string representation of the student's information
    * in the format.
    *
    *@return String return the string
    *
    */
    public String toString() {
        return "BuzzCard balance with Dining Dollars: (" + diningDollars + "), "
                    + "BuzzFunds: (" + buzzFunds + "), " + "Meal Swipes: ("
                        + mealSwipes + ")";
    }
}