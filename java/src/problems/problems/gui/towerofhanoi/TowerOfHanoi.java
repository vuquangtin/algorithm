package problems.gui.towerofhanoi;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Stack;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSlider;
import javax.swing.JTextArea;
import javax.swing.Timer;

/**
 * 
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a
 *      href="https://github.com/vuquangtin/algorithm">https://github.com/vuquangtin/algorithm</a>
 *
 */

public class TowerOfHanoi extends JFrame implements Runnable, ActionListener {

	public static void main(String[] args) {
		TowerOfHanoi toh = new TowerOfHanoi();
		toh.setVisible(true);
	}

	// this replects to the ActionListener
	Timer tm;
	int n, fps = 0;

	int fwidth = 1000, fheight = 1000;
	JButton start = new JButton("Start");
	JButton exit = new JButton("EXit");
	JButton stop = new JButton("Slow");
	JLabel peg1 = new JLabel("X");
	JLabel peg2 = new JLabel("Y");
	JLabel peg3 = new JLabel("Z");
	JSlider slider = new JSlider();
	Rectangle[] peg = new Rectangle[3];
	Rectangle[] disk = new Rectangle[10];
	JLabel movecount = new JLabel("Moves count");
	JLabel moveddisk = new JLabel("Current mov --- Disk");
	JTextArea title = new JTextArea();

	Stack<Integer> stack1 = new Stack<>();
	Stack<Integer> stack2 = new Stack<>();
	Stack<Integer> stack3 = new Stack<>();
	// will determine no of disk in each peg
	int count = 0, sz, num1, velx = 100;

	Thread t = new Thread(this);

	@Override
	public void run() {

		towerofhanoi(n, 1, 2, 3);
	}

	public TowerOfHanoi() {
		/*
		 * tm=new Timer(100,new ActionListener(){
		 * 
		 * @Override public void actionPerformed(ActionEvent ae){ inst+=inst+2;
		 * repaint(); if(inst==200){ tm.stop(); inst=0; } else{ tm.start(); } }
		 * });
		 */
		String number = JOptionPane.showInputDialog(null,
				"enter the number of disks");
		n = Integer.valueOf(number);

		/*
		 * public void stateChanged(ChangeEvent ae){ JSlider slider =
		 * (JSlider)e.getSource(); if (!slider.getValueIsAdjusting()) { fps =
		 * (int)slider.getValue(); } }
		 */
		setSize(fwidth, fheight);
		setTitle("Restricted lab7s Of towerofhanoi ");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		slider.setMajorTickSpacing(10);
		// slider.setMinorTickSpacing(1);
		slider.setPaintLabels(true);
		slider.setPaintTicks(true);
		slider.setPaintTrack(true);
		slider.setAutoscrolls(true);
		slider.setBackground(Color.WHITE);
		slider.setBounds(800, 500, 250, 100);

		add(slider);
		start.setBounds(300, 550, 100, 30);
		exit.setBounds(600, 550, 100, 30);
		stop.setBounds(900, 520, 100, 25);
		peg1.setBounds(250, 480, 100, 30);
		peg2.setBounds(500, 480, 100, 30);
		peg3.setBounds(750, 480, 100, 30);
		movecount.setBounds(600, 20, 400, 50);
		moveddisk.setBounds(200, 20, 400, 50);
		peg[0] = new Rectangle(250, 200, 15, 300);
		peg[1] = new Rectangle(500, 200, 15, 300);
		peg[2] = new Rectangle(750, 200, 15, 300);
		// title.setBounds(850,10,100,500);
		add(start);
		add(exit);
		add(peg1);
		add(peg2);
		add(peg3);
		add(movecount);
		add(moveddisk);
		// add(title);

		// disk[0] large size

		for (int i = 0; i < n; i++) {
			// max y of any disk is 475
			// height of each disk is 25
			// 110+i*10+n*5
			disk[i] = new Rectangle(250 - ((250 - n) - i * 20) / 2,
					475 - i * 25, (250 - n) - i * 20, 25);
			// 0 represents the peg 0 and i reprents the disk
			// pushing disk numbers in to first peg
			stack1.push(i);
		}
		start.addActionListener(this);
		exit.addActionListener(this);
		// slider.addChangeListener(this);
		setLayout(null);
	}

