import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;

import Demos.RichardDemo;
import guiPratice.components.AnimatedComponent;
import guiPratice.GUIApplication;
import guiPratice.Screen;
import guiPractice8.component.Action;
import guiPractice8.component.Button;
import guiPratice.components.Graphic;
import guiPratice.components.TextLabel;
import guiPratice.components.Visible;
import guiPratice.sampleGames.ClickableScreen;

public class AdventureCapScreen extends ClickableScreen implements AdventureCapScreenInterface{

	public AdventureCapScreen(int width, int height) {
		super(width, height);
		// TODO Auto-generated constructor stub
	}

	public static AdventureCapScreen AdvCapDemo;
	public static ManagerScreen manager;
	public static StatsScreen stats;


	private static TextLabel moneyText;
	private int currentAmount;

	private Graphic background;//made

	private Button statsButton;//made
	private Button restartButton;//made
	private Button managerButton;


	public Button lemonMoney;
	public Button newspaperMoney;
	public Button carMoney;
	public Button pizzaMoney;
	public Button donutMoney;
	public Button shrimpMoney;
	public Button hockeyMoney;
	public Button movieMoney;

	private PropertyButton lemon;
	private PropertyButton newspaper;
	private PropertyButton car;
	private PropertyButton pizza;
	private PropertyButton donut;
	private PropertyButton shrimp;
	private PropertyButton hockey;
	private PropertyButton movie;
	private TextLabel lemonT;
	private TextLabel newsT;
	private TextLabel carT;
	private TextLabel pizzaT;
	private TextLabel donutT;
	private TextLabel shrimpT;
	private TextLabel hockeyT;
	private TextLabel movieT;
	private ArrayList<TextLabel> times;

	public void generateMenuButtons(){
		managerButton = new Button(50, 230, 150, 40, "MANAGER", new Color(0,0,0), new Action(){
			public void act(){
				//take me to manager screen
				System.out.println("Clicked");
				AdventureCapGame.game.setScreen(AdventureCapGame.manager);
			}
		});

		statsButton = new Button(50, 290, 150, 40, "STATISTICS", new Color(0,0,0), new Action(){
			public void act(){
				AdventureCapGame.game.setScreen(AdventureCapGame.stats);
			}
		});

		restartButton = new Button(50, 350, 150, 40, "restart*", new Color(0,0,0), new Action(){
			public void act(){
				//				reset.setText("You have reseted");

			}
		});
	}
	public void generateAmountButton(){

	}

	@Override
	public void initAllObjects(ArrayList<Visible> arg0) {

		background = new Graphic(1,1,1.0,"Resources/background/cfafa34141.png");

		generateMenuButtons();
		//	ArrayList<PropertyButtonInterface> properties = JoeyOperation.generateButtons();
		//	ArrayList<guiPractice8.component.Button> moneyButtons = JoeyOperation.generateMoneyButtons();

		viewObjects.add(background);

		viewObjects.add(managerButton);
		viewObjects.add(statsButton);
		viewObjects.add(restartButton);
	}

	@Override
	public int getCurrentAmount() {
		// TODO Auto-generated method stub
		return currentAmount;
	}

	public void setMoneyText(String text) {
		// TODO Auto-generated method stub
		moneyText.setText(text);
	}




