package subClassAndSuperClass;

public class Main {

	public static void main(String[] args) {
		Shoe s = new Shoe("Nike", 10);
		System.out.println(s);

		Walking w = new Walking(false, "Under Armor", 4.2);
		System.out.println(w.size);

		Running r = new Running(2.4, "Adidas", 9.5);
		System.out.println(r.weight);
	}

}
