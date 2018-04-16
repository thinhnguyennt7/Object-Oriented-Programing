import java.util.ArrayList;
import java.util.Comparator;
import java.util.Collections;

public class Cat implements Comparable {
	public int age;
	public String name;

	public Cat(int age, String name) {
		this.age = age;
		this.name = name;
	}

	private static class CatComparator<T extends Cat> implements Comparator<T> {
		public int compare(T a, T b) {
			if (a.compareTo(b) == 0) {
				return a.name.compareTo(b.name);
			}
			return a.compareTo(b);
		}
	}

	public int compareTo(Object other) {
		Cat that = (Cat) (other);
		return this.age - that.age;
	}

	public static void main(String[] args) {
		ArrayList<Cat> cats = new ArrayList<>();
		// cats.add(new Cat(8, "steph"));
		// cats.add(new Cat(4, "adi"));
		// cats.add(new Cat(5, "chris"));
		// cats.add(new Cat(2, "taylor"));
		// cats.add(new Cat(4, "sam"));
		cats.add(new Cat(6, "andy"));
		cats.add(new Cat(9, "john"));

		CatComparator<Cat> catComp = new CatComparator<>();
		Collections.sort(cats, catComp);

		for (Cat cat : cats) {
			System.out.println(cat.name + " ");
		}
		System.out.println("\n");
	}
}