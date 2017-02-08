import java.util.List;

import guiPractice8.component.ClickableScreen;
import guiPractice8.component.Visible;

public class AdventureCapScreen extends ClickableScreen{
	
	public AdventureCapScreen(int width, int height) {
		super(width, height);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void initAllObjects(List<Visible> arg0) {
		// TODO Auto-generated method stub
		
		//add "buy" buttons
		addBuyButtons();
		//add "swag & stats" buttons
		addSASButton();
		//add "X + num" button (top right thing that shows multiple buys)
		addXNumButton();
	}

	private void addXNumButton() {
		// TODO Auto-generated method stub
		
	}

	private void addSASButton() {
		// TODO Auto-generated method stub
		int numberOfSASButtons = 3;
//		for(int i = 0; i<numberOfSASButtons; i++){
//			
//		}
	}

	private void addBuyButtons() {
		// TODO Auto-generated method stub
		int numberOfBuyButtons = 8;
		
//		for(int i = 0; i<=numberOfBuyButtons/2; i++){
//			for(int j = 0; j<2; j++){
//				
//			}
//		} 
	}

}
