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
	
	public static ArrayList<String> transactionHistory = new ArrayList<String>();
	public static ArrayList<Double> transactionPrices  = new ArrayList<Double>();
	public static ArrayList<StockInterface> stocks = new ArrayList<StockInterface>();
	
	
	static Scanner input;
	
	private static int chosenShareAmount = 1;
	
	public static String chosenStock;
	private static int i;
	private static int buyIndex = 0;
	public static double stockPrice;
	private static Object choiceSelection;
	
	public static double userBalance = 50000;
	public static String[] stockNames = {"Blackgate","Apple","Samsung",
			"Glascow","General Motors"};
	public static double[] stockPrices = {100,78,90,120,111,87};
	
	public Transaction(){
		fillStockArray();
	}
	
	public static void buyAStock(){
		chosenStock = stockNames[buyIndex];
		buyIndex = (buyIndex + 1) % stockNames.length;
		if(userBalance > 0){
			findStock();
			stockPrice = stocks.get(buyIndex).getStockPrice() * chosenShareAmount;
			if(stockPrice < userBalance){
				userBalance = userBalance - stockPrice;
//				containStocks(chosenStock);
				fillStock(chosenStock);
				fillPrices(stockPrice);
				
				if(userBalance <= 0){
					userBalance += stockPrice;
					return;
				}
				if(userBalance == 0){
					return;
				}
			}else{
				return;
			}	
		}else{
			return;
		}
	}
	
	public static void sellAStock(){
		findStock();
		userBalance = (stocks.get(buyIndex).getStockPrice() * chosenShareAmount) + userBalance;
	}
	
	private static void fillStock(String stk) {
		System.out.println(stk);
		transactionHistory.add(0,stk);
	}
	
	private static void fillPrices(double prc){
		System.out.println(prc);
		transactionPrices.add(0,prc);
	}
	
	public static int findStock(){
		//helper method
		
		for(int i = 0;i < stocks.size(); i++){
			if(chosenStock.equals(stocks.get(i).getStockName())){
				return i;
			}
		}
		return -1;
	}

//	@Override
//	public ArrayList<StockInterface> getStocks() {
//		for(int a = 0;a < transactionHistory.size(); a++){
//			Stock s = new Stock(transactionHistory.get(a), transactionPrices.get(a));
//			stocks.add(s);
//		}
//		return stocks;
//	}
	
	public void fillStockArray(){
		for(int a = 0; a < stockNames.length; a++){
			Stock s = new Stock(stockNames[a], stockPrices[a]);
			stocks.add(s);
		}
	}

	@Override
	public ArrayList<StockInterface> getStocks() {
		return stocks;
	}
}
