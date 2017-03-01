import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

import guiPractice.ClickableScreen;
import guiPractice.TextLabel;
import guiPractice.components.Action;
import guiPractice.components.Button;
import guiPractice.components.ClickableGraphic;
import guiPractice.components.Graphic;
import guiPractice.components.Visible;

public class HistoryScreen extends ClickableScreen implements App, MouseListener, MouseMotionListener {

	private Button homeButton;
	private Button close;
	private Graphic stockIcon;
	private Graphic advIcon;
	private TextLabel historyText;
	static boolean advOpened;
	static boolean stockOpened;
	private ArrayList<Graphic> appPics;
	
	public HistoryScreen(int width, int height) {
		super(width, height);
		// TODO Auto-generated constructor stub
	}

	public void initObjects(ArrayList<Visible> view) {
		appPics = new ArrayList<Graphic>();
		homeButton = new Button(getWidth()/2-30, (int) (5 * getHeight()/6), 60, 30, "Home", new Color(0,0,0), new Action(){
			public void act(){
				MainMenu.mms.setScreen(MainMenu.menuScreen);
			}
		});
		if(stockOpened){
			stockIcon = new Graphic((int) (2 * getWidth()/3 ), getHeight()/2 - 50, "resources/sampleImages/stockMarketIcon.png");
			view.add(stockIcon);
			appPics.add(stockIcon);
			close = new Button(stockIcon.getWidth(), stockIcon.getHeight() - 50, 70, 30, "Close", new Color(0,0,0), new Action(){
				public void act(){
					view.remove(stockIcon);
					view.remove(close);
					appPics.remove(stockIcon);
				}
			});
		}
		if(advOpened){
			advIcon = new Graphic((int) (getWidth()/3 - 87.5), getHeight()/2 - 50, "resources/sampleImages/advCapIcon.png");
			view.add(advIcon);
			appPics.add(advIcon);
			close = new Button(advIcon.getWidth(), advIcon.getHeight() - 50, 70, 30, "Close", new Color(0,0,0), new Action(){
				public void act(){
					view.remove(advIcon);
					view.remove(close);
					appPics.remove(advIcon);
				}
			});
		}
		
		view.add(homeButton);
	}
	
	public void addToHistory(Graphic g){
		appPics.add(g);
		if(appPics != null){
			g.setX(700);
			close = new Button(g.getWidth(), g.getHeight() - 50, 70, 30, "Close", new Color(0,0,0), new Action(){
				public void act(){
					appPics.remove(g);
					
				}
			});
		}
		else{
			g.setX(400);
		}
		addObject(g);//this makes this display on the screen
	}
	
	@Override
	public void mouseDragged(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseMoved(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		  if(homeButton.isHovered(e.getX(), e.getY())){
		  homeButton.act();
		  }
		  if(close.isHovered(e.getX(), e.getY())){
		  close.act();
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
	public Graphic getGraphic() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setHomeButton(Button homeButton) {
		this.homeButton = homeButton;

	}

	public void main(String[] args) {
		// TODO Auto-generated method stub
	}
}
