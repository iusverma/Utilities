package com.hackerrank.daily;


import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

public class PlusMinusFormat {


    /*
     * Complete the plusMinus function below.
     */
    static void plusMinus(int[] arr) {
        int arrLen = arr.length;
        int negNumCnt = 0;
        int posNumCnt = 0;
        int zeroCnt = 0;
        for(int i=0;i<arrLen;i++){
        		System.out.println("Number: "+arr[i]);
            if(arr[i] < 0){
                negNumCnt++;
            }else if(arr[i] > 0) {
                posNumCnt++;
            }else {
                zeroCnt++;
            }
        }
        DecimalFormat df = new DecimalFormat("#.######");
        System.out.println(df.format((float)posNumCnt/arrLen));
        System.out.println(df.format((float)negNumCnt/arrLen));
        System.out.println(df.format((float)zeroCnt/arrLen));
    }

    private static final Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        int n = Integer.parseInt(scan.nextLine().trim());

        int[] arr = new int[n];

        String[] arrItems = scan.nextLine().split(" ");

        for (int arrItr = 0; arrItr < n; arrItr++) {
            int arrItem = Integer.parseInt(arrItems[arrItr].trim());
            arr[arrItr] = arrItem;
        }

        plusMinus(arr);
    }
}

