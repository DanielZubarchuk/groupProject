
/**
 * @author Katherine
 */

public class Reset implements ResetInterface{
	
	private static StatsInterface stats;
	private double cBalance = stats.getCurrentBalance();
	private int numResets = stats.getNumResets();
	private double lastCurrentBalance = 0;
	private boolean received = false;
	private int numInvestors;

	public void main(String[] args) {
		
		getInvestors();
		setCurrentBalance();
		//Anything else in betweeen I have to reset?
		setNumResets();
		
	}
	
	public int getInvestors(){
		int rounds = numTimes(cBalance - lastCurrentBalance);	
		if(lastCurrentBalance > cBalance){
			received = true;
			return numInvestors;
		}
		else if(received == false){
			lastCurrentBalance = cBalance;
			if(cBalance == 0){
				numInvestors = numInvestors + (3*rounds);
			}
			else{
				numInvestors = numInvestors + (3*rounds) + 1;
			}
		}
		
		return numInvestors;
	}
	
	public int numTimes(double balance){
		int times = 0;
		balance = Math.floor(balance);
		if(balance%25000.00 == 0){
			while(balance > 0){
				balance = balance - 25000.00;
				times++;
			}
		}
		
		return times;
	}
	
	public void setCurrentBalance(){
		Statistics.currentBalance = 0;
	}
	
	public void setNumResets(){
		Statistics.numResets = numResets + 1;
	}

	@Override
	public int getNumInvestors() {
		return numInvestors;
	}

}
