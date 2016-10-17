
import java.io.*;
import java.lang.reflect.Field;

public class UnpackerInputStream extends FilterInputStream {

	byte[] bytes;
	byte[] buffor;
	int index;
	int bufforSize;
	String fileStreamPath;

	UnpackerInputStream(InputStream inputStream) {
		super(inputStream);
		this.index = 0;
		this.bufforSize = 1;
	}

	@SuppressWarnings("unused")
	private void getFileNameFromStream() {
		// workaround for getting filename from inputstream
		Field pathField;
		try {
			pathField = InputStream.class.getDeclaredField("path");
			pathField.setAccessible(true);
			String path;
			try {
				path = (String) pathField.get(in);
				this.fileStreamPath = path;
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

	@Override
	public int read(byte b[]) {
		if (index < bufforSize) {
			if (index == 0) {
				byte[] wholeBuffor = new byte[10000];
				int size = 0;
				try {
					size = super.read(wholeBuffor);
				} catch (IOException e) {
					e.printStackTrace();
				}
				byte[] encoded = new byte[size];
				for (int i = 0; i < size; i++) {
					encoded[i] = wholeBuffor[i];
				}
				String strTemp = new String("");
				String strBinary = new String("");
				String strText = new String("");
				Integer tempInt = new Integer(0);
				int intTemp = 0;
				for (int i = 0; i < encoded.length; i++) {
					if (encoded[i] < 0) {
						intTemp = (int) encoded[i] + 256;
					} else {
						intTemp = (int) encoded[i];
					}
					strTemp = Integer.toBinaryString(intTemp);
					while (strTemp.length() % 8 != 0) {
						strTemp = "0" + strTemp;
					}
					strBinary = strBinary + strTemp;
				}
				for (int i = 0; i < strBinary.length(); i = i + 6) {
					tempInt = tempInt.valueOf(strBinary.substring(i, i + 6), 2);
					strText = strText + toChar(tempInt.intValue());
				}
				strText = strText.trim();

				buffor = strText.getBytes();
				bufforSize = buffor.length;
			}
			int len;
			if (index + b.length > bufforSize) {
				len = bufforSize - index;
			} else {
				len = b.length;
			}
			for (int i = 0; i < len; i++) {
				b[i] = buffor[index++];
			}
			return len;
		}
		return -1;
	}

	char toChar(int val) {
		char ch = ' ';
		switch (val) {
		case 0:
			ch = ' ';
			break;
		case 1:
			ch = 'a';
			break;
		case 2:
			ch = 'b';
			break;
		case 3:
			ch = 'c';
			break;
		case 4:
			ch = 'd';
			break;
		case 5:
			ch = 'e';
			break;
		case 6:
			ch = 'f';
			break;
		case 7:
			ch = 'g';
			break;
		case 8:
			ch = 'h';
			break;
		case 9:
			ch = 'i';
			break;
		case 10:
			ch = 'j';
			break;
		case 11:
			ch = 'k';
			break;
		case 12:
			ch = 'l';
			break;
		case 13:
			ch = 'm';
			break;
		case 14:
			ch = 'n';
			break;
		case 15:
			ch = 'o';
			break;
		case 16:
			ch = 'p';
			break;
		case 17:
			ch = 'q';
			break;
		case 18:
			ch = 'r';
			break;
		case 19:
			ch = 's';
			break;
		case 20:
			ch = 't';
			break;
		case 21:
			ch = 'u';
			break;
		case 22:
			ch = 'v';
			break;
		case 23:
			ch = 'w';
			break;
		case 24:
			ch = 'x';
			break;
		case 25:
			ch = 'y';
			break;
		case 26:
			ch = 'z';
			break;
		case 27:
			ch = '.';
			break;
		case 28:
			ch = '*';
			break;
		case 29:
			ch = ',';
			break;
		case 30:
			ch = '\'';
			break;
		case 31:
			ch = '2';
			break;
		case 32:
			ch = 'A';
			break;
		case 33:
			ch = 'B';
			break;
		case 34:
			ch = 'C';
			break;
		case 35:
			ch = 'D';
			break;
		case 36:
			ch = 'E';
			break;
		case 37:
			ch = 'F';
			break;
		case 38:
			ch = 'G';
			break;
		case 39:
			ch = 'H';
			break;
		case 40:
			ch = 'I';
			break;
		case 41:
			ch = 'J';
			break;
		case 42:
			ch = 'K';
			break;
		case 43:
			ch = 'L';
			break;
		case 44:
			ch = 'M';
			break;
		case 45:
			ch = 'N';
			break;
		case 46:
			ch = 'O';
			break;
		case 47:
			ch = 'P';
			break;
		case 48:
			ch = 'Q';
			break;
		case 49:
			ch = 'R';
			break;
		case 50:
			ch = 'S';
			break;
		case 51:
			ch = 'T';
			break;
		case 52:
			ch = 'U';
			break;
		case 53:
			ch = 'V';
			break;
		case 54:
			ch = 'W';
			break;
		case 55:
			ch = '0';
			break;
		case 56:
			ch = '1';
			break;
		case 57:
			ch = '3';
			break;
		case 58:
			ch = '4';
			break;
		case 59:
			ch = '5';
			break;
		case 60:
			ch = '6';
			break;
		case 61:
			ch = '[';
			break;
		case 62:
			ch = ']';
			break;
		case 63:
			ch = '9';
			break;
		default:
			ch = ' ';
		}
		return ch;
	}
}
