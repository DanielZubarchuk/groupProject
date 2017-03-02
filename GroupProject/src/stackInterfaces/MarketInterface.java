package stackInterfaces;

import stockMarket.Transaction;

public interface MarketInterface {

	void updateStock(Transaction transaction);
	void fillEvents();
	String outputEvent();
	int getEventStock();
}
