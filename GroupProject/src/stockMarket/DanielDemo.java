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
import projectComponents.ThemedTextLabel;

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
		private Graphic background;
		private Graphic logo;
		private ThemedTextLabel transactionDisplay;
		private Button sellAStock;
		
		public DemoScreen(int width, int height) {
			super(width, height);
		}

		@Override
		public void initAllObjects(List<Visible> view) {
			background = new Graphic(0,0,getWidth(),getHeight(),"resources/images/moneybackground.jpg");
			transactionDisplay = new ThemedTextLabel(40, 150, 800, 25, "");
			logo = new Graphic(40, 50, 90, 90, "resources/images/logo.png");
			
			buyAStock = new Button(40, 200, 190, 40, "AddTransaction", Color.blue, new Action() {
				//click this to but a stock
			@Override
				public void act() {
				transactionDisplay.setText(Transaction.transactionHistory[i] + " was bought for " + Transaction.transactionPrices[i]);
				}
			});
			view.add(actionDisplay);
			view.add(buyAStock);
			
			sellAStock = new Button(290,200 , 250, 40, "AddTransaction", Color.blue, new Action() {			
				//click this to sell a stock
				@Override
					public void act() {
					transactionDisplay.setText(Transaction.transactionHistory[i] + " was sold for " + Transaction.transactionPrices[i]);
					}
				});
			
//			rectangle = new Graphic(40, 100, 190, 40,"resources/images/greenrect.png");
//			view.add(rectangle);
		}
		
	}

}
