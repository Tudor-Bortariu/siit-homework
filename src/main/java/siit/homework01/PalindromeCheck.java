package siit.homework01;

import java.util.Scanner;

public class PalindromeCheck {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Enter number");

        int n = keyboard.nextInt();
        int m = 0;

        m = MainPalindromeCheck.getReversedNumber(n, m);

        MainPalindromeCheck.compareNumbers(m, n);
    }
}
