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
		}, 4, 1, 1.07, 1000 );
		newspaper = new PropertyButton(0,0,200,50,"Buy x"+one.getAmount()+"  $60.00", Color.orange, new Action(){
			public void act(){
				priceScaling(newspaper);
			}
		}, 60, 60, 1.15, 2000);
		car = new PropertyButton(0,0,200,50,"Buy x"+one.getAmount()+"  $720.00", Color.orange, new Action(){
			public void act(){
				priceScaling(car);
			}
		}, 720, 540, 1.14, 3000 );
		pizza = new PropertyButton(0,0,200,50,"Buy x"+one.getAmount()+"  $8,640.00", Color.orange, new Action(){
			public void act(){
				priceScaling(pizza);
			}
		}, 8640, 4320, 1.13, 5000 );
		donut = new PropertyButton(0,0,200,50,"Buy x"+one.getAmount()+"  $103,680.00", Color.orange, new Action(){
			public void act(){
				priceScaling(donut);
			}
		}, 103680, 51840, 1.12, 12000 );
		shrimp = new PropertyButton(0,0,200,50,"Buy x"+one.getAmount()+"  $1.244 million", Color.orange, new Action(){
			public void act(){
				priceScaling(shrimp);			
			}
		}, 1244000, 622080, 1.11, 47000 );
		hockey = new PropertyButton(0,0,200,50,"Buy x"+one.getAmount()+"  $14.929 million", Color.orange, new Action(){
			public void act(){
				priceScaling(hockey);			
			}
		}, 14929000, 7464000, 1.10, 192000 );
		movie = new PropertyButton(0,0,200,50,"Buy x"+one.getAmount()+"  $179.159 million", Color.orange, new Action(){
			public void act(){
				priceScaling(movie);			
			}
		}, 179159000, 89579000, 1.09, 768000 );

	}

}
