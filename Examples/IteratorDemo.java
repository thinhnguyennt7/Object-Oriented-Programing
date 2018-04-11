import java.util.*;

public class IteratorDemo {

   public static void main(String args[]) {
      // Tao mot array list
      ArrayList al = new ArrayList();
      // them cac phan tu toi array list
      al.add("C");
      al.add("A");
      al.add("E");
      al.add("B");
      al.add("D");
      al.add("F");

      // Su dung iterator de hien thi noi dung cua array list
      System.out.print("Noi dung ban dau cua ArrayList la: ");
      Iterator itr = al.iterator();
      while(itr.hasNext()) {
         Object element = itr.next();
         System.out.print(element + " ");
      }
      System.out.println();
      
	  // Sua doi cac doi tuong sau khi da duoc lap qua
      ListIterator litr = al.listIterator();
      while(litr.hasNext()) {
         Object element = litr.next();
         litr.set(element + "+");
      }
      System.out.print("Noi dung sau khi sua doi cua ArrayList la: ");
      itr = al.iterator();
      while(itr.hasNext()) {
         Object element = itr.next();
         System.out.print(element + " ");
      }
      System.out.println();

      // Bay gio, hien thi list theo chieu nguoc lai
      System.out.print("Hien thi list theo chieu nguoc lai: ");
      while(litr.hasPrevious()) {
         Object element = litr.previous();
         System.out.print(element + " ");
       }
       System.out.println();
    }
}

// Noi dung ban dau cua ArrayList la: C A E B D F
// Noi dung sau khi sua doi cua ArrayList la: C+ A+ E+ B+ D+ F+
// Hien thi list theo chieu nguoc lai: F+ D+ B+ E+ A+ C+