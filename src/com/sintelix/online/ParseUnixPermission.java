package com.sintelix.online;

// covert read write execute
public class ParseUnixPermission {

	public static int symbolicToOctal(String permString) {
		String permission = "";
        if(permString.length()%3!=0)
        	return -1;
        for(int i=0;i<permString.length();i=i+3) {
        	int num = 0;
        	String perm = permString.substring(i, (i+3));
        	//System.out.println(perm);
        	for(int j=0;j<3;j++) {
        		if(perm.charAt(j)=='r') {
        			num+=4;
        		}else if(perm.charAt(j)=='w') {
        			num+=2;
        		}else if(perm.charAt(j)=='x') {
        			num+=1;
        		}else {
        			// do nothing;
        		}
        	}
        	if(num>=0) {
        		permission+=num;
        	}
        }
        return Integer.parseInt(permission);
    }

    public static void main(String[] args) {
        // Should write 752
        System.out.println(ParseUnixPermission.symbolicToOctal("rwxr-x-w-"));
    }

}
