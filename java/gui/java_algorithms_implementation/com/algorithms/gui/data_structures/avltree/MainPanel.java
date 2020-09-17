package com.algorithms.gui.data_structures.avltree;

import java.awt.BorderLayout;
import java.awt.ComponentOrientation;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.Border;

import com.algorithms.gui.common.components.Button;
import com.algorithms.gui.common.components.ColourLabels;
import com.algorithms.gui.common.components.Description;
import com.algorithms.gui.common.components.Label;

/**
 * 
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a
 *      href="https://github.com/vuquangtin/algorithm">https://github.com/vuquangtin/algorithm</a>
 *
 */
public class MainPanel extends JPanel implements ActionListener {

	private static final long serialVersionUID = 1L;
	ControlButtons buttonsPanel;
	ColourLabels labelsPanel;
	Description C;
	AVLTree avl;
	TreeCanvas T;
	int STEPS = 10;
	boolean pause = true;
	JTextArea textMessage;
	Button about, help, close;
	Label label9;
	JScrollPane scroll2;
	String lang;
	int current_lang;
	Locale[] all_locales = new Locale[2];
	ResourceBundle[] all_msgs = new ResourceBundle[2];
	Locale locale;
	ResourceBundle msg;
	JButton b;
	JPanel panel, panel1, panel2, panel3, panel4;

	/**
	 * Constructor for MainPanel class
	 */
	public MainPanel() {
		// initialise all components
		init();
	}

