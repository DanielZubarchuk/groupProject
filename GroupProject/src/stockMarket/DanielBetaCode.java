package stockMarket;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import groupFiles.DanielMain;
import guiPractice8.component.TextLabel;
import guiPractice8.component.Visible;
import stackInterfaces.DanielInterface;

public class DanielBetaCode {

	//I am making this as a major template for the project,
	//here I will code my part without implementing your things. When the time is right, 
	//I will fix up the code.
	
	private ArrayList<DanielInterface> stocks;
	static Scanner input;
	
	private String[] stockNames = 
		{"BlackRock", "Yahoo", "Ebay", "AMC Entertainment", "Facebook"};
	
	private String[] stockPrices = 
		{"375.26", "45.04", "33.34", "31.10", "134.00"}; 
	
	private String[] stockInventory = 
		{}; 
	
	public static int userBalance = 5000000;
	
	public DanielBetaCode() {
		
	}

	public static void main(String[] args) {
		DanielBetaCode.print("Do you want to buy or sell?");
		if(choiceSelection.equals("Buy")){
			
		}

	}
	
//	public void initAllObjects(List<Visible> visible) {
//		stocks = new ArrayList<DanielInterface>();
//		
//	}
	
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
		String input = DanielBetaCode.promptInput();

		while(notAMatch(input, acceptedResponse)){
			DanielBetaCode.print("I don't recognize that answer.");
			input = DanielBetaCode.promptInput();
		}
		return input;
	}
	
	private boolean notAMatch(String input, String[] acceptedResponse) {

		for(int i = 0; i < acceptedResponse.length; i ++){
			if((DanielBetaCode.findKeyword(input, acceptedResponse[i], 0) >= 0) ){
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
