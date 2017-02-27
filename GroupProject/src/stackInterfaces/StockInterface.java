package stackInterfaces;

public interface StockInterface {

	public String getStockName();
	public double getStockPrice();
	public double getGrowthRate();
	public void setStockPrice(double stockPrice);
	public void setStockName(String stockName);
	public void setGrowthRate(double growthRate);
}
