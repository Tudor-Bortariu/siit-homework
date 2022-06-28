package siit.homework01;

public class MainMaxDigitFromNumber {

    public static int getLargestDigit(int number, int largest) {
        int reminder;
        while (number > 0){
            reminder = number % 10;

            if (largest < reminder){
                largest = reminder;
            }
            number = number /10;
        }
        return largest;
    }
}
