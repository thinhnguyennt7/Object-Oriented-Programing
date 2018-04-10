// Lambda expressions can be used to greatly simplify coding for event handling

// Lambda expressions can be viewed as an anonymous class with a concise syntax.

// Anonymous inner clas handler
btEnlarge.setOnAction(
	new EventHandler<ActionEvent>() {   // EventHandler is the inteface defined the handle method with parameter ActionEvent type
		@Override
		public void handle(ActionEvent e) {
      		// Code for processing event e
		}
	}
});

// Lamba Expression event handler
btEnlarge.setOnAction(e -> {   // Compiler recognize e here is a parameter of the ActionEvent type
	// Code for processing event e

	// For the body here is the statements are for the body of the handle method.
	// The lamba expression compiler can be understand only one abstract method.
	// Interface is known as functional interface
});

// Syntax

// The basic syntax for a lambda expression is either
  // (type1 param1, type2 param2, ...) -> expression

// or
// (type1 param1, type2 param2, ...) -> { statements; }


// The data type for a parameter may be explicitly declared or implicitly 
// inferred by the com- piler. The parentheses can be omitted if there is only 
// one parameter without an explicit data type

e -> {
	// Code for processing e
}

// The compiler treats a lambda expression as if it is an object created 
// from an anonymous inner class.


public class Lamba {
	public void start() {
		Button btNew = new Button("New");
		Button btOpen = new Button("Open");
		Button btSave = new Button("Save");
		Button btPrint = new Button("Print");

		// Create and register the handle
		btNew.setOnAction((ActionEvent e) ->  // Lamba uses a declared type
			System.out.println("Process New");
		});

		btOpen.setOnAction((e) -> {  // Lamba uses inferred type
			System.out.println("Process Open");
		});

		btSave.setOnAction(e -> {  // Omits the parenthese for a single inferred type
			System.out.println("Process Save");
		});

		btPrint.setOnAction(e -> System.out.println("Process New")); // Omits the brace for a single statement in the body.
	}
}