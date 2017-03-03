package stockMarket;

import java.util.ArrayList;

import guiPractice.ClickableScreen;
import guiPractice.components.Graphic;
import guiPractice.components.Visible;
import javafx.scene.paint.Color;
import projectComponents.ThemedTextLabel;

public class LoseScreen extends ClickableScreen {

	private Graphic background;
	private ThemedTextLabel loseText;
	
	public LoseScreen(int width, int height) {
		super(width, height);
		// TODO Auto-generated constructor stub
	}
	
	public void initAllObjects(ArrayList<Visible> viewObjects) {
		
		background=new Graphic(0,0,getWidth(),getHeight(),"resources/images/newmoneybackground.png");
		viewObjects.add(background);
		
		loseText = new ThemedTextLabel(100,300, 800, 50, "YOU LOST THE GAME. THANKS FOR PLAYING.");
		//loseText.setColor(Color.DARKGOLDENROD);
		loseText.setSize(30);
		viewObjects.add(loseText);
		
	}
	
}