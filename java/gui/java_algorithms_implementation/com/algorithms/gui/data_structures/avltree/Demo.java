package com.algorithms.gui.data_structures.avltree;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

/**
 * 
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a
 *      href="https://github.com/vuquangtin/algorithm">https://github.com/vuquangtin/algorithm</a>
 *
 */
public class Demo {
	/**
	 * constructor for the Demo class
	 */
	public Demo() {
		// create the welcome frame
		final JFrame f = new JFrame("Welcome");
		// create the main frame in the system
		final JFrame frame = new JFrame("AVL Search Trees Animation System");
		// create the state button which will add to the welcome frame
		JButton start = new JButton("Start");

		// add the action listener to the start button
		start.addActionListener(new ActionListener() {

			// here is the event handler
			public void actionPerformed(ActionEvent e) {
				f.setVisible(false);
				MainPanel panel = new MainPanel();
				frame.add(panel);
				// set the layout of the main frame
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setVisible(true);
				frame.setSize(1200, 738);
			}

		});
		// create a panel that will add to the welcome frame
		JPanel welcomePanel = new JPanel(new GridLayout(3, 3, 3, 3));
		// create labels
		JLabel titleL = new JLabel(
				"                                                  Welcome");
		titleL.setBorder(new LineBorder(Color.black, 1));
		titleL.setFont(new Font("Arial", Font.BOLD, 18));
		JLabel emptyL = new JLabel("                                       ");

		JLabel welcomeL = new JLabel(
				"The system provides an animation and visualization of an AVL search tree data structure");
		welcomeL.setFont(new Font("Arial", Font.BOLD, 14));
		// add components to the welcomePanel
		welcomePanel.add(titleL);
		welcomePanel.add(emptyL);
		welcomePanel.add(welcomeL);

		f.setLayout(new FlowLayout());
		f.add(welcomePanel);
		f.add(start);
		f.setVisible(true);
		f.setSize(650, 180);

	}

	/**
	 * This is the main method in the project
	 * 
	 * @param paramArrayOfString
	 */
	public static void main(String[] paramArrayOfString) {
		Demo demo = new Demo();
	}
}