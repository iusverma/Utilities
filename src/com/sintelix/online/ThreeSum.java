package com.sintelix.online;
import java.util.LinkedList;

/**
 * @author ayverma
 * Find three consecutive number with given sum and return true
 * else false
 */
public class ThreeSum {
    LinkedList<Integer> ll = new LinkedList<>();

    /**
     * Adds/appends list of integers at the end of internal list.
     */
    public void addLast(int[] list) {
        for(int i=0;i<list.length;i++) {
        	ll.addLast(list[i]);
        }
    }

    /**
     * Returns boolean representing if any three consecutive integers in the
     * internal list have given sum.
     */
    public boolean containsSum3(int sum) {
        int lastPosibleIndexForSum = ll.size()-3;
        for(int i=0;i<=lastPosibleIndexForSum;i++) {
        	int calculatedSum = ll.get(i) + ll.get(i+1) + ll.get(i+2);
        	System.out.println("Calculated Sum: " +calculatedSum);
        	if(calculatedSum == sum){
        		return true;
        	}
        }
        return false;
    }

    public static void main(String[] args) {
    	ThreeSum s = new ThreeSum();

        s.addLast(new int[] { 1, 2, 3 });

        System.out.println(s.containsSum3(6));
        System.out.println(s.containsSum3(9));

        s.addLast(new int[] { 4 });

        System.out.println(s.containsSum3(9));
    }
}