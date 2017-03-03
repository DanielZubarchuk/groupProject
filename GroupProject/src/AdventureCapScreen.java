import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;

import guiPratice.components.AnimatedComponent;
import guiPratice.GUIApplication;
import guiPratice.Screen;
import guiPractice8.component.Action;
import guiPractice8.component.Button;
import guiPratice.components.Graphic;
import guiPratice.components.TextLabel;
import guiPratice.components.Visible;
import guiPratice.sampleGames.ClickableScreen;

public class AdventureCapScreen extends ClickableScreen implements AdventureCapScreenInterface{
	
	public AdventureCapScreen(int width, int height) {
		super(width, height);
		// TODO Auto-generated constructor stub
	}
	
	public static AdventureCapScreen AdvCapDemo;
	public static ManagerScreen manager;
	public static StatsScreen stats;
	
	
	private static TextLabel moneyText;
	private int currentAmount;
	
	
	
	private Button mangerButton;//made
	private Button statsButton;//made
	private Button restartButton;//made
	
	public void generateMenuButtons(){
		mangerButton = new Button(50, 230, 150, 40, "MANAGER", new Color(0,0,0), new Action(){
			public void act(){
				//take me to manager screen
				System.out.println("Clicked");
				AdventureCapGame.game.setScreen(AdventureCapGame.manager);
			}
		});
		
		statsButton = new Button(50, 290, 150, 40, "STATISTICS", new Color(0,0,0), new Action(){
			public void act(){
				AdventureCapGame.game.setScreen(AdventureCapGame.stats);
			}
		});
		
		restartButton = new Button(50, 350, 150, 40, "restart*", new Color(0,0,0), new Action(){
			public void act(){
//				reset.setText("You have reseted");
				
			}
		});
	}
	
	
	@Override
	public void initAllObjects(ArrayList<Visible> arg0) {
		// TODO Auto-generated method stub
		generateMenuButtons();
		ArrayList<PropertyButtonInterface> properties = JoeyOperation.generateButtons();
		ArrayList<guiPractice8.component.Button> moneyButtons = JoeyOperation.generateMoneyButtons();
		
		
		viewObjects.add(mangerButton);
		viewObjects.add(statsButton);
		viewObjects.add(restartButton);
	}

	@Override
	public int getCurrentAmount() {
		// TODO Auto-generated method stub
		return currentAmount;
	}

	public void setMoneyText(String text) {
		// TODO Auto-generated method stub
		moneyText.setText(text);
	}

}
