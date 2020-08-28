package algorithm.sortvisualiser.gui;

import java.awt.CheckboxGroup;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

import algorithm.sortvisualiser.gui.algorithms.BubbleSort;
import algorithm.sortvisualiser.gui.algorithms.HeapSort;
import algorithm.sortvisualiser.gui.algorithms.ISortAlgorithm;
import algorithm.sortvisualiser.gui.algorithms.MergeSort;
import algorithm.sortvisualiser.gui.algorithms.SelectionSort;

/**
 * 
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a
 *      href="https://github.com/vuquangtin/algorithm">https://github.com/vuquangtin/algorithm</a>
 *
 */
public final class MainMenuScreen extends Screen {
	private static final Color BACKGROUND_COLOUR = Color.GRAY;
	private final ArrayList<AlgorithmCheckBox> checkBoxes;

	public MainMenuScreen(MainApp app) {
		super(app);
		checkBoxes = new ArrayList<>();
		setUpGUI();
	}

	private void addCheckBox(ISortAlgorithm algorithm, JPanel panel) {
		JCheckBox box = new JCheckBox("", true);
		box.setAlignmentX(Component.LEFT_ALIGNMENT);
		box.setBackground(BACKGROUND_COLOUR);
		box.setForeground(Color.WHITE);
		checkBoxes.add(new AlgorithmCheckBox(algorithm, box));
		panel.add(box);
	}

	private void initContainer(JPanel p) {
		p.setLayout(new BoxLayout(p, BoxLayout.PAGE_AXIS));
		p.setBackground(BACKGROUND_COLOUR);
	}

	public void setUpGUI() {
		JPanel sortAlgorithmContainer = new JPanel();
		JPanel optionsContainer = new JPanel();
		JPanel outerContainer = new JPanel();
		initContainer(this);
		initContainer(optionsContainer);
		initContainer(sortAlgorithmContainer);

		outerContainer.setBackground(BACKGROUND_COLOUR);
		outerContainer.setLayout(new BoxLayout(outerContainer,
				BoxLayout.LINE_AXIS));

		/**
		 * Tworzenie checkboxów
		 */
		sortAlgorithmContainer.setAlignmentX(Component.CENTER_ALIGNMENT);
		addCheckBox(new BubbleSort(), sortAlgorithmContainer);
		addCheckBox(new SelectionSort(), sortAlgorithmContainer);
		addCheckBox(new MergeSort(), sortAlgorithmContainer);
		addCheckBox(new HeapSort(), sortAlgorithmContainer);

		JCheckBox soundCheckBox = new JCheckBox();

		/**
		 * Create a start button and logic to it
		 */
		JButton startButton = new JButton("Start");
		startButton.addActionListener((ActionEvent e) -> {
			ArrayList<ISortAlgorithm> algorithms = new ArrayList<>();
			for (AlgorithmCheckBox cb : checkBoxes) {
				if (cb.isSelected()) {
					algorithms.add(cb.getAlgorithm());
				}
			}
			app.pushScreen(new SortingVisualiserScreen(algorithms,
					soundCheckBox.isSelected(), app));
		});
		startButton.setAlignmentX(Component.CENTER_ALIGNMENT);

		outerContainer.add(optionsContainer);
		outerContainer.add(Box.createRigidArea(new Dimension(5, 0)));
		outerContainer.add(sortAlgorithmContainer);

		int gap = 15;
		add(Box.createRigidArea(new Dimension(0, gap)));
		add(outerContainer);
		add(Box.createRigidArea(new Dimension(0, gap)));
		add(startButton);
	}

	@Override
	public void onOpen() {
		checkBoxes.forEach((box) -> {
			box.unselect();

		});

	}

	private class AlgorithmCheckBox {
		private final ISortAlgorithm algorithm;
		private final JCheckBox box;

		public AlgorithmCheckBox(ISortAlgorithm algorithm, JCheckBox box) {
			this.algorithm = algorithm;
			this.box = box;
			this.box.setText(algorithm.getName());
		}

		public void unselect() {
			box.setSelected(false);
		}

		public boolean isSelected() {
			return box.isSelected();
		}

		public ISortAlgorithm getAlgorithm() {
			return algorithm;
		}
	}

}