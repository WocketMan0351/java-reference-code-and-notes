package inheritance2;

import java.util.Scanner;

public class QuestionDemoPolymorphism {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		ChoiceQuestion q = new ChoiceQuestion();
		q.setQuestion("Who invented bitcoin?");

		q.addChoice("Alexander Hamilton", false);
		q.addChoice("Satoshi Nakamoto", true);
		q.addChoice("Steve Jobs", false);
		q.addChoice("The CIA", false);

		presentQuestion(q);

		System.out.println();
		System.out.print("q instanceof Question: ");
		System.out.println(q instanceof Question); // checks if q belongs to the particular type of object that Question
													// is
		System.out.print("Enter corresponding number: ");

		String response = in.next();
		System.out.print(q.checkAnswer(response));

		in.close();
	}

	public static void presentQuestion(Question q) { // accepts either a Question or a ChoiceQuestion as an arg
		q.display();
	}

}
