package siit.homework02;

public class BubbleSortMethod {

    /**
     * This is the bubble sort function. At the beginning of the while, it assigns a boolean variable to false in order for the
     * if function to start and proceed with the loop. The loop compares the number at position i with the number at position i+1
     * and it swaps them if the condition is met. The loop will stop only when it has nothing to swap. The swap is done using the
     * temporary variable.
     * @param numbers represents an array of objects from the SalesRepresentatives class.
     */
    public static void sortSalesValues(SalesRepresentatives[] numbers) {
        boolean swap = true;

        while (swap) {

            swap = false;
            for (int i = 0; i < numbers.length - 1; i++) {
                if (numbers[i].getSalesValue() < numbers[i + 1].getSalesValue()) {
                    swap = true;
                    SalesRepresentatives temporary = numbers[i];
                    numbers[i] = numbers[i + 1];
                    numbers[i + 1] = temporary;
                }
            }
        }
    }
}
