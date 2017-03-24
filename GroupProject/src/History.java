
/**
 * @author Katherine
 */

import java.util.ArrayList;

public class History {
	
	public static ArrayList<String> history;
	private static AdventureCapScreenInterface h;

	public static void updateHistory(int cost, String property) {	
		String temp;
		temp = "You purchased " + h.getCurrentAmount() + " " + property + "for " + cost;
		if(history.size() == 10){
			history.remove(0);
			history.add(temp);
		}
		else{
			history.add(temp);
		}	
	}

}
