package algorithm.sortvisualiser.gui;

import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

/**
 * https://github.com/MrHDOLEK/Wizualizacja_sortowan
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a
 *      href="https://github.com/vuquangtin/algorithm">https://github.com/vuquangtin/algorithm</a>
 *
 */
public class MainApp {
	private final JFrame window;
	/**
	 * Declaration of the window size and its logic
	 */
	public static final int WIN_WIDTH = 1200;
	public static final int WIN_HEIGHT = 600;

	private final ArrayList<Screen> screens;

	public MainApp() {
		screens = new ArrayList<>();
		window = new JFrame("visualisation");
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setVisible(true);
	}

	public Screen getCurrentScreen() {
		return screens.get(screens.size() - 1);
	}

	public void pushScreen(Screen screen) {
		if (!screens.isEmpty()) {
			window.remove(getCurrentScreen());
		}
		screens.add(screen);
		window.setContentPane(screen);
		window.validate();
		screen.onOpen();
	}

	public void popScreen() {
		if (!screens.isEmpty()) {
			Screen prev = getCurrentScreen();
			screens.remove(prev);
			window.remove(prev);
			if (!screens.isEmpty()) {
				Screen current = getCurrentScreen();
				window.setContentPane(current);
				window.validate();
				current.onOpen();
			} else {
				window.dispose();
			}
		}
	}

	public void start() {
		pushScreen(new MainMenuScreen(this));
		window.pack();
	}

	public static void main(String... args) {
		System.setProperty("sun.java2d.opengl", "true");
		SwingUtilities.invokeLater(() -> {
			new MainApp().start();
		});
	}
}