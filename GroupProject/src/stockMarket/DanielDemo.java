/**
 * 
 */
package stockMarket;

import java.awt.Color;
import java.util.List;

import guiPractice8.GUIApplication;
import guiPractice8.component.Action;
import guiPractice8.component.Button;
import guiPractice8.component.ClickableScreen;
import guiPractice8.component.TextLabel;
import guiPractice8.component.Visible;

/**
 * @author hotfi
 *
 */
public class DanielDemo extends GUIApplication {

	public static Fluctuation fluctuation;
	/**
	 * 
	 */
	public DanielDemo() {
		fluctuation = new Fluctuation();
	}

	/* (non-Javadoc)
	 * @see guiPractice8.GUIApplication#initScreen()
	 */
	@Override
	protected void initScreen() {
		DemoScreen demo = new DemoScreen(getWidth(), getHeight());
		setScreen(demo);

	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		DanielDemo demo = new DanielDemo();
		Thread app = new Thread(demo);
		app.start();

	}
	
	//nested inner class;
	private class DemoScreen extends ClickableScreen{

		private TextLabel rewardDisplay;
		private Button beatAMonster;
		
		public DemoScreen(int width, int height) {
			super(width, height);
			// TODO Auto-generated constructor stub
		}

		@Override
		public void initAllObjects(List<Visible> view) {
			rewardDisplay = new TextLabel(20, 40, 800, 25, "");
			beatAMonster = new Button(40, 100, 190, 40, "Beat a monster", Color.blue, new Action() {
				
				@Override
				public void act() {
					VictorDemo.fluctuation.outputEvent();
					rewardDisplay.setText("You earned a reward! Total points = "
							+ DanielDemo.fluctuation.outputEvent());
				}
			});
			view.add(rewardDisplay);
			view.add(beatAMonster);
		}
		
	}

}
