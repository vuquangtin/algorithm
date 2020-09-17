package com.algorithms.gui.data_structures.avltree;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

/**
 * AVLNode - this class is used to create a new node that will insert or search
 * for into the AVLTree data structure. Also, it is responsible for drawing this
 * node.
 * 
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a
 *      href="https://github.com/vuquangtin/algorithm">https://github.com/vuquangtin/algorithm</a>
 *
 */
public class AVLNode {
	AVLNode right = null;
	AVLNode left = null;
	AVLNode parent = null;
	// set variables
	int sumh = 1;
	int size = 1;
	int height = 1;
	int leftw, rightw, value, x, y, tox, toy, steps;
	AVLTree avl;
	boolean markedNode = false;
	Color fgcolor;
	Color bgcolor;
	FontMetrics fm;
	// set colours that will use to represent nodes cases
	static final Font LABEL_FONT = new Font("Arial", Font.BOLD, 15);
	static final Color NORMAL_COLOR = Color.yellow;
	static final Color INSERT_COLOR = Color.blue.brighter();
	static final Color FIND_COLOR = Color.orange;
	static final Color FOUND_COLOR = Color.green;
	static final Color NOTFOUND_COLOR = Color.red;
	static final Color DELETE_COLOR = Color.red;
	private int barb = 10; // barb length
	private double phi = Math.PI / 5; // degrees barb angle

	/**
	 * Constructor for the AVLNode class; to create a node with its position
	 * 
	 * @param avl
	 *            - AVLTree
	 * @param num1
	 *            - int element value
	 * @param num2
	 *            - int x position
	 * @param num3
	 *            - int y position
	 */
	public AVLNode(AVLTree avl, int num1, int num2, int num3) {
		this.avl = avl;
		this.value = num1;
		this.tox = num2;
		this.x = tox;
		this.toy = num3;
		this.y = toy;
		this.steps = 0;
		setColor(Color.black, NORMAL_COLOR);
	}

	/**
	 * Constructor for the AVLNode class; to create a node with its initial
	 * position
	 * 
	 * @param avl
	 *            - AVLTree
	 * @param value
	 *            - int element value
	 */

	public AVLNode(AVLTree avl, int value) {
		this(avl, value, -12, -12);

	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	/**
	 * Returns the x position of the node
	 * 
	 * @return - int
	 */
	public int getX() {
		return x;
	}

	/**
	 * Returns the y position of the node
	 * 
	 * @return - int
	 */
	public int getY() {
		return y;
	}

	/**
	 * Constructor for the AVLNode class
	 * 
	 * @param avlNode
	 *            - AVLNode
	 */
	public AVLNode(AVLNode avlNode) {
		this(avlNode.avl, avlNode.value, avlNode.x, avlNode.y);
	}

	/**
	 * Returns the height of the node
	 * 
	 * @return
	 */
	public int getHeight() {
		return height;
	}

	/**
	 * This method is used to check if the node is marked
	 * 
	 * @return - boolean
	 */

	public boolean isMarkedNode() {
		return markedNode;
	}

	/**
	 * This method is used to return the Phi value
	 * 
	 * @return - double
	 */

	public double getPhi() {
		return phi;
	}

	/**
	 * This method is used to return the barb value
	 * 
	 * @return - double
	 */

	public int getBarb() {
		return barb;
	}

	/**
	 * This method is used to check if the root is null
	 * 
	 * @return - boolean
	 */
	public boolean isRoot() {
		return this.parent == null;
	}

	/**
	 * This method is used to check if the node is left
	 * 
	 * @return - boolean
	 */

	public boolean isLeft() {
		return this.parent.left == this;
	}

	/**
	 * This method is used to link the node to the left side
	 * 
	 * @param avlNode
	 *            - AVLNode
	 */
	public void linkleft(AVLNode avlNode) {
		this.left = avlNode;
		if (avlNode != null) {
			avlNode.parent = this;

		}
	}

	/**
	 * This method is used to link the node to the right side
	 * 
	 * @param avlNode
	 *            - AVLNode
	 */
	public void linkright(AVLNode avlNode) {
		this.right = avlNode;
		if (avlNode != null) {
			avlNode.parent = this;

		}
	}

	/**
	 * This method is used to calculate the height, size of the node
	 */
	public void calc() {
		// set variables
		int s = 0, t = 0, h = 0, m = 0, n = 0, i = 0;
		if (this.right != null) {
			t = this.right.size;
			m = this.right.height;
			i = this.right.sumh;
		}
		if (this.left != null) {
			s = this.left.size;
			h = this.left.height;
			n = this.left.sumh;
		}
		this.height = (1 + Math.max(h, m));
		this.size = (s + t + 1);
		this.sumh = (n + i + this.size);
		balance();

	}

	public void calcTree() {
		if (this.left != null) {
			this.left.calcTree();
		}
		if (this.right != null) {
			this.right.calcTree();
		}
		calc();
	}

	/**
	 * Returns the balance factor of the node
	 * 
	 * @return
	 */
	public int balance() {
		int k = this.left == null ? 0 : this.left.height;
		int t = this.right == null ? 0 : this.right.height;
		return t - k;
	}

	/**
	 * This method is used to draw the tree by drawing the lines with their
	 * arrowheads that connect nodes with each other in the tree and then draw
	 * these nodes.
	 * 
	 * @param g
	 *            - Graphics
	 */
	public void drawTree(Graphics g) {
		// make lines smooth
		((Graphics2D) g).setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);

		if (this.right != null) {
			g.setColor(Color.black);
			// draw a line to connect two nodes
			g.drawLine(this.x, this.y, this.right.x, this.right.y);
			// draw arrow at the end of the line
			drawArrow(g, this.x, this.y, this.right.x, this.right.y);
			this.right.drawTree(g);
		}
		if (this.left != null) {
			g.setColor(Color.black);
			g.drawLine(this.x, this.y, this.left.x, this.left.y);
			drawArrow(g, this.x, this.y, this.left.x, this.left.y);
			this.left.drawTree(g);
		}

		draw(g);
	}

