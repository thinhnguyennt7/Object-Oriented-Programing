import java.time.LocalDateTime;
import java.util.Optional;
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
		System.out.println("Date with Time: " + aLDT);

		Message testMessage = new Message(Optional.of("Tien Ho"), "Tien", "Thinh", "Testing message", aLDT, true);
		
		System.out.println(testMessage);

		Database testDataBase = new Database(testMessage);

		System.out.println(getMessages(0));
		// System.out.println(testMessage.getContact());
		// System.out.println(testMessage.getTo());
		// System.out.println(testMessage.getFrom());
		// System.out.println(testMessage.getBody());
		// System.out.println(testMessage.getDate());
		// System.out.println(testMessage.getIsImportant());


		// public static LocalDateTime of​(int year,
  //                              Month month,
  //                              int dayOfMonth,
  //                              int hour,
  //                              int minute

		// LocalDateTime specificDate = LocalDateTime.of(2014, Month.MARCH, 1, 10, 10, 30);
		// System.out.println("Specific Date="+specificDate);

	}
}