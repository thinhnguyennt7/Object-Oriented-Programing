import java.time.LocalDate;

public class Cat implements Comparable {

	private String name;
	private LocalDate anniversary;

	public Cat(String name, LocalDate d) {
		this.name = name;
		setAnniversary(d);
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

	public void setAnniversary(LocalDate anniversary) {
		this.anniversary = anniversary;
	}

	public interface Comparable {
		String getName();
		void SetName();
		LocalDate getAnniversary();
		void setAnniversary();
	}
}