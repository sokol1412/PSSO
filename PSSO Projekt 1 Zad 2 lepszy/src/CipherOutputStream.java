
import java.io.*;

public class CipherOutputStream extends FilterOutputStream {

	String key;
	// variables needed for proper keystream generation
	byte[] K_BOX;
	byte[] S_BOX;
	int i;
	int j;

	public CipherOutputStream(OutputStream outStream) {
		super(outStream);
		this.i = 0;
		this.j = 0;
		this.key = "abcdefghijklmnop";
		K_BOX = new byte[256];
		S_BOX = new byte[256];
		for (int i = 0; i < S_BOX.length; i++)
			S_BOX[i] = (byte) i;

		for (int i = 0; i < K_BOX.length; i++) {
			K_BOX[i] = (byte) key.charAt(i % key.length());
		}
		scramble();
	}

	public CipherOutputStream(OutputStream outStream, String key) {
		super(outStream);
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

//	private byte[] xorWithKey(byte[] message, byte[] key) {
//		byte[] encryptedText = new byte[key.length];
//		for (int i = 0; i < key.length; i++) {
//			encryptedText[i] = (byte) (message[i] ^ key[i]);
//		}
//		return encryptedText;
//	}

	private byte[] encryptData(byte[] msg, int len) {
		byte temp;
		byte[] encryptedText = new byte[len];
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
			encryptedText[k] = (byte) (msg[k] ^ keyStream);
		}
		return encryptedText;
	}

	@Override
	public void write(byte b[], int off, int len) {
		byte[] bytes = encryptData(b, len);
		try {
			super.write(bytes, off, bytes.length);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
