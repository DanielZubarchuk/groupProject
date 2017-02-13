import java.awt.Color;

import guiPractice8.component.Action;
import guiPractice8.component.Button;

public class AmountButton extends Button implements AmountButtonInterface {
	private int amount;
	private boolean showing;
	public AmountButton(int x, int y, int w, int h, String text, Color color, Action action, int amount, boolean showing) {
		super(x, y, w, h, text, color, action);
		this.amount = amount;
		this.showing = showing;
		// TODO Auto-generated constructor stub
	}

	@Override
	public int getAmount() {
		// TODO Auto-generated method stub
		return amount;
	}

	@Override
	public boolean isShowing() {
		// TODO Auto-generated method stub
		return showing;
	}

}
