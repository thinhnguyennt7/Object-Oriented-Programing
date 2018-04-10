public class innerClass {

	public interface SayHello {
		void say();
	}
 
	public static void main(String[] args) {

		// Anonymous inner class
        SayHello sh = new SayHello() {
			
			@Override
			public void say() {
				System.out.println("Hello");
			}
		};
        sh.say();

        // Using lamba expression
        SayHello sh = () -> System.out.println("Hello");
        sh.say();
    }
}