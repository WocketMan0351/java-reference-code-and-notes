package frames;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ClickListener implements ActionListener {
	private int x;

	public ClickListener() {
		x = 0;
	}

	public int getX() {
		return x;
	}

	/**
	 * An action listener that prints a message.
	 */
	public void actionPerformed(ActionEvent event) {
		x += 1;
		System.out.println("I was clicked " + x + " time(s)");
	}

}
