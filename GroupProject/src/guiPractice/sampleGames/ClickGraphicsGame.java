package guiPractice.sampleGames;

import guiPractice.GUIApplication;
import guiPractice.component.ClickGraphicScreen;

public class ClickGraphicsGame extends GUIApplication {

	public ClickGraphicsGame() {
		super();
	}

	@Override
	protected void initScreen() {
		// TODO Auto-generated method stub
		ClickGraphicScreen gcs = new ClickGraphicScreen(getWidth(),getHeight());
		setScreen(gcs);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ClickGraphicsGame cgg = new ClickGraphicsGame();
		Thread app = new Thread(cgg);
		app.start();
	}

}
