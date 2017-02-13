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
 * @author hotfi
 *
 */
public class VictorDemo extends GUIApplication {

	public static Fluctuation fluctuation;
	/**
	 * 
	 */
	public VictorDemo() {
		fluctuation = new Fluctuation();
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
		VictorDemo demo = new VictorDemo();
		Thread app = new Thread(demo);
		app.start();

	}
	
	//nested inner class;
	private class DemoScreen extends ClickableScreen{

		private TextLabel eventDisplay;
		private Button updateStock;
		
		public DemoScreen(int width, int height) {
			super(width, height);
			// TODO Auto-generated constructor stub
		}

		@Override
		public void initAllObjects(List<Visible> view) {
			eventDisplay = new TextLabel(20, 40, 800, 25, "");
			updateStock = new Button(40, 100, 190, 40, "Update Stock", Color.blue, new Action() {
				
				@Override
				public void act() {
					eventDisplay.setText("Current state of " + VictorDemo.fluctuation.stockNames[VictorDemo.fluctuation.eventStock] 
							+ ": "
							+ VictorDemo.fluctuation.outputEvent() 
							+ "(" + VictorDemo.fluctuation.stockGrowths[VictorDemo.fluctuation.eventStock]
							+ " )");
					VictorDemo.fluctuation.fillEvents();
					VictorDemo.fluctuation.updateStock();
				}
			});
			view.add(eventDisplay);
			view.add(updateStock);
		}
		
	}

}
