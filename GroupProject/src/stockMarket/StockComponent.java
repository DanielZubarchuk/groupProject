package stockMarket;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.util.ArrayList;

import guiPractice8.component.Component;
import stackInterfaces.StockInterface;
import stackInterfaces.StockInventory;

public class StockComponent extends Component {

	private StockInventory inventory;
	private ArrayList<String> stocks;
	
	public StockComponent(int x, int y, int w, int h, StockInventory inventory) {
		super(x, y, w, h);
		this.inventory = inventory;
	}

	@Override
	public void update(Graphics2D g) {
		int cntr = 0;
		int y = 0;
		if(inventory != null && !inventory.getStocks().isEmpty()){
			clear();
			int inventorySize = inventory.getStocks().size();
			
			for(int i = inventorySize - 1; i >= 0; i--){
				
				StockInterface s = inventory.getStocks().get(i);
				
				if(cntr < 3){
					g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
					g.setColor(Color.black);
					g.fillRect(10, y, 60, 40);
					g.drawRect(10, y, 60, 40);
				
					g.drawString(s.getStockName(Transaction.chosenStock) + s.getStockPrice(Transaction.stockPrice), 35, y);
				
					y += 40;
					cntr++;
				}else{
					displayAll(g);
				}
			}
		}
	}
	
	public void displayAll(Graphics2D g){
		clear();
		int y = 0;
		for(StockInterface s : inventory.getStocks()){
			g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
			g.setColor(Color.black);
			g.fillRect(10, y, 60, 40);
			g.drawRect(10, y, 60, 40);
		
			g.drawString(s.getStockName(Transaction.chosenStock) + s.getStockPrice(Transaction.stockPrice), 35, y);
		
			y += 40;
		}
	}
	
}
