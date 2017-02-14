package stockMarket;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import guiPractice8.component.Component;
import stackInterfaces.StockInterface;
import stackInterfaces.StockInventory;

public class StockComponent extends Component {

	
	StockInventory inventory;
	
	public StockComponent(int x, int y, int w, int h, StockInventory inventory) {
		super(x, y, w, h);
		this.inventory = inventory;
	}

	@Override
	public void update(Graphics2D g) {
		int y = 0;
		if(inventory != null){
			System.out.println("inventory");
			for(StockInterface s : inventory.getStocks()){
				g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
				g.setColor(Color.black);
				g.fillRect(10, y, 60, 40);
				g.drawRect(10, y, 60, 40);
				y += 40;
			}
		}
	}

}
