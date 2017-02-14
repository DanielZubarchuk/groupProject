package guiPractice8.sampleGames;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import javax.swing.ImageIcon;

import guiPractice8.Screen;
import guiPractice8.component.Action;
import guiPractice8.component.AnimatedComponent;
import guiPractice8.component.Button;
import guiPractice8.component.Graphic;
import guiPractice8.component.MovingComponent;
import guiPractice8.component.TextArea;
import guiPractice8.component.TextLabel;
import guiPractice8.component.Visible;

public class CoordinateScreen extends Screen implements MouseMotionListener, MouseListener{

	private TextLabel label;
	private TextArea paragraph;
	private Button button;
	private Graphic picture;
	
	public CoordinateScreen(int width, int height) {
		super(width, height);
	}

	@Override
	public void initObjects(ArrayList<Visible> viewObjects) {
		label = new TextLabel(40,45,760,40,"Sample Text");
		paragraph = new TextArea(40,85,550,500,
				"This is a whole paragraph. Notice how "
				+ "as the paragraph gets to the edge"
				+ " of the page, a new line is created.");
		button = new Button(40,200,80,40,"Button",
				new Color(100,100,250),new Action() {
			
			public void act() {
				MouseFollower.game.setScreen(MouseFollower.moveScreen);
			}
		});
		picture = new Graphic(50,50,.5,"resources/sampleImages/ball.png");
		
		
		viewObjects.add(label);
		viewObjects.add(paragraph);
		viewObjects.add(button);
		viewObjects.add(picture);
		
		
//		MovingComponent mc = new MovingComponent(30, 60, 80, 80);
//		mc.setVy(3);
//		mc.play();
//		
//		viewObjects.add(mc);
		
		addAnimation(viewObjects);
	}

	private void addAnimation(ArrayList<Visible> viewObjects) {
		AnimatedComponent a = new AnimatedComponent(40, 50, 150, 150);
		try{
			int numberInRow = 9;
			int rows = 3;
			int w = 90;
			int h = 120;
			
			ImageIcon icon = new ImageIcon("resources/sampleImages/sonic.jpg");
			for(int i = 2; i < numberInRow*rows; i++){
				BufferedImage cropped = new BufferedImage(w,h, BufferedImage.TYPE_INT_ARGB);
				int leftMargin = 0;
				int topMargin = 0;
				int x1 = leftMargin + w*(i%numberInRow);
				int y1 = topMargin + h*(i/numberInRow);
				Graphics2D g = cropped.createGraphics();
				g.drawImage(icon.getImage(),30,30,w,h,x1,y1,x1+w,y1+h,null);
				a.addFrame(cropped, 10);
		}
		}catch(Exception e){
			e.printStackTrace();
		}
		viewObjects.add(a);
		a.play();
	}

	public void mouseDragged(MouseEvent e) {
		
	}

	public void mouseMoved(MouseEvent m) {
		label.setText("Mouse at " + m.getX()+", "+m.getY());
	}
	
	public MouseMotionListener getMouseMotionListener(){
		return this;
	}
	
	public MouseListener getMouseListener(){
		return this;
	}

	public void mouseClicked(MouseEvent m) {
		if(button.isHovered(m.getX(), m.getY())){
			button.act();
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

}

