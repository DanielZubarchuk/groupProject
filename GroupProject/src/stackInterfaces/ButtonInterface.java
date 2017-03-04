package src.stackInterfaces;

import java.awt.Color;

import guiPractice.components.Action;

public interface ButtonInterface {
	void setColor(Color color);
	void setAction(Action action);
	boolean isHovered(int x, int y);
}
