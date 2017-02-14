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

		public String[] buyLog = {"Which stock do you want to buy?", 
				"How many shares of the Stock do you want to buy?", 
				"You do not have enough money!",
				"You do not have enough money!", 
				"You do not have money to buy stocks! Try selling stocks to improve your balance."
				};
		public String[] sellLog = {"Which stock do you want to sell?",
				"How many shares of the Stock do you want to sell?"
				};
		
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
		
		
		
		public DemoScreen(int width, int height) {
			super(width, height);
		}

		@Override
		public void initAllObjects(List<Visible> view) {
			background = new Graphic(0,0,getWidth(),getHeight(),"resources/images/moneybackground.jpg");
			transactionDisplay = new ThemedTextLabel(40, 150, 800, 25, "");
			logo = new Graphic(40, 50, 90, 90, "resources/images/logo.png");
			startDialogue = new TextLabel(130,230,300,40,"Do you want to buy or sell?");
			//userBal = new TextLabel(130,230,300,40, Transaction.userBalance);
			
			buyAStock = new Button(40, 200, 190, 40, "Add Transaction", Color.blue, new Action() {
			//click this to buy a stock
			@Override
				public void act() {
				dialogueBuy = true;
				transaction.buyAStock();
				transactionDisplay.setText(Transaction.transactionHistory[i] + " was bought for " + Transaction.transactionPrices[i]);
				
			}
			});
			view.add(actionDisplay);
			view.add(buyAStock);
			
			sellAStock = new Button(290,200, 250, 40, "Add Transaction", Color.blue, new Action() {			
				//click this to sell a stock
				@Override
				public void act() {
					dialogueBuy = false;
					transaction.sellAStock();
					transactionDisplay.setText(Transaction.transactionHistory[i] + " was sold for " + Transaction.transactionPrices[i]);
				}
			});
			
			view.add(sellAStock);
			
			makeADialogue = new Button(290,200, 250, 40, "Run the Dialogue", Color.blue, new Action() {			
				//click this to run the dialogue
				@Override
				public void act() {
					startDialogue.setText("");
					if(dialogueBuy == true){
						for(int n = 0; n < buyLog.length; n++){
							
						}
					}else{
						for(int m = 0; m < sellLog.length; m++){
							
						}
					}
					
				
				}
			});
			
			view.add(makeADialogue);
			
//			rectangle = new Graphic(40, 100, 190, 40,"resources/images/greenrect.png");
//			view.add(rectangle);
		}
		
	}

}
