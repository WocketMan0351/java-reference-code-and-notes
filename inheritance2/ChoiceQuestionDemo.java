package inheritance2;

import java.util.Scanner;

public class ChoiceQuestionDemo {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		ChoiceQuestion q = new ChoiceQuestion();
		q.setQuestion("Who invented bitcoin?");

		q.addChoice("Alexander Hamilton", false);
		q.addChoice("Satoshi Nakamoto", true);
		q.addChoice("Steve Jobs", false);
		q.addChoice("The CIA", false);

		q.display();

		System.out.println();
		System.out.print("Enter corresponding number: ");

		String response = in.next();
		System.out.print(q.checkAnswer(response));

		in.close();
	}

}
