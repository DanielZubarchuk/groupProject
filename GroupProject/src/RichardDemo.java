import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;

import guiPractice8.Screen;
import guiPractice8.component.Action;
import guiPractice8.component.Button;
import guiPractice8.component.Graphic;
import guiPractice8.component.TextLabel;
import guiPractice8.component.Visible;
import guiPractice8.component.ClickableScreen;
import guiPractice8.GUIApplication;

/**
 * 
 */

/**
 * @author Richard
 *
 */
public class RichardDemo extends GUIApplication implements MouseMotionListener, MouseListener{

	public static RichardDemo demos;
	public static RichardDemo2 demo2;
	public static Screen demo;
	private static int xthing = 1;
	/**
	 * 
	 */
	public RichardDemo() {
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see guiPractice.GUIApplication#initScreen()
	 */
	@Override
	protected void initScreen() {
		demo2 = new RichardDemo2(getWidth(), getHeight());
		demo = new DemoScreen(getWidth(), getHeight());
		setScreen(demo);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		demos = new RichardDemo();
		Thread app = new Thread(demos);
		app.start();
	}

	//nested inner class
	private class DemoScreen extends ClickableScreen {

		//joey making these
		//all i need to do is set x and set y
		//wait for him for more info
		private Button buyButton;
		
		private Button xNumButton;//made
		private Button xNumButton2;//made
		private Button xNumButton3;//made
		private Button mangerButton;//made
		//same thing as manager button(new screen)
		private Button statsButton;
		private Button restartButton;
		
		private Graphic lemon;
		private Graphic newspaper;
		private Graphic carWash;
		private Graphic pizza;
		private Graphic donut;
		private Graphic shrimp;
		private Graphic hocky;
		private Graphic film;
		
		private boolean button1Disabled = true;
		private boolean button2Disabled = true;
		private boolean button3Disabled = false;
		
//		private TextLabel buyText;
		
		public DemoScreen(int width, int height) {
			super(width, height);
			// TODO Auto-generated constructor stub
		
		}
		
		@Override
		public void initAllObjects(List<Visible> viewObjects) {
			// TODO Auto-generated method stub
			int numberOfBB = 8;
			int numberOfXNB = 1;
			int numberOfMB = 1;
			
			//showing == true
			//everything else false 
			//if showing act
			//if not dont act
			
			xNumButton = new Button(100, 50, 150, 100, " X " + xthing, new Color(255,255,0), new Action(){

				public void act() {
					// TODO Auto-generated method stub
					
					if(button1Disabled == true){
						System.out.println("button 1 is " + button1Disabled);
						return;
					}
					else{
						System.out.println(xthing);
						button3Disabled = !button3Disabled;
						button1Disabled = !button1Disabled;
						moveToBack(xNumButton);
						moveToBack(xNumButton);
						}
					}
				});
			xNumButton2 = new Button(150, 60, 150, 100, " X 2" + xthing, new Color(255,255,0), new Action(){

				public void act() {
					// TODO Auto-generated method stub
					if(button2Disabled == true){
						System.out.println("button 2 is " + button2Disabled);
						return;
					}
					else{
					System.out.println("klegjielg");
					button1Disabled = !button1Disabled;
					button2Disabled = !button2Disabled;
						moveToBack(xNumButton2);
						moveToBack(xNumButton2);
						
					}
				}
				});
			xNumButton3 = new Button(200, 70, 150, 100, " X 3" + xthing, new Color(255,255,0), new Action(){

				
					public void act() {
						// TODO Auto-generated method stub
						if(button3Disabled == true){
							System.out.println("button 3 is " + button3Disabled);
							return;
						}
						else{
							System.out.println("rtyeryer");
							button2Disabled = !button2Disabled;
							button3Disabled = !button3Disabled;
							moveToBack(xNumButton3);
							moveToBack(xNumButton3);
						}
					}
				});
			
			mangerButton = new Button(50, 200, 100, 40, "MANAGER", new Color(255,255,0), new Action(){
				public void act(){
					//take me to manager screen
					RichardDemo.demos.setScreen(demo2);
				}
			});
			viewObjects.add(xNumButton);
			viewObjects.add(xNumButton2);
			viewObjects.add(xNumButton3);
			viewObjects.add(mangerButton);
			
			addAnimation(viewObjects);
		}

		private void addAnimation(ArrayList<Visible> viewObjects) {
			// TODO Auto-generated method stub
			AnimatedComponent a = new AnimatedComponent(40,40,150,150);
		}
		
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
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
	public void mouseDragged(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	} 






}