	/**
	 * This method is used to draw the arrowhead at the end of each line.
	 * 
	 * @param g
	 *            - Graphics
	 * @param x1
	 *            - int
	 * @param y1
	 *            - int
	 * @param x2
	 *            - int
	 * @param y2
	 *            - int
	 */
	private void drawArrow(Graphics g, double x1, double y1, double x2,
			double y2) {
		double theta = Math.atan2(y2 - y1, x2 - x1);

		x2 = x2 - 14 * Math.cos(theta);
		y2 = y2 - 14 * Math.sin(theta);

		int a1 = (int) x2;
		int b1 = (int) y2;
		int a2 = (int) (x2 - barb * Math.cos(theta + phi));
		int b2 = (int) (y2 - barb * Math.sin(theta + phi));
		int a3 = (int) (x2 - barb * Math.cos(theta - phi));
		int b3 = (int) (y2 - barb * Math.sin(theta - phi));

		int[] xpoints = { a1, a3, a2 };
		int[] ypoints = { b1, b3, b2 };

		int sides = 3;
		g.fillPolygon(xpoints, ypoints, sides);
	}

	/**
	 * This method is used to draw the node as a circle and the value of the
	 * node then draw the height of this node above to it.
	 * 
	 * @param g
	 *            - Graphics
	 */
	public void draw(Graphics g) {
		drawBg(g);
		if (this.bgcolor == AVLNode.NORMAL_COLOR) {
			g.setColor(Color.yellow);
			g.setColor(this.fgcolor);
			// draw the node as a circle
			g.drawOval(this.x - this.avl.radius, this.y - this.avl.radius,
					2 * this.avl.radius, 2 * this.avl.radius);
		}
		// draw the value inside the node
		drawValue(g);

		// set the font to draw the height of the node
		Font myfont = new Font("Arial", Font.BOLD, 10);
		fm = g.getFontMetrics(myfont);
		g.setFont(myfont);
		// draw the height above the node
		g.drawString("" + this.height, this.x + this.avl.radius - 12, this.y
				- this.avl.radius - 1);
	}

	public void moveTree() {
		// check if the node at right side of this node is null or not
		if (this.right != null) {
			// go to the next right node
			this.right.moveTree();
		}
		// check if the node at left side of this node is null or not
		if (this.left != null) {
			// go to the next left node
			this.left.moveTree();
		}

		move();
	}

	public void rebox() {
		this.leftw = (this.left == null ? this.avl.xspan + this.avl.radius
				: this.left.leftw + this.left.rightw);
		this.rightw = (this.right == null ? this.avl.xspan + this.avl.radius
				: this.right.leftw + this.right.rightw);
	}

	/**
	 * This method is used to go through the tree until find the
	 */
	public void reboxTree() {
		if (this.right != null) {
			this.right.reboxTree();
		}

		if (this.left != null) {
			this.left.reboxTree();
		}

		rebox();
	}

