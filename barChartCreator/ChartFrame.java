package barChartCreator;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.KeyStroke;

public class ChartFrame extends JFrame {
	private JTextField labelField;
	private JTextField valueField;
	private JButton addButton;
	private JButton removeButton;
	private ChartComponent chart;

	private static final int FRAME_WIDTH = 400;
	private static final int FRAME_HEIGHT = 400;

	private static final int CHART_WIDTH = 300;
	private static final int CHART_HEIGHT = 300;

	private static final String DEFAULT_LABEL = "Description";
	private static final double DEFAULT_VALUE = 100;

	class AddBarListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String label = labelField.getText();
			double value = Double.parseDouble(valueField.getText());
			chart.append(label, value);
		}
	}

	class RemoveBarListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			chart.removeLast();
		}
	}

	class ChartMouseListener extends MouseAdapter {
		public void mousePressed(MouseEvent e) {
			int x = e.getX();
			int y = e.getY();

			chart.click(x, y);
			chart.requestFocus();
		}
	}

	class ChartKeyListener extends KeyAdapter {
		public void keyPressed(KeyEvent e) {
			String key = KeyStroke.getKeyStrokeForEvent(e).toString().replace("pressed ", "");

			if (key.equals("RIGHT")) {
				chart.growSelected(1);
			} else if (key.equals("LEFT")) {
				chart.growSelected(-1);
			} else if (key.equals("DOWN")) {
				chart.changeSelected(1);
			} else if (key.equals("UP")) {
				chart.changeSelected(-1);
			}
		}
	}

	public ChartFrame() {
		chart = new ChartComponent();
		chart.setPreferredSize(new Dimension(CHART_WIDTH, CHART_HEIGHT));
		chart.append(DEFAULT_LABEL, DEFAULT_VALUE);

		chart.addMouseListener(new ChartMouseListener());
		chart.addKeyListener(new ChartKeyListener());
		chart.setFocusable(true);

		createTextFields();
		createButtons();
		createPanel();
		setSettings();
	}

	private void createTextFields() {
		final int LABEL_FIELD_WIDTH = 20;
		labelField = new JTextField(LABEL_FIELD_WIDTH);
		labelField.setText(DEFAULT_LABEL);

		final int VALUE_FIELD_WIDTH = 10;
		valueField = new JTextField(VALUE_FIELD_WIDTH);
		valueField.setText("" + DEFAULT_VALUE);
	}

	private void createButtons() {
		addButton = new JButton("Add");
		addButton.addActionListener(new AddBarListener());

		removeButton = new JButton("Remove");
		removeButton.addActionListener(new RemoveBarListener());
	}

	private void createPanel() {
		JPanel panel = new JPanel();

		panel.add(labelField);
		panel.add(valueField);
		panel.add(addButton);
		panel.add(removeButton);
		panel.add(chart);

		add(panel);
	}

	private void setSettings() {
		setSize(FRAME_WIDTH, FRAME_HEIGHT);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

	public static void main(String[] args) {
		JFrame demo = new ChartFrame();
	}
}
