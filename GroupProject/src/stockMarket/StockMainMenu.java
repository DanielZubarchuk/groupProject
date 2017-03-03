package src.stockMarket;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

import guiPractice.GUIApplication;
import guiPractice.Screen;
import guiPractice.components.Action;
import guiPractice.components.Button;
import guiPractice.ClickableScreen;
import guiPractice.components.Graphic;
import guiPractice.components.Visible;
import src.phone.App;
import src.phone.MainMenu;
import src.projectComponents.MultiLineTextLabel;
import src.projectComponents.ThemedTextLabel;
import src.stackInterfaces.StockInterface;

public class StockMainMenu extends GUIApplication {
	
		public static StockMainMenu mainScreen;
		public static WinScreen winScreen;
		public static LoseScreen loseScreen;
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
			winScreen = new WinScreen(1000,600);
			loseScreen = new LoseScreen(1000,600);
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
	private Button stock1;
	private Button stock2;
	private Button stock3;
	private Button stock4;
	private Button stock5;
	private ThemedTextLabel shareText;
	private int shareNumber;
	private ThemedTextLabel shareLabel;
	private Button plus;
	private Button minus;
	private Graphic logo;
	private ThemedTextLabel goal;
	private ThemedTextLabel turn;
	private Graphic background;
	private Button buy;
	private Button sell;
	private Button user;
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
	
