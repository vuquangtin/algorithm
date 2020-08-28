package algorithm.sortvisualiser.gui;

import java.awt.Dimension;

import javax.swing.JPanel;

/**
 * 
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a
 *      href="https://github.com/vuquangtin/algorithm">https://github.com/vuquangtin/algorithm</a>
 *
 */
public abstract class Screen extends JPanel {
	protected MainApp app;

	public Screen(MainApp app) {
		this.app = app;
	}

	@Override
	public Dimension getPreferredSize() {
		return new Dimension(MainApp.WIN_WIDTH, MainApp.WIN_HEIGHT);
	}

	public abstract void onOpen();
}