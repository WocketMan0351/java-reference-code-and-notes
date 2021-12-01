package interfaces;

public class main {

	public static void main(String[] args) {
		ByTwos byTwos = new ByTwos();
		ByThrees byThrees = new ByThrees();

		for (int i = 0; i < 5; i++) {
			System.out.println(byTwos.getNext());
		}

		System.out.println();

		for (int i = 0; i < 5; i++) {
			System.out.println(byThrees.getNext());
		}

		System.out.println();

		// ob is an object of type Series (interface)
		// ob can only call methods defined in its interface
		Series ob;
		for (int i = 0; i < 2; i++) {
			ob = byTwos;
			System.out.println(ob.getNext() + " ByTwos <-- ob.getNext()");

			ob = byThrees;
			System.out.println(ob.getNext() + " ByThrees <-- ob.getNext()");
			System.out.println();
		}

		// we can access variables declared in interfaces because they are public,
		// static, and final
		System.out.println("Accessing interface variable: " + Series.MAX);
		System.out.println();

		ob = new ByTwos();
		ob.printStuff(); // default void printStuff() (needs to be called on an object that has that
							// method)
		Series.printMoreStuff(); // static void printStuff() (don't need an object to call static method)

		System.out.println();

		ob = new ByThrees();
		ob.printStuff();
	}

}
