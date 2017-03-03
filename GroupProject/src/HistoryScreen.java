package src;

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
	private Graphic backgroundPic;
	private TextLabel historyText;
	private TextLabel historyText2;
	private TextLabel nothing;
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
//		close = new Button(getWidth()/2 - 30, getHeight()/2 - 15, 60, 30, "Close Apps", new Color(0,0,0), new Action() {
//			public void act() {
//				System.out.println("this has been clickedsdas");
//				if(appPics == null){
//					nothing = new TextLabel(getWidth()/2 - 125, getHeight()/3, 760, 40, "There is nothing to close!");
//					System.out.println("this has been clicked");
//				}
//				if(view.contains(stockIcon)){
//					appPics.remove(stockIcon);
//					remove(stockIcon);
//				}
//				else if(view.contains(advIcon)){
//					appPics.remove(advIcon);
//					remove(advIcon);
//				}
//				else{
//					appPics.remove(stockIcon);
//					appPics.remove(advIcon);
//					remove(stockIcon);
//					remove(advIcon);
//					
//				}
//			}
//		});
		close = new Button(getWidth()/2 - 60, getHeight()/2 - 15, 120, 30, "Close Apps", new Color(0,0,0), new Action() {
			public void act(){
				
			}
		});
		nothing = new TextLabel(getWidth()/2 - 115, getHeight()/3, 760, 40, "There is nothing to close");
		historyText = new TextLabel(getWidth()/2 - 115, getHeight()/5, 760, 40, "This is the history screen");
		historyText2 = new TextLabel(getWidth()/2 - 250, (int) (getHeight()/4.2), 760, 40, "Press the 'Close Apps' button to close your opened apps");
		backgroundPic = new Graphic(50, 25, "resources/sampleImages/background.png");
		viewObjects.add(backgroundPic);
		view.add(close);
		view.add(homeButton);
		viewObjects.add(nothing);
		viewObjects.add(historyText);
		viewObjects.add(historyText2);
	}
	
	public void addToHistory(Graphic g){
		appPics.add(g);
		if(appPics.size() == 1){
			g.setX((int) (getWidth()/2 - 287.5));
		}
		else{
			g.setX((int) (getWidth()/2 + 200));
		}
		close = new Button(getWidth()/2 - 60, getHeight()/2 - 15, 120, 30, "Close Apps", new Color(0,0,0), new Action(){
			public void act(){
				if(appPics.size() != 0){
					appPics.removeAll(appPics);
					viewObjects.removeAll(viewObjects);
					viewObjects.add(backgroundPic);
					viewObjects.add(homeButton);
					viewObjects.add(close);
					stockOpened = false;
					advOpened = false;
					viewObjects.add(nothing);
					viewObjects.add(historyText);
					viewObjects.add(historyText2);
				}
			}
		});
		System.out.print(appPics.size());
		System.out.print(viewObjects.size());
		if (appPics.size() != 0){
				viewObjects.remove(nothing);
		}
		viewObjects.add(g);//this makes this display on the screen
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
