package ds.abstractdatatypes.nodes;
/**
 * 
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a
 *      href="https://github.com/vuquangtin/algorithm">https://github.com/vuquangtin/algorithm</a>
 *
 */
public class Node<V> {
    
    protected V value;
    
    public void setValue(V newValue) {
        value = newValue;
    }
    
    public V getValue() {
        return value;
    }

}