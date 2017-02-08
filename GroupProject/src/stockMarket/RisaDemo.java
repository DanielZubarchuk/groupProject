/**
 * 
 */
package stockMarket;

import java.awt.Color;
import java.util.List;

import guiPractice8.GUIApplication;
import guiPractice8.component.Action;
import guiPractice8.component.Button;
import guiPractice8.component.ClickableScreen;
import guiPractice8.component.TextLabel;
import guiPractice8.component.Visible;

/**
 * @author Student 6
 *
 */
public class RisaDemo extends GUIApplication {

	public static UserScreen user;

	public RisaDemo() {
		user = new UserScreen(0, 0);
	}

	/* (non-Javadoc)
	 * @see guiPractice8.GUIApplication#initScreen()
	 */
	@Override
	protected void initScreen() {
		DemoScreen demo = new DemoScreen(getWidth(), getHeight());
		setScreen(demo);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		RisaDemo demo = new RisaDemo();
		Thread app = new Thread(demo);
		app.start();
	}
	
	//nested inner class
	private class DemoScreen extends ClickableScreen{
		
		private TextLabel display;
		private Button button;
		
		public DemoScreen(int width, int height) {
			super(width, height);
			// TODO Auto-generated constructor stub
		}

		@Override
		public void initAllObjects(List<Visible> viewObjects) {
			display = new TextLabel(20, 40, 100, 25, "");
			button = new Button(40, 100, 90, 40, "Button", Color.blue, new Action(){
				
				public void act(){
					//code here for check
				}
			});
			
			viewObjects.add(display);
			viewObjects.add(button);
			
		}
		
	}

}
