import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.List;

import guiPratice.sampleGames.ClickableScreen;
import guiPratice.components.Visible;
import guiPratice.components.Action;
import guiPratice.components.Button;
import guiPratice.components.Graphic;

/**
 * @author Joey
 */
public class ManagerScreen extends ClickableScreen implements MouseMotionListener, MouseListener{
	
	private Button back;
	
	private Graphic background;
	private Graphic theLeung;
	
	private Graphic theLeungTag;
	
	private ArrayList<ManagerInterface> managers;
	private ArrayList<PropertyButtonInterface> properties;

	public ManagerScreen(int width, int height) {
		super(width, height);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void initAllObjects(ArrayList<Visible> viewObjects) {
		// TODO Auto-generated method stub
		background = new Graphic(1,1,1.0,"Resources/background/adfasdfasdfadf.png");
		theLeung = new Graphic(70,100,.5,"Resources/managers/joeeeeeeeeeeeeeey2.png");
		
		theLeungTag = new Graphic(70,235,1.0,"Resources/tags/The Leung2.png");
		
		back = new Button(850,50,100,60,"Back", 
				Color.GRAY, new Action() {
			
			public void act() {
				AdventureCapGame.game.setScreen(AdventureCapGame.AdvCapDemo);
			}
		});
		viewObjects.add(background);
		
		viewObjects.add(theLeung);
		
		viewObjects.add(theLeungTag);
		
		viewObjects.add(back);
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}