public class MyLinkedList<E> extends GenericLinkedList<E> {

    public int length3() {
        return getLengthHelper(head);
    }

    private int getLengthHelper(Node<E> node) {
        if (node == null) {
            return 0;
        } else {
            return 1 + getLengthHelper(node.next);
        }
    }

    // For testing. All three length methods should return the same value.
    public static void main(String[] args) {
        MyLinkedList<String> troopers = new MyLinkedList<>();
        troopers.addFront("Thorny");
        troopers.addFront("Farva");
        troopers.addFront("Mac");
        troopers.addFront("Rabbit");
        troopers.addFront("Foster");
        System.out.println(troopers.toString2());
        System.out.println("How many? " + troopers.length());
        System.out.println("How many? " + troopers.length2());
        System.out.println("How many? " + troopers.length3());

    }
}
