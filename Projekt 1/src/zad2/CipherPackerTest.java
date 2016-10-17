package zad2;

import static org.junit.Assert.*;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.junit.Before;
import org.junit.Test;

public class CipherPackerTest {

	private InputStream in = null;
	private OutputStream out = null;

	@Before
	public void setUp() throws Exception {
		// ClassLoader classLoader =
		// Thread.currentThread().getContextClassLoader();
		// in = classLoader.getResourceAsStream("plainText.txt");
		in = new FileInputStream("src/zad2/main/resources/plainText.txt");
	}

	@Test
	public void testPacker() throws Exception {
		out = new PackerOutputStream(new FileOutputStream("src/zad2/main/resources/compressedText.txt"));
		copyAndClose(in, out, 64);
		in = new UnpackerInputStream(new FileInputStream("src/zad2/main/resources/compressedText.txt"));
		out = new FileOutputStream("src/zad2/main/resources/out.txt");
		copyAndClose(in, out, 32);
		assertEquals(Files.size(Paths.get("src/zad2/main/resources/plainText.txt")),
				Files.size(Paths.get("src/zad2/main/resources/out.txt")));
	}

	@Test
	public void testCipher() throws Exception {
		out = new CipherOutputStream(new FileOutputStream("src/zad2/main/resources/encryptedText.txt"));
		copyAndClose(in, out, 64);
		in = new CipherInputStream(new FileInputStream("src/zad2/main/resources/encryptedText.txt"));
		out = new FileOutputStream("src/zad2/main/resources/out.txt");
		copyAndClose(in, out, 32);
		assertTrue(contentEquals());
	}

	@Test
	public void testCipherAndPacker() throws Exception {
		out = new CipherOutputStream(
				new PackerOutputStream(new FileOutputStream("src/zad2/main/resources/encryptedCompressedText.txt")));
		copyAndClose(in, out, 32);
		in = new CipherInputStream(
				new UnpackerInputStream(new FileInputStream("src/zad2/main/resources/encryptedCompressedText.txt")));
		out = new FileOutputStream("src/zad2/main/resources/out.txt");
		copyAndClose(in, out, 64);
		assertEquals(Files.size(Paths.get("src/zad2/main/resources/plainText.txt")),
				Files.size(Paths.get("src/zad2/main/resources/encryptedCompressedText.txt")));
	}

	private void copyAndClose(InputStream in, OutputStream out, int buffor) throws IOException {

		byte[] array = new byte[buffor];
		int count;
		while ((count = in.read(array)) != -1) {
			out.write(array, 0, count);
		}
		in.close();
		out.close();
	}

	private boolean contentEquals() throws IOException {
		InputStream in1 = new FileInputStream("src/zad2/main/resources/plainText.txt");
		InputStream in2 = new FileInputStream("src/zad2/main/resources/out.txt");
		boolean result = true;
		int ch1, ch2;
		while ((ch1 = in1.read()) != -1) {
			ch2 = in2.read();
			if (ch1 != ch2) {
				result = false;
				break;
			}
		}
		if (in2.read() != -1)
			result = false;
		in1.close();
		in2.close();
		return result;
	}

}
