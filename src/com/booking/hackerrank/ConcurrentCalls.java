package com.booking.hackerrank;

import java.io.*;
import java.util.*;
/*
Check if following can be used
import java.text.*;
import java.math.*;
import java.util.regex.*;
*/

/*
Input
1
3
2
1481122000 1481122020
1481122000 1481122040
1481122030 1481122035

Output
1

Note:- Following solution taking long time in executing
 */
public class ConcurrentCalls {
    /*
     * Complete the function below.
     */
    static int howManyAgentsToAdd(int noOfCurrentAgents, int[][] callsTimes) {
        if(callsTimes.length==0)
            return 0;

        int concurrentCalls = getConcurrentCalls(callsTimes);
        if(concurrentCalls>noOfCurrentAgents)
            return (concurrentCalls - noOfCurrentAgents);
        else
            return 0;
    }

    static int getConcurrentCalls(int[][] callsTimes){
        int concurrentCalls = 0;
        int numOfRecs = callsTimes.length;
        for(int i=0;i<numOfRecs-1;i++){
            int callStart = callsTimes[i][0];
            int callEnd = callsTimes[i][1];
            for(int j=i+1;j<numOfRecs;j++){
                int otherCallStarts = callsTimes[j][0];
                int otherCallEnds = callsTimes[j][1];
                System.out.println("comparing");
                System.out.println(callStart+":"+callEnd);
                System.out.println(otherCallStarts+":"+otherCallEnds);
                if(otherCallStarts >=callStart && otherCallStarts <= callEnd) {
                    concurrentCalls++;
                }
            }
        }
        return concurrentCalls;
    }


    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        final String fileName = System.getenv("OUTPUT_PATH");
        BufferedWriter bw = null;
        if (fileName != null) {
            bw = new BufferedWriter(new FileWriter(fileName));
        }
        else {
            bw = new BufferedWriter(new OutputStreamWriter(System.out));
        }

        int res;
        int noOfCurrentAgents;
        noOfCurrentAgents = Integer.parseInt(in.nextLine().trim());

        int callsTimes_rows = 0;
        int callsTimes_cols = 0;
        callsTimes_rows = Integer.parseInt(in.nextLine().trim());
        callsTimes_cols = Integer.parseInt(in.nextLine().trim());

        int[][] callsTimes = new int[callsTimes_rows][callsTimes_cols];
        for(int callsTimes_i = 0; callsTimes_i < callsTimes_rows; callsTimes_i++) {
            for(int callsTimes_j = 0; callsTimes_j < callsTimes_cols; callsTimes_j++) {
                callsTimes[callsTimes_i][callsTimes_j] = in.nextInt();

            }
        }

        if(in.hasNextLine()) {
          in.nextLine();
        }

        res = howManyAgentsToAdd(noOfCurrentAgents, callsTimes);
        bw.write(String.valueOf(res));
        bw.newLine();

        bw.close();
        in.close();
    }
}
