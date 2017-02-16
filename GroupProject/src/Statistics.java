/**
 * @author Katherine
 */

public class Statistics implements StatsInterface{
	
	public static int currentBalance;
	public static int lifetimeEarnings;
	public static int[] propertyQuantityArray;
	//public static int[] propertyTimeArray;
	public static int numResets;
	
	public int getMoney() {
		return currentBalance;
	}
	
//	public void updateBalance(){
//		
//	}
//	
//	public void updateEarnings(){
//		
//	}

	@Override
	public void setMoney() {
		// TODO Auto-generated method stub
		
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