import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;

import guiPratice.components.AnimatedComponent;
import guiPratice.Screen;
import guiPratice.components.Action;
import guiPratice.components.Button;
import guiPratice.components.Graphic;
import guiPratice.components.TextLabel;
import guiPratice.components.Visible;
import guiPratice.sampleGames.ClickableScreen;
import guiPratice.GUIApplication;

/**
 * @author Richard
 *
 */
public class RichardDemo extends GUIApplication implements MouseMotionListener, MouseListener{
	
	public static int currentAmount;
	public static TextLabel moneyDisplay;

	public static RichardDemo demos;
	public static RichardDemo2 demo2;
	public static RichardDemo3 demo3;
	
	public static Screen demo;
	private static int xthing = 1;
	/**
	 * TTTTTTTTTTTTTTTTTTT   HHHHH    HHHHH   IIIII   NNNNNNN   NNNNN      GGGGGG          SSSS        
	 *  TTTTTTTTTTTTTTTTT     HHH      HHH     III     NNNNN     NNN     GGGGGGGGGG     SSSSSSSSSS
	 *   T     TTT     T      HHH      HHH     III     NNN NN    NNN    GGG      GGG   SSS 
	 *         TTT            HHH      HHH     III     NNN  NN   NNN   GGG             SSSS     
	 *         TTT            HHHHHHHHHHHH     III     NNN   NN  NNN   GGG               SSSSSSS
	 *         TTT            HHH      HHH     III     NNN    NN NNN   GGG      GGGG        SSSSSSS
	 *         TTT            HHH      HHH     III     NNN     NNNNN    GGG      GGG            SSS
	 *         TTT            HHH      HHH     III     NNN      NNNN     GGG    GGG     SSSSSSSSSS  
	 *        TTTTT          HHHHH    HHHHH   IIIII   NNNNN    NNNNNN     GGGGGGGG         SSSS
	 * 
	 * - Re-photoshop the background
	 * - get a background for stats and manager
	 * - get icons
	 * - FIX DANIEL'S GUI
	 * - make loading bar
	 * - make manager screen 
	 * - make stats screen
	 * 
	 * 
	 * 
	 */
	public RichardDemo() {
		// TODO Auto-generated constructor stub
		setBounds(50,50,1000,600);
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

		private Button xNumButton;//made
		private Button xNumButton2;//made
		private Button xNumButton3;//made
		
		private Button mangerButton;//made
		private Button statsButton;//made
		private Button restartButton;//made
		
		private Button buyButton1;//made
		private Button buyButton2;//made
		private Button buyButton3;//made
		private Button buyButton4;//made
		private Button buyButton5;//made
		private Button buyButton6;//made
		private Button buyButton7;//made
		private Button buyButton8;//made
		
		private Button makeMoneyButton1;//made
		private Button makeMoneyButton2;//made
		private Button makeMoneyButton3;//made
		private Button makeMoneyButton4;//made
		private Button makeMoneyButton5;//made
		private Button makeMoneyButton6;//made
		private Button makeMoneyButton7;//made
		private Button makeMoneyButton8;//made
		
		private TextLabel reset;//made
		private TextLabel buyText;//made
		
		private TextLabel timer1;
		private TextLabel timer2;
		private TextLabel timer3;
		private TextLabel timer4;
		private TextLabel timer5;
		private TextLabel timer6;
		private TextLabel timer7;
		private TextLabel timer8;
		
		private Graphic iconleft;//made
		private Graphic background;//made
		private Graphic lemon;//made
		private Graphic newspaper;//made
		private Graphic carwash;//made
		private Graphic pizza;//made
		private Graphic donut;//made
		private Graphic shrimp;//made
		private Graphic hocky;//made
		private Graphic film;//made
		
		private boolean button1Disabled = true;
		private boolean button2Disabled = true;
		private boolean button3Disabled = false;
		
//		private TextLabel buyText;
		
		public DemoScreen(int width, int height) {
			super(width, height);
		
		}
		
		@Override
		public void initAllObjects(ArrayList<Visible> viewObjects) {
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
			buyText = new TextLabel(250, 50, 800, 25, " ");
			moneyDisplay = new TextLabel(10, 0, 700, 100, "0.00");
					
			xNumButton = new Button(800, 40, 100, 50, " X 1", new Color(100,100,100), new Action(){

				public void act() {
					// TODO Auto-generated method stub
					
					if(button1Disabled == true){
						System.out.println("button 1 is " + button1Disabled);
						return;
					}
					else{
						System.out.println(xthing);
						moveToBack(xNumButton3);
						moveToFront(xNumButton3);
						button3Disabled = !button3Disabled;
						button1Disabled = !button1Disabled;
						currentAmount = 100;
						System.out.println("button 1");
						System.out.println(currentAmount);
						}
					}
				});
			xNumButton2 = new Button(807, 50, 100, 50, " X 10", new Color(100,100,100), new Action(){

				public void act() {
					// TODO Auto-generated method stub
					if(button2Disabled == true){
						System.out.println("button 2 is " + button2Disabled);
						return;
					}
					else{
						System.out.println("klegjielg");
						moveToBack(xNumButton);
						moveToFront(xNumButton);
						button1Disabled = !button1Disabled;
						button2Disabled = !button2Disabled;
						currentAmount = 1;
						System.out.println("button 2");
						System.out.println(currentAmount);
					}
				}
				});
			xNumButton3 = new Button(793, 45, 100, 50, " X 100", new Color(100,100,100), new Action(){

				
					public void act() {
						// TODO Auto-generated method stub
						if(button3Disabled == true){
							System.out.println("button 3 is " + button3Disabled);
							return;
						}
						else{
							System.out.println("rtyeryer");
							moveToBack(xNumButton2);
							moveToFront(xNumButton2);
							button2Disabled = !button2Disabled;
							button3Disabled = !button3Disabled;
							currentAmount = 10;
							System.out.println("button 3");
							System.out.println(currentAmount);
						}
					}
				});
			mangerButton = new Button(50, 350, 150, 40, "MANAGER", new Color(0,0,0), new Action(){
				public void act(){
					//take me to manager screen
					RichardDemo.demos.setScreen(demo2);
				}
			});
			
			statsButton = new Button(50, 410, 150, 40, "STATISTICS", new Color(0,0,0), new Action(){
				public void act(){
					RichardDemo.demos.setScreen(demo3);
				}
			});
			
			restartButton = new Button(50, 470, 150, 40, "restart*", new Color(0,0,0), new Action(){
				public void act(){
					reset.setText("You have reseted");
					
				}
			});
			
			buyButton1 = new Button(420, 180, 100, 40, "BUY", new Color(0,0,0), new Action(){
				public void act(){
					buyText.setText("You have bought girgwiglg1");
				}
			});
			buyButton2 = new Button(790, 180, 100, 40, "BUY", new Color(0,0,0), new Action(){
				public void act(){
					buyText.setText("You have bought girgwiglg2");
				}
			});
			buyButton3 = new Button(420, 280, 100, 40, "BUY", new Color(0,0,0), new Action(){
				public void act(){
					buyText.setText("You have bought girgwiglg3");
				}
			});
			buyButton4 = new Button(790, 280, 100, 40, "BUY", new Color(0,0,0), new Action(){
				public void act(){
					buyText.setText("You have bought girgwiglg4");
				}
			});
			buyButton5 = new Button(420, 380, 100, 40, "BUY", new Color(0,0,0), new Action(){
				public void act(){
					buyText.setText("You have bought girgwiglg5");
				}
			});
			buyButton6 = new Button(790, 380, 100, 40, "BUY", new Color(0,0,0), new Action(){
				public void act(){
					buyText.setText("You have bought girgwiglg6");
				}
			});
			buyButton7 = new Button(420, 480, 100, 40, "BUY", new Color(0,0,0), new Action(){
				public void act(){
					buyText.setText("You have bought girgwiglg7");
				}
			});
			buyButton8 = new Button(790, 480, 100, 40, "BUY", new Color(0,0,0), new Action(){
				public void act(){
					buyText.setText("You have bought girgwiglg8");
				}
			});
			
			makeMoneyButton1 = new Button(521, 180, 100, 40, "$$$", new Color(0,0,0), new Action(){
				public void act(){
					buyText.setText("You have dofgjsioprjhbilr1");
				}
			});
			makeMoneyButton2 = new Button(891, 180, 100, 40, "$$$", new Color(0,0,0), new Action(){
				public void act(){
					buyText.setText("You have dofgjsioprjhbilr2");
				}
			});
			makeMoneyButton3 = new Button(521, 280, 100, 40, "$$$", new Color(0,0,0), new Action(){
				public void act(){
					buyText.setText("You have dofgjsioprjhbilr3");
				}
			});
			makeMoneyButton4 = new Button(891, 280, 100, 40, "$$$", new Color(0,0,0), new Action(){
				public void act(){
					buyText.setText("You have dofgjsioprjhbilr4");
				}
			});
			makeMoneyButton5 = new Button(521, 380, 100, 40, "$$$", new Color(0,0,0), new Action(){
				public void act(){
					buyText.setText("You have dofgjsioprjhbilr5");
				}
			});
			makeMoneyButton6 = new Button(891, 380, 100, 40, "$$$", new Color(0,0,0), new Action(){
				public void act(){
					buyText.setText("You have dofgjsioprjhbilr6");
				}
			});
			makeMoneyButton7 = new Button(521, 480, 100, 40, "$$$", new Color(0,0,0), new Action(){
				public void act(){
					buyText.setText("You have dofgjsioprjhbilr7");
				}
			});
			makeMoneyButton8 = new Button(891, 480, 100, 40, "$$$", new Color(0,0,0), new Action(){
				public void act(){
					buyText.setText("You have dofgjsioprjhbilr8");
				}
			});
			
			lemon = new Graphic(260,130,.75, "Resources/icon/dddd3.png");
			newspaper = new Graphic(260,230,.75, "Resources/icon/eeee6.png");
			carwash = new Graphic(260,330,.75, "Resources/icon/ffff2.png");
			pizza = new Graphic(260,430,.75, "Resources/icon/gggg2.png");
			donut = new Graphic(630,130,.75, "Resources/icon/hhhh2.png");		
			shrimp = new Graphic(630,230,.75, "Resources/icon/iiii2.png");		
			hocky = new Graphic(630,330,.75, "Resources/icon/jjjj.png");		
			film = new Graphic(630,430,.75, "Resources/icon/kkkk2.png");
			
			
			viewObjects.add(background);
			viewObjects.add(iconleft);
			
			viewObjects.add(xNumButton);
			viewObjects.add(xNumButton2);
			viewObjects.add(xNumButton3);
			
			viewObjects.add(mangerButton);
			viewObjects.add(statsButton);
			viewObjects.add(restartButton);
			
			viewObjects.add(buyButton1);
			viewObjects.add(buyButton2);
			viewObjects.add(buyButton3);
			viewObjects.add(buyButton4);
			viewObjects.add(buyButton5);
			viewObjects.add(buyButton6);
			viewObjects.add(buyButton7);
			viewObjects.add(buyButton8);
			
			viewObjects.add(makeMoneyButton1);
			viewObjects.add(makeMoneyButton2);
			viewObjects.add(makeMoneyButton3);
			viewObjects.add(makeMoneyButton4);
			viewObjects.add(makeMoneyButton5);
			viewObjects.add(makeMoneyButton6);
			viewObjects.add(makeMoneyButton7);
			viewObjects.add(makeMoneyButton8);
			
			viewObjects.add(lemon);
			viewObjects.add(newspaper);
			viewObjects.add(carwash);
			viewObjects.add(pizza);
			viewObjects.add(donut);		
			viewObjects.add(shrimp);		
			viewObjects.add(hocky);		
			viewObjects.add(film);
			
			viewObjects.add(reset);
			viewObjects.add(buyText);
			
			addAnimation(viewObjects);
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
	private void addAnimation(ArrayList<Visible> viewObjects) {
		// TODO Auto-generated method stub
		AnimatedComponent a = new AnimatedComponent(0,0,56*2,72*2);
		//size of pic on screen
		try{
//			int numberInRow = 1;
//			int rows = 53;
//			int w = 303;
//			int h = 103;
			int numberInRow = 4;
			int rows = 1;
			int w = 56;
			int h = 79;
			ImageIcon icon = new ImageIcon("resources/animatedPic/zanpto_sprite_sheet.png");
			//create a for loop that will take a "sub-length from the sprite grid
			for(int k = 0; k< rows; k++){
				for(int i = 0; i < numberInRow; i++){
					//declare the "cropped image" 
					BufferedImage cropped = new BufferedImage(w,h,BufferedImage.TYPE_INT_ARGB);
					int leftMargin = 0;
					int topMargin = 0;
					int x1 = leftMargin + w*(i%numberInRow);
					int y1 = topMargin + h*(k%numberInRow);
					Graphics2D g = cropped.createGraphics();
					g.drawImage(icon.getImage(), 0, 0, w, h, x1, y1, x1 + w, y1 + h, null);
					//                           compress horizontal
					//								compress vertical
					
					a.addFrame(cropped, 200);
				}
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		viewObjects.add(a);
		a.play();
	}

	public static int getCurrentAmount() {
		// TODO Auto-generated method stub
		return currentAmount;
	}
	public void setMoneyText(String text){
		moneyDisplay.setText(text);
	}
}

