package stockMarket;

import java.awt.Graphics2D;
import java.util.ArrayList;

import guiPractice8.Screen;
import guiPractice8.component.ClickableGraphic;
import guiPractice8.component.Visible;

public class StockMenu extends Screen {
	
	private ClickableGraphic buttons;
	//these fields are for the different parts of the menu that display info about the game.
	//numbers are not accurate as of now. 
	private static final int logoHeight = 50;
	private static final int logoWidth = 50;
	private static final int turnHeight = 20;
	private static final int turnWidth = 60;
	private static final int eventHeight = 50;
	private static final int eventWidth = 100;
	private static final int stocksHeight = 100;
	private static final int stocksWidth = 100;

	public StockMenu(int width, int height) {
		super(width, height);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void initObjects(ArrayList<Visible> clickableObjects) {
		// TODO Auto-generated method stub

	}
	
	public void update(Graphics2D g) {
	
	
	}

}
