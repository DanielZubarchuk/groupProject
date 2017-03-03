
/**
 * @author Katherine
 */

public class Statistics implements StatsInterface{
	
	public static double currentBalance;
	public double lifetimeEarnings;
	public static int numResets;
	public static int[] quantityOwnedArray;
	public static int[] propertyTimeArray;
	
	public void instantiateStats(){
		//quantityOwnedArray = new int[8];
		//quantityOwnedArray[0] = 1;
		currentBalance = 0;
		lifetimeEarnings = 0;
		numResets = 0;
	}
	
	
	
	public double getCurrentBalance() {
		return currentBalance;
	}


	public int getNumResets() {
		return numResets;
	}
	
	
	

	public void setMoney(double money) {
		currentBalance = money;
	}




	public int[] getQuantityArray() {
		return quantityOwnedArray;
	}


	public void setQuantityArray(int index, int amount) {
		// TODO Auto-generated method stub
		quantityOwnedArray[index] = amount;
	}


	
	
	
	
//	public void updateBalance(){
//		
//	}
//	
//	public void updateEarnings(){
//		
//	}
	
}