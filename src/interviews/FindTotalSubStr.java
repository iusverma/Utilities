package interviews;

import java.io.*;
import java.nio.charset.StandardCharsets;

/*
 * Basic idea here is, we will iterate through each character of sub sequence 
 * in sequence and if character is found it's location will be stored in 2 dim 
 * array.
 * Once we have array populated, we will find all traversals or paths in the array
 * 
 * Example:
 * babag,bag
 * 
 * babag, bag
 * 01234
 * 
 * two dimension array will be 
 * b 0  2 -1
 * a 1  3 -1
 * g 4 -1 -1
 * 
 * Based on above array possible combinations are 
 * (0,1,4),(0,3,4),(2,3,4) - if character has to be taken in increasing index
 * Final number = 3
 */
public class FindTotalSubStr {
	public static void main(String... arg) throws Exception {
		System.out.println("Hello World");
		InputStreamReader reader = new InputStreamReader(System.in, StandardCharsets.UTF_8);
		BufferedReader in = new BufferedReader(reader);
		String line;
		while ((line = in.readLine()) != null) {
			String[] words = line.split(",");
			System.out.println(findSubsequenceCount(words[0], words[1]));
		}
	}

	/*
	 * S = sequence SS = sub sequence
	 */
	private static String findSubsequenceCount(String S, String SS) {
		// This two dimensional array will hold the position of each character in SS
		int ssLen = SS.length();
		int sLen = S.length();
		int[][] seqMat = new int[SS.length()][S.length()];
		for (int i = 0; i < ssLen; i++)
			for (int j = 0; j < sLen; j++)
				seqMat[i][j] = -1;
		printMat(seqMat, ssLen, sLen);
		for (int i = 0; i < ssLen; i++) {
			int cntr = 0;
			for (int j = 0; j < sLen; j++) {
				if (SS.charAt(i) == S.charAt(j)) {
					seqMat[i][cntr] = j;
					cntr++;
				}
			}
		}
		int numOfSubSeq = findNumberOfSubsequence(seqMat, ssLen, sLen);
		printMat(seqMat, ssLen, sLen);
		return "";
	}

	private static int findNumberOfSubsequence(int[][] seqMat, int ssLen, int sLen) {
		for (int i = 0; i < sLen; i++) {
			if (seqMat[0][i] >= 0) {
				// find the next index in next line
				// then next in another line
				// continue till have all line covered
			}
		}
		return 0;
	}

	/*
	 * Prints a two dimensional array
	 */
	private static void printMat(int mat[][], int row, int col) {
		for (int i = 0; i < row; i++, System.out.println())
			for (int j = 0; j < col; j++)
				System.out.print(mat[i][j] + " ");
		for (int j = 0; j < col; j++)
			System.out.print("**");
		System.out.println();
	}
}
