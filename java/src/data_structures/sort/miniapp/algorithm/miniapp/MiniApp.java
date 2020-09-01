package algorithm.miniapp;

import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import algorithm.miniapp.view.Screen;
import algorithm.miniapp.view.screens.MainMenuScreen;

/**
 * 
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a
 *      href="https://github.com/vuquangtin/algorithm">https://github.com/vuquangtin/algorithm</a>
 *
 */
public class MiniApp {

	private final JFrame window;

	public static final int WIN_WIDTH = 1360;
	public static final int WIN_HEIGHT = 768;
	private final ArrayList<Screen> screens;

	public MiniApp() {
		screens = new ArrayList<>();
		window = new JFrame("Algorithm analysis and graphical demonstration");
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setResizable(false);
		window.pack();
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

	public static void main(String[] args) {
		System.setProperty("sun.java2d.opengl", "true");
		SwingUtilities.invokeLater(() -> {
			new MiniApp().start();
		});
	}

}
