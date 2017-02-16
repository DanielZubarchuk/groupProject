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

	private void priceScaling(PropertyButton button){
		double newPrice = Math.pow(1.08, one.getAmount())*button.getPrice();
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
		
		lemon = new PropertyButton(220,180,200,50,"Buy x"+one.getAmount()+"  $4.00", Color.ORANGE, new Action(){
			public void act(){
				if(lemon.getPrice()<=playerMoney){
					quantityOwned[0]+=one.getAmount();
					playerMoney -= lemon.getPrice();
					buyText.setText("$"+playerMoney);
					priceScaling(lemon);
					lemon.setText("Buy x"+one.getAmount()+"  $"+lemon.getPrice());
				}
			}
		}, 4, 1, 1.07, 1000 );
		
		newspaper = new PropertyButton(720,180,200,50,"Buy x"+one.getAmount()+"  $60.00", Color.ORANGE, new Action(){
			public void act(){
				if(newspaper.getPrice()<=playerMoney){
					quantityOwned[1]+=one.getAmount();
					playerMoney -= newspaper.getPrice();
					buyText.setText("$"+playerMoney);
					priceScaling(newspaper);
					newspaper.setText("Buy x"+one.getAmount()+"  $"+newspaper.getPrice());
				}					
			}
		}, 60, 60, 1.15, 2000);
		
		car = new PropertyButton(220,280,200,50,"Buy x"+one.getAmount()+"  $720.00", Color.ORANGE, new Action(){
			public void act(){
				if(car.getPrice()<=playerMoney){
					quantityOwned[2]+=one.getAmount();
					playerMoney -= car.getPrice();
					buyText.setText("$"+playerMoney);
					priceScaling(car);
					car.setText("Buy x"+one.getAmount()+"  $"+car.getPrice());
				}
			}
		}, 720, 540, 1.14, 3000 );
		
		pizza = new PropertyButton(720,280,200,50,"Buy x"+one.getAmount()+"  $8,640.00", Color.ORANGE, new Action(){
			public void act(){
				if(pizza.getPrice()<=playerMoney){
					quantityOwned[3]+=one.getAmount();
					playerMoney -= pizza.getPrice();
					buyText.setText("$"+playerMoney);
					priceScaling(pizza);
					pizza.setText("Buy x"+one.getAmount()+"  $"+pizza.getPrice());
				}
			}
		}, 8640, 4320, 1.13, 5000 );
		
		donut = new PropertyButton(220,380,200,50,"Buy x"+one.getAmount()+"  $103,680.00", Color.ORANGE, new Action(){
			public void act(){
				if(donut.getPrice()<=playerMoney){
					quantityOwned[4]+=one.getAmount();
					playerMoney -= donut.getPrice();
					buyText.setText("$"+playerMoney);
					priceScaling(donut);
					donut.setText("Buy x"+one.getAmount()+"  $"+donut.getPrice());
				}
			}
		}, 103680, 51840, 1.12, 12000 );
		
		shrimp = new PropertyButton(720,380,200,50,"Buy x"+one.getAmount()+"  $1.244 mill", Color.ORANGE, new Action(){
			public void act(){
				if(shrimp.getPrice()<=playerMoney){
					quantityOwned[5]+=one.getAmount();
					playerMoney -= shrimp.getPrice();
					buyText.setText("$"+playerMoney);
					priceScaling(shrimp);	
					shrimp.setText("Buy x"+one.getAmount()+"  $"+shrimp.getPrice());		
				}
			}
		}, 1244000, 622080, 1.11, 47000 );
		
		hockey = new PropertyButton(220,480,200,50,"Buy x"+one.getAmount()+"  $14.929 mill", Color.ORANGE, new Action(){
			public void act(){
				if(hockey.getPrice()<=playerMoney){
					quantityOwned[6]+=one.getAmount();
					playerMoney -= hockey.getPrice();
					buyText.setText("$"+playerMoney);
					priceScaling(hockey);		
					hockey.setText("Buy x"+one.getAmount()+"  $"+hockey.getPrice());	
				}
			}
		}, 14929000, 7464000, 1.10, 192000 );
		
		movie = new PropertyButton(720,480,200,50,"Buy x"+one.getAmount()+"  $179.159 mill", Color.ORANGE, new Action(){
			public void act(){
				if(movie.getPrice()<=playerMoney){
					quantityOwned[7]+=one.getAmount();
					playerMoney -= movie.getPrice();
					buyText.update();
					priceScaling(movie);		
					movie.setText("Buy x"+one.getAmount()+"  $"+movie.getPrice());	
				}
			}
		}, 179159000, 89579000, 1.09, 768000 );
		

	}
	
	public void generateMoneyButtons(){
		Button lemonMoney = new Button(10, 180, 150, 40, "Make Money!", new Color(255,255,0), new Action(){

			public void act(){
				Statistics.currentBalance += lemon.getPayout() * quantityOwned[0];
				buyText.setText("$"+Statistics.currentBalance);
			}
		});
		Button newspaperMoney = new Button(510, 180, 150, 40, "Make Money!", new Color(255,255,0), new Action(){
			public void act(){
				Statistics.currentBalance += newspaper.getPayout() * quantityOwned[1];
				buyText.setText("$"+Statistics.currentBalance);
			}
		});
		Button carMoney = new Button(10, 280, 150, 40, "Make Money!", new Color(255,255,0), new Action(){
			public void act(){
				Statistics.currentBalance+=car.getPayout() * quantityOwned[2];
				buyText.setText("$"+Statistics.currentBalance);
			}
		});
		Button pizzaMoney = new Button(510, 280, 150, 40, "Make Money!", new Color(255,255,0), new Action(){
			public void act(){
				Statistics.currentBalance += pizza.getPayout() * quantityOwned[3];
				buyText.setText("$"+Statistics.currentBalance);			
			}
		});
		Button donutMoney = new Button(10, 380, 150, 40, "Make Money!", new Color(255,255,0), new Action(){
			public void act(){
				Statistics.currentBalance += donut.getPayout() * quantityOwned[4];
				buyText.setText("$"+Statistics.currentBalance);
			}
		});
		Button shrimpMoney = new Button(510, 380, 150, 40, "Make Money!", new Color(255,255,0), new Action(){
			public void act(){
				Statistics.currentBalance += shrimp.getPayout() * quantityOwned[5];
				buyText.setText("$"+Statistics.currentBalance);		
			}
		});
		Button hockeyMoney = new Button(10, 480, 150, 40, "Make Money!", new Color(255,255,0), new Action(){
			public void act(){
				Statistics.currentBalance += hockey.getPayout() * quantityOwned[6];
				buyText.setText("$"+Statistics.currentBalance);
			}
		});
		Button movieMoney = new Button(510, 480, 150, 40, "Make Money!", new Color(255,255,0), new Action(){
			public void act(){
				Statistics.currentBalance += movie.getPayout() * quantityOwned[7];
				buyText.setText("$"+Statistics.currentBalance);
			}
		});
		
	}

}
