//package atlasin.online;

/**
 * Class - https://en.wikipedia.org/wiki/Look-and-say_sequence
 * 
 * @author ayverma
 *
 */
public class LookAndSay {

	public static void lookAndSay(int num) {
		String givenNum = Integer.toString(num);
		int count = 0;
		for (int i = 0; i < givenNum.length(); i++) {
			count++;
			char currentChar = givenNum.charAt(i);
			char nextChar = i == (givenNum.length() - 1) ? '\0' : givenNum.charAt(i + 1);
			if (currentChar != nextChar) {
				System.out.print(count);
				System.out.print(currentChar);
				count = 0;
			}
		}
	}

	public static void lnsString(int num) {
		String output = "";
		String givenNum = Integer.toString(num);
		int count = 0;
		for (int i = 0; i < givenNum.length(); i++) {
			count++;
			char currentChar = givenNum.charAt(i);
			char nextChar = i == (givenNum.length() - 1) ? '\0' : givenNum.charAt(i + 1);
			if (currentChar != nextChar) {
				output += getNumInString(count, ' ', true) + " ";
				output += getNumInString(0, currentChar, false) + ", ";
				count = 0;
			}
		}
		System.out.println(output);
	}

	public static void lnsMixString(int num) {
		String output = "";
		String givenNum = Integer.toString(num);
		int count = 0;
		for (int i = 0; i < givenNum.length(); i++) {
			count++;
			char currentChar = givenNum.charAt(i);
			char nextChar = i == (givenNum.length() - 1) ? '\0' : givenNum.charAt(i + 1);
			if (currentChar != nextChar) {
				output += getNumInString(count, ' ', true) + " ";
				output += currentChar + "s, ";
				count = 0;
			}
		}
		System.out.println(output);
	}

	private static String getNumInString(int num, char chr, boolean count) {
		String rtr = "";
		if (num == 1 || chr == '1')
			rtr = "ONE";
		else if (num == 2 || chr == '2')
			rtr = "TWO";
		else if (num == 3 || chr == '3')
			rtr = "THREE";
		else if (num == 4 || chr == '4')
			rtr = "FOUR";
		else if (num == 5 || chr == '5')
			rtr = "FIVE";
		else if (num == 6 || chr == '6')
			rtr = "SIX";
		else if (num == 7 || chr == '7')
			rtr = "SEVEN";
		else if (num == 8 || chr == '8')
			rtr = "EIGTH";
		else if (num == 9 || chr == '9')
			rtr = "NINE";
		if (!count) {
			rtr += "S";
		}
		return rtr;
	}

	public static int lnsReverse(String str) {
		int lns = 0;
		String str1 = "";
		String arr[] = str.split(" ");
		if (arr.length % 2 != 0) {
			System.out.println("String is not proper.");
			return -1;
		}
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + ",");
		}
		System.out.println();
		for (int i = 0; i < arr.length; i = i + 2) {
			int count = strToNum(arr[i]);
			String num = strToNumStr(arr[i + 1]);
			for (int x = 0; x < count; x++) {
				str1 += num;
			}
		}
		System.out.println(str1);
		lns = Integer.parseInt(str1);
		return lns;
	}

	private static int strToNum(String word) {
		if (word.equalsIgnoreCase("one") || word.equalsIgnoreCase("1"))
			return 1;
		else if (word.equalsIgnoreCase("two") || word.equalsIgnoreCase("2"))
			return 2;
		else if (word.equalsIgnoreCase("three") || word.equalsIgnoreCase("3"))
			return 3;
		else if (word.equalsIgnoreCase("four") || word.equalsIgnoreCase("4"))
			return 4;
		else if (word.equalsIgnoreCase("five") || word.equalsIgnoreCase("5"))
			return 5;
		else if (word.equalsIgnoreCase("six") || word.equalsIgnoreCase("6"))
			return 6;
		else if (word.equalsIgnoreCase("seven") || word.equalsIgnoreCase("7"))
			return 7;
		else if (word.equalsIgnoreCase("eight") || word.equalsIgnoreCase("8"))
			return 8;
		else if (word.equalsIgnoreCase("nine") || word.equalsIgnoreCase("9"))
			return 9;
		return -1;
	}

	private static String strToNumStr(String word) {
		if (word.equalsIgnoreCase("one"))
			return "1";
		else if (word.equalsIgnoreCase("two"))
			return "2";
		else if (word.equalsIgnoreCase("three"))
			return "3";
		else if (word.equalsIgnoreCase("four"))
			return "4";
		else if (word.equalsIgnoreCase("five"))
			return "5";
		else if (word.equalsIgnoreCase("six"))
			return "6";
		else if (word.equalsIgnoreCase("seven"))
			return "7";
		else if (word.equalsIgnoreCase("eight"))
			return "8";
		else if (word.equalsIgnoreCase("nine"))
			return "9";
		return null;
	}

	public static void main(String args[]) {
		System.out.println("**********************************************");
		System.out.println("112334445 is");
		LookAndSay.lookAndSay(112334445);
		System.out.println();
		LookAndSay.lnsString(112334445);
		LookAndSay.lnsMixString(112334445);

		String str = "TWO ONE ONE TWO TWO THREE THREE FOUR ONE FIVE";
		System.out.println("Working on " + str);
		System.out.println("Coverted value is: " + LookAndSay.lnsReverse(str));

		String str2 = "8 SEVEN 1 six";
		System.out.println("Working on " + str2);
		System.out.println("Coverted value is: " + LookAndSay.lnsReverse(str2));
		System.out.println("**********************************************");
	}
}
