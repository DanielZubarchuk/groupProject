import java.awt.Color;

import guiPractice8.component.Action;
import guiPractice8.component.Button;

public class PropertyButton extends Button implements PropertyButtonInterface{
	 
	private int quantity;
	private double price;
	private double payout;
	private int level;
	//private int time;
	
	public PropertyButton(int x, int y, int w, int h, String text, Color color, Action action, double price, double payout) {
		super(x, y, w, h, text, color, action);
		this.price = price;
		this.payout = payout;
		// TODO Auto-generated constructor stub
	}
	
	public boolean isClicked() {
		return false;
	}
	
	public void setQuantity(int x) {
		this.quantity = x;
	}
	
	public void setPrice(double x){
		this.price = x;
	}
	
	public void setPayout(double x){
		this.payout = x;
	}

	public void setLevel(int x) {
		this.level = x;
	}
	
	public int getQuantity() {
		return quantity;
	}
	
	public double getPrice(){
		return price;
	}
	
	public double getPayout(){
		return payout;
	}

	public int getLevel() {
		return level;
	}	

}
