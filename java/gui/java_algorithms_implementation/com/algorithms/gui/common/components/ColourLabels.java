package com.algorithms.gui.common.components;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.border.Border;

import com.algorithms.gui.data_structures.avltree.MainPanel;

/**
 * ColourLabels - This class extends JPanle class, it is used to illustrate the
 * use of colours in the visualisation
 * 
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a
 *      href="https://github.com/vuquangtin/algorithm">https://github.com/vuquangtin/algorithm</a>
 *
 */
public class ColourLabels extends JPanel {
	private static final long serialVersionUID = 1L;
	MainPanel m;
	Label label1, label2, label3, label4, label5, label6, label7, label8,
			heightNote;
	JPanel panel1, panel2_1, panel2_2, panel3_1, panel3_2, panel4_1, panel4_2,
			panel5;
	Font myFont = new Font("Arial", Font.BOLD, 14);

	/**
	 * constructor for ColourLabels class
	 * 
	 * @param m
	 *            - MainPanel
	 */
	public ColourLabels(MainPanel m) {
		this.m = m;
		// set the title of this panel
		Border etched3 = BorderFactory.createEtchedBorder();
		Border titled3 = BorderFactory.createTitledBorder(etched3,
				"Colour-coding");
		this.setBorder(BorderFactory.createCompoundBorder(titled3,
				BorderFactory.createEmptyBorder(5, 5, 5, 5)));
		panel1 = new JPanel(new BorderLayout());
		panel2_1 = new JPanel(new BorderLayout());
		panel2_2 = new JPanel(new BorderLayout());
		panel3_1 = new JPanel(new FlowLayout());
		panel3_2 = new JPanel(new FlowLayout());
		panel4_1 = new JPanel(new FlowLayout());
		panel4_2 = new JPanel(new FlowLayout());
		panel5 = new JPanel(new FlowLayout());

		label1 = new Label(m, "bluenode");
		label1.setColor(Color.blue);
		label1.setFont(myFont);
		label2 = new Label(m, "bluemeans");
		label2.setFont(myFont);
		label3 = new Label(m, "orangenode");
		label3.setColor(Color.orange);
		label3.setFont(myFont);
		label4 = new Label(m, "orangemeans");
		label4.setFont(myFont);
		label5 = new Label(m, "greennode");
		label5.setFont(myFont);
		label5.setColor(Color.green);
		label6 = new Label(m, "greenmeans");
		label6.setFont(myFont);
		label7 = new Label(m, "rednode");
		label7.setFont(myFont);
		label7.setColor(Color.red);
		label8 = new Label(m, "redmeans");
		label8.setFont(myFont);
		heightNote = new Label(m, "heightNote");
		heightNote.setFont(myFont);

		panel3_1.add(label1);
		panel3_1.add(label2);
		panel3_2.add(label3);
		panel3_2.add(label4);
		panel4_1.add(label5);
		panel4_1.add(label6);
		panel4_2.add(label7);
		panel4_2.add(label8);
		panel5.add(heightNote);

		panel1.add(panel2_1, "Center");
		panel1.add(panel2_2, "South");
		panel1.add(panel5, "North");
		panel2_1.add(panel3_1, "North");
		panel2_1.add(panel3_2, "South");
		panel2_2.add(panel4_1, "North");
		panel2_2.add(panel4_2, "South");

		this.add(panel1);

	}

	/**
	 * This method invokes when the user change the language and it acts as
	 * translator between the two languages
	 */
	public void refresh() {
		this.label1.refresh();
		this.label2.refresh();
		this.label3.refresh();
		this.label4.refresh();
		this.label5.refresh();
		this.label6.refresh();
		this.label7.refresh();
		this.label8.refresh();
		this.heightNote.refresh();
	}

	/**
	 * Returns the Blue node label
	 * 
	 * @return Label
	 */

	public Label getLabel1() {
		return label1;
	}

	/**
	 * Returns the label2
	 * 
	 * @return Label
	 */

	public Label getLabel2() {
		return label2;
	}

	/**
	 * Returns the label3
	 * 
	 * @return Label
	 */

	public Label getLabel3() {
		return label3;
	}

	/**
	 * Returns the label4
	 * 
	 * @return Label
	 */
	public Label getLabel4() {
		return label4;
	}

	/**
	 * Returns the label5
	 * 
	 * @return Label
	 */

	public Label getLabel5() {
		return label5;
	}

	/**
	 * Returns the label6
	 * 
	 * @return Label
	 */
	public Label getLabel6() {
		return label6;
	}

	/**
	 * Returns the label7
	 * 
	 * @return Label
	 */

	public Label getLabel7() {
		return label7;
	}

	/**
	 * Returns the label8
	 * 
	 * @return Label
	 */

	public Label getLabel8() {
		return label8;
	}

	/**
	 * Returns the heightNote label
	 * 
	 * @return Label
	 */
	public Label getHeightNote() {
		return heightNote;
	}

}