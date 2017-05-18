#package atlasian.java;

/**
 * Class - https://en.wikipedia.org/wiki/Look-and-say_sequence
 * 
 * @author ayverma
 *
 */
public class LookAndSaySequence {
	private static int tCount = 1;

	public static void printLookNSaySeq(long num, int cnt) {
		tCount++;
		System.out.println(num);
		String givenNum = Long.toString(num);
		String output = "";
		long newnum = 0;
		int count = 0;
		for (int i = 0; i < givenNum.length(); i++) {
			count++;
			char currentChar = givenNum.charAt(i);
			char nextChar = i == (givenNum.length() - 1) ? '\0' : givenNum.charAt(i + 1);
			if (currentChar != nextChar) {
				output += count;
				output += currentChar;
				count = 0;
			}
		}
		newnum = Long.parseLong(output);
		if (tCount <= cnt)
			printLookNSaySeq(newnum, cnt);
	}

	public static void printLookNSaySeq(String givenNum, int cnt) {
		tCount++;
		System.out.println(givenNum);
		// String givenNum = Long.toString(num);
		String output = "";
		long newnum = 0;
		int count = 0;
		for (int i = 0; i < givenNum.length(); i++) {
			count++;
			char currentChar = givenNum.charAt(i);
			char nextChar = i == (givenNum.length() - 1) ? '\0' : givenNum.charAt(i + 1);
			if (currentChar != nextChar) {
				output += count;
				output += currentChar;
				count = 0;
			}
		}
		// newnum = Long.parseLong(output);
		if (tCount <= cnt)
			printLookNSaySeq(output, cnt);
	}

	public static void main(String args[]) {
		// printLookNSaySeq(1, 8);
		printLookNSaySeq("1", 20);
	}
}
