package com.algorithms.gui.common.components;

import java.awt.Font;

import javax.swing.JTextArea;

import com.algorithms.gui.data_structures.avltree.MainPanel;

/**
 * Description - This class extends JTextArea class, which used to show comments
 * that explain the meaning of each step of the animation.
 * 
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a
 *      href="https://github.com/vuquangtin/algorithm">https://github.com/vuquangtin/algorithm</a>
 *
 */
public class Description extends JTextArea {
	private static final long serialVersionUID = 1L;
	MainPanel m;
	String header;

	/**
	 * constructor for Description class
	 * 
	 * @param m
	 *            - MainPanel
	 */
	public Description(MainPanel m) {
		// set the layout of this component
		super(3, 80);
		setEditable(false);
		setFont(new Font("Default", 1, 13));
		this.m = m;
	}

	/**
	 * This method is used to set the header of the textArea
	 * 
	 * @param s
	 *            - String
	 */
	public void setHeader(String s) {
		this.header = this.m.getString(s);
	}

	/**
	 * This method is used to set the textArea to be blank
	 * 
	 */
	public void setText() {
		super.setText("");
	}

	/**
	 * This method is used to set a string to the textArea
	 * 
	 * @param s
	 *            - String
	 */
	public void setText(String s) {
		super.setText(this.header + " \n" + this.m.getString(s));
	}

	/**
	 * This method is used to set three strings to the textArea
	 * 
	 * @param s
	 *            - String
	 */
	public void setText(String s1, String s2, String s3) {
		super.setText(this.header
				+ "\n"
				+ this.m.getString(s1).replaceAll("#1", s2)
						.replaceAll("#2", s3));
	}

	/**
	 * This method is used to set two strings to the textArea
	 * 
	 * @param s1
	 *            - String
	 * @param s2
	 *            - String
	 */

	public void setText(String s1, String s2) {
		super.setText(this.header + "\n"
				+ this.m.getString(s1).replaceAll("#1", s2));
	}

	/**
	 * This method is used to set string with two numbers to the textArea
	 * 
	 * @param s
	 *            - String
	 * @param num1
	 *            - int
	 * @param num2
	 *            - int
	 */
	public void setText(String s, int num1, int num2) {
		setText(s, Integer.toString(num1), Integer.toString(num2));
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
		setText(s, Integer.toString(num1));
	}

	/**
	 * Returns string
	 * 
	 * @return - String
	 */
	public String getHeader() {
		return header;
	}

}