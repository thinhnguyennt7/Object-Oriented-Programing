import java.time.LocalDateTime;
import java.util.Optional;
import java.util.ArrayList;
import java.util.List;
public class Driver {
	
	public static void main(String[] args) {

		// Optional.ofNullable() method returns a Non-empty Optional
		// if a value present in the given object. Otherwise returns empty Optional

		// Optional.empty() method is useful to create an empty Optional object.


		// LocalDateTime is an immutable date-time object that represents a date-time,
		 // with default format as yyyy-MM-dd-HH-mm-ss.zzz. It provides a factory method
		// that takes LocalDate and LocalTime input arguments to create LocalDateTime
		 // instance.

		// LocalDateTime rightnow = LocalDateTime.now();

		String strDatewithTime = "2015-08-04T10:11:30";
		LocalDateTime aLDT = LocalDateTime.parse(strDatewithTime);

		String strDatewithTime1 = "2015-07-04T10:11:30";
		LocalDateTime aLD = LocalDateTime.parse(strDatewithTime1);
		// System.out.println("Date with Time: " + aLDT);

		Message testMessage = new Message(Optional.ofNullable("Tien Ho"), "Tien", "Thinh", "Testing message", aLD, true);
		Message testMessage2 = new Message(Optional.ofNullable("Tien Ho"), "Tien", "Thinh", "Testing message", aLD, false);
		Message testMessage1 = new Message(Optional.ofNullable("thinh nguyen"), "Thinh", "tien", "Hello world", aLDT, true);

		List<Message> test = new ArrayList<>();
		test.add(testMessage);
		test.add(testMessage1);
		test.add(testMessage2);

		// System.out.println(testMessage.toString());

		Database testDataBase = new Database(test);

		// testDataBase.filter((Message p) testMessage);
		testDataBase.filter((Message p) -> {

            return p.getBody().contains("Hello");
        });

		// System.out.println(testDataBase.getMessagesBetween(aLD,aLD));
		// System.out.println(testDataBase.sortMessagesByContact());
		// System.out.println(testDataBase.sortMessagesByContact());
		// System.out.println(testDataBase.getMessagesWithPriority());
		System.out.println(testDataBase.getMessagesWithKeyword("Hello"));
	}
}