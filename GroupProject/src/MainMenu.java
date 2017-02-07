import guiPractice.GUIApplication;

public class MainMenu extends GUIApplication {

	public static MainMenuScreen menuScreen;
	public static MainMenu mms;
	
	@Override
	protected void initScreen() {
		menuScreen = new MainMenuScreen(getWidth(), getHeight());
		setScreen(menuScreen);
	}

	public static void main(String[] args) {
		mms = new MainMenu();
		Thread app = new Thread(mms);
		app.start();
	}

}
