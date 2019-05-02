package thirty.days.code;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Day25 {

    public static void main(String[] args) {
        /* Enter your code here. */
        Scanner scan = new Scanner(System.in);
        int testcases = scan.nextInt();
        for(int i=0;i<testcases;i++){
            int num = scan.nextInt();
            testPrime(num);
        }
        
    }
    private static void testPrime(int num){
        if(num==1){
            System.out.println("Not prime");
            return;
        }
        if(num==2 || num == 3){
            System.out.println("Prime");
            return;
        }
        if(num%2==0){
            System.out.println("Not prime");
            return;
        }
        for(int i=3;i<num;i=i+2){
            if(i*i<=num){
                if(num%i==0){
                    System.out.println("Not prime");
                    return;
                }
            }
        }
        System.out.println("Prime");
    }
}
