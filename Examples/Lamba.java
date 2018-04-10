public class Lamba {

	public interface SayHello {
		void say(String name);
	}

	//  funtional interface: Has only one abstract method in side that interface

	public static void main(String[] args) {

		// Lamba expression use the functional interface. 
		SayHello sh = (name) -> System.out.println("Hello, " + name);
		sh.say("Thinh");

	}
}