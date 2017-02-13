package stockMarket;

import java.awt.Graphics2D;

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
		int x = 0;
		if(inventory != null){
			for(StockInterface s : inventory.getStocks()){
				
				x += 40;
			}
		}
	}

}
