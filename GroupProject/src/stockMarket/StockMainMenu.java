package stockMarket;

import java.awt.Color;
import java.awt.Graphics;
import java.util.List;

import guiPractice8.GUIApplication;
import guiPractice8.Screen;
import guiPractice8.component.Action;
import guiPractice8.component.Button;
import guiPractice8.component.ClickableScreen;
import guiPractice8.component.Graphic;
import guiPractice8.component.Visible;
import projectComponents.MultiLineTextLabel;
import projectComponents.ThemedTextLabel;

public class StockMainMenu extends GUIApplication {
	
		public static StockMainMenu mainDemoScreen;
		public static DemoInventoryScreen inventoryDemo;
		public static User inventoryScreen;
		public static Screen demo;
		private static Transaction transaction;
		private static Fluctuation fluctuation;
		
		public StockMainMenu() {
			transaction = new Transaction();
			fluctuation = new Fluctuation();
		}
		
		
		@Override
		protected void initScreen() {
			// for screens of phone and games
			demo = new DemoScreen(getWidth(), getHeight());
			inventoryDemo = new DemoInventoryScreen(getWidth(), getHeight());
			setScreen(demo);
		}

		/**
		
		 */
		public static void main(String[] args) {
			mainDemoScreen = new StockMainMenu();
			Thread app = new Thread(mainDemoScreen);
			app.start();

		}
		
//nested inner class
private class DemoScreen extends ClickableScreen{

	/**
	 * Checklist:
	 * - Select Stock button
	 * - Display events
	 * - Link to other code
	 * - Make the buy and sell buttons display which stock affected and how many shares of it
	 */

	private ThemedTextLabel result;
	private String Samsung;
	private String Blackgate;
	private String Apple;
	private String Glascow;
	private String Generalmotors;
	private String selectedStock;
	private int shareNumber;
	private ThemedTextLabel shareLabel;
	private Button plus;
	private Button minus;
	private Button select1;//buttons for selecting which stock the user wants to buy or sell
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
	
	private ThemedTextLabel transactionDisplay;
	private boolean dialogueBuy;
	private int stockIndex = 0;
	
	/*
	 * To Do List:
	 * - Create method for plus and minus buttons (SimonScreen + Veeraj Screen)
	 * - Change build path to GUI5
	 * - Change imports
	 */
	
	public DemoScreen(int width, int height) {
		super(width, height);
				
	}
	public void selectStock(String stock){
		selectedStock = stock;
		result.setText("You selected "+selectedStock+" as your stock");
	}
	
