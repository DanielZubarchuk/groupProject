package src.stackInterfaces;

import src.stockMarket.Transaction;
/**
 * @author Gabriel
 *
 */
public interface MarketInterface {

	void updateStock(Transaction transaction);
	void fillEvents();
	String outputEvent();
	int getEventStock();
}
