package interviews;


import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;



class Result {

    /*
     * Complete the 'entryTime' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. STRING s
     *  2. STRING keypad
     */

    public static int entryTime(String s, String keypad) {
    	int time = 0;
    	for(int i=0;i<s.length()-1;i++) {
    		char ch1 = s.charAt(i);
    		System.out.println(ch1);
    		char ch2 = s.charAt(i+1);
    		System.out.println(ch2);
    		int loc1 = keypad.lastIndexOf(ch1);
    		System.out.println(loc1);
    		int loc2 = keypad.lastIndexOf(ch2);
    		System.out.println(loc2);
    		if(loc2>loc1) {
    			time  += (loc2-loc1);
    			System.out.println("-"+time);
    		}else {
    			time = time + (loc2 + (keypad.length()-loc1));
    			System.out.println("+"+time);
    		}
 	
    	}
    	return time;

    }

}

public class Sample1 {
    public static void main(String[] args) throws IOException {
//        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
//
//        String s = bufferedReader.readLine();
//
//        String keypad = bufferedReader.readLine();

        int result = Result.entryTime("423692", "923857614");

//        bufferedWriter.write(String.valueOf(result));
//        bufferedWriter.newLine();
//
//        bufferedReader.close();
//        bufferedWriter.close();
    }
}
