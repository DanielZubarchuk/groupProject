
/**
 * @author Katherine
 */

import java.util.ArrayList;

public class History implements HistoryInterface {
	
	public static ArrayList<String> history;
	private static RichardDemoInterface h;

	@Override
	public void updateHistory(int cost, String property) {	
		String temp;
		temp = "You purchased " + h.getQuantity() + " " + property + "for " + cost;
		if(history.size() == 10){
			history.remove(0);
			history.add(temp);
		}
		else{
			history.add(temp);
		}	
	}

}
