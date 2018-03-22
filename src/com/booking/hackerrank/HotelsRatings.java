package com.booking.hackerrank;

import java.io.*;
import java.util.*;
/*
Check if following can be used
import java.text.*;
import java.math.*;
import java.util.regex.*;
*/

/*
Input
breakfast beach citycenter location metro view staff price
5
1
2
1
1
2
5
This hotel has a nice view of the citycenter. The location is perfect.
The breakfast is ok. Regarding location, it is quite far from citycenter but price is cheap so it is worth.
Location is excellent, 5 minutes from citycenter. There is also a metro station very close to the hotel.
They said I couldn't take my dog and there were other guests with dogs! That is not fair.
Very friendly staff and good cost-benefit ratio. Its location is a bit far from citycenter.

Output
2
1
*/
public class HotelsRatings {

	/*
	 * Complete the function below.
	 */
	static int[] sort_hotels(String keywords, int[] hotel_ids, String[] reviews) {
		//TODO
		int[] a = new int[1];
		return a;
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
		String keywords;
		try {
			keywords = in.nextLine();
		} catch (Exception e) {
			keywords = null;
		}

		int hotel_ids_size = 0;
		hotel_ids_size = Integer.parseInt(in.nextLine().trim());

		int[] hotel_ids = new int[hotel_ids_size];
		for (int i = 0; i < hotel_ids_size; i++) {
			int hotel_ids_item;
			hotel_ids_item = Integer.parseInt(in.nextLine().trim());
			hotel_ids[i] = hotel_ids_item;
		}

		int reviews_size = 0;
		reviews_size = Integer.parseInt(in.nextLine().trim());

		String[] reviews = new String[reviews_size];
		for (int i = 0; i < reviews_size; i++) {
			String reviews_item;
			try {
				reviews_item = in.nextLine();
			} catch (Exception e) {
				reviews_item = null;
			}
			reviews[i] = reviews_item;
		}

		res = sort_hotels(keywords, hotel_ids, reviews);
		for (int res_i = 0; res_i < res.length; res_i++) {
			bw.write(String.valueOf(res[res_i]));
			bw.newLine();
		}

		bw.close();
		in.close();
	}
}
