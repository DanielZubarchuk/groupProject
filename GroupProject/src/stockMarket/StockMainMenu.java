package stockMarket;

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
import projectComponents.MultiLineTextLabel;
import projectComponents.ThemedTextLabel;

public class StockMainMenu extends GUIApplication {
	
		public static StockMainMenu mainDemoScreen;
		public static DemoInventoryScreen inventoryDemo;
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
			mainDemoScreen = new StockMainMenu();
			Thread app = new Thread(mainDemoScreen);
			app.start();

		}
		
//nested inner class
private class MenuScreen extends ClickableScreen{

	private ThemedTextLabel display;
	private String Samsung;
	private String Blackgate;
	private String Apple;
	private String Glascow;
	private String Generalmotors;
	
	//public String selectedStock;
	
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
	private MultiLineTextLabel historyDisplay;
	private MultiLineTextLabel historyDisplay2;
	private MultiLineTextLabel historyDisplay3;
	private Button eventHistory;
	private MultiLineTextLabel eventDisplay;
	public int stockIndex;
	
	
	public MenuScreen(int width, int height) {
		super(width, height);
				
	}
	
	public void createStocks(){
		
	}
	
	public void selectStock(String stock){
		selectedStock = stock;
		display.setText("You selected "+selectedStock+" as your stock");
	}
	@Override
	public void initAllObjects(ArrayList<Visible> view) {
	
		Samsung = "Samsung";
		Blackgate = "Blackgate";
		Apple = "Apple";
		Glascow = "Glascow";
		Generalmotors = "General Motors";
		display = new ThemedTextLabel(300, 70, 800, 25, "Choose an action.");
		turncount = 0;
		goalcount = 50000;
		historyDisplay = new MultiLineTextLabel(40, 430, 800, 50,"");
		historyDisplay2 = new MultiLineTextLabel(40, 470, 800, 50,"");
		historyDisplay3 = new MultiLineTextLabel(40, 510, 800, 50,"");
		eventDisplay = new MultiLineTextLabel(40, 380, 800, 25, "");
		
		
		background=new Graphic(0,0,getWidth(),getHeight(),"resources/images/newmoneybackground.png");
		view.add(background);
		
		logo = new Graphic(40, 50, 90, 90, "resources/images/logo.png"); 
		view.add(logo);
		
		turn = new ThemedTextLabel(700, 10, 90,90,"Turn " + turncount);
		view.add(turn);
		
		goal = new ThemedTextLabel(680, 35, 200,90,"Goal:$" + goalcount);
		view.add(goal);
		
		shareText = new ThemedTextLabel(200,155,70,90,"Shares:");
		view.add(shareText);
				
		select1 = new Button(20,140,90,30,Samsung, Color.green,new Action(){
			@Override
			public void act() {
				selectStock(Samsung);	
			}
		});
		view.add(select1);
		
		select2 = new Button(20,180,90,30,Blackgate, Color.green,new Action() {
			@Override
			public void act() {
				selectStock(Blackgate);	
			}
		});
		view.add(select2);
		
		select3 = new Button(20,215,90,30,Apple, Color.green,new Action() {
			@Override
			public void act() {
				selectStock(Apple);	
			}
		});
		view.add(select3);
		
		select4 = new Button(20,250,90,30,Glascow, Color.green,new Action() {
			@Override
			public void act() {
				selectStock(Glascow);	
			}
		});
		view.add(select4);
		
		select5 = new Button(20,290,145,30,Generalmotors, Color.green,new Action() {
			@Override
			public void act() {
				selectStock(Generalmotors);	
			}
		});
		view.add(select5);
		
		shareLabel = new ThemedTextLabel(225,180,70,90,Integer.toString(shareNumber));
		view.add(shareLabel);
		
		plus = new Button(260,245,25,20,"+",Color.green, new Action() {
			@Override
			public void act() {
				shareNumber++;
				shareLabel.setText(Integer.toString(shareNumber) );
			}
		});
		view.add(plus);
		
		minus = new Button(200,245,25,20,"-",Color.green, new Action() {
			@Override
			public void act() {
				if(shareNumber > 0){
					shareNumber--;
				}
				
				shareLabel.setText(Integer.toString(shareNumber));
			}
		});
		view.add(minus);
		
		eventHistory = new Button(500,150, 250, 40, "Event History", Color.green, new Action() {
			
			@Override
			public void act() {
	
				StockMainMenu.fluctuation.updateStock(transaction);
				
				fluctuation.getEventHistory().add("Current state of " + transaction.getStocks().get(StockMainMenu.fluctuation.getEventStock()).getStockName()
						+ ": "
						+ StockMainMenu.fluctuation.outputEvent() 
						+ "(" + transaction.getStocks().get(StockMainMenu.fluctuation.getEventStock()).getGrowthRate()
						+ " )" + transaction.getStocks().get(StockMainMenu.fluctuation.getEventStock()).getStockPrice());
				
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
//				historyDisplay.setText("Hello\nWorld");
				
			}
		});
		
		buy = new Button(500, 200, 90, 40, "Buy", Color.green, new Action() {
			
				public void act() {
					transaction.buyAStock();
					display.setText(transaction.transactionHistory.get(stockIndex) + " was sold for $" 
							+ Transaction.transactionPrices.get(stockIndex));
			}
		});
		view.add(buy);
		view.add(display);

		user = new Button(500, 250, 200, 40, "User Portfolio", Color.green, new Action() {
			
			@Override
			public void act() {
				System.out.println("Transporting to your portfolio");
				StockMainMenu.mainDemoScreen.setScreen(inventoryScreen);
			}
		});
		view.add(user);
		view.add(display);
			
		sell = new Button(600, 200, 90, 40, "Sell", Color.green, new Action() {
				
				@Override
				public void act() {
					//transactionDisplay.setText(transaction.transactionHistory.get(stockIndex) + " was sold for " 
					//+ Transaction.transactionPrices.get(stockIndex));
					//transaction.sellAStock();
//					index++;
				}
			});
			
			view.add(sell);
			//view.add(transactionDisplay);
			
		end = new Button(500, 300, 100, 40, "End Turn", Color.green, new Action() {
				
				@Override
				public void act() {
					System.out.println("Turn ended.");
					display.setText("Turn ended.");
					turncount++;
					turn.setText("Turn " + turncount); 
					
				}
		});
		view.add(eventDisplay);
		view.add(historyDisplay);
		view.add(historyDisplay2);
		view.add(historyDisplay3);
		view.add(eventHistory);
		view.add(display);
		view.add(end);
			
	}
	
	}
}
