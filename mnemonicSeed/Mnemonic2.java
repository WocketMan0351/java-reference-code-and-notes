package mnemonicSeed;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Scanner;

public class Mnemonic2 {
	private static String[] wordList = new String[2049];
	private String ENT = "";
	private String[] wordIndexesInBinary = new String[12];
	private int[] wordIndexes = new int[12];
	private String[] mnemonicWords = new String[12];
	private String hashOfEnt = "";
	private String hashOfEntInBinary = "";

	public Mnemonic2() throws FileNotFoundException, NoSuchAlgorithmException, UnsupportedEncodingException {
		setWordList();
		ENT = setENT();
		setWordIndexesInBinary();
		setWordIndexes(ENT);
		setMnemonicWords();
		sha256(ENT);
		hashOfEntInBinary = getBinary(hashOfEnt);
		appendCheckSumBits();
		addCheckSum();
	}

	public String get() {
		String seed = "";
		for (int i = 0; i < mnemonicWords.length; i++) {
			seed += mnemonicWords[i] + " ";
		}
		return seed;
	}

	private static void setWordList() throws FileNotFoundException {
		File words = new File("/Users/codyworthen/Documents/Java Review/Files/bip39.txt");

		Scanner scan = new Scanner(words);

		for (int i = 0; i < wordList.length - 1; i++) {
			wordList[i] = scan.nextLine();
			System.out.println(i + ") " + wordList[i]);
		}
		System.out.println();
	}

	private String setENT() {
		for (int i = 0; i < 128; i++) {
			int number = (int) Math.round(Math.random() * 100);

			if (number % 2 == 0) {
				ENT += 1;
				continue;
			}

			if (number % 2 != 0) {
				ENT += 0;
				continue;
			}
		}

		if (ENT.length() > 128) {
			ENT = ENT.substring(1);
		}

		System.out.println(ENT);
		System.out.println(ENT.length() + " bits ^");
		System.out.println();

		return ENT;
	}

	private void setWordIndexesInBinary() {
		wordIndexesInBinary[0] = ENT.substring(0, 11);
		wordIndexesInBinary[1] = ENT.substring(11, 22);
		wordIndexesInBinary[2] = ENT.substring(22, 33);
		wordIndexesInBinary[3] = ENT.substring(33, 44);
		wordIndexesInBinary[4] = ENT.substring(44, 55);
		wordIndexesInBinary[5] = ENT.substring(55, 66);
		wordIndexesInBinary[6] = ENT.substring(66, 77);
		wordIndexesInBinary[7] = ENT.substring(77, 88);
		wordIndexesInBinary[8] = ENT.substring(88, 99);
		wordIndexesInBinary[9] = ENT.substring(99, 110);
		wordIndexesInBinary[10] = ENT.substring(110, 121);
		wordIndexesInBinary[11] = ENT.substring(121, 128);

		System.out.println(wordIndexesInBinary[0].length() + " " + wordIndexesInBinary[11].length());
		System.out.println(Arrays.toString(wordIndexesInBinary));
	}

	private void setWordIndexes(String str) {
		for (int i = 0; i < wordIndexesInBinary.length; i++) {
			String binaryString = wordIndexesInBinary[i];
			wordIndexes[i] = Integer.parseInt(binaryString, 2);
		}
		System.out.println(Arrays.toString(wordIndexes));
	}

	private void setMnemonicWords() {
		for (int i = 0; i < mnemonicWords.length; i++) {
			mnemonicWords[i] = wordList[wordIndexes[i]];
		}
		System.out.println(Arrays.toString(mnemonicWords));
		System.out.println();
	}

	public void sha256(String hexString) throws NoSuchAlgorithmException, UnsupportedEncodingException {
		MessageDigest md5 = MessageDigest.getInstance("SHA-256");
		byte[] digest = md5.digest(hexString.getBytes(StandardCharsets.UTF_8));
		StringBuilder sb = new StringBuilder();

		for (byte b : digest) {
			sb.append(String.format("%02x", b));
		}

		hashOfEnt = sb.toString();

		System.out.println("hash of 128 bits > " + hashOfEnt);
		System.out.println();
	}

	private String getBinary(String hash) {
		String bin = "";
		String binFragment = "";
		int iHex;
		hash = hash.trim();
		hash = hash.replaceFirst("0x", "");

		for (int i = 0; i < hash.length(); i++) {
			iHex = Integer.parseInt("" + hash.charAt(i), 16);
			binFragment = Integer.toBinaryString(iHex);

			while (binFragment.length() < 4) {
				binFragment = "0" + binFragment;
			}
			bin += binFragment;
		}

		System.out.println(hashOfEntInBinary);
		System.out.println("hash in binary^");

		return bin;
	}

	private void appendCheckSumBits() {
		String checkSumBits = hashOfEntInBinary.substring(0, 4);
		ENT += checkSumBits;

		System.out.println("checksum > " + checkSumBits);
		System.out.println();
		System.out.println(ENT);
		System.out.println(ENT.length() + " bits^");
	}

	private void addCheckSum() {
		wordIndexesInBinary[11] = ENT.substring(121);
		System.out.println(Arrays.toString(wordIndexesInBinary));

		setWordIndexes(ENT);
		setMnemonicWords();
	}

}
