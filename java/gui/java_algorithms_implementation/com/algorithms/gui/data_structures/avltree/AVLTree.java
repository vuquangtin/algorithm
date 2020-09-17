package com.algorithms.gui.data_structures.avltree;

import java.awt.Graphics;

/**
 * AVLTree - This class represents Implementation of an AVL Tree, along with
 * code to test insertions on the tree. Based on code written by Mark Allen
 * Weiss in his book Data Structures and Algorithm Analysis in Java.
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a
 *      href="https://github.com/vuquangtin/algorithm">https://github.com/vuquangtin/algorithm</a>
 *
 */
public class AVLTree {
	AVLNode avlNode = null;
	AVLNode root = null;
	AnimationThread A;
	int radius;
	int xspan;
	int yspan;
	int rootx;
	int rooty;
	int sheight;
	int swidth;
	MainPanel M;

	/**
	 * Constructor for the AVLTree class
	 * 
	 * @param M
	 *            - MainPanel
	 */
	public AVLTree(MainPanel M) {
		this.M = M;
	}

	/**
	 * Insert an element into the tree.
	 * 
	 * @param num
	 *            - int element to add
	 * 
	 */
	public void insert(int num) {
		AVLInsert newNode = new AVLInsert(this, num);
		start(newNode);
	}

	/**
	 * Search for an element within the tree.
	 * 
	 * @param num
	 *            - Element to find
	 */

	public void find(int num) {
		AVLFind findNode = new AVLFind(this, num);
		start(findNode);
	}

	/**
	 * This method resumes the animation and it calls by next button which used
	 * to allow the user to go through the animation step by step.
	 */
	public void next() {
		this.A.myresume();
	}

	/**
	 * This method is used to start the AnimationThread.
	 * 
	 * @param a
	 *            - AnimationThread
	 */
	void start(AnimationThread a) {
		this.A = a;
		this.A.start();
		try {
			this.A.join();
		} catch (InterruptedException localInterruptedException) {
		}
	}

	/**
	 * This method makes the tree empty.
	 */
	public void clear() {
		this.root = null;
		this.avlNode = null;
		A.setText();
	}

	/**
	 * The method is used to draw the AVL tree on the TreeCanvs panel.
	 * 
	 * @param g
	 */
	public void draw(Graphics g) {
		if (this.root != null) {
			this.root.moveTree();
			this.root.drawTree(g);
		}
		if (this.avlNode != null) {
			this.avlNode.move();
			this.avlNode.draw(g);
		}
	}

	/**
	 * Resets the positions of the node based on the width and height of
	 * TreeCanvs panel.
	 */
	public void resize() {
		this.radius = 15;
		this.xspan = 12;
		this.yspan = 10;
		// the screen width
		this.swidth = this.M.T.size.width;
		// the screen height
		this.sheight = this.M.T.size.height;
		// the x position
		this.rootx = (this.swidth / 2);
		// the y position
		this.rooty = (5 * this.radius + this.yspan);
		if (this.root != null) {
			reposition();
		}
	}

	/**
	 * Rotate AVL tree node with left child.
	 * 
	 * @param avlNode
	 *            - AVLNode
	 */
	protected void leftRotation(AVLNode avlNode) {
		AVLNode localAVLNode = avlNode.parent;
		if (localAVLNode.isRoot()) {
			this.root = avlNode;
			avlNode.parent = null;
		} else if (localAVLNode.isLeft()) {
			localAVLNode.parent.linkleft(avlNode);
		} else {
			localAVLNode.parent.linkright(avlNode);
		}
		if (avlNode.left == null) {
			localAVLNode.right = null;
		} else {
			localAVLNode.linkright(avlNode.left);
		}
		avlNode.linkleft(localAVLNode);
	}

	/**
	 * Rotate AVL tree node with right child.
	 * 
	 * @param avlNode
	 *            - AVLNode
	 */
	protected void rightRotation(AVLNode avlNode) {
		AVLNode localAVLNode = avlNode.parent;
		if (localAVLNode.isRoot()) {
			this.root = avlNode;
			avlNode.parent = null;
		} else if (localAVLNode.isLeft()) {
			localAVLNode.parent.linkleft(avlNode);
		} else {
			localAVLNode.parent.linkright(avlNode);
		}
		if (avlNode.right == null) {
			localAVLNode.left = null;
		} else {
			localAVLNode.linkleft(avlNode.right);
		}
		avlNode.linkright(localAVLNode);
	}

	/**
	 * The AVL tree requires rotation
	 * 
	 * @param avlNode
	 *            - AVLNode
	 */
	public void rotate(AVLNode avlNode) {
		if (avlNode.isLeft()) {
			rightRotation(avlNode);
		} else {
			leftRotation(avlNode);
		}
		reposition();
		if (avlNode.left != null) {
			avlNode.left.calc();
		}
		if (avlNode.right != null) {
			avlNode.right.calc();
		}
		avlNode.calc();
	}

	/**
	 * reposition the AVL tree after the rotation
	 */
	public void reposition() {
		if (this.root != null) {
			this.root._reposition();
		}
	}

	/**
	 * Returns the root of the AVL tree
	 * 
	 * @return - AVLNode
	 */
	public AVLNode getRoot() {
		return root;
	}

	/**
	 * Returns the radius of the node
	 * 
	 * @return - int
	 */
	public int getRadius() {
		return radius;
	}

	/**
	 * Returns the height of the node
	 * 
	 * @return - int
	 */
	public int getSheight() {
		return sheight;
	}

	/**
	 * Returns the width
	 * 
	 * @return
	 */
	public int getSwidth() {
		return swidth;
	}

}