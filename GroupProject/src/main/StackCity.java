/**
 * 
 */
package main;

import guiPractice8.GUIApplication;
import guiPractice8.component.Buttonssss;

/**
 * @author Daniel
 *
 */
public class StackCity extends GUIApplication {

	/**
	 *  static fields
	 */
	public static Buttonssss homeButton;
	public static StackCity game;
	
	public StackCity() {
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see guiPractice8.GUIApplication#initScreen()
	 */
	@Override
	protected void initScreen() {
		// TODO Auto-generated method stub

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
