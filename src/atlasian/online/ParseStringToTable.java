package atlasian.online;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.StringTokenizer;

public class ParseStringToTable {
    private static HashMap<String, ArrayList<String>> dataMap = new HashMap<>();

    private static void parseString(String str){
        System.out.println("Parsing: "+str);
        String arr1[] = str.split("'|'");
        System.out.println("Total number of rows: "+arr1.length);
        for(int i=0;i<arr1.length;i++){
            System.out.println("Sub Parsing: "+arr1[i]);
            String arr2[] = arr1[i].split(":");
            System.out.println("Number of columns in row " +i +": "+arr2.length);
            for(int j=0;j<arr2.length;j++){
                System.out.print(arr2[j] + " ");                
            }
        }
    }
    
    private static void parseString1(String str){
        int numberOfHeaders = 0;
        int numberOfMaxCol = 0;
        boolean first = true;

        System.out.println("Parsing: "+str);
        StringTokenizer str1 = new StringTokenizer(str, "|");
        System.out.println("Total number of rows: "+str1.countTokens());
        int count = 1;
        while(str1.hasMoreTokens()){
            ArrayList<String> data = new ArrayList<>();
            String tstr1 = str1.nextToken();
            System.out.println(tstr1);            
            StringTokenizer str2 = new StringTokenizer(tstr1, ":");
            System.out.println("Total number of rows: "+str2.countTokens());
            if(first){
                numberOfHeaders = str2.countTokens();
                dataMap.put("header", data);
            }else{
                dataMap.put("col_"+Integer.toString(count), data);
            }
            if(str2.countTokens()>numberOfMaxCol){
                numberOfMaxCol = str2.countTokens();
            }
            while(str2.hasMoreTokens()){
                String tstr2 = str2.nextToken();
                System.out.println(tstr2);
                data.add(tstr2);
            }
            first = false;
            count++;
        }
        System.out.println("Number of headers: " +numberOfHeaders);
        System.out.println("Max number of columns: " +numberOfMaxCol);
        if(numberOfMaxCol>numberOfHeaders){
            settleHeaders(numberOfMaxCol, numberOfHeaders);
        }
        for(Entry<String, ArrayList<String>> e: dataMap.entrySet()){
            System.out.print(e.getKey() +":"+e.getValue().toString());
            System.out.println();
        }
    }
    
    private static void settleHeaders(int numberOfMaxCol, int numberOfHeaders){
        int diff = numberOfMaxCol - numberOfHeaders;
        ArrayList<String> headers = dataMap.get("header");
        String lastCol = headers.get(headers.size()-1);
        for(int i=1;i<=diff;i++){
            String newColHeader = lastCol+"+"+Integer.toString(i);
            headers.add(newColHeader);
        }
                
    }
    
    public static void main(String args[]){
        //parseString("head1:head2:head3|R1C1:R1C2:R1C3|R2C1:R2C2:R2C3:R2C4");
        parseString1("head1:head2|R1C1:R1C2:R1C3|R2C1:R2C2:R2C3:R2C4");
    }
}
