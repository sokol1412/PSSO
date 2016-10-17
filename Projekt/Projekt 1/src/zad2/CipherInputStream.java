package zad2;

import java.io.*;

public class CipherInputStream extends FilterInputStream {

	String key = null;
	// variables needed for proper keystream generation
	byte[] K_BOX;
	byte[] S_BOX;
	int i;
	int j;

	public CipherInputStream(InputStream inputStream) {
		super(inputStream);
		this.i = 0;
		this.j = 0;
		K_BOX = new byte[256];
		S_BOX = new byte[256];
		this.key = "abcdefghijklmnop";
		for (int i = 0; i < S_BOX.length; i++)
			S_BOX[i] = (byte) i;

		for (int i = 0; i < K_BOX.length; i++) {
			K_BOX[i] = (byte) key.charAt(i % key.length());
		}
		scramble();
	}

	public CipherInputStream(InputStream inStream, String key) {
		super(inStream);
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

	private void decrypt(byte[] msg, int len, byte[] result) {
		byte temp;
		for (int k = 0; k < len; k++) {
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
			byte keyStream = S_BOX[(temp1 + temp2) % 256];
			result[k] = (byte) (msg[k] ^ keyStream);
		}
	}

	@Override
	public int read(byte b[], int off, int len) throws IOException {
		byte[] bytes = new byte[len];
		int result = in.read(bytes, 0, len);
		if (result > 0) {
			decrypt(bytes, result, b);
		}
		return result;
	}
}
