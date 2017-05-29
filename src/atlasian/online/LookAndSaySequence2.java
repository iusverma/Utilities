package atlasian.online;

import java.util.Scanner;

/**
 * Class - https://en.wikipedia.org/wiki/Look-and-say_sequence
 * 
 * @author ayverma
 *
 */
public class LookAndSaySequence2 {
	private static int tCount = 1;
	private static String str = "";

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
		str = givenNum;
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
		if (tCount <= cnt)
			printLookNSaySeq(output, cnt);
	}

    public static void main(String args[] ) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
        String num = "";
        String power = "";
        Scanner stdin = new Scanner(System.in);
        int count = 0;
        while(stdin.hasNextLine())
        {
            if(count == 0){
                num = stdin.nextLine();
            }else if(count == 1){
                power = stdin.nextLine();
                break;
            }else{
                break;
            }
            count++;
        }
        printLookNSaySeq(num, Integer.parseInt(power)+1);
        System.out.println(str);
    }
}
