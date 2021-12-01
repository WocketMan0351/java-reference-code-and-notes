package twister;

public class Twister {

	public static void main(String[] args) {
		Chooser color = new Chooser();
		color.addChoice("red");
		color.addChoice("yellow");
		color.addChoice("green");
		color.addChoice("blue");

		Chooser bodyPart = new Chooser();
		bodyPart.addChoice("left foot");
		bodyPart.addChoice("right foot");
		bodyPart.addChoice("left hand");
		bodyPart.addChoice("right hand");

		for (int i = 0; i < 10; i++) {
			color.spin();
			bodyPart.spin();

			if (i % 2 == 0) {
				System.out.print("Player 1: ");
			} else {
				System.out.print("Playser 2: ");
			}
			System.out.println("Place your " + bodyPart.getChoice() + " on a " + color.getChoice() + " spot");
		}
	}

}
