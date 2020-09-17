package com.algorithms.gui.data_structures.avltree;

/**
 * AVLInsert - This class extends the AnimationThread class. It is used to add a
 * new element into the AVL tree data structure.
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a
 *      href="https://github.com/vuquangtin/algorithm">https://github.com/vuquangtin/algorithm</a>
 *
 */
public class AVLInsert extends AnimationThread {
	AVLTree avlTree;
	AVLNode v;
	int value;

	MainPanel m;

	/**
	 * Constructor for the AVLInsert class
	 * 
	 * @param avl
	 *            - AVLTree
	 * @param value
	 *            - int
	 */
	public AVLInsert(AVLTree avl, int value) {
		super(avl.M);
		this.M = avl.M;
		this.avlTree = avl;
		this.value = value;
		// create a new node
		this.v = new AVLNode(avl, value);
		this.v.bgColor(AVLNode.INSERT_COLOR);
		avl.avlNode = this.v;
		// set the header of the textArea
		setHeader("insertion");

	}

	/**
	 * Return the AVLNode
	 * 
	 * @return AVLNode
	 */
	public AVLNode getV() {
		return v;
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
	 * This method will run when an object of this class creates to insert a new
	 * element into the AVL tree data structure
	 */
	public void run() {
		// sing root value in localAVLNode object
		AVLNode localAVLNode = this.avlTree.root;
		// check if the root null or not
		if (this.avlTree.root == null) {
			// root is null, so set new root with yellow color
			this.avlTree.root = (this.v = new AVLNode(this.v));
			// set the position of the new root
			this.v.goToRoot();
			// set comments to the textArea
			setText("newroot", v.value);
			// wait until press next to do the next step
			mysuspend();
		} else {
			// root is not null, so set the new node above the root
			// before check where it should be set.
			this.v.goAboveRoot();
			// set comments to the textArea
			setText("insertstart");
			// wait until press next to do the next step
			mysuspend();
			while (true) {
				// check if the new number is already in the tree
				if (localAVLNode.value == this.value) {
					// set comments to the textArea
					setText("alreadythere");
					// drop the node down
					this.v.goDown();
					// change color to red
					this.v.bgColor(AVLNode.NOTFOUND_COLOR);
					// do nothing
					return;
				}
				// if the new node comes before the current node, go left
				if (this.value < localAVLNode.value) {
					// set comments to the textArea
					setText("gotoleftside", this.value, localAVLNode.value);
					if (localAVLNode.left != null) {
						localAVLNode = localAVLNode.left;
					} else {
						localAVLNode.linkleft(this.v = new AVLNode(this.v));
						break;
					}
				} else {
					// set comments to the textArea
					setText("gotorightside", this.value, localAVLNode.value);
					if (localAVLNode.right != null) {
						// get the right node
						localAVLNode = localAVLNode.right;
					} else {
						// create a new node
						this.v = new AVLNode(this.v);
						localAVLNode.linkright(this.v);
						break;

					}
				}
				// move the node above
				this.v.goAbove(localAVLNode);
				// wait until press next to do the next step
				mysuspend();
			}
			this.v = (this.avlTree.avlNode = null);
			this.avlTree.reposition();
			// set comments to the textArea
			setText("nodeinserted");
			// wait until press next to do the next step
			mysuspend();
			while (localAVLNode != null) {
				// this node will update
				localAVLNode.markNode();
				// Calculate the height and the size of this node
				localAVLNode.calc();
				// set comments to the textArea
				setText("treeupdated");
				// wait until press next to do the next step
				mysuspend();
				if (localAVLNode.balance() == -2) {
					if (localAVLNode.left.balance() != 1) {
						// set comments to the textArea
						setText("avlr");
						// this node will not update
						localAVLNode.unmarkNode();
						localAVLNode = localAVLNode.left;
						// this node will update
						localAVLNode.markNode();
						this.avlTree.rotate(localAVLNode);
					} else {
						// set comments to the textArea
						setText("avlrl");
						// this node will not update
						localAVLNode.unmarkNode();
						localAVLNode = localAVLNode.left.right;
						localAVLNode.markNode();
						this.avlTree.rotate(localAVLNode);
						// wait until press next to do the next step
						mysuspend();
						this.avlTree.rotate(localAVLNode);
					}
					// wait until press next to do the next step
					mysuspend();
				} else if (localAVLNode.balance() == 2) {
					if (localAVLNode.right.balance() != -1) {
						// set comments to the textArea
						setText("avll");
						localAVLNode.unmarkNode();
						localAVLNode = localAVLNode.right;
						localAVLNode.markNode();
						this.avlTree.rotate(localAVLNode);
					} else {
						// set comments to the textArea
						setText("avllr");
						localAVLNode.unmarkNode();
						localAVLNode = localAVLNode.right.left;
						localAVLNode.markNode();
						this.avlTree.rotate(localAVLNode);
						// wait until press next to do the next step
						mysuspend();
						this.avlTree.rotate(localAVLNode);
					}
					// wait until press next to do the next step
					mysuspend();
				}
				localAVLNode.unmarkNode();
				localAVLNode = localAVLNode.parent;
			}
		}
		// set comments to the textArea
		setText("insertdone");
	}
}
