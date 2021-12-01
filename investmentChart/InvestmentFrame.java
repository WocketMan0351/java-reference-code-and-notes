package investmentChart;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class InvestmentFrame extends JFrame {
	private JButton button;
	private JLabel resultLabel;
	private double balance;
	private JTextField rateField;
	private JLabel rateLabel;
	private ChartComponent chart;

	private static final int FRAME_WIDTH = 400;
	private static final int FRAME_HEIGHT = 400;

	private static final int CHART_WIDTH = 300;
	private static final int CHART_HEIGHT = 300;

	private static final double DEFAULT_RATE = 5;
	private static final double INITIAL_BALANCE = 1000;

	public InvestmentFrame() {
		balance = INITIAL_BALANCE;
		resultLabel = new JLabel("Balance: " + Math.floor(balance * 100) / 100);

		chart = new ChartComponent(5 * INITIAL_BALANCE);
		chart.setPreferredSize(new Dimension(CHART_WIDTH, CHART_HEIGHT)); // default is 0x0 pixels
		chart.append(INITIAL_BALANCE);

		createTextField();
		createButton();
		createPanel();
		setSettings();
	}

	class AddInterestListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			double rate = Double.parseDouble(rateField.getText());
			double interest = balance * rate / 100;
			balance += interest;
			resultLabel.setText("Balance: " + Math.floor(balance * 100) / 100);
			chart.append(balance);
		}
	}

	public void createTextField() {
		rateLabel = new JLabel("Interest Rate: ");

		final int FIELD_WIDTH = 10;
		rateField = new JTextField(FIELD_WIDTH);
		rateField.setText("" + DEFAULT_RATE);
	}

	public void createButton() {
		button = new JButton("Add Interest");

		button.addActionListener(new AddInterestListener());
	}

	public void createPanel() {
		JPanel panel = new JPanel();
		panel.add(rateLabel);
		panel.add(rateField);
		panel.add(button);
		panel.add(resultLabel);
		panel.add(chart);
		add(panel);
	}

	public void setSettings() {
		setSize(FRAME_WIDTH, FRAME_HEIGHT);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

	public static void main(String[] args) {
		JFrame demo = new InvestmentFrame();
	}
}
