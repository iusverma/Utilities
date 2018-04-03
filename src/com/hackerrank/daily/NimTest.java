package com.hackerrank.daily;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

/**
 * TODO: Need some scenarios to be tested
 * @author ayverma
 *
 */
public class NimTest {

    static String nimGame(int[] pile) {
    		//int [] arr = new int[pile.length];
    		int xor = 0;
        for(int i=0;i<pile.length-1;i++) {
        		xor = xor ^ pile[i];
        }
        if(xor==0)
        		return "Second";
        else
        		return "First";
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int g = in.nextInt();
        for(int a0 = 0; a0 < g; a0++){
            int n = in.nextInt();
            int[] pile = new int[n];
            for(int pile_i = 0; pile_i < n; pile_i++){
                pile[pile_i] = in.nextInt();
            }
            String result = nimGame(pile);
            System.out.println(result);
        }
        in.close();
    }
}


