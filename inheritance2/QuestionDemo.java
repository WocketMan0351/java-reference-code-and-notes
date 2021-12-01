package inheritance2;

import java.util.Scanner;

public class QuestionDemo {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		Question q = new Question();
		q.setQuestion("Who invented bitcoin?");
		q.setAnswer("Satoshi Nakamoto");

		q.display();

		System.out.print("Answer: ");
		String response = in.nextLine();
		System.out.println(q.checkAnswer(response));

		in.close();
	}

}
