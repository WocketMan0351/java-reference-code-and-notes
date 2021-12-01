package keyboardAndMouseEvents;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.KeyStroke;

public class RectangleFrame extends JFrame {
	private static final int FRAME_WIDTH = 400;
	private static final int FRAME_HEIGHT = 500;

	private RectangleComponent scene;

	class MousePressListener extends MouseAdapter {
		public void mousePressed(MouseEvent e) {
			int x = e.getX();
			int y = e.getY();
			scene.moveRectangleTo(x, y);
		}
	}

	class KeyStrokeListener implements KeyListener {
		public void keyPressed(KeyEvent e) {
			String key = KeyStroke.getKeyStrokeForEvent(e).toString().replace("pressed ", "");
			System.out.println(key);

			if (key.equals("DOWN")) {
				scene.moveRectangleBy(0, 8);
			} else if (key.equals("UP")) {
				scene.moveRectangleBy(0, -8);
			} else if (key.equals("LEFT")) {
				scene.moveRectangleBy(-8, 0);
			} else if (key.equals("RIGHT")) {
				scene.moveRectangleBy(8, 0);
			}
		}

		public void keyTyped(KeyEvent e) {
		}

		public void keyReleased(KeyEvent e) {
		}
	}

	public RectangleFrame() {
		scene = new RectangleComponent();
		add(scene);

		scene.addMouseListener(new MousePressListener());

		scene.addKeyListener(new KeyStrokeListener());
		scene.setFocusable(true);
	}

	public static void main(String[] args) {
		JFrame frame = new RectangleFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
		frame.setVisible(true);
	}

}
