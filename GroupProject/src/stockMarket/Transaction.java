package stockMarket;

import java.util.ArrayList;

import java.util.List;
import java.util.Scanner;
import guiPractice.TextLabel;
import guiPractice.components.Visible;
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
	
	public static double userBalance = 5000;
	public static String[] stockNames = {"Blackgate","Apple","Samsung",
			"Glascow","General Motors"};
	public static double[] stockPrices = {100,78,90,120,111,87};
	public static double[] stockGrowths = {1.1,1.3,1.2,1.0,1.0,1.2};
	
	public Transaction(){
		fillStockArray();
	}
	
	public void buyAStock(){
		chosenStock = StockMainMenu.selectedStock;
		buyIndex = (buyIndex + 1) % stockNames.length;
		if(userBalance > 0){
			findStock();
			stockPrice = stocks.get(buyIndex).getStockPrice() * chosenShareAmount;
			if(stockPrice < userBalance){
				userBalance = userBalance - stockPrice;
//				containStocks(chosenStock);
				fillStock(chosenStock);
				fillPrices(stockPrice);
			}else{
				return;
			}	
			if(userBalance < stockPrice){
				return;
			}
			if(userBalance == 0){
				return;
			}
		}else{
			return;
		}
	}
	
	public void sellAStock(){
		findStock();
		userBalance = (stocks.get(buyIndex).getStockPrice() * chosenShareAmount) + userBalance;
	}
	
	public void fillStock(String stk) {
		System.out.println(stk);
		transactionHistory.add(0,stk);
	}
	
	public void fillPrices(double prc){
		System.out.println(prc);
		transactionPrices.add(0,prc);
	}
	
	public int findStock(){
		//helper method
		
		for(int i = 0;i < stocks.size(); i++){
			if(chosenStock.equals(stocks.get(i).getStockName())){
				return i;
			}
		}
		return -1;
	}
	
	public void fillStockArray(){
		//helper method
//		for(int a = 0; a < stockNames.length; a++){
//			Stock s = new Stock(stockNames[a], stockPrices[a], stockGrowths[a]);
//			stocks.add(s);
//		}
		stocks.add(new Stock("Blackgate", 100, 1.1));
		stocks.add(new Stock("Apple", 70, 1.4));
		stocks.add(new Stock("Samsung", 80, 1.3));
		stocks.add(new Stock("Glascow", 110, 1.0));
		stocks.add(new Stock("General Motors", 90, 1.2));
	}

	@Override
	public ArrayList<StockInterface> getStocks() {
		return stocks;
	}
	
//	@Override
//	public ArrayList<StockInterface> getStocks() {
//		for(int a = 0;a < transactionHistory.size(); a++){
//			Stock s = new Stock(transactionHistory.get(a), transactionPrices.get(a));
//			stocks.add(s);
//		}
//		return stocks;
//	}
}
