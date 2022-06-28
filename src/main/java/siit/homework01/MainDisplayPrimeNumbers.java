package siit.homework01;

public class MainDisplayPrimeNumbers {
    public static void checkIfPrime(int number) {
        int reminder;
        for (int i = 0; i <= number; i++) {
            reminder = 0;
            for (int j = 2; j < i; j++) {
                if (i % j == 0) {
                    reminder = 1;
                    break;
                }
            }
            if (i > 1 && reminder == 0){
                System.out.println(i);
            }
        }
    }
}
