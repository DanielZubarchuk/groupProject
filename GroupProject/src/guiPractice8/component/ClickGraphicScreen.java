package guiPractice8.component;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

import guiPractice8.Screen;

public class ClickGraphicScreen extends Screen implements MouseListener{
	
	public ClickGraphicScreen(int width, int height) {
		super(width, height);
		// TODO Auto-generated constructor stub
	}

	private ClickableGraphic bboy;

	

	public void initObjects(ArrayList<Visible> viewObjects){
		bboy = new ClickableGraphic(300,300,.1,"resources/sampleImages/bboy.jpg");
		bboy.setAction(new Action(){
			public void act(){
				bboy.setX(bboy.getX()+10);
			}
		}
				);
		viewObjects.add(bboy);
	}
	

	
	public MouseListener getMouseListener(){
		return this;
	}
	
	public void mouseClicked(MouseEvent m) {
		// TODO Auto-generated method stub
		if(bboy.isHovered(m.getX(), m.getY())){
			bboy.act();
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


	
}
