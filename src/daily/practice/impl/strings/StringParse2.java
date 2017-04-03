package daily.practice.impl.strings;

public class StringParse2 {
    private int centerPoint;

    private void init() {
        centerPoint = -1;
    }

    public int solution(String S) {
        // write your code in Java SE 8
        // Step 1: Find the center point
        init();
        int length = S.length();
        int midPoint = length / 2;
        if (length % 2 == 1) {
            midPoint++;
        }

        // Step 2: Find opening bracket to left of center and closing bracket to
        // center
        test(S, midPoint);

        return centerPoint;
    }

    private void test(String S, int midPoint) {
        int length = S.length();
        String firstHalf = S.substring(0, midPoint);
        String secondHalf = S.substring(midPoint, length);
        System.out.println("String: " + S);
        System.out.println("firstHalf: " + firstHalf);
        System.out.println("secondHalf: " + secondHalf);
        int openBracketCount = countOccurence(firstHalf, '(');
        int closeBracketCount = countOccurence(secondHalf, ')');
        if (openBracketCount == closeBracketCount) {
            centerPoint = midPoint;
            return;
        } else if (openBracketCount > closeBracketCount) {
            midPoint--;
        } else {
            midPoint++;
        }
        test(S, midPoint);
    }

    private int countOccurence(String str, char ch) {
        int counter = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ch) {
                counter++;
            }
        }
        return counter;
    }
}
