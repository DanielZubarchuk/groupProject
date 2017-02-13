package stockMarket;

import java.awt.Color;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

import guiPractice8.component.Action;
import guiPractice8.component.Button;
import guiPractice8.component.ClickableScreen;
import guiPractice8.component.Visible;
import projectComponents.ThemedTextLabel;
import stackInterfaces.DanielInterface;
import stackInterfaces.StockInterface;

public class UserScreen extends ClickableScreen implements DanielInterface{

	public UserScreen(int width, int height) {
		super(width, height);
	}

	public static ArrayList<String> currentStocks;
	public static ArrayList<StockInterface> prevTransactions;
	public static double balance;
	
	private Button backButton;
	private ThemedTextLabel balanceDisplay;
	

	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		backButton = new Button(0, 0, 0, 0, "back", Color.green, new Action(){

			@Override
			public void act() {
				//StockMenu.game.setScreen(StockMenu.);
				System.out.println("goes back to main menu");
			}
			
		});
		
		balanceDisplay = new ThemedTextLabel(100, 60, 100, 25, "Balance");
		
		
		
		viewObjects.add(backButton);
		
	}
}
