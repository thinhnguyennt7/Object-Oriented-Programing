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
        Athlete thinh = new Athlete("Thinh", 6, 6);
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

        // System.out.println(test.size());
        for (int i = 0; i < test.asArray().length; i++) {
            System.out.println(test.get(i));
        }


        // test.train(0); // Test train() method
        // System.out.println(test.get(0)); // Print out after train()

        // test.rest(0); // Test rest() method
        // System.out.println(test.get(0)); // Print out after test()

        // AthleteList player = test.get(10);
        // System.out.println(player);

        
        
        // AthleteList player1 = test.remove(10);
        // System.out.println(player1);
        // System.out.println(test.size());
        // test.remove(7);//Check remove method
        // test.clear();//check clear method
        // test.add(thinh);//Add new player. after clear
        // System.out.println(test.isEmpty()); // Test isEmpty() method

        // AthleteList[] b = test.asArray(); // check method asArray()
        // for (int i = 0; i < b.length; i++) {
        //     System.out.println(b[i]);
        // }

        // Print all the players
        // for(int i = 0; i < test.size(); i++) {
        //     System.out.println(test.get(i)); // Check get method
        // }
        // System.out.println(test.get(-1)); // Check negative index
        // System.out.println(test.get(test.size())); // Check the index value
        // System.out.println(test.size()); // check size
    }
}