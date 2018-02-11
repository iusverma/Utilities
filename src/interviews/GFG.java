package interviews;

import java.io.*;
import java.nio.charset.StandardCharsets;
/*
 * This was asked in JP Morgan Chase Interview for 
 * CIP - Software Engineer Associate - Sydney
 * 
 * Problem: Given two sequence, you need to find how many times
 * second sequence can be made from first sequence in increasing index.
 * This mean given seq1 & seq2, how many time you can make seq2 from seq1
 * provided you pick the characters from seq1 in increase index order. and a 
 * 
 * Example 1
 * Input: babag,bag
 * Output: 3
 * 
 */
/* 
// ALGORITHM
// Returns count of subsequences of S that match T 
// m is length of T and n is length of S
subsequenceCount(S, T, n, m)

   // An empty string is subsequence of all.
   1) If length of T is 0, return 1.

   // Else no string can be a sequence of empty S.
   2) Else if S is empty, return 0.
    
   3) Else if last characters of S and T don't match,
      remove last character of S and recur for remaining
        return subsequenceCount(S, T, n-1, m)

   4) Else (Last characters match), the result is sum
      of two counts.
        
        // Remove last character of S and recur.
        a) subsequenceCount(S, T, n-1, m) + 

        // Remove last characters of S and T, and recur.
        b) subsequenceCount(S, T, n-1, m-1)     
 */

class GFG {
	static int findSubsequenceCount(String sequence, String subSeq) {
		int seqLen = sequence.length();
		int subSeqLen = subSeq.length();
		
		// T can't appear as a subsequence in S	
		if (subSeqLen > seqLen)
			return 0;

		// mat[i][j] stores the count of 
        // occurrences of T(1..i) in S(1..j).
		int mat[][] = new int[subSeqLen + 1][seqLen + 1];

		// Initializing first column with
		// all 0s. An empty string can't have
		// another string as subsequence
		for (int i = 1; i <= subSeqLen; i++)
			mat[i][0] = 0;
		printMat(mat, seqLen, subSeqLen);

		// Initializing first row with all 1s.
		// An empty string is subsequence of all.
		for (int j = 0; j <= seqLen; j++)
			mat[0][j] = 1;
		printMat(mat, seqLen, subSeqLen);

		System.out.println("=================");
		// Fill mat[][] in bottom up manner
		for (int i = 1; i <= subSeqLen; i++) {
			for (int j = 1; j <= seqLen; j++) {
				// If last characters don't match,
				// then value is same as the value
				// without last character in seq.
				System.out.println(subSeq.charAt(i - 1));
				System.out.println(sequence.charAt(j - 1));
				if (subSeq.charAt(i - 1) != sequence.charAt(j - 1)){
					mat[i][j] = mat[i][j-1];
					System.out.println("1. setting mat["+i+"]["+j+"]="+mat[i][j]);
				}
				// Else value is obtained considering two cases.
				// a) All substrings without last character in S
				// b) All substrings without last characters in
				// both.
				else{
					mat[i][j] = mat[i][j-1] + mat[i-1][j-1];
					System.out.println("2. setting mat["+i+"]["+j+"]="+mat[i][j]);
				}
				printMat(mat, seqLen, subSeqLen);
			}
		}
		printMat(mat, seqLen, subSeqLen);
		return mat[subSeqLen][seqLen];
	}
	
	private static void printMat(int mat[][], int seqLen, int subSeqLen){
		for (int i = 0; i <= subSeqLen; i++, System.out.println())
			for (int j = 0; j <= seqLen; j++)
				System.out.print ( mat[i][j]+" ");
		for (int j = 0; j <= seqLen; j++)
			System.out.print( "**");
		System.out.println();
	}

	public static void main(String[] args) throws IOException {
		InputStreamReader reader = new InputStreamReader(System.in, StandardCharsets.UTF_8);
		BufferedReader in = new BufferedReader(reader);
		String line;
		while ((line = in.readLine()) != null) {
			String[] words = line.split(",");
			System.out.println(findSubsequenceCount(words[0], words[1]));
		}
	}
}
