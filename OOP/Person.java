public class Person implements Named, Destiny {

    public String getName() {
        return "Robert Paulson";
    }

    public static void main(String[] args) {
    	Person hooman = new Person();
    	System.out.println(hooman.getName());
    	System.out.println(hooman.getAge());
    }
}
