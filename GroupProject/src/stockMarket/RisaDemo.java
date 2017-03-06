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
		
		private Button backButton;
		private Button viewAllStocks;
		private Button viewAllTransactions;
		
		private Graphic background;
		
		private ThemedTextLabel balanceDisplay;
		private ThemedTextLabel stocksTitle;
		private ThemedTextLabel transactionTitle;
		
		private StockInventory stockInventory;
		
		private final int ALL_STOCKS = 0;
		private final int ALL_TRANSACTIONS = 1;
		
		public DemoScreen(int width, int height) {
			super(width, height);
		}

		public void initAllObjects(ArrayList<Visible> viewObjects) {
			background = new Graphic(0,0,getWidth(),getHeight(),"resources/images/moneybackground.jpg");
			viewObjects.add(background);
			
			//picture??
			backButton = new Button(10, 30, 90, 40, "back", Color.blue, new Action(){
				
				public void act(){
					RisaDemo.demo.setScreen(StockMainMenu.gameScreen);
					System.out.println("goes back to main menu");
				}
			});
			viewObjects.add(backButton);
			
			balance = Transaction.userBalance;
			balanceDisplay = new ThemedTextLabel(250, 70, 800, 25, "Balance: $" + balance);
			viewObjects.add(balanceDisplay);
			
			stocksTitle = new ThemedTextLabel(10, 130, 220, 25, "Current Stocks");
			viewObjects.add(stocksTitle);
			
			stockInventory = new Transaction();//change to stockmainmenu.getTransaction()
			
			viewAllStocks = new Button(160, 130, 95, 25, "View All", Color.black, new Action(){

				@Override
				public void act() {
					StockComponent allStocks = new StockComponent(15, 170, getWidth()/2 - 25, getHeight() - 190, stockInventory, ALL_STOCKS);
					viewObjects.add(allStocks);
				}
				
			});
			viewObjects.add(viewAllStocks);
			
			
			transactionTitle = new ThemedTextLabel(getWidth()/2, 130, 220, 25, "Transaction History");
			viewObjects.add(transactionTitle);
			
			viewAllTransactions = new Button((getWidth()/2) + 200, 130, 95, 25, "View All", Color.black, new Action(){

				@Override
				public void act() {
					StockComponent allTransactions = new StockComponent((getWidth()/2) + 10, 170, getWidth()/2 - 20, getHeight() - 190, stockInventory, ALL_TRANSACTIONS);
					viewObjects.add(allTransactions);
				}
				
			});
			viewObjects.add(viewAllTransactions);
			
		}		
	
	}
}