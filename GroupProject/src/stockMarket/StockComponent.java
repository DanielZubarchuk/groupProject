package stockMarket;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.util.ArrayList;

import guiPractice.components.Component;
import stackInterfaces.StockInterface;
import stackInterfaces.StockInventory;

/**
 * @author Risa
 *
 */

public class StockComponent extends Component {
	
	private StockInventory inventory;
	
	private int viewAll;
	private final int ALL_STOCKS = 0;
	private final int ALL_TRANSACTIONS = 1;
	private final int _STOCK = 3;
	private final int _TRANSACTION = 4;
	
	public StockComponent(int x, int y, int w, int h, StockInventory inventory, int viewAll) {
		super(x, y, w, h);
		this.inventory = inventory;
		this.viewAll = viewAll;
	}

	@Override
	public void update(Graphics2D g) {
		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g.setColor(Color.black);
		
		int y = 0;
		
		if(User.history.isEmpty()){
			g.drawString("You have no previous transactions!", 100, 55);
			return;
		}else{
			
			if(viewAll == ALL_TRANSACTIONS){
				viewAllTransactions(g);
				return;
			}
			
			if(viewAll == _TRANSACTION){
				
				return;
			}
			
		}
		
		if(User.stocksInventory.isEmpty()){
			g.drawString("You don't own any stocks!", 10, 170);
			return;
		}else{
			
			if(viewAll == ALL_STOCKS){
				viewAllStocks(g);
				return;
			}
			
			
			if(viewAll == _STOCK){
				
				return;
			}
			
		}
		
		
		if(inventory != null && !inventory.getStocks().isEmpty()){
			clear();
			System.out.println("b");
			for(StockInterface s : inventory.getStocks()){
				int x = 35;
				
				g.fillRect(10, y, 60, 40);
				g.drawRect(10, y, 60, 40);
				
				
				g.drawString(s.getStockName(), x, y);
				g.drawString(Double.toString(s.getStockPrice()), x + 50, y);
				
				y += 40;
			}
			
			
//			int inventorySize = inventory.getStocks().size();
//			
//			for(int i = inventorySize - 1; i >= 0; i--){
//				
//				StockInterface s = inventory.getStocks().get(i);
//				
//				if(cntr < 3){
//					g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
//					g.setColor(Color.black);
//					g.fillRect(10, y, 60, 40);
//					g.drawRect(10, y, 60, 40);
//				
////					g.drawString(s.getStockName(Transaction.chosenStock) + s.getStockPrice(Transaction.stockPrice), 35, y);
//				
//					y += 40;
//					cntr++;
//				}else{
//					displayAll(g);
//				}
//			}
		}
	}
	
	private void viewAllStocks(Graphics2D g) {
		clear();
		
	}

	private void viewAllTransactions(Graphics2D g){
		clear();
		g.drawString("test", 0, 0);
	}
	
	
	
//	public void displayAll(Graphics2D g){
//		clear();
//		int y = 0;
//		for(StockInterface s : inventory.getStocks()){
//			g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
//			g.setColor(Color.black);
//			g.fillRect(10, y, 60, 40);
//			g.drawRect(10, y, 60, 40);
//		
//			g.drawString(s.getStockName(Transaction.chosenStock) + s.getStockPrice(Transaction.stockPrice), 35, y);
//		
//			y += 40;
//		}
//	}
	
}