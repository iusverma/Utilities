package com.hackerrank.viator;

/**
 * Need to find highest prime for which absolute sum is highest Example: 100
 * Prime with highest absolute sum = 89 Absolute sum = 17
 */
public class SumOfPrime {
	static int largest = 1;
	static int largestPrime = 1;

	static int calculateLargest(int max) {
		int largest = 0;
		int largestPrime = 0;
		for (int i = 2; i < max; i++) {
			System.out.println("num-" + i);
			if (isPrime(i)) {
				int sum = getAbsSum(i);
				if (sum >= largest) {
					largest = sum;
					largestPrime = i;
				}
			}
		}

		// required sum
		return largestPrime;
	}

	static int getAbsSum(int n) {
		int sum = 0;
		do {
			sum = sum + n % 10;
			n = n / 10;
		} while (n > 0);
		System.out.println("sum-" + sum);
		System.out.println("largest-" + largest);
		return sum;
	}

	static boolean isPrime(int n) {
		if (n <= 3)
			return true;
		if (n % 2 == 0)
			return false;
		for (int i = 3; i < n / 2; i = i + 2) {
			if (n % i == 0)
				return false;
		}
		return true;
	}

	// Driver program
	public static void main(String args[]) {
		int n = 100;
		System.out.println("Sum = " + calculateLargest(n));
	}

}
