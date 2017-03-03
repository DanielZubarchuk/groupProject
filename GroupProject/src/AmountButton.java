import java.awt.Color;

import guiPractice8.component.Action;
import guiPractice8.component.Button;
/**
 * @author Joey
 */

public class AmountButton extends Button {
	private int amount;
	private boolean showing;
	public AmountButton(int x, int y, int w, int h, String text, Color color, Action action, int amount, boolean showing) {
		super(x, y, w, h, text, color, action);
		this.amount = amount;
		this.showing = showing;
		// TODO Auto-generated constructor stub
	}

	public int getAmount() {
		// TODO Auto-generated method stub
		return amount;
	}

	public boolean isShowing() {
		// TODO Auto-generated method stub
		return showing;
	}
	
	public void setFalse(){
		showing = false;
	}
	public void setTrue(){
		showing = true;
	}

}
