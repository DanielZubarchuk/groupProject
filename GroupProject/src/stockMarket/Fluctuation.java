/**
 * 
 */
package stockMarket;

import java.util.ArrayList;

import stackInterfaces.MarketInterface;

/**
 * @author Victor
 *
 */
public class Fluctuation implements MarketInterface{

	/**
	 * FIELDS
	 */
	//events
	private ArrayList<String> events;
	private static ArrayList<String> eventHistory;
	private static int currentEvent = 0;
	private int eventStock;
	

	//stocks array
//	private static String[] stockNames = {"Blackgate","Apple","Samsung","Glascow","General Motors"};
//	private static double[] stockPrices = {100,78,90,120,111,87};
//	private static double[] stockGrowths = {1.1,2.6,1.3,.8,.9,2.0};
	
	//constants
	private static final int _BANKRUPT = 0;
	private static final int _RECESSION = 1;
	private static final int _STABILITY = 2;
	private static final int _PROGRESS = 3;
	
	public Fluctuation() {
		events = new ArrayList<String>();
		eventHistory = new ArrayList<String>();
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

	public void updateStock(Transaction transaction){
		/**
		 * Each time BUY/SELL is clicked, the anonymous inner class (act) should call this method to update the stocks.
		 */
		eventStock = (int) (Math.random()*transaction.getStocks().size());
		fillEvents();
			
		if((int)(transaction.getStocks().get(eventStock).getStockPrice()) == _BANKRUPT){
			reviveStock(eventStock, transaction);
		}
		double effect = currentEvent/2;
		double newGrowth = transaction.getStocks().get(eventStock).getGrowthRate() * effect;
		double newPrice = transaction.getStocks().get(eventStock).getStockPrice() * newGrowth;
		
		transaction.getStocks().get(eventStock).setGrowthRate(newGrowth);
		transaction.getStocks().get(eventStock).setStockPrice(newPrice);
		
	}
	
	private void reviveStock(int index, Transaction transaction) {
		transaction.getStocks().get(eventStock).setStockPrice(70);
		transaction.getStocks().get(eventStock).setGrowthRate(1.0);
		
	}

	public void fillEvents(){
		
		int randomEvent = (int) (Math.random()*3)+1;
		currentEvent = randomEvent;
			
		if(randomEvent == _RECESSION){
			events.add("RECESSION");
		}else{
			if(randomEvent == _STABILITY){
				events.add("STABILITY");
			}else{
				if(randomEvent == _PROGRESS){
					events.add("PROGRESS");
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

	public ArrayList<String> getEventHistory() {
		return eventHistory;
	}
	
	public int getEventStock() {
		return eventStock;
	}

}
