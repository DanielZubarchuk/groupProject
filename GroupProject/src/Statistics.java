
/**
 * @author Katherine
 */

public class Statistics implements StatsInterface{
	
	public static double currentBalance;
	public double lifetimeEarnings;
	public static int numResets;
	//public static int[] quantityOwnedArray;
	//public static int[] propertyTimeArray;
	
	public void instantiateStats(){
		//quantityOwnedArray = new int[8];
		//quantityOwnedArray[0] = 1;
		currentBalance = 0;
		lifetimeEarnings = 0;
		numResets = 0;
	}
	
	
	
	@Override
	public double getCurrentBalance() {
		return currentBalance;
	}


	@Override
	public int getNumResets() {
		return numResets;
	}
	
	
	
//	public static double getMoney() {
//		// TODO Auto-generated method stub
//		return currentBalance;
//	}
//
//
//	public static void setMoney(double money) {
//		currentBalance = money;
//	}




//	public static int[] getQuantityArray() {
//		// TODO Auto-generated method stub
//		return quantityOwnedArray;
//	}
//
//
//	public static void setQuantityArray(int index, int amount) {
//		// TODO Auto-generated method stub
//		quantityOwnedArray[index] = amount;
//	}


	
	
	
	
//	public void updateBalance(){
//		
//	}
//	
//	public void updateEarnings(){
//		
//	}
	
}