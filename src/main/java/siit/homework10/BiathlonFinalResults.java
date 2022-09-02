package siit.homework10;

import java.util.*;

public class BiathlonFinalResults {

    /**
     * In this method I instantiated a list of athletes. I create a loop to add as many athletes to the list, as there are
     * lines in the file parsed. Because each line in the file represents a result for an athlete. I use the methods created
     * in the FileReader class to build the instances of Athlete object to be added to the list. After all the athletes are
     * added to the list I create a stream on that list and sort them by total time.
     * @param filePath is the path of the file you want to be read by the file parser and return its lines in a List.
     * @return Returns a list of athletes sorted by their total time from the competition.
     */
    public static List<Athlete> getFinalResults(String filePath){
        List<Athlete> athletesResults = new ArrayList<>();

        for (int i = 0; i < BiathlonResultsFileReader.athletesResultsReader(filePath).size(); i++) {
                athletesResults.add(new Athlete(BiathlonResultsFileReader.getAthletesNumbers(filePath).get(i), BiathlonResultsFileReader.getAthletesNames(filePath).get(i),
                        BiathlonResultsFileReader.getAthletesCountry(filePath).get(i), BiathlonResultsFileReader.computeFinalTimeResult(filePath).get(i)));
            }
        return athletesResults.stream()
                .sorted(Comparator.comparing(Athlete::getTotalTime))
                .toList();
    }

    /**
     * This method checks the size of the list of athletes. If the list is bigger than 3, it prints just the first 3 places.
     * If the list is smaller than 3 it prints whatever there is in the list.
     * @param finalResults is the list of final results computed from the file parser.
     */
    public static void printFinalResults(List<Athlete> finalResults) {
        if (finalResults.size() > 2) {
            for (int i = 0; i < 3; i++) {
                System.out.println("Place " + (i + 1) + ". Athlete name: " + finalResults.get(i).getName() + " - " + finalResults.get(i).getConvertedTime());
            }
        }else{
            for (int i = 0; i < finalResults.size(); i++) {
                System.out.println("Place " + (i + 1) + ". Athlete name: " + finalResults.get(i).getName() + " - " + finalResults.get(i).getConvertedTime());
            }
        }
    }

}
