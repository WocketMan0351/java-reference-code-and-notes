package barChartCreator;

import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JComponent;

public class ChartComponent extends JComponent {
	private ArrayList<Bar> bars;
	private double maxValue;
	private int selected;

	private final int GAP = 5;

	public ChartComponent() {
		bars = new ArrayList<Bar>();
		maxValue = 1;
	}

	public void append(String label, double value) {
		bars.add(new Bar(label, value));

		if (value > maxValue) {
			maxValue = value;
		}
		repaint();
	}

	public void removeLast() {
		int n = bars.size();

		if (n == 0) {
			return;
		}
		bars.remove(n - 1);
		repaint();
	}

	public void paintComponent(Graphics g) {
		int y = GAP;
		double scale = getWidth() / maxValue;

		for (int i = 0; i < bars.size(); i++) {
			Bar b = bars.get(i);

			b.draw(g, y, scale, i == selected);
			y = y + Bar.HEIGHT + GAP;
		}
	}

	public void changeSelected(int increment) {
		if (bars.size() == 0) {
			return;
		}

		selected = selected + increment;
		int n = bars.size();

		if (selected >= n) {
			selected -= n;
		}
		if (selected < 0) {
			selected += n;
		}

		repaint();
	}

	public void growSelected(int increment) {
		if (bars.size() == 0) {
			return;
		}

		Bar b = bars.get(selected);

		double value = b.getValue();
		value = value + increment * maxValue / getWidth();

		b.setValue(value);
		repaint();
	}

	public void click(int x, int y) {
		int row = y / (GAP + Bar.HEIGHT);

		double value = x * maxValue / getWidth();

		if (row == selected) {
			bars.get(row).setValue(value);
		} else if (row >= bars.size()) {
			bars.add(new Bar("", value));
		} else {
			selected = row;
		}
		repaint();
	}
}
