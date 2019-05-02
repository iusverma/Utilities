package thirty.days.code;

import java.util.Scanner;

public class Day6{

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scan = new Scanner(System.in);
        int strings = scan.nextInt();
        scan.nextLine();
        String arr[] = new String[strings];
        for(int i=0;i<strings;i++){
            arr[i] = scan.nextLine();
        }
        
        String part1 = "";
        String part2 = "";
        for(int i=0;i<strings;i++){
            part1 = "";
            part2 = "";
            breakString(arr[i], part1, part2);
        }
    }
    
    private static void breakString(String input, String str1, String str2){
        for(int i=0;i<input.length();i++){
            if(i%2 == 0){
                str1 += input.charAt(i);
            }else{
                str2 += input.charAt(i);
            }
        }
        System.out.print(str1 +" "+str2);
        System.out.println();
    }
}