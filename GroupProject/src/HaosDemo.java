import java.awt.Color;
import java.util.ArrayList;

import guiPractice.ClickableScreen;
import guiPractice.GUIApplication;
import guiPractice.Screen;
import guiPractice.components.Action;
import guiPractice.components.Button;
import guiPractice.components.ClickableGraphic;
import guiPractice.components.Visible;

/**
 * 
 */

/**
 * @author Hao
 *
 */
public class HaosDemo extends GUIApplication {

	public static HaosDemo demos;
	public static Screen demo;
	public static SampleScreen test;
	/**
	 * 
	 */
	public HaosDemo() {
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see guiPractice.GUIApplication#initScreen()
	 */
	@Override
	protected void initScreen() {
		demo = new DemoScreen(getWidth(), getHeight());
		test = new SampleScreen(getWidth(), getHeight());
		setScreen(demo);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		demos = new HaosDemo();
		Thread app = new Thread(demos);
		app.start();
	}

	//nested inner class
	private class DemoScreen extends ClickableScreen {

		private Button homeButton;
		private ClickableGraphic testAppLink;
		
		public DemoScreen(int width, int height) {
			super(width, height);
			// TODO Auto-generated constructor stub
		
		}
		
		public void initAllObjects(ArrayList<Visible> view){
			testAppLink = new ClickableGraphic((int) (getWidth()/3 - 87.5), getHeight()/2 - 50, .5, "resources/sampleImages/testAppIcon.jpg");
			homeButton = new Button(getWidth()/2-30, (int) (5 * getHeight()/6), 60, 30, "Home", new Color(0,0,0), new Action(){
				public void act(){
					HaosDemo.demos.setScreen(HaosDemo.demo);
				}
			});
			
			view.add(homeButton);
		}
		
	}






}