	protected void repos() {
		if (isRoot()) {
			goToRoot();
		}

		if (this.right != null) {
			this.right.goTo(this.tox + this.right.leftw, this.toy + 2
					* this.avl.radius + this.avl.yspan);
			this.right.repos();
		}
		if (this.left != null) {
			this.left.goTo(this.tox - this.left.rightw, this.toy + 2
					* this.avl.radius + this.avl.yspan);
			this.left.repos();
		}
	}

	public void _reposition() {
		reboxTree();
		repos();
	}

	public void setColor(Color color1, Color color2) {
		this.fgcolor = color1;
		this.bgcolor = color2;
	}

	/**
	 * set the colour
	 * 
	 * @param color
	 *            - Color
	 */
	public void fgColor(Color color) {
		this.fgcolor = color;
	}

	/**
	 * Set the background color * @param color - Color
	 */
	public void bgColor(Color color) {
		this.bgcolor = color;
	}

	/**
	 * set the node to be marked
	 */
	public void markNode() {
		this.markedNode = true;
	}

	/**
	 * Set the root to be unmarked
	 */
	public void unmarkNode() {
		this.markedNode = false;
	}

	/**
	 * This method is used to draw the background of the node.
	 * 
	 * @param g
	 *            - Graphics
	 */
	public void drawBg(Graphics g) {
		g.setColor(this.bgcolor);
		g.fillOval(this.x - this.avl.radius, this.y - this.avl.radius,
				2 * this.avl.radius, 2 * this.avl.radius);
		g.setColor(this.fgcolor);
		g.drawOval(this.x - this.avl.radius, this.y - this.avl.radius,
				2 * this.avl.radius, 2 * this.avl.radius);
		// if the node is marked to update its balance factor
		if (this.markedNode) {
			g.drawOval(this.x - this.avl.radius - 2, this.y - this.avl.radius
					- 2, 2 * this.avl.radius + 4, 2 * this.avl.radius + 4);
		}
	}

	/**
	 * This method is used to draw the value of the node.
	 * 
	 * @param g
	 *            - Graphics
	 */
	public void drawValue(Graphics g) {
		g.setColor(this.fgcolor);
		if (this.value != -1) {
			g.setFont(LABEL_FONT);
			fm = g.getFontMetrics(LABEL_FONT);
			g.drawString("" + this.value,
					this.x - fm.stringWidth("" + this.value) / 2,
					this.y - fm.getHeight() / 2 + fm.getAscent());
		}
	}

	/**
	 * This method is used to move the node by change its position
	 * 
	 * @param num1
	 *            - int position
	 * @param num2
	 *            - int position
	 */
	public void goTo(int num1, int num2) {
		this.tox = num1;
		this.toy = num2;
		this.steps = this.avl.M.STEPS;
	}

	/**
	 * This method is used to from its x and y positions to tox and toy
	 * positions
	 * 
	 * @param node
	 */
	public void goTo(AVLNode node) {
		goTo(node.tox, node.toy);
	}

	/**
	 * This method is used to set a position to the new node with blue color
	 * above to the local node before set it in its position in the tree.
	 */
	public void goAbove(AVLNode node) {
		goTo(node.tox, node.toy - 2 * this.avl.radius - this.avl.yspan);
	}

	/**
	 * This method is used to set a position to the new node when the tree is
	 * empty and it becomes the root of the tree.
	 */
	public void goToRoot() {
		goTo(this.avl.rootx, this.avl.rooty);
	}

	/**
	 * This method is used to set a position to the new node with blue color
	 * above the root before set it in its position in the tree.
	 */
	public void goAboveRoot() {
		goTo(this.avl.rootx, this.avl.rooty - 2 * this.avl.radius
				- this.avl.yspan);
	}

	/**
	 * This method is used to move the new node or the search node to the right
	 * side of the tree to insert or search for a number into the tree
	 */
	public void goRight() {
		goTo(this.avl.swidth + this.avl.radius, this.avl.sheight + 3
				* this.avl.radius);
	}

	/**
	 * This method is used to move the new node or the search node to the left
	 * side of the tree to insert or search for a number into the tree
	 */
	public void goLeft() {
		goTo(-this.avl.radius, this.avl.sheight + 3 * this.avl.radius);
	}

	/**
	 * This method is used to drop the new node with red color in case it
	 * already in the tree or the number is not found.
	 */
	public void goDown() {
		goTo(this.tox, this.avl.sheight + 3 * this.avl.radius);
	}

	/**
	 * This method is used to move the new node from its initial position at the
	 * top left side of the screen to be sit at its new position.
	 */
	public void move() {
		if (this.steps > 0) {
			this.x += (this.tox - this.x) / this.steps;
			this.y += (this.toy - this.y) / this.steps;
			this.steps -= 1;
		}
	}

}