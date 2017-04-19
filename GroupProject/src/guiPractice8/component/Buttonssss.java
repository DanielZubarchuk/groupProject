package guiPractice8.component;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import guiPratice.components.Action;


public class Buttonssss extends TextLabel implements Clickable,Visible{

	private Color color;
	private Actions action;
	private boolean enabled;

	public Buttonssss(int x, int y, int w, int h, String text, Color color, Actions action2) {
		super(x, y, w, h, text);
		enabled = true;
		this.color = color;
		this.action = action2;
		update();
	}
	
	public Color getColor(){
		return color;
	}
	
	public void setEnabled(boolean b){
		enabled = b;
		update();
	}
	public boolean isEnabled(){
		return enabled;
	}
	
	public void setColor(Color c){
		color = c;
		update();
	}
	
	public void update(Graphics2D g) {
		g = clear();
		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);
		if(enabled){
			g.setColor(Color.black);
		}else{
			g.setColor(Color.gray);
		}
		g.fillRoundRect(0, 0, getWidth(), getHeight(), 35, 25);
		g.setColor(Color.blue);
		g.drawRoundRect(0, 0, getWidth()-1, getHeight()-1, 35, 25);
		g.setFont(new Font(getFont(),Font.PLAIN,getSize()));
		FontMetrics fm = g.getFontMetrics();
		
		if(getText() != null){
			g.setColor(Color.white);
			String t = getText();
			int cutoff = t.length();
			while(cutoff > 0 && fm.stringWidth(t) > getWidth()){
				cutoff --;
				t = t.substring(0, cutoff);
			}
			g.drawString(t, (getWidth()-fm.stringWidth(t))/2, (getHeight()+fm.getHeight()-fm.getDescent())/2);
		}
	}

	@Override
	public boolean isHovered(int x, int y) {
		return x > getX() && x < getX()+getWidth() && y > getY() && y < getY()+getHeight();
	}

	@Override
	public void act() {
		if(enabled){
			action.act();
		}
	}

	
}