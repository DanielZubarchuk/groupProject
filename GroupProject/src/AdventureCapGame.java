
import guiPratice.GUIApplication;
import guiPratice.Screen;

public class AdventureCapGame extends GUIApplication{
	
//	public static ManagerScreen manager;
////	public static AdventureCapScreen demo3;
//	public static AdventureCapGame game;
	
	public static AdventureCapScreen AdvCapDemo;
	public static ManagerScreen manager;
	public static StatsScreen stats;
	
	public static Screen demo;
	
	public static AdventureCapGame game;
	
	public AdventureCapGame() {
		// TODO Auto-generated constructor stub
		setBounds(50,50,1000,600);
	}


	public static void main(String[] args){
		game = new AdventureCapGame();
		Thread app = new Thread(game);
		app.start();
	}
	@Override
	protected void initScreen() {
		// TODO Auto-generated method stub
		//		demo3 = new RichardDemo3(1000, 600);
		AdvCapDemo = new AdventureCapScreen();
		manager = new ManagerScreen(1000, 600);
		stats = new StatsScreen(1000, 600);
		setScreen(demo);
	}

}
