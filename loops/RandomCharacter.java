package loops;

public class RandomCharacter {
	public static void main(String[] args) {
		System.out.print(randomCharacter("abcdefghijklmnopqrstuvwxwyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890"));
	}
	
	public static String randomCharacter(String characters) {
		int n = characters.length();
		System.out.println(n); //63
		
		int r = (int) (n * Math.random());
		
		System.out.println(n * Math.random());
		System.out.println(r);
		
		return characters.substring(r, r + 1);
	}
}
