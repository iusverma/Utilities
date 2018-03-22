package com.hackerrank.daily;

import java.io.*;
import java.util.*;

/*
 Try solving regular expression later
import java.text.*;
import java.math.*;
import java.util.regex.*;
*/
import java.lang.reflect.*;
import static java.lang.System.in;

/**
 * Check and print all the primes in given list of numbers
 * Sample Input:
 * 2
 * 1
 * 3
 * 4
 * 5
 *
 * Expected Output:
 * 2
 * 2
 * 2 3
 * 2 3 5
 */
class Prime {
	public void checkPrime(int... args) {
		for (int i = 0; i < args.length; i++) {
			// 1 is not prime number, move this logic to isPrime function
			if (args[i] <= 1) {
				// skip
				continue;
			}
			// 2, 3 are prime, move this also to isPrime
			if (args[i] < 4) {
				System.out.print(args[i] + " ");
				continue;
			}
			if (isPrime(args[i])) {
				System.out.print(args[i] + " ");
				continue;
			}
		}
		System.out.println();
	}

	private boolean isPrime(int num) {
		// if number is divisible by 2 it is not a prime
		if (num % 2 == 0)
			return false;

		// since we already test divisible by 2, no point in checking even numbers
		// so try dividing from 3,5,7,9...up to num/2 as any number after num/2
		// will not completely divide the num
		for (int i = 3; i < num / 2; i = i + 2) {
			if (num % i == 0)
				return false;
		}
		return true;
	}
}

public class PrimeChecker {

	public static void main(String[] args) {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			int n1 = Integer.parseInt(br.readLine());
			int n2 = Integer.parseInt(br.readLine());
			int n3 = Integer.parseInt(br.readLine());
			int n4 = Integer.parseInt(br.readLine());
			int n5 = Integer.parseInt(br.readLine());
			Prime ob = new Prime();
			ob.checkPrime(n1);
			ob.checkPrime(n1, n2);
			ob.checkPrime(n1, n2, n3);
			ob.checkPrime(n1, n2, n3, n4, n5);
			Method[] methods = Prime.class.getDeclaredMethods();
			Set<String> set = new HashSet<>();
			boolean overload = false;
			for (int i = 0; i < methods.length; i++) {
				if (set.contains(methods[i].getName())) {
					overload = true;
					break;
				}
				set.add(methods[i].getName());

			}
			if (overload) {
				throw new Exception("Overloading not allowed");
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}