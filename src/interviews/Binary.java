package interviews;

//import java.lang.String;
import java.util.Scanner;

class Binary{
    public static void main(String args[]){
        Scanner scan = new Scanner(System.in);
        int num = scan.nextInt();
        System.out.println("You entered:" +num);
        String binary = "";
        while(num>0){
            binary += num%2;
            num = num/2;
        }
        System.out.println("Binary of"+num+" in reverse order is:"+binary);
        String longestOnes = "";
        String temp = "";
        for(int i=0;i<binary.length();i++){
            //String temp = "";
            char pos = binary.charAt(i);
            if(pos == '1'){
                temp += pos; 
            }else{
                temp="";
            }
            if(longestOnes.length() < temp.length()){
                longestOnes = temp;
            }
        }
        System.out.println("Longest sequence of 1 is: " +longestOnes);
        scan.close();
    }
}
