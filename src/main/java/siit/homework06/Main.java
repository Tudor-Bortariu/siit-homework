package siit.homework06;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Please insert the equation:");
        Scanner keyboard = new Scanner(System.in);
        String input = keyboard.nextLine();

        System.out.println("Please insert unit measure for output:");
        String unitMeasure = keyboard.next();

        Calculator calculator = new Calculator();
        calculator.calculate(input, unitMeasure);
    }
}
