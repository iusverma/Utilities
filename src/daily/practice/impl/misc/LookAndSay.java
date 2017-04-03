package daily.practice.impl.misc;

/**
 * Class - https://en.wikipedia.org/wiki/Look-and-say_sequence
 * @author ayverma
 *
 */
public class LookAndSay{

	public static void lookAndSay(int num){
		String givenNum = Integer.toString(num);
		int count = 0;
		for(int i=0;i<givenNum.length();i++){
			count++;
			char currentChar = givenNum.charAt(i);
			char nextChar = i==(givenNum.length()-1)?'\0':givenNum.charAt(i+1);
			if(currentChar != nextChar){
				System.out.print(count);
				System.out.print(currentChar);
				count=0;
			}
		}
	}

	public static void main(String args[]){
		LookAndSay.lookAndSay(112334445);
	}
}