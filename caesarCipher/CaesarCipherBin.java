package caesarCipher;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class CaesarCipherBin {
	private int key;

	public CaesarCipherBin(int key) {
		this.key = key;
	}

	public void encryptStream(InputStream in, OutputStream out) throws IOException {
		int next = in.read();

		while (next != -1) {
			int encrypted = encrypt(next);
			out.write(encrypted);
			next = in.read();
		}
	}

	public int encrypt(int b) {
		return (b + key) % 256;
	}
}