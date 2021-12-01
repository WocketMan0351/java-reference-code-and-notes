package twister;

import java.util.ArrayList;

public class Chooser {
	private ArrayList<String> choices = new ArrayList<String>();
	private String selection = "";

	public void addChoice(String c) {
		if (!choices.contains(c)) {
			choices.add(c);
		}
	}

	public void spin() {
		int x = (int) (Math.random() * choices.size());
		selection = choices.get(x);
	}

	public String getChoice() {
		return selection;
	}
}
