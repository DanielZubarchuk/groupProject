import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import Demos.RichardDemo;
import guiPractice8.component.Action;
import guiPractice8.component.Button;

public class JoeyOperation{
	private static ArrayList<AmountButtonInterface> amountButtons;
	private static PropertyButton lemon;
	private static PropertyButton newspaper;
	private static PropertyButton car;
	private static PropertyButton pizza;
	private static PropertyButton donut;
	private static PropertyButton shrimp;
	private static PropertyButton hockey;
	private static PropertyButton movie;

	private static Button lemonMoney;
	private static Button newspaperMoney;
	private static Button carMoney;
	private static Button pizzaMoney;
	private static Button donutMoney;
	private static Button shrimpMoney;
	private static Button hockeyMoney;
	private static Button movieMoney;
	

	public static ArrayList<PropertyButtonInterface> properties;
	private static ManagerButton lemonManager;
	private static ManagerButton newspaperManager;
	private static ManagerButton carManager;
	private static ManagerButton pizzaManager;
	private static ManagerButton donutManager;
	private static ManagerButton shrimpManager;
	private static ManagerButton hockeyManager;
	private static ManagerButton movieManager;



	private int[] numbers;
	private int theButton = 0;


	private boolean canBuy(int userMoney, int cost){
		return userMoney>cost;
	}

