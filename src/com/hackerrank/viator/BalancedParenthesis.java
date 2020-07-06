package com.hackerrank.viator;

import java.util.Stack;

/**
 * Need to find out if in a give string all the parenthesis/brackets are closed
 *
 */
public class BalancedParenthesis {
	
    // Complete the braces function below.
    static String[] braces(String[] values) {
        String [] result = new String[values.length];
        for(int i=0;i<values.length;i++){
            result[i] = isBalancedString(values[i])?"YES":"NO";
        }
        return result;
    }

    private static boolean isClosingPair(Stack<Character> stk, char c) {
	char lastCharacter = stk.pop();
	if((lastCharacter == '[' && c == ']')
			|| (lastCharacter == '{' && c == '}')
			|| (lastCharacter == '(' && c == ')') ) {
		return true;
	}
	return false;
    }
	
    private static boolean isBalancedString(String str) {
	Stack<Character> stk = new Stack<>();
	if(str==null || str.isEmpty() ) {
		return true;
	}
        if(str.length()%2==1)
            return false;
	for(int i=0;i<str.length();i++) {
		char c = str.charAt(i);
		if( c== '['	|| c == '{' || c == '(') {
			stk.push(c);
		}else if(c == ']' || c == '}' || c == ')') {
			if(stk.size()==0)
	    			return false;
			if(!isClosingPair(stk, c))
				return false;
		}else {
			return false;
		}
	}
	return true;
    }

	public static void main(String...a) {
		System.out.println("!@#!@#2 is balanced: "+isBalancedString("!@#!@#2"));
		System.out.println("{}[]() is balanced: "+isBalancedString("{}[]()"));
		System.out.println("[{()}] is balanced: "+isBalancedString("[{()}]"));
		System.out.println("[{]}([{)}] is balanced: "+isBalancedString("[{]}([{)}]"));
	}
}
