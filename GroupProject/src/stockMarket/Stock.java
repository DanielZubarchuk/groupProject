/**
 * 
 */
package stockMarket;

import stackInterfaces.StockInterface;

/**
 * @author Daniel
 *
 */
public class Stock implements StockInterface {

	private static String stockName;
	private static double stockPrice;
	
	public Stock(String s, double d){
		this.stockName = s;
		this.stockPrice = d;
	}
	/* (non-Javadoc)
	 * @see stackInterfaces.StockInterface#getStockName(java.lang.String)
	 */
	@Override
	public String getStockName(String name) {
		return null;
	}

	/* (non-Javadoc)
	 * @see stackInterfaces.StockInterface#getStockPrice(double)
	 */
	@Override
	public double getStockPrice(double price) {
		return 0;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {

	}

}
