package zad2;

import java.io.*;
import java.lang.reflect.Field;

public class CipherInputStream extends FilterInputStream {

	byte[] keyStream;
	String fileToDecodePath;

	protected CipherInputStream(InputStream in) {
		super(in);
		// workaround for getting filename from FileOutputStream
		Field pathField;
		try {
			pathField = FileInputStream.class.getDeclaredField("path");
			pathField.setAccessible(true);
			String path;
			try {
				path = (String) pathField.get(in);
				this.fileToDecodePath = path;
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
		} catch (NoSuchFieldException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		}
	}

	public void setKeyStream(byte[] key) {
		this.keyStream = key;
	}

	private byte[] xorWithKey(byte[] message, byte[] key) {
		byte[] decryptedText = new byte[key.length];
		for (int i = 0; i < key.length; i++) {
			decryptedText[i] = (byte) (message[i] ^ key[i]);
		}
		return decryptedText;
	}

	@Override
	public int read() {
		byte[] decryptedText = null;
		File fileToDecipher = new File(fileToDecodePath);
		FileOutputStream outputStream = null;
		try {
			outputStream = new FileOutputStream("src/zad2/resources/out.txt");
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
		byte encoded[] = new byte[(int) fileToDecipher.length()];
		try {
			super.read(encoded);
			close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		decryptedText = xorWithKey(encoded, keyStream);
		try {
			outputStream.write(decryptedText);
			outputStream.flush();
			outputStream.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
}
