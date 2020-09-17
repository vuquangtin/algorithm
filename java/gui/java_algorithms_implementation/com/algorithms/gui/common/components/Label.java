package com.algorithms.gui.common.components;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;

import com.algorithms.gui.data_structures.avltree.MainPanel;

/**
 * Label - This class is extends the JLabel class and it uses to create Labels
 * that can translate its text from English to Arabic and vice versa.
 * 
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a
 *      href="https://github.com/vuquangtin/algorithm">https://github.com/vuquangtin/algorithm</a>
 *
 */
public class Label extends JLabel {
	private static final long serialVersionUID = 1L;
	MainPanel m;
	String s;

	/**
	 * Constructor for Label class
	 * 
	 * @param m
	 *            - object of MainPanel class
	 * @param s
	 *            - String
	 */
	public Label(MainPanel m, String s) {
		super(m.getString(s));
		setFont(new Font("Default", 1, 13));
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

	public void setColor(Color c) {
		setForeground(c);
	}

}