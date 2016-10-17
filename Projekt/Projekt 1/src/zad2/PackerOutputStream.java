package zad2;

import java.io.*;
import java.util.Arrays;

public class PackerOutputStream extends FilterOutputStream {

	public PackerOutputStream(OutputStream outputStream) {
		super(outputStream);
	}

	@Override
	public void write(byte[] bytes, int off, int len) {
		String str = new String(bytes);
		if (str.indexOf('\0') > 0)
			str = str.substring(0, str.indexOf('\0'));
		int length = str.length();
		float tmpRet1 = 0, tmpRet2 = 0;
		tmpRet1 = 3.0f;
		tmpRet2 = 4.0f;
		byte encoded[] = new byte[(int) (tmpRet1 * Math.ceil(length / tmpRet2))];
		char string[] = new char[length];
		str.getChars(0, length, string, 0);
		String temp;
		String strBinary = new String("");
		for (int i = 0; i < length; i++) {
			temp = Integer.toBinaryString(toValue(string[i]));
			while (temp.length() % 6 != 0) {
				temp = "0" + temp;
			}
			strBinary = strBinary + temp;
		}
		while (strBinary.length() % 8 != 0) {
			strBinary = strBinary + "0";
		}
		Integer tempInt = new Integer(0);
		for (int i = 0; i < strBinary.length(); i = i + 8) {
			tempInt = tempInt.valueOf(strBinary.substring(i, i + 8), 2);
			encoded[i / 8] = tempInt.byteValue();
		}
		try {
			out.write(encoded, off, encoded.length);
		} catch (IOException e) {
			e.printStackTrace();
		}
		Arrays.fill(bytes, (byte) '\0');
	}

	int toValue(char ch) {
		int chaVal = 0;
		switch (ch) {
		case ' ':
			chaVal = 0;
			break;
		case 'a':
			chaVal = 1;
			break;
		case 'b':
			chaVal = 2;
			break;
		case 'c':
			chaVal = 3;
			break;
		case 'd':
			chaVal = 4;
			break;
		case 'e':
			chaVal = 5;
			break;
		case 'f':
			chaVal = 6;
			break;
		case 'g':
			chaVal = 7;
			break;
		case 'h':
			chaVal = 8;
			break;
		case 'i':
			chaVal = 9;
			break;
		case 'j':
			chaVal = 10;
			break;
		case 'k':
			chaVal = 11;
			break;
		case 'l':
			chaVal = 12;
			break;
		case 'm':
			chaVal = 13;
			break;
		case 'n':
			chaVal = 14;
			break;
		case 'o':
			chaVal = 15;
			break;
		case 'p':
			chaVal = 16;
			break;
		case 'q':
			chaVal = 17;
			break;
		case 'r':
			chaVal = 18;
			break;
		case 's':
			chaVal = 19;
			break;
		case 't':
			chaVal = 20;
			break;
		case 'u':
			chaVal = 21;
			break;
		case 'v':
			chaVal = 22;
			break;
		case 'w':
			chaVal = 23;
			break;
		case 'x':
			chaVal = 24;
			break;
		case 'y':
			chaVal = 25;
			break;
		case 'z':
			chaVal = 26;
			break;
		case '.':
			chaVal = 27;
			break;
		case '*':
			chaVal = 28;
			break;
		case ',':
			chaVal = 29;
			break;
		case '\'':
			chaVal = 30;
			break;
		case '2':
			chaVal = 31;
			break;
		case 'A':
			chaVal = 32;
			break;
		case 'B':
			chaVal = 33;
			break;
		case 'C':
			chaVal = 34;
			break;
		case 'D':
			chaVal = 35;
			break;
		case 'E':
			chaVal = 36;
			break;
		case 'F':
			chaVal = 37;
			break;
		case 'G':
			chaVal = 38;
			break;
		case 'H':
			chaVal = 39;
			break;
		case 'I':
			chaVal = 40;
			break;
		case 'J':
			chaVal = 41;
			break;
		case 'K':
			chaVal = 42;
			break;
		case 'L':
			chaVal = 43;
			break;
		case 'M':
			chaVal = 44;
			break;
		case 'N':
			chaVal = 45;
			break;
		case 'O':
			chaVal = 46;
			break;
		case 'P':
			chaVal = 47;
			break;
		case 'Q':
			chaVal = 48;
			break;
		case 'R':
			chaVal = 49;
			break;
		case 'S':
			chaVal = 50;
			break;
		case 'T':
			chaVal = 51;
			break;
		case 'U':
			chaVal = 52;
			break;
		case 'V':
			chaVal = 53;
			break;
		case 'W':
			chaVal = 54;
			break;
		case '0':
			chaVal = 55;
			break;
		case '1':
			chaVal = 56;
			break;
		case '3':
			chaVal = 57;
			break;
		case '4':
			chaVal = 58;
			break;
		case '5':
			chaVal = 59;
			break;
		case '6':
			chaVal = 60;
			break;
		case '[':
			chaVal = 61;
			break;
		case ']':
			chaVal = 62;
			break;
		case '9':
			chaVal = 63;
			break;
		default:
			chaVal = 0;
		}
		return chaVal;
	}
}
