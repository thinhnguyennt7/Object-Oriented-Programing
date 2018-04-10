import java.time.LocalDateTime;
import java.util.Optional;

import java.util.function.Predicate;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;


public class Driver {

	public static void main(String[] args) {


		LocalDateTime tienTime = LocalDateTime.of(2016,1,1,1,1,1);
		LocalDateTime tuanTime = LocalDateTime.of(2017,2,2,2,2,2);
		LocalDateTime thinhTime = LocalDateTime.of(2018,2,2,2,2,2);
		LocalDateTime khoaTime = LocalDateTime.of(2016,2,2,2,2,2);


		Message tien = new Message(
			Optional.ofNullable("TienH"), "Tien", "Na", "Tien to Na",tienTime, true);

		Message tien2 = new Message(
			Optional.ofNullable("TienH"), "Tien", "Na", "Tien to Na2",tienTime, true);

		Message tien3 = new Message(
			Optional.ofNullable("TienH"), "Tien", "Na", "Tien to Na3",tienTime, true);

		Message tuan = new Message(
			Optional.ofNullable(null), "Tuan", "Na", "Tuan to Na",tuanTime, false);

		Message thinh = new Message(
			Optional.ofNullable("Thinh"), "Thinh", "Na", "Thinh to Na",thinhTime, true);

		Message thinh2 = new Message(
			Optional.ofNullable("Thinh"), "Thinh", "Na", "Thinh to Na2",thinhTime, false);

		Message khoa = new Message(
			Optional.ofNullable("Khoa"), "Khoa", "Na", "Khoa to Na",khoaTime, false);

		Message Vinh = new Message(
			Optional.ofNullable("Vinh"), "Vinh", "Na", "Vinh to Na",khoaTime, false);

		List<Message> test = new ArrayList<>();
		test.add(tien);
		test.add(tien2);
		test.add(tien3);
		test.add(tuan);
		test.add(thinh);
		test.add(thinh2);
		test.add(khoa);
		test.add(Vinh);


		// int a = tuanTime.compareTo(tienTime);
		// int b = tuanTime.compareTo(thinhTime);
		// System.out.println(a);
		// System.out.println(b);
		// boolean checking = tuanTime.compareTo(tienTime) > 1 ;
		// System.out.println(checking);


		Database testDataBase = new Database(test);

		// System.out.println(testDataBase.getMessagesBetween(LocalDateTime.of(2016,5,1,1,1,1),thinhTime));

		// System.out.println(testDataBase.getMessages());
		// System.out.println(testDataBase.getMessage(0));


		//System.out.println(thinh.getContactName().get());
		// System.out.println(tuan.getContactName().isPresent());
		// System.out.println(testDataBase.sortMessagesByContact());

		//Map<String, List<Message>> map = testDataBase.sortMessagesByContact();
		//System.out.println(map);
		// System.out.println(map.size());

		// System.out.println(testDataBase.getMessagesWithKeyword("inh"));
		// System.out.println(testDataBase.getMessagesWithPriority());
		// System.out.println(testDataBase.getMessage(3));

	}
}