package ds.abstractdatatypes.lists;

/**
 * 
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a
 *      href="https://github.com/vuquangtin/algorithm">https://github.com/vuquangtin/algorithm</a>
 *
 */
public class Main {

	public static void main(String[] args) {
		DoublyLinkedList<Integer, String> list = new DoublyLinkedList<Integer, String>();

		list.add(5, "James");

		System.out.println(list.size());

		System.out.println(list.get(5));

		list.add(5, "Thomas");

		System.out.println(list.size());

		System.out.println(list.get(5));

	}

}