package ds.abstractdatatypes.stacks;
/**
 * 
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a
 *      href="https://github.com/vuquangtin/algorithm">https://github.com/vuquangtin/algorithm</a>
 *
 */
public class Stack<V> {
    
    private StackNode<V> topNode = null;
    
    public boolean isEmpty() {
        return topNode == null;
    }
    
    public void push(V newElem) {
        topNode = new StackNode<V>(newElem, topNode);
    }
    
    
    public V peek() {
        if (!isEmpty()) {
            return topNode.getValue();
        } else {
            return null;
        }
    }
    
    public V pop() {
        V topValue = null;
        
        if (!isEmpty()) {
            topValue = topNode.getValue();
            topNode = topNode.getNext();
        } 
        
        return topValue;
    }

}