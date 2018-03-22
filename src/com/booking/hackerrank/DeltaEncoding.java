package com.booking.hackerrank;

import java.io.*;
import java.util.*;
/*
Chek if following can be used
import java.text.*;
import java.math.*;
import java.util.regex.*;
*/

/*
Input
8
25626
25757
24367
24267
16
100
2
7277

Output
25626
-128
131
-128
-1390
-100
-128
-24251
84
-98
-128
7275

range for -128
-127<-=x<=127
 */
public class DeltaEncoding {

	/*
	 * Complete the function below.
	 */
	static int[] delta_encode(int[] array) {
		ArrayList<Integer> list = new ArrayList<>();
		if (array.length > 0) {
			list.add(array[0]);
			for (int i = 1; i < array.length; i++) {
				int temp = array[i] - array[i - 1];
				if (temp < -127 || temp > 127)
					list.add(-128);
				list.add(temp);
			}
		}
		int[] arr = new int[list.size()];
		for (int i = 0; i < list.size(); i++) {
			arr[i] = list.get(i);
		}
		return arr;
	}

	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		final String fileName = System.getenv("OUTPUT_PATH");
		BufferedWriter bw = null;
		if (fileName != null) {
			bw = new BufferedWriter(new FileWriter(fileName));
		} else {
			bw = new BufferedWriter(new OutputStreamWriter(System.out));
		}

		int[] res;
		int array_size = 0;
		array_size = Integer.parseInt(in.nextLine().trim());

		int[] array = new int[array_size];
		for (int i = 0; i < array_size; i++) {
			int array_item;
			array_item = Integer.parseInt(in.nextLine().trim());
			array[i] = array_item;
		}

		res = delta_encode(array);
		for (int res_i = 0; res_i < res.length; res_i++) {
			bw.write(String.valueOf(res[res_i]));
			bw.newLine();
		}

		bw.close();
		in.close();
	}
}
