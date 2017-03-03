package Demos;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import AmountButton;
import ManagerButton;
import PropertyButton;
import guiPractice8.GUIApplication;
import guiPractice8.Screen;
import guiPractice8.component.Action;
import guiPractice8.component.Button;
import guiPractice8.component.ClickableScreen;
import guiPractice8.component.TextLabel;
import guiPractice8.component.Visible;

public class JoeyDemo extends GUIApplication {

	private static Screen demoxd;
	private static JoeyDemo demo;
	private TextLabel lemonT;
	private TextLabel newsT;
	private TextLabel carT;
	private TextLabel pizzaT;
	private TextLabel shrimpT;
	private TextLabel hockeyT;
	private TextLabel movieT;
	private TextLabel donutT;
	private ArrayList<TextLabel> times;
	private Button lemonManager ;

	public JoeyDemo() {
		// TODO Auto-generated constructor stub
	}

	public JoeyDemo(int i, int j) {
		super(i, j);
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		demo = new JoeyDemo();
		Thread app = new Thread(demo);
		app.start();
	}

	protected void initScreen() {
		demoxd = new DemoScreen(1000, 600);
		setScreen(demoxd);
	}
	private class DemoScreen extends ClickableScreen {
		private Button lemonMoney;
		private Button newspaperMoney;
		private Button carMoney;
		private Button pizzaMoney;
		private Button donutMoney;
		private Button shrimpMoney;
		private Button hockeyMoney;
		private Button movieMoney;

		private double playerMoney;

		private int[] quantityOwned;

		private TextLabel buyText;
		private AmountButton one;
		private AmountButton ten;
		private AmountButton hundred;

		private PropertyButton lemon;
		private PropertyButton newspaper;
		private PropertyButton car;
		private PropertyButton pizza;
		private PropertyButton donut;
		private PropertyButton shrimp;
		private PropertyButton hockey;
		private PropertyButton movie;
		private ManagerButton lemonManager;
		private ManagerButton movieManager;
		private ManagerButton hockeyManager;
		private ManagerButton pizzaManager;
		private ManagerButton donutManager;
		private ManagerButton shrimpManager;
		private ManagerButton newspaperManager;
		private ManagerButton carManager;


		public DemoScreen(int width, int height) {
			super(width, height);
			// TODO Auto-generated constructor stub
		}

		public double roundNumber(double amount){
			double newNumber = (((int)(amount*100))/100.00);
			return newNumber;
		}




		public void createAmountButtons(){
			one = new AmountButton(800, 40, 100, 50, " x1", new Color(255,255,0), new Action(){

				public void act() {
					// TODO Auto-generated method stub

					if(one.isShowing()){
						moveToBack(one);
						moveToBack(one);
						ten.setTrue();
						//						moveToBack(background);
						//						moveToBack(background);
					}
				}
			}, 1, true);
			ten = new AmountButton(807, 50, 100, 50, " x10", new Color(255,255,0), new Action(){

				public void act() {
					// TODO Auto-generated method stub
					if(ten.isShowing()){
						moveToBack(ten);
						moveToBack(ten);
						hundred.setTrue();
						//						moveToBack(background);
						//						moveToBack(background);
					}
				}
			}, 10, false);
			hundred = new AmountButton(793, 45, 100, 50, " x100", new Color(255,255,0), new Action(){


				public void act() {
					// TODO Auto-generated method stub
					if(hundred.isShowing()){
						moveToBack(hundred);
						moveToBack(hundred);
						one.setTrue();
						//						moveToBack(background);
						//						moveToBack(background);
					}
				}
			}, 100, false);
		}

		private void priceScaling(PropertyButton button){
			double newPrice = Math.pow(1.08, one.getAmount())*button.getPrice();
			button.setPrice(roundNumber(newPrice));
		}

