package guiPractice8.component;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

import guiPractice8.Screen;

public abstract class ClickableScreen extends Screen implements MouseListener{

	private ArrayList<Clickable> clickables;


	public ClickableScreen(int width, int height) {
		super(width, height);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void initObjects(ArrayList<Visible> viewObjects) {
		// TODO Auto-generated method stub
		initAllObjects(viewObjects);
		clickables = new ArrayList<Clickable>();
		for(Visible obj:viewObjects){
			if(obj instanceof Clickable){
				clickables.add((Clickable) obj);
			}
		}
	}

	public MouseListener getMouseListener(){
		return this;
	}




	public abstract void initAllObjects(List<Visible> v);



	public void addObject(Visible v){
		super.addObject(v);
		if(v instanceof Clickable){
			clickables.add((Clickable) v);
		}
	}



	public void remove(Visible v){
		super.remove(v);
		clickables.remove(v);
	} 



	@Override
	public void mouseClicked(MouseEvent m) {
		// TODO Auto-generated method stub
		for(int i = 0; i<clickables.size(); i++){
			Clickable c = clickables.get(i);
			if(c.isHovered(m.getX(), m.getY())){
				c.act();
				break;
			}


		}
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

}