	private static void priceScaling(PropertyButton button){
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
	
	
	
	
	
	
	
	
	public static ArrayList<PropertyButtonInterface> generateButtons(){
		
		lemon = new PropertyButton(220,180,200,50,"Buy x"+RichardDemo.getCurrentAmount()+"  $4.00", Color.ORANGE, new Action(){
			public void act(){
				if(lemon.getPrice()<=Statistics.getMoney()){
					double money = Statistics.getMoney();
					int[] qtyOwned = Statistics.getQuantityArray();
					Statistics.setQuantityArray(0, qtyOwned[0]+=RichardDemo.getCurrentAmount());
					money -= lemon.getPrice();
					AdventureCapScreen.AdvCapDemo.setMoneyText("$"+money);
					priceScaling(lemon);
					lemon.setText("Buy x"+AdventureCapScreen.AdvCapDemo.getCurrentAmount()+"  $"+lemon.getPrice());
					Statistics.setMoney(money);
				}
			}
		}, 4, 1, 1.07, 1000);
		
		newspaper = new PropertyButton(720,180,200,50,"Buy x"+RichardDemo.getCurrentAmount()+"  $60.00", Color.ORANGE, new Action(){
			public void act(){
				if(newspaper.getPrice()<=Statistics.getMoney()){
					double money = Statistics.getMoney();
					int[] qtyOwned = Statistics.getQuantityArray();
					Statistics.setQuantityArray(0, qtyOwned[0]+=RichardDemo.getCurrentAmount());
					money -= newspaper.getPrice();
					AdventureCapScreen.AdvCapDemo.setMoneyText("$"+money);
					priceScaling(newspaper);
					newspaper.setText("Buy x"+AdventureCapScreen.AdvCapDemo.getCurrentAmount()+"  $"+newspaper.getPrice());
					Statistics.setMoney(money);
				}					
			}
		}, 60, 60, 1.15, 2000);
		
		car = new PropertyButton(220,280,200,50,"Buy x"+RichardDemo.getCurrentAmount()+"  $720.00", Color.ORANGE, new Action(){
			public void act(){
				if(car.getPrice()<=Statistics.getMoney()){
					double money = Statistics.getMoney();
					int[] qtyOwned = Statistics.getQuantityArray();
					Statistics.setQuantityArray(0, qtyOwned[0]+=RichardDemo.getCurrentAmount());
					money -= car.getPrice();
					AdventureCapScreen.AdvCapDemo.setMoneyText("$"+money);
					priceScaling(car);
					car.setText("Buy x"+AdventureCapScreen.AdvCapDemo.getCurrentAmount()+"  $"+car.getPrice());
					Statistics.setMoney(money);
				}
			}
		}, 720, 540, 1.14, 3000);
		
		pizza = new PropertyButton(720,280,200,50,"Buy x"+RichardDemo.getCurrentAmount()+"  $8,640.00", Color.ORANGE, new Action(){
			public void act(){
				if(pizza.getPrice()<=Statistics.getMoney()){
					double money = Statistics.getMoney();
					int[] qtyOwned = Statistics.getQuantityArray();
					Statistics.setQuantityArray(0, qtyOwned[0]+=RichardDemo.getCurrentAmount());
					money -= pizza.getPrice();
					AdventureCapScreen.AdvCapDemo.setMoneyText("$"+money);
					priceScaling(pizza);
					pizza.setText("Buy x"+AdventureCapScreen.AdvCapDemo.getCurrentAmount()+"  $"+pizza.getPrice());
					Statistics.setMoney(money);
				}
			}
		}, 8640, 4320, 1.13, 5000);
		
		donut = new PropertyButton(220,380,200,50,"Buy x"+RichardDemo.getCurrentAmount()+"  $103,680.00", Color.ORANGE, new Action(){
			public void act(){
				if(donut.getPrice()<=Statistics.getMoney()){
					double money = Statistics.getMoney();
					int[] qtyOwned = Statistics.getQuantityArray();
					Statistics.setQuantityArray(0, qtyOwned[0]+=RichardDemo.getCurrentAmount());
					money -= donut.getPrice();
					AdventureCapScreen.AdvCapDemo.setMoneyText("$"+money);
					priceScaling(donut);
					donut.setText("Buy x"+AdventureCapScreen.AdvCapDemo.getCurrentAmount()+"  $"+donut.getPrice());
					Statistics.setMoney(money);
				}
			}
		}, 103680, 51840, 1.12, 12000);
		
		shrimp = new PropertyButton(720,380,200,50,"Buy x"+RichardDemo.getCurrentAmount()+"  $1.244 mill", Color.ORANGE, new Action(){
			public void act(){
				if(shrimp.getPrice()<=Statistics.getMoney()){
					double money = Statistics.getMoney();
					int[] qtyOwned = Statistics.getQuantityArray();
					Statistics.setQuantityArray(0, qtyOwned[0]+=RichardDemo.getCurrentAmount());
					money -= shrimp.getPrice();
					AdventureCapScreen.AdvCapDemo.setMoneyText("$"+money);
					priceScaling(shrimp);	
					shrimp.setText("Buy x"+AdventureCapScreen.AdvCapDemo.getCurrentAmount()+"  $"+shrimp.getPrice());		
					Statistics.setMoney(money);
				}
			}
		}, 1244000, 622080, 1.11, 47000 );
		
		hockey = new PropertyButton(220,480,200,50,"Buy x"+RichardDemo.getCurrentAmount()+"  $14.929 mill", Color.ORANGE, new Action(){
			public void act(){
				if(hockey.getPrice()<=Statistics.getMoney()){
					double money = Statistics.getMoney();
					int[] qtyOwned = Statistics.getQuantityArray();
					Statistics.setQuantityArray(0, qtyOwned[0]+=RichardDemo.getCurrentAmount());
					money -= hockey.getPrice();
					AdventureCapScreen.AdvCapDemo.setMoneyText("$"+money);
					priceScaling(hockey);		
					hockey.setText("Buy x"+AdventureCapScreen.AdvCapDemo.getCurrentAmount()+"  $"+hockey.getPrice());	
					Statistics.setMoney(money);
					History.updateHistory(6, "Hockey Stadium");
				}
			}
		}, 14929000, 7464000, 1.10, 192000);
		
		movie = new PropertyButton(720,480,200,50,"Buy x"+RichardDemo.getCurrentAmount()+"  $179.159 mill", Color.ORANGE, new Action(){
			public void act(){
				if(movie.getPrice()<=Statistics.getMoney()){
					double money = Statistics.getMoney();
					int[] qtyOwned = Statistics.getQuantityArray();
					Statistics.setQuantityArray(0, qtyOwned[0]+=RichardDemo.getCurrentAmount());
					money -= movie.getPrice();
					AdventureCapScreen.AdvCapDemo.setMoneyText("$"+money);
					priceScaling(movie);		
					movie.setText("Buy x"+AdventureCapScreen.AdvCapDemo.getCurrentAmount()+"  $"+movie.getPrice());	
					Statistics.setMoney(money);
				}
			}
		}, 179159000, 89579000, 1.09, 768000);
		
		properties = new ArrayList<PropertyButtonInterface>();
		properties.add(lemon);
		properties.add(newspaper);
		properties.add(car);
		properties.add(pizza);
		properties.add(donut);
		properties.add(shrimp);
		properties.add(hockey);
		properties.add(movie);
		
		
		
		
		return properties;
		

	}
	
	
	
	
	
	
	
	
	
	
	
	
	public static ArrayList<Button> managers(){
			lemonManager = new ManagerButton(220, 130, 200, 40, "Manage $100", new Color(255,255,0), new Action(){
				public void act(){
					if(Statistics.getMoney()>=lemonManager.getPricexd()){
						lemonMoney.setEnabled(false);
						AdventureCapScreen.AdvCapDemo.viewObjects.remove(lemonManager);
						boolean x = true;
						while(x){							
						lemonMoney.act();
						}
					}
				}
			},100);
			newspaperManager = new ManagerButton(720, 130, 200, 40, "Manage $1000", new Color(255,255,0), new Action(){
				public void act(){
					if(Statistics.getMoney()>=newspaperManager.getPricexd()){
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
					if(Statistics.getMoney()>=carManager.getPricexd()){
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
					if(Statistics.getMoney()>=pizzaManager.getPricexd()){
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
					if(Statistics.getMoney()>=donutManager.getPricexd()){
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
					if(Statistics.getMoney()>=shrimpManager.getPricexd()){
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
					if(Statistics.getMoney()>=hockeyManager.getPricexd()){
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
					if(Statistics.getMoney()>=movieManager.getPricexd()){
						movieMoney.setEnabled(false);
						AdvCapDemo.viewObjects.remove(movieManager);	
						boolean x = true;
						while(x){							
						movieMoney.act();
						}
					}
				}
			},1000000000);
			return null;
		}
	
	
	
	
	
	
	
	
	
	
	
	
	public static ArrayList<Button> generateMoneyButtons(){
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
		ArrayList<Button> buttonsList = new ArrayList<Button>();
		buttonsList.add(lemonMoney);
		buttonsList.add(newspaperMoney);
		buttonsList.add(carMoney);
		buttonsList.add(pizzaMoney);
		buttonsList.add(donutMoney);
		buttonsList.add(shrimpMoney);
		buttonsList.add(hockeyMoney);
		buttonsList.add(movieMoney);
		
		return buttonsList;
	}
	
	protected static void doButtonAction(Button buyButton, PropertyButton property, int number) {

		Thread actionToDo = new Thread(new Runnable(){

			@Override
			public void run() {
				buyButton.setEnabled(false);
				try{
					Thread.sleep((long) property.getTime());
				}catch(InterruptedException e){
					e.printStackTrace();
				}
				double money = Statistics.getMoney();
				int[]qtyOwned = Statistics.getQuantityArray();
				money += property.getPayout() * qtyOwned[0];
				money = roundNumber(money);
				AdventureCapScreen.AdvCapDemo.setMoneyText("$"+money);
				buyButton.setEnabled(true);
			}

		});
		actionToDo.start();

	}
	public static double roundNumber(double amount){
		double newNumber = (((int)(amount*100))/100.00);
		return newNumber;
	}
	
}
