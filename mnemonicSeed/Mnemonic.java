package mnemonicSeed;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Scanner;

public class Mnemonic {
	private String[] wordList;
	private String ENT;
	private String[] wordIndexesInBinary;
	private int[] wordIndexes;
	private String[] mnemonicWords;
	private String hashOfEnt;
	private String hashOfEntInBinary;

	public Mnemonic() throws FileNotFoundException, NoSuchAlgorithmException, UnsupportedEncodingException {
		wordList = setWordList();
		ENT = setENT();
		wordIndexesInBinary = setWordIndexesInBinary();
		wordIndexes = setWordIndexes(ENT);
		mnemonicWords = setMnemonicWords();
		hashOfEnt = sha256(ENT);
		hashOfEntInBinary = hashToBinary(hashOfEnt);
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

	private String[] setWordList() throws FileNotFoundException {
		wordList = new String[2049];

		File words = new File("/Users/codyworthen/Desktop/Java Review/Files/bip39.txt");

		Scanner scan = new Scanner(words);

		for (int i = 0; i < wordList.length - 1; i++) {
			wordList[i] = scan.nextLine();
			System.out.println(i + ") " + wordList[i]);
		}
		System.out.println();
		return wordList;
	}

	private String setENT() {
		ENT = "";

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

	private String[] setWordIndexesInBinary() {
		wordIndexesInBinary = new String[12];

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

		System.out.println(Arrays.toString(wordIndexesInBinary));

		return wordIndexesInBinary;
	}

	private int[] setWordIndexes(String str) {
		wordIndexes = new int[12];

		for (int i = 0; i < wordIndexesInBinary.length; i++) {
			String binaryString = wordIndexesInBinary[i];
			wordIndexes[i] = Integer.parseInt(binaryString, 2);
		}
		System.out.println(Arrays.toString(wordIndexes));

		return wordIndexes;
	}

	private String[] setMnemonicWords() {
		mnemonicWords = new String[12];

		for (int i = 0; i < mnemonicWords.length; i++) {
			mnemonicWords[i] = wordList[wordIndexes[i]];
		}
		System.out.println(Arrays.toString(mnemonicWords));
		System.out.println();

		return mnemonicWords;
	}

	public String sha256(String hexString) throws NoSuchAlgorithmException, UnsupportedEncodingException {
		MessageDigest md5 = MessageDigest.getInstance("SHA-256");
		byte[] digest = md5.digest(hexString.getBytes(StandardCharsets.UTF_8));
		StringBuilder sb = new StringBuilder();

		for (byte b : digest) {
			sb.append(String.format("%02x", b));
		}

		hashOfEnt = sb.toString();

		System.out.println("hash of 128 bits > " + hashOfEnt);
		System.out.println();

		return hashOfEnt;
	}

//	private String hashToBinary(String hash) {
//		String bin = "";
//		String binFragment = "";
//		int iHex;
//		hash = hash.trim();
//		hash = hash.replaceFirst("0x", "");
//
//		for (int i = 0; i < hash.length(); i++) {
//			iHex = Integer.parseInt("" + hash.charAt(i), 16);
//			binFragment = Integer.toBinaryString(iHex);
//
//			while (binFragment.length() < 4) {
//				binFragment = "0" + binFragment;
//			}
//			bin += binFragment;
//		}
//
//		System.out.println(bin);
//		System.out.println("hash in binary^");
//
//		return bin;
//	}

	private String hashToBinary(String hex) {
		String digits = "0123456789ABCDEF";
		hex = hex.toUpperCase();
		String binaryString = "";

		for (int i = 0; i < hex.length(); i++) {
			char c = hex.charAt(i);
			int d = digits.indexOf(c);
			if (d == 0)
				binaryString += "0000";
			else
				binaryString += Integer.toBinaryString(d);
		}
		return binaryString;
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

//	private void checksum() {
//		String checkSumBits = hashOfEntInBinary.substring(0, 4);
//	}

}
