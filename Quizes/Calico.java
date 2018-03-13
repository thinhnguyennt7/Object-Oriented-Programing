import java.time.LocalDate;
public class Calico extends Cat implements Comparable {
	private String name;
	private LocalDate anniversary;

	public Calico(String name, LocalDate anAnniversary) {
		super(name, anAnniversary);
	}
	
	public String getName() {
		return super.getName();
	}

	public LocalDate getAnniversary() {
		return super.getAnniversary();
	}
}