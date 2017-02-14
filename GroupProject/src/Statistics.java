/**
 * @author Katherine
 */

public class Statistics implements StatsInterface{
	
	public static int currentBalance;
	public static int lifetimeEarnings;
	public static int[] propertyQuantityArray;
	//public static int[] propertyTimeArray;
	public static int numResets;
	
	private static void main(String[] args){ 
		
		currentBalance = 0;
		lifetimeEarnings = 0;
		
	}
	
	public int getMoney() {
		return currentBalance;
	}
	
//	private void setNewPrice(PropertyButton property, double x){
//		
//		currentBalance -= property.getPrice();
//		double prctIncrease = x;
//		double currentPrice = property.getPrice();
//		property.setPrice(currentPrice*prctIncrease);
//		
//	}
//	
//	private void setNewPayout(PropertyButton property, double x){
//		
//		double prctIncrease = x;
//		currentBalance += property.getPayout();
//		lifetimeEarnings += property.getPayout();
//		double currentPayout = property.getPayout();
//		property.setPayout(currentPayout*prctIncrease);
//		
//	}
	
}