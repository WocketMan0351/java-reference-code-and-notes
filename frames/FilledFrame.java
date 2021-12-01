package frames;

import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class FilledFrame extends JFrame {
	private JButton button;
	private JLabel label;
	private static final int FRAME_WIDTH = 400;
	private static final int FRAME_HEIGHT = 400;

	// CAN PUT MAIN METHOD HERE
//	public static void main(String[] args) {
//		JFrame frame = new FilledFrame();
//		frame.setTitle("A frame with 2 components");
//		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		frame.setVisible(true);
//	}

	public FilledFrame() {
		createComponents();
		setSize(FRAME_WIDTH, FRAME_HEIGHT);
	}

	private void createComponents() {
		button = new JButton("Button");
		label = new JLabel("Buy BTC!");
		JPanel panel = new JPanel();
		panel.add(button);
		panel.add(label);
		add(panel);

		ActionListener listener = new ClickListener();
		button.addActionListener(listener);
	}
}
