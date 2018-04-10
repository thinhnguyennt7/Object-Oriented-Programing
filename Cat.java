import java.time.LocalDate;

public class Cat {

    private String name;
    private LocalDate anniversary;
    private int weight;

    public Cat(String name, LocalDate anniversary, int weight) {
        this.name = name;
        this.anniversary = anniversary;
        this.weight = weight;
    }

    public String getName() { return name; }

    public LocalDate getAnniversary() { return anniversary; }

    public int getWeight() { return weight; }

    @Override
    public boolean equals(Object other) {
        if (null == other) return false;
        if (this == other) return true;
        if (!(other instanceof Cat)) return false;
        Cat that = (Cat) other;
        return this.name.equals(that.name) && this.anniversary.equals(that.anniversary) && this.weight == that.weight;
    }

    public int hashCode() {
        int result = 17;
        result = 31 * result + name.hashCode();
        result = 31 * result + weight;
        result = 31 * result + anniversary.hashCode();
        return result;
    }
}