
import javax.swing.JFrame;

import ui.Game;

/**
 * Main program
 * 
 * @author Timo Wortmann
 * @since 27.11.2018
 * @version 1.0
 */
public class Main {

	/**
	 * Main program opens a GUI and starts a new game
	 * 
	 * @param args
	 *            Commandline parameter
	 */
	public static void main(String[] args) {
		Game game = new Game();
		JFrame frame = new JFrame();
		frame.add(game);
		frame.pack();
		frame.setBounds(0, 0, 1280, 790);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.setAlwaysOnTop(true);
		game.start();

	}

}
