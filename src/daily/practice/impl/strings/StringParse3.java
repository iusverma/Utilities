package daily.practice.impl.strings;

import java.util.ArrayList;
import java.util.List;

/**
 * Findind longest password with no digit and at least one Uppercase character
 * @author ayverma
 *
 */
public class StringParse3 {
    List<String> listOfPossiblePassords = null;
    String longestPassword = "";

    public void init(){
        listOfPossiblePassords = new ArrayList<>();
        longestPassword = "";
    }

    public int solution(String S) {
        init();
        for(int i=0;i<S.length();i++){
            for(int j=i;j<=S.length();j++){
                String tempStr = S.substring(i,j);
                if(!hasDigit(tempStr) && hasUpperCaseCharacter(tempStr)){
                    listOfPossiblePassords.add(tempStr);
                    if(longestPassword.length()<tempStr.length()){
                        longestPassword = tempStr;
                    }
                }
            }
        }
        if(listOfPossiblePassords.size() > 0){
            System.out.println("Possible Passwords: "+listOfPossiblePassords.size());
            System.out.println("Longest Password: "+longestPassword);
            System.out.println("Length of longest Password: "+longestPassword.length());
        }else{
            System.out.println("No valid password found in "+S);
        }
        return -1;
    }
    
    private boolean hasDigit(String str){
        for(int i=0;i<str.length();i++){
            if(Character.isDigit(str.charAt(i))){
                return true;
            }
        }
        return false;
    }
    
    private boolean hasUpperCaseCharacter(String str){
        for(int i=0;i<str.length();i++){
            if(Character.isUpperCase(str.charAt(i))){
                return true;
            }
        }
        return false;
    }
}
