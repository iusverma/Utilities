package interviews;
/*
 * This was asked in JP Morgan Chase Interview for 
 * CIP - Software Engineer Associate - Sydney
 * 
 * Problem: Given a array on numbers and a number N,
 * reverse every N elements in array. If there are elements
 * at end which are not multiple of N, leave them as it is.
 * 
 * Example 1
 * Input: 1,2,3,4,5;3
 * Output: 3,2,1,4,5
 * 
 * Example 2
 * Input: 1,2,3,4,5;2
 * Output: 2,1,4,3;5
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class ReverseSelectiveArray {
  /**
   * Iterate through each line of input.
   */
  public static void main(String[] args) throws IOException {
    InputStreamReader reader = new InputStreamReader(System.in, StandardCharsets.UTF_8);
    BufferedReader in = new BufferedReader(reader);
    String line;
    while ((line = in.readLine()) != null) {
    	String result = reverseLineBasedonToken(line).replaceAll("\\s", "");
        String temp = result.substring(1, result.length()-1);
        System.out.println(temp);
    }
  }
  
  private static String reverseLineBasedonToken(String line){
    String[] words = line.split(";");
    String tokSize = words[1];
    String [] arr2Rev = words[0].split(",");
    List <Integer> list = new ArrayList<>();
    
    System.out.println(arr2Rev);
    for(int i=0;i<arr2Rev.length;i++){
    	System.out.println(arr2Rev[i]);
    	list.add(Integer.parseInt(arr2Rev[i]));
    }
    System.out.println(list.toString());
    int tok = Integer.parseInt(tokSize);
    System.out.println(tok);
    int pos = 0;
    int itemNotToReverse = list.size() % tok;
    int newArrLen = list.size() - itemNotToReverse;
    System.out.println(newArrLen);
    
    while(pos<newArrLen){
    	System.out.println(list.subList(pos,pos+tok));
    	reverse(list.subList(pos,pos+tok));
    	pos=pos+tok;
    	System.out.println(pos);
    }
    return list.toString();
  }
  
  private static void reverse(List<Integer> s){
    Collections.reverse(s);
  }
}

