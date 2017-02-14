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
import guiPractice8.component.Graphic;
import guiPractice8.component.Visible;
import projectComponents.ThemedTextLabel;

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

		private ThemedTextLabel eventDisplay;
		private Button updateStock;
		private Button eventHistory;
		private Graphic background;
		
		public DemoScreen(int width, int height) {
			super(width, height);
			// TODO Auto-generated constructor stub
		}

		@Override
		public void initAllObjects(List<Visible> view) {
			eventDisplay = new ThemedTextLabel(20, 40, 800, 25, "");
			background = new Graphic(0,0,getWidth(),getHeight(),"resources/images/moneybackground.jpg");
			updateStock = new Button(40, 100, 190, 40, "Update Stock", Color.blue, new Action() {
				
				@Override
				public void act() {
					eventDisplay.setText("Current state of " + Fluctuation.stockNames[VictorDemo.fluctuation.eventStock] 
							+ ": "
							+ VictorDemo.fluctuation.outputEvent() 
							+ "(" + String.format( "%.2f", Fluctuation.stockGrowths[VictorDemo.fluctuation.eventStock] )
							+ " )" + String.format( "%.2f", Fluctuation.stockPrices[VictorDemo.fluctuation.eventStock] ));
					VictorDemo.fluctuation.updateStock();
				}
			});
			eventHistory = new Button(290,100 , 250, 40, "Event History", Color.green, new Action() {
				
				@Override
				public void act() {
					// show the event history as a toggle 
					
				}
			});
			view.add(background);
			view.add(eventDisplay);
			view.add(updateStock);
			view.add(eventHistory);
		}
		
	}

}
