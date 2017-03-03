package src.stockMarket;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

import guiPractice.GUIApplication;
import guiPractice.Screen;
import guiPractice.TextLabel;
import guiPractice.components.Action;
import guiPractice.components.Button;
import guiPractice.ClickableScreen;
import guiPractice.components.Graphic;
import guiPractice.components.Visible;
import src.App;
import src.MainMenu;
import src.projectComponents.MultiLineTextLabel;
import src.projectComponents.ThemedTextLabel;
import src.stackInterfaces.StockInterface;

public class StockMainMenu extends GUIApplication {
	
		public static StockMainMenu mainScreen;
		public static User inventoryScreen;
		public static Screen gameScreen;
		private static Transaction transaction;
		private static Fluctuation fluctuation;
		public static String selectedStock;
		
		public StockMainMenu() {
			transaction = new Transaction();
			fluctuation = new Fluctuation();
		}
		
		
		@Override
		protected void initScreen() {
			// for screens of phone and games
			gameScreen = new MenuScreen(1000, 600);
			//demo = new DemoScreen(getWidth(), getHeight());
			inventoryScreen = new User(1000, 600);
			setScreen(gameScreen);
		}

		/**
		
		 */
		public static void main(String[] args) {
			mainScreen = new StockMainMenu();
			Thread app = new Thread(mainScreen);
			app.start();

		}
		
		public static Transaction getTransaction() {
			return transaction;
		}

//nested inner class
public static class MenuScreen extends ClickableScreen implements App{
	
	private ArrayList<Button> buttons;
	private Button homeButton;
	public ThemedTextLabel display;
	private String Samsung;
	private String Blackgate;
	private String Apple;
	private String Glascow;
	private String Generalmotors;
	public String[] stocks = {Samsung, Blackgate, Apple, Glascow, Generalmotors};
	private ThemedTextLabel price1;
	private ThemedTextLabel price2;
	private ThemedTextLabel price3;
	private ThemedTextLabel price4;
	private ThemedTextLabel price5;
	private Button stock1;
	private Button stock2;
	private Button stock3;
	private Button stock4;
	private Button[] stockButtons = {stock1, stock2, stock3, stock3, stock4};
	private ThemedTextLabel shareText;
	private int shareNumber;
	private ThemedTextLabel shareLabel;
	private Button plus;
	private Button minus;
	private Button select1;
	private Button select2;
	private Button select3;
	private Button select4;
	private Button select5;
	private Graphic logo;
	private ThemedTextLabel goal;
	private ThemedTextLabel turn;
	private Graphic background;
	private Button buy;
	private Button sell;
	private Button user;
	private Button end;
	private int turncount;
	private int goalcount;
	private ThemedTextLabel historyDisplay;
	private ThemedTextLabel historyDisplay2;
	private ThemedTextLabel historyDisplay3;
	private ThemedTextLabel eventDisplay;
	public int stockIndex;
	private Button eventHistory;
	
	
	public MenuScreen(int width, int height) {
		super(width, height);
				
	}
	
	public void createStocks(){
			for(int i = 0; i < 5; i++){
				Button temp = new Button(20,140+(50*i),90,30,"",Color.GREEN, new Action() {
					@Override
					public void act() {
						for(int i =0; i<5; i++){
							selectStock(stocks[i]);
							return;
						}
					}
				});
				temp.setSize(20);
				//temp.setText(stocks[i]);
				//stockButtons[i] = temp;
				//buttons.add(stockButtons[i]);
				if(i == 0){
					temp.setText(Samsung);
					stock1 = temp;
					buttons.add(stock1);
				}
				if(i == 1){
					temp.setText(Blackgate);
					stock2 = temp;
					buttons.add(stock2);
				}
				if(i == 2){
					temp.setText(Apple);
					stock3 = temp;
					buttons.add(stock3);
				}
				if(i == 3){
					temp.setText(Glascow);
					stock4 = temp;
					buttons.add(stock4);
				}
				if(i == 4){
					temp.setText(Generalmotors);
					stock4 = temp;
					buttons.add(stock4);
				}
			}					
			return;
	}
	
	public void selectStock(String stock){
		selectedStock = stock;
		display.setText("You selected "+selectedStock+" as your stock");
	}
	
	public void printStocks(ArrayList<Button> buttons){
		for(int i = 0; i < buttons.size(); i++){
			viewObjects.add(buttons.get(i));
		}
	}
	
