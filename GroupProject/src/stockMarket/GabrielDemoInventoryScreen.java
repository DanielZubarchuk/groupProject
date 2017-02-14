package stockMarket;

import java.awt.Color;
import java.util.List;

import guiPractice8.component.Action;
import guiPractice8.component.Button;
import guiPractice8.component.ClickableScreen;
import guiPractice8.component.Visible;
import projectComponents.ThemedTextLabel;

public class GabrielDemoInventoryScreen extends ClickableScreen{

	private Button back;
	private ThemedTextLabel inventory;
	
	public GabrielDemoInventoryScreen(int width, int height) {
		super(width, height);
		
	}

	@Override
	public void initAllObjects(List<Visible> view) {
		back = new Button(40,40,90,90,"back", Color.blue, new Action() {
			
			@Override
			public void act() {
				GabrielDemo.mainDemoScreen.setScreen(GabrielDemo.demo);
				
			}
		});
		view.add(back);
		
		inventory = new ThemedTextLabel(60,60,400,100,"Inventory Example Screen");
		view.add(inventory);
	}

}
