import java.awt.Color;

import guiPractice8.component.Action;
import guiPractice8.component.Button;

public class AmountButton extends Button implements AmountButtonInterface {
	private int amount;
	public AmountButton(int x, int y, int w, int h, String text, Color color, Action action, int amount) {
		super(x, y, w, h, text, color, action);
		this.amount = amount;
		// TODO Auto-generated constructor stub
	}

	@Override
	public int getAmount() {
		// TODO Auto-generated method stub
		return amount;
	}

}
