import java.util.ArrayList;
import java.util.Iterator;

public class IteratorPractice {
	public static void main(String[] args) {
		ArrayList test = new ArrayList();

		for (int i = 0; i < 10; i++) {
			test.add(i);
		}
		
		Iterator each = test.iterator(); // .iterator() mean traversal. While reverseIterator() is reverse traversal
		while (each.hasNext()) {
			int task = (Integer) each.next();
			System.out.println(task);
		}
	}
}