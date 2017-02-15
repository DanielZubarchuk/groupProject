/**
 * 
 */
package stockMarket;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.util.ArrayList;
import java.util.List;

import guiPractice8.GUIApplication;
import guiPractice8.component.Action;
import guiPractice8.component.Button;
import guiPractice8.component.ClickableScreen;
import guiPractice8.component.Graphic;
import guiPractice8.component.Visible;
import projectComponents.MultiLineTextLabel;
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
		private MultiLineTextLabel historyDisplay;
		private MultiLineTextLabel historyDisplay2;
		private MultiLineTextLabel historyDisplay3;
//		private ArrayList<ThemedTextLabel> stockDisplay;
		
		
		public DemoScreen(int width, int height) {
			super(width, height);
			// TODO Auto-generated constructor stub
		}

//		private void instantiateStocksDisplay(){
//			stockDisplay = new ArrayList<ThemedTextLabel>();
//			int previousHeight = 50;
//			for(int i = 0; i < 6; i++){
//				stockDisplay.add(new ThemedTextLabel(120, previousHeight + 50, 800, 25, ""));
//			}
//			int index = 0;
//			for(ThemedTextLabel stock: stockDisplay){
//				if(index < 5)
//				stock.setText(Fluctuation.getStockNames()[index]);
//				index++;
//			}
//		}
		
		@Override
		public void initAllObjects(List<Visible> view) {
//			instantiateStocksDisplay();
			
			eventDisplay = new ThemedTextLabel(40, 170, 800, 25, "");
			background = new Graphic(0,0,getWidth(),getHeight(),"resources/images/newmoneybackground.png");
			logo = new Graphic(40, 50, 90, 90, "resources/images/logo.png"); 
			historyDisplay = new MultiLineTextLabel(40, 250, 800, 50,"");
			historyDisplay2 = new MultiLineTextLabel(40, 270, 800, 50,"");
			historyDisplay3 = new MultiLineTextLabel(40, 290, 800, 50,"");
			
			updateStock = new Button(40, 220, 190, 40, "Update Stock", Color.blue, new Action() {
				@Override
				public void act() {
					Fluctuation.getEventHistory().add("Current state of " + Fluctuation.getStockNames()[VictorDemo.fluctuation.getEventStock()] 
							+ ": "
							+ VictorDemo.fluctuation.outputEvent() 
							+ "(" + String.format( "%.2f", Fluctuation.getStockGrowths()[VictorDemo.fluctuation.getEventStock()] )
							+ " )" + String.format( "%.2f", Fluctuation.getStockPrices()[VictorDemo.fluctuation.getEventStock()] ) + "\n");
					
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
					/**
					* for(String s: Fluctuation.getEventHistory){
					* 	// either use scrollpanes or
					*	// use y+getFontMetrics() to show multiple lines of events
					*	// make a new text label component for multi lined strings 
					*	// but change the g.drawString method
					* }
					**/
					if(Fluctuation.getEventHistory().size() >= 1){
						historyDisplay.setText(Fluctuation.getEventHistory().get(Fluctuation.getEventHistory().size()-1) );
					}
					if(Fluctuation.getEventHistory().size() >= 2){
						historyDisplay2.setText(Fluctuation.getEventHistory().get(Fluctuation.getEventHistory().size()-2) );
					}
					if(Fluctuation.getEventHistory().size() >= 3){
						historyDisplay3.setText(Fluctuation.getEventHistory().get(Fluctuation.getEventHistory().size()-3) );
					}
//					historyDisplay.setText("Hello\nWorld");
					
				}
			});
			view.add(background);
			view.add(eventDisplay);
			view.add(historyDisplay);
			view.add(historyDisplay2);
			view.add(historyDisplay3);
			view.add(updateStock);
			view.add(eventHistory);
			view.add(logo);
//			for(ThemedTextLabel stock: stockDisplay){
//				view.add(stock);
//			}
			
		}
		
	}

}
