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

	// demo field
	public static int reward;
	/**
	 * FIELDS
	 */
	private ArrayList<String> events;
	//stocks array
	
	public Fluctuation() {
		events = new ArrayList<String>();
		fillEvents();
	}
	
	public void fillEvents(){
		/**
		 * Each time END TURN is clicked, the anonymous inner class (act) should call this method to add a new event.
		 */
		int randomEvent = (int) (Math.random()*5);
		
		if(randomEvent == 0){
			events.add("BANKRUPT");
		}else{
			if(randomEvent == 1){
				events.add("RECESSION");
			}else{
				if(randomEvent == 2){
					events.add("STABILITY");
				}else{
					if(randomEvent == 3){
						events.add("PROGRESS");
					}else{
						if(randomEvent == 4){
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
