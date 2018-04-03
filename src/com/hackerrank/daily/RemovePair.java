package com.hackerrank.daily;

import java.util.Scanner;

/*
 * remove all possible duplicates from string
 * Sample Input: kagoyzkgfjnyvjewazalxngpdcfahneqoqgiyjgpzobhaghmgzmnwcmeykqzgajlmuerhhsanpdtmrzibswswzjjbjqytgfewiuu
 * Sample Output: kagoyzkgfjnyvjewazalxngpdcfahneqoqgiyjgpzobhaghmgzmnwcmeykqzgajlmuersanpdtmrzibswswzbjqytgfewi
 * 
 * Sample Input: aaabccddd
 * Sample Output: abd
 * 
 * Sample Input: aa
 * Sample Output: Empty String
 * 
 * Sample Input: baab
 * Sample Output: Empty String
 */
public class RemovePair {

    static String super_reduced_string(String s){
        while(findFirstPair(s) >=0){
            s = removePair(s, findFirstPair(s));
        }
        System.out.println("s: "+s);
        return s;
    }

    static private int findFirstPair(String s){
        int pairIndex = -1;
        if(s.length()==1) {
        		return pairIndex;
        }
        if(s.length()==2) {
        		if(s.charAt(0) == s.charAt(1)) {
        			return 0;
        		}
        }
        for(int i=0;i<=s.length()-2;i++){
            if(s.charAt(i) == s.charAt(i+1)){
                return i;
            }
        }
        return pairIndex;
    }
    
    static private String removePair(String s, int index){
    		if(s.length() == 1)
    			return s;
    		if(s.length() == 2)
    			return "";
    		String temp = s.substring(0,index);
    		System.out.println("temp 1:"+temp);
        temp += s.substring(index+2);
        System.out.println("temp 2:"+temp);
        return temp;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        String result = super_reduced_string(s);
        System.out.println(result);
    }
}
