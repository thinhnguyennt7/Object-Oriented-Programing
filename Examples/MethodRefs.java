import java.util.Arrays;

interface Foo {
	void bar(Object o);
}

public class MethodRefs {
	static void doo(Foo f) {
		f.bar("baz");
	}

	public static void main(String[] args) {
		doo(x -> System.out.println(x));
		// or
		doo(System.out::println); // method reference

		Arrays.asList("foo", "bar", "baz", "dance!").stream()
			.forEach(System.out::println);


		// s -> System.out.println(s);

		// Same as 

		// System.out::println
	}
}