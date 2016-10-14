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
			 String compressedFileName = "src/zad2/resources/compressedText.txt";
			 packer = new PackerOutputStream(new FileOutputStream(compressedFileName));
			 unPacker = new UnpackerInputStream(new FileInputStream(compressedFileName));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		packer.setBit(Conf.SIX_BIT);
		packer.write(null);
		unPacker.setBit(Conf.SIX_BIT);
		unPacker.read();
	}
}
