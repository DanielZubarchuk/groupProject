package guiPractice8.component;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

import guiPractice8.Screen;
import guiPractice8.component.Action;

public class ClickableGraphicScreen extends Screen implements MouseListener {
	
	private ClickableGraphic movedPic;
	
	public ClickableGraphicScreen(int width, int height) {
		super(width, height);
		
	}
	
	public void initObjects(ArrayList<Visible> viewObjects) {
		movedPic = new ClickableGraphic(200,200,.25,"resources/sampleImages/ball2.png");
		movedPic.setAction(new Action(){

			@Override
			public void act() {
				movedPic.setX(movedPic.getX() + 10);
				
			}
			
		});
		viewObjects.add(movedPic);
		
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if(movedPic.isHovered(e.getX(), e.getY())){
			movedPic.act();
		}
	}

	@Override
	public void mouseEntered(MouseEvent e) {
	
	}

	@Override
	public void mouseExited(MouseEvent e) {
	
	}

	@Override
	public void mousePressed(MouseEvent e) {
	
	}

	@Override
	public void mouseReleased(MouseEvent e) {
	
	}

	
	public MouseListener getMouseListener(){
		return this;
	}

}
