package dayOfWeekGUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class DOW extends JFrame {
	private JPanel panel;
	private JLabel calculation;
	private JButton button;
	private JTextField month;
	private JTextField day;
	private JTextField year;

	private String[] dayOfWeek = { "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday" };

	class ButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			calculation.setText(dayOfWeek[dayOfWeek(Integer.parseInt(year.getText()), Integer.parseInt(month.getText()),
					Integer.parseInt(day.getText()))]);
		}
	}

	public DOW() {
		panel = new JPanel();
		createComponents();
		add(panel);
	}

	public void createComponents() {
		month = new JTextField(2);
		month.setText("6");
		panel.add(month);

		day = new JTextField(2);
		day.setText("23");
		panel.add(day);

		year = new JTextField(4);
		year.setText("1912");
		panel.add(year);

		button = new JButton("Calculate");
		button.addActionListener(new ButtonListener());
		panel.add(button);

		calculation = new JLabel("Sunday");
		panel.add(calculation);
	}

	private int dayOfWeek(int y, int m, int d) {
		int t[] = { 0, 3, 2, 5, 0, 3, 5, 1, 4, 6, 2, 4 };

		if (m < 3)
			y = y - 1;

		return (y + y / 4 - y / 100 + y / 400 + t[m - 1] + d) % 7;
	}

	public static void main(String[] args) {
		DOW d = new DOW();
		d.setSize(400, 100);
		d.setTitle("Day of the Week Calculator");
		d.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		d.setVisible(true);

	}

}
