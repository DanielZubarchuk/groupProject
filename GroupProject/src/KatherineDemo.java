import java.awt.Color;
import java.util.ArrayList;


import guiPractice8.component.Actions;
import guiPractice8.component.Visible;

public class KatherineDemo extends JoeyDemo {

	private static KatherineDemo demo;
	private static KatherineScreen screen;
	
	
	public static void main(String[] args) {
		demo = new KatherineDemo();
		Thread app = new Thread(demo);
		app.start();
	}
	
	protected void initScreen() {
		screen = new KatherineScreen(1000, 600);
		setScreen(screen);
	}

	protected class KatherineScreen extends DemoScreen{

		public KatherineScreen(int width, int height) {
			super(width, height);
			// TODO Auto-generated constructor stub
		}
		
		public void managers(){
			setLemonManager(new ManagerButton(220, 130, 200, 40, "Manage $100", new Color(255,255,0), new Actions(){
				public void act(){
					if(playerMoney>=getLemonManager().getPricexd()){
						lemonMoney.setEnabled(false);
						viewObjects.remove(getLemonManager());
						boolean x = true;
						while(x){							
						lemonMoney.act();
						}
					}
				}
			},100));
			
		}
		
		protected void addManagers(ArrayList<Visible> viewObjects) {
			viewObjects.add(getLemonManager());

		}
		
	}
	
	
	
}
