package Demos;

import java.awt.Color;
import java.util.List;

import guiPractice8.GUIApplication;
import guiPractice8.component.Action;
import guiPractice8.component.Button;
import guiPractice8.component.ClickableScreen;
import guiPractice8.component.TextLabel;
import guiPractice8.component.Visible;

public class KatDemo extends GUIApplication {
	
	public static Manager manager;

	public KatDemo() {
		manager = new Manager(0, 0);
	}

	@Override
	protected void initScreen() {
		DemoScreen demo = new DemoScreen(getWidth(), getHeight());
		setScreen(demo);
	}

	public static void main(String[] args) {
		KatDemo demo = new KatDemo();
		Thread app = new Thread(demo);
		app.start();
	}
	
	//nested inner class
	private class DemoScreen extends ClickableScreen {
			
		private TextLabel label;
		private Button button;
			 
		public DemoScreen(int width, int height) {
			super(width, height);
			// TODO Auto-generated constructor stub
		}
			 
		@Override
		public void initAllObjects(List<Visible> viewObjects) {
			label = new TextLabel(20, 40, 100, 25, "");
			button = new Button(40, 100, 90, 40, "Button", Color.blue, new Action(){

				@Override
				public void act() {
					//rest of code goes here
				}
				
			});
			
			viewObjects.add(label);
			viewObjects.add(button);
		}
		
	}

}
