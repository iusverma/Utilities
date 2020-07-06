package com.hackerrank.viator;

import java.util.HashSet;
import java.util.Set;
import java.util.Vector;

/**
 * you need to figure out distinct pair which form a given sum
 * 
 * Example:
 * array[] = { 6,6,3,9,3,5,1};
 * has 3 pairs with sum 12 {6,6},{3,9} & {9,3}
 * but there are only 2 distinct pairs (6,6) and (3,9)/(9,3)
 */
public class DistinctPair {

	/*
	 * this is taking long for huge inputs, need to work on time complexity
	 */
    static int numberOfPairs(int[] a, long k) {
    		/** this will store number of total pair */
    		int count = 0;
        Set<String> set = new HashSet<>();

        for (int i = 0; i < a.length; i++) 
        {
            for (int j = i + 1; j < a.length; j++)
                if (a[i] + a[j] == k ){
                    System.out.println(i+"+"+j);
                    System.out.println(a[i]+"+"+a[j]);
                    if(a[i]<=a[j]) {
                    		String tempS = a[i] + "-" +a[j];
                    		set.add(tempS);
                    }else {
                    	String tempS = a[j] + "-" +a[i];
                		set.add(tempS);
                    }
                    count++;
            }
        }
        System.out.println(count +" pairs with sum "+k);
        return set.size();
    }

    public static void main(String args[])
    {
        int arr[] = { 6,6,3,9,3,5,1};
        int k = 12;
        System.out.println("Distinct of pairs with given sum is "
                        + numberOfPairs(arr, k));
    }
}
