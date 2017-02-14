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
 * @author Richard
 *
 */
public class RichardDemo extends GUIApplication implements MouseMotionListener, MouseListener{

	public static RichardDemo demos;
	public static RichardDemo2 demo2;
	public static RichardDemo3 demo3;
	private TextLabel reset;
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
		demo3 = new RichardDemo3(1000, 600);
		demo2 = new RichardDemo2(1000, 600);
		demo = new DemoScreen(1000, 600);
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
		
		private Graphic iconleft;
		private Graphic background;
		private Graphic lemon;
		private Graphic newspaper;
		private Graphic carwash;
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
//			int numberOfBB = 8;
//			int numberOfXNB = 1;
//			int numberOfMB = 1;
			
			//showing == true
			//everything else false 
			//if showing act
			//if not dont act
			
			background = new Graphic(1,1,1.0,"Resources/background/cfafa34141.png");
			iconleft = new Graphic(56,220,1.0, "Resources/icon/dbjhasdfjndfm.jpg");
			
			reset = new TextLabel(50, 540, 800, 25, " ");
			
			xNumButton = new Button(800, 40, 100, 50, " X 1", new Color(255,255,0), new Action(){

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
						moveToBack(background);
						moveToBack(background);
						}
					}
				});
			xNumButton2 = new Button(807, 50, 100, 50, " X 10", new Color(255,255,0), new Action(){

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
						moveToBack(background);
						moveToBack(background);
					}
				}
				});
			xNumButton3 = new Button(793, 45, 100, 50, " X 50", new Color(255,255,0), new Action(){

				
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
							moveToBack(background);
							moveToBack(background);
						}
					}
				});
			
			mangerButton = new Button(50, 350, 150, 40, "MANAGER", new Color(255,255,0), new Action(){
				public void act(){
					//take me to manager screen
					RichardDemo.demos.setScreen(demo2);
				}
			});
			
			statsButton = new Button(50, 410, 150, 40, "STATISTICS", new Color(255,255,0), new Action(){
				public void act(){
					RichardDemo.demos.setScreen(demo3);
				}
			});
			
			restartButton = new Button(50, 470, 150, 40, "restart*", new Color(255,255,0), new Action(){
				public void act(){
					reset.setText("You have reseted");
					
				}
			});
			viewObjects.add(background);
			viewObjects.add(iconleft);
			
			viewObjects.add(xNumButton);
			viewObjects.add(xNumButton2);
			viewObjects.add(xNumButton3);
			viewObjects.add(mangerButton);
			viewObjects.add(statsButton);
			viewObjects.add(restartButton);
			
			viewObjects.add(reset);
			
//			addAnimation(viewObjects);
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
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
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
//	private void addAnimation(List<Visible> viewObjects) {
//		// TODO Auto-generated method stub
//		AnimatedComponent a = new AnimatedComponent(40,40,150,150);
//		try{
//			int numberInRow = 7;
//			int rows = 4;
//			int w = 80;
//			int h = 160;
//			ImageIcon icon = new ImageIcon("resources/sampleImages/zanpto_sprite_sheet.png");
//			//create a for loop that will take a "sub-length from the sprite grid
//			for(int i = 0; i < numberInRow*rows; i++){
//				//declare the "cropped image" 
//				BufferedImage cropped = new BufferedImage(w,h,BufferedImage.TYPE_INT_ARGB);
//				int leftMargin = 0;
//				int topMargin = 0;
//				int x1 = leftMargin + w*(i%numberInRow);
//				int y1 = topMargin + h*(1/numberInRow);
//				Graphics2D g = cropped.createGraphics();
//				g.drawImage(icon.getImage(), 0, 0, w, h, x1, y1, x1 + w, y1 + h, null);
//				a.addFrame(cropped, 120);
//			}
//		}
//		catch(Exception e){
//			e.printStackTrace();
//		}
//		viewObjects.add(a);
//		a.play();
//	}
	
}

