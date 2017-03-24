import java.awt.Color;

import guiPractice8.component.Actions;
import guiPractice8.component.Buttonssss;

public class ManagerButton extends Buttonssss {

	private int price;

	public ManagerButton(int x, int y, int w, int h, String text, Color color, Actions actions, int price) {
		super(x, y, w, h, text, color, actions);
		this.price = price;
		// TODO Auto-generated constructor stub
	}
	
	public int getPricexd(){
		return price;
	}
	public void setPrice(int price){
		this.price = price;
	}
	
}
