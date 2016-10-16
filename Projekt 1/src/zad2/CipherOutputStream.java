package zad2;

import java.io.*;

public class CipherOutputStream extends FilterOutputStream {

	String key = null;
	byte[] K_BOX = new byte[256];
	byte[] S_BOX = new byte[256];
	byte[] keyStream = null;

	public byte[] getKeyStream() {
		return this.keyStream;
	}

	public CipherOutputStream(OutputStream out) {
		super(out);
		this.key = "abcdefghijklmnop";
		for (int i = 0; i < S_BOX.length; i++)
			S_BOX[i] = (byte) i;

		for (int i = 0; i < K_BOX.length; i++) {
			K_BOX[i] = (byte) key.charAt(i % key.length());
		}
		scramble();
	}
	
	public CipherOutputStream(OutputStream out, String key) {
		super(out);
		this.key = key;
		for (int i = 0; i < S_BOX.length; i++)
			S_BOX[i] = (byte) i;

		for (int i = 0; i < K_BOX.length; i++) {
			K_BOX[i] = (byte) key.charAt(i % key.length());
		}
		scramble();
	}

	private void scramble() {
		int j = 0;
		byte temp;
		for (int i = 0; i < S_BOX.length; i++) {
			int temp1 = S_BOX[i] + 256;
			int temp2 = K_BOX[i] + 256;
			if (temp1 < 0)
				temp1 += 256;
			if (temp2 < 0)
				temp2 += 256;
			j = (j + temp1 + temp2) % 256;
			temp = S_BOX[i];
			S_BOX[i] = S_BOX[j];
			S_BOX[j] = temp;
		}
	}

	private byte[] xorWithKey(byte[] message, byte[] key) {
		byte[] encryptedText = new byte[key.length];
		for (int i = 0; i < key.length; i++) {
			encryptedText[i] = (byte) (message[i] ^ key[i]);
		}
		return encryptedText;
	}

	@Override
	public void write(byte[] b) {
		byte[] encryptedText = null;
		FileInputStream inputStream = null;
		try {
			inputStream = new FileInputStream("src/zad2/resources/plainText.txt");
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
		String text = "";
		int content;
		try {
			while ((content = inputStream.read()) != -1) {
				text += ((char) content);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		int i = 0;
		int j = 0;
		byte temp;
		keyStream = new byte[text.length()];
		for (int k = 0; k < text.length(); k++) {
			i = (i + 1) % 256;
			j = (j + 1) % 256;
			temp = S_BOX[i];
			S_BOX[i] = S_BOX[j];
			S_BOX[j] = temp;
			int temp1 = S_BOX[i] + 256;
			int temp2 = K_BOX[i] + 256;
			if (temp1 < 0)
				temp1 += 256;
			if (temp2 < 0)
				temp2 += 256;
			keyStream[k] = S_BOX[(temp1 + temp2) % 256];
		}

		encryptedText = xorWithKey(text.getBytes(), keyStream);
		try {
			super.write(encryptedText);
			flush();
			close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
