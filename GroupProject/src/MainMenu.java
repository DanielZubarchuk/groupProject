import guiPractice.GUIApplication;
import guiPractice.Screen;

public class MainMenu extends GUIApplication {

	public static MainMenuScreen menuScreen;
	public static HistoryScreen histScreen;
	public static SampleScreen sampleScreen;
	public static MainMenu mms;
	
	@Override
	protected void initScreen() {
		menuScreen = new MainMenuScreen(1100, 700);
		histScreen = new HistoryScreen(1100, 700);
		sampleScreen = new SampleScreen(1100, 700);
		setScreen(menuScreen);
	}

	public static void main(String[] args) {
		mms = new MainMenu();
		Thread app = new Thread(mms);
		app.start();
	}

}
