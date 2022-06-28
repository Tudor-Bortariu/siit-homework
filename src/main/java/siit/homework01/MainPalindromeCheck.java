package siit.homework01;

public class MainPalindromeCheck {
    public static int getReversedNumber(int n, int m) {
        int reminder;
        while (n > 0){
            reminder = n % 10;
            m = m + reminder;
            n = n / 10;
            m = m * 10;
        }
        m = m / 10;
        return m;
    }

    public static void compareNumbers(int m, int nCompare) {
        if (m == nCompare){
            System.out.println("The number is a palindrome.");
        }else{
            System.out.println("The number is not a palindrome.");
        }
    }
}