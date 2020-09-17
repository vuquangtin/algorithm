package com.algorithms.gui.data_structures.avltree;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.PageFormat;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.util.ArrayList;
import java.util.Random;
import java.util.StringTokenizer;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.border.Border;

import com.algorithms.gui.common.components.Button;
import com.algorithms.gui.common.components.CheckBox;
import com.algorithms.gui.common.components.Label;
import com.algorithms.gui.common.utils.Printer;

/**
 * ControlButtons - This class is used to create a panel that will contain the
 * control components in the system such as Insert Node, Find, Next, Animation
 * Speed, Clear, and Pause check box. Each component has a specific task to do
 * when a user clicks on it.
 * 
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a
 *      href="https://github.com/vuquangtin/algorithm">https://github.com/vuquangtin/algorithm</a>
 *
 */
public class ControlButtons extends JPanel implements ActionListener {
	private static final long serialVersionUID = 1L;
	MainPanel M;
	AVLTree avl;
	int numButtons;
	int numInputs;
	JTextField inputTF1, inputTF2;
	Label inputL;
	Button[] button;
	Button insert, find, next, clear, print, random;
	CheckBox pause;
	JSlider speedSlider;
	Label speedL;

	/**
	 * Constructor for ControlButtons class which create a panel
	 * 
	 * @param M
	 *            - MainPanel
	 */
	public ControlButtons(MainPanel M) {
		this.M = M;
		// get the AVL data structure from the MainPanel class
		this.avl = M.avl;
		// specified the size of button array
		this.numButtons = 2;
		// check whether the AVL data structure is initialised or not yet
		assert (this.avl != null) : "AVL data structure is null";
		// initialise the button array
		this.button = new Button[this.numButtons];

		// set the layout of the Input Data text field
		inputL = new Label(M, "input");
		this.add(this.inputL);

		// set the layout of the Input Data text field
		this.inputTF1 = new JTextField(5);
		this.add(this.inputTF1);
		this.inputTF1.addActionListener(this);

		// set the layout of the Insert button
		insert = new Button(M, "insert");
		insert.setMnemonic(73);
		this.add(this.button[0] = insert);
		this.insert.setEnabled(true);
		insert.addActionListener(this);

		// set the layout of the Find button
		find = new Button(M, "find");
		find.setMnemonic(73);
		this.add(this.button[1] = find);
		this.find.setEnabled(true);
		find.addActionListener(this);

		// set the layout of the Next button
		this.next = new Button(M, "next");
		this.add(this.next);
		this.next.setMnemonic(78);
		this.next.setEnabled(false);
		this.next.addActionListener(this);

		// set the layout of the Pause check box
		this.pause = new CheckBox(M, "pause", true);
		this.pause.setMnemonic(80);
		this.pause.addActionListener(this);
		this.add(this.pause);

		// set the layout of the Animation Speed lapel
		this.speedL = new Label(M, "AnimationSpeed");
		this.add(speedL);

		// set the layout of the Speed Slider
		this.speedSlider = new JSlider(JSlider.HORIZONTAL);
		this.speedSlider = new JSlider();
		this.add(speedSlider);

		// set the layout of the Clear button
		this.clear = new Button(M, "clear");
		this.clear.setMnemonic(67);
		this.clear.addActionListener(this);
		this.add(this.clear);

		// set the layout of the Input text field
		this.inputTF2 = new JTextField(5);
		this.add(this.inputTF2);
		this.inputTF2.addActionListener(this);

		// set the layout of the Insert Subtree button
		this.random = new Button(M, "random");
		this.random.setMnemonic(82);
		this.random.addActionListener(this);
		this.add(this.random);

		// set the layout of the Print button
		this.print = new Button(M, "Print");
		this.add(this.print);
		this.print.setMnemonic(78);
		this.print.setEnabled(true);
		this.print.addActionListener(this);

		// set the title style of the panel
		Border etched = BorderFactory.createEtchedBorder();
		Border titled = BorderFactory.createTitledBorder(etched, "control");
		this.setBorder(BorderFactory.createCompoundBorder(titled,
				BorderFactory.createEmptyBorder(5, 5, 5, 5)));

	}

