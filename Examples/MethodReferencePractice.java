import java.util.*;

public class MethodReferencePractice {
    public static void main(String[] args){
        new MethodReferencePractice();
    }

    public MethodReferencePractice() {
        // Answers at bottom of file!!
        // 1) Can the following lambda be turned into a method reference?
        Foo f = (String str, String str2) -> {
            return str.indexOf(str2);
        };

        // 2) Can the following lambda be turned into a method reference?
        StringConverter<Integer> s = (String str) -> {
            return str.indexOf("h");
        };

        // 3) Can the following lambda be turned into a method reference
        StringConverter<Integer> s1 = (String str) -> {
            return Integer.parseInt(str);
        };

        // 4) Can the following lambda be turned into a method reference
        Foo f1 = (String str1, String str2) -> {
            return Integer.parseInt(str1) + Integer.parseInt(str2);
        };

        // 5) Can the following lambda be turned into a method reference
        Bar b = (int i) -> {
            // This is deprecated as of Java 9 but don't worry about it
            return new Integer(i);
        };

        // 6) Can the following lambda be turned into a method reference
        Bar b1 = (int i) -> {
            // This is deprecated as of Java 9 but don't worry about it
            return new Integer(i + 45);
        };

        // 7) Can the following lambda be turned into a method reference
        List<Integer> ints = new ArrayList<Integer>();
        Bar b2 = (int i) -> {
            return ints.get(i);
        };
    }

    // Functional Interface
    public interface StringConverter<R> {
        public R convert(String s);
    }

    public interface Foo {
        public int foo(String s, String s2);
    }

    public interface Bar {
        public int bar(int i);
    }

    public void answers() {
        // 1)
        Foo f = String::indexOf;

        // 2) No

        // 3)
        StringConverter<Integer> s1 = Integer::parseInt;

        // 4) No

        // 5)
        Bar b = Integer::new;

        // 6) No

        // 7) Can the following lambda be turned into a method reference
        List<Integer> ints = new ArrayList<Integer>();
        Bar b2 = ints::get;
    }
}