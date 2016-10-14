package zad2;

import java.io.*;

public class PackerOutputStream extends FilterOutputStream {

	private FileOutputStream outputStream;
	private FileInputStream inputStream;

	public PackerOutputStream(FileInputStream in, FileOutputStream out) {
		super(out);
		inputStream = in;
		outputStream = out;
	}

	public void encode(int bit) {
		String text = "";
		int content;
		try {
			while ((content = inputStream.read()) != -1) {
				text += ((char) content);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		int length = text.length();
		float tmpRet1 = 0, tmpRet2 = 0;
		if (bit == Constants.SIX_BIT) {
			tmpRet1 = 3.0f;
			tmpRet2 = 4.0f;
		} else if (bit == Constants.FIVE_BIT) {
			tmpRet1 = 5.0f;
			tmpRet2 = 8.0f;
		}
		byte encoded[] = new byte[(int) (tmpRet1 * Math.ceil(length / tmpRet2))];
		char str[] = new char[length];
		text.getChars(0, length, str, 0);
		String temp;
		String strBinary = "";
		for (int i = 0; i < length; i++) {
			temp = Integer.toBinaryString(toValue(str[i]));
			while (temp.length() % bit != 0) {
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
			outputStream.write(encoded);
			outputStream.flush();
			outputStream.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

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
		case '9':
			chaVal = 61;
			break;
		case '[':
			chaVal = 62;
			break;
		case ']':
			chaVal = 63;
			break;
		default:
			chaVal = 0;
		}
		return chaVal;
	}
}
