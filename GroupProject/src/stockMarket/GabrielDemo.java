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
	 * - Select Stock button 
	 * - Link share# to
	 * - Display events
	 * - Buy/Sell buttons to work
	 * - Create interface
	 */

	private ThemedTextLabel result;
	private String SamsungTest;
	private ThemedTextLabel Samsung;
	private ThemedTextLabel Blackgate;
	private ThemedTextLabel Apple;
	private ThemedTextLabel Glascow;
	private ThemedTextLabel Generalmotors;
	private int share1; //int that refers to shares of Samsung
	private int share2; //int that refers to shares of Blackgate
	private int share3; //int that refers to shares of Apple
	private int share4;//int that refers to shares of Glascow
	private int share5;//int that refers to shares of General Motors
	private Button plus1; //plus and minus buttons are for increasing/decreasing the shares of their respective #
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
		Samsung = new ThemedTextLabel(40,80,150,90,"Samsung " + share1);
		view.add(Samsung);
		plus1 = new Button(185,145,25,20,"+",Color.green, new Action() {
			@Override
			public void act() {
				share1++;
				Samsung.setText("Samsung "+ share1 );
			}
		});
		view.add(plus1);
		minus1 = new Button(150,145,25,20,"-",Color.green, new Action() {
			@Override
			public void act() {
				if(share1 > 0){
					share1--;
				}
				
				Samsung.setText("Samsung "+ share1);
			}
		});
		view.add(minus1);
		
		Blackgate = new ThemedTextLabel(40, 100, 120, 90, "Blackgate " + share2);
		view.add(Blackgate);
		plus2 = new Button(185,165,25,20,"+",Color.green, new Action() {
			@Override
			public void act() {
				share2++;
				Blackgate.setText("Blackgate "+ share2 );
			}
		});
		view.add(plus2);
		minus2 = new Button(150,165,25,20,"-",Color.green, new Action() {
			@Override
			public void act() {
				if(share2 > 0){
					share2--;
				}
				
				Blackgate.setText("Blackgate "+ share2);
			}
		});
		view.add(minus2);
		
		Apple = new ThemedTextLabel(40, 120, 90, 90, "Apple "+ share3);
		view.add(Apple);
		plus3 = new Button(185,187,25,20,"+",Color.green, new Action() {
			@Override
			public void act() {
				share3++;
				Apple.setText("Apple "+ share3 );
			}
		});
		view.add(plus3);
		minus3 = new Button(150,187,25,20,"-",Color.green, new Action() {
			@Override
			public void act() {
				if(share3 > 0){
					share3--;
				}
				
				Apple.setText("Apple "+ share3);
			}
		});
		view.add(minus3);
		
		Glascow = new ThemedTextLabel(40, 140, 120, 90, "Glascow "+share4);
		view.add(Glascow);
		plus4 = new Button(185,205,25,20,"+",Color.green, new Action() {
			@Override
			public void act() {
				share4++;
				Glascow.setText("Glascow "+ share4 );
			}
		});
		view.add(plus4);
		minus4 = new Button(150,205,25,20,"-",Color.green, new Action() {
			@Override
			public void act() {
				if(share4 > 0){
					share4--;
				}
				
				Glascow.setText("Glascow "+ share4);
			}
		});
		view.add(minus4);
		
		Generalmotors = new ThemedTextLabel(40, 160, 170, 90, "General Motors "+share5);
		view.add(Generalmotors);
		plus5 = new Button(240,225,25,20,"+",Color.green, new Action() {
			@Override
			public void act() {
				share5++;
				Generalmotors.setText("General Motors "+ share5 );
			}
		});
		view.add(plus5);
		minus5 = new Button(215,225,25,20,"-",Color.green, new Action() {
			@Override
			public void act() {
				if(share5 > 0){
					share5--;
				}
				
				Generalmotors.setText("General Motors "+ share5);
			}
		});
		view.add(minus5);
		
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

