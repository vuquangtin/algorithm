package com.algorithms.gui.data_structures.avltree;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.border.Border;

/**
 * TreeCanvas - This class extends the JPanel class and implements Runnable
 * interface. This panel is used to draw the AVL tree data structure on it.
 * 
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a
 *      href="https://github.com/vuquangtin/algorithm">https://github.com/vuquangtin/algorithm</a>
 *
 */
public class TreeCanvas extends JPanel implements Runnable {

	private static final long serialVersionUID = 1L;
	Thread t = null;
	boolean suspended;
	AVLTree avl = null;
	AVLNode avlNode;
	MainPanel m;
	Image image;
	Graphics g;
	Dimension size;
	ControlButtons b;

	/**
	 * Constructor for the TreeCanvas class
	 */
	public TreeCanvas() {
		// set the title of this panel
		Border etched1 = BorderFactory.createEtchedBorder();
		Border titled1 = BorderFactory.createTitledBorder(etched1,
				"An AVL Tree");
		setBorder(BorderFactory.createCompoundBorder(titled1,
				BorderFactory.createEmptyBorder(5, 5, 5, 5)));
		// set the size of this panel
		setPreferredSize(new Dimension(900, 300));
		setMinimumSize(new Dimension(600, 200));

	}

	/**
	 * Method used to set the MainPanel
	 * 
	 * @param m
	 *            - MainPanel
	 */

	public void setDS(MainPanel m) {
		this.m = m;
	}

	/**
	 * Method used to set the AVLTree
	 * 
	 * @param avl
	 *            - AVLTree
	 */

	public void setDS(AVLTree avl) {
		this.avl = avl;
	}

	/**
	 * Method used to set the ControlButtons
	 * 
	 * @param B
	 *            - ControlButtons
	 */
	public void setB(ControlButtons B) {
		this.b = B;
	}

	/**
	 * Check the size of this panel and base on that set the x and y position of
	 * each node into the AVL tree.
	 */
	void check_size() {
		Dimension localDimension = getSize();
		if ((this.image == null) || (localDimension.width != this.size.width)
				|| (localDimension.height != this.size.height)) {
			this.image = createImage(localDimension.width,
					localDimension.height);
			this.g = this.image.getGraphics();
			this.size = localDimension;
			this.avl.resize();
		}
	}

	/**
	 * Resets the panel
	 */
	void clear() {
		this.g.setColor(Color.white);
		this.g.fillRect(0, 0, this.size.width, this.size.height);
	}

	/**
	 * Check the white and the height of this panel and draw the tree on it
	 */
	public void paintComponent(Graphics g) {
		check_size();
		clear();
		if (this.avl != null) {
			this.avl.draw(this.g);
		} else {
			System.out.println("");
		}
		g.drawImage(this.image, 0, 0, null);
	}

	/**
	 * Starts running this thread
	 */
	public void start() {
		if (this.t == null) {
			this.t = new Thread(this);
			this.t.start();
		}
	}

	/**
	 * Repaints the tree and change the speed of the animation
	 */
	public void run() {
		while (true) {
			repaint();
			try {
				Thread.sleep(b.getSpeedSlider().getValue());
			} catch (InterruptedException e) {
				break;
			}
		}
	}

}