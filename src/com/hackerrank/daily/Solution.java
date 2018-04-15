package com.hackerrank.daily;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

/*
 validates a xml/html line and print valid text between matching tags
 tags should match in exact sequence, i.e. if there are nested tags, only the inner most tag's content is valid
 
Sample Input
============
4
<h1>Nayeem loves counseling</h1>
<h1><h1>Sanjay has no watch</h1></h1><par>So wait for a while</par>
<Amee>safat codes like a ninja</amee>
<SA premium>Imtiaz has a secret crush</SA premium>

Sample Output
=============
Nayeem loves counseling
Sanjay has no watch
So wait for a while
None
 */
public class Solution {
	
	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
        int testCases = Integer.parseInt(scan.nextLine());
        
        while (testCases-- > 0) {
            String line = scan.nextLine();
            
            boolean matchFound = false;
            Pattern r = Pattern.compile("<(.+)>([^<]+)</\\1>");
            /**
            Regular Expression Explanation
            <(.+)>  matches HTML start tags. The parentheses save the contents inside the brackets into Group #1.
            ([^<]+) matches all the text in between the HTML start and end tags. A special restriction is placed 
            		    on the text in that it can't have the "<" symbol. The characters inside the parenthesis are saved into Group #2.
            </\\1>  is to match the HTML end brace that corresponds to our previous start brace. The \1 is here to match all text from Group #1.
             */
            Matcher m = r.matcher(line);

            while (m.find()) {
                System.out.println(m.group(2));
                matchFound = true;
            }
            if ( ! matchFound) {
                System.out.println("None");
            }
        }
        scan.close();
	}

}
