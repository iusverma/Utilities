package com.booking.hackerrank;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

/*
 * To deduce if the 3 given lines (with lengths) can create a triangle.
 */
public class Triangle {

	/*
	 * Complete the function below.
	 */
	static int triangle(int a, int b, int c) {
		if (a < 0 && b < 0 && c < 0)
			return 0;

		// No need to check for a==c, because if following both are true
		// it is and equilateral triangle
		if (a == b && b == c)
			return 1;

		if ((a + b > c) && (a - b < c)
				&& (c + a > b) && (c - a < b)
				&& (b + c > a) && (b - c < a))
			return 2;

		else
			return 0;
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

		int res;
		int a;
		a = Integer.parseInt(in.nextLine().trim());

		int b;
		b = Integer.parseInt(in.nextLine().trim());

		int c;
		c = Integer.parseInt(in.nextLine().trim());

		res = triangle(a, b, c);
		bw.write(String.valueOf(res));
		bw.newLine();

		bw.close();
		in.close();
	}
}
