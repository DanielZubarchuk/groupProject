/**
 * 
 */
package src.projectComponents;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import guiPractice.TextLabel;

/**
 * @author hotfi
 *
 */
public class ThemedTextLabel extends TextLabel {

	private String text;
	private String font;
	private int size;
	private Color bgcolor;
	
	public ThemedTextLabel(int x, int y, int w, int h, String text) {
		super(x, y, w, h, text);
		this.text = text;
		font = "Helvetica";//yes
		size = 20;
		bgcolor = null;
		update();
	}
	
	public void setBgcolor(Color bgcolor) {
		this.bgcolor = bgcolor;
		update();
	}

	public void setText(String s){
		this.text = s;
		update();
	}
	
	public void setSize(int size){
		this.size = size;
		update();
	}
	
	public void setFont(String font){
		this.font = font;
		update();
	}

	public void update(Graphics2D g) {
		g = clear(); // clears image and gets new graphics
		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);
		if(text != null){
			
			if(bgcolor != null){
				FontMetrics fm = g.getFontMetrics();
				g.setColor(bgcolor);
				g.fillRect(2, getHeight()-5 - fm.getHeight(), fm.stringWidth(text) + 4, fm.getHeight()+fm.getDescent());
			}
			g.setColor(Color.black);
			g.setFont(new Font(font,Font.PLAIN,size));
			g.drawString(text, 4, getHeight()-5);
		}
	}
}
