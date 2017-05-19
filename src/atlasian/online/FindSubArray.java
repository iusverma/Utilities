package atlasian.online;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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
        int arr [] = {10,4,6,67,89,4};
        int sarr1 [] = {6,67};
        int sarr2 [] = {10};
        int sarr3 [] = {67,89,4};
        int sarr4 [] = {4,4};
        System.out.println(findArray(arr, sarr1));
        System.out.println(findArray(arr, sarr2));
        System.out.println(findArray(arr, sarr3));
        System.out.println(findArray(arr, sarr4));
    }
}
