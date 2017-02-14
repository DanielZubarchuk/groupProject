package guiPractice8.sampleGames;

import guiPractice8.GUIApplication;
import guiPractice8.component.ClickableGraphicScreen;

public class ClickGraphicsGame extends GUIApplication{

	public ClickGraphicsGame() {
		super();
	}

	public static void main(String[] args) {
		ClickGraphicsGame cgg = new ClickGraphicsGame();
		Thread app = new Thread(cgg);
		app.start();
	}

	protected void initScreen() {
		ClickableGraphicScreen gcs = new ClickableGraphicScreen(getWidth(), getHeight());
		
		setScreen(gcs);
	}

}
