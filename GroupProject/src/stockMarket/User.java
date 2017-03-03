package src.stockMarket;

import java.awt.Color;
import java.util.ArrayList;

import guiPractice.components.Action;
import guiPractice.components.Button;
import guiPractice.ClickableScreen;
import guiPractice.components.Graphic;
import guiPractice.components.Visible;
import src.phone.App;
import src.projectComponents.ThemedTextLabel;
import src.stackInterfaces.StockInterface;
import src.stackInterfaces.StockInventory;

/**
 * @author Risa
 *
 */

public class User extends ClickableScreen implements App{
	
	public User(int width, int height) {
		super(width, height);
	}
	
	private Graphic background;
	
	public static double balance;
	private ThemedTextLabel balanceDisplay;
	
	private Button homeButton;
	private Button backButton;
	private Button viewAllStocks;
	private Button viewAllTransactions;
	
	private ThemedTextLabel stocksTitle;
	private ThemedTextLabel transactionTitle;
	private ThemedTextLabel transaction;
	private ThemedTextLabel stocksLabel;
	
	
	public static ArrayList<String> history = new ArrayList<String>();
	public static ArrayList<StockInterface> stocksInventory = new ArrayList<StockInterface>();
	
	private StockInventory inventory;
	
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
		
		transactionTitle = new ThemedTextLabel(10, 230, 220, 25, "Transaction History:");
		viewObjects.add(transactionTitle);
		
		inventory = StockMainMenu.getTransaction();
		StockComponent stocks = new StockComponent(10, 170, 250, 25, inventory, _STOCK);
		viewObjects.add(stocks);
		
		StockComponent transactions = new StockComponent(10, 270, 250, 25, inventory, _TRANSACTION);
		viewObjects.add(transactions);
		

		if(!stocksInventory.isEmpty()){
			int y = 180;
			for(StockInterface s : inventory.getStocks()){
				stocksInventory.add(s);
				String temp = s.getStockName() + "	$" + s.getStockPrice() + " " + s.getStockQuantity(); 
				stocksLabel = new ThemedTextLabel(10, y, 600, 25, temp);
				y += 40;
				viewObjects.add(stocks);
			}
		}else{
			stocksLabel = new ThemedTextLabel(10, 180, 400, 25, "You don't own any stocks.");
			viewObjects.add(stocks);
		}
		
		viewAllStocks = new Button(250, 130, 100, 30, "View All", Color.black, new Action(){

			@Override
			public void act() {
				
				if(!stocksInventory.isEmpty()){
					int y = 180;
					for(StockInterface s : stocksInventory){
						String temp = s.getStockName() + "	$" + s.getStockPrice() + " " + s.getStockQuantity(); 
						stocksLabel = new ThemedTextLabel(10, y, 600, 25, temp);
						y += 40;
						viewObjects.add(stocks);
					}
				}
			}
			
		});
		viewObjects.add(viewAllStocks);
		
		
		transactionTitle = new ThemedTextLabel(580, 130, 220, 25, "Transaction History:");
		viewObjects.add(transactionTitle);
	
		
		if(history.isEmpty()){
			transaction = new ThemedTextLabel(580, 180, 400, 25, "You don't have any previous transactions.");
			viewObjects.add(transaction);
		}else{
			int y = 180;
			for(StockInterface s : inventory.getStocks()){
				String temp = "You bought " + s.getStockQuantity() + " " + s.getStockName() + " for " + s.getStockPrice();
				history.add(temp);
				transaction = new ThemedTextLabel(580, y, 600, 25, temp);
				viewObjects.add(transaction);
				y += 40;
			}
		}
		
		viewAllTransactions = new Button(800, 130, 100, 30, "View All", Color.black, new Action(){

			@Override
			public void act() {
				
				if(!history.isEmpty()){
					int x = 580;
					int y = 180;
					for(String s : history){
						transaction = new ThemedTextLabel(x, y, 600, 25, s);
						viewObjects.add(transaction);
						y += 40;
					}
				}
			}
			
		});
		viewObjects.add(viewAllTransactions);
		homeButton = new Button(getWidth()/2-30, 560 , 60, 30, "Home", new Color(0,0,0), new Action(){
			@Override
			public void act(){
				src.phone.MainMenu.mms.setScreen(src.phone.MainMenu.menuScreen);
			}
		});
		viewObjects.add(homeButton);
	}
		
	public ArrayList<StockInterface> getStocksInventory() {
		return stocksInventory;
	}

	@Override
	public Graphic getGraphic() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setHomeButton(Button homeButton) {
		this.homeButton = homeButton;		
	}
}