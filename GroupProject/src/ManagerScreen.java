import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.List;

import guiPratice.sampleGames.ClickableScreen;
import guiPratice.components.Visible;
import guiPratice.components.Action;
import guiPratice.components.Button;
import guiPratice.components.Graphic;

/**
 * @author Joey
 */
public class ManagerScreen extends ClickableScreen implements MouseMotionListener, MouseListener{
	
	private Button back;
	
	private Graphic background;
	private Graphic theLeung;
	
	private Graphic theLeungTag;
	
	private ArrayList<PropertyButtonInterface> properties;

	private ManagerButton lemonManager;

	private ManagerButton newspaperManager;

	private ManagerButton carManager;

	private ManagerButton pizzaManager;

	private ManagerButton donutManager;

	private ManagerButton shrimpManager;

	private ManagerButton hockeyManager;

	private ManagerButton movieManager;

	public ManagerScreen(int width, int height) {
		super(width, height);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void initAllObjects(ArrayList<Visible> viewObjects) {
		// TODO Auto-generated method stub
		background = new Graphic(1,1,1.0,"Resources/background/adfasdfasdfadf.png");
		theLeung = new Graphic(70,100,.5,"Resources/managers/joeeeeeeeeeeeeeey2.png");
		
		theLeungTag = new Graphic(70,235,1.0,"Resources/tags/The Leung2.png");
		
		back = new Button(850,50,100,60,"Back", 
				Color.GRAY, new Action() {
			
			public void act() {
				AdventureCapGame.game.setScreen(AdventureCapGame.AdvCapDemo);
			}
		});
		viewObjects.add(background);
		
		viewObjects.add(theLeung);
		
		viewObjects.add(theLeungTag);
		
		viewObjects.add(back);
		
	}
	
	public void managers(){
		lemonManager = new ManagerButton(220, 130, 200, 40, "Manage $100", new Color(255,255,0), new Action(){
			public void act(){
				if(Statistics.stats.getCurrentBalance()>=lemonManager.getPricexd()){
					AdventureCapScreen.AdvCapDemo.lemonMoney.setEnabled(false);
					viewObjects.remove(lemonManager);
					boolean x = true;
					while(x){							
					AdventureCapScreen.AdvCapDemo.lemonMoney.act();
					}
				}
			}
		},100);
		newspaperManager = new ManagerButton(720, 130, 200, 40, "Manage $1000", new Color(255,255,0), new Action(){
			public void act(){
				if(Statistics.stats.getCurrentBalance()>=newspaperManager.getPricexd()){
					AdventureCapScreen.AdvCapDemo.newspaperMoney.setEnabled(false);
					viewObjects.remove(newspaperManager);		
					boolean x = true;
					while(x){							
						AdventureCapScreen.AdvCapDemo.newspaperMoney.act();
					}
				}
			}
		}, 1000);
		carManager = new ManagerButton(220, 230, 200, 40, "Manage $10k", new Color(255,255,0), new Action(){
			public void act(){
				if(Statistics.stats.getCurrentBalance()>=carManager.getPricexd()){
					AdventureCapScreen.AdvCapDemo.carMoney.setEnabled(false);
					viewObjects.remove(carManager);
					boolean x = true;
					while(x){							
						AdventureCapScreen.AdvCapDemo.carMoney.act();
					}
				}
			}
		}, 10000);
		pizzaManager = new ManagerButton(720, 230, 200, 40, "Manage $100k", new Color(255,255,0), new Action(){
			public void act(){
				if(Statistics.stats.getCurrentBalance()>=pizzaManager.getPricexd()){
					AdventureCapScreen.AdvCapDemo.pizzaMoney.setEnabled(false);
					viewObjects.remove(lemonManager);	
					boolean x = true;
					while(x){							
						AdventureCapScreen.AdvCapDemo.pizzaMoney.act();
					}
				}
			}
		},100000);
		donutManager = new ManagerButton(220, 330, 200,40, "Manage $1 mill", new Color(255,255,0), new Action(){
			public void act(){
				if(Statistics.stats.getCurrentBalance()>=donutManager.getPricexd()){
					AdventureCapScreen.AdvCapDemo.donutMoney.setEnabled(false);
					viewObjects.remove(donutManager);	
					boolean x = true;
					while(x){							
						AdventureCapScreen.AdvCapDemo.donutMoney.act();
					}
				}
			}
		},1000000);
		shrimpManager = new ManagerButton(720, 330, 200, 40, "Manage $10 mill", new Color(255,255,0), new Action(){
			public void act(){
				if(Statistics.stats.getCurrentBalance()>=shrimpManager.getPricexd()){
					AdventureCapScreen.AdvCapDemo.shrimpMoney.setEnabled(false);
					viewObjects.remove(shrimpManager);	
					boolean x = true;
					while(x){							
						AdventureCapScreen.AdvCapDemo.shrimpMoney.act();
					}
				}
			}
		},10000000);
		hockeyManager = new ManagerButton(220, 430, 200, 40, "Manage $100 mill", new Color(255,255,0), new Action(){
			public void act(){
				if(Statistics.stats.getCurrentBalance()>=hockeyManager.getPricexd()){
					AdventureCapScreen.AdvCapDemo.hockeyMoney.setEnabled(false);
					viewObjects.remove(hockeyManager);	
					boolean x = true;
					while(x){							
						AdventureCapScreen.AdvCapDemo.hockeyMoney.act();
					}
				}
			}
		},100000000);
		movieManager = new ManagerButton(720, 430, 200, 40, "Manage $1 bill", new Color(255,255,0), new Action(){
			public void act(){
				if(Statistics.stats.getCurrentBalance()>=movieManager.getPricexd()){
					AdventureCapScreen.AdvCapDemo.movieMoney.setEnabled(false);
					viewObjects.remove(movieManager);	
					boolean x = true;
					while(x){							
						AdventureCapScreen.AdvCapDemo.movieMoney.act();
					}
				}
			}
		},1000000000);
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

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