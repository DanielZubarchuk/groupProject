package guiPractice8.sampleGames;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

import guiPractice8.Screen;
import guiPractice8.component.Actions;
import guiPractice8.component.Buttonssss;
import guiPractice8.component.Graphic;
import guiPractice8.component.Visible;

public class MyScreen extends Screen implements MouseMotionListener, MouseListener{

	private Graphic secondPic;
	private Buttonssss back;
	
	public MyScreen(int width, int height) {
		super(width, height);
	}

	@Override
	public void initObjects(ArrayList<Visible> viewObjects) {
		secondPic = new Graphic(200,200,1,"resources/sampleImages/images.jpg");
		back = new Buttonssss(50,50,100,60,"Back", Color.GRAY, new Actions() {
			
			public void act() {
				MouseFollower.game.setScreen(MouseFollower.coordScreen);
			}
		});
		viewObjects.add(secondPic);
		viewObjects.add(back);
	}

	public void mouseDragged(MouseEvent arg0) {

	}

	public void mouseMoved(MouseEvent e) {
		
	}

	public void mouseClicked(MouseEvent e) {
		if(back.isHovered(e.getX(), e.getY())){
			back.act();
		}
	}

	public void mouseEntered(MouseEvent e) {
	
	}

	public void mouseExited(MouseEvent e) {
		
	}

	public void mousePressed(MouseEvent e) {
		
	}

	public void mouseReleased(MouseEvent e) {
	
	}

	public MouseListener getMouseListener(){
		return this;
	}
	
}