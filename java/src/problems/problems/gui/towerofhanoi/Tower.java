package problems.gui.towerofhanoi;

import java.awt.*;
import java.util.Stack;

import javax.swing.ImageIcon;

/**
 * 
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a
 *      href="https://github.com/vuquangtin/algorithm">https://github.com/vuquangtin/algorithm</a>
 *
 */

public class Tower {
	// / tower image
	ImageIcon tower = new ImageIcon(Hanoi.resourcePath+"tower.png");
	// / disc stack
	public Stack<ImageIcon> pole;
	// / x position of the tower
	private int x;
	// / y position of the tower
	private int y = 300;
	// / disk width
	private int disc = 20;
	// / tower base length
	private int base = 150;
	// / tower name
	private String name;
	// / tower top disc image
	public ImageIcon top;

	// /class constructor
	public Tower(int x, String name) {
		this.x = x;
		this.name = name;
		this.pole = new Stack<ImageIcon>();
	}

	// / Method that draws the towers with the disks they contain
	public void DrawTower(Graphics g) {
		g.drawImage(tower.getImage(), x - base / 2, y - disc * 11,
				tower.getIconWidth(), tower.getIconHeight(), null);
		for (int i = 0; i < pole.size(); i++) {
			g.drawImage(pole.get(i).getImage(), x - pole.get(i).getIconWidth()
					/ 2, y - pole.get(i).getIconHeight() - (i * disc) - 20,
					pole.get(i).getIconWidth(),
					pole.get(i).getIconHeight() - 1, null);
		}
		g.setColor(Color.black);
		g.drawString(name, x - base / 2 + 72, y - 5);
	}

	// / Method that draws the top of the tower
	public void DrawTop(Graphics g) {
		if (top != null) {
			g.drawImage(top.getImage(), x - top.getIconWidth() / 2, 30,
					top.getIconWidth(), top.getIconHeight() - 1, null);
		}
	}
}