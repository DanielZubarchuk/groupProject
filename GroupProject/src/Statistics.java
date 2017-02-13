public class Statistics {
	
	public static int currentBalance;
	public static int lifetimeEarnings;
	//public static int[] propertyQuantityArray;
	//public static int[] propertyTimeArray;
	//public static int[] multiplier;
	//public static int numResets;
	
	public static PropertyButton property;
	//public PropertyButton[] properties;
	
	private static void main(String[] args){ 
		 
		init(property);
		while(property.isClicked()){
			setNewPrice(property, );
			setNewPayout(property, );
		}
		
	}
	
	private static void init(PropertyButton property){
		property.setQuantity(1);
		property.setLevel(0);
	}
	
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
			double currentPayout = property.getPayout();
			property.setPayout(currentPayout*prctIncrease);
		}
		else if(property.getLevel() != 0 && property.getQuantity() % 25 == 0){
			prctIncrease++;
			currentBalance += property.getPayout();
			double currentPayout = property.getPayout();
			property.setPayout(currentPayout*prctIncrease);
		}	
		
	}
	
}