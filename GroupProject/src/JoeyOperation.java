import java.awt.Color;
import java.util.ArrayList;

import guiPractice8.component.Action;
import guiPractice8.component.Button;

public class JoeyOperation {
	public static ArrayList<AmountButtonInterface> amountButtons;
	public static PropertyButton lemon;
	public static PropertyButton newspaper;
	public static PropertyButton car;
	public static PropertyButton pizza;
	public static PropertyButton donut;
	public static PropertyButton shrimp;
	public static PropertyButton hockey;
	public static PropertyButton movie;

	public static AmountButton one;
	public static AmountButton ten;
	public static AmountButton hundred;
	public static AmountButton max;




	private boolean button1Disabled = true;
	private boolean button2Disabled = true;
	private boolean button3Disabled = false;


	private int[] numbers;

	public static ArrayList<PropertyButton> properties;
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	private boolean canBuy(int userMoney, int cost){
		return userMoney>cost;
	}

	public void priceScaling(PropertyButton button){
		double newPrice = Math.pow(1.08, numberBought)*button.getPrice();
		button.setPrice(newPrice);
	}

	public int calculateMax(double currentMoney, PropertyButton button){
		double cost = button.getPrice();
		int counter = 0;
		while(cost<currentMoney){
			cost = cost*1.08;
			counter++;
		}
		return counter;
	}

	public void createAmountButtons(){
		one = new AmountButton(800, 40, 100, 50, " x1", new Color(255,255,0), new Action(){

			public void act() {
				// TODO Auto-generated method stub

				if(button1Disabled == true){
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
				if(button2Disabled == true){
					System.out.println("button 2 is " + button2Disabled);
					return;
				}
				else{
					System.out.println("klegjielg");
					button1Disabled = !button1Disabled;
					button2Disabled = !button2Disabled;
					moveToBack(xNumButton2);
					moveToBack(xNumButton2);
					moveToBack(background);
					moveToBack(background);
				}
			}
		}, 10, false);
		hundred = new AmountButton(793, 45, 100, 50, " x100", new Color(255,255,0), new Action(){


			public void act() {
				// TODO Auto-generated method stub
				if(button3Disabled == true){
					System.out.println("button 3 is " + button3Disabled);
					return;
				}
				else{
					System.out.println("rtyeryer");
					button2Disabled = !button2Disabled;
					button3Disabled = !button3Disabled;
					moveToBack(xNumButton3);
					moveToBack(xNumButton3);
					moveToBack(background);
					moveToBack(background);
				}
			}
		}, 100, false);
	}

	



	public double projectedMaxPrice(int max,  PropertyButton button){
		return button.getPrice()*Math.pow(1.08, max);
	}
	//amount button 900 50
	//
	public void generateButtons(){
		lemon = new PropertyButton(0,0,200,50,"Buy x"+one.getAmount()+"  $4.00", Color.orange, new Action(){
			public void act(){
				priceScaling(lemon);
			}
		}, 4, 1, 1.07 );
		newspaper = new PropertyButton(0,0,200,50,"Buy x"+one.getAmount()+"  $69.00", Color.orange, new Action(){
			public void act(){
				priceScaling(newspaper);
			}
		}, 4, 1, 1.15 );
		car = new PropertyButton(0,0,200,50,"Buy x"+one.getAmount()+"  $4", Color.orange, new Action(){
			public void act(){
				priceScaling(car);
			}
		}, 4, 1, 1.14 );
		pizza = new PropertyButton(0,0,200,50,"Buy x"+one.getAmount()+"  $4", Color.orange, new Action(){
			public void act(){
				priceScaling(pizza);
			}
		}, 4, 1, 1.13 );
		donut = new PropertyButton(0,0,200,50,"Buy x"+one.getAmount()+"  $4", Color.orange, new Action(){
			public void act(){
				priceScaling(donut);
			}
		}, 4, 1, 1.12 );
		shrimp = new PropertyButton(0,0,200,50,"Buy x"+one.getAmount()+"  $4", Color.orange, new Action(){
			public void act(){
				priceScaling(shrimp);			
			}
		}, 4, 1, 1.11 );
		hockey = new PropertyButton(0,0,200,50,"Buy x"+one.getAmount()+"  $4", Color.orange, new Action(){
			public void act(){
				priceScaling(hockey);			
			}
		}, 4, 1, 1.10 );
		movie = new PropertyButton(0,0,200,50,"Buy x"+one.getAmount()+"  $27.604 billion", Color.orange, new Action(){
			public void act(){
				priceScaling(movie);			
			}
		}, 4, 1, 1.09 );

	}

}
