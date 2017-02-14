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
import guiPractice8.component.TextArea;
import guiPractice8.component.Graphic;
import guiPractice8.component.TextLabel;
import guiPractice8.component.Visible;

/**
 * @author daniel
 *
 */
public class DanielDemo extends GUIApplication {

	public static Transaction transaction;
	/**
	 * 
	 */
	public DanielDemo() {
		transaction = new Transaction();
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
		DanielDemo demo = new DanielDemo();
		Thread app = new Thread(demo);
		app.start();

	}
	
	//nested inner class;
	private class DemoScreen extends ClickableScreen{

		private TextLabel actionDisplay;
		private Button buyAStock;
		private Graphic rectangle;
		
		public DemoScreen(int width, int height) {
			super(width, height);
		}

		@Override
		public void initAllObjects(List<Visible> view) {
		
			actionDisplay = new TextLabel(20, 40, 800, 25, "");
			buyAStock = new Button(40, 100, 190, 40, "Buy a Stock", Color.blue, new Action() {
				
				@Override
				public void act() {
//					DanielDemo.transaction.outputEvent();
					//actionDisplay.setText(title);
			}
			});
			view.add(actionDisplay);
			view.add(buyAStock);
			
			rectangle = new Graphic(40, 100, 190, 40,"resources/images/greenrect.png");
			view.add(rectangle);
		}
		
	}

}
