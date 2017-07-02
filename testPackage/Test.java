//package testPackage;
//import other.*;
class Other { static String hello = "Hello"; }

public class Test
{
   public static void main(String[] args)
   {
      String hello = "Hello", lo = "lo";
      System.out.print((Other.hello == hello) + " ");   //line 1  // true
      System.out.print((Other.hello == hello) + " ");   //line 2  // true
      System.out.print((hello == ("Hel"+"lo")) + " ");           //line 3  // true
      System.out.println("==>>Hel"+lo+"<<<===");
      System.out.println(hello);
      System.out.print((hello == ("Hel"+lo)) + " ");             //line 4  // false
      System.out.println(hello == ("Hel"+lo).intern());          //line 5  // true
   }
}
 
