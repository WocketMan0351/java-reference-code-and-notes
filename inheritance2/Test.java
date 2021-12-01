package inheritance2;

public class Test {

	public static void main(String[] args) {
		Question x = new Question();
		x.setQuestion("Year?");
		x.setAnswer("2021");

		ChoiceQuestion y = new ChoiceQuestion();
		y.setQuestion("Month?");
		y.setAnswer("Aug");

		x = new ChoiceQuestion();

		x.display();
		y.display();

	}

}
