package com.algorithms.gui.data_structures.avltree;

/**
 * AnimationThread - this class is used to provide a control of animation for a
 * user, which means the user can use the Next button to control the animation
 * of AVL tree data structure and go step by step through it.
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a
 *      href="https://github.com/vuquangtin/algorithm">https://github.com/vuquangtin/algorithm</a>
 *
 */
public class AnimationThread extends Thread {
	MainPanel M;
	boolean suspended = false;

	/**
	 * Constructor for the AnimationThread class
	 * 
	 * @param M
	 *            - MainPanel
	 */
	public AnimationThread(MainPanel M) {
		this.M = M;
	}

	/**
	 * This method is used to suspend the thread
	 */
	public void mysuspend() {
		if (this.M.pause) {
			this.suspended = true;
			synchronized (this) {
				try {
					while (this.suspended) {
						wait();
					}
				} catch (InterruptedException localInterruptedException) {
				}
			}
		}
	}

	/**
	 * This method is used to resume the thread
	 */

	public void myresume() {
		synchronized (this) {
			this.suspended = false;
			notifyAll();
		}
	}

	/**
	 * This method is used to set the header of the textArea
	 * 
	 * @param s
	 *            - String
	 */
	public void setHeader(String s) {
		this.M.C.setHeader(s);
	}

	/**
	 * This method is used to set text to the textArea
	 * 
	 * @param s
	 *            - String
	 */
	public void setText(String s) {
		if (this.M.pause) {
			this.M.C.setText(s);
		}
	}

	/**
	 * This method is used to set the textArea to be blank
	 * 
	 */
	public void setText() {
		if (this.M.pause) {
			this.M.C.setText();
		}
	}

	/**
	 * This method is used to set text with two numbers to the textArea
	 * 
	 * @param s
	 *            - String
	 * @param num1
	 *            - int
	 * @param num2
	 *            - int
	 */
	public void setText(String s, int num1, int num2) {
		if (this.M.pause) {
			this.M.C.setText(s, num1, num2);
		}
	}

	/**
	 * This method is used to set text with a number to the textArea
	 * 
	 * @param s
	 *            - String
	 * @param num1
	 *            - int
	 */
	public void setText(String s, int num1) {
		if (this.M.pause) {
			this.M.C.setText(s, num1);
		}
	}

	/**
	 * Returns nothing
	 * 
	 * @return - String
	 */

	public String getText() {
		return "";
	}
}