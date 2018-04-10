import java.time.LocalDate;
import java.util.ArrayList;

/**
* This is the Quiz Cats class
*@author tnguyen452
*@version 1.0
*/
public class Cats {
	
	/**
	* The driver class
	*@param String[] Take in the args
	*/
	public static void main(String[] args) {
		
		ArrayList<Cat> array = new ArrayList<>();
		array.add(new Cat("A", LocalDate.of(2017,2,2),13));
		array.add(new Cat("B", LocalDate.of(2016,4,6),21));
		array.add(new Cat("C", LocalDate.of(2018,1,9),16));

	}
}