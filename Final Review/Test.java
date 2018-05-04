public class Test {

	// Define enum
	public enum Color { RED, BLUE, YELLOW};

	// Number 1
	// static void bar() throws Throwable {
	// 	throw new Throwable("Wee!");
	// }

	// static void foo() throws Throwable {
	// 	bar();
	// 	System.out.println("Foo!");
	// }

	// Number 2
	// static void decryptA() {
	// 	try {
	// 		throw new Throwable("Party!");
	// 	} catch (Throwable t) {
	// 		System.out.println("This is");
	// 	}
	// 	System.out.println("NOT");
	// }

	// static void decryptB() throws Throwable {
	// 	System.out.println("of the ");
	// 	throw new Throwable("Emergency");
	// }

	public static void main(String[] args) {

		// TEST 1:

		// TRUE VS FALSE
		/**
		 * A public top level java class maybe defined in a source file with any base name as long as the file
		 * 				extension is .java -> Fasle
		 * Java identifiers can contain letters, digits, and the underscore symbol and may start with a digit -> False
		 * The statement int x = 3f/4f, will compile, but the result will be truncated so that x gets the value o -> false
		 * in a for loop header, for (initlizier; condition; update) the java compiler requires intiliaer to initilize a loop
		 * 				variable and update to update it -> false
		 * The declarations double scores[] and double[] scores are equivalen -> True
		 * Java arrays have a varianle number of elements of mixed types -> False
		 * Given an array named scores, the statement scores[scores.length + 1] will not complie -> False
		 * Instace methods of a class can be called without first inistatning an object of the class -> False
		 * Every java class has a default no-args constructor in addition to the constructro you write yourslef -> false
		 */

		// Class Car extends Vehicle.      Vehicle is superclass, Car is subclass

		// DECLARE ARRAY
		// String[] test = new String[3];
		// The default value for array is null


		// COMPILE BUT RUN TIME
		// char letter = "Hawk".chatAt(5);


		// RUN 1 TIME
		// for (int i = 0; i < 8; i++);


		// RUN LOOP IF NO SEMICOLON
		// for (int i = 0; i < 8; i++)

		// STILL WORK
		// if (1 == 1) System.out.println("test");

		// Kitten maggie = new Kitten("Maggies");
		// maggie value here is -> the address if a  Kitten Object



		// TEST 2

		// TRUE VS FALSE
		/**
		 * In java, every class you write is a subclass of at least one other class -> True
		 * In a constructor, if an explicit super call is present, it must be the first statement in the constructor -> True
		 * If a class defines a single constructor, the constructor contains an implicit super call if no explicit
		 * 			super call provided in the constructor. -> True
		 * You can define a subclass without defining any of the abstract methods declared in the interface -> True
		 * In a concerte class that implements an interfaces, you must provide definitions for all of the methods declared in the
		 * 			interface -> True
		 * Overloading a superclass method in a subclass means defining a method with the same name as the superclass method, but
		 * 			with a different parameter list -> True
		 * Protected members are visible to classes in the same package and to subclasses.-> True
		 * Private members are visible to classes in which they are define, but not in subclasses. -> True
		 * FileNotFoundException is checked exception -> True
		 */

		// OTHER NOTES:
		// Dynamic method binding mean: -> An invoked method is determined by the run-time type of the object
		// A direct subclass of an abstract class does not have to implement all of its super class's abstract methods when
		// 			-> it too is an abstract class
		// Class a = new Class();
		// LHS is static type, compile time, super class
		// RHS is actual type, actual type, dynamic type, run time, sub class

		// Explicit super call: this() or super() constructor take in argument
		// Implicit super call: constructor with no args, -> super()

		// public class ConcertPunker extends Punker                          punker here is superclass of ConcertPunker.

		// Package is Object from the standard library located. -> java.lang
		// A method declared in a super class is said to be polymorphic in its subclasses if -> The method is overridden
		// in the subclasses.
		// Object-oriented language -> dynamic method binding
		// Classes may extend only 1 class
		// Abstract class can not be intiansitated
		// f1 is alias f2 =>     f1 == f2
		// f1 and f2 reference have the same value =>       f1.equals(f2)
		// A concerct class is class must implements all the method in the interface

		// DECLARE ARRAY LIST
		// ArrayList list = new ArrayList<>(); // Empty array not generic
		// ArrayList<String> lists = new ArrayList<>(); // Empty array with String generic type


		// public int compareTo(Object o) from Comparable
		// public int compare(Object a, Object b) from Comparator

		// Number 1
		// try {
		// 	foo();
		// } catch (Throwable t) {
		// 	System.out.println(t.getMessage());
		// }
		// System.out.println("I'm still running");


		// Number 2
		// try {
		// 	decryptA();
		// 	System.out.println("a test");
		// 	decryptB();
		// } catch (Throwable t) {
		// 	System.out.println(t.getMessage());
		// }
		// System.out.println("broadcast system");


		// Equals()
		public boolean equals(Object o) {
			if (null == o) return false;
			if (this == o) return true;
			if (!(o instaceof Person)) return false;
			Person that = (Person) o;
			return this.name.equals(that.name) && this.mustached == that mustached;
		}

		// Hashcode()
		public int hashCode() {
			int result = 17;
			result = 31 * result + name.hashCode();
			result = 31 * result + (mustached ? 1 : 0);
			return result;
			// boolean type : c = (f ? 1 : 0)
			// byte, char, short, int c = (int) f
			// long c = (int) (f ^ ( f >>> 32))
			// float c = Float.floatToIntBits(f)
			// double c = (int) (Double.doubleToLongBits(f))
			// reference fields: c = f.hashCode()
			// arrayfields : c = Arrays.hashCode()
		}

		// compare() new Comparator<Trooper>()
		public int compare(Trooper a, Trooper b) {
            if (a.hasMustache() && !b.hasMustache()) {
                return 1;
            } else if (b.hasMustache() && !a.hasMustache()) {
                return -1;
            } else {
                return a.getName().compareTo(b.getName());
            }
        }

        // Using an instance of an anonymous inner class
        Collections.sort(troopers, new Comparator<Trooper>() {
            public int compare(Trooper a, Trooper b) {
                if (a.hasMustache() && !b.hasMustache()) {
                    return 1;
                } else if (b.hasMustache() && !a.hasMustache()) {
                    return -1;
                } else {
                    return a.getName().compareTo(b.getName());
                }
            }
        });

        // Using lamba with comparator compare() method
        // Using a lambda expression
        Collections.sort(troopers, (Trooper a, Trooper b) -> {
            if (a.hasMustache() && !b.hasMustache()) {
                return 1;
            } else if (b.hasMustache() && !a.hasMustache()) {
                return -1;
            } else {
                return a.getName().compareTo(b.getName());
            }
        });

        // using method reference
        Comparator<Trooper> byMustacheThenName =
            Comparator.comparing(Trooper::hasMustache)
            .thenComparing(Trooper::getName);

        Collections.sort(troopers, byMustacheThenName);

        // compareTo() new Comparable
        public int compareTo(Object other) {
        	return this.age - other.age;
        	// or
        	return this.age.compareTo(other.age);
        }



        // TEST 3

        // Checked exceptions include RuntimeException -> False
        // hashCode purpose: used in conjunction with a hashing algorithmn to provide a more efficient way to find object stored in a hash table
        // to Compare two hashCode equal or not use ==, a.hashCode() == b.hashCode()
        // To get all the key out from the set use keySet() method


        // Stream pipeline
        List<Marble> biggiest = marble
    							.stream()
    							.filter(a -> a.getSize() >= 2)
    							.collect(Collections.toList());


		// using named class:
        long mc1 =
            troopers.stream().filter(new HasMustache()).count();


		// using anonymous inner class:
        long mc2 =
            troopers.stream().filter(new Predicate<Trooper>() {
                    public boolean test(Trooper t) {
                        return t.hasMustache();
                    }
                }).count();


        // using lambda expression:
        long mc3 =
            troopers.stream().filter(t -> t.hasMustache()).count();



        // using method reference:
        long mc4 =
            troopers.stream().filter(Trooper::hasMustache).count();



        // Regular stream()
        List<Integer> squares =
            Stream.of(1, 2, 3, 4)
            .map(e -> e * e)
            .collect(Collectors.toList());


		// Notes:
		// System.out.println(daringDobermans.contains(new Doberman("Chloe")));        -> if no override hashCode method then answer will always false
		// Set<String> stringSet = new HashSet<>(Arrays.asList("meow", "meow"))      -> the  stringSet.size() == 1
		// The highest superclass of all exceptions -> java.lang.Object


					+-----------+
		   			| Throwable |
                   +-----------+
                    /         \
		   /           \
          +-------+          +-----------+
          | Error |          | Exception |
          +-------+          +-----------+
		   /  |  \           / |        \
	         \________/	  \______/    	 \
				                	+------------------+
			unchecked	 checked	| RuntimeException |
									+------------------+
									  /   |    |      \
									 \_________________/
									   unchecked


	   // Checked are the exception that checked at the compile time.. Example: FileNotFoundException, IOException, ClassNotFoundException
	   // Unchecked are tge exception that are not checked at compiled time.. Example : ArithmeticException, ArrayIndexOutOfBoundsException, NullPointerException, IllegalArgumentException


	   // LINKED LIST
	   // Double linked list: has first and last as node. And has reference next and previous.
	   // Single linked list: has head. has the reference next.
	   // To see the value : head.data
	   // To move to the right: head.next


	   // ITERATOR
	   DynamicArray<String> da = new DynamicArray<>(2);
        da.add("Stan");
        da.add("Kenny");
        // Automatically growing capacity
        da.add("Kyle");
        da.add("Butters");
        da.add("Cartman");

        // Left to right
        Iterator daIter = da.iterator();
        while (daIter.hasNext()) {
            if (daIter.next().equals("Kenny")) {
                daIter.remove();
            }
        }

        // Right to left
        Iterator revIter = da.reverseIterator();
        while (revIter.hasNext()) {
            System.out.println(revIter.next());
        }
	}
}