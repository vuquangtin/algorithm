package ds.abstractdatatypes.lists;

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
public class ListNode<K,V> extends Node<V> {
    
    private K key;
    private ListNode<K,V> prev;
    private ListNode<K,V> next;
    
    public ListNode(K key, V value) {
        this.key = key;
        this.value = value;
        next = null;
        prev = null;
    }
    
    public K getKey() {
        return key;
    }
    
    public void setNext(ListNode<K,V> next) {
        this.next = next;
    }
    
    public ListNode<K,V> getNext() {
        return next;
    }
    
    public void setPrev(ListNode<K,V> newNode) {
        prev = newNode;
    }
    
    public ListNode<K,V> getPrev() {
        return prev;
    }
    
}