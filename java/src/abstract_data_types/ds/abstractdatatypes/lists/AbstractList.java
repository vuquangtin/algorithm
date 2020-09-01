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
public abstract class AbstractList<K,V> {
    
    protected int numElems;
    
    ListNode<K,V> head = new ListNode<K,V>(null, null);
    ListNode<K,V> tail = new ListNode<K,V>(null, null);
    
    protected int size() {
        return numElems;
    }
    
    protected boolean isEmpty() {
        return numElems == 0;
    }
    
    protected ListNode<K,V> find(K key) {
        ListNode<K,V> curr = head.getNext();
        
        while (!curr.equals(tail)) {
            if (curr.getKey().equals(key)) {
                return curr;
            }
            curr = curr.getNext();
        }
        
        if (curr.equals(tail)) {
            return null;
        } else {
            return curr;
        }
    }
    
    protected boolean contains(K key) {
        return find(key) != null;
    }
    
    public V get(K key) throws NullPointerException {
        assert contains(key) : "The given key should be in the List";
        
        return find(key).getValue();
    }

    public abstract void add(K key, V value);
    
    public abstract void remove(K key);
    
}