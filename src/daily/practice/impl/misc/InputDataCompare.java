package daily.practice.impl.misc;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class InputDataCompare {

    private static List<Integer> targetList = new ArrayList<>();
    private static List<Integer> searchList = new ArrayList<>();
    private static List<Integer> unfoundList = new ArrayList<>();
    private static List<Integer> foundList = new ArrayList<>();
    private static String TARGET_LIST = "/input/b.1.txt";
    private static String SEARCH_LIST = "/input/a.1.txt";
    private static BufferedReader br = null;
    private static FileReader fr = null;
    
    static private void populateData() {
        
        try {
            String path = Paths.get(".").toAbsolutePath().normalize().toString();
            System.out.println("[FileInputReader] Absolute Path: " + path);
            File params = new File(path, TARGET_LIST);
            fr = new FileReader(params);
            br = new BufferedReader(fr);
            if (br != null) {
                String sCurrentLine;
                while ((sCurrentLine = br.readLine()) != null) {
                    targetList.add(new Integer(sCurrentLine));
                }
            }

            File sparams = new File(path, SEARCH_LIST);
            fr = new FileReader(sparams);
            br = new BufferedReader(fr);
            if (br != null) {
                String sCurrentLine;
                while ((sCurrentLine = br.readLine()) != null) {
                    searchList.add(new Integer(sCurrentLine));
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("[FileInputReader] " + e.getMessage());
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("[FileInputReader.getData] " + e.getMessage());
            e.printStackTrace();
        } finally {
            try {
                if (br != null)
                    br.close();
                if (fr != null)
                    fr.close();
            } catch (IOException ex) {
                System.out.println("[FileInputReader.getData] " + ex.getMessage());
                ex.printStackTrace();
            }
        }
    }
    
    public static void searchData(){
        for(Integer i: searchList){
            if(targetList.contains(i)){
                foundList.add(i);
            }else{
                unfoundList.add(i);
            }
        }
    }
    
    public static void main(String args[]){
        populateData();
//        for(Integer i: targetList){
//            System.out.println(i);
//        }
//        System.out.println("++++++++++++++++");
//        for(Integer i: searchList){
//            System.out.println(i);
//        }
        searchData();
        System.out.println("++++++++++++++++");
        System.out.println("Following items not found in the target list");
        for(Integer i: unfoundList){
            
            System.out.println(i);
        }
        System.out.println("++++++++++++++++");
        System.out.println("Following items found in the target list");
        for(Integer i: foundList){
            
            System.out.println(i);
        }
    }
}
