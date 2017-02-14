package stockMarket;

import java.util.ArrayList;

import java.util.List;
import java.util.Scanner;
import guiPractice8.component.TextLabel;
import guiPractice8.component.Visible;
import stackInterfaces.DanielInterface;

public class Transaction {
	
	private static ArrayList<String> transactionHistory;
	private static ArrayList<Double> transactionPrices;
	
	static Scanner input;
	
	//private static boolean booleanStock;
	
	private static int chosenShareAmount;
	private static String chosenStock;
	private static int i;
	private static double stockPrice;
	
	public static double userBalance = 50000;
	public static String[] secondStocks = {"Blackgate","Apple","Samsung",
			"Glascow","General Motors"};
	public static double[] secondPrices = {100,78,90,120,111,87};
	
	
	
	public Transaction() {
	}

	public static void main(String[] args) {
		Transaction.print("Do you want to buy or sell?");
		if(input.equals("Buy")){
			if(userBalance > 0){
				print("Which stock do you want to buy?");
				findStock();
				print("How many shares of the Stock do you want to buy?");
				stockPrice = Fluctuation.stockPrices[i] * chosenShareAmount;
				if(stockPrice > userBalance){
					userBalance = userBalance - stockPrice;
//					containStocks(chosenStock);
					fillStock(chosenStock);
					fillPrices(stockPrice);
					
					if(userBalance <= 0){
						userBalance += stockPrice;
						print("You do not have enough money!");
						return;
					}
					if(userBalance == 0){
						return;
					}
				}else{
					print("You do not have enough money!");
					return;
				}	
			}else{
				print("You do not have money to buy stocks!"
						+ " Try selling stocks to improve your balance.");
				return;
			}
		}
		if(input.equals("Sell")){
			print("Which stock do you want to sell?");
			findStock();
			print("How many shares of the Stock do you want to sell?");
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
	
//	public String outputEvent(){
//		/**
//		 * Outputs the newest event for text about fluctuation in main screen
//		 */
//		return stocks.get(stocks.size()-1);
//	}
	
	
	
	
	//Code that I probably won't need
	
	public static void print(String s){
        String printString = "";
        int cutoff = 80;
   
        while(s.length() > 0){

            String currentCut = "";
            String nextWord = "";
   
            while(currentCut.length()+nextWord.length() < cutoff && s.length() > 0){
   
                currentCut += nextWord;
                
                s = s.substring(nextWord.length());
                
                int endOfWord = s.indexOf(" ");
   
                if(endOfWord == -1) {
                    endOfWord = s.length()-1;
                }
                nextWord = s.substring(0,endOfWord+1);
            }
   
               printString +=currentCut+"\n";
   
            }
               System.out.print(printString);
	}
	
	public String forceResponse(String[] acceptedResponse){
		String input = Transaction.promptInput();

		while(notAMatch(input, acceptedResponse)){
			Transaction.print("I don't recognize that answer.");
			input = Transaction.promptInput();
		}
		return input;
	}
	
	private boolean notAMatch(String input, String[] acceptedResponse) {

		for(int i = 0; i < acceptedResponse.length; i ++){
			if((Transaction.findKeyword(input, acceptedResponse[i], 0) >= 0) ){
				return false;
			}
		}
		return true;
	}
	
	public static String promptInput() {
        String userInput = input.nextLine();
        return userInput; 
    }

	public static int findKeyword(String searchString, String keyword, int startPsn) {
        //deletes white space
        searchString = searchString.trim();
        searchString = searchString.toLowerCase();
        keyword = keyword.toLowerCase();
//      System.out.println("The phrase is "+searchString);
//      System.out.println("The keyword is "+keyword);
        //find first position of key word
        int psn = searchString.indexOf(keyword);
//      System.out.println("The keyword was found at "+psn);
        
        //keep searching until context keyword found
        while(psn>=0){
            //assume preceded and followed by space
            String before = " ";
            String after = " ";
            //check character in front if it exists
            if(psn>0){
                before = searchString.substring(psn-1, psn);
//              System.out.println("The character before is "+before);
            }
            //check if there is a character after the keyword
            if(psn+keyword.length() < searchString.length()){
                //psn+1 is finding one space after our current psn, so this finds the next word
                after = searchString.substring((psn + keyword.length()), 
                        psn + keyword.length()+1);
//              System.out.println("The character after is "+after);
            }
            if(before.compareTo("a") < 0 && after.compareTo("a") < 0 && noNegations(searchString, psn)){
//              System.out.println("Found "+keyword+" at "+psn);
                return psn;
            }else{
                psn = searchString.indexOf(keyword,psn+1);
//              System.out.println("Did not find " + keyword + ", checking position "+psn);
            }
            
            
        }
        return -1;
    }
	
	private static boolean noNegations(String searchString, int psn) {
        if(psn - 3 >= 0  && searchString.substring(psn-3, psn).equals("no "))
        {
            return false;
        }
        if(psn - 4 >= 0  && searchString.substring(psn-4, psn).equals("not "))
        {
            return false;
        }
        if(psn - 6 >= 0  && searchString.substring(psn-6, psn).equals("never "))
        {
            return false;
        }
        if(psn - 4 >= 0  && searchString.substring(psn-4, psn).equals("n't "))
        {
            return false;
        }
        return true;
        
    }
}
