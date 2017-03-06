package src.stockMarket;

import java.awt.Color;
import java.util.ArrayList;

import guiPractice.components.Action;
import guiPractice.components.Button;
import guiPractice.ClickableScreen;
import guiPractice.components.Graphic;
import guiPractice.components.Visible;
import src.projectComponents.ThemedTextLabel;
import src.stackInterfaces.DanielInterface;
import src.stackInterfaces.StockInterface;
import src.stockMarket.StockMainMenu;
import src.stockMarket.Transaction;

/**
 * @author Risa
 *
 */

public class User extends ClickableScreen implements DanielInterface{
	
	public User(int width, int height) {
		super(width, height);
	}
	
	private Graphic background;
	
	public static double balance;
	
	private Button backButton;
	private Button viewAllStocks;
	private Button viewAllTransactions;
	
	private ThemedTextLabel balanceDisplay;
	private ThemedTextLabel stocksTitle;
	private ThemedTextLabel transactionTitle;
	
	public static ArrayList<StockInterface> stocksInventory = new ArrayList<StockInterface>();
	
	private final int ALL_STOCKS = 0;
	private final int ALL_TRANSACTIONS = 1;
	
	private Transaction stockInventory;
	
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
		
		balance = stockInventory.getUserBalance();
		int stringLength = (("Balance: $" + balance).length()) + 100;
		balanceDisplay = new ThemedTextLabel((getWidth()- stringLength) / 2, 80, 800, 25, "Balance: $" + balance);
		viewObjects.add(balanceDisplay);
		
		stockInventory = StockMainMenu.getTransaction();
		
		stocksTitle = new ThemedTextLabel(10, 130, 220, 25, "Current Stocks");
		viewObjects.add(stocksTitle);
		
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
		
	public ArrayList<StockInterface> getStocksInventory() {
		return stocksInventory;
	}

	@Override
	public void addStock(String name, Double price) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addTransaction(String name, Double price, int quantity) {
		// TODO Auto-generated method stub
		
	}
}