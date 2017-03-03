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
	private int stockQuantity;
	
	public Stock(String s, double d, double g, int q){
		this.stockName = s;
		this.stockPrice = d;
		this.growthRate = g;
		this.stockQuantity = q;
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
		return this.stockPrice;
	}
	public void setStockPrice(double price) {
		this.stockPrice = price;
	}
	public String getStockName() {
		return this.stockName;
	}
	public void setStockName(String name) {
		this.stockName = name;
	}
	public double getGrowthRate() {
		return this.growthRate;
	}
	public void setGrowthRate(double growth) {
		this.growthRate = growth;
	}

	@Override
	public int getStockQuantity() {
		// TODO Auto-generated method stub
		return this.stockQuantity;
	}

}
