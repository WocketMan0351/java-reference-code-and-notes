package Timer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.Timer;

public class MovingRectangle extends JFrame {
	private static final int FRAME_WIDTH = 300;
	private static final int FRAME_HEIGHT = 400;

	private RectangleComponent scene;

	public MovingRectangle() {
		scene = new RectangleComponent();
		add(scene);
		Timer t = new Timer(10, new TimerListener());
		t.start();
	}

	class TimerListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			scene.moveRectangleBy(1, 1);
		}
	}

	public static void main(String[] args) {
		JFrame frame = new MovingRectangle();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
		frame.setVisible(true);
	}

}
