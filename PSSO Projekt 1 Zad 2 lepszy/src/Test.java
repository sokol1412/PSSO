/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import static org.junit.Assert.assertTrue;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Test {

    public static void main(String[] args) throws FileNotFoundException, IOException {
        InputStream in = null;
        OutputStream out = null;

    	in = new FileInputStream("src/main/resources/plainText.txt");
        out = new CipherOutputStream(new FileOutputStream("src/main/resources/encryptedText.txt"));
		copyAndClose(in, out, 64);
		in = new CipherInputStream(new FileInputStream("src/main/resources/encryptedText.txt"));
		out = new FileOutputStream("src/main/resources/out.txt");
		copyAndClose(in, out, 32);
    }

    private static void copyAndClose(InputStream in, OutputStream out, int buffor) throws IOException {
        byte[] array = new byte[buffor];
        int count;
        while ((count = in.read(array)) != -1) {
            out.write(array, 0, count);
        }
        in.close();
        out.close();
    }
}
