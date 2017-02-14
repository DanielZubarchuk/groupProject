package stockMarket;

import java.util.ArrayList;

import java.util.List;
import java.util.Scanner;
import guiPractice8.component.TextLabel;
import guiPractice8.component.Visible;
import stackInterfaces.DanielInterface;
import stackInterfaces.StockInterface;
import stackInterfaces.StockInventory;

public class Transaction implements StockInventory{
	
	private static ArrayList<String> transactionHistory;
	private static ArrayList<Double> transactionPrices;
	
	static Scanner input;
	
	//private static boolean booleanStock;
	
	private static int chosenShareAmount;
	private static String chosenStock;
	private static int i;
	private static double stockPrice;
	private static Object choiceSelection;
	
	public static double userBalance = 50000;
	public static String[] secondStocks = {"Blackgate","Apple","Samsung",
			"Glascow","General Motors"};
	public static double[] secondPrices = {100,78,90,120,111,87};
	
	
	
	public Transaction() {
	}

	public static void main(String[] args) {
		//System.out.println("Do you want to buy or sell?");
		if(choiceSelection.equals("Buy")){
			if(userBalance > 0){
				//System.out.println("Which stock do you want to buy?");
				findStock();
				//System.out.println("How many shares of the Stock do you want to buy?");
				stockPrice = Fluctuation.stockPrices[i] * chosenShareAmount;
				if(stockPrice > userBalance){
					userBalance = userBalance - stockPrice;
//					containStocks(chosenStock);
					fillStock(chosenStock);
					fillPrices(stockPrice);
					
					if(userBalance <= 0){
						userBalance += stockPrice;
						//System.out.println("You do not have enough money!");
						return;
					}
					if(userBalance == 0){
						return;
					}
				}else{
					//System.out.println("You do not have enough money!");
					return;
				}	
			}else{
				//System.out.println("You do not have money to buy stocks!"
						//+ " Try selling stocks to improve your balance.");
				return;
			}
		}
		if(choiceSelection.equals("Sell")){
			//System.out.println("Which stock do you want to sell?");
			findStock();
			//System.out.println("How many shares of the Stock do you want to sell?");
			userBalance = (Fluctuation.stockPrices[i] * chosenShareAmount) + userBalance;
		}

	}
	
	private static void fillStock(String stk) {
		transactionHistory.add(stk);
	}
	
	private static void fillPrices(Double prc){
		transactionPrices.add(prc);
	}

//	public void initAllObjects(List<Visible> visible) {
//		transactionHistory = new ArrayList<String>();
//		
//	}
	
	public static int findStock(){
		//helper method
		
		for(int i = 0;i < Fluctuation.stockNames.length; i++){
			if(chosenStock.equals(Fluctuation.stockNames[i])){
				return i;
			}
		}
		return -1;
	}

	@Override
	public ArrayList<StockInterface> getStocks() {
		return null;
	}
	
//	public String outputEvent(){
//	/**
//	 * Outputs the newest event for text about fluctuation in main screen
//	 */
//	return stocks.get(stocks.size()-1);
//}
}
