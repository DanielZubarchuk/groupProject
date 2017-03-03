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
				viewObjects.remove(viewObjects.size()-1);
				viewObjects.remove(viewObjects.size()-2);
			}
		});
		backgroundPic = new Graphic(50, 25, "resources/sampleImages/background.png");
		viewObjects.add(backgroundPic);
		view.add(close);
		view.add(homeButton);
	}
	
	public void addToHistory(Graphic g){
		
		appPics.add(g);
		System.out.println(appPics);
		System.out.println(viewObjects);
		if(appPics.size() == 1){
			g.setX(300);
		}
		else{
			g.setX(700);
		}
		close = new Button(getWidth()/2 - 60, getHeight()/2 - 15, 120, 30, "Close Apps", new Color(0,0,0), new Action(){
			public void act(){
				if(appPics.size() != 0){
					appPics.removeAll(appPics);
					viewObjects.removeAll(viewObjects);
					viewObjects.add(backgroundPic);
					viewObjects.add(homeButton);
					viewObjects.add(close);
				}
				else {
					System.out.println("There is nothing here");
				}
			}
		});
		viewObjects.add(g);//this makes this display on the screen
		System.out.println(viewObjects);
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
