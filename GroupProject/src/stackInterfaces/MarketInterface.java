package stackInterfaces;

public interface MarketInterface {

	void updateStock();
	void fillEvents();
	String outputEvent();
	ArrayList<String> getEventHistory();
	int get eventStock();
	double[] getStockPrices();
	double[] getStockGrowths();
	String[] getStockNames();
}
