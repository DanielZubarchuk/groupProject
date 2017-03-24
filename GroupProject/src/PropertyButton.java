/**
 * @author Joey
 */

import java.awt.Color;

import guiPractice8.component.Actions;
import guiPractice8.component.Buttonssss;

public class PropertyButton extends Buttonssss implements PropertyButtonInterface{
	 
	private int quantity;
	private double price;
	private double payout;
	private double rate;
	private double time;
	private boolean active;
	//private int time;
	
	public PropertyButton(int x, int y, int w, int h, String text, Color color, Actions action, double price, double payout, double rate, double time) {
		super(x, y, w, h, text, color, action);
		this.price = price;
		this.payout = payout;
		this.rate = rate;
		this.time = time;
		// TODO Auto-generated constructor stub
	}
	
	public boolean isClicked() {
		return false;
	}
	
	public void setPrice(double x){
		this.price = x;
	}
	
	public void setPayout(double x){
		this.payout = x;
	}
	
	public void activeSwap(){
		active = !active;
	}
	
	
	
	
	
	
	public double getPrice(){
		return price;
	}
	public double getRate(){
		return rate;
	}
	public double getTime(){
		return time;
	}
	public double getPayout(){
		return payout;
	}

	public boolean isNotActive() {
		// TODO Auto-generated method stub
		return !active;
	}


}
