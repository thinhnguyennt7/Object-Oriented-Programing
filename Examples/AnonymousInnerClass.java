// An anonymous inner class is an inner class without a name.
// It combines defining an inner class and creating an instance of the
// class into one step.

// An anonymous inner class must always extend a superclass or implement an interface, 
// but it cannot have an explicit extends or implements clause

// An anonymous inner class must implement all the abstract methods in the
// superclass or in the interface.

// An anonymous inner class always uses the no-arg constructor from its superclass 
// to create an instance. If an anonymous inner class implements an interface, the constructor is Object().

// An anonymous inner class is compiled into a class named OuterClassName$n. class. 
// For example, if the outer class Test has two anonymous inner classes, 
// they are compiled into Test$1.class and Test$2.class.

public void start(Stage primaryStage) {
	// Omitted
  
	btEnlarge.setOnAction(EventHandler<ActionEvent>() {

		@override // Override the functional interface.
		public void handle(ActionEvent e) {
        	circlePane.enlarge();
      	}
	}); 
}