package algorithm.design.backtracking.gui.nqueen;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

/**
 * 
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a
 *      href="https://github.com/vuquangtin/algorithm">https://github.com/vuquangtin/algorithm</a>
 *
 */
public class MainFrame extends JFrame {

	static int N;
	static int[][] value;

	MainFrame() {

		setTitle("N Qeens");
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		setValue();
		Queens.solve();

		Bord bord = new Bord();

		setContentPane(bord);

		JMenuBar bar = new JMenuBar();

		setJMenuBar(bar);

		JMenu file = new JMenu("File");
		JMenu edit = new JMenu("Edit");
		JMenu help = new JMenu("Help");
		JMenuItem exit = new JMenuItem("Exit");
		JMenuItem enter = new JMenuItem("Enter new N");
		JMenuItem about = new JMenuItem("About");

		file.add(exit);
		edit.add(enter);
		help.add(about);
		bar.add(file);
		bar.add(edit);
		bar.add(help);

		exit.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {

				System.exit(0);
			}
		});
		enter.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {

				N = 0;
				setValue();
				Queens.solve();
				bord.repaint();
			}
		});
		about.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {

				JOptionPane
						.showMessageDialog(null,
								"Programmer: Sayyid abbas ahgaei\nSN: 9319753\n10/jul/2017");
			}
		});
	}

	void setValue() {

		while (N < 4) {
			String input = JOptionPane.showInputDialog(null,
					"Enter number of Queens:");
			N = Integer.parseInt(input);
			if (N < 4)
				JOptionPane.showMessageDialog(null,
						"There is no solution exist for N<4");
		}
		value = new int[N][N];
		setBounds(300, 100, N * 100 + 6, N * 100 + 57);

		for (int i = 0; i < N; i++)
			for (int j = 0, k = i; j < N; j++, k++)
				if (k % 2 == 0)
					value[i][j] = 1;
				else
					value[i][j] = 0;
	}
}