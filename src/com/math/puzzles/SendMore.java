package match.puzzles;

/**
 * Purpose of this util is to solve following math puzzle
 *  SPEND
 * - MORE
 * ======
 * MONEY
 * Each character is a differnt digit and no two digits are same. Solve the puzzle.
 */
public class SendMore {
	public static void main(String args[]) {
		System.out.println("START =================================");
		int first = 21345;
		int second = 1234;
		//System.out.println(validate(first, second,first-second));
		long startTime = System.nanoTime(); 
		//System.out.println(validateNumbers(first, second));
		//System.out.println(validateNumbers(22666, 2006));
		//System.out.println(validateNumbers(98765, 4327));
		int counter = 0;
		for(int i=first;i<=99999;i++) {
			for(int j=second;j<=9999;j++) {
				if( validateNumbers(i,j)) {
					counter++;
					if(validate(i, j,i-j)) {
						break;
					}
				}
			}
		}
		long endTime   = System.nanoTime();
		long totalTime = endTime - startTime;
		System.out.println(totalTime +", counter: " +counter);
	}

	private static boolean validateNumbers(int first, int second) {
		String firstNumber = Integer.toString(first);
		String secondNumber = Integer.toString(second);
		// Validate SPEND
		if (firstNumber.charAt(0) == firstNumber.charAt(1)
				|| firstNumber.charAt(0) == firstNumber.charAt(2)
				|| firstNumber.charAt(0) == firstNumber.charAt(3)
				|| firstNumber.charAt(0) == firstNumber.charAt(4)
				|| firstNumber.charAt(1) == firstNumber.charAt(2)
				|| firstNumber.charAt(1) == firstNumber.charAt(3)
				|| firstNumber.charAt(1) == firstNumber.charAt(4)
				|| firstNumber.charAt(2) == firstNumber.charAt(3)
				|| firstNumber.charAt(2) == firstNumber.charAt(4)
				|| firstNumber.charAt(3) == firstNumber.charAt(4)) {
			return false;
		}
		//Validate MORE
		if (secondNumber.charAt(0) == secondNumber.charAt(1)
				|| secondNumber.charAt(0) == secondNumber.charAt(2)
				|| secondNumber.charAt(0) == secondNumber.charAt(3)
				|| secondNumber.charAt(1) == secondNumber.charAt(2)
				|| secondNumber.charAt(1) == secondNumber.charAt(3)
				|| secondNumber.charAt(2) == secondNumber.charAt(3)) {
			return false;
		}
		// Validate SPEND - MORE
		if(firstNumber.charAt(2) != secondNumber.charAt(3)) {
			return false;
		}
		//validate SPEND/MORE
		if (firstNumber.charAt(0) == secondNumber.charAt(0)
				|| firstNumber.charAt(0) == secondNumber.charAt(1)
				|| firstNumber.charAt(0) == secondNumber.charAt(2)
				|| firstNumber.charAt(0) == secondNumber.charAt(3)
				|| firstNumber.charAt(1) == secondNumber.charAt(0)
				|| firstNumber.charAt(1) == secondNumber.charAt(1)
				|| firstNumber.charAt(1) == secondNumber.charAt(2)
				|| firstNumber.charAt(1) == secondNumber.charAt(3)
				|| firstNumber.charAt(2) == secondNumber.charAt(0)
				|| firstNumber.charAt(2) == secondNumber.charAt(1)
				|| firstNumber.charAt(2) == secondNumber.charAt(2)
				|| firstNumber.charAt(3) == secondNumber.charAt(0)
				|| firstNumber.charAt(3) == secondNumber.charAt(1)
				|| firstNumber.charAt(3) == secondNumber.charAt(2)
				|| firstNumber.charAt(3) == secondNumber.charAt(3)
				|| firstNumber.charAt(4) == secondNumber.charAt(0)
				|| firstNumber.charAt(4) == secondNumber.charAt(1)
				|| firstNumber.charAt(4) == secondNumber.charAt(2)
				|| firstNumber.charAt(4) == secondNumber.charAt(3)) {
			return false;
		}
		return true;
	}

	private static boolean validate(int first, int second, int diff) {
//		System.out.println("==================");
//		System.out.println("first: "+first);
//		System.out.println("second: "+second);
//		System.out.println("diff: "+diff);
//		System.out.println("==================");

		String firstNumber = Integer.toString(first);
		String secondNumber = Integer.toString(second);
		String difference = Integer.toString(diff);
		if (difference.length()<5) {
			return false;
		}

		// Validate SPEND - MORE = MONEY
		if(difference.charAt(0) == secondNumber.charAt(0) 
				&& difference.charAt(1) == secondNumber.charAt(1)
				&& difference.charAt(2) == firstNumber.charAt(3)
				&& difference.charAt(3) == secondNumber.charAt(3)
				&& difference.charAt(4) != firstNumber.charAt(0)
				&& difference.charAt(4) != firstNumber.charAt(1)
				&& difference.charAt(4) != firstNumber.charAt(2)
				&& difference.charAt(4) != firstNumber.charAt(3)	
				&& difference.charAt(4) != firstNumber.charAt(4)
				&& difference.charAt(4) != secondNumber.charAt(0)
				&& difference.charAt(4) != secondNumber.charAt(1)
				&& difference.charAt(4) != secondNumber.charAt(2)
				&& difference.charAt(4) != secondNumber.charAt(3)) {
			System.out.println("SPEND: "+firstNumber);
			System.out.println("MORE: "+secondNumber);
			System.out.println("MONEY: "+difference);
			
			return true;
		}
		
		return false;
	}
/*
results
START =================================
SPEND: 50817
MORE: 4628
MONEY: 46189
SPEND: 63140
MORE: 5721
MONEY: 57419
SPEND: 64790
MORE: 5817
MONEY: 58973
SPEND: 70839
MORE: 6458
MONEY: 64381
SPEND: 80519
MORE: 7365
MONEY: 73154
SPEND: 82609
MORE: 7546
MONEY: 75063
SPEND: 83160
MORE: 7541
MONEY: 75619
SPEND: 84150
MORE: 7631
MONEY: 76519
SPEND: 91620
MORE: 8356
MONEY: 83264
SPEND: 93607
MORE: 8546
MONEY: 85061
15037336573, counter: 1243962
*/
}
