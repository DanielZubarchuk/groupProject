/**
 * 
 */
package stockMarket;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
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
		private Graphic logo;
		private ThemedTextLabel historyDisplay;
		
		public DemoScreen(int width, int height) {
			super(width, height);
			// TODO Auto-generated constructor stub
		}

		@Override
		public void initAllObjects(List<Visible> view) {
			eventDisplay = new ThemedTextLabel(40, 170, 800, 25, "");
			background = new Graphic(0,0,getWidth(),getHeight(),"resources/images/newmoneybackground.png");
			logo = new Graphic(40, 50, 90, 90, "resources/images/logo.png"); 
			historyDisplay = new ThemedTextLabel(40, 250, getWidth() - 50, 100,"");	
			updateStock = new Button(40, 220, 190, 40, "Update Stock", Color.blue, new Action() {
				@Override
				public void act() {
					Fluctuation.getEventHistory().add("Current state of " + Fluctuation.getStockNames()[VictorDemo.fluctuation.getEventStock()] 
							+ ": "
							+ VictorDemo.fluctuation.outputEvent() 
							+ "(" + String.format( "%.2f", Fluctuation.getStockGrowths()[VictorDemo.fluctuation.getEventStock()] )
							+ " )" + String.format( "%.2f", Fluctuation.getStockPrices()[VictorDemo.fluctuation.getEventStock()] ));
					
					eventDisplay.setText("Current state of " + Fluctuation.getStockNames()[VictorDemo.fluctuation.getEventStock()] 
							+ ": "
							+ VictorDemo.fluctuation.outputEvent() 
							+ "(" + String.format( "%.2f", Fluctuation.getStockGrowths()[VictorDemo.fluctuation.getEventStock()] )
							+ " )" + String.format( "%.2f", Fluctuation.getStockPrices()[VictorDemo.fluctuation.getEventStock()] ));
					VictorDemo.fluctuation.updateStock();
				}
			});
			eventHistory = new Button(290,220 , 250, 40, "Event History", Color.green, new Action() {
				
				@Override
				public void act() {
					//each line should be another element in eventHistory
					historyDisplay.setText("");
					
					
				}
			});
			view.add(background);
			view.add(eventDisplay);
			view.add(updateStock);
			view.add(eventHistory);
			view.add(logo);
			view.add(historyDisplay);
		}
		
	}

}
