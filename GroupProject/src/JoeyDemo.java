import java.awt.Color;
import java.util.List;

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
		private Button buyButton1;
		private Button buyButton2;
		private Button buyButton3;
		private Button buyButton4;
		private Button buyButton5;
		private Button buyButton6;
		private Button buyButton7;
		private Button buyButton8;

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
			lemon = new PropertyButton(220,180,200,50,"Buy x"+one.getAmount()+"  $4.00", Color.ORANGE, new Action(){
				public void act(){
					if(lemon.getPrice()<=playerMoney){
						quantityOwned[0]+=one.getAmount();
						playerMoney -= lemon.getPrice();
						playerMoney = roundNumber(playerMoney);
						buyText.setText("$"+playerMoney);
						priceScaling(lemon);
						lemon.setText("Buy x"+one.getAmount()+"  $"+lemon.getPrice());
					}
				}
			}, 4, 1, 1.07, 1000, false );

			newspaper = new PropertyButton(720,180,200,50,"Buy x"+one.getAmount()+"  $60.00", Color.ORANGE, new Action(){
				public void act(){
					if(newspaper.getPrice()<=playerMoney){
						quantityOwned[1]+=one.getAmount();
						playerMoney -= newspaper.getPrice();
						playerMoney = roundNumber(playerMoney);
						buyText.setText("$"+playerMoney);
						priceScaling(newspaper);
						newspaper.setText("Buy x"+one.getAmount()+"  $"+newspaper.getPrice());
					}
				}
			}, 60, 60, 1.15, 2000, false);

			car = new PropertyButton(220,280,200,50,"Buy x"+one.getAmount()+"  $720.00", Color.ORANGE, new Action(){
				public void act(){
					if(car.getPrice()<=playerMoney){
						quantityOwned[2]+=one.getAmount();
						playerMoney -= car.getPrice();
						playerMoney = roundNumber(playerMoney);
						buyText.setText("$"+playerMoney);
						priceScaling(car);
						car.setText("Buy x"+one.getAmount()+"  $"+car.getPrice());
					}
				}
			}, 720, 540, 1.14, 3000, false );

			pizza = new PropertyButton(720,280,200,50,"Buy x"+one.getAmount()+"  $8,640.00", Color.ORANGE, new Action(){
				public void act(){
					if(pizza.getPrice()<=playerMoney){
						quantityOwned[3]+=one.getAmount();
						playerMoney -= pizza.getPrice();
						playerMoney = roundNumber(playerMoney);
						buyText.setText("$"+playerMoney);
						priceScaling(pizza);
						pizza.setText("Buy x"+one.getAmount()+"  $"+pizza.getPrice());
					}
				}
			}, 8640, 4320, 1.13, 5000, false );

			donut = new PropertyButton(220,380,200,50,"Buy x"+one.getAmount()+"  $103,680.00", Color.ORANGE, new Action(){
				public void act(){
					if(donut.getPrice()<=playerMoney){
						quantityOwned[4]+=one.getAmount();
						playerMoney -= donut.getPrice();
						playerMoney = roundNumber(playerMoney);
						buyText.setText("$"+playerMoney);
						priceScaling(donut);
						donut.setText("Buy x"+one.getAmount()+"  $"+donut.getPrice());
					}
				}
			}, 103680, 51840, 1.12, 12000, false );

			shrimp = new PropertyButton(720,380,200,50,"Buy x"+one.getAmount()+"  $1.244 mill", Color.ORANGE, new Action(){
				public void act(){
					if(shrimp.getPrice()<=playerMoney){
						quantityOwned[5]+=one.getAmount();
						playerMoney -= shrimp.getPrice();
						playerMoney = roundNumber(playerMoney);
						buyText.setText("$"+playerMoney);
						priceScaling(shrimp);	
						shrimp.setText("Buy x"+one.getAmount()+"  $"+shrimp.getPrice());		
					}
				}
			}, 1244000, 622080, 1.11, 47000, false );

			hockey = new PropertyButton(220,480,200,50,"Buy x"+one.getAmount()+"  $14.929 mill", Color.ORANGE, new Action(){
				public void act(){
					if(hockey.getPrice()<=playerMoney){
						quantityOwned[6]+=one.getAmount();
						playerMoney -= hockey.getPrice();
						playerMoney = roundNumber(playerMoney);
						buyText.setText("$"+playerMoney);
						priceScaling(hockey);		
						hockey.setText("Buy x"+one.getAmount()+"  $"+hockey.getPrice());	
					}
				}
			}, 14929000, 7464000, 1.10, 192000, false );

			movie = new PropertyButton(720,480,200,50,"Buy x"+one.getAmount()+"  $179.159 mill", Color.ORANGE, new Action(){
				public void act(){
					if(movie.getPrice()<=playerMoney){
						quantityOwned[7]+=one.getAmount();
						playerMoney -= movie.getPrice();
						playerMoney = roundNumber(playerMoney);
						buyText.setText("$"+playerMoney);
						priceScaling(movie);
					}
				}
			}, 179159000, 89579000, 1.09, 768000, false);


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



			buyButton1 = new Button(10, 180, 150, 40, "Make Money!", new Color(255,255,0), new Action(){

				public void act(){
					doButtonAction(buyButton1,lemon);


				}
			});
			buyButton2 = new Button(510, 180, 150, 40, "Make Money!", new Color(255,255,0), new Action(){
				public void act(){
					if(newspaper.isNotActive()){
						try{
							newspaper.activeSwap();
							Thread.sleep((long) newspaper.getTime());
							playerMoney += newspaper.getPayout() * quantityOwned[1];
							playerMoney = roundNumber(playerMoney);
							buyText.setText("$"+playerMoney);	
							newspaper.activeSwap();
						}catch(InterruptedException e){
							e.printStackTrace();
						}
					}
				}
			});
			buyButton3 = new Button(10, 280, 150, 40, "Make Money!", new Color(255,255,0), new Action(){
				public void act(){
					if(car.isNotActive()){
						try{
							car.activeSwap();
							Thread.sleep((long) car.getTime());
							playerMoney += car.getPayout() * quantityOwned[2];
							playerMoney = roundNumber(playerMoney);
							buyText.setText("$"+playerMoney);	
							car.activeSwap();
						}catch(InterruptedException e){
							e.printStackTrace();
						}
					}
				}
			});
			buyButton4 = new Button(510, 280, 150, 40, "Make Money!", new Color(255,255,0), new Action(){
				public void act(){
					if(pizza.isNotActive()){
						try{
							pizza.activeSwap();
							Thread.sleep((long) pizza.getTime());
							playerMoney += pizza.getPayout() * quantityOwned[3];
							playerMoney = roundNumber(playerMoney);
							buyText.setText("$"+playerMoney);
							pizza.activeSwap();
						}catch(InterruptedException e){
							e.printStackTrace();
						}
					}

				}
			});
			buyButton5 = new Button(10, 380, 150, 40, "Make Money!", new Color(255,255,0), new Action(){
				public void act(){
					if(donut.isNotActive()){
						try{
							donut.activeSwap();
							Thread.sleep((long) donut.getTime());
							playerMoney += donut.getPayout() * quantityOwned[4];
							playerMoney = roundNumber(playerMoney);
							buyText.setText("$"+playerMoney);
							donut.activeSwap();
						}catch(InterruptedException e){
							e.printStackTrace();
						}
					}
				}
			});
			buyButton6 = new Button(510, 380, 150, 40, "Make Money!", new Color(255,255,0), new Action(){
				public void act(){
					if(shrimp.isNotActive()){
						try{
							shrimp.activeSwap();
							Thread.sleep((long) shrimp.getTime());
							playerMoney += shrimp.getPayout() * quantityOwned[5];
							playerMoney = roundNumber(playerMoney);
							buyText.setText("$"+playerMoney);	
							shrimp.activeSwap();
						}catch(InterruptedException e){
							e.printStackTrace();
						}
					}
				}
			});
			buyButton7 = new Button(10, 480, 150, 40, "Make Money!", new Color(255,255,0), new Action(){
				public void act(){
					if(hockey.isNotActive()){
						try{
							hockey.activeSwap();
							Thread.sleep((long) hockey.getTime());
							playerMoney += hockey.getPayout() * quantityOwned[6];
							playerMoney = roundNumber(playerMoney);
							buyText.setText("$"+playerMoney);
							hockey.activeSwap();
						}catch(InterruptedException e){
							e.printStackTrace();
						}
					}
				}
			});
			buyButton8 = new Button(510, 480, 150, 40, "Make Money!", new Color(255,255,0), new Action(){
				public void act(){
					if(movie.isNotActive()){
						try{
							movie.activeSwap();
							Thread.sleep((long) movie.getTime());
							playerMoney += movie.getPayout() * quantityOwned[7];
							playerMoney = roundNumber(playerMoney);
							buyText.setText("$"+playerMoney);	
							movie.activeSwap();
						}catch(InterruptedException e){
							e.printStackTrace();
						}
					}
				}
			});

			viewObjects.add(buyText);

			viewObjects.add(buyButton1);
			viewObjects.add(buyButton2);
			viewObjects.add(buyButton3);
			viewObjects.add(buyButton4);
			viewObjects.add(buyButton5);
			viewObjects.add(buyButton6);
			viewObjects.add(buyButton7);
			viewObjects.add(buyButton8);

			viewObjects.add(lemon);
			viewObjects.add(newspaper);
			viewObjects.add(car);
			viewObjects.add(pizza);
			viewObjects.add(donut);
			viewObjects.add(shrimp);
			viewObjects.add(hockey);
			viewObjects.add(movie);

		}
		//		public void createTimerLabels(){
		//			TextLabel lemonTimer = new TextLabel(int x, int y, int w, int h, String text);
		//		}

		protected void doButtonAction(Button buyButton1, PropertyButton lemon) {
			
			Thread actionToDo = new Thread(new Runnable(){

				@Override
				public void run() {
					buyButton1.setEnabled(false);
					//			if(lemon.isNotActive()){
					try{
						//					lemon.activeSwap();
						System.out.println("Attempting to sleep for "+(long) lemon.getTime());
						Thread.sleep((long) lemon.getTime());
						System.out.println("Finished sleeping.");
					}catch(InterruptedException e){
						e.printStackTrace();
					}
					System.out.println("Running other code.");
					playerMoney += lemon.getPayout() * quantityOwned[0];
					playerMoney = roundNumber(playerMoney);
					buyText.setText("$"+playerMoney);
					//					lemon.activeSwap();
					buyButton1.setEnabled(true);
				}
					
			});
			actionToDo.start();
			
			
		}
	}


}
