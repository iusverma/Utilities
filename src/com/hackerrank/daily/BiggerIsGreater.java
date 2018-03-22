package com.hackerrank.daily;

import java.util.Scanner;

/**
 * This solution finds lexicographical next sequence in the given string Sample
 * Input:
 *  5
 *  ab
 *  bb
 *  hefg
 *  dhck
 *  dkhc
 *
 * Expected Output:
 *  ba
 *  no answer
 *  hegf
 *  dhkc
 *  hcdk
 */
public class BiggerIsGreater {

	/**
	 * Correct implementation
	 * Step 1: traversing from reverse find i, such that next
	 * character (in reverse) is smaller than character @ i i.e. find i such that
	 * a[i] >= a[i-1], this is also the first increasing sequence of length 2 while
	 * traversing reverse
	 * Step 2: traversing from reverse find j, such that it is
	 * smaller than a[i] i.e. a[j] <= a[i-1]
	 * Step 3: swap (i-1) & j
	 * Step 4: from i to end of string reverse the characters, since in step 1 we reach i, by find
	 * increasing sequence, this implies that all characters from i till end are in
	 * decreasing order, hence reverse.
	 */
	private static String biggerIsGreater(String w) {
		char[] array = w.toCharArray();
		int i = array.length - 1;

		// First loop for finding i
		while (i > 0 && array[i - 1] >= array[i]) {
			i--;
		}
		// System.out.println(i);
		if (i <= 0) {
			return "no answer";
		}

		int j = array.length - 1;
		// Second loop for finding i
		while (array[j] <= array[i - 1]) {
			j--;
		}
		// System.out.println(i);
		// Swap i & j
		char temp = array[i - 1];
		array[i - 1] = array[j];
		array[j] = temp;

		j = array.length - 1;

		// reverse order for all other
		while (i < j) {
			temp = array[i];
			array[i] = array[j];
			array[j] = temp;
			i++;
			j--;
		}

		return new String(array);
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		for (int a0 = 0; a0 < T; a0++) {
			String w = in.next();
			String result;
			result = biggerIsGreater(w);
			System.out.println(result);
			// result = nextPermutation(w);
			// System.out.println(result);
		}
		in.close();
	}

	/**
	 * Following method is just swapping one character, which us bigger than current
	 * and present in current string. Result of this may not be lexically greater
	 */
	static String nextPermutation(String w) {
		char[] wArr = w.toCharArray();
		char currChar;
		for (int i = w.length() - 1; i >= 0; i--) {
			currChar = w.charAt(i);
			System.out.println("Current char: " + currChar);
			int asciiChar = currChar;
			for (int c = asciiChar + 1; c <= 'z'; c++) {
				char nextChar = (char) c;
				System.out.println("Next char should be: " + nextChar);
				if (w.lastIndexOf(nextChar) > w.lastIndexOf(currChar)) {
					int nextCharLoc = w.lastIndexOf(nextChar);
					System.out.println(
							nextChar + " found in string, at index " + nextCharLoc + " " + w.charAt(nextCharLoc));
					// swap i with nextCharLoc
					char temp = wArr[nextCharLoc];
					wArr[nextCharLoc] = wArr[i];
					wArr[i] = temp;
					return new String(wArr);
				}
			}
		}
		return "no answer";
	}
}