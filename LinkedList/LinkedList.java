/**
 * 						 List
 *					/			\
 *			ArrayList			LinkedList
 *
 *
 * 
 * Singly LinkedList: -> Contains a pointer to a head node (null if empty)
 *
 *
 *
 *
 */

// private class Node {
// 	public Object date;

// }

//  Adding something to the head of linkedlist

public String toString() {
	StringBuffer sb = new StringBuffer("[");
	for (Node node = head; node != null; node = node.next) {
		sb.append(node.data + " ");
	}
	return sb.toString() + "]";
}

public String toString2() {
	return "[" + toStringHelper(head, "") + "]";
}

private String toStringHelper(Node<E> node, String accum) {
	if (node == nul) {
		return accum;
	} else {
		return toStringHelper(node.next, accum + "," + node.data);
	}
}