	/**
	 * This method is used to initialise all components that will locate on this
	 * panel
	 */
	public void init() {
		// set the preferred size of this panel
		setPreferredSize(new Dimension(1200, 680));
		// initialise and set the layout of sub panels
		panel = new JPanel(new BorderLayout());
		panel1 = new JPanel(new BorderLayout());
		panel2 = new JPanel(new FlowLayout());
		panel3 = new JPanel(new BorderLayout());
		panel4 = new JPanel(new FlowLayout());

		// initialise the all_locales and all_msgs objects
		this.all_locales[0] = new Locale("en");
		this.all_msgs[0] = ResourceBundle.getBundle("Messages",
				this.all_locales[0]);
		this.all_locales[1] = new Locale("ar");
		this.all_msgs[1] = ResourceBundle.getBundle("Messages_ar",
				this.all_locales[1]);

		this.lang = "en";
		if (this.lang.equals("ar")) {
			this.current_lang = 1;
			this.b = new JButton("English");
		} else {
			this.current_lang = 0;
			this.b = new JButton("Arabic");
		}
		this.locale = this.all_locales[this.current_lang];
		this.msg = this.all_msgs[this.current_lang];

		this.b.setActionCommand("lang");
		this.b.addActionListener(this);

		label9 = new Label(this, "ChangeL");

		// set the title of the textArea panel
		Border etched2 = BorderFactory.createEtchedBorder();
		Border titled2 = BorderFactory.createTitledBorder(etched2, "Comments");
		panel1.setBorder(BorderFactory.createCompoundBorder(titled2,
				BorderFactory.createEmptyBorder(5, 5, 5, 5)));

		// declare object of TreeCanves class
		this.T = new TreeCanvas();
		// declare object of AVLTree class
		this.avl = new AVLTree(this);
		// declare object of ControlButtons class
		this.buttonsPanel = new ControlButtons(this);
		// declare object of ColourLabels class
		this.labelsPanel = new ColourLabels(this);

		// declare about button
		about = new Button(this, "about");
		about.addActionListener(new ActionListener() {
			// here is the event handler of about button
			public void actionPerformed(ActionEvent e) {
				// set font style
				Font myFont = new Font("Arial", Font.BOLD, 14);
				// initialise a frame for the about button
				final JFrame aboutFrame = new JFrame("About");
				JPanel aboutPanel = new JPanel(new GridLayout(6, 10, 10, 6));
				// labels contain notes that add to about panel
				JLabel titleL = new JLabel(
						"                        Information");
				titleL.setFont(new Font("Arial", Font.BOLD, 18));

				JLabel projectNameL = new JLabel(
						"      An AVL Tree Algorithm Animation System");
				projectNameL.setFont(myFont);

				JLabel developerNameL = new JLabel(
						"             Developed by Aishah Ahmed");
				developerNameL.setFont(myFont);

				JLabel emailL = new JLabel(
						"                          a.ahmad@ncl.ac.uk");
				emailL.setFont(myFont);

				JLabel dateL = new JLabel(
						"                                2013-2014");
				dateL.setFont(myFont);

				// initialise close button for the about frame
				JButton closeB = new JButton("Close");
				closeB.addActionListener(new ActionListener() {
					// here is the event handler of close button
					public void actionPerformed(ActionEvent e) {
						aboutFrame.setVisible(false);
					}
				});
				// add labels to about panel
				aboutPanel.add(titleL);
				aboutPanel.add(projectNameL);
				aboutPanel.add(developerNameL);
				aboutPanel.add(emailL);
				aboutPanel.add(dateL);
				// set the layout of the about frame
				aboutFrame.setLayout(new FlowLayout());
				// add the about panel to the about frame
				aboutFrame.add(aboutPanel);
				aboutFrame.add(closeB);
				aboutFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				aboutFrame.setVisible(true);
				aboutFrame.setSize(350, 250);

			}
		});

		// declare help button
		help = new Button(this, "help");
		help.addActionListener(new ActionListener() {
			// here is the event handler of help button
			public void actionPerformed(ActionEvent e) {
				// initialise a frame for the help button
				final JFrame helpFrame = new JFrame("Help");
				// initialise close button for the help frame
				JButton closeB = new JButton("Close");
				closeB.addActionListener(new ActionListener() {
					// here is the event handler of close button
					public void actionPerformed(ActionEvent e) {
						helpFrame.setVisible(false);
					}
				});

				// set the layout of the textArea
				JTextArea textMessage = new JTextArea(21, 43);
				textMessage.setFont(new Font("Default", 1, 13));
				textMessage.setEditable(false);
				textMessage.setLineWrap(true);
				JScrollPane scroll = new JScrollPane(textMessage);
				scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
				// add comments to textMessage
				textMessage
						.setText("                                                        Help \n \nThis animated application illustrates the behaviour of an AVL-balanced binary. \n tree. \n"
								+ "\n");
				textMessage
						.append("-Insert Node button:"
								+ "\n"
								+ "To insert an element into an AVLL tree, write the input into the Input Data text "
								+ "\n"
								+ "field. (Input data is an integer from 0 to 99); lower or greater numbers will be \nchanged to 0 or 99.) Then press Insert Node button the operation will start."
								+ "\n"
								+ "If you don't type anything in the input text field and press insert, it will insert a random number. You can type several values into the input text feild separated by spaces and the press some action button. \n \n");
				textMessage
						.append("-Find button:"
								+ "\n"
								+ "To search for an element into an AVLL tree data structure, write the input into \nthe Input Data text field. (Input data is an integer from 0 to 99); lower or greater numbers will be changed to 0 or 99.) Then press Find button the operation will \nstart."
								+ "If you don't type anything in the input box and press Find, nothing will \nhappen. \n \n");

				textMessage
						.append("-Next button:"
								+ "\n"
								+ "To move to the next step after inserting or searching for a number you need to \npress on this button and you can follow the AVL tree step by step\n \n");

				textMessage
						.append("-Check box Pause:"
								+ "\n"
								+ "If you don't want to see the animation and you just want to make some changes \nto the tree you can make the Pause box unchecked. \n \n");

				textMessage
						.append("- Animation Speed:"
								+ "\n"
								+ "You can change the speed of the animation and make it slower or faster by using\nthis option which allows you to manipulate the animation speed. \n \n");

				textMessage
						.append("- Clear button:"
								+ "\n"
								+ "This button allows you to delete all nodes in the tree and makes all text fields\nempty. \n \n");

				textMessage
						.append("- Insert Subtree button:"
								+ "\n"
								+ "You can use this button to generate a random sub tree, which means if you press \nthis button, sub tree of eight random numbers will generate by default .Also, you\ncan type a number of nodes that will be inserted randomly. \n \n");

				textMessage
						.append("- Print:"
								+ "\n"
								+ "This button allows you to print a tree that painted on the AVL tree section. \n \n");

				textMessage
						.append("- Change language to Arabic button:"
								+ "\n"
								+ "You can change the interface language from English to Arabic and vice versa by using this button. \n \n");

				textMessage
						.append("- About button:"
								+ "\n"
								+ "Information about the developer will provide from this button. \n \n");

				// set the layout of the help frame
				helpFrame.setLayout(new FlowLayout());
				// add components to the help frame
				helpFrame.add(scroll, "Center");
				helpFrame.add(closeB, "South");
				helpFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				helpFrame.setVisible(true);
				helpFrame.setSize(550, 460);

			}
		});

		// initialise close button for the about frame
		close = new Button(this, "exit");
		close.addActionListener(new ActionListener() {
			// here is the event handler of close button
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		// add labels to about panel

		// declare an object of Description class
		this.C = new Description(this);
		scroll2 = new JScrollPane(this.C);
		scroll2.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

		panel1.add(scroll2);
		panel2.add(this.buttonsPanel);
		panel3.add(this.labelsPanel);
		panel4.add(label9);
		panel4.add(Box.createHorizontalGlue());
		panel4.add(this.b);
		panel4.add(this.help);
		panel4.add(this.about);
		panel4.add(this.close);

		panel.add(panel1, "South");
		panel.add(panel3, "Center");
		panel.add(T, "North");

		this.add(panel2, "North");
		this.add(panel, "Center");
		this.add(panel4, "South");

		this.T.setDS(this.avl);
		this.T.setDS(this);
		this.T.setB(buttonsPanel);
		this.T.start();
	}

	/**
	 * This method invokes when the user change the language and it acts as
	 * translator between the two languages
	 */
	public void refresh() {
		this.buttonsPanel.refresh();
		this.labelsPanel.refresh();
		this.label9.refresh();
		this.help.refresh();
		this.about.refresh();
		this.close.refresh();

	}

	public String getString(String s) {
		return this.all_msgs[this.current_lang].getString(s);
	}

	/**
	 * This method is the event handler of change language button
	 */

	public void actionPerformed(ActionEvent e) {

		if ("lang".equals(e.getActionCommand())) {
			this.current_lang = (1 - this.current_lang);
			if (this.current_lang == 0) {
				// set the text of button to Arabic
				this.b.setText("Arabic");
				// change the layout of the scroll to be at the left side of
				// textArea
				scroll2.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
				C.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
			}

			else if (this.current_lang == 1) {
				this.b.setText("English");
				// change the layout of the scroll to be at the right side of
				// textArea
				scroll2.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
				C.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);

			}
			this.locale = this.all_locales[this.current_lang];
			this.msg = this.all_msgs[this.current_lang];
			refresh();
		}
	}

	/**
	 * Returns number of steps
	 * 
	 * @return - int
	 */
	public int getSTEPS() {
		return STEPS;
	}

	/**
	 * Returns if pause is selected or not
	 * 
	 * @param pause
	 *            - boolean
	 */
	public boolean isPause() {
		return pause;
	}

	/**
	 * Returns the about button
	 * 
	 * @return - Button
	 */
	public Button getAbout() {
		return about;
	}

	/**
	 * Returns the help button
	 * 
	 * @return - Button
	 */
	public Button getHelp() {
		return help;
	}

	/**
	 * Returns the Label9
	 * 
	 * @return - Label
	 */
	public Label getLabel9() {
		return label9;
	}

}
