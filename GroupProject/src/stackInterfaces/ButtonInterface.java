package stackInterfaces;

import java.awt.Color;

import guiPractice8.component.Action;

public interface ButtonInterface {
	void setColor(Color color);
	void setAction(Action action);
	boolean isHovered(int x, int y);
}
