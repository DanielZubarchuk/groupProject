import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.List;

import guiPractice8.Screen;
import guiPractice8.component.Action;
import guiPractice8.component.Button;
import guiPractice8.component.ClickableScreen;
import guiPractice8.component.Graphic;
import guiPractice8.component.Visible;

public class RichardDemo2 extends Screen implements MouseMotionListener, MouseListener{

	private Button back;
	
	private Graphic background;
	private Graphic theLeung;
	
	private Graphic theLeungTag;
	
	public RichardDemo2(int width, int height) {
		super(width, height);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void initObjects(ArrayList<Visible> viewObjects) {
		// TODO Auto-generated method stub
		
		background = new Graphic(1,1,1.0,"Resources/background/adfasdfasdfadf.png");
		theLeung = new Graphic(70,100,.5,"Resources/managers/joeeeeeeeeeeeeeey2.png");
		
		theLeungTag = new Graphic(70,235,1.0,"Resources/tags/The Leung2.png");
		
		back = new Button(850,50,100,60,"Back", 
				Color.GRAY, new Action() {
			
			public void act() {
				RichardDemo.demos.setScreen(RichardDemo.demo);
			}
		});
		viewObjects.add(background);
		
		viewObjects.add(theLeung);
		
		viewObjects.add(theLeungTag);
		
		viewObjects.add(back);
		
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		if(back.isHovered(e.getX(), e.getY())){
			back.act();
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
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	public MouseListener getMouseListener(){
		return this;
	}

}
