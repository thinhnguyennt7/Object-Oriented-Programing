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

    @Override public String toString() {
        return String.format("<%s, born %s, %d pounds>",
                             name, anniversary, weight);
    }
}
