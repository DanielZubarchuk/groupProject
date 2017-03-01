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
	private static double growthRate;
	
	public Stock(String s, double d, double g){
		setStockName(s);
		setStockPrice(d);
		setGrowthRate(g);
	}
	/* (non-Javadoc)
	 * @see stackInterfaces.StockInterface#getStockName(java.lang.String)
	 */
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {

	}
	public double getStockPrice() {
		return stockPrice;
	}
	public void setStockPrice(double stockPrice) {
		Stock.stockPrice = stockPrice;
	}
	public String getStockName() {
		return stockName;
	}
	public void setStockName(String stockName) {
		Stock.stockName = stockName;
	}
	public double getGrowthRate() {
		return growthRate;
	}
	public void setGrowthRate(double growthRate) {
		Stock.growthRate = growthRate;
	}

}
