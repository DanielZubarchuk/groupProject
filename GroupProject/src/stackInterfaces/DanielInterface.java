/**
 * 
 */
package src.stackInterfaces;

import java.util.ArrayList;

/**
 * @author Daniel
 *
 */
public interface DanielInterface {
	ArrayList<StockInterface> getStocksInventory();
	void addStock(String name, Double price);
	void addTransaction(String name, Double price, int quantity);
}
