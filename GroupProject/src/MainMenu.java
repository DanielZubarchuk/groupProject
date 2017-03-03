package src;

import guiPractice.GUIApplication;
import guiPractice.Screen;
import src.stockMarket.StockMainMenu;
import src.stockMarket.StockMainMenu.MenuScreen;

public class MainMenu extends GUIApplication {

	public static MainMenuScreen menuScreen;
	public static HistoryScreen histScreen;
	public static SampleScreen sampleScreen;
//	nested inner class ??
	public static StockMainMenu.MenuScreen stockLink;
	public static MainMenu mms;
	
	@Override
	protected void initScreen() {
		menuScreen = new MainMenuScreen(1100, 700);
		histScreen = new HistoryScreen(1100, 700);
		sampleScreen = new SampleScreen(1100, 700);

		stockLink = new MenuScreen(1100, 700);
		setScreen(menuScreen);
	}

	public static void main(String[] args) {
		mms = new MainMenu();
		Thread app = new Thread(mms);
		app.start();
	}

}