		public void generateButtons(){
			lemon = new PropertyButton(220,180,200,40,"Buy x"+one.getAmount()+"  $4.00", Color.ORANGE, new Action(){
				public void act(){
					if(lemon.getPrice()<=playerMoney){
						quantityOwned[0]+=one.getAmount();
						playerMoney -= lemon.getPrice();
						playerMoney = roundNumber(playerMoney);
						buyText.setText("$"+playerMoney);
						priceScaling(lemon);
						if(mill(lemon.getPrice())){
							int x = (int)donut.getPrice();
							double y = x/1000;
							lemon.setText("Buy x"+one.getAmount()+"  $"+y+" mill");
						}else{
							lemon.setText("Buy x"+one.getAmount()+"  $"+lemon.getPrice());
						}					}
				}
			}, 4, 1, 1.07, 1000);

			newspaper = new PropertyButton(720,180,200,40,"Buy x"+one.getAmount()+"  $60.00", Color.ORANGE, new Action(){
				public void act(){
					if(newspaper.getPrice()<=playerMoney){
						quantityOwned[1]+=one.getAmount();
						playerMoney -= newspaper.getPrice();
						playerMoney = roundNumber(playerMoney);
						buyText.setText("$"+playerMoney);
						priceScaling(newspaper);
						if(mill(newspaper.getPrice())){
							int x = (int)donut.getPrice();
							double y = x/1000;
							newspaper.setText("Buy x"+one.getAmount()+"  $"+y+" mill");
						}else{
							newspaper.setText("Buy x"+one.getAmount()+"  $"+newspaper.getPrice());
						}					}					
				}
			}, 60, 60, 1.15, 2000);

			car = new PropertyButton(220,280,200,40,"Buy x"+one.getAmount()+"  $720.00", Color.ORANGE, new Action(){
				public void act(){
					if(car.getPrice()<=playerMoney){
						quantityOwned[2]+=one.getAmount();
						playerMoney -= car.getPrice();
						playerMoney = roundNumber(playerMoney);
						buyText.setText("$"+playerMoney);
						priceScaling(car);
						if(mill(donut.getPrice())){
							int x = (int)car.getPrice();
							double y = x/1000;
							car.setText("Buy x"+one.getAmount()+"  $"+y+" mill");
						}else{
							car.setText("Buy x"+one.getAmount()+"  $"+car.getPrice());
						}					}
				}
			}, 720, 540, 1.14, 3000);

			pizza = new PropertyButton(720,280,200,40,"Buy x"+one.getAmount()+"  $8,640.00", Color.ORANGE, new Action(){
				public void act(){
					if(pizza.getPrice()<=playerMoney){
						quantityOwned[3]+=one.getAmount();
						playerMoney -= pizza.getPrice();
						playerMoney = roundNumber(playerMoney);
						buyText.setText("$"+playerMoney);
						priceScaling(pizza);
						if(mill(donut.getPrice())){
							int x = (int)donut.getPrice();
							double y = x/1000;
							pizza.setText("Buy x"+one.getAmount()+"  $"+y+" mill");
						}else{
							pizza.setText("Buy x"+one.getAmount()+"  $"+pizza.getPrice());
						}
					}
				}
			}, 8640, 4320, 1.13, 5000);

			donut = new PropertyButton(220,380,200,40,"Buy x"+one.getAmount()+"  $103,680.00", Color.ORANGE, new Action(){
				public void act(){
					if(donut.getPrice()<=playerMoney){
						quantityOwned[4]+=one.getAmount();
						playerMoney -= donut.getPrice();
						playerMoney = roundNumber(playerMoney);
						buyText.setText("$"+playerMoney);
						priceScaling(donut);
						if(mill(donut.getPrice())){
							int x = (int)donut.getPrice();
							double y = x/1000;
							donut.setText("Buy x"+one.getAmount()+"  $"+y+" mill");
						}else{
							donut.setText("Buy x"+one.getAmount()+"  $"+donut.getPrice());
						}

					}
				}
			}, 103680, 51840, 1.12, 12000);

			shrimp = new PropertyButton(720,380,200,40,"Buy x"+one.getAmount()+"  $1.244 mill", Color.ORANGE, new Action(){
				public void act(){
					if(shrimp.getPrice()<=playerMoney){
						quantityOwned[5]+=one.getAmount();
						playerMoney -= shrimp.getPrice();
						playerMoney = roundNumber(playerMoney);
						buyText.setText("$"+playerMoney);
						priceScaling(shrimp);	
						if(mill(shrimp.getPrice())){
							int x = (int)donut.getPrice();
							double y = x/1000;
							shrimp.setText("Buy x"+one.getAmount()+"  $"+y+" mill");
						}else{
							shrimp.setText("Buy x"+one.getAmount()+"  $"+shrimp.getPrice());
						}		
					}
				}
			}, 1244000, 622080, 1.11, 47000 );

			hockey = new PropertyButton(220,480,200,40,"Buy x"+one.getAmount()+"  $14.929 mill", Color.ORANGE, new Action(){
				public void act(){
					if(hockey.getPrice()<=playerMoney){
						quantityOwned[6]+=one.getAmount();
						playerMoney -= hockey.getPrice();
						playerMoney = roundNumber(playerMoney);
						buyText.setText("$"+playerMoney);
						priceScaling(hockey);		
						if(mill(hockey.getPrice())){
							int x = (int)donut.getPrice();
							double y = x/1000;
							hockey.setText("Buy x"+one.getAmount()+"  $"+y+" mill");
						}else{
							hockey.setText("Buy x"+one.getAmount()+"  $"+hockey.getPrice());
						}					}
				}
			}, 14929000, 7464000, 1.10, 192000);

			movie = new PropertyButton(720,480,200,40,"Buy x"+one.getAmount()+"  $179.159 mill", Color.ORANGE, new Action(){
				public void act(){
					if(movie.getPrice()<=playerMoney){
						quantityOwned[7]+=one.getAmount();
						playerMoney -= movie.getPrice();
						playerMoney = roundNumber(playerMoney);
						buyText.update();
						priceScaling(movie);		
						if(mill(movie.getPrice())){
							int x = (int)donut.getPrice();
							double y = x/1000;
							movie.setText("Buy x"+one.getAmount()+"  $"+y+" mill");
						}else{
							movie.setText("Buy x"+one.getAmount()+"  $"+movie.getPrice());
						}					}
				}
			}, 179159000, 89579000, 1.09, 768000);

		}


