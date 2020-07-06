package interviews;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;



class Result {

    /*
     * Complete the 'closestStraightCity' function below.
     *
     * The function is expected to return a STRING_ARRAY.
     * The function accepts following parameters:
     *  1. STRING_ARRAY c
     *  2. INTEGER_ARRAY x
     *  3. INTEGER_ARRAY y
     *  4. STRING_ARRAY q
     */

    public static List<String> closestStraightCity(List<String> c, List<Integer> x, List<Integer> y, List<String> q) {
        int nearestCity = -1;
        List<String> results = new ArrayList<>();
        for(int o=0;o<q.size();o++){
            int cityNameLoc = c.lastIndexOf(q.get(o));
            int xLoc = x.get(cityNameLoc);
            int yLoc = y.get(cityNameLoc);
            int min = 99999;
            /* Check for matching x */
            for(int i=0;i<x.size();i++){
                if(i!=cityNameLoc && x.get(i) == xLoc){
                    int temp = java.lang.Math.abs(y.get(i) - yLoc);
                    if(temp < min){
                        min = i;
                    } 
                }
            }
            /* Check for matching y */
            for (int i = 0; i < y.size(); i++) {
                if (i != cityNameLoc && y.get(i) == yLoc) {
                    int temp = java.lang.Math.abs(x.get(i) - xLoc);
                    if (temp < min) {
                        min = i;
                    }
                }
            }
            if (nearestCity == -1) {
                results.add("NONE");
            }
            results.add(c.get(nearestCity));
        }       
        return results;
    }

}

public class Sample2 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int cCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<String> c = new ArrayList<>();

        for (int i = 0; i < cCount; i++) {
            String cItem = bufferedReader.readLine();
            c.add(cItem);
        }

        int xCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> x = new ArrayList<>();

        for (int i = 0; i < xCount; i++) {
            int xItem = Integer.parseInt(bufferedReader.readLine().trim());
            x.add(xItem);
        }

        int yCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> y = new ArrayList<>();

        for (int i = 0; i < yCount; i++) {
            int yItem = Integer.parseInt(bufferedReader.readLine().trim());
            y.add(yItem);
        }

        int qCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<String> q = new ArrayList<>();

        for (int i = 0; i < qCount; i++) {
            String qItem = bufferedReader.readLine();
            q.add(qItem);
        }

        List<String> result = Result.closestStraightCity(c, x, y, q);

        for (int i = 0; i < result.size(); i++) {
            bufferedWriter.write(result.get(i));

            if (i != result.size() - 1) {
                bufferedWriter.write("\n");
            }
        }

        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
