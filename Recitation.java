import java.util.Arrays;
import java.util.List;

public class Recitation {
	public static void main(String[] args) {
		List<String> myList = Arrays.asList("a1", "a2", "b1", "b2", "c3", "c100", "c56");

		myList
			.stream()
			.filter(s -> s.startsWith("c"))
			.map(String::toUpperCase)
			.sorted()
			.forEach(System.out::println); // forEach is the terminating
	}
}