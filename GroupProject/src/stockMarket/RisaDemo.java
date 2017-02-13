/**
 * 
 */
package stockMarket;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import guiPractice8.GUIApplication;
import guiPractice8.component.Action;
import guiPractice8.component.Button;
import guiPractice8.component.ClickableScreen;
import guiPractice8.component.Graphic;
import guiPractice8.component.Visible;
import projectComponents.ThemedTextLabel;
import stackInterfaces.StockInterface;
import stackInterfaces.StockInventory;

/**
 * @author Risa
 *
 */
public class RisaDemo extends GUIApplication {

	public static UserScreen user;
	
	public static ArrayList<ArrayList<Object>> currentStocks;
	public static ArrayList<StockInterface> prevTransactions; //??????
	public static double balance;

	public RisaDemo() {
		currentStocks = new ArrayList<ArrayList<Object>>();
		prevTransactions = new ArrayList<StockInterface>();
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
		RisaDemo demo = new RisaDemo();
		Thread app = new Thread(demo);
		app.start();
	}
	
	//nested inner class
	private class DemoScreen extends ClickableScreen{
		
		private ThemedTextLabel balanceDisplay;
		private Button backButton;
		private Graphic background;
		private ThemedTextLabel stocksDisplay;
		private ThemedTextLabel transactions;
		
		private StockInventory stockInventory;
		
		public DemoScreen(int width, int height) {
			super(width, height);
		}

		@Override
		public void initAllObjects(List<Visible> viewObjects) {
			background = new Graphic(0,0,getWidth(),getHeight(),"resources/images/moneybackground.jpg");
			viewObjects.add(background);
			
			//picture??
			backButton = new Button(10, 30, 90, 40, "back", Color.blue, new Action(){
				
				public void act(){
					//GabrielDemo.game.setScreen(GabrielDemo.game);
					System.out.println("goes back to main menu");
				}
			});
			viewObjects.add(backButton);
			
			balance = Transaction.userBalance;
			balanceDisplay = new ThemedTextLabel(250, 70, 800, 25, "Balance: $" + balance);
			viewObjects.add(balanceDisplay);
			
			//newStocks();
			
			stocksDisplay = new ThemedTextLabel(10, 100, 220, 25, "Current Stocks:");
			viewObjects.add(stocksDisplay);
			
			stockInventory = new Transaction();
			StockComponent stocks = new StockComponent(10, 140, 250, 25, stockInventory);
			viewObjects.add(stocks);
			
			transactions = new ThemedTextLabel(10, 200, 220, 25, "Transaction History:");
			viewObjects.add(transactions);
		}
		
		private void newStocks(){
			//need Daniel's interface??
			//if statement needed. only add the new stocks
//			
//			for(int i = 0; i < ; i++){
//				for(int j = 0; j < ; j++){
//					if()
//				}
//			}
			
			ArrayList<Object> temp = new ArrayList<Object>();
			String name = "stock 1"; 
			double price = 2.00;
			temp.add(name);
			temp.add(price);
			
			currentStocks.add(temp);
		}
		
		private void transactionHistory(){
			
		}
		
	}

}
