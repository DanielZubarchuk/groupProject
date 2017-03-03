package src.stockMarket;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import guiPractice.components.Action;
import guiPractice.components.Button;
import guiPractice.ClickableScreen;
import guiPractice.components.Visible;
import src.projectComponents.ThemedTextLabel;

public class DemoInventoryScreen extends ClickableScreen{

	private Button back;
	private ThemedTextLabel inventory;
	
	public DemoInventoryScreen(int width, int height) {
		super(width, height);
		
	}

	@Override
	public void initAllObjects(ArrayList<Visible> view) {
		back = new Button(40,40,90,90,"back", Color.blue, new Action() {
			
			@Override
			public void act() {
				StockMainMenu.mainDemoScreen.setScreen(StockMainMenu.gameScreen);
				
			}
		});
		view.add(back);
		
		inventory = new ThemedTextLabel(60,60,400,100,"Inventory Example Screen");
		view.add(inventory);
	}

}
