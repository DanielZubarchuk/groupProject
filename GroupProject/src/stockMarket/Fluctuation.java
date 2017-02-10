/**
 * 
 */
package stockMarket;

import java.util.ArrayList;

/**
 * @author hotfi
 *
 */
public class Fluctuation{

	/**
	 * FIELDS
	 */
	//events
	private ArrayList<String> events;
	private static double currentEvent = 0;
	
	//stocks array
	public static String[] stockNames = {"Blackgate","Apple","Samsung","Glascow","General Motors"};
	public static double[] stockPrices = {100,78,90,120,111,87};
	private double[] stockGrowths = {1.1,2.6,1.3,.8,.9,2.0};
	
	//constants
	private static final int _BANKRUPT = 0;
	private static final int _RECESSION = 1;
	private static final int _STABILITY = 2;
	private static final int _PROGRESS = 3;
	private static final int _FORTUNE = 4;
	
	public Fluctuation() {
		events = new ArrayList<String>();
		fillEvents();
	}
	
	/**
	 * Nockles Suggestion:
	 * Make a limitOrderInterface that allows the user to 
	 * set a queue of stocks that the user insta-sells/buys if
	 * a certain stock value is reached. 
	 * Maybe an arrayList to represent that queue.
	 * 
	 *  boolean limitReached
	 *  void buy
	 *  void sell
	 */

	public void updateStock(){
		/**
		 * Each time END TURN is clicked, the anonymous inner class (act) should call this method to update the stocks.
		 */
		fillEvents();
		
		int eventStock = (int) (Math.random()*stockNames.length-1);
		double effect = currentEvent/2;
		double newGrowth = stockGrowths[eventStock] * effect;
		double newPrice = stockPrices[eventStock] * newGrowth;
		
		stockGrowths[eventStock] = newGrowth;
		stockPrices[eventStock] = newPrice;
		
	}
	
	public void fillEvents(){
		
		int randomEvent = (int) (Math.random()*5);
		currentEvent = (double) (randomEvent);
		
		if(randomEvent == _BANKRUPT){
			events.add("BANKRUPT");
		}else{
			if(randomEvent == _RECESSION){
				events.add("RECESSION");
			}else{
				if(randomEvent == _STABILITY){
					events.add("STABILITY");
				}else{
					if(randomEvent == _PROGRESS){
						events.add("PROGRESS");
					}else{
						if(randomEvent == _FORTUNE){
							events.add("FORTUNE");
						}
					}
				}
			}
		}
	}

	public String outputEvent(){
		/**
		 * Outputs the newest event for text about fluctuation in main screen
		 */
		return events.get(events.size()-1);
	}

}
