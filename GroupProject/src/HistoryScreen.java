import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

import guiPractice.ClickableScreen;
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
	
	public HistoryScreen(int width, int height) {
		super(height, height);
		// TODO Auto-generated constructor stub
	}

	public void initObjects(ArrayList<Visible> view) {
		homeButton = new Button(getWidth()/2-70, (int) (5 * getHeight()/6), 70, 30, "Home", new Color(0,0,0), new Action(){
			public void act(){
				MainMenu.mms.setScreen(MainMenu.menuScreen);
			}
		});
		stockIcon = new Graphic(getWidth()/2-175, (int) (getHeight()/2 - 87.5), .5, "resources/sampleImages/stockMarketIcon.png");
		if (MainMenuScreen.stockOpened){
			view.add(stockIcon);
			close = new Button(stockIcon.getWidth() - 50, stockIcon.getHeight(), 70, 30, "Close", new Color(0,0,0), new Action(){
				public void act(){
					view.remove(stockIcon);
					view.remove(close);
				}
			});
			view.add(close);
		}
		
		view.add(homeButton);
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
