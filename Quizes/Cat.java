import java.time.LocalDate;

public class Cat {
	private String name;
	private LocalDate anniversary;

	public Cat(String name, LocalDate d) {
		this.name = name;
		anniversary(d);
	}
	
	public String getName() {
		return name;
	}

	public void SetName(String name) {
		this.name = name;
	}

	public LocalDate getAnniversary() {
		return anniversary;
	}

	private void setAnniversy(LocalDate d) {
		// if (d.compareTo(LocalDate.now()) > 0) {
		// 	//nuh uh
		// }
		this.anniversary = d;
	}
}