import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

import guiPractice.ClickableScreen;
import guiPractice.Screen;
import guiPractice.components.Action;
import guiPractice.components.Button;
import guiPractice.components.ClickableGraphic;
import guiPractice.components.Graphic;
import guiPractice.components.Visible;

public class MainMenuScreen extends ClickableScreen implements MouseMotionListener, MouseListener{

	private Button homeButton;
	private ClickableGraphic stockGameLink;
	private ClickableGraphic advCapLink;
	private Graphic backgroundPic;
	private ArrayList<ClickableGraphic> appLinks;
	
	public MainMenuScreen(int width, int height) {
		super(width, height);
		// TODO Auto-generated constructor stub
	}

	public void initObjects(ArrayList<Visible> viewObjects) {
		
		advCapLink = new ClickableGraphic((int) (getWidth()/3 - 87.5), getHeight()/2 - 50, .5, "resources/sampleImages/advCapIcon.png");
		stockGameLink = new ClickableGraphic((int) (2 * getWidth()/3 ), getHeight()/2 - 50, .5, "resources/sampleImages/stockMarketIcon.png");
		viewObjects.add(advCapLink);
		viewObjects.add(stockGameLink);
		homeButton = new Button(getWidth()/2-30, (int) (5 * getHeight()/6), 60, 30, "Home", new Color(0,0,0), new Action(){
			public void act(){
				MainMenu.mms.setScreen(MainMenu.menuScreen);
			}
		});
		viewObjects.add(homeButton);
	}

	public void mouseClicked(MouseEvent e) {
		  if(homeButton.isHovered(e.getX(), e.getY())){
		  homeButton.act();
		  }
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
	public MouseListener getMouseListener(){
		return this;
	}

	@Override
	public void mouseDragged(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
