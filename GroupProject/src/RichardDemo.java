import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import guiPractice8.component.ClickableScreen;
import guiPractice8.component.TextLabel;
import guiPractice8.GUIApplication;
import guiPractice8.Screen;
import guiPractice8.component.Action;
import guiPractice8.component.Button;
import guiPractice8.component.Visible;

/**
 * 
 */

/**
 * @author Richard
 *
 */
public class RichardDemo extends GUIApplication {

	public static RichardDemo demos;
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

		private Button buyButton;
		private Button xNumButton;
		private Button xNumButton2;
		private Button xNumButton3;
		private Button mangerButton;
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
						System.out.println("button 3 is " + button2Disabled);
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
			viewObjects.add(xNumButton);
			viewObjects.add(xNumButton2);
			viewObjects.add(xNumButton3);
		}
		
	} 






}