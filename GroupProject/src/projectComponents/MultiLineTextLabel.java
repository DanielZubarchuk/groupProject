/**
 * 
 */
package projectComponents;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

/**
 * @author hotfi
 *
 */
public class MultiLineTextLabel extends ThemedTextLabel {

	private String text;
	private String font;
	private int size;
	
	public MultiLineTextLabel(int x, int y, int w, int h, String text) {
		super(x, y, w, h, text);
		this.text = text;
		font = "Helvetica";//yes
		size = 20;
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

//	private void drawString(Graphics2D g, String text, int x, int y) {
//        for (String line : text.split("\n"))
//            g.drawString(line, x, y += g.getFontMetrics().getHeight());
//    }
	
	public void update(Graphics2D g) {
		g = clear(); // clears image and gets new graphics
		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);
		g.setColor(Color.black);
		if(text != null){
			g.setFont(new Font(font,Font.PLAIN,size));
			g.drawString(text, 4, getHeight()-5);
//		    drawString(g, text, 4, getHeight()-5);
//			g.drawString(text, 4, (getHeight()-5) + g.getFontMetrics().getHeight());
		}
	}
}