	private static void priceScaling(PropertyButton button){
		double newPrice = Math.pow(1.08, RichardDemo.getCurrentAmount())*button.getPrice();
		button.setPrice(newPrice);
	}
	public void generateButtons(){

		lemon = new PropertyButton(220,180,200,50,"Buy x"+RichardDemo.getCurrentAmount()+"  $4.00", Color.ORANGE, new Action(){
			public void act(){
				if(lemon.getPrice()<=Statistics.stats.getCurrentBalance()){
					double money = Statistics.stats.getCurrentBalance();
					int[] qtyOwned = Statistics.stats.getQuantityArray();
					Statistics.stats.setQuantityArray(0, qtyOwned[0]+=RichardDemo.getCurrentAmount());
					money -= lemon.getPrice();
					AdventureCapScreen.AdvCapDemo.setMoneyText("$"+money);
					priceScaling(lemon);
					lemon.setText("Buy x"+AdventureCapScreen.AdvCapDemo.getCurrentAmount()+"  $"+lemon.getPrice());
					Statistics.stats.setMoney(money);
				}
			}
		}, 4, 1, 1.07, 1000);

		newspaper = new PropertyButton(720,180,200,50,"Buy x"+RichardDemo.getCurrentAmount()+"  $60.00", Color.ORANGE, new Action(){
			public void act(){
				if(newspaper.getPrice()<=Statistics.stats.getCurrentBalance()){
					double money = Statistics.stats.getCurrentBalance();
					int[] qtyOwned = Statistics.stats.getQuantityArray();
					Statistics.stats.setQuantityArray(0, qtyOwned[0]+=RichardDemo.getCurrentAmount());
					money -= newspaper.getPrice();
					AdventureCapScreen.AdvCapDemo.setMoneyText("$"+money);
					priceScaling(newspaper);
					newspaper.setText("Buy x"+AdventureCapScreen.AdvCapDemo.getCurrentAmount()+"  $"+newspaper.getPrice());
					Statistics.stats.setMoney(money);
				}					
			}
		}, 60, 60, 1.15, 2000);

		car = new PropertyButton(220,280,200,50,"Buy x"+RichardDemo.getCurrentAmount()+"  $720.00", Color.ORANGE, new Action(){
			public void act(){
				if(car.getPrice()<=Statistics.stats.getCurrentBalance()){
					double money = Statistics.stats.getCurrentBalance();
					int[] qtyOwned = Statistics.stats.getQuantityArray();
					Statistics.stats.setQuantityArray(0, qtyOwned[0]+=RichardDemo.getCurrentAmount());
					money -= car.getPrice();
					AdventureCapScreen.AdvCapDemo.setMoneyText("$"+money);
					priceScaling(car);
					car.setText("Buy x"+AdventureCapScreen.AdvCapDemo.getCurrentAmount()+"  $"+car.getPrice());
					Statistics.stats.setMoney(money);
				}
			}
		}, 720, 540, 1.14, 3000);

		pizza = new PropertyButton(720,280,200,50,"Buy x"+RichardDemo.getCurrentAmount()+"  $8,640.00", Color.ORANGE, new Action(){
			public void act(){
				if(pizza.getPrice()<=Statistics.stats.getCurrentBalance()){
					double money = Statistics.stats.getCurrentBalance();
					int[] qtyOwned = Statistics.stats.getQuantityArray();
					Statistics.stats.setQuantityArray(0, qtyOwned[0]+=RichardDemo.getCurrentAmount());
					money -= pizza.getPrice();
					AdventureCapScreen.AdvCapDemo.setMoneyText("$"+money);
					priceScaling(pizza);
					pizza.setText("Buy x"+AdventureCapScreen.AdvCapDemo.getCurrentAmount()+"  $"+pizza.getPrice());
					Statistics.stats.setMoney(money);
				}
			}
		}, 8640, 4320, 1.13, 5000);

		donut = new PropertyButton(220,380,200,50,"Buy x"+RichardDemo.getCurrentAmount()+"  $103,680.00", Color.ORANGE, new Action(){
			public void act(){
				if(donut.getPrice()<=Statistics.stats.getCurrentBalance()){
					double money = Statistics.stats.getCurrentBalance();
					int[] qtyOwned = Statistics.stats.getQuantityArray();
					Statistics.stats.setQuantityArray(0, qtyOwned[0]+=RichardDemo.getCurrentAmount());
					money -= donut.getPrice();
					AdventureCapScreen.AdvCapDemo.setMoneyText("$"+money);
					priceScaling(donut);
					donut.setText("Buy x"+AdventureCapScreen.AdvCapDemo.getCurrentAmount()+"  $"+donut.getPrice());
					Statistics.stats.setMoney(money);
				}
			}
		}, 103680, 51840, 1.12, 12000);

		shrimp = new PropertyButton(720,380,200,50,"Buy x"+RichardDemo.getCurrentAmount()+"  $1.244 mill", Color.ORANGE, new Action(){
			public void act(){
				if(shrimp.getPrice()<=Statistics.stats.getCurrentBalance()){
					double money = Statistics.stats.getCurrentBalance();
					int[] qtyOwned = Statistics.stats.getQuantityArray();
					Statistics.stats.setQuantityArray(0, qtyOwned[0]+=RichardDemo.getCurrentAmount());
					money -= shrimp.getPrice();
					AdventureCapScreen.AdvCapDemo.setMoneyText("$"+money);
					priceScaling(shrimp);	
					shrimp.setText("Buy x"+AdventureCapScreen.AdvCapDemo.getCurrentAmount()+"  $"+shrimp.getPrice());		
					Statistics.stats.setMoney(money);
				}
			}
		}, 1244000, 622080, 1.11, 47000 );

		hockey = new PropertyButton(220,480,200,50,"Buy x"+RichardDemo.getCurrentAmount()+"  $14.929 mill", Color.ORANGE, new Action(){
			public void act(){
				if(hockey.getPrice()<=Statistics.stats.getCurrentBalance()){
					double money = Statistics.stats.getCurrentBalance();
					int[] qtyOwned = Statistics.stats.getQuantityArray();
					Statistics.stats.setQuantityArray(0, qtyOwned[0]+=RichardDemo.getCurrentAmount());
					money -= hockey.getPrice();
					AdventureCapScreen.AdvCapDemo.setMoneyText("$"+money);
					priceScaling(hockey);		
					hockey.setText("Buy x"+AdventureCapScreen.AdvCapDemo.getCurrentAmount()+"  $"+hockey.getPrice());	
					Statistics.stats.setMoney(money);
					History.updateHistory(6, "Hockey Stadium");
				}
			}
		}, 14929000, 7464000, 1.10, 192000);

		movie = new PropertyButton(720,480,200,50,"Buy x"+RichardDemo.getCurrentAmount()+"  $179.159 mill", Color.ORANGE, new Action(){
			public void act(){
				if(movie.getPrice()<=Statistics.stats.getCurrentBalance()){
					double money = Statistics.stats.getCurrentBalance();
					int[] qtyOwned = Statistics.stats.getQuantityArray();
					Statistics.stats.setQuantityArray(0, qtyOwned[0]+=RichardDemo.getCurrentAmount());
					money -= movie.getPrice();
					AdventureCapScreen.AdvCapDemo.setMoneyText("$"+money);
					priceScaling(movie);		
					movie.setText("Buy x"+AdventureCapScreen.AdvCapDemo.getCurrentAmount()+"  $"+movie.getPrice());	
					Statistics.stats.setMoney(money);
				}
			}
		}, 179159000, 89579000, 1.09, 768000);

	}



