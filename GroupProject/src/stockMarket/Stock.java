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

	private String stockName;
	private double stockPrice;
	private double growthRate;
	
	public Stock(String s, double d, double g){
		this.stockName = s;
		this.stockPrice = d;
		this.growthRate = g;
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
	public void setStockPrice(double price) {
		this.stockPrice = price;
	}
	public String getStockName() {
		return stockName;
	}
	public void setStockName(String name) {
		this.stockName = name;
	}
	public double getGrowthRate() {
		return growthRate;
	}
	public void setGrowthRate(double growth) {
		this.growthRate = growth;
	}

}
