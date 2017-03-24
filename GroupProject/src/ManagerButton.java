import java.awt.Color;

import guiPratice.components.Action;
import guiPratice.components.Button;

public class ManagerButton extends Button {

	private int price;

	public ManagerButton(int x, int y, int w, int h, String text, Color color, guiPratice.components.Action action, int price) {
		super(x, y, w, h, text, color, action);
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
