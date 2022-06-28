package siit.homework01;

public class MinimumNumberFromArray {
    public static void main(String[] args) {

        int[] numbers = MainMinimumNumberFromArray.randomArray();

        int min = numbers[0];

        min = MainMinimumNumberFromArray.getMin(numbers, min);
        System.out.println("The smallest number is " + min);
    }
}