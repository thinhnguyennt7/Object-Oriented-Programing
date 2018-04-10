// Predicate: Statement has a true or false
// Predicate<T> is the functional interface. Has a single abstact method
// Predicate is an object that has AND method, OR method, NEGATE method, TEST method
import java.util.function.Predicate;
import java.util.Arrays;
class Person {
	public String name;
	public int age;
	public Person(String name, int age) {
		this.name = name; this.age = age;
	}
	@Override
	public String toString() { return name; }
}

public class OverviewExam {

	public static void main(String[] args) {
		//Anonymous class that implement the Predicate interface
		Predicate<Person> isOld = new Predicate<Person>() { // allow to delay the testing
			public boolean test(Person p) {
				return p.age > 50;
			}
		};	

		// Lamba expression
		// Predicate<Person> isFunky = (Person p) -> {
		Predicate<Person> isFunky = p -> {
			return Arrays.asList("Clinton", "Isbell").contains(p.name.split(" ")[1]);
			// Arrays.asList("Clinton", "Isbell").contains(p.name.split(" ")[1]);
		};

		Person george = new Person("George Clinton", 70);
		Person chalres = new Person("Charles Isbell", 49);
		Person djt = new Person("Donal Trump", 100);

		System.out.printf("%s is old: %s%n", george, isOld.test(george));
		System.out.printf("%s is old: %s%n", chalres, isOld.test(chalres));
		System.out.printf("%s is old: %s%n", djt, isOld.test(djt));

		System.out.printf("%s is funky: %s%n", george, isFunky.test(george));
		System.out.printf("%s is funky: %s%n", chalres, isFunky.test(chalres));
		System.out.printf("%s is funky: %s%n", djt, isFunky.test(djt));

	}
}