	/**
	 * This method is invoked when an action event occurs, whenever an action is
	 * performed by the user. Thus, if the user clicks on any button that
	 * handles an event then an action will generate.
	 */
	public void actionPerformed(ActionEvent e) {
		// initialise an ArrayList that will use to store data from text field
		// before insert it into an AVL tree data structure
		ArrayList<Integer> nums;
		// check the source of event
		if (e.getSource() == this.next) {
			this.avl.next();
		} else if (e.getSource() == this.clear) {
			// reset the tree
			this.avl.clear();
			// reset the text fields
			inputTF1.setText("");
			inputTF2.setText("");

		} else if (e.getSource() == this.print) {

			PrinterJob pjob = PrinterJob.getPrinterJob();
			PageFormat preformat = pjob.defaultPage();
			preformat.setOrientation(PageFormat.LANDSCAPE);
			PageFormat postformat = pjob.pageDialog(preformat);
			// If user does not hit cancel then print.
			if (preformat != postformat) {
				// Set print component
				pjob.setPrintable(new Printer(M), postformat);
				if (pjob.printDialog()) {
					try {
						pjob.print();
					} catch (PrinterException e1) {
						e1.printStackTrace();
					}
				}

			}
		} else {
			int number1;
			Object localObject1;
			Object localObject2;
			if (e.getSource() == this.random) {
				// the sub tree that will generate randomly will consists of 8
				// nodes by default
				number1 = 8;
				// get text from the inputTF2 text field
				localObject1 = new StringTokenizer(this.inputTF2.getText());
				try {
					// Cast the string to integer
					number1 = Integer.parseInt(((StringTokenizer) localObject1)
							.nextToken());
					// check the inserted number is less than 1
					if (number1 < 1)
						// if yes change it to 1
						number1 = 1;
					// check the inserted number is greater than 99
					if (number1 > 99)
						// if yes change it to 99
						number1 = 99;
				} catch (Exception localException) {
				}
				// initialise an object from class Random
				Random random = new Random(System.currentTimeMillis());
				// get the boolean variable pause from the MainPanel
				boolean boolValue = this.M.pause;
				// make the animation without pauses
				this.M.pause = false;
				nums = new ArrayList();
				// insert n random numbers into nums arrayList
				for (int j = 0; j < number1; j++)
					// add random number
					nums.add((random.nextInt(100)));
				this.action(0, nums);
				this.M.pause = boolValue;
			} else if (e.getSource() == this.getPause()) {
				this.M.pause = this.pause.isSelected();
			} else {
				nums = new ArrayList<Integer>();
				for (number1 = 0; number1 < this.numButtons; number1++)
					// check if the event source is the next or find button
					if (e.getSource() == this.button[number1]) {
						nums.clear();
						// get the text from the inputTF1 text field
						localObject2 = new StringTokenizer(
								this.inputTF1.getText());
						// while there are numbers in the text field inputTF1
						// get and add to nums
						// this allows the user to insert group of numbers at
						// once
						while (((StringTokenizer) localObject2).hasMoreTokens())
							try {
								// cast the string to integer
								int i = Integer
										.parseInt(((StringTokenizer) localObject2)
												.nextToken());
								// check the validity of the number
								if (i < 0)
									i = 0;
								if (i > 99)
									i = 99;
								// add the number to nums arrayList
								nums.add(i);
							} catch (NumberFormatException e2) {
							}
						// set Next button to be active and set others to be
						// inactive
						enableNext();
						// if n = 0 means the event source is Next button and if
						// n =1 the event source is Find button
						int n = number1;
						ThreadTest localThread = new ThreadTest(this, n, nums);
						localThread.start();
						break;
					}
			}
		}
	}

	/**
	 * This method is used to make the Next button active after each step and
	 * make other buttons inactive
	 */
	public void enableNext() {
		for (int i = 0; i < this.numButtons; i++)
			this.button[i].setEnabled(false);
		this.clear.setEnabled(false);
		this.random.setEnabled(false);
		this.print.setEnabled(false);
		this.next.setEnabled(true);

	}

