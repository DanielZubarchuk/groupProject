package src;

import java.awt.Color;
import java.util.ArrayList;

import guiPractice.ClickableScreen;
import guiPractice.GUIApplication;
import guiPractice.Screen;
import guiPractice.TextLabel;
import guiPractice.components.Action;
import guiPractice.components.Button;
import guiPractice.components.ClickableGraphic;
import guiPractice.components.Graphic;
import guiPractice.components.Visible;

/**
 * 
 */

/**
 * @author Hao
 *
 */
public class HaosDemo extends GUIApplication{

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
		private TextLabel test;
		private Graphic backgroundTest;
		
		public DemoScreen(int width, int height) {
			super(width, height);
			// TODO Auto-generated constructor stub
		
		}
		
		public void initAllObjects(ArrayList<Visible> view){
			testAppLink = new ClickableGraphic((int) (getWidth()/2 - 43.75), getHeight()/2 - 50, .5, "resources/sampleImages/testAppIcon.jpg");
			testAppLink.setAction(new Action() {
				public void act(){
					HaosDemo.demos.setScreen(HaosDemo.test);
				}
			});
			homeButton = new Button(getWidth()/2-30, (int) (5 * getHeight()/6), 60, 30, "Home", new Color(0,0,0), new Action(){
				public void act(){
					HaosDemo.demos.setScreen(HaosDemo.demo);
				}
			});
//			backgroundTest = new Graphic(100, 600, 1000, 500, "resources/sampleImages/background.png");
			test = new TextLabel(getWidth()/2 - 200, getHeight()/4, 760, 40, "Click the black icon to go to the Sample Screen");
			view.add(testAppLink);
			view.add(homeButton);
			view.add(test);
//			view.add(backgroundTest);
		}
		
	}






}
