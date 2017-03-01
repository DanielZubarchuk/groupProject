
/**
 * @author Katherine
 */

import java.util.ArrayList;

public class History {
	
	public static ArrayList<String> history;
	private static HistoryInterface h;

	public static void main(String[] args) {
		String temp;
		temp = "You purchased " + h.getQuantity() + " " + h.getProperty() + "for " + h.getPrice();
		if(history.size() == 10){
			history.remove(0);
			history.add(temp);
		}
		else{
			history.add(temp);
		}
	}

}
