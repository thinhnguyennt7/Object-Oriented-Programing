// INNER CLASS

// An inner class, or nested class, is a class defined within the scope of another class.
// Inner classes are useful for defining handler classes.
// Used in the preceding section

// OuterClass.java: inner class demo
public class OuterClass {
	private int data;

  /** A method in the outer class */
public void m() { 
	// Do something
}
  // An inner class defined inside the Outerclass
class InnerClass {
/** A method in the inner class */ 
	public void mi() {
    	// Directly reference data and method
    	// defined in its outer class
  		data++;
		m();
	} 
}
}

// In the example above:
// An inner class is compiled into a class named -> OuterClassName$InnerClassName. <-

// Inner class can reference the data and the methods defined in the outer class in which it nests

// An inner class can be defined with a visibility modifier subject to the same visibility rules applied
// to a member of the class.

// An inner class can be defined as static. A static inner class can be accessed using the outer
// class name. A static inner class cannot access nonstatic members of the outer class.

// To create an obejct for the inner class:
	// OuterClass.InnerClass innerObject = outerObject.new InnerClass();
// If the inner class is static
	// OuterClass.InnerClass innerObject = new OuterClass.InnerClass();

