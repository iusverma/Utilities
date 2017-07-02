package daily.practice.impl.misc;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Temp {

	private static String covertIntToDate(int x){
		x = x -4;
    	if(x == 0){
    		return "SUNDAY";
    	}
    	if(x == 1){
    		return "MONNDAY";
    	}
    	if(x == 2){
    		return "TUESDAY";
    	}
    	if(x == 3){
    		return "WEDNESDAY";
    	}
    	if(x == 4){
    		return "THRUSDAY";
    	}
    	if(x == 5){
    		return "FRIDAY";
    	}
    	if(x == 6){
    		return "SATURDAY";
    	}
    	return "";
    }

	    public static void main(String[] args) {
	        Scanner in = new Scanner(System.in);
	        String month = in.next();
	        String day = in.next();
	        String year = in.next();
	        
	        int syear = Integer.parseInt(year) - 1900;
	        
	        Calendar cal = Calendar.getInstance();
	        cal.setTime(new Date(syear,Integer.parseInt(month),Integer.parseInt(day)));
	        System.out.println(cal.toString());
	        int x = cal.get(Calendar.DAY_OF_WEEK);
	        System.out.println(covertIntToDate(x));
	    
	    }
	    
	}
