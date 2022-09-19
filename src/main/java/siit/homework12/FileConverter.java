package siit.homework12;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileConverter {
    /**
     * In this method I created a stream with all the lines read from the target input file using the Files.readAllLines method.
     * I filtered the results by target birthday month and split the result by comma in order to find the first and last name.
     * With these two I instantiate a Person object for each entry and sort them using the Name Comparator.
     * After sorting them I use the BufferedWriter to write each Person object from the stream to a newly created file.
     * @param inputFileName is the name of the file you want to read from.
     * @param targetMonth is the birthday month you want to filter by.
     * @param outputFileName is the name of the file you want to write to.
     */
    public void fileConverter(String inputFileName, int targetMonth, String outputFileName){
        if(targetMonth > 12){
            throw new IllegalArgumentException("Target month cannot be bigger than 12.");
        }

        Path path = Path.of(".\\src\\main\\resources\\homework12.Files\\" + inputFileName);

        try(BufferedWriter out = new BufferedWriter(new FileWriter(outputFileName))){
            Files.readAllLines(path).stream()
                    .filter(entry -> dateFilter(entry, targetMonth))
                    .map(line -> line.split(","))
                    .map(entry -> new Person(entry[0], entry[1]))
                    .sorted(new NameComparator())
                    .forEach(person -> {
                        try {
                            out.write(person.toString());
                            out.newLine();
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    });
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean dateFilter (String line, int targetMonth){
        String[] entryArray = line.split("-");
        int getEntryMonth = Integer.parseInt(entryArray[1]);
        return targetMonth == getEntryMonth;
    }
}
