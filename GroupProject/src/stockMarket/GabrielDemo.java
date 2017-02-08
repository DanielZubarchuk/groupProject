package stockMarket;

import java.awt.Color;
import java.util.List;

import guiPractice8.GUIApplication;
import guiPractice8.component.Action;
import guiPractice8.component.Button;
import guiPractice8.component.ClickableScreen;
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

	private ThemedTextLabel rewardDisplay;
	private Button buy;
	private Button sell;
	private Button user;
	private Button end;
	
	public DemoScreen(int width, int height) {
		super(width, height);
				
	}

			@Override
	public void initAllObjects(List<Visible> view) {
		rewardDisplay = new ThemedTextLabel(20, 40, 100, 25, "");
		buy = new Button(40, 100, 90, 40, "Buy", Color.blue, new Action() {
			
			@Override
			public void act() {
				//SamDemo.reward.getReward(18);
				//rewardDisplay.setText("You earned a reward total points equals
				// +"SamDemo.reward.getPoints());
				
			}
		});
		
		view.add(rewardDisplay);
		view.add(buy);
		
		sell = new Button(40, 300, 90, 40, "Sell", Color.blue, new Action() {
			
			@Override
			public void act() {
				//SamDemo.reward.getReward(18);
				//rewardDisplay.setText("You earned a reward total points equals
				// +"SamDemo.reward.getPoints());
				
			}
		});
		
		view.add(rewardDisplay);
		view.add(sell);
			
			
		user = new Button(300, 100, 200, 40, "User Inventory", Color.blue, new Action() {
				
				@Override
				public void act() {
					//SamDemo.reward.getReward(18);
					//rewardDisplay.setText("You earned a reward total points equals
					// +"SamDemo.reward.getPoints());
					
				}
			});
			
			view.add(rewardDisplay);
			view.add(user);
			
		end = new Button(300, 300, 100, 40, "End Turn", Color.blue, new Action() {
				
				@Override
				public void act() {
					//SamDemo.reward.getReward(18);
					//rewardDisplay.setText("You earned a reward total points equals
					// +"SamDemo.reward.getPoints());
					
				}
			});
			
			view.add(rewardDisplay);
			view.add(end);
}
}
}

