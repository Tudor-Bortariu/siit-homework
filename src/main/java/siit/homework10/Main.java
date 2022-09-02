package siit.homework10;

public class Main {

    public static void main(String[] args) {
        String filePath = ".\\src\\main\\resources\\homework10.Files\\biathlonResults.csv";
            BiathlonFinalResults.printFinalResults(BiathlonFinalResults.getFinalResults(filePath));
    }
}
