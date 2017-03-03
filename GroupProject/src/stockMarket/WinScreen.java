package stockMarket;

import java.awt.Color;
import java.util.ArrayList;

import guiPractice.ClickableScreen;
import guiPractice.components.Action;
import guiPractice.components.Button;
import guiPractice.components.Graphic;
import guiPractice.components.Visible;
import projectComponents.ThemedTextLabel;

public class WinScreen extends ClickableScreen {

	private Graphic background;
	private ThemedTextLabel winText;
	private Button homeButton;
	
	public WinScreen(int width, int height) {
		super(width, height);
		// TODO Auto-generated constructor stub
	}
	
	public void initAllObjects(ArrayList<Visible> viewObjects) {
		
		background=new Graphic(0,0,getWidth(),getHeight(),"resources/images/newmoneybackground.png");
		viewObjects.add(background);
		
		winText = new ThemedTextLabel(100,300, 800, 50, "YOU LOST THE GAME. THANKS FOR PLAYING.");
		winText.setSize(30);
		viewObjects.add(winText);
		
		homeButton = new Button(200, 450, 60, 30, "Home", new Color(0,0,0), new Action() {
			
			@Override
			public void act() {
				//MainMenu.mms.setScreen(MainMenu.menuScreen);
			}
		});
		viewObjects.add(homeButton);
	}
	
}