	public void moneyMaker(){
		lemonMoney = new Button(10, 180, 150, 40, "Money!", new Color(255,255,0), new Action(){
			public void act(){
				doButtonAction(lemonMoney,lemon, 0);
			}
		});
		newspaperMoney = new Button(510, 180, 150, 40, "Money!", new Color(255,255,0), new Action(){
			public void act(){
				doButtonAction(newspaperMoney,newspaper, 1);
			}
		});
		carMoney = new Button(10, 280, 150, 40, "Money!", new Color(255,255,0), new Action(){
			public void act(){
				doButtonAction(carMoney	,car, 2);
			}
		});
		pizzaMoney = new Button(510, 280, 150, 40, "Money!", new Color(255,255,0), new Action(){
			public void act(){
				doButtonAction(pizzaMoney,pizza, 3);
			}
		});
		donutMoney = new Button(10, 380, 150, 40, "Money!", new Color(255,255,0), new Action(){
			public void act(){
				doButtonAction(donutMoney,donut, 4);
			}
		});
		shrimpMoney = new Button(510, 380, 150, 40, "Money!", new Color(255,255,0), new Action(){
			public void act(){
				doButtonAction(shrimpMoney,shrimp, 5);
			}
		});
		hockeyMoney = new Button(10, 480, 150, 40, "Money!", new Color(255,255,0), new Action(){
			public void act(){
				doButtonAction(hockeyMoney,hockey, 6);
			}
		});
		movieMoney = new Button(510, 480, 150, 40, "Money!", new Color(255,255,0), new Action(){
			public void act(){
				doButtonAction(movieMoney,movie, 7);
			}
		});
	}
	protected void doButtonAction(Button buyButton, PropertyButton property, int i) {

		Thread actionToDo = new Thread(new Runnable(){

			@Override
			public void run() {
				buyButton.setEnabled(false);
				countdown(property,times.get(i));
				//					try{
				//						Thread.sleep((long) property.getTime());
				//					}catch(InterruptedException e){
				//						e.printStackTrace();
				//					}
				playerMoney += property.getPayout() * quantityOwned[i];
				playerMoney = roundNumber(playerMoney);
				buyText.setText("$"+playerMoney);
				buyButton.setEnabled(true);
			}

		});
		actionToDo.start();


	}


	public boolean mill(double x){
		int d = (int)x;
		String str = ""+d;
		return str.length()>=6;
	}

	public void generateTimer(){
		lemonT = new TextLabel(50, 70, 700, 100, "");
		newsT = new TextLabel(550, 70, 700, 100, "");
		carT = new TextLabel(50, 170, 700, 100, "");
		pizzaT = new TextLabel(550, 170, 700, 100, "");
		donutT = new TextLabel(50,270,700,100,"");
		shrimpT = new TextLabel(550, 270, 700, 100, "");
		hockeyT = new TextLabel(50, 370, 700, 100, "");
		movieT = new TextLabel(550, 370, 700, 100, "");
		times = new ArrayList<TextLabel>();
		times.add(lemonT);
		times.add(newsT);
		times.add(carT);
		times.add(pizzaT);
		times.add(donutT);
		times.add(shrimpT);
		times.add(hockeyT);
		times.add(movieT);
	}

	public void countdown(PropertyButton x, TextLabel b){
		double timeLeft = x.getTime()/1000;
		while(timeLeft > 0){
			//frame updates every 100ms
			try{
				Thread.sleep(100);
			}catch(InterruptedException e){
				e.printStackTrace();
			}
			timeLeft -= .1;
			b.setText(""+(int)(timeLeft*10)/10.0);
		}
	}


}
