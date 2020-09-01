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
public abstract class AbstractSinglyLinkedList<K extends Comparable<K>, V>
		extends AbstractList<K, V> {

	public AbstractSinglyLinkedList() {
		head.setNext(tail);
	}

	@Override
	public void remove(K key) {
		assert contains(key) : "The key must be in the List";

		ListNode<K, V> prev = findPrevious(key);
		ListNode<K, V> node = find(key);

		prev.setNext(node.getNext());
		node.setNext(null);

	}

	private ListNode<K, V> findPrevious(K key) {
		ListNode<K, V> prev = head;
		ListNode<K, V> curr = head.getNext();

		while (curr != tail) {
			if (curr.getKey().equals(key)) {
				break;
			} else {
				prev = curr;
				curr = curr.getNext();
			}
		}

		return prev;
	}

}