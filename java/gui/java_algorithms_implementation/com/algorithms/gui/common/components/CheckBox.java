package com.algorithms.gui.common.components;

import javax.swing.JCheckBox;

import com.algorithms.gui.data_structures.avltree.MainPanel;

/**
 * CheckBox - This class is extends the JCheckBox class and it uses to create
 * CheckBox that can translate its text from English to Arabic and vice versa
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a
 *      href="https://github.com/vuquangtin/algorithm">https://github.com/vuquangtin/algorithm</a>
 *
 */
public class CheckBox extends JCheckBox {
	private static final long serialVersionUID = 1L;
	MainPanel m;
	String s;

	/**
	 * Constructor for CheckBox class
	 * 
	 * @param m
	 *            - object of MainPanel class
	 * @param s
	 *            - String
	 * @param b
	 *            - boolean (to set it is selected or not)
	 */
	public CheckBox(MainPanel m, String s, boolean b) {
		super(m.getString(s), b);
		this.m = m;
		this.s = s;
	}

	/**
	 * This method invokes when the user change the language and it acts as
	 * translator between the two languages
	 */
	public void refresh() {
		setText(this.m.getString(this.s));
	}
}