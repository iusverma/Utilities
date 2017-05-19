/**
 Just change the map for any number system
 * add or remove entries if needed.
 */
package atlasian.online;

import java.util.HashMap;

public class NumberConverter {
       private static HashMap<Integer, Character> numberMap = new HashMap<>();
       private static HashMap<Character, Integer> stringMap = new HashMap<>();

       private static void init(){
           numberMap.put(0, 'A');
           numberMap.put(1, 'B');
           numberMap.put(2, 'C');
           numberMap.put(3, 'D');
           numberMap.put(4, 'E');
           numberMap.put(5, 'F');
           numberMap.put(6, 'G');
           numberMap.put(7, 'H');
           
           stringMap.put('A',0);
           stringMap.put('B',1);
           stringMap.put('C',2);
           stringMap.put('D',3);
           stringMap.put('E',4);
           stringMap.put('F',5);
           stringMap.put('G',6);
           stringMap.put('H',7);           
       }
       
       public static String convertNumber(int num){
           String str = "";
           if(num==0){
               str += numberMap.get(num);
               return str;
           }

           init();
           int base = numberMap.size();
           
           while(num>0){
               int a = num % base;
               str += numberMap.get(a);
               num = num / base;               
           }
           StringBuilder finalStr = new StringBuilder(str).reverse();
           return finalStr.toString();
       }
       
       
       public static int convertString(String str){
           init();
           int num = 0;
           int size = str.length()-1;
           int baseLength = stringMap.size();
           int pow = 0;
           for(int i=size;i>=0;i--){
               int tnum = stringMap.get(str.charAt(i));
               num += tnum*Math.pow(baseLength, pow);
               pow++;
           }
           return num;
       }
       
       public static void main(String args[]){
           String temp = convertNumber(123);
           System.out.println("Coverted number for 123 is: " +temp);
           int number = convertString(temp);
           System.out.println("Coverted number for " +temp +" is: " +number);
           // Write corner case for 0
           System.out.println("1 is " +convertNumber(1) +"; which is revertes as: " +convertString(convertNumber(1)));
           System.out.println("7569 is " +convertNumber(7569) +"; which is revertes as: " +convertString(convertNumber(7569)));
           System.out.println("6545415 is " +convertNumber(6545415) +"; which is revertes as: " +convertString(convertNumber(6545415)));
           System.out.println("0 is " +convertNumber(0) +"; which is revertes as: " +convertString(convertNumber(0)));
       }
}
