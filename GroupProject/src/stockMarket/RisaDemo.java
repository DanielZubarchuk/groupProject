/**
 * 
 */
package stockMarket;

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;

import guiPractice.GUIApplication;
import guiPractice.components.Action;
import guiPractice.components.Button;
import guiPractice.ClickableScreen;
import guiPractice.components.Graphic;
import guiPractice.components.Visible;
import projectComponents.ThemedTextLabel;
import stackInterfaces.StockInterface;
import stackInterfaces.StockInventory;

/**
 * @author Risa
 *
 */
public class RisaDemo extends GUIApplication {

	public static User user;
	public static RisaDemo demo;
	
	public static double balance;
	private ArrayList<String> history;

	public RisaDemo() {

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
		demo = new RisaDemo();
		Thread app = new Thread(demo);
		app.start();
	}
	
	//nested inner class
	private class DemoScreen extends ClickableScreen{
		
		private ThemedTextLabel balanceDisplay;
		private Button backButton;
		private Button viewAllStocks;
		private Button viewAllTransactions;
		private Graphic background;
		private ThemedTextLabel stocksTitle;
		private ThemedTextLabel allStocks;
		private ThemedTextLabel transactionTitle;
		private ThemedTextLabel allTransactions;
		
		private StockInventory stockInventory;
		
		public DemoScreen(int width, int height) {
			super(width, height);
		}

		public void initAllObjects(List<Visible> viewObjects) {
			background = new Graphic(0,0,getWidth(),getHeight(),"resources/images/moneybackground.jpg");
			viewObjects.add(background);
			
			//picture??
			backButton = new Button(10, 30, 90, 40, "back", Color.blue, new Action(){
				
				public void act(){
					RisaDemo.demo.setScreen(StockMainMenu.demo);
					System.out.println("goes back to main menu");
				}
			});
			viewObjects.add(backButton);
			
			balance = Transaction.userBalance;
			balanceDisplay = new ThemedTextLabel(250, 70, 800, 25, "Balance: $" + balance);
			viewObjects.add(balanceDisplay);
			
			stocksTitle = new ThemedTextLabel(10, 130, 220, 25, "Current Stocks:");
			viewObjects.add(stocksTitle);
			
			stockInventory = new Transaction();
			StockComponent stocks = new StockComponent(10, 170, 250, 25, stockInventory);
			viewObjects.add(stocks);
			
			viewAllStocks = new Button(250, 130, 100, 30, "View All", Color.blue, new Action(){

				@Override
				public void act() {
					allStocks = new ThemedTextLabel(15, 170, 300, 25, "You don't own any stocks!");
					viewObjects.add(allStocks);
				}
				
			});
			viewObjects.add(viewAllStocks);
			
			transactionTitle = new ThemedTextLabel(10, 230, 220, 25, "Transaction History:");
			viewObjects.add(transactionTitle);
			
			//updateTransactionHistory();
			
			viewAllTransactions = new Button(250, 230, 100, 30, "View All", Color.blue, new Action(){

				@Override
				public void act() {
					allTransactions = new ThemedTextLabel(15, 270, 400, 25, "There are no previous transactions!");
					viewObjects.add(allTransactions);
				}
				
			});
			viewObjects.add(viewAllTransactions);
		}		
	
//		private void updateTransactionHistory(){
//			if(Transaction.transactionHistory != null){
//				for(int i = 0; i < Transaction.transactionHistory.size(); i++){
//					history.add("You bought " + " shares of " + Transaction.transactionHistory.get(i) + " for $" + Transaction.transactionPrices.get(i));
//				}
//					
//			}
//		}
		
		
		
	}
}