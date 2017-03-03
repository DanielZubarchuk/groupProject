package src;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

import guiPractice.ClickableScreen;
import guiPractice.Screen;
import guiPractice.TextLabel;
import guiPractice.components.Action;
import guiPractice.components.Button;
import guiPractice.components.ClickableGraphic;
import guiPractice.components.Graphic;
import guiPractice.components.Visible;

public class MainMenuScreen extends ClickableScreen implements MouseMotionListener, MouseListener, App{

	private Button homeButton;
	private Button history;
	private ClickableGraphic stockGameLink;
	private ClickableGraphic advCapLink;
	private Graphic backgroundPic;
	private TextLabel menuText;
	private TextLabel menuText2;
	private ArrayList<ClickableGraphic> appLinks;
	
	public MainMenuScreen(int width, int height) {
		super(width, height);
		// TODO Auto-generated constructor stub
	}

	public void initObjects(ArrayList<Visible> viewObjects) {
		
		advCapLink = new ClickableGraphic((int) (getWidth()/2 - 287.5), getHeight()/2 - 50, .5, "resources/sampleImages/advCapIcon.png");
		stockGameLink = new ClickableGraphic((int) (getWidth()/2 +200), getHeight()/2 - 50, .5, "resources/sampleImages/stockMarketIcon.png");
		homeButton = new Button(getWidth()/2-30, (int) (5 * getHeight()/6), 60, 30, "Home", new Color(0,0,0), new Action(){
			public void act(){
				MainMenu.mms.setScreen(MainMenu.menuScreen);
			}
		});
		history = new Button(getWidth()/2 - 35, (int) (7 * getHeight()/8), 70, 30, "History", new Color(0,0,0), new Action(){
			public void act(){
				MainMenu.mms.setScreen(MainMenu.histScreen);
			}
		});
		stockGameLink.setAction(new Action() {
			public void act(){
				if(!MainMenu.histScreen.stockOpened){
					MainMenu.histScreen.stockOpened = true;
					MainMenu.histScreen.addToHistory(new Graphic((int) (2 * getWidth()/3 ), getHeight()/2 - 50, .5, "resources/sampleImages/stockMarketIcon.png"));			
//					nested inner class ??
//					MainMenu.mms.setScreen(MainMenu.stockLink);
				}
				else{
//					MainMenu.mms.setScreen(MainMenu.stockLink);
				}
			}
		});
		advCapLink.setAction(new Action() {
			public void act(){
				if(!MainMenu.histScreen.advOpened){
					MainMenu.histScreen.advOpened = true;
					MainMenu.histScreen.addToHistory(new Graphic((int) (2 * getWidth()/3 ), getHeight()/2 - 50, .5, "resources/sampleImages/advCapIcon.png"));	
					MainMenu.mms.setScreen(MainMenu.sampleScreen);
				}
				else{
					MainMenu.mms.setScreen(MainMenu.sampleScreen);
				}
			}
		});
		menuText = new TextLabel(getWidth()/2 - 100, getHeight()/5, 760, 40, "This is the Main Menu");
		menuText2 = new TextLabel(getWidth()/2 - 135, (int)(getHeight()/4.2), 760, 40, "Click any app to start playing!");
		backgroundPic = new Graphic(50, 25, "resources/sampleImages/background.png");
		
		viewObjects.add(backgroundPic);
		viewObjects.add(homeButton);
		viewObjects.add(history);
		viewObjects.add(advCapLink);
		viewObjects.add(stockGameLink);
		viewObjects.add(menuText);
		viewObjects.add(menuText2);
	}

	public void mouseClicked(MouseEvent e) {
		  if(homeButton.isHovered(e.getX(), e.getY())){
			  homeButton.act();
		  }
		  if(history.isHovered(e.getX(), e.getY())){
			  history.act();
		  }
		  if(stockGameLink.isHovered(e.getX(), e.getY())){
			  stockGameLink.act();
		  }
		  if(advCapLink.isHovered(e.getX(), e.getY())){
			  advCapLink.act();
		  }
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

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
