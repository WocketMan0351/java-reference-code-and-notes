package keyboardAndMouseEvents;

import java.awt.Graphics;

import javax.swing.JComponent;

public class RectangleComponent extends JComponent {
	private static final int RECTANGLE_WIDTH = 20;
	private static final int RECTANGLE_HEIGHT = 20;

	private int xLeft;
	private int yTop;

	public RectangleComponent() {
		xLeft = 0;
		yTop = 0;
	}

	public void paintComponent(Graphics g) {
		g.fillRect(xLeft, yTop, RECTANGLE_WIDTH, RECTANGLE_HEIGHT);
	}

	public void moveRectangleTo(int x, int y) {
		xLeft = x;
		yTop = y;
		repaint();
	}

	public void moveRectangleBy(int dx, int dy) {
		xLeft = xLeft + dx;
		yTop = yTop + dy;
		repaint();
	}
}