	@Override
	public void initAllObjects(ArrayList<Visible> viewObjects) {
		
		buttons = new ArrayList<Button>();
		Samsung = "Samsung";
		Blackgate = "Blackgate";
		Apple = "Apple";
		Glascow = "Glascow";
		Generalmotors = "General Motors";
		display = new ThemedTextLabel(200, 70, 800, 25, "Choose an action.");
		turncount = 0;
		goalcount = 50000;
		historyDisplay = new ThemedTextLabel(40, 430,800, 50,"");
		historyDisplay2 = new ThemedTextLabel(40, 470, 800, 50,"");
		historyDisplay3 = new ThemedTextLabel(40, 510, 800, 50,"");
		eventDisplay = new ThemedTextLabel(40, 380, 800, 25, "");
		
		
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
		
		shareLabel = new ThemedTextLabel(225,180,70,90,Integer.toString(shareNumber));
		viewObjects.add(shareLabel);
		
		plus = new Button(260,245,25,20,"+",Color.black, new Action() {
			@Override
			public void act() {
				shareNumber++;
				shareLabel.setText(Integer.toString(shareNumber) );
			}
		});
		viewObjects.add(plus);
		
		minus = new Button(200,245,25,20,"-",Color.black, new Action() {
			@Override
			public void act() {
				if(shareNumber > 0){
					shareNumber--;
				}
				
				shareLabel.setText(Integer.toString(shareNumber));
			}
		});
		viewObjects.add(minus);
			eventHistory = new Button(500,150, 250, 40, "Event History", Color.black, new Action() {
			
			@Override
			public void act() {
	
				StockMainMenu.fluctuation.updateStock(transaction);
				
				fluctuation.getEventHistory().add("Current state of " + transaction.getStocks().get(StockMainMenu.fluctuation.getEventStock()).getStockName()
						+ ": "
						+ StockMainMenu.fluctuation.outputEvent() 
						+ "(" +  String.format( "%.2f",transaction.getStocks().get(StockMainMenu.fluctuation.getEventStock()).getGrowthRate())
						+ " )" +  String.format( "%.2f",transaction.getStocks().get(StockMainMenu.fluctuation.getEventStock()).getStockPrice()));
				
				eventDisplay.setText(fluctuation.getEventHistory().get(fluctuation.getEventHistory().size()-1));
				eventDisplay.setBgcolor(Color.green);
				
				if(fluctuation.getEventHistory().size() >= 1){
					historyDisplay.setText(fluctuation.getEventHistory().get(fluctuation.getEventHistory().size()-1) );
					historyDisplay.setBgcolor(Color.green);
				}
				if(fluctuation.getEventHistory().size() >= 2){
					historyDisplay2.setText(fluctuation.getEventHistory().get(fluctuation.getEventHistory().size()-2) );
					historyDisplay2.setBgcolor(Color.green);
				}
				if(fluctuation.getEventHistory().size() >= 3){
					historyDisplay3.setText(fluctuation.getEventHistory().get(fluctuation.getEventHistory().size()-3) );
					historyDisplay3.setBgcolor(Color.green);
				}
				
//				StockMainMenu.fluctuation.updateStock(transaction);
//				historyDisplay.setText("Hello\nWorld");
				
			}
		});
			
		viewObjects.add(eventHistory);
		
		buy = new Button(500, 200, 90, 40, "Buy", Color.black, new Action() {
			
				public void act() {
					if(selectedStock == null || shareNumber ==0){
						display.setText("You must select a stock and shares.");
					}
					if(transaction.userBalance < Transaction.stockPrice){
						display.setText("You don't have enough money");
					}
					else{
						transaction.buyAStock();
						display.setText(shareNumber+ " shares of " + transaction.transactionHistory.get(stockIndex) + " were bought for $" 
								+ String.format( "%.2f",Transaction.transactionPrices.get(stockIndex)));
						turncount++;
						turn.setText("Turn " + turncount); 
						if(turncount ==50 || transaction.userBalance >= 50000){
							StockMainMenu.mainScreen.setScreen(winScreen);
						}
						if(turncount == 50 && transaction.userBalance < 50000){
							StockMainMenu.mainScreen.setScreen(loseScreen);
						}
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

		user = new Button(500, 250, 200, 40, "User Portfolio", Color.black, new Action() {
			
			@Override
			public void act() {
				System.out.println("Transporting to your portfolio");
				StockMainMenu.mainScreen.setScreen(inventoryScreen);
			}
		});
		viewObjects.add(user);
		viewObjects.add(display);
			
		sell = new Button(600, 200, 90, 40, "Sell", Color.black, new Action() {
				
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
						turncount++;
						if(turncount ==50 || transaction.userBalance >= 50000){
							StockMainMenu.mainScreen.setScreen(winScreen);
						}
						if(turncount == 50 && transaction.userBalance < 50000){
							StockMainMenu.mainScreen.setScreen(loseScreen);
						}
						turn.setText("Turn " + turncount); 
						
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
			
			viewObjects.add(eventDisplay);
			viewObjects.add(historyDisplay);
			viewObjects.add(historyDisplay2);
			viewObjects.add(historyDisplay3);
			viewObjects.add(display);
		
		homeButton = new Button(getWidth()/2-30, 560 , 60, 30, "Home", new Color(0,0,0), new Action(){
			@Override
			public void act(){
				src.phone.MainMenu.mms.setScreen(src.phone.MainMenu.menuScreen);
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
	
	public void createStocks(){
		for(int i = 0; i < 5; i++){
			if(i == 0){
				Button temp = new Button(20,140+(50*i),90,30,Samsung,Color.black, new Action() {
					@Override
					public void act() {
						selectStock(Samsung);	
					}
				});
				temp.setSize(20);
				stock1 = temp;
				buttons.add(stock1);
			}
			if(i == 1){
				Button temp = new Button(20,140+(50*i),90,30,Blackgate,Color.black, new Action() {
					@Override
					public void act() {
						selectStock(Blackgate);
					}
				});
				temp.setSize(20);
				stock2 = temp;
				buttons.add(stock2);
			}
			if(i == 2){
				Button temp = new Button(20,140+(50*i),90,30,Apple,Color.black, new Action() {
					@Override
					public void act() {
						selectStock(Apple);	
					}
				});
				temp.setSize(20);
				stock3 = temp;
				buttons.add(stock3);
			}
			if(i == 3){
				Button temp = new Button(20,140+(50*i),90,30,Glascow,Color.black, new Action() {
					@Override
					public void act() {
						selectStock(Glascow);
					}
				});
				temp.setSize(20);
				stock4 = temp;
				buttons.add(stock4);
			}
			if(i == 4){
				Button temp = new Button(20,140+(50*i),90,30,Generalmotors,Color.black, new Action() {
					@Override
					public void act() {
						selectStock(Generalmotors);
					}
				});
				temp.setSize(20);
				stock5 = temp;
				buttons.add(stock5);
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
	}
}