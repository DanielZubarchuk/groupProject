package src.stockMarket;

import guiPractice.GUIApplication;

/**
 * @author Risa
 *
 */
public class UserScreen extends GUIApplication {

	public static UserScreen user;
	public static User userScreen;

	public static StockMainMenu menu;
	
	public static void main(String[] args) {
		user = new UserScreen();
		Thread app = new Thread(user);
		app.start();
	}

	@Override
	protected void initScreen() {
		userScreen = new User(getWidth(), getHeight());
		setScreen(userScreen);
	}
	
}
