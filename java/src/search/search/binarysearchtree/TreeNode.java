package search.binarysearchtree;

/**
 * 
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a
 *      href="https://github.com/vuquangtin/algorithm">https://github.com/vuquangtin/algorithm</a>
 *
 */
public class TreeNode {

	public int data;
	public TreeNode left;
	public TreeNode right;

	public TreeNode(int data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "TreeNode [data=" + data + "]";
	}

}