package siit.homework01;

import java.util.Scanner;

public class MaxDigitFromNumber {
    public static void main(String[] args) {

        Scanner keyboard = new Scanner(System.in);
        System.out.println("Enter number");

        int number = keyboard.nextInt();
        int largest = 0;

        largest = MainMaxDigitFromNumber.getLargestDigit(number, largest);
        System.out.println("The largest figure in your number is " + largest);
    }
}
