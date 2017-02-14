package stockMarket;

import java.awt.Color;
import java.awt.Graphics;
import java.util.List;

import guiPractice8.GUIApplication;
import guiPractice8.component.Action;
import guiPractice8.component.Button;
import guiPractice8.component.ClickableScreen;
import guiPractice8.component.Graphic;
import guiPractice8.component.Visible;
import projectComponents.ThemedTextLabel;

import stockMarket.StockMenu;


public class GabrielDemo extends GUIApplication {
	
		public static GabrielDemo game;
		
		public GabrielDemo() {
			
		}
		
		
		@Override
		protected void initScreen() {
			// for screens of phone and games
			DemoScreen demo = new DemoScreen(getWidth(), getHeight());
			setScreen(demo);
		}

		/**
		
		 */
		public static void main(String[] args) {
			GabrielDemo demo = new GabrielDemo();
			Thread app = new Thread(demo);
			app.start();

		}
		
//nested inner class
private class DemoScreen extends ClickableScreen{

	/**
	 * Checklist:
	 * - Display events
	 * - Buy/Sell buttons to work
	 * - User Portfolio button to go to new Screen
	 * - End Turn button to increased turn count by 1
	 * - Array of plus/minus buttons?? 
	 * - Fix bugs
	 */

	private ThemedTextLabel result;
	private ThemedTextLabel samsung;
	private ThemedTextLabel blackgate;
	private ThemedTextLabel apple;
	private ThemedTextLabel glascow;
	private ThemedTextLabel generalmotors;
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
	private Graphic stockRect;
	
	public DemoScreen(int width, int height) {
		super(width, height);
				
	}
	
	//public void createRectangle (Graphics g) {    
	//	g.drawRect(30, 70, 170, 170);    //can use either of the two//
	 //   g.fillRect(30, 70, 170, 170);
	 //   g.setColor(Color.green);
	//}
	
	@Override
	public void initAllObjects(List<Visible> view) {
		
		//String[] stocks = { "Samsung","Blackgate", "Apple","Glascow","General Motors"};
		result = new ThemedTextLabel(220, 50, 800, 25, "Choose an action.");
		turncount = 0;
		goalcount = 50000;
		
		background=new Graphic(0,0,getWidth(),getHeight(),"resources/images/moneybackground.jpg");
		view.add(background);
		
		logo = new Graphic(40, 50, 90, 90, "resources/images/logo.png"); 
		view.add(logo);
		
		turn = new ThemedTextLabel(510, 0, 90,90,"Turn " + turncount);
		view.add(turn);
		
		goal = new ThemedTextLabel(470, 25, 200,90,"Goal:$" + goalcount);
		view.add(goal);
		
		stockRect = new Graphic(30, 145, 170, 110, "resources/images/greenrect.png");
		view.add(stockRect);
				
		samsung = new ThemedTextLabel(40, 80, 90, 90, "Samsung");
		view.add(samsung);
		
		blackgate = new ThemedTextLabel(40, 100, 90, 90, "Blackgate");
		view.add(blackgate);
		
		apple = new ThemedTextLabel(40, 120, 90, 90, "Apple");
		view.add(apple);
		
		glascow = new ThemedTextLabel(40, 140, 90, 90, "Glascow");
		view.add(glascow);
		
		generalmotors = new ThemedTextLabel(40, 160, 150, 90, "General Motors");
		view.add(generalmotors);
		
		
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
				result.setText("Moving to your portfolio.");
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
					result.setText("Ending your turn");
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

