import java.awt.Color;

import guiPractice8.component.Action;
import guiPractice8.component.Button;

public class PropertyButton extends Button{
	
	private int price;
	private int payout;
	
	public PropertyButton(int x, int y, int w, int h, String text, Color color, Action action, int price, int payout) {
		super(x, y, w, h, text, color, action);
		this.price = price;
		this.payout = payout;
		// TODO Auto-generated constructor stub
	}
	
	public int getPrice(){
		return price;
	}
	
	public int getPayout(){
		return payout;
	}
	
	
	

}
