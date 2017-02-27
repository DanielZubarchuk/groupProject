package stockMarket;

import java.awt.Color;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

import guiPractice8.component.Action;
import guiPractice8.component.Button;
import guiPractice8.component.ClickableScreen;
import guiPractice8.component.Graphic;
import guiPractice8.component.Visible;
import projectComponents.ThemedTextLabel;
import stackInterfaces.DanielInterface;
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
	
	private ThemedTextLabel balanceDisplay;
	private Button backButton;
	private Button viewAllStocks;
	private Button viewAllTransactions;
	private Graphic background;
	private ThemedTextLabel stocksTitle;
	private ThemedTextLabel allStocks;
	private ThemedTextLabel transactionTitle;
	private ThemedTextLabel allTransactions;
	private ArrayList<String> history;
	public static double balance;
	
	private StockInventory stockInventory;
	
	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		background = new Graphic(0,0,getWidth(),getHeight(),"resources/images/moneybackground.jpg");
		viewObjects.add(background);
		
		//picture??
		backButton = new Button(10, 30, 90, 40, "back", Color.blue, new Action(){
			
			public void act(){
				UserScreen.user.setScreen(StockMainMenu.demo);
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
		
		updateTransactionHistory();
		
		viewAllTransactions = new Button(250, 230, 100, 30, "View All", Color.blue, new Action(){

			@Override
			public void act() {
				allTransactions = new ThemedTextLabel(15, 270, 400, 25, "There are no previous transactions!");
				viewObjects.add(allTransactions);
			}
			
		});
		viewObjects.add(viewAllTransactions);
	}		

	private void updateTransactionHistory(){
		if(Transaction.transactionHistory != null){
			for(int i = 0; i < Transaction.transactionHistory.size(); i++){
				history.add("You bought " + " shares of " + Transaction.transactionHistory.get(i) + " for $" + Transaction.transactionPrices.get(i));
			}
				
		}
	}
		
}
