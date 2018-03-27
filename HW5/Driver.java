/**
* Test class
*@author Thinh nguyen
*@version 1.0
*/
public class Driver {

    /**
    *
    * Test class
    *@param args Take in an array
    *
    */
    public static void main(String[] args) {
        Athlete thinh = new Athlete("Thinh", 7, 7);
        Athlete nina = new Athlete("Nina", 15, 4);
        Athlete tuan = new Athlete("Tuan", 12, 3);
        Athlete vinh = new Athlete("Vinh", 11, 2);
        Athlete lan = new Athlete("Lan", 9, 1);
        Athlete trai = new Athlete("Trai", 10, 7);
        Athlete an = new Athlete("An", 10, 7);
        Athlete thang = new Athlete("Thang", 10, 7);
        Athlete dang = new Athlete("Dang", 10, 7);
        Athlete tien = new Athlete("Tien", 10, 7);
        Athlete khoa = new Athlete("Khoa", 10, 7);
        Athlete duc = new Athlete("Duc", 10, 7);

        // System.out.println(thinh);

        AthleteList<Athlete> test = new AthleteList<Athlete>();

        // // Add players to AthleteList list
        test.add(thinh);
        test.add(nina);
        test.add(tuan);
        test.add(vinh);
        test.add(lan);
        test.add(trai);
        test.add(an);
        test.add(thang);
        test.add(dang);
        test.add(tien);
        test.add(khoa);
        test.add(duc);

        // Test remove method
        // System.out.println(test.remove(0));
        System.out.println("Break");

        // Test asarray method
        for (int i = 0; i < test.asArray().length; i++) {
            System.out.println(test.get(i));
        }

        test.remove(0);
        System.out.println("Break");
        for (int i = 0; i < test.asArray().length; i++) {
            System.out.println(test.get(i));
        }

        // Test size() method
        System.out.println(test.size());
        System.out.println(test.remove(10));
        System.out.println(test.size());
        // System.out.println("Break");

        // // Test the get method
        // System.out.println(test.get(0));

        // System.out.println("Break");

        // // Test the clear() method
        // // test.clear();
        // System.out.println(test.size());

        // System.out.println("Break");
        // // Test the isempty() method
        // System.out.println(test.isEmpty());

        // System.out.println("Break");
        // // Test teh train() method
        // test.train(0);
        // for (int i = 0; i < test.asArray().length; i++) {
        //     System.out.println(test.get(i));
        // }

        // System.out.println("Break");
        // // Test the rest() method
        // test.rest(0);
        // for (int i = 0; i < test.asArray().length; i++) {
        //     System.out.println(test.get(i));
        // }
    }
}