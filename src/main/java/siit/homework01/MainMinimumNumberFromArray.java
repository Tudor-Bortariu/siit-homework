package siit.homework01;

import java.util.Random;

public class MainMinimumNumberFromArray {

    public static int[] randomArray() {
        Random randomizer = new Random();
        int[] numbers = new int[5];

        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = randomizer.nextInt(1000);
            System.out.println(numbers[i]);
        }
        return numbers;
    }
    public static int getMin(int[] numbers, int min) {
        for (int number : numbers) {
            min = Math.min(number, min);
        }
        return min;
    }
}
