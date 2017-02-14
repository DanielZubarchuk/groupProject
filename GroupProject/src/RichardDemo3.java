import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

import guiPractice8.Screen;
import guiPractice8.component.Action;
import guiPractice8.component.Button;
import guiPractice8.component.Visible;

public class RichardDemo3 extends Screen implements MouseMotionListener, MouseListener{

	private Button back;
	
	public RichardDemo3(int width, int height) {
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

	@Override
	public void initObjects(ArrayList<Visible> viewObjects) {
		// TODO Auto-generated method stub
		back = new Button(50,50,100,60,"Back", 
				Color.GRAY, new Action() {
			
			public void act() {
				RichardDemo.demos.setScreen(RichardDemo.demo);
			}
		});
		viewObjects.add(back);
	}

	public MouseListener getMouseListener(){
		return this;
	}
}
