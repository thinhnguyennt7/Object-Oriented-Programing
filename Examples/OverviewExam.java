// Predicate: Statement has a true or false
// Predicate<T> is the functional interface. Has a single abstact method
// Predicate is an object that has AND method, OR method, NEGATE method, TEST method
import java.util.function.Predicate;

class Person {
	public String name;
	public int age;
	public Person(String name, int age) {
		this.name = name; this.age = age;
	}
}

public class OverviewExam {

	public static void main(String[] args) {
		//Anonymous inner class
		Predicate<Person> isOld = new Predicate<Person>() {
			public boolean test(Person p) {
				return p.age > 50;
			}
		};
	}
}