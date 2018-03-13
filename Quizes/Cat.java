import java.time.LocalDate;
import java.time.Period;

public abstract class Cat implements Comparable {
	private String name;
	private LocalDate anniversary;

	/**
	*
	*
	*@throws IllegalArgumentException is unchecked
	*
	*/
	public Cat(String name, LocalDate anAnniversary) {
		if (name == null) {
			throw new IllegalArgumentException("Name can't be null");
		} else if (name == "") {
			throw new IllegalArgumentException("Name can't be empty");
		}

		if (anAnniversary != LocalDate.now()) {
			throw new IllegalArgumentException("anniversary can't be in the future.");
		}
	}
	
	// public int compareTo(Object other) {
	// 	Cat that = (Cat) other; // We have to case because other still in Object class
	// 	return -this.anniversary.compareTo(that.anniversary);
	// 	// We have to reverse in this case case if we don't put the - in front then we will get -1 instead 1.
	// 	// We can reference the private member because we can we cast other to Cat therefore we abble to use anniversary in private
	// }

	//  Or we can use this way 

	// public int ageInDays() {
	// 	// Use Period, accounts for leap years
	// 	//  Need to implement
	// }

	// public int compareTo(Object other) {
	// 	Cat that = (Cat) other;
	// 	return this.ageInDays() - that.ageInDays();
	// }

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
		this.anniversary = d;
	}

	@Override
    public boolean equals(Object other) {
        if (this == other) { return true; }
        if (!(other instanceof Cat)) { return false; }
        if ((((Cat) other).name.equals(this.name) == true) && (((Cat) other).anniversary.equals(this.anniversary) == true)) {
			return true;
		}
        return false;
    }
    // public static void main(String[] args) {
    // 	Cat test = new Cat("Thinh", u)
    // }
}