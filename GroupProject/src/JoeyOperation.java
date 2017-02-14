import java.awt.Color;
import java.util.ArrayList;

import guiPractice8.component.Action;

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
		}, 4, 1 );
		newspaper = new PropertyButton(0,0,200,50,"Buy x"+one.getAmount()+"  $69.00", Color.orange, new Action(){
			public void act(){
				priceScaling(newspaper);
			}
		}, 4, 1 );
		car = new PropertyButton(0,0,200,50,"Buy x"+one.getAmount()+"  $4", Color.orange, new Action(){
			public void act(){
				priceScaling(car);
			}
		}, 4, 1 );
		pizza = new PropertyButton(0,0,200,50,"Buy x"+one.getAmount()+"  $4", Color.orange, new Action(){
			public void act(){
				priceScaling(pizza);
			}
		}, 4, 1 );
		donut = new PropertyButton(0,0,200,50,"Buy x"+one.getAmount()+"  $4", Color.orange, new Action(){
			public void act(){
				priceScaling(donut);
			}
		}, 4, 1 );
		shrimp = new PropertyButton(0,0,200,50,"Buy x"+one.getAmount()+"  $4", Color.orange, new Action(){
			public void act(){
				priceScaling(shrimp);			
			}
		}, 4, 1 );
		hockey = new PropertyButton(0,0,200,50,"Buy x"+one.getAmount()+"  $4", Color.orange, new Action(){
			public void act(){
				priceScaling(hockey);			
			}
		}, 4, 1 );
		movie = new PropertyButton(0,0,200,50,"Buy x"+one.getAmount()+"  $4", Color.orange, new Action(){
			public void act(){
				priceScaling(movie);			
			}
		}, 4, 1 );

	}

}
