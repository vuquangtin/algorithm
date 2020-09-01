package ds.abstractdatatypes.stacks;

import ds.abstractdatatypes.nodes.Node;

/**
 * 
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a
 *      href="https://github.com/vuquangtin/algorithm">https://github.com/vuquangtin/algorithm</a>
 *
 */
public class StackNode<V> extends Node<V> {

	private StackNode<V> next;

	public StackNode(V value, StackNode<V> next) {
		this.value = value;
		this.next = next;
	}

	public StackNode<V> getNext() {
		return next;
	}

}