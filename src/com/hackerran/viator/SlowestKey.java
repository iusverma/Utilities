package com.hackerran.viator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SlowestKey {
	//private static 
	//private List<Integer>
	
	public static void main(String...a) {
		//int [] a1 = {0, 2, 1, 3, 0,7};
		//System.out.println(slowestKey(a1, 3));
		List<Integer> a1 = new ArrayList<>();
		a1.add(3);
		a1.add(2);
		a1.add(0);
		a1.add(2);a1.add(1);a1.add(3);a1.add(0);a1.add(7);
		List<List<Integer>>kli1 = new ArrayList<List<Intger>>();
		System.out.println(slowestKey(a1));
		//int [] a2 = {0, 1, 0, 3, 4, 5, 5, 6, 4, 10};
		//System.out.println(slowestKey(a2, 5));
		List<Integer> a2 = new ArrayList<>();
		a2.add(5);a2.add(2);
		a2.add(0);
		a2.add(1);
		a2.add(0);
		a2.add(3);a2.add(4);a2.add(5);a2.add(5);a2.add(5);
		a2.add(4);a2.add(10);
		System.out.println(slowestKey(a2));
	}

	public static String slowestKey(List<List<Integer>> keyTimes) {
		int keys = keyTimes.get(0).get(0);
		List<Integer> keyPress = keyTimes.get(2) ;
		int size = keyPress.size();
		int [] arr = new int[size-2];
		//int k = ;
		for(int i=0;i<arr.length;i++) {
			arr[i] = keyPress.get(1) ;
			//k++;
		}
		int max = 0;
		int location = 0;
		int []a1 = new int[keys];
		int pressTime = 1;
		for(int i=0;i<keys;i++) {
			a1[i] = arr[pressTime];
			pressTime+=2;
		}
//		for(int i=0;i<keys;i++) {
//			System.out.println(a1[i]);
//		}
		
		for(int i=1;i<keys-1;i++) {
			int temp = a1[i+1] - a1[i];
			//System.out.println("t"+temp);
			if(temp > max) {
				max = temp;
				location = i;
			}
		}
		//System.out.println("Slowest: "+max);
		Map<Integer, String> alhpa = new HashMap<>();
		alhpa.put(0, "a");
		alhpa.put(1, "b");
		alhpa.put(2, "c");
		alhpa.put(3, "d");
		alhpa.put(4, "e");
		alhpa.put(5, "f");
		alhpa.put(6, "g");
		alhpa.put(7, "h");
		alhpa.put(8, "i");
		alhpa.put(9, "j");
		alhpa.put(10, "k");
		alhpa.put(11, "l");
		alhpa.put(12, "m");
		alhpa.put(13, "n");
		alhpa.put(14, "o");
		alhpa.put(15, "p");
		alhpa.put(16, "q");
		alhpa.put(17, "r");
		alhpa.put(18, "s");
		alhpa.put(19, "t");
		alhpa.put(20, "u");
		alhpa.put(21, "v");
		alhpa.put(22, "w");
		alhpa.put(23, "x");
		alhpa.put(24, "y");
		alhpa.put(25, "z");
		return(alhpa.get(location));
		
	}
}
