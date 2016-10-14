package zad2;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class Test {

	public static void main(String[] args) {
		PackerOutputStream packer = null;
		UnpackerInputStream unPacker = null;
		try {
			 packer = new PackerOutputStream(new FileInputStream("src/zad2/resources/plainText.txt"), new FileOutputStream("src/zad2/resources/compressedText.txt"));
			 unPacker = new UnpackerInputStream(new FileInputStream("src/zad2/resources/compressedText.txt"), new FileOutputStream("src/zad2/resources/unCompressedText.txt"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		packer.encode(Constants.SIX_BIT);
		unPacker.decode(new File("src/zad2/resources/compressedText.txt"), Constants.SIX_BIT);
	}
}
