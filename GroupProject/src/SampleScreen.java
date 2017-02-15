import java.awt.Color;
import java.awt.TextArea;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

import guiPractice.ClickableScreen;
import guiPractice.TextLabel;
import guiPractice.components.Action;
import guiPractice.components.Button;
import guiPractice.components.ClickableGraphic;
import guiPractice.components.Visible;

public class SampleScreen extends ClickableScreen implements App, MouseMotionListener, MouseListener {

	private Button homeButton;
	private TextLabel sample;
	private TextLabel sample2;
	
	public SampleScreen(int width, int height) {
		super(width, height);
		// TODO Auto-generated constructor stub
	}

	@Override
	public ClickableGraphic getGraphic() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setHomeButton(Button homeButton) {
		this.homeButton = homeButton;
	}

	public void initObjects(ArrayList<Visible> view) {
		homeButton = new Button(getWidth()/2-30, (int) (5 * getHeight()/6), 60, 30, "Home", new Color(0,0,0), new Action(){
			public void act(){
				HaosDemo.demos.setScreen(HaosDemo.demo);
			}
		});
		sample = new TextLabel(getWidth()/2 - 125, getHeight()/3, 760, 40, "This is the Sample Screen");
		sample2 = new TextLabel(getWidth()/2 - 150, getHeight()/2, 760, 40, "Click the home button to go back");

		view.add(homeButton);
		view.add(sample);
		view.add(sample2);
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
