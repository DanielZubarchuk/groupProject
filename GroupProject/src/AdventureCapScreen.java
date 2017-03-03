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
import guiPratice.components.Action;
import guiPratice.components.Button;
import guiPratice.components.Graphic;
import guiPratice.components.TextLabel;
import guiPratice.components.Visible;
import guiPratice.sampleGames.ClickableScreen;

public class AdventureCapScreen extends Screen implements MouseMotionListener, MouseListener{
	
	public AdventureCapScreen(int width, int height) {
		super(width, height);
		// TODO Auto-generated constructor stub
	}
	
	public static AdventureCapScreen AdvCapDemo;
	public static ManagerScreen manager;
	public static StatsScreen stats;
	
	private Button mangerButton;//made
	private Button statsButton;//made
	private Button restartButton;//made
	
	public void generateMenuButtons(){
		mangerButton = new Button(50, 350, 150, 40, "MANAGER", new Color(0,0,0), new Action(){
			public void act(){
				//take me to manager screen
				AdventureCapGame.game.setScreen(AdventureCapGame.manager);
			}
		});
		
		statsButton = new Button(50, 410, 150, 40, "STATISTICS", new Color(0,0,0), new Action(){
			public void act(){
				AdventureCapGame.game.setScreen(AdventureCapGame.stats);
			}
		});
		
		restartButton = new Button(50, 470, 150, 40, "restart*", new Color(0,0,0), new Action(){
			public void act(){
//				reset.setText("You have reseted");
				
			}
		});
	}
	
	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void initObjects(ArrayList<Visible> viewObjects) {
		// TODO Auto-generated method stub
		generateMenuButtons();
		
		viewObjects.add(mangerButton);
		viewObjects.add(statsButton);
		viewObjects.add(restartButton);
	}

}
