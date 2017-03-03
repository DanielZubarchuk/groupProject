package src.stackInterfaces;

import src.stockMarket.Transaction;
/**
 * @author Victor
 *
 */
public interface MarketInterface {

	void updateStock(Transaction transaction);
	void fillEvents();
	String outputEvent();
	int getEventStock();
}
