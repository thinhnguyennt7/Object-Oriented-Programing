import java.util.Scanner;

    public class sb {

        public static void main(String[] args) {

            Scanner scan = new Scanner(System.in);
            StringBuilder strb  = new StringBuilder(scan.nextLine());
            strb.append( scan.nextLine());
            System.out.println(strb);
        }
    }