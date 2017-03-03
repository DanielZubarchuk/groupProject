package stockMarket;

import java.awt.Color;
import java.util.ArrayList;

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

public class User extends ClickableScreen{
	
	public User(int width, int height) {
		super(width, height);
	}
	
	private Graphic background;
	
	public static double balance;
	private ThemedTextLabel balanceDisplay;
	
	private Button backButton;
	private Button viewAllStocks;
	private Button viewAllTransactions;
	
	private ThemedTextLabel stocksTitle;
	private ThemedTextLabel transactionTitle;
	
	private StockInventory stockInventory;
	
	private final int ALL_STOCKS = 0;
	private final int ALL_TRANSACTIONS = 1;
	private final int _STOCK = 3;
	private final int _TRANSACTION = 4;
	
	public static ArrayList<String> history = new ArrayList<String>();
	public static ArrayList<StockInterface> stocksInventory = new ArrayList<StockInterface>();
	
	public void initAllObjects(ArrayList<Visible> viewObjects) {
		background = new Graphic(0,0,getWidth(),getHeight(),"resources/images/newmoneybackground.png");
		viewObjects.add(background);
		
		//picture??
		backButton = new Button(10, 30, 90, 40, "back", Color.green, new Action(){
			
			public void act(){
				StockMainMenu.mainScreen.setScreen(StockMainMenu.gameScreen);
			}
		});
		viewObjects.add(backButton);
		
		balance = Transaction.userBalance;
		balanceDisplay = new ThemedTextLabel(250, 70, 800, 25, "Balance: $" + balance);
		viewObjects.add(balanceDisplay);
		
		stocksTitle = new ThemedTextLabel(10, 130, 220, 25, "Current Stocks:");
		viewObjects.add(stocksTitle);
		
		transactionTitle = new ThemedTextLabel(10, 230, 220, 25, "Transaction History:");
		viewObjects.add(transactionTitle);
		
		stockInventory = new Transaction();
		StockComponent stocks = new StockComponent(10, 170, 250, 25, stockInventory, _STOCK);
		viewObjects.add(stocks);
		
		StockComponent transactions = new StockComponent(10, 270, 250, 25, stockInventory, _TRANSACTION);
		viewObjects.add(transactions);
		
		
		viewAllStocks = new Button(250, 130, 100, 30, "View All", Color.black, new Action(){

			@Override
			public void act() {
				StockComponent allStocks = new StockComponent(10, 170, 250, 25, stockInventory, ALL_STOCKS);
				viewObjects.add(allStocks);
			}
			
		});
		viewObjects.add(viewAllStocks);
		
		viewAllTransactions = new Button(250, 230, 100, 30, "View All", Color.black, new Action(){

			@Override
			public void act() {
				StockComponent allTransactions = new StockComponent(10, 270, 250, 25, stockInventory, ALL_TRANSACTIONS);
				viewObjects.add(allTransactions);
			}
			
		});
		viewObjects.add(viewAllTransactions);
	}
		
	public static ArrayList<StockInterface> getStocksInventory() {
		return stocksInventory;
	}
}