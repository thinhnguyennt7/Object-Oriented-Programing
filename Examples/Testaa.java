import java.util.*;

public class Testaa {

	public static void main(String[] args) {
		List<Integer> collection2 = new ArrayList<>();
		collection2.add(1);
		collection2.add(3);
		collection2.add(9);
		collection2.add(2);

		Collections.sort(collection2);
		System.out.println(collection2);

		// ArrayList<String> c1 = (ArrayList<String>)(collection2.clone());
		// c1.addAll(collection2);

		// System.out.println(c1);
		// Iterator<String> iterator = collection2.iterator();
		// while (iterator.hasNext()) {
		// 	System.out.println(iterator.next());

		// }
		// System.out.println();

	}
}