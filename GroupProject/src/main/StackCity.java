/**
 * 
 */
package main;

import guiPractice8.GUIApplication;
import guiPractice8.component.Button;

/**
 * @author Daniel
 *
 */
public class StackCity extends GUIApplication {

	/**
	 *  static fields
	 */
	public static Button homeButton;
	public static StackCity game;
	
	public StackCity() {
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see guiPractice8.GUIApplication#initScreen()
	 */
	@Override
	protected void initScreen() {
		// for screens of phone and games
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		game = new StackCity();
		Thread go = new Thread(game);
		go.start();

	}

}
