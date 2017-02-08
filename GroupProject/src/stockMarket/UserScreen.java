package stockMarket;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import guiPractice8.component.Action;
import guiPractice8.component.Button;
import guiPractice8.component.ClickableScreen;
import guiPractice8.component.Visible;

public class UserScreen extends ClickableScreen{

	public static ArrayList<StockInterface> stocks;
	public static ArrayList<TransactionInterface> transactions;
	public static double balance;
	
	private Button backButton;
	
	public UserScreen(int width, int height) {
		super(width, height);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		backButton = new Button(0, 0, 0, 0, "back", Color.green, new Action(){

			@Override
			public void act() {
				
			}
			
		});
		
		viewObjects.add(backButton);
		
	}
	
	

}
