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
public class DoublyOrderedLinkedList<K extends Comparable<K>, V> extends
		AbstractDoublyLinkedList<K, V> {

	public DoublyOrderedLinkedList() {
		super();
	}

	@Override
	public void add(K key, V value) {
		if (contains(key)) {
			ListNode<K, V> node = find(key);
			node.setValue(value);
			return;
		}

		numElems++;

		ListNode<K, V> newNode = new ListNode<K, V>(key, value);

		ListNode<K, V> curr = head;

		while ((curr.getNext() != tail)
				&& (curr.getNext().getKey().compareTo(key) < 0)) {
			curr = curr.getNext();
		}

		newNode.setPrev(curr);
		newNode.setNext(curr.getNext());

		curr.getNext().setPrev(newNode);
		curr.setNext(newNode);
	}

}