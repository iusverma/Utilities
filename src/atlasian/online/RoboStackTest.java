package atlasian.online;

import java.util.Scanner;

public class RoboStackTest {
    
    public static String solution(String input){
        int arr[] = {0,0,0,0,0,0,0,0,0,0};
        boolean dataPresent = false;
        int pos = 0;
        for(int i=0;i<input.length();i++){
            String s = input.substring(i, i+1);
            if(s.equalsIgnoreCase("P") || 
                    s.equalsIgnoreCase("L") ||
                    s.equalsIgnoreCase("M") ){
                if(s.equalsIgnoreCase("P")){
                    dataPresent  = true;
                    pos = 0;
                }else if(s.equalsIgnoreCase("M") ){
                    if(pos<10){
                        pos++;
                    }
                }else if(s.equalsIgnoreCase("L") ){
                    if(dataPresent && arr[pos]<15){
                        arr[pos]++;
                        dataPresent = false;
                    }else{
                        
                    }
                }
            }
        }
        
        return convertArrToString(arr);
    }
    
    private static String convertArrToString(int arr[]){
        String result = "";
        System.out.print("Array final condition: ");
        for(int i =0;i<arr.length;i++){
            if(arr[i] == 10){
                result += "A";
            }else if(arr[i] == 11){
                result += "B";
            }else if(arr[i] == 12){
                result += "C";
            }else if(arr[i] == 13){
                result += "D";
            }else if(arr[i] == 14){
                result += "E";
            }else if(arr[i] == 15){
                result += "F";
            }else{
                result += arr[i];
            }
        }
        return result;
    }
    
    public static void main(String args[]){
        Scanner scan = new Scanner(System.in);
        //Enter following two inputs in command line
        //PMLPMMMLPMLPMML
        //PLPLPLPLPLPLPLPLPLPL
        String input1 = scan.nextLine();
        String input2 = scan.nextLine();
        System.out.println(solution(input1));
        System.out.println(solution(input2));
    }
}
