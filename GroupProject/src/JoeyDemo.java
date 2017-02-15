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
		
		private TextLabel buyText;
		private AmountButton one;
		private AmountButton ten;
		private AmountButton hundred;
		
		public DemoScreen(int width, int height) {
			super(width, height);
			// TODO Auto-generated constructor stub
		}
		
		
		public void createAmountButtons(){
			one = new AmountButton(800, 40, 100, 50, " x1", new Color(255,255,0), new Action(){

				public void act() {
					// TODO Auto-generated method stub

					if(one.isShowing()){
						System.out.println("button 1 is " + button1Disabled);
						return;
					}
					else{
						System.out.println(one.getAmount());
						button3Disabled = !button3Disabled;
						button1Disabled = !button1Disabled;
						moveToBack(one);
						moveToBack(one);
						moveToBack(background);
						moveToBack(background);
					}
				}
			}, 1, true);
			ten = new AmountButton(807, 50, 100, 50, " x10", new Color(255,255,0), new Action(){

				public void act() {
					// TODO Auto-generated method stub
					if(ten.isShowing()){
						System.out.println("button 2 is " + button2Disabled);
						return;
					}
					else{
						System.out.println("klegjielg");
						button1Disabled = !button1Disabled;
						button2Disabled = !button2Disabled;
						moveToBack(ten);
						moveToBack(ten);
						moveToBack(background);
						moveToBack(background);
					}
				}
			}, 10, false);
			hundred = new AmountButton(793, 45, 100, 50, " x100", new Color(255,255,0), new Action(){


				public void act() {
					// TODO Auto-generated method stub
					if(hundred.isShowing()){
						System.out.println("button 3 is " + button3Disabled);
						return;
					}
					else{
						System.out.println("rtyeryer");
						button2Disabled = !button2Disabled;
						button3Disabled = !button3Disabled;
						moveToBack(hundred);
						moveToBack(hundred);
						moveToBack(background);
						moveToBack(background);
					}
				}
			}, 100, false);
		}
		
		

		@Override
		public void initAllObjects(List<Visible> v) {
			// TODO Auto-generated method stub
			buyText = new TextLabel(10, 0, 700, 100, "");
			
			
			
			
			buyButton1 = new Button(420, 180, 150, 40, "BUY", new Color(255,255,0), new Action(){

				public void act(){
					
					buyText.setText("");
				}
			});
			buyButton2 = new Button(820, 180, 150, 40, "BUY", new Color(255,255,0), new Action(){
				public void act(){
					buyText.setText("You have bought girgwiglg2");
				}
			});
			buyButton3 = new Button(420, 280, 150, 40, "BUY", new Color(255,255,0), new Action(){
				public void act(){
					buyText.setText("You have bought girgwiglg3");
				}
			});
			buyButton4 = new Button(820, 280, 150, 40, "BUY", new Color(255,255,0), new Action(){
				public void act(){
					buyText.setText("You have bought girgwiglg4");
				}
			});
			buyButton5 = new Button(420, 380, 150, 40, "BUY", new Color(255,255,0), new Action(){
				public void act(){
					buyText.setText("You have bought girgwiglg5");
				}
			});
			buyButton6 = new Button(820, 380, 150, 40, "BUY", new Color(255,255,0), new Action(){
				public void act(){
					buyText.setText("You have bought girgwiglg6");
				}
			});
			buyButton7 = new Button(420, 480, 150, 40, "BUY", new Color(255,255,0), new Action(){
				public void act(){
					buyText.setText("You have bought girgwiglg7");
				}
			});
			buyButton8 = new Button(820, 480, 150, 40, "BUY", new Color(255,255,0), new Action(){
				public void act(){
					buyText.setText("You have bought girgwiglg8");
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
			
		}
		
	}
}
