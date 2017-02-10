package stockMarket;

import java.awt.Color;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

import guiPractice8.component.Action;
import guiPractice8.component.Button;
import guiPractice8.component.ClickableScreen;
import guiPractice8.component.Visible;
import stackInterfaces.RisaInterface;

public class UserScreen extends ClickableScreen{

	public static ArrayList<String> currentStocks;
	public static ArrayList<RisaInterface> prevTransactions;
	public static double balance;
	
	private Button backButton;
	
	public UserScreen(int width, int height) {
		super(width, height);
	}

	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		backButton = new Button(0, 0, 0, 0, "back", Color.green, new Action(){

			@Override
			public void act() {
				//StockMenu.game.setScreen(StockMenu.coordScreen);
			}
			
		});
		
		viewObjects.add(backButton);
		
	}
	
	public void addTransaction(){
		currentStocks.add();
	}

}
