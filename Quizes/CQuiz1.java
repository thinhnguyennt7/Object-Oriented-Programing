public class CQuiz1 {

    public static void main(String[] args) {
        int[] xs = {1, 2, 3};
        int[] ys = {4, 3, 2, 1};
        boolean isEqual = xs[0] == ys[0];
        if (isEqual) {
            System.out.println("Equal heads.");
        } else {
            System.out.println("Unequal heads.");
        }
    }
}