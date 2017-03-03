/*
 * author joey
 */
public interface StatsInterface {
	double getCurrentBalance();
	void setMoney(double money);
	int[] getQuantityArray();
	void setQuantityArray(int index, int amount);
}
