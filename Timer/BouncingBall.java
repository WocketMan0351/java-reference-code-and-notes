package Timer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.Timer;

public class BouncingBall extends JFrame {
	private static final int FRAME_WIDTH = 500;
	private static final int FRAME_HEIGHT = 500;
	private static final int DIAMETER = 20;

	private BounceBallComponent scene;
	private int xDirection = 1;
	private int yDirection = 1;

	public BouncingBall() {
		scene = new BounceBallComponent(DIAMETER);
		add(scene);

		ActionListener listener = new TimerListener();
		final int DELAY = 4; // ms between timer ticks

		Timer t = new Timer(DELAY, listener);
		t.start();

		setSize(FRAME_WIDTH, FRAME_HEIGHT);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	class TimerListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if (scene.getXposition() + 1.5 * DIAMETER >= getWidth() || scene.getXposition() + 1.5 <= 0) {
				xDirection = -1 * xDirection;
			}

			if (scene.getYposition() + 2.75 * DIAMETER >= getHeight() || scene.getYposition() <= 0) {
				yDirection = -1 * yDirection;
			}

			scene.moveRectangleBy(xDirection, yDirection);

		}
	}

	public static void main(String[] args) {
		JFrame frame = new BouncingBall();
	}

}
