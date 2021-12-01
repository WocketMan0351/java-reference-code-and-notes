package inheritance;

public class Inheritance {
	public static void main(String[] args) {
		Student s = new Student();
		s.firstName = "Cody"; // inherits from User class
		s.lastName = "Worthen";
		s.major = "CS";

		System.out.println(s.firstName + " " + s.lastName);
		System.out.println(s.major);
	}
}