	/**
	 * This method is used to make the Next button inactive after after
	 * finishing inserting or finding a number in the AVL tree data structure
	 * and make other buttons active
	 */
	public void disableNext() {
		for (int i = 0; i < this.numButtons; i++)
			this.button[i].setEnabled(true);
		this.clear.setEnabled(true);
		this.random.setEnabled(true);
		this.print.setEnabled(true);
		this.next.setEnabled(false);

	}

	/**
	 * This method invokes when the user change the language and it acts as
	 * translator between the two languages
	 */
	public void refresh() {
		for (int j = 0; j < this.numButtons; j++)
			this.button[j].refresh();
		this.random.refresh();
		this.pause.refresh();
		this.next.refresh();
		this.speedL.refresh();
		this.clear.refresh();
		this.inputL.refresh();
		this.print.refresh();

	}

	/**
	 * This method is used to perform operation based on the given parameter.
	 * So, if n is 0 the insert operation will run and if n is 1 the find
	 * operation will run.
	 * 
	 * @param n
	 *            - int
	 * @param nums
	 *            - ArrayList
	 */
	public void action(int n, ArrayList<Integer> nums) {
		Object localObject;
		switch (n) {
		case 0:
			// check if the user pressed the Insert button without typing a
			// number
			if (nums.size() == 0) {
				// insert random number
				localObject = new Random(System.currentTimeMillis());
				avl.insert(((Random) localObject).nextInt(100));
			} else {
				// insert one number or a group of numbers
				for (Integer num : nums) {
					avl.insert(num);
				}
			}
			break;
		case 1:
			// find only one number, which is the fist number typed in the text
			// field
			// So, the user can not search for a group of numbers.
			if (nums.size() > 0) {
				avl.find(nums.get(0));
			}

			break;
		}
		// set the Next button to be inactive
		disableNext();
	}

	public static class ThreadTest extends Thread {
		int num;
		ArrayList<Integer> nums;
		ControlButtons bs;

		public ThreadTest(ControlButtons bs, int num, ArrayList<Integer> nums) {
			this.num = num;
			this.nums = nums;
			this.bs = bs;

		}

		public void run() {
			bs.action(num, nums);
		}

	}

	/**
	 * Returns the pause check box
	 * 
	 * @return - check box (pause)
	 */
	public CheckBox getPause() {
		return pause;
	}

	/**
	 * Returns the inputTF1 text field
	 * 
	 * @return - text field (inputTF1)
	 */
	public JTextField getInputTF1() {
		return inputTF1;
	}

	/**
	 * Returns the inputTF2 text field
	 * 
	 * @return - text field (inputTF2)
	 */

	public JTextField getInputTF2() {
		return inputTF2;
	}

	/**
	 * Returns the inputL label
	 * 
	 * @return - button (inputL)
	 */

	public Label getInputL() {
		return inputL;
	}

	/**
	 * Returns the insert button
	 * 
	 * @return - button (insert)
	 */
	public Button getInsert() {
		return insert;
	}

	/**
	 * Returns the find button
	 * 
	 * @return - button (find)
	 */
	public Button getFind() {
		return find;
	}

	/**
	 * Returns the next button
	 * 
	 * @return - button (next)
	 */
	public Button getNext() {
		return next;
	}

	/**
	 * Returns the clear button
	 * 
	 * @return - button (clear)
	 */
	public Button getClear() {
		return clear;
	}

	/**
	 * Returns the print button
	 * 
	 * @return - button (print)
	 */
	public Button getPrint() {
		return print;
	}

	/**
	 * Returns the random button
	 * 
	 * @return - button (random)
	 */
	public Button getRandom() {
		return random;
	}

	/**
	 * Returns the speedSlider slider
	 * 
	 * @return - slider (speedSlider)
	 */
	public JSlider getSpeedSlider() {
		return speedSlider;
	}

	/**
	 * Returns the speedL label
	 * 
	 * @return - label (speedL)
	 */
	public Label getSpeedL() {
		return speedL;
	}

}