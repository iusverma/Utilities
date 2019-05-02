/**
 Just change the map for any number system
 * add or remove entries if needed.
 */
package atlasian.online;

import java.util.HashMap;
import java.util.Scanner;

public class NumberConverter2 {
       private static HashMap<Integer, Character> numberMap = new HashMap<>();

       private static void init(){
           numberMap.put(0, '0');
           numberMap.put(1, 'a');
           numberMap.put(2, 't');
           numberMap.put(3, 'l');
           numberMap.put(4, 's');
           numberMap.put(5, 'i');
           numberMap.put(6, 'n');
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

       public static void main(String args[]){
            String num = "";
            Scanner stdin = new Scanner(System.in);
            int count =0;
            while (stdin.hasNextLine()) {
                if (count == 0) {
                    num = stdin.nextLine();
                    break;
                } else {
                    break;
                }
            }
            String fin = convertNumber(Integer.parseInt(num));
            System.out.println(fin);
       }
}
