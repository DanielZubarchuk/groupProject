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
		public static UserScreen inventoryScreen;
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
	private String testString;
	private ThemedTextLabel SamsungLabel;
	private ThemedTextLabel BlackgateLabel;
	private ThemedTextLabel AppleLabel;
	private ThemedTextLabel GlascowLabel;
	private ThemedTextLabel GeneralmotorsLabel;
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
	private Button select1;//buttons for selecting which stock the user wants to buy or sell
	private Button select2;
	private Button select3;
	private Button select4;
	private Button select5;
	private Graphic logo;
	private ThemedTextLabel goal;
	private ThemedTextLabel turn;
	//private ThemedTextLabel event;
	private Graphic background;
	private Button buy;
	private Button sell;
	private Button user;
	private Button end;
	private int turncount;
	private int goalcount;
	
	public DemoScreen(int width, int height) {
		super(width, height);
				
	}
	public void selectStock(String stock){
		testString = stock;
		result.setText("You selected "+stock+" as your stock");
	}
	
	public void addShare(ThemedTextLabel stocklabel, int share){
		share++;
		stocklabel.setText(Integer.toString(share) );
	}
	
	public void subtractShare(ThemedTextLabel stocklabel, int share){
		if(share > 0){
			share--;
		}
		
		stocklabel.setText(Integer.toString(share));
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
		
		turn = new ThemedTextLabel(510, 10, 90,90,"Turn " + turncount);
		view.add(turn);
		
		goal = new ThemedTextLabel(470, 35, 200,90,"Goal:$" + goalcount);
		view.add(goal);
		
		//SamsungLabel = new ThemedTextLabel(40,80,150,90,"Samsung " + share1);
		SamsungLabel = new ThemedTextLabel(120,80,70,90,Integer.toString(share1));
		view.add(SamsungLabel);
		select1 = new Button(20,140,90,30,"Samsung", Color.green,new Action(){
			@Override
			public void act() {
				selectStock(Samsung);	
			}
		});
		view.add(select1);
		plus1 = new Button(185,145,25,20,"+",Color.green, new Action() {
			@Override
			public void act() {
				share1++;
				SamsungLabel.setText(Integer.toString(share1) );
			}
		});
		view.add(plus1);
		minus1 = new Button(150,145,25,20,"-",Color.green, new Action() {
			@Override
			public void act() {
				if(share1 > 0){
					share1--;
				}
				
				SamsungLabel.setText(Integer.toString(share1));
			}
		});
		view.add(minus1);
		
		BlackgateLabel = new ThemedTextLabel(120, 120, 120, 90, Integer.toString(share2));
		view.add(BlackgateLabel);
		select2 = new Button(20,180,90,30,"Blackgate", Color.green,new Action() {
			@Override
			public void act() {
				selectStock(Blackgate);	
			}
		});
		view.add(select2);
		plus2 = new Button(185,190,25,20,"+",Color.green, new Action() {
			@Override
			public void act() {
				share2++;
				BlackgateLabel.setText(Integer.toString(share2));
			}
		});
		view.add(plus2);
		minus2 = new Button(150,190,25,20,"-",Color.green, new Action() {
			@Override
			public void act() {
				if(share2 > 0){
					share2--;
				}
				
				BlackgateLabel.setText(Integer.toString(share2));
			}
		});
		view.add(minus2);
		
		AppleLabel = new ThemedTextLabel(120, 155, 90, 90, Integer.toString(share3));
		view.add(AppleLabel);
		select3 = new Button(20,215,90,30,"Apple", Color.green,new Action() {
			@Override
			public void act() {
				selectStock(Apple);	
			}
		});
		view.add(select3);
		plus3 = new Button(185,220,25,20,"+",Color.green, new Action() {
			@Override
			public void act() {
				share3++;
				AppleLabel.setText(Integer.toString(share3));
			}
		});
		view.add(plus3);
		minus3 = new Button(150,220,25,20,"-",Color.green, new Action() {
			@Override
			public void act() {
				if(share3 > 0){
					share3--;
				}
				
				AppleLabel.setText(Integer.toString(share3));
			}
		});
		view.add(minus3);
		
		GlascowLabel = new ThemedTextLabel(120, 185, 120, 90, Integer.toString(share4));
		view.add(GlascowLabel);
		select4 = new Button(20,250,90,30,"Glascow", Color.green,new Action() {
			@Override
			public void act() {
				selectStock(Glascow);	
			}
		});
		view.add(select4);
		plus4 = new Button(185,253,25,20,"+",Color.green, new Action() {
			@Override
			public void act() {
				share4++;
				GlascowLabel.setText(Integer.toString(share4));
			}
		});
		view.add(plus4);
		minus4 = new Button(150,253,25,20,"-",Color.green, new Action() {
			@Override
			public void act() {
				if(share4 > 0){
					share4--;
				}
				
				GlascowLabel.setText(Integer.toString(share4));
			}
		});
		view.add(minus4);
		
		GeneralmotorsLabel = new ThemedTextLabel(180, 230, 170, 90, Integer.toString(share5));
		view.add(GeneralmotorsLabel);
		select5 = new Button(20,290,145,30,"General Motors", Color.green,new Action() {
			@Override
			public void act() {
				selectStock(Generalmotors);	
			}
		});
		view.add(select5);
		plus5 = new Button(245,295,25,20,"+",Color.green, new Action() {
			@Override
			public void act() {
				share5++;
				GeneralmotorsLabel.setText(Integer.toString(share5));
			}
		});
		view.add(plus5);
		minus5 = new Button(210,295,25,20,"-",Color.green, new Action() {
			@Override
			public void act() {
				if(share5 > 0){
					share5--;
				}
				
				GeneralmotorsLabel.setText(Integer.toString(share5));
			}
		});
		view.add(minus5);
		
		buy = new Button(350, 260, 90, 40, "Buy", Color.green, new Action() {
			
			@Override
			public void act() {
				result.setText("You bought a stock");
				System.out.println("You bought a stock");
			}
		});
		view.add(buy);
		view.add(result);

		user = new Button(350, 305, 200, 40, "User Portfolio", Color.green, new Action() {
			
			@Override
			public void act() {
				System.out.println("Transporting to your portfolio");
				GabrielDemo.mainDemoScreen.setScreen(inventoryDemo);
			}
		});
		view.add(user);
		view.add(result);
			
		sell = new Button(450, 260, 90, 40, "Sell", Color.green, new Action() {
				
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
			
		end = new Button(350, 350, 100, 40, "End Turn", Color.green, new Action() {
				
				@Override
				public void act() {
					System.out.println("Turn ended.");
					result.setText("Turn ended.");
					turncount++;
					turn.setText("Turn " + turncount); 
					
				}
		});
		view.add(result);
		view.add(end);
			
	}


			
	}
}

