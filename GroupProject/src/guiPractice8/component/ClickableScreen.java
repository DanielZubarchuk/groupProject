package guiPractice8.component;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

import guiPractice8.Screen;

public abstract class ClickableScreen extends Screen implements MouseListener{

	private ArrayList<Clickable> clickables;
	
	public abstract void initAllObjects(List<Visible> viewObjects);
	
	public ClickableScreen(int width, int height) {
		super(width, height);
	}

	public void initObjects(ArrayList<Visible> viewObjects) {
		initAllObjects(viewObjects);
		clickables = new ArrayList<Clickable>();
		for (int i = 0; i < viewObjects.size(); i ++){
			if (viewObjects.get(i) instanceof Clickable)clickables.add((Clickable) viewObjects.get(i));
		}
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		for (int i = 0; i < clickables.size(); i++){
			Clickable c = clickables.get(i);
			if(c.isHovered(e.getX(), e.getY())){
				c.act();
					break;
			}
		}

	}

	@Override
	public void mouseEntered(MouseEvent e) {
	}

	@Override
	public void mouseExited(MouseEvent e) {
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		
	}
	
	public MouseListener getMouseListener(){
		return this;
	}
	
	public void addObject(Visible v){
		 super.addObject(v);
		 if(v instanceof Clickable){
			 clickables.add((Clickable)v);
		 }
	}
		 

		 
	public void remove(Visible v){
		 super.remove(v);
		 clickables.remove(v);
	} 

	

}
