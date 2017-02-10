import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import guiPractice8.component.ClickableScreen;
import guiPractice8.component.TextLabel;
import guiPractice8.GUIApplication;
import guiPractice8.Screen;
import guiPractice8.component.Action;
import guiPractice8.component.Button;
import guiPractice8.component.Visible;

/**
 * 
 */

/**
 * @author Richard
 *
 */
public class RichardDemo extends GUIApplication {

	public static RichardDemo demos;
	public static Screen demo;
	private static int xthing = 1;
	/**
	 * 
	 */
	public RichardDemo() {
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see guiPractice.GUIApplication#initScreen()
	 */
	@Override
	protected void initScreen() {
		demo = new DemoScreen(getWidth(), getHeight());
		setScreen(demo);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		demos = new RichardDemo();
		Thread app = new Thread(demos);
		app.start();
	}

	//nested inner class
	private class DemoScreen extends ClickableScreen {

		private Button buyButton;
		private Button xNumButton;
		private Button mangerButton;
		private Button xNumButton2;
		
//		private TextLabel buyText;
		
		public DemoScreen(int width, int height) {
			super(width, height);
			// TODO Auto-generated constructor stub
		
		}
		
		@Override
		public void initAllObjects(List<Visible> viewObjects) {
			// TODO Auto-generated method stub
			int numberOfBB = 8;
			int numberOfXNB = 1;
			int numberOfMB = 1;
			
			
			
			xNumButton = new Button(100, 50, 150, 100, " X " + xthing, new Color(255,255,0), new Action(){

				public void act() {
					// TODO Auto-generated method stub
						xthing++;
						System.out.println(xthing);
						viewObjects.add(xNumButton2);
//						moveToFront(xNumButton2);
						
					}
				});
			xNumButton2 = new Button(200, 50, 150, 100, " X " + xthing, new Color(255,255,0), new Action(){

				public void act() {
					// TODO Auto-generated method stub
						System.out.println("klegjielg");
						xthing*=2;
						
					}
				});
			viewObjects.add(xNumButton);
		}
		
	}






}