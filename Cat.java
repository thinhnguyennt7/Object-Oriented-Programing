import java.time.LocalDate;
import java.util.List;

public class Cat {

    private String name;
    private LocalDate anniversary;
    private int weight;
    private List<Cats> cat;

    public Cat(String name, LocalDate anniversary, int weight) {
        cat = new ArrayList<Cats>();
        cat.add(this.name);
        cat.add(this.anniversary);
        cat.add(this.weight);
    }

    public String getName() { return name; }

    public LocalDate getAnniversary() { return anniversary; }

    public int getWeight() { return weight; }

    public static void main(String[] args) {
        LocalDate aldt = LocalDate.now();
        Cat cat1 = new Cat("Thinh", aldt, 120);
        Cat cat2 = new Cat("Tien", aldt, 130);
        Cat cat3 = new Cat("Test", aldt, 140);
    }
}
