package stockMarket;

import java.awt.Color;
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
	//put fields here from StockMenu to add things for project.
	
	public static StockMenu logo;
	
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
		 * @param args
		 */
		public static void main(String[] args) {
			GabrielDemo demo = new GabrielDemo();
			Thread app = new Thread(demo);
			app.start();

		}
		
//nested inner class
private class DemoScreen extends ClickableScreen{

	private ThemedTextLabel result;
	private Graphic logo;
	private ThemedTextLabel goal;
	private ThemedTextLabel turn;
	private ThemedTextLabel event;
	private Graphic background;
	private Button buy;
	private Button sell;
	private Button user;
	private Button end;
	
	public DemoScreen(int width, int height) {
		super(width, height);
				
	}

			@Override
	public void initAllObjects(List<Visible> view) {
		
		String[] stocks = { "Samsung","Blackgate", "Apple","Glascow","General Motors"};
		
		result = new ThemedTextLabel(220, 150, 800, 25, "Choose an action.");
		

		background=new Graphic(0,0,getWidth(),getHeight(),"resources/images/moneybackground.jpg");
		view.add(background);
		
		logo = new Graphic(40, 50, 90, 90, "resources/images/logo.png"); 
		view.add(logo);
		
		buy = new Button(175, 220, 90, 40, "Buy", Color.green, new Action() {
			
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
		
		user = new Button(200, 270, 200, 40, "User Portfolio", Color.green, new Action() {
			
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
			
			
		sell = new Button(350, 220, 90, 40, "Sell", Color.green, new Action() {
				
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
			
		end = new Button(250, 320, 100, 40, "End Turn", Color.green, new Action() {
				
				@Override
				public void act() {
					System.out.println("Turn ended.");
					result.setText("Ending your turn");
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

