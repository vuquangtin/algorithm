package algorithm.design.TSP;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.UIManager;

public class GUI {

	private JFrame frame;
	private JTextField txt_lanlap;
	private JTextField txt_quanthe;
	JTextArea txt_point;
	JPanel panel_2;
	ArrayList<Point> points = new ArrayList<Point>();
	Graphics g;
	String str = "";
	int tp = 0;
	private JTextField txt_best_tp;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager
							.setLookAndFeel("com.nilo.plaf.nimrod.NimRODLookAndFeel");
					GUI window = new GUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setIconImage(Toolkit
				.getDefaultToolkit()
				.getImage(
						GUI.class
								.getResource("/com/nilo/plaf/nimrod/icons/TreePelotilla.png")));
		frame.setResizable(false);
		frame.setBounds(100, 100, 869, 628);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);

		JMenu mnNewMenu = new JMenu("Home");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Exit");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		mnNewMenu.add(mntmNewMenuItem);

		JMenu mnNewMenu_1 = new JMenu("Help");
		menuBar.add(mnNewMenu_1);
		
		JMenuItem mntmAbout = new JMenuItem("About");
		mntmAbout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				About about = new About();
				about.setVisible(true);
			}
		});
		mnNewMenu_1.add(mntmAbout);
		frame.getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBorder(UIManager.getBorder("ProgressBar.border"));
		panel.setBounds(637, 0, 226, 579);
		frame.getContentPane().add(panel);
		panel.setLayout(null);

		JLabel lblLnLp = new JLabel("L\u1EA7n l\u1EB7p");
		lblLnLp.setBounds(25, 42, 58, 30);
		panel.add(lblLnLp);

		txt_lanlap = new JTextField();
		txt_lanlap.setText("100");
		txt_lanlap.setBounds(93, 42, 86, 30);
		panel.add(txt_lanlap);
		txt_lanlap.setColumns(10);

		JLabel lblQunTh = new JLabel("Qu\u1EA7n th\u1EC3");
		lblQunTh.setBounds(25, 89, 58, 27);
		panel.add(lblQunTh);

		txt_quanthe = new JTextField();
		txt_quanthe.setText("100");
		txt_quanthe.setColumns(10);
		txt_quanthe.setBounds(93, 86, 86, 30);
		panel.add(txt_quanthe);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(23, 145, 193, 387);
		panel.add(scrollPane);

		txt_point = new JTextArea();
		scrollPane.setViewportView(txt_point);

		final JPanel panel_1 = new JPanel();
		panel_1.setBorder(UIManager.getBorder("CheckBox.border"));
		panel_1.setBounds(0, 461, 637, 118);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);

		JButton btnNewButton = new JButton("Ti\u1EBFn h\u00F3a");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Gọi Lớp TSP
				int soquanthe = Integer.valueOf(txt_quanthe.getText().trim());
				int solanlap = Integer.valueOf(txt_lanlap.getText().trim());
				TSP tsp = new TSP(points,soquanthe,solanlap);
				ArrayList<Integer> best_city = tsp.getBest_move_city();
				endThuatToan(best_city);
				txt_best_tp.setText(best_city.toString());
			}

			// Lấy thành phố tốt nhất rồi nối lại thành đường thẳng
			private void endThuatToan(ArrayList<Integer> best_city) {
				for (int i = 0; i < best_city.size() - 1; i++) {
					int x1 = (int) points.get(best_city.get(i)).getX();
					int y1 = (int) points.get(best_city.get(i)).getY();
					int x2 = (int) points.get(best_city.get(i + 1)).getX();
					int y2 = (int) points.get(best_city.get(i + 1)).getY();
					g.drawLine(x1, y1, x2, y2);
				}

				int _x1 = (int) points.get(best_city.get(0)).getX();
				int _y1 = (int) points.get(best_city.get(0)).getY();
				int _x2 = (int) points.get(best_city.get(best_city.size() - 1))
						.getX();
				int _y2 = (int) points.get(best_city.get(best_city.size() - 1))
						.getY();
				g.drawLine(_x1, _y1, _x2, _y2);
			}
		});
		btnNewButton.setBounds(10, 11, 118, 70);
		panel_1.add(btnNewButton);

		JButton btnLmLi = new JButton("L\u00E0m l\u1EA1i");
		btnLmLi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel_2.repaint();
				points.clear();
				txt_point.setText(null);
				str="";
				tp=0;
			}
		});
		btnLmLi.setBounds(165, 11, 118, 70);
		panel_1.add(btnLmLi);
		
		txt_best_tp = new JTextField();
		txt_best_tp.setBounds(293, 45, 324, 36);
		panel_1.add(txt_best_tp);
		txt_best_tp.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Đường đi tốt nhất qua các thành phố");
		lblNewLabel.setBounds(357, 20, 210, 14);
		panel_1.add(lblNewLabel);

		panel_2 = new JPanel();

		panel_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				g = panel_2.getGraphics();
				Point click = arg0.getPoint();
				str += "Thành phố " + tp + ": (" + (int) click.getX() + ", "
						+ (int) click.getY() + ")\n";
				points.add(click);
				tp = tp + 1;
				txt_point.setText(str);
				g.fillOval((int) click.getX(), (int) click.getY(), 3, 3);
				g.finalize();
			}
		});
		panel_2.setBackground(new Color(0, 206, 209));
		panel_2.setForeground(new Color(175, 238, 238));
		panel_2.setBorder(UIManager.getBorder("TitledBorder.border"));
		panel_2.setBounds(0, 0, 637, 462);
		frame.getContentPane().add(panel_2);
	}
}