	@Override
	public void actionPerformed(ActionEvent ae) {

		if (ae.getSource() == start) {
			t.start();

		}

		else if (ae.getSource() == exit) {
			System.exit(0);
		}
	}

	public void call(int re) {

		try {
			t.sleep(1000 - re * 10);
		} catch (Exception e) {

		}
	}

	public void towerofhanoi(int number, int source, int intermediate, int dest) {
		fps = slider.getValue();

		if (number == -1) {

			if ((source == 1 && intermediate == 2)) {
				num1 = stack1.pop();
				stack2.push(num1);
				sz = stack2.size();
			}
			if ((source == 3 && intermediate == 2)) {
				num1 = stack3.pop();
				stack2.push(num1);
				sz = stack2.size();

			}
			if (source == 1 && intermediate == 3) {

				num1 = stack1.pop();
				stack3.push(num1);
				sz = stack3.size();
			}
			if (source == 2 && intermediate == 3) {
				num1 = stack2.pop();
				stack3.push(num1);

				sz = stack3.size();
			}
			if (source == 3 && intermediate == 1) {

				num1 = stack3.pop();
				stack1.push(num1);
				sz = stack1.size();

			}
			if (source == 2 && intermediate == 1) {
				num1 = stack2.pop();
				stack1.push(num1);
				sz = stack1.size();
			}

			// disk[num1].setLocation(disk[num1].x,disk[num1].y-inst);

			// repaint();
			// inst+=1;
			/*
			 * int temp=0; int finalv=2*(disk[num1].y)/3; while(temp<=finalv){
			 */
			disk[num1].setLocation(disk[num1].x, disk[num1].y - 2
					* (disk[num1].y) / 3);
			repaint();
			call(fps);
			movecount.setText("Moves count=" + (++count));
			moveddisk.setText("Current mov --- Disk " + (num1 + 1)
					+ "   moving from" + (char) (source + 87) + " --> "
					+ (char) (intermediate + 87));
			disk[num1].setLocation(disk[num1].x
					+ (peg[intermediate - 1].x - peg[source - 1].x),
					disk[num1].y);
			repaint();
			call(fps);
			disk[num1].setLocation(disk[num1].x, 475 - (sz - 1) * 25);
			repaint();
			call(fps);

		} else if (number > 0) {
			towerofhanoi(number - 1, source, intermediate, dest);
			System.out.println("source " + source + "to " + intermediate);
			towerofhanoi(-1, source, intermediate, dest);
			towerofhanoi(number - 1, dest, intermediate, source);
			System.out.println("source " + intermediate + "to " + dest);
			towerofhanoi(-1, intermediate, dest, source);
			towerofhanoi(number - 1, source, intermediate, dest);
		}
	}

	// this is the orerride method present in the jframe
	public void paint(Graphics g) {
		super.paint(g);
		// Color randomColor = new Color((float)Math.random(),
		// (float)Math.random(), (float)Math.random());

		g.setColor(Color.red);

		for (int i = 0; i < 3; i++) {
			g.fillRect(peg[i].x, peg[i].y, peg[i].width, peg[i].height);
		}

		g.drawLine(100, 500, 850, 500);
		g.setColor(Color.black);
		g.fillRect(100, 500, 800, 10);

		// drawing disks
		for (int i = 0; i < n; i++) { // Color randomColor1 = new
										// Color((float)Math.random(),
										// (float)Math.random(),
										// (float)Math.random());
			g.setColor(Color.green);
			g.fillRoundRect(disk[i].x, disk[i].y, disk[i].width,
					disk[i].height, 20, 20);
			g.setColor(Color.BLACK);
			g.drawRoundRect(disk[i].x, disk[i].y, disk[i].width,
					disk[i].height, 20, 20);
			g.setColor(Color.black);
			g.drawString("" + (i + 1), disk[i].x + (disk[i].height / 2),
					disk[i].y + 13);

		}
	}

}