package daily.practice.java8.hashmap;

import java.util.HashMap;

public class HashMapTest {
    public static void main(String[] args) {
        HashMap<Student, String> hashMap = new HashMap<>();
         
        String s1 = "s";
         
        /*We are stating from index 10 to make sure that 
        hashCode values of Student object remains same
        and we get them in same bucket in HashMap */
        for(int i=10;i<15;i++)
        {
            Student s = new Student(201701,s1+i);
            hashMap.put(s, s.getStudentName());
        }
         
        System.out.println(hashMap);
        
        for(int i=15;i<20;i++)
        {
            Student s = new Student(201701,s1+i);
            hashMap.put(s, s.getStudentName());
        }
        System.out.println(hashMap);
    }
}
