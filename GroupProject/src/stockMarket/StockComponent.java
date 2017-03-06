package stockMarket;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.util.ArrayList;
import java.util.List;

import guiPractice.components.Component;
import stackInterfaces.DanielInterface;
import stackInterfaces.StockInterface;
import stackInterfaces.StockInventory;

/**
 * @author Risa
 *
 */

public class StockComponent extends Component implements DanielInterface{
	
	private Color c = new Color(0, 0, 0, 1);
	
	private StockInventory inventory;
	
	private int viewAll;
	private final int ALL_STOCKS = 0;
	private final int ALL_TRANSACTIONS = 1;
	
	public static ArrayList<String> history = new ArrayList<String>();
	public static List<ArrayList<String>> currentStocks = new ArrayList<ArrayList<String>>();
	
	public StockComponent(int x, int y, int w, int h, StockInventory inventory, int viewAll) {
		super(x, y, w, h);
		this.inventory = inventory;
		this.viewAll = viewAll;
		
		update();
	}

	@Override
	public void update(Graphics2D g) {
		FontMetrics f = g.getFontMetrics();
		
		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g.setColor(Color.black);
		
		g.drawRect(0, 0, getWidth() - 1, getHeight() - 1);
		
		
		if(viewAll == ALL_TRANSACTIONS){
			if(inventory != null && !inventory.getStocks().isEmpty()){
				int y = 15;
				
				for(StockInterface s : inventory.getStocks()){
					int x = 4;
					
					g.drawString("You bought " + Integer.toString(s.getStockQuantity()) + " " + s.getStockName() + " for $" + Double.toString(s.getStockPrice()), x, y);
					
					y += 20;
					
					addTransaction(s.getStockName(), s.getStockPrice(), s.getStockQuantity());
				}
			}
			
			if(history.isEmpty()){
				g.drawString("You have no previous transactions!", 4, 15);
			}
			
			return;
		}
		
		if(viewAll == ALL_STOCKS){
			if(inventory != null && !inventory.getStocks().isEmpty()){
				
				int y = 15;
				
				for(StockInterface s : inventory.getStocks()){
					int x = 4;
					
					g.drawString(s.getStockName(), x, y);
					
					int strWidth = f.stringWidth(s.getStockName());
					
					g.drawString("$" + Double.toString(s.getStockPrice()), x + strWidth + 10, y);
					
					y += 20;
					
					addStock(s.getStockName(), s.getStockQuantity());
				}
			}
			
			if(currentStocks.isEmpty()){
				g.drawString("You don't own any stocks!", 4, 15);
			}
			return;
		}
	}
	
	public void addTransaction(String name, double price, int quantity) {
		String temp = "You bought " + Integer.toString(quantity) + " " + name + " for " + Double.toString(price);
		history.add(temp);
	}

	public void addStock(String name, double price) {
		
		boolean which = false;
		
		for(int i = 0; i < currentStocks.size(); i++){
			if(currentStocks.get(i).get(0).equals(name)){
				currentStocks.get(i).set(1, Double.toString(price));
				which = true;
				break;
			}	
		}
		
		if(!which){
			ArrayList<String> temp = new ArrayList<String>();
			temp.add(name);
			temp.add(Double.toString(price));
			currentStocks.add(temp);
		}
		
	}

	
}