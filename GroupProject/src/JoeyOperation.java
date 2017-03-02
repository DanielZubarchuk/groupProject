import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import guiPractice8.component.Action;
import guiPractice8.component.Button;

public class JoeyOperation implements JoeyOperationInterface{
	private static ArrayList<AmountButtonInterface> amountButtons;
	private static PropertyButton lemon;
	private static PropertyButton newspaper;
	private static PropertyButton car;
	private static PropertyButton pizza;
	private static PropertyButton donut;
	private static PropertyButton shrimp;
	private static PropertyButton hockey;
	private static PropertyButton movie;


	public static ArrayList<AmountButton> amountButtonList;



	private int[] numbers;
	private int theButton = 0;

	public static ArrayList<PropertyButton> properties;

	private boolean canBuy(int userMoney, int cost){
		return userMoney>cost;
	}

	private void priceScaling(PropertyButton button){
		double newPrice = Math.pow(1.08, RichardDemo.getCurrentAmount())*button.getPrice();
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
	
	public AmountButton currentAmount(){
		return amountButtonList.get(theButton );
	}
	
	public int getCurrentAmount(){
		return 0;
	}
	
	public void generateButtons(){
		
		lemon = new PropertyButton(220,180,200,50,"Buy x"+one.getAmount()+"  $4.00", Color.ORANGE, new Action(){
			public void act(){
				if(lemon.getPrice()<=Statistics.getMoney()){
					quantityOwned[0]+=getCurrentAmount();
					playerMoney -= lemon.getPrice();
					buyText.setText("$"+playerMoney);
					priceScaling(lemon);
					lemon.setText("Buy x"+RichardDemo.getCurrentAmount()+"  $"+lemon.getPrice());
				}
			}
		}, 4, 1, 1.07, 1000, false );
		
		newspaper = new PropertyButton(720,180,200,50,"Buy x"+one.getAmount()+"  $60.00", Color.ORANGE, new Action(){
			public void act(){
				if(newspaper.getPrice()<=playerMoney){
					quantityOwned[1]+=RichardDemo.getCurrentAmount();
					playerMoney -= newspaper.getPrice();
					buyText.setText("$"+playerMoney);
					priceScaling(newspaper);
					newspaper.setText("Buy x"+RichardDemo.getCurrentAmount()+"  $"+newspaper.getPrice());
				}					
			}
		}, 60, 60, 1.15, 2000, false);
		
		car = new PropertyButton(220,280,200,50,"Buy x"+one.getAmount()+"  $720.00", Color.ORANGE, new Action(){
			public void act(){
				if(car.getPrice()<=playerMoney){
					quantityOwned[2]+=RichardDemo.getCurrentAmount();
					playerMoney -= car.getPrice();
					buyText.setText("$"+playerMoney);
					priceScaling(car);
					car.setText("Buy x"+RichardDemo.getCurrentAmount()+"  $"+car.getPrice());
				}
			}
		}, 720, 540, 1.14, 3000, false );
		
		pizza = new PropertyButton(720,280,200,50,"Buy x"+RichardDemo.getCurrentAmount()+"  $8,640.00", Color.ORANGE, new Action(){
			public void act(){
				if(pizza.getPrice()<=playerMoney){
					quantityOwned[3]+=RichardDemo.getCurrentAmount();
					playerMoney -= pizza.getPrice();
					buyText.setText("$"+playerMoney);
					priceScaling(pizza);
					pizza.setText("Buy x"+RichardDemo.getCurrentAmount()+"  $"+pizza.getPrice());
				}
			}
		}, 8640, 4320, 1.13, 5000, false );
		
		donut = new PropertyButton(220,380,200,50,"Buy x"+RichardDemo.getCurrentAmount()+"  $103,680.00", Color.ORANGE, new Action(){
			public void act(){
				if(donut.getPrice()<=playerMoney){
					quantityOwned[4]+=RichardDemo.getCurrentAmount();
					playerMoney -= donut.getPrice();
					buyText.setText("$"+playerMoney);
					priceScaling(donut);
					donut.setText("Buy x"+RichardDemo.getCurrentAmount()+"  $"+donut.getPrice());
				}
			}
		}, 103680, 51840, 1.12, 12000, false );
		
		shrimp = new PropertyButton(720,380,200,50,"Buy x"+RichardDemo.getCurrentAmount()+"  $1.244 mill", Color.ORANGE, new Action(){
			public void act(){
				if(shrimp.getPrice()<=playerMoney){
					quantityOwned[5]+=RichardDemo.getCurrentAmount();
					playerMoney -= shrimp.getPrice();
					buyText.setText("$"+playerMoney);
					priceScaling(shrimp);	
					shrimp.setText("Buy x"+RichardDemo.getCurrentAmount()+"  $"+shrimp.getPrice());		
				}
			}
		}, 1244000, 622080, 1.11, 47000, false );
		
		hockey = new PropertyButton(220,480,200,50,"Buy x"+RichardDemo.getCurrentAmount()+"  $14.929 mill", Color.ORANGE, new Action(){
			public void act(){
				if(hockey.getPrice()<=playerMoney){
					quantityOwned[6]+=RichardDemo.getCurrentAmount();
					playerMoney -= hockey.getPrice();
					buyText.setText("$"+playerMoney);
					priceScaling(hockey);		
					hockey.setText("Buy x"+RichardDemo.getCurrentAmount()+"  $"+hockey.getPrice());	
				}
			}
		}, 14929000, 7464000, 1.10, 192000, false );
		
		movie = new PropertyButton(720,480,200,50,"Buy x"+RichardDemo.getCurrentAmount()+"  $179.159 mill", Color.ORANGE, new Action(){
			public void act(){
				if(movie.getPrice()<=playerMoney){
					quantityOwned[7]+=RichardDemo.getCurrentAmount();
					playerMoney -= movie.getPrice();
					buyText.update();
					priceScaling(movie);		
					movie.setText("Buy x"+RichardDemo.getCurrentAmount()+"  $"+movie.getPrice());	
				}
			}
		}, 179159000, 89579000, 1.09, 768000, false );
		

	}
	
	public void generateMoneyButtons(){
		Button lemonMoney = new Button(10, 180, 150, 40, "Make Money!", new Color(255,255,0), new Action(){

			public void act(){
				double money = Statistics.getMoney();
				money += lemon.getPayout() * quantityOwned[0];
				buyText.setText("$"+money);
				Statistics.setMoney(money);
			}
		});
		Button newspaperMoney = new Button(510, 180, 150, 40, "Make Money!", new Color(255,255,0), new Action(){
			public void act(){
				double money = Statistics.getMoney();
				money += newspaper.getPayout() * quantityOwned[1];
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

	@Override
	public String getProperty() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getQuantity() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getPrice() {
		// TODO Auto-generated method stub
		return 0;
	}

}