		public void managers(){
			lemonManager = new ManagerButton(220, 130, 200, 40, "Manage $100", new Color(255,255,0), new Action(){
				public void act(){
					if(playerMoney>=lemonManager.getPricexd()){
						lemonMoney.setEnabled(false);
						viewObjects.remove(lemonManager);
						boolean x = true;
						while(x){							
						lemonMoney.act();
						}
					}
				}
			},100);
			newspaperManager = new ManagerButton(720, 130, 200, 40, "Manage $1000", new Color(255,255,0), new Action(){
				public void act(){
					if(playerMoney>=newspaperManager.getPricexd()){
						newspaperMoney.setEnabled(false);
						viewObjects.remove(newspaperManager);		
						boolean x = true;
						while(x){							
							newspaperMoney.act();
						}
					}
				}
			}, 1000);
			carManager = new ManagerButton(220, 230, 200, 40, "Manage $10k", new Color(255,255,0), new Action(){
				public void act(){
					if(playerMoney>=carManager.getPricexd()){
						carMoney.setEnabled(false);
						viewObjects.remove(carManager);
						boolean x = true;
						while(x){							
						carMoney.act();
						}
					}
				}
			}, 10000);
			pizzaManager = new ManagerButton(720, 230, 200, 40, "Manage $100k", new Color(255,255,0), new Action(){
				public void act(){
					if(playerMoney>=pizzaManager.getPricexd()){
						pizzaMoney.setEnabled(false);
						viewObjects.remove(lemonManager);	
						boolean x = true;
						while(x){							
						pizzaMoney.act();
						}
					}
				}
			},100000);
			donutManager = new ManagerButton(220, 330, 200,40, "Manage $1 mill", new Color(255,255,0), new Action(){
				public void act(){
					if(playerMoney>=donutManager.getPricexd()){
						donutMoney.setEnabled(false);
						viewObjects.remove(donutManager);	
						boolean x = true;
						while(x){							
						donutMoney.act();
						}
					}
				}
			},1000000);
			shrimpManager = new ManagerButton(720, 330, 200, 40, "Manage $10 mill", new Color(255,255,0), new Action(){
				public void act(){
					if(playerMoney>=shrimpManager.getPricexd()){
						shrimpMoney.setEnabled(false);
						viewObjects.remove(shrimpManager);	
						boolean x = true;
						while(x){							
						shrimpMoney.act();
						}
					}
				}
			},10000000);
			hockeyManager = new ManagerButton(220, 430, 200, 40, "Manage $100 mill", new Color(255,255,0), new Action(){
				public void act(){
					if(playerMoney>=hockeyManager.getPricexd()){
						hockeyMoney.setEnabled(false);
						viewObjects.remove(hockeyManager);	
						boolean x = true;
						while(x){							
						hockeyMoney.act();
						}
					}
				}
			},100000000);
			movieManager = new ManagerButton(720, 430, 200, 40, "Manage $1 bill", new Color(255,255,0), new Action(){
				public void act(){
					if(playerMoney>=movieManager.getPricexd()){
						movieMoney.setEnabled(false);
						viewObjects.remove(movieManager);	
						boolean x = true;
						while(x){							
						movieMoney.act();
						}
					}
				}
			},1000000000);
		}







		@Override
		public void initAllObjects(List<Visible> v) {
			// TODO Auto-generated method stub
			buyText = new TextLabel(10, 0, 700, 100, "0.00");
			playerMoney = 0;
			createAmountButtons();
			generateButtons();
			quantityOwned = new int[8];
			quantityOwned[0] = 1;



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

			viewObjects.add(buyText);

			viewObjects.add(lemonMoney);
			viewObjects.add(newspaperMoney);
			viewObjects.add(carMoney);
			viewObjects.add(pizzaMoney);
			viewObjects.add(donutMoney);
			viewObjects.add(shrimpMoney);
			viewObjects.add(hockeyMoney);
			viewObjects.add(movieMoney);

			viewObjects.add(lemon);
			viewObjects.add(newspaper);
			viewObjects.add(car);
			viewObjects.add(pizza);
			viewObjects.add(donut);
			viewObjects.add(shrimp);
			viewObjects.add(hockey);
			viewObjects.add(movie);


			generateTimer();
			viewObjects.add(lemonT);
			viewObjects.add(newsT);
			viewObjects.add(carT);
			viewObjects.add(pizzaT);
			viewObjects.add(donutT);
			viewObjects.add(shrimpT);
			viewObjects.add(hockeyT);
			viewObjects.add(movieT);
			
			managers();
			viewObjects.add(lemonManager);
			viewObjects.add(newspaperManager);
			viewObjects.add(carManager);
			viewObjects.add(pizzaManager);
			viewObjects.add(donutManager);
			viewObjects.add(shrimpManager);
			viewObjects.add(hockeyManager);
			viewObjects.add(movieManager);


		}
		//		public void createTimerLabels(){
		//			TextLabel lemonTimer = new TextLabel(int x, int y, int w, int h, String text);
		//		}

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
