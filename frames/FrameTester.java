package frames;

import javax.swing.JFrame;

public class FrameTester {

	public static void main(String[] args) {
		JFrame frame = new FilledFrame();
		frame.setTitle("A frame with 2 components");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

}
