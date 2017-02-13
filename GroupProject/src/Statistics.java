/**
 * @author Katherine
 */

public class Statistics {
	
	public static int currentBalance;
	public static int lifetimeEarnings;
	public PropertyButton[] properties;
	public static int[] propertyQuantityArray;
	public static int[] propertyTimeArray;
	//public static int[] multiplier;
	//public static int numResets;
	
	
	
	private static void main(String[] args){ 
		
		
		
	}
	
//	private static void init(PropertyButton property){
//		property.setQuantity(1);
//		property.setLevel(0);
//	}
	
	private void setNewPrice(PropertyButton property, double x){
		
		currentBalance -= property.getPrice();
		double prctIncrease = x;
		double currentPrice = property.getPrice();
		property.setPrice(currentPrice*prctIncrease);
		
	}
	
	private void setNewPayout(PropertyButton property, double x){
		
		double prctIncrease = x;
		if(property.getLevel() == 0){
			currentBalance += property.getPayout();
			lifetimeEarnings += property.getPayout();
			double currentPayout = property.getPayout();
			property.setPayout(currentPayout*prctIncrease);
		}
		else if(property.getLevel() != 0 && property.getQuantity() % 25 == 0){
			prctIncrease++;
			currentBalance += property.getPayout();
			lifetimeEarnings += property.getPayout();
			double currentPayout = property.getPayout();
			property.setPayout(currentPayout*prctIncrease);
		}	
		
	}
	
}