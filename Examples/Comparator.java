class Dog implements Comparator<Dog>, Comparable<Dog>{
   private String name;
   private int age;
   Dog(){
   }

   Dog(String n, int a){
      name = n;
      age = a;
   }

   public String getDogName(){      return name;
   }

   public int getDogAge(){
      return age;
   }

   // Ghi de phuong thuc compareTo
   public int compareTo(Dog d){
      return (this.name).compareTo(d.name);
   }

   // Ghi de phuong thuc compare de sap xep age 
   public int compare(Dog d, Dog d1){
      return d.age - d1.age;
   }
}

public class Example{

   public static void main(String args[]){
      // Lay danh sach cac doi tuong Dog
      List<Dog> list = new ArrayList<Dog>();

      list.add(new Dog("Shaggy",3));
      list.add(new Dog("Lacy",2));
      list.add(new Dog("Roger",10));
      list.add(new Dog("Tommy",4));
      list.add(new Dog("Tammy",1));
      Collections.sort(list);// Sap xep array list

      for(Dog a: list)//in danh sach cac name sau khi da sap xep
         System.out.print(a.getDogName() + ", ");

      // Sap xep array list boi su dung comparator
      Collections.sort(list, new Dog());
      System.out.println(" ");
      for(Dog a: list)//in danh sach da qua sap xep cua age
         System.out.print(a.getDogName() +"  : "+
		 a.getDogAge() + ", ");
   }
}

// Lacy, Roger, Shaggy, Tammy, Tommy,
// Tammy  : 1, Lacy  : 2, Shaggy  : 3, Tommy  : 4, Roger  : 10,