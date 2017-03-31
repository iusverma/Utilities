package daily.practice.test.strings;

import daily.practice.impl.strings.StringParse2;

public class StringParse2Test {

        public static void main(String args[]){
            String input1 = "(())";
            String input2 = "(())))(";
            String input3 = "))";

            StringParse2 sol = new StringParse2();
            System.out.println("Center point for "+ input1 +"is: " +sol.solution(input1));
            System.out.println("Center point for "+ input2 +"is: " +sol.solution(input2));
            System.out.println("Center point for "+ input3 +"is: " +sol.solution(input3));
        }
}
