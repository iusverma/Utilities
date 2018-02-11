package interviews;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class HourGlass {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int arr[][] = new int[6][6];
        for(int arr_i=0; arr_i < 6; arr_i++){
            for(int arr_j=0; arr_j < 6; arr_j++){
                arr[arr_i][arr_j] = in.nextInt();
            }
        }
        // If we initialize to 0, max sum in array can be in negative 
        // so need to initialize sum to a low negative number
        int sum = -1024;
        for(int i=0;i<4;i++){
            for(int j=0;j<4;j++){
            	int temp = 0;
                int x=i,y=j;
                temp = temp + arr[x][y] + arr[x][y+1] + arr[x][y+2] 
                		+ arr[x+1][y+1] + arr[x+2][y] + arr[x+2][y+1] 
                		+ arr[x+2][y+2];
                //System.out.println(temp);
                if(temp>sum)
                	sum = temp;
            }
        }
        System.out.println(sum);
    }
}