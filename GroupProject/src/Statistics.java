
/**
 * @author Katherine
 */

public class Statistics implements StatsInterface{
	
	private double currentBalance;
	public int lifetimeEarnings;
	public int[] quantityOwnedArray;
	//public static int[] propertyTimeArray;
	public int numResets;
	
	public void instantiateStats(){
		quantityOwnedArray = new int[8];
		quantityOwnedArray[0] = 1;
		currentBalance = 0;
		lifetimeEarnings = 0;
		numResets = 0;
	}
	
	
	public double getMoney() {
		// TODO Auto-generated method stub
		return currentBalance;
	}


	public void setMoney(double money) {
		currentBalance = money;
	}




	@Override
	public int[] getQuantityArray() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public void setQuantityArray(int index, int amount) {
		// TODO Auto-generated method stub
		
	}
	
	
	
//	public void updateBalance(){
//		
//	}
//	
//	public void updateEarnings(){
//		
//	}
	
}