package src.stackInterfaces;

/**
 * 	Risa
 */

import java.util.ArrayList;

public interface StockInventory {
	ArrayList<StockInterface> getStocks();
	void fillStockArray();
	int findStock();
	void fillStock(String stk);
	void fillPrices(double prc);
	void buyAStock();
	void sellAStock();
	
}