	@Override
	public void initAllObjects(ArrayList<Visible> viewObjects) {
		
		buttons = new ArrayList<Button>();
		Samsung = "Samsung";
		Blackgate = "Blackgate";
		Apple = "Apple";
		Glascow = "Glascow";
		Generalmotors = "General Motors";
		display = new ThemedTextLabel(300, 70, 800, 25, "Choose an action.");
		turncount = 0;
		goalcount = 50000;
		historyDisplay = new ThemedTextLabel(40, 430,800, 50,"");
		historyDisplay2 = new ThemedTextLabel(40, 470, 800, 50,"");
		historyDisplay2.setBgcolor(Color.green);
		historyDisplay3 = new ThemedTextLabel(40, 510, 800, 50,"");
		historyDisplay3.setBgcolor(Color.green);
		eventDisplay = new ThemedTextLabel(40, 380, 800, 25, "");
		eventDisplay.setBgcolor(Color.green);
		
		
		background=new Graphic(0,0,getWidth(),getHeight(),"resources/images/newmoneybackground.png");
		viewObjects.add(background);
		
		logo = new Graphic(40, 50, 90, 90, "resources/images/logo.png"); 
		viewObjects.add(logo);
		
		turn = new ThemedTextLabel(700, 10, 90,90,"Turn " + turncount);
		viewObjects.add(turn);
		
		goal = new ThemedTextLabel(680, 35, 200,90,"Goal:$" + goalcount);
		viewObjects.add(goal);
		
		shareText = new ThemedTextLabel(200,155,70,90,"Shares:");
		viewObjects.add(shareText);
		
		createStocks();
		printStocks(buttons);
		/**		
		select1 = new Button(20,140,90,30,Samsung, Color.green,new Action(){
			@Override
			public void act() {
				selectStock(Samsung);	
			}
		});
		viewObjects.add(select1);
		
		price1 = new ThemedTextLabel(40,140,90,30,"");
		//price1.setText(""+transaction.getStocks().get(0).getStockPrice());
		//System.out.println(transaction.getStocks().get(transaction.getStocks().size()).getStockPrice());
		viewObjects.add(price1);
		
		select2 = new Button(20,180,90,30,Blackgate, Color.green,new Action() {
			@Override
			public void act() {
				selectStock(Blackgate);	
			}
		});
		viewObjects.add(select2);
		
		select3 = new Button(20,215,90,30,Apple, Color.green,new Action() {
			@Override
			public void act() {
				selectStock(Apple);	
			}
		});
		viewObjects.add(select3);
		
		select4 = new Button(20,250,90,30,Glascow, Color.green,new Action() {
			@Override
			public void act() {
				selectStock(Glascow);	
			}
		});
		viewObjects.add(select4);
		
		select5 = new Button(20,290,145,30,Generalmotors, Color.green,new Action() {
			@Override
			public void act() {
				selectStock(Generalmotors);	
			}
		});
		viewObjects.add(select5);
		*/
		
		shareLabel = new ThemedTextLabel(225,180,70,90,Integer.toString(shareNumber));
		viewObjects.add(shareLabel);
		
		plus = new Button(260,245,25,20,"+",Color.green, new Action() {
			@Override
			public void act() {
				shareNumber++;
				shareLabel.setText(Integer.toString(shareNumber) );
			}
		});
		viewObjects.add(plus);
		
		minus = new Button(200,245,25,20,"-",Color.green, new Action() {
			@Override
			public void act() {
				if(shareNumber > 0){
					shareNumber--;
				}
				
				shareLabel.setText(Integer.toString(shareNumber));
			}
		});
		viewObjects.add(minus);
			eventHistory = new Button(500,150, 250, 40, "Event History", Color.green, new Action() {
			
			@Override
			public void act() {
	
				StockMainMenu.fluctuation.updateStock(transaction);
				
				fluctuation.getEventHistory().add("Current state of " + transaction.getStocks().get(StockMainMenu.fluctuation.getEventStock()).getStockName()
						+ ": "
						+ StockMainMenu.fluctuation.outputEvent() 
						+ "(" +  String.format( "%.2f",transaction.getStocks().get(StockMainMenu.fluctuation.getEventStock()).getGrowthRate())
						+ " )" +  String.format( "%.2f",transaction.getStocks().get(StockMainMenu.fluctuation.getEventStock()).getStockPrice()));
				
				eventDisplay.setText(fluctuation.getEventHistory().get(fluctuation.getEventHistory().size()-1));
				
				if(fluctuation.getEventHistory().size() >= 1){
					historyDisplay.setText(fluctuation.getEventHistory().get(fluctuation.getEventHistory().size()-1) );
					historyDisplay.setBgcolor(Color.green);
				}
				if(fluctuation.getEventHistory().size() >= 2){
					historyDisplay2.setText(fluctuation.getEventHistory().get(fluctuation.getEventHistory().size()-2) );
				}
				if(fluctuation.getEventHistory().size() >= 3){
					historyDisplay3.setText(fluctuation.getEventHistory().get(fluctuation.getEventHistory().size()-3) );
				}
				
//				StockMainMenu.fluctuation.updateStock(transaction);
//				historyDisplay.setText("Hello\nWorld");
				
			}
		});
			
		viewObjects.add(eventHistory);
		
		buy = new Button(500, 200, 90, 40, "Buy", Color.green, new Action() {
			
				public void act() {
					if(selectedStock == null || shareNumber ==0){
						display.setText("You must select a stock and shares.");
					}
					if(Transaction.userBalance < Transaction.stockPrice){
						display.setText("You don't have enough money");
					}
					else{
						transaction.buyAStock();
						display.setText(shareNumber+ " shares of " + transaction.transactionHistory.get(stockIndex) + " were bought for $" 
								+ String.format( "%.2f",Transaction.transactionPrices.get(stockIndex)));
						StockMainMenu.fluctuation.updateStock(transaction);
						
						fluctuation.getEventHistory().add("Current state of " + transaction.getStocks().get(StockMainMenu.fluctuation.getEventStock()).getStockName()
								+ ": "
								+ StockMainMenu.fluctuation.outputEvent() 
								+ "(" + String.format( "%.2f",transaction.getStocks().get(StockMainMenu.fluctuation.getEventStock()).getGrowthRate())
								+ " )" + String.format( "%.2f",transaction.getStocks().get(StockMainMenu.fluctuation.getEventStock()).getStockPrice()));
						
						eventDisplay.setText(fluctuation.getEventHistory().get(fluctuation.getEventHistory().size()-1));
						
						if(fluctuation.getEventHistory().size() >= 1){
							historyDisplay.setText(fluctuation.getEventHistory().get(fluctuation.getEventHistory().size()-1) );
						}
						if(fluctuation.getEventHistory().size() >= 2){
							historyDisplay2.setText(fluctuation.getEventHistory().get(fluctuation.getEventHistory().size()-2) );
						}
						if(fluctuation.getEventHistory().size() >= 3){
							historyDisplay3.setText(fluctuation.getEventHistory().get(fluctuation.getEventHistory().size()-3) );
						}
						
						StockMainMenu.fluctuation.updateStock(transaction);
					}

					
			}
		});
		viewObjects.add(buy);
		viewObjects.add(display);

		user = new Button(500, 250, 200, 40, "User Portfolio", Color.green, new Action() {
			
			@Override
			public void act() {
				System.out.println("Transporting to your portfolio");
				StockMainMenu.mainScreen.setScreen(inventoryScreen);
			}
		});
		viewObjects.add(user);
		viewObjects.add(display);
			
		sell = new Button(600, 200, 90, 40, "Sell", Color.green, new Action() {
				
				@Override
				public void act() {
					if(selectedStock == null || shareNumber ==0){
						display.setText("You must select a stock and shares.");
					}
					if(!User.stocksInventory.contains(selectedStock)){
						display.setText("You dont have that stock or enough shares to sell.");
					}
					else{
						transaction.buyAStock();
						display.setText(shareNumber+ " shares of " + transaction.transactionHistory.get(stockIndex) + " were bought for $" 
								+ String.format( "%.2f",Transaction.transactionPrices.get(stockIndex)));
						StockMainMenu.fluctuation.updateStock(transaction);
						
						fluctuation.getEventHistory().add("Current state of " + transaction.getStocks().get(StockMainMenu.fluctuation.getEventStock()).getStockName()
								+ ": "
								+ StockMainMenu.fluctuation.outputEvent() 
								+ "(" + String.format( "%.2f",transaction.getStocks().get(StockMainMenu.fluctuation.getEventStock()).getGrowthRate())
								+ " )" + String.format( "%.2f",transaction.getStocks().get(StockMainMenu.fluctuation.getEventStock()).getStockPrice()));
						
						eventDisplay.setText(fluctuation.getEventHistory().get(fluctuation.getEventHistory().size()-1));
						
						if(fluctuation.getEventHistory().size() >= 1){
							historyDisplay.setText(fluctuation.getEventHistory().get(fluctuation.getEventHistory().size()-1) );
						}
						if(fluctuation.getEventHistory().size() >= 2){
							historyDisplay2.setText(fluctuation.getEventHistory().get(fluctuation.getEventHistory().size()-2) );
						}
						if(fluctuation.getEventHistory().size() >= 3){
							historyDisplay3.setText(fluctuation.getEventHistory().get(fluctuation.getEventHistory().size()-3) );
						}
						
					}
				}
			});
			
			viewObjects.add(sell);
			//viewObjects.add(transactionDisplay);
			
		end = new Button(500, 300, 100, 40, "End Turn", Color.green, new Action() {
				
				@Override
				public void act() {
					System.out.println("Turn ended.");
					display.setText("Turn ended.");
					turncount++;
					turn.setText("Turn " + turncount); 
					
				}
		});
		viewObjects.add(eventDisplay);
		viewObjects.add(historyDisplay);
		viewObjects.add(historyDisplay2);
		viewObjects.add(historyDisplay3);
		viewObjects.add(display);
		viewObjects.add(end);
		
		homeButton = new Button(getWidth()/2-30, 560 , 60, 30, "Home", new Color(0,0,0), new Action(){
			@Override
			public void act(){
				src.MainMenu.mms.setScreen(src.MainMenu.menuScreen);
			}
		});
		viewObjects.add(homeButton);

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
}