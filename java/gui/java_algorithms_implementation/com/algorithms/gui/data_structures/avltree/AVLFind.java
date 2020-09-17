package com.algorithms.gui.data_structures.avltree;

/**
 * AVLInsert - This class extends the AnimationThread class. It is used to
 * search for an element into the AVL tree data structure.
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a
 *      href="https://github.com/vuquangtin/algorithm">https://github.com/vuquangtin/algorithm</a>
 *
 */
public class AVLFind extends AnimationThread {
	AVLTree avl;
	AVLNode avlNode;
	int value;

	/**
	 * Constructor for the AVLFind class
	 * 
	 * @param avl
	 *            - AVLTree
	 * @param value
	 *            - int
	 */
	public AVLFind(AVLTree avl, int value) {
		super(avl.M);
		this.avl = avl;
		this.value = value;
		this.avlNode = new AVLNode(avl, value);
		avl.avlNode = this.avlNode;
		// set node color to orange.
		this.avlNode.bgColor(AVLNode.FIND_COLOR);
		// set the header of the textArea
		setHeader("search");
	}

	/**
	 * Constructor for the AVLFind class
	 * 
	 * @param avl
	 *            - AVLTree
	 */
	public AVLFind(AVLTree avl) {
		super(avl.M);
		avlNode = null;
	}

	/**
	 * Return the AVLNode
	 * 
	 * @return int
	 */
	public AVLNode getAVLNode() {
		return avlNode;
	}

	/**
	 * Return the value of AVLNode
	 * 
	 * @return int
	 */
	public int getValue() {
		return value;
	}

	/**
	 * This method will run when an object of this class creates to search for
	 * an element into the AVL tree data structure
	 */
	public void run() {
		// check if root is null
		if (this.avl.root == null) {
			// set position to the node which search for on the root position.
			this.avlNode.goToRoot();
			setText("empty");
			// wait until press next to do the next step
			mysuspend();
			// drop the node down because the tree is empty.
			this.avlNode.goDown();
			// set the color to red
			this.avlNode.bgColor(AVLNode.NOTFOUND_COLOR);
			// set comments to the textArea
			setText("notfound");
		} else {
			// root is not null
			AVLNode localAVLNode = this.avl.root;
			this.avlNode.goTo(localAVLNode);
			// set comments to the textArea
			setText("searchstart");
			// wait until press next to do the next step
			mysuspend();

			while (true) {
				// check if the root is equal to number that search for.
				if (localAVLNode.value == this.value) {
					// set comments to the textArea
					setText("found");
					// set node color to green
					this.avlNode.bgColor(AVLNode.FOUND_COLOR);
					break;
				}
				// if the node comes before the current node, go left to check
				if (this.value < localAVLNode.value) {
					// set comments to the textArea
					setText("searchleft", this.value, localAVLNode.value);
					localAVLNode = localAVLNode.left;
					if (localAVLNode != null) {
						this.avlNode.goTo(localAVLNode);
					} else {
						// set comments to the textArea
						setText("notfound");
						// set node color to red
						this.avlNode.bgColor(AVLNode.NOTFOUND_COLOR);
						// drop it from the tree
						this.avlNode.goLeft();
						break;
					}
				} // otherwise, go right
				else {
					// set comments to the textArea
					setText("searchright", this.value, localAVLNode.value);
					localAVLNode = localAVLNode.right;
					if (localAVLNode != null) {
						this.avlNode.goTo(localAVLNode);
					} else {
						// set comments to the textArea
						setText("notfound");
						// set node color to red
						this.avlNode.bgColor(AVLNode.NOTFOUND_COLOR);
						// drop it from the tree
						this.avlNode.goRight();
						break;
					}

				}
				// wait until press next to do the next step
				mysuspend();
			}
		}
		// set comments to the textArea
		setText("searchdone");

	}

}