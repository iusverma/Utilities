package com.hackerrank.daily;

import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;
/*
Input
5
1000000001 1000000002 1000000003 1000000004 1000000005

Output
5000000015
*/
public class LargeSum {

    /*
     * Complete the aVeryBigSum function below.
     */
    static long aVeryBigSum(int n, long[] ar) {
        long sum = 0;
        double maxAllowedNumber = Math.pow(10,10);
        for(int i=0;i<n;i++){
            if(ar[i] <= maxAllowedNumber){
                sum += ar[i];
            }
        }
        return sum;
    }

    private static final Scanner scan = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        //BufferedWriter bw = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
    		Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine().trim());

        long[] ar = new long[n];

        String[] arItems = scan.nextLine().split(" ");

        for (int arItr = 0; arItr < n; arItr++) {
            long arItem = Long.parseLong(arItems[arItr].trim());
            ar[arItr] = arItem;
        }

        long result = aVeryBigSum(n, ar);

        System.out.println(result);
        //bw.write(String.valueOf(result));
        //bw.newLine();
        //bw.close();
    }
}