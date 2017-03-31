package daily.practice.impl.strings;

import java.util.ArrayList;
import java.util.List;

public class StringParse1 {
    List<String> listOfSubStrings = new ArrayList<>();
    List<String> listOfValidStrings = new ArrayList<>();
    List<String> listOfAllPossiblePasswordSubstrings = new ArrayList<>();
    List<String> listOfPasswords = new ArrayList<>();
    
    String substrwithoutDigit = "";
    public int solution(String S) {
     // write your code in Java SE 8
     // Step 1: Identify all substring which exist between digits
    listOfPasswords.clear();
     for(int i=0;i<S.length();i++){
         String str = S.substring(i, i+1);
         int num = -1;
         try{
            num = Integer.valueOf(str);
         }catch(NumberFormatException e){
             // this char is not an number
         }
         if(num >=0 && num <=9){
             // this is a number so need to break
             if(substrwithoutDigit.length()>0){
                 listOfSubStrings.add(substrwithoutDigit);
                 substrwithoutDigit = "";
             }
         }else{
             substrwithoutDigit += str;
         }
     }
     if(substrwithoutDigit.length()>0){
         listOfSubStrings.add(substrwithoutDigit);
         substrwithoutDigit = "";
     }
     System.out.println("listOfSubStrings");
     for(int i=0;i<listOfSubStrings.size();i++){
         System.out.println(i+": "+listOfSubStrings.get(i));
     }
     
     // Step 2: eliminate string which are not eligible or doesn't have an uppercase character
     listOfValidStrings = eliminateSubstringWithoutUppercaseCharacter(listOfSubStrings);
    
     // Step 3: generate all permutation for valid strings
     populatePasswordChoices();
     
     // Step 4: Return number of possible passwords
     System.out.println("Number of possible passwords in string: "+S +" are: "+listOfPasswords.size());
     if(listOfPasswords.size()>0){
         return listOfPasswords.size();
     }
     return -1;
    }
    
    private List<String> eliminateSubstringWithoutUppercaseCharacter(List<String> listOfStrings){
        List<String> list = new ArrayList<>();
        System.out.println("Array Length: "+listOfStrings.size());
        for(int i=0;i<listOfStrings.size();i++){
            boolean validString = false;
             String str = listOfStrings.get(i);
             for(int index=0;index<str.length();index++){
                 char substr = str.charAt(index);
                 if(Character.isUpperCase(substr)){
                     validString = true;
                 }
             }
             if(validString && !list.contains(str)){
                 list.add(str);
                 validString = false;
             }
         }
        System.out.println("listOfValidStrings");
        for(int i=0;i<list.size();i++){
             System.out.println(i+": "+list.get(i));
         }
        return list;
    }

    private void populatePasswordChoices(){
        for(int i=0;i<listOfValidStrings.size();i++){
            String str = listOfValidStrings.get(i);
            System.out.println("Parseing: "+str);
            for(int j=0;j<str.length();j++){
                for(int k=j+1;k<str.length();k++){
                    String pwd = str.substring(j, k);
                    System.out.println("substring:" +pwd);
                    if(!listOfAllPossiblePasswordSubstrings.contains(pwd)){
                        listOfAllPossiblePasswordSubstrings.add(pwd);
                    }
                }
            }
        }
        System.out.println("listOfAllPossiblePasswordSubstrings");
        for(int i=0;i<listOfAllPossiblePasswordSubstrings.size();i++){
            System.out.println(i+": "+listOfAllPossiblePasswordSubstrings.get(i));
        }
        listOfPasswords = eliminateSubstringWithoutUppercaseCharacter(listOfAllPossiblePasswordSubstrings);
        System.out.println("listOfPasswords");
        for(int i=0;i<listOfPasswords.size();i++){
            System.out.println(i+": "+listOfPasswords.get(i));
        }
    }
}
