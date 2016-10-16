package zad2;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class Test {

	public static void main(String[] args) {

		// // packer/unpacker
		OutputStream packer = null;
		InputStream unPacker = null;
		try {
			String compressedFileName = "src/zad2/resources/compressedText.txt";
			packer = new PackerOutputStream(new FileOutputStream(compressedFileName));
			unPacker = new UnpackerInputStream(new FileInputStream(compressedFileName));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			packer.write(null);
			unPacker.read();
		} catch (IOException e) {
			e.printStackTrace();
		}

		System.out.println("Packing and unpacking completed!");

		// cipher/decipher - jesli chcialbym zamienic ponizsze streamy na Zwykly
		// InputStream i OutputStream, to jak handleowac przekazywanie
		// KeyStreama??
//		CipherOutputStream cipher = null;
//		CipherInputStream deCipher = null;
//		try {
//			String encryptedFileName = "src/zad2/resources/encryptedText.txt";
//			cipher = new CipherOutputStream(new FileOutputStream(encryptedFileName),
//					"askl;dasdkl;akls;daskdl;asdkl;asdkl;aaa");
//			deCipher = new CipherInputStream(new FileInputStream(encryptedFileName));
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//		}
//		cipher.write(null);
//		byte[] keyStream = cipher.getKeyStream();
//		deCipher.setKeyStream(keyStream);
//		deCipher.read();
//		System.out.println("Encrypting and decrypting completed!");

		// // encryption and packing together
		// OutputStream out = null;
		// InputStream in = null;
		// try {
		// String testedFileName =
		// "src/zad2/resources/encryptedCompressedText.txt";
		// out = new PackerOutputStream(
		// new CipherOutputStream(new FileOutputStream(testedFileName),
		// "lkasdklasdklklasdadksl"));
		// in = new UnpackerInputStream(new CipherInputStream(new
		// FileInputStream(testedFileName)));
		// } catch (FileNotFoundException e) {
		// e.printStackTrace();
		// }

	}
}
