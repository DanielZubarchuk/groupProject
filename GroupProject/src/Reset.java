
/**
 * @author Katherine
 */

public class Reset {
	
	private static StatsInterface stats;
	private int currentBalance = stats.getCurrentBalance();
	private int numResets = stats.getNumResets();
	private int lastCurrentBalance = 0;
	private boolean received = false;
	private int numInvestors;

	public void main(String[] args) {
		
		getInvestors();
		setCurrentBalance();
		//Anything else in betweeen I have to reset?
		setNumResets();
		
	}
	
	public int getInvestors(){
		int rounds = numTimes(currentBalance - lastCurrentBalance);	
		if(lastCurrentBalance > currentBalance){
			received = true;
			return numInvestors;
		}
		else if(received == false){
			lastCurrentBalance = currentBalance;
			if(currentBalance == 0){
				numInvestors = numInvestors + (3*rounds);
			}
			else{
				numInvestors = numInvestors + (3*rounds) + 1;
			}
		}
		
		return numInvestors;
	}
	
	public int numTimes(int balance){
		int rounds = 0;
		if(balance%5000 == 0){
			while(balance > 0){
				balance = balance - 5000;
				rounds++;
			}
		}
		
		return rounds;
	}
	
	public int setCurrentBalance(){
		return currentBalance = 0;
	}
	
	public int setNumResets(){
		return numResets++;
	}

}
