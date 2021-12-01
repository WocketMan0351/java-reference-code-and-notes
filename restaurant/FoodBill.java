package restaurant;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class FoodBill extends JFrame {
	private static final int FRAME_WIDTH = 500;
	private static final int FRAME_HEIGHT = 600;
	private static final double DEFAULT_TAX = 5.6;
	private static final int DEFAULT_TIP = 15;

	private JLabel taxLabel;
	private JTextField taxField;
	private JLabel taxPercentLabel;
	private JLabel tipLabel;
	private JTextField tipField;
	private JLabel tipPercentLabel;

	private ArrayList<Double> selectedItems;
	private JButton btn0;
	private JButton btn1;
	private JButton btn2;
	private JButton btn3;
	private JButton btn4;
	private JButton totalBtn;
	private JButton clearBtn;

	private JTextArea billArea;

	public FoodBill() {
		createTextFields();
		createMenuButtons();
		createBillArea();
		createPanel();
		setSettings();
	}

	public void createTextFields() {
		taxLabel = new JLabel("Tax Rate");
		final int TAX_FIELD_WIDTH = 2;
		taxField = new JTextField(TAX_FIELD_WIDTH);
		taxField.setText("" + DEFAULT_TAX);
		taxPercentLabel = new JLabel("%");

		tipLabel = new JLabel("  Tip");
		final int TIP_FIELD_WIDTH = 2;
		tipField = new JTextField(TIP_FIELD_WIDTH);
		tipField.setText("" + DEFAULT_TIP);
		tipPercentLabel = new JLabel("%");
	}

	public void createMenuButtons() {
		selectedItems = new ArrayList<Double>();

		btn0 = new JButton("IPA");
		btn0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double price = 4.99;
				selectedItems.add(4.99);
				String item = String.format("%s %23s %6.2f", btn0.getText(), "$", price);
				billArea.append(item + "\n");
			}
		});

		btn1 = new JButton("Fries");
		btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double price = 2.99;
				selectedItems.add(2.99);
				String item = String.format("%s %21s %6.2f", btn1.getText(), "$", price);
				billArea.append(item + "\n");
			}
		});

		btn2 = new JButton("Salad");
		btn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double price = 5.99;
				selectedItems.add(5.99);
				String item = String.format("%s %21s %6.2f", btn2.getText(), "$", price);
				billArea.append(item + "\n");
			}
		});

		btn3 = new JButton("Shrimp");
		btn3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double price = 16.99;
				selectedItems.add(16.99);
				String item = String.format("%s %20s %6.2f", btn3.getText(), "$", price);
				billArea.append(item + "\n");
			}
		});

		btn4 = new JButton("Wagyu");
		btn4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double price = (58.99);
				selectedItems.add(58.99);
				String item = String.format("%s %21s %6.2f", btn4.getText(), "$", price);
				billArea.append(item + "\n");
			}
		});

		totalBtn = new JButton("Total");
		totalBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double preTax = 0;
				double total = 0;

				for (int i = 0; i < selectedItems.size(); i++) {
					preTax += selectedItems.get(i);
				}

				double tax = preTax * (Double.parseDouble(taxField.getText()) / 100);
				double tip = preTax * (Double.parseDouble(tipField.getText()) / 100);
				double postTax = preTax + tax;
				double finalTotal = postTax + tip;

				billArea.append("-------------------------- -------\n");

				String preTaxString = String.format("%1s %14s %6.2f", "Pretax Total", "$", preTax);
				String taxString = String.format("%1s %23s %6.2f", "Tax", "$", tax);
				billArea.append(preTaxString + "\n");
				billArea.append(taxString + "\n");

				billArea.append("-------------------------- -------\n");

				String postTaxString = String.format("%1s %15s %6.2f\n", "Total w/Tax", "$", postTax);
				String tipString = String.format("%1s %23s %6.2f\n", "Tip", "$", tip);
				billArea.append(postTaxString);
				billArea.append(tipString);

				billArea.append("-------------------------- -------\n");

				String finalTotalString = String.format("%1s %21s %6.2f\n", "Total", "$", finalTotal);
				billArea.append(finalTotalString);

				taxField.setEnabled(false);
				tipField.setEnabled(false);
				btn0.setEnabled(false);
				btn1.setEnabled(false);
				btn2.setEnabled(false);
				btn3.setEnabled(false);
				btn4.setEnabled(false);
				totalBtn.setEnabled(false);
			}
		});

		clearBtn = new JButton("Clear");
		clearBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				billArea.setText(null);

				selectedItems.clear();
				taxField.setEnabled(true);
				tipField.setEnabled(true);
				btn0.setEnabled(true);
				btn1.setEnabled(true);
				btn2.setEnabled(true);
				btn3.setEnabled(true);
				btn4.setEnabled(true);
				totalBtn.setEnabled(true);
			}
		});
	}

	public void createBillArea() {
		final int ROWS = 25;
		final int COLUMNS = 40;
		billArea = new JTextArea(ROWS, COLUMNS);
		Font font = new Font("Monospaced", Font.BOLD, 12);
		billArea.setFont(font);
		billArea.setEditable(false);
	}

	public void createPanel() {
		JPanel panel = new JPanel();

		panel.add(taxLabel);
		panel.add(taxField);
		panel.add(taxPercentLabel);

		panel.add(tipLabel);
		panel.add(tipField);
		panel.add(tipPercentLabel);

		panel.add(btn0);
		panel.add(btn1);
		panel.add(btn2);
		panel.add(btn3);
		panel.add(btn4);
		panel.add(totalBtn);
		panel.add(clearBtn);

		panel.add(billArea);
		panel.add(new JScrollPane(billArea));

		add(panel);
	}

	public void setSettings() {
		setSize(FRAME_WIDTH, FRAME_HEIGHT);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Restaurant Bill");
		setVisible(true);
	}

	public static void main(String[] args) {
		JFrame demo = new FoodBill();
	}
}
