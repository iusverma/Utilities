package uber.round1;

public class JavaNegativeNumber {
    public static void main(String args[]){
        int a = Integer.MIN_VALUE;
        int b = -a;

        System.out.println("a: " +a +" | b: " +b);
        
        /*
         * Output - a: -2147483648 | b: -2147483648
         * Reason -
                Java Integer can hold 2^32 - 1 values, at the range of [-2147483648, 2147483647],
                including those two numbers. Those two numbers are -2^31 for Integer.MIN_VALUE,
                and 2^31–1 for Integer.MAX_VALUE. When int b = -Integer.MIN_VALUE, which is supposed
                to be -(-2147483648), or +2147483648, however - note that this is greater than
                Integer.MAX_VALUE (2147483647), so your integer overflows. This is a special case
                where it overflows to the same number.

                To understand that numbers represented by Integer are circular:

                Integer.MIN_VALUE - 1 == 2147483647 (MAX_VALUE)
                Integer.MAX_VALUE + 1 == -2147483648 (MIN_VALUE)
                So: -Integer.MIN_VALUE = MAX_VALUE + 1 = MIN_VALUE
        */
        
        int c = -2147483646;
        int d = -c;

        System.out.println("c: " +c +" | d: " +d);
        // Output c: -2147483646 | d: 2147483646        
    }
}
