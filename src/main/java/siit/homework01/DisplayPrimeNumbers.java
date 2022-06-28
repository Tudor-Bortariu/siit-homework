package siit.homework01;

import java.util.Scanner;

public class DisplayPrimeNumbers {
    public static void main(String[] args) {

        Scanner keyboard = new Scanner(System.in);
        System.out.println("Enter number");

        int number = keyboard.nextInt();

        MainDisplayPrimeNumbers.checkIfPrime(number);
    }
}