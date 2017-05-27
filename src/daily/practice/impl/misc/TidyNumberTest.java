package daily.practice.impl.misc;
public class TidyNumberTest{
	public static boolean isTidyNumber(int num){
		int currentDigit = num;
		int lastDigit = num;
		do{
			lastDigit=currentDigit;
			currentDigit = num % 10;
			num = num/10;
			if(lastDigit < currentDigit){
				return false;
			}
		}while(num>0);
		return true;
	}
	public static void main(String args[]){
		System.out.println("12345 is tidy: "+isTidyNumber(12345));
		System.out.println("12245 is tidy: "+isTidyNumber(12245));
		System.out.println("12342 is tidy: "+isTidyNumber(12342));
		System.out.println("21345 is tidy: "+isTidyNumber(21345));
	}
}