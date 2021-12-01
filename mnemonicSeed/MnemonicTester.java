package mnemonicSeed;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

public class MnemonicTester {
	public static void main(String[] args)
			throws FileNotFoundException, NoSuchAlgorithmException, UnsupportedEncodingException {
		Mnemonic test = new Mnemonic();
		System.out.println(test.get());
	}
}
