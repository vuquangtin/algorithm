package com.algorithms.data_structures;

/**
 * An AA tree in computer science is a form of balanced tree used for storing
 * and retrieving ordered data efficiently. AA trees are named for Arne
 * Andersson, their inventor.
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0 *
 *          <p>
 * @see <a href="https://en.wikipedia.org/wiki/AA_tree">AA tree (Wikipedia)</a> <br>
 * @see <a
 *      href="https://github.com/vuquangtin/algorithm">https://github.com/vuquangtin/algorithm</a>
 *
 */
public class AATree<T extends Comparable<T>> {

	private Node<T> root;

	public AATree() {
		this.root = null;
	}

	public void insert(T value) {
		root = insert(value, root);
	}

	private Node<T> insert(T value, Node<T> root) {
		// If there's no root, create one
		if (root == null) {
			root = new Node<>(value);
		}
		// Otherwise we insert the value like we do it in BST
		else if (value.compareTo((T) root.value) <= 0) {
			root.left = insert(value, root.left);
		} else if (value.compareTo((T) root.value) > 0) {
			root.right = insert(value, root.right);
		} else {
			return root;
		}
		/*- Call 2 methods to rebalance tree
		 Delete cases when a left child of a node is on the same level as it's parent
		              |                       |
		      L   <-  T           SKEW        L   ->  T
		    /   \      \          --->       /      /   \
		   A     B      R                   A      B     R
		 */
		root = skew(root);
		/*-
		                              SPLIT
		 Delete cases when we have a right child and and a right grandchild on the same level
		      |                                       |
		      T   ->  R   ->  X      SPLIT            R
		     /       /                --->          /   \
		    A       B                              T     X
		                                         /   \
		                                        A     B
		 */
		root = split(root);
		//
		return root;
	}

	private Node<T> skew(Node<T> root) {
		// Check if root isn't null
		if (root == null) {
			return null;
			// If it isn't then we check we left sibling
			// If we don't have a left sibling -> we don't have any left child
			// -> return our root
		} else if (root.left == null) {
			return root;
			// Otherwise, if the left child and the root are on the same level,
			// we need to reverse a subtree
		} else if (root.left.level == root.level) {
			// Take a link to the left sibling root
			Node leftNode = root.left;
			// The left sibling's root right child becomes the left child of
			// initial root
			root.left = leftNode.right;
			// Link the left sibling's root to initial root as a right child
			leftNode.right = root;
			// Now the leftNode becomes new root -> we return leftNode and
			// assign it to root in insert method
			return leftNode;
			// If the left child isn't on the same level as root then we just
			// return this root
		} else {
			return root;
		}
	}

	private Node<T> split(Node<T> root) {

		// Check if root isn't null
		if (root == null) {
			return null;
			// If it isn't then we check whether we have a right child and right
			// grandchild
			// If some of them isn't present then we don't have to do anything
			// and rebalance the tree
		} else if (root.right == null || root.right.right == null) {
			return root;
			// Otherwise, we check whether the root level equals to right
			// grandchild level
			// If it is
		} else if (root.level == root.right.right.level) {
			// Take a link to root's right child
			Node rightNode = root.right;
			// Link rightRoot left child to initial root as a right child
			root.right = rightNode.left;
			// Initial root with it's children becomes a left child of rightNode
			rightNode.left = root;
			// Lift the rightNode upper
			rightNode.level++;
			// rightNode becomes a new root instead of initial root
			return rightNode;
			// If it isn't
		} else {
			return root;
		}
	}

	private Node<T> decreaseLevel(Node<T> root) {
		/*-
		 In AA Tree left child's level must be one less than root's
		 Right child's level must be one less or equal to root's
		 The root level must be equal to the given statement
		 If root is higher than it should be, we decrease it to the value of expected
		 Check every case to avoid NullPointerException
		 */
		int expected = 0;
		if (root.left != null && root.right != null) {
			expected = Math.min(root.left.level, root.right.level) + 1;
		} else if (root.left == null || root.right == null) {
			expected = 1;
		}

		// Try to lower our node and its right child
		if (expected < root.level) {
			root.level = expected;
			if (root.right != null && expected < root.right.level) {
				root.right.level = expected;
			}
		}
		return root;
	}

	public void remove(T value) {
		root = remove(value, root);
	}

	private Node<T> remove(T value, Node<T> root) {
		// Try to find the node to remove
		if (root == null) {
			return root;
		} else if (value.compareTo(root.value) > 0) {
			root.right = remove(value, root.right);
		} else if (value.compareTo(root.value) < 0) {
			root.left = remove(value, root.left);
		} else {
			// If the node is a leaf -> make it null
			if (root.left == null && root.right == null) {
				return null;
				// If it isn't a leaf then we try to find it's successor or
				// predecessor to swap
				// Found node will have level 1 which is easy to delete
			} else if (root.left == null) {
				Node<T> left = getSuccessor(root);
				root.right = remove(left.value, root.right);
				root.value = left.value;
			} else {
				Node<T> left = getPredecessor(root);
				root.left = remove(left.value, root.left);
				root.value = left.value;
			}
		}
		// We need 2-3 skew and 2 split operations to rebalance the tree
		root = decreaseLevel(root);
		root = skew(root);
		root.right = skew(root.right);
		if (root.right != null) {
			root.right.right = skew(root.right.right);
		}
		root = split(root);
		root.right = split(root.right);
		return root;
	}

	private Node<T> getPredecessor(Node<T> node) {
		Node<T> predecessor = node.left;
		while (predecessor.right != null) {
			predecessor = predecessor.right;
		}

		return predecessor;
	}

	private Node<T> getSuccessor(Node<T> node) {
		Node<T> successor = node.right;
		while (successor.left != null) {
			successor = successor.left;
		}

		return successor;
	}

	// Contains method equals to contains method in Binary Search Tree
	public Node<T> find(T value) {
		return find(value, root);
	}

	private Node<T> find(T value, Node<T> root) {
		if (root == null) {
			return null;
		} else if (root.value.compareTo(value) == 0) {
			return root;
		} else if (root.value.compareTo(value) < 0) {
			return find(value, root.right);
		} else {
			return find(value, root.left);
		}
	}

	static class Node<T> {
		private T value;
		private int level;
		private Node left;
		private Node right;

		public Node(T value) {
			this.value = value;
			this.level = 1;
		}

		public Node(T value, int level, Node left, Node right) {
			this(value, left, right);
			this.level = level;
		}

		public Node(T value, Node left, Node right) {
			this(value);
			this.left = left;
			this.right = right;
		}

		@Override
		public String toString() {
			return "Node{" + "value=" + value + '}';
		}
	}
}