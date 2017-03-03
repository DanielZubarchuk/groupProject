package src.stackInterfaces;

import java.util.ArrayList;

import guiPractice.components.Button;
/**
 * @author Victor
 *
 */
public interface StockMenuInterface {
	void selectStock(String stock);
	void printStocks(ArrayList<Button> buttons);
	void createStocks();
}
