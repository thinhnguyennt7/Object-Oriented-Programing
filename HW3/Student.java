/**
* This function will determine if the amount of money student has able to buy
* the food or not. If it able then it will decrement after the student buy.
* And print out the status if theu able to buy food or not. Also it will print
* out the information of student and how much they have left in their account
* store in BuzzCard class.
*
* @author tnguyen452
* @version 1.0
*/
public class Student {
    private BuzzCard card;
    private String name;
    private int id;

    /**
    * The constructor of the student class
    *
    *@param card Take in the information
    *@param name Take in the name of the Student
    *@param id Take in the student id of the Student
    */
    public Student(BuzzCard card, String name, int id) {
        this.card = card;
        this.name = name;
        this.id = id;
    }
    /**
     * Getter method for the buzz card information.
     *
     * @return The student card information from BuzzCard class
     */
    public BuzzCard getCard() {
        return card;
    }

    /**
     * Getter method to get the name of the student
     *
     * @return The name of the student that entered.
     */
    public String getName() {
        return name;
    }

    /**
     * Getter method to get the id of the student
     *
     * @return The id of the student that entered.
     */
    public int getId() {
        return id;
    }
    /**
    *   Which will allow student to buy items from Brittian Dining Hall using
    *   meal swipes. If the student does not have the amount needed to buy them
    *   item, print to the console don't have enough amount.
    *
    *@param item represent the item that student want to buy from Dinning Hall
    *
    */
    public void buyBrittainMealSwipes(BrittainItem item) {
        if (card.getMealSwipes() < item.getMealSwipes()) {
            System.out.println("You do not have the amount"
                + " to buy this item :(");
        } else {
            card.setMealSwipes(card.getMealSwipes() - item.getMealSwipes());
        }
    }

    /**
    *   Which will allow student to buy items from Brittian Dining Hall using
    *   BuzzFunds. If the student does not have the amount needed to buy them
    *   item, print to the console don't have enough amount.
    *
    *@param item represent the item that student want to buy from Brittian
    *            Dinning Hall
    *
    */
    public void buyBrittainBuzzFund(BrittainItem item) {
        if (card.getBuzzFunds() < item.getBuzzFunds()) {
            System.out.println("You do not have the amount"
                + " to buy this item :(");
        } else {
            card.setBuzzFunds(card.getBuzzFunds() - item.getBuzzFunds());
        }
    }
    /**
    *   Which will allow student to buy items from Burdells using BuzzFunds
    *   If the student does not have the amount needed to buy them
    *   item, print to the console don't have enough amount.
    *
    *@param item represent the item that student want to buy from Burdells
    *
    */
    public void buyBurdellsBuzzFunds(BurdellsItem item) {
        if (card.getBuzzFunds() < item.getBuzzFunds()) {
            System.out.println("You do not have the amount"
                + " to buy this item :(");
        } else {
            card.setBuzzFunds(card.getBuzzFunds() - item.getBuzzFunds());
        }
    }

    /**
    *   Which will allow student to buy items from Subway using dining dollars
    *   If the student does not have the amount needed to buy them
    *   item, print to the console don't have enough amount.
    *
    *@param item represent the item that student want to buy from Subway
    *
    */
    public void buySubwayDiningDollars(SubwayItem item) {
        if (card.getDiningDollars() < item.getDiningDollars()) {
            System.out.println("You do not have the amount"
                + " to buy this item :(");
        } else {
            card.setDiningDollars(card.getDiningDollars()
                - item.getDiningDollars());
        }
    }

    /**
    *   Which will allow student to buy items from Subway using BuzzFunds
    *   If the student does not have the amount needed to buy them
    *   item, print to the console don't have enough amount.
    *
    *@param item represent the item that student want to buy from Subway
    *
    */
    public void buySubwayBuzzFunds(SubwayItem item) {
        if (card.getBuzzFunds() < item.getBuzzFunds()) {
            System.out.println("You do not have the amount"
                + " to buy this item :(");
        } else {
            card.setBuzzFunds(card.getBuzzFunds() - item.getBuzzFunds());
        }
    }

    /**
    *   Which will return the string representation of the student's information
    *   in the format.
    *
    *@return String return the string
    *
    */
    public String toString() {
        return "Student named (" + name + ") " + "with ID: (" + id + ") "
                + card;
    }
}