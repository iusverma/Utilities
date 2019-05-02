package atlasian.online;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class FindSubArray {

    private static List<Integer> getList(int[] array) {
        List<Integer> list = new ArrayList<Integer>();
        for (int index = 0; index < array.length; index++)
        {
            list.add(array[index]);
        }
        return list;
    }
    
    public static int findArray(int array[], int subArray[]){
        return Collections.indexOfSubList(
                getList(array),
                getList(subArray));
           
    }
    
    public static void main(String args[]){
         ArrayList<String> list1 = new ArrayList<>();
         ArrayList<String> list2 = new ArrayList<>();
         Scanner stdin = new Scanner(System.in);
         int count = 0;
         while(stdin.hasNextLine())
         {
             int list1Size = 0;
             int list2Size = 0;
             if(count == 0){
                 list1Size = Integer.parseInt(stdin.nextLine());
             }
             for(int i=0;i<list1Size;i++){
                 list1.add(stdin.nextLine());
             }
             if(count == list1Size+1){
                 list2Size = Integer.parseInt(stdin.nextLine());
             }
             for(int i=0;i<list2Size;i++){
                 list2.add(stdin.nextLine());
             }
             count++;
         }
         System.out.println(list1.toString() + ":" +list2.toString()); 
         System.out.println(Collections.indexOfSubList(list1,list2));
    }
    
}
