import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

import guiPratice.Screen;
import guiPratice.components.Action;
import guiPratice.components.Button;
import guiPratice.components.Visible;
import guiPratice.sampleGames.ClickableSceen;

public class StatsScreen extends ClickableScreen implements MouseMotionListener,MouseListener{

	private Button back;
	
	public StatsScreen(int width, int height) {
		// TODO Auto-generated constructor stub
		super(width, height);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		if(back.isHovered(e.getX(), e.getY())){
			back.act();
		}
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
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

	@Override
	public void initObjects(ArrayList<Visible> viewObjects) {
		// TODO Auto-generated method stub
		back = new Button(50,50,100,60,"Back", 
				Color.GRAY, new Action() {
			
			public void act() {
				AdventureCapGame.game.setScreen(AdventureCapGame.AdvCapDemo);
			}
		});
		viewObjects.add(back);
	}

}
