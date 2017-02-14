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
import projectComponents.ThemedTextLabel;

import stockMarket.StockMenu;


public class GabrielDemo extends GUIApplication {
	
		public static GabrielDemo mainDemoScreen;
		public static GabrielDemoInventoryScreen inventoryDemo;
		public static Screen demo;
		
		public GabrielDemo() {
			
		}
		
		
		@Override
		protected void initScreen() {
			// for screens of phone and games
			demo = new DemoScreen(getWidth(), getHeight());
			inventoryDemo = new GabrielDemoInventoryScreen(getWidth(), getHeight());
			setScreen(demo);
		}

		/**
		
		 */
		public static void main(String[] args) {
			mainDemoScreen = new GabrielDemo();
			Thread app = new Thread(mainDemoScreen);
			app.start();

		}
		
//nested inner class
private class DemoScreen extends ClickableScreen{

	/**
	 * Checklist:
	 * - Link share# to
	 * - Display events
	 * - Buy/Sell buttons to work
	 * - Create interface
	 */

	private ThemedTextLabel result;
	private ThemedTextLabel Samsung;
	private ThemedTextLabel Blackgate;
	private ThemedTextLabel Apple;
	private ThemedTextLabel Glascow;
	private ThemedTextLabel Generalmotors;
	private int share1;
	private int share2;
	private int share3;
	private int share4;
	private int share5;
	private Button plus1;
	private Button plus2;
	private Button plus3;
	private Button plus4;
	private Button plus5;
	private Button minus1;
	private Button minus2;
	private Button minus3;
	private Button minus4;
	private Button minus5;
	private Graphic logo;
	private ThemedTextLabel goal;
	private ThemedTextLabel turn;
	private ThemedTextLabel event;
	private Graphic background;
	private Button buy;
	private Button sell;
	private Button user;
	private Button end;
	private int turncount;
	private int goalcount;
	//private Graphic stockRect;
	
	public DemoScreen(int width, int height) {
		super(width, height);
				
	}
	
	@Override
	public void initAllObjects(List<Visible> view) {
		
		//String[] stocks = { "Samsung","Blackgate", "Apple","Glascow","General Motors"};
		result = new ThemedTextLabel(220, 50, 800, 25, "Choose an action.");
		share1 = 0;
		share2 = 0;
		share3 = 0;
		share4 = 0;
		share5 = 0;
		turncount = 0;
		goalcount = 50000;
		
		background=new Graphic(0,0,getWidth(),getHeight(),"resources/images/newmoneybackground.png");
		view.add(background);
		
		logo = new Graphic(40, 50, 90, 90, "resources/images/logo.png"); 
		view.add(logo);
		
		turn = new ThemedTextLabel(510, 0, 90,90,"Turn " + turncount);
		view.add(turn);
		
		goal = new ThemedTextLabel(470, 25, 200,90,"Goal:$" + goalcount);
		view.add(goal);
		
		//stockRect = new Graphic(30, 145, 170, 110, "resources/images/greenrect.png");
		//view.add(stockRect);
				
		//Samsung = new ThemedTextLabel(40, 80, 90, 90, "Samsung");
		//view.add(Samsung);
		Samsung = new ThemedTextLabel(160,80,150,90,"Samsung " + share1);
		view.add(Samsung);
		plus1 = new Button(185,148,25,20,"+",Color.green, new Action() {
			@Override
			public void act() {
				share1++;
				Samsung.setText("Samsung "+ share1 );
			}
		});
		view.add(plus1);
		minus1 = new Button(135,148,25,20,"-",Color.green, new Action() {
			@Override
			public void act() {
				share1--;
				Samsung.setText("Samsung "+ share1);
			}
		});
		view.add(minus1);
		
		Blackgate = new ThemedTextLabel(40, 100, 90, 90, "Blackgate");
		view.add(Blackgate);
		
		Apple = new ThemedTextLabel(40, 120, 90, 90, "Apple");
		view.add(Apple);
		
		Glascow = new ThemedTextLabel(40, 140, 90, 90, "Glascow");
		view.add(Glascow);
		
		Generalmotors = new ThemedTextLabel(40, 160, 150, 90, "General Motors");
		view.add(Generalmotors);
		
		
		buy = new Button(175, 260, 90, 40, "Buy", Color.green, new Action() {
			
			@Override
			public void act() {
				result.setText("You bought a stock");
				System.out.println("You bought a stock");
			
				//result.setText("You bought a stock");
				
				//rewardDisplay.setText("You earned a reward total points equals
				// +"SamDemo.reward.getPoints());
				
			}
		});
		view.add(buy);
		view.add(result);
		//view.add(result);
		
		user = new Button(200, 305, 200, 40, "User Portfolio", Color.green, new Action() {
			
			@Override
			public void act() {
				System.out.println("Transporting to your portfolio");
				GabrielDemo.mainDemoScreen.setScreen(inventoryDemo);
				//SamDemo.reward.getReward(18);
				//rewardDisplay.setText("You earned a reward total points equals
				// +"SamDemo.reward.getPoints());
				
			}
		});
		
		view.add(user);
		view.add(result);
			
			
		sell = new Button(350, 260, 90, 40, "Sell", Color.green, new Action() {
				
				@Override
				public void act() {
					System.out.println("You sold a stock");
					result.setText("You sold a stock.");
					//rewardDisplay.setText("You earned a reward total points equals
					// +"SamDemo.reward.getPoints());
					
				}
		});
		
		view.add(sell);
		view.add(result);
			
		end = new Button(250, 350, 100, 40, "End Turn", Color.green, new Action() {
				
				@Override
				public void act() {
					System.out.println("Turn ended.");
					result.setText("Turn ended.");
					turncount++;
					turn.setText("Turn " + turncount); 
					//SamDemo.reward.getReward(18);
					//rewardDisplay.setText("You earned a reward total points equals
					// +"SamDemo.reward.getPoints());
					
				}
		});
		
		view.add(result);
		view.add(end);
			
	}


			
	}
}

