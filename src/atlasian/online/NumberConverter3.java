/**
 Just change the map for any number system
 * add or remove entries if needed.
 */
package atlasian.online;

import java.util.HashMap;
import java.util.Scanner;

public class NumberConverter3 {
       private static HashMap<Integer, Character> numberMap = new HashMap<>();
      // private static HashMap<Character, Integer> stringMap = new HashMap<>();

       private static void init(){
           numberMap.put(0, '0');
           numberMap.put(1, 'a');
           numberMap.put(2, 't');
           numberMap.put(3, 'l');
           numberMap.put(4, 's');
           numberMap.put(5, 'i');
           numberMap.put(6, 'n');
           
//           stringMap.put('0',0);
//           stringMap.put('a',1);
//           stringMap.put('t',2);
//           stringMap.put('l',3);
//           stringMap.put('s',4);
//           stringMap.put('i',5);
//           stringMap.put('n',6);          
       }
//       private static void init1(){
//           numberMap.put(0, 'A');
//           numberMap.put(1, 'B');
//           numberMap.put(2, 'C');
//           numberMap.put(3, 'D');
//           numberMap.put(4, 'E');
//           numberMap.put(5, 'F');
//           numberMap.put(6, 'G');
//           numberMap.put(7, 'H');
//           
//           stringMap.put('A',0);
//           stringMap.put('B',1);
//           stringMap.put('C',2);
//           stringMap.put('D',3);
//           stringMap.put('E',4);
//           stringMap.put('F',5);
//           stringMap.put('G',6);
//           stringMap.put('H',7);           
//       }
       
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
       
       
//       public static int convertString(String str){
//           init();
//           int num = 0;
//           int size = str.length()-1;
//           int baseLength = stringMap.size();
//           int pow = 0;
//           for(int i=size;i>=0;i--){
//               int tnum = stringMap.get(str.charAt(i));
//               num += tnum*Math.pow(baseLength, pow);
//               pow++;
//           }
//           return num;
//       }
       
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
