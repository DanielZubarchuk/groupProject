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
	private ThemedTextLabel transaction;
	
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
		backButton = new Button(10, 30, 90, 40, "back", Color.black, new Action(){
			
			public void act(){
				StockMainMenu.mainScreen.setScreen(StockMainMenu.gameScreen);
			}
		});
		viewObjects.add(backButton);
		
		balance = Transaction.userBalance;
		int stringLength = (("Balance: $" + balance).length()) + 100;
		balanceDisplay = new ThemedTextLabel((getWidth()- stringLength) / 2, 80, 800, 25, "Balance: $" + balance);
		viewObjects.add(balanceDisplay);
		
		stocksTitle = new ThemedTextLabel(10, 130, 220, 25, "Current Stocks:");
		viewObjects.add(stocksTitle);
		
		transactionTitle = new ThemedTextLabel(580, 130, 220, 25, "Transaction History:");
		viewObjects.add(transactionTitle);
		
		stockInventory = new Transaction();
		StockComponent stocks = new StockComponent(10, 170, 250, 25, stockInventory, _STOCK);
		viewObjects.add(stocks);
		
		if(stockInventory.getStocks().isEmpty()){
			transaction = new ThemedTextLabel(580, 180, 220, 25, "You don't have any previous transactions");
			viewObjects.add(transaction);
		}else{
			for(StockInterface s : stocksInventory.getStocks()){
				transaction = new ThemedTextLabel(x, y, 220, 25, "You bought " + s.getStockQuantity() + " " + s.getStockName() + " for " + s.getStockPrice());
			}
		}
		
		viewAllStocks = new Button(250, 130, 100, 30, "View All", Color.black, new Action(){

			@Override
			public void act() {
				StockComponent allStocks = new StockComponent(10, 170, 250, 25, stockInventory, ALL_STOCKS);
				viewObjects.add(allStocks);
			}
			
		});
		viewObjects.add(viewAllStocks);
		
		viewAllTransactions = new Button(800, 130, 100, 30, "View All", Color.black, new Action(){

			@Override
			public void act() {
				StockComponent allTransactions = new StockComponent(10, 270, 250, 25, stockInventory, ALL_TRANSACTIONS);
				viewObjects.add(allTransactions);
			}
			
		});
		viewObjects.add(viewAllTransactions);
	}
		
	public ArrayList<StockInterface> getStocksInventory() {
		return stocksInventory;
	}
}