	@Override
	public void initAllObjects(List<Visible> view) {
		
		//String[] stocks = { "Samsung","Blackgate", "Apple","Glascow","General Motors"};
		Samsung = "Samsung";
		Blackgate = "Blackgate";
		Apple = "Apple";
		Glascow = "Glascow";
		Generalmotors = "General Motors";
		result = new ThemedTextLabel(150, 50, 800, 25, "Choose an action.");
		turncount = 0;
		goalcount = 50000;
		historyDisplay = new MultiLineTextLabel(40, 250, 800, 50,"");
		historyDisplay2 = new MultiLineTextLabel(40, 270, 800, 50,"");
		historyDisplay3 = new MultiLineTextLabel(40, 290, 800, 50,"");
		eventDisplay = new MultiLineTextLabel(40, 170, 800, 25, "");
		
		
		background=new Graphic(0,0,getWidth(),getHeight(),"resources/images/newmoneybackground.png");
		view.add(background);
		
		logo = new Graphic(40, 50, 90, 90, "resources/images/logo.png"); 
		view.add(logo);
		
		turn = new ThemedTextLabel(510, 10, 90,90,"Turn " + turncount);
		view.add(turn);
		
		goal = new ThemedTextLabel(470, 35, 200,90,"Goal:$" + goalcount);
		view.add(goal);
		
		eventHistory = new Button(290,220 , 250, 40, "Event History", Color.green, new Action() {
			
			@Override
			public void act() {
				//each line should be another element in eventHistory
				/**
				* for(String s: Fluctuation.getEventHistory){
				* 	// either use scrollpanes or
				*	// use y+getFontMetrics() to show multiple lines of events
				*	// make a new text label component for multi lined strings 
				*	// but change the g.drawString method
				* }
				**/
				StockMainMenu.fluctuation.updateStock();
				
				fluctuation.getEventHistory().add("Current state of " + transaction.getStocks().get(StockMainMenu.fluctuation.getEventStock()).getStockName()
						+ ": "
						+ StockMainMenu.fluctuation.outputEvent() 
						+ "(" + transaction.getStocks().get(StockMainMenu.fluctuation.getEventStock()).getStockPrice()
						+ " )" + transaction.getStocks().get(StockMainMenu.fluctuation.getEventStock()).getStockName());
				
				eventDisplay.setText("Current state of " + transaction.getStocks().get(StockMainMenu.fluctuation.getEventStock()).getStockName() 
						+ ": "
						+ StockMainMenu.fluctuation.outputEvent() 
						+ "(" + transaction.getStocks().get(StockMainMenu.fluctuation.getEventStock()).getGrowthRate() 
						+ " )" + transaction.getStocks().get(StockMainMenu.fluctuation.getEventStock()).getStockPrice());
				
				if(fluctuation.getEventHistory().size() >= 1){
					historyDisplay.setText(fluctuation.getEventHistory().get(fluctuation.getEventHistory().size()-1) );
				}
				if(fluctuation.getEventHistory().size() >= 2){
					historyDisplay2.setText(fluctuation.getEventHistory().get(fluctuation.getEventHistory().size()-2) );
				}
				if(fluctuation.getEventHistory().size() >= 3){
					historyDisplay3.setText(fluctuation.getEventHistory().get(fluctuation.getEventHistory().size()-3) );
				}
				
				StockMainMenu.fluctuation.updateStock();
//				historyDisplay.setText("Hello\nWorld");
				
			}
		});
		
		//SamsungLabel = new ThemedTextLabel(120,80,70,90,Integer.toString(share1));
		//view.add(SamsungLabel);
		select1 = new Button(20,140,90,30,"Samsung", Color.green,new Action(){
			@Override
			public void act() {
				selectStock(Samsung);	
			}
		});
		view.add(select1);
		
		//BlackgateLabel = new ThemedTextLabel(120, 120, 120, 90, Integer.toString(share2));
		//view.add(BlackgateLabel);
		select2 = new Button(20,180,90,30,"Blackgate", Color.green,new Action() {
			@Override
			public void act() {
				selectStock(Blackgate);	
			}
		});
		view.add(select2);
		
		//AppleLabel = new ThemedTextLabel(120, 155, 90, 90, Integer.toString(share3));
		//view.add(AppleLabel);
		select3 = new Button(20,215,90,30,"Apple", Color.green,new Action() {
			@Override
			public void act() {
				selectStock(Apple);	
			}
		});
		view.add(select3);
		
		//GlascowLabel = new ThemedTextLabel(120, 185, 120, 90, Integer.toString(share4));
		//view.add(GlascowLabel);
		select4 = new Button(20,250,90,30,"Glascow", Color.green,new Action() {
			@Override
			public void act() {
				selectStock(Glascow);	
			}
		});
		view.add(select4);
		
		//GeneralmotorsLabel = new ThemedTextLabel(180, 230, 170, 90, Integer.toString(share5));
		//view.add(GeneralmotorsLabel);
		select5 = new Button(20,290,145,30,"General Motors", Color.green,new Action() {
			@Override
			public void act() {
				selectStock(Generalmotors);	
			}
		});
		view.add(select5);
		
		shareLabel = new ThemedTextLabel(175,80,70,90,Integer.toString(shareNumber));
		view.add(shareLabel);
		
		plus = new Button(200,145,25,20,"+",Color.green, new Action() {
			@Override
			public void act() {
				shareNumber++;
				shareLabel.setText(Integer.toString(shareNumber) );
			}
		});
		view.add(plus);
		
		minus = new Button(150,145,25,20,"-",Color.green, new Action() {
			@Override
			public void act() {
				if(shareNumber > 0){
					shareNumber--;
				}
				
				shareLabel.setText(Integer.toString(shareNumber));
			}
		});
		view.add(minus);
		
		buy = new Button(350, 260, 90, 40, "Buy", Color.green, new Action() {
				public void act() {
					dialogueBuy = true;
					transaction.buyAStock();
					transactionDisplay.setText(transaction.transactionHistory.get(stockIndex) + " was bought for " 
					+ Transaction.transactionPrices.get(stockIndex));
//					index++;
					view.add(transactionDisplay);
			}
		});
		view.add(buy);
		view.add(result);

		user = new Button(350, 305, 200, 40, "User Portfolio", Color.green, new Action() {
			
			@Override
			public void act() {
				System.out.println("Transporting to your portfolio");
				StockMainMenu.mainDemoScreen.setScreen(inventoryDemo);
			}
		});
		view.add(user);
		view.add(result);
			
		sell = new Button(450, 260, 90, 40, "Sell", Color.green, new Action() {
				
				@Override
				public void act() {
					dialogueBuy = false;
					transactionDisplay.setText(transaction.transactionHistory.get(stockIndex) + " was sold for " 
					+ Transaction.transactionPrices.get(stockIndex));
					transaction.sellAStock();
//					index++;
				}
			});
			
			view.add(sell);
			view.add(transactionDisplay);
			
		end = new Button(350, 350, 100, 40, "End Turn", Color.green, new Action() {
				
				@Override
				public void act() {
					System.out.println("Turn ended.");
					result.setText("Turn ended.");
					turncount++;
					turn.setText("Turn " + turncount); 
					
				}
		});
		view.add(eventDisplay);
		view.add(historyDisplay);
		view.add(historyDisplay2);
		view.add(historyDisplay3);
		view.add(eventHistory);
		view.add(result);
		view.add(end);
			
	}
	
	}
}
