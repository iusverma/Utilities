package com.atlasian.online;

import java.util.Scanner;

/*
 *  Corner case 1
 *  PMMPML -> means picked, moved 2 cells, then reset to 0th position, moved one cell again and than left
 *  
 *  Corner case 2
 *  Some row already has 16 blocks, hence command didn't lower the block next command is ML .. in this case
 *  without even a P next cell counter will increase.
 *  
 *  * check if after P it always starts from 0
 *
 *  Example 1:
 *  Input: PMLPMMMLPMMLPML
 *  Ouput: 0211000000
 *
 *  Example 2:
 *  Input: PLPLPLPLPLPLPLPLPLPL
 *  Ouput: A000000000
 */
public class RoboArm {
	public static void main(String...args) {
		Scanner scan = new Scanner(System.in);
		String input = scan.nextLine();

		int[] arr = new int[10];
		int pos = 0;
		char prevCommand = 'z';
		for (int i = 0; i < input.length(); i++) {
			if (input.charAt(i) == 'P') {
				if (prevCommand == 'P') {
					pos = 0;
				}
			} else if (input.charAt(i) == 'M') {
				pos++;
			} else if (input.charAt(i) == 'L') {
				if (arr[pos] < 15) {
					arr[pos]++;
				}
				pos = 0;
			}
		}

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] < 10) {
				System.out.print(arr[i]);
			} else if (arr[i] < 11) {
				System.out.print('A');
			} else if (arr[i] < 12) {
				System.out.print('B');
			} else if (arr[i] < 13) {
				System.out.print('C');
			} else if (arr[i] < 14) {
				System.out.print('D');
			} else if (arr[i] < 15) {
				System.out.print('E');
			}
		}
		scan.close();
	}
}
