/**
 * 
 */
package stockMarket;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import guiPractice.GUIApplication;
import guiPractice.components.Action;
import guiPractice.components.Button;
import guiPractice.ClickableScreen;
import guiPractice.TextLabel;
import guiPractice.components.Graphic;
import guiPractice.components.Visible;
import guiPractice.sampleGames.TextArea;
import projectComponents.ThemedTextLabel;

/**
 * @author Daniel
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
		private TextLabel startDialogue;
		private TextArea mainDialogue;
		private ThemedTextLabel transactionDisplay;
		
		private Button buyAStock;
		private Button sellAStock;
		
		private Graphic rectangle;
		private Graphic background;
		private Graphic logo;
		private Button makeADialogue;
		
		private boolean dialogueBuy;
		private TextLabel userBal;
		
		private int index = 0;
		
		public DemoScreen(int width, int height) {
			super(width, height);
		}

		public void initAllObjects(ArrayList<Visible> view) {
			background = new Graphic(0,0,getWidth(),getHeight(),"resources/images/moneybackground.jpg");
			transactionDisplay = new ThemedTextLabel(40, 150, 800, 25, "");
			logo = new Graphic(40, 50, 90, 90, "resources/images/logo.png");
			//startDialogue = new TextLabel(130,230,300,40,"Do you want to buy or sell?");
			//userBal = new TextLabel(130,230,300,40, Transaction.userBalance);
			
			buyAStock = new Button(40, 200, 190, 40, "Buy", Color.blue, new Action() {
			//click this to buy a stock
			@Override
				public void act() {
				dialogueBuy = true;
				transaction.buyAStock();
				transactionDisplay.setText(Transaction.transactionHistory.get(index) + " was bought for " + Transaction.transactionPrices.get(index));
//				index++;
				view.add(transactionDisplay);
			}
			});
			view.add(buyAStock);
			
			sellAStock = new Button(290,200, 250, 40, "Sell", Color.blue, new Action() {			
				//click this to sell a stock
				@Override
				public void act() {
					dialogueBuy = false;
					transactionDisplay.setText(Transaction.transactionHistory.get(index) + " was sold for " + Transaction.transactionPrices.get(index));
					transaction.sellAStock();
//					index++;
				}
			});
			
			view.add(sellAStock);
			
			view.add(transactionDisplay);
		}
		
	}

}
