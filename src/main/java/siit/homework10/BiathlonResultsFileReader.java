package siit.homework10;

import java.io.BufferedReader;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalTime;
import java.util.*;

public class BiathlonResultsFileReader {
    /**
     * I created a buffered reader for the CSV file to read every line of the file and add each line as String to an array list.
     * After the List is created I map that List of Strings to a List of String Arrays by splitting each line by comma in order to
     * better separate the information from the file.
     * @param filePath is the path of the CSV file you want to be read.
     * @return Returns a List of Strings in which each element is a line from the CSV file given as argument.
     */
    public static List<String[]> athletesResultsReader(String filePath) {
        List<String> resultsRead = new ArrayList<>();
        try (BufferedReader in = new BufferedReader(new java.io.FileReader(filePath))) {
            String line;
            while ((line = in.readLine()) != null) {
                if (line.split(",").length < 7){
                    throw new InvalidPropertiesFormatException("Check file entries have comma after each column entry");
                }
                resultsRead.add(line);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return resultsRead.stream()
                .map(line -> line.split(","))
                .toList();
    }

    /**
     * In this method I create a stream from the List of String Arrays returned by the file parser. Then I use flat map
     * to get the results as simple elements of a list not as arrays. I filter them using a regex string in order to find
     * just the names of the athletes, and I return those names in a list.
     * @param filePath is the path of the file you want to be read by the file parser and return its lines in a List.
     * @return Returns a list containing all the names of the athletes who participated.
     */
    public static List<String> getAthletesNames(String filePath) {
        return athletesResultsReader(filePath).stream()
                .flatMap(Arrays::stream)
                .filter(string -> string.matches("[a-zA-Z]+\\s+[a-zA-Z]*"))
                .toList();
    }

    /**
     * In this method I create a stream from the List of String Arrays returned by the file parser. Then I use flat map
     * to get the results as simple elements of a list not as arrays. I filter them using a regex string in order to find
     * just the competition numbers of the athletes, parse the string into an Integer and return those numbers in a list.
     * @param filePath is the path of the file you want to be read by the file parser and return its lines in a List.
     * @return Returns a list containing all the numbers of the athletes who participated.
     */
    public static List<Integer> getAthletesNumbers(String filePath) throws NumberFormatException{
        return athletesResultsReader(filePath).stream()
                .flatMap(Arrays::stream)
                .filter(string -> string.matches("\\d+\\z"))
                .map(Integer::parseInt)
                .toList();
    }

    /**
     * In this method I create a stream from the List of String Arrays returned by the file parser. I filter them using a regex string in order to find
     * just the country code of the athletes, and I return those codes in a list.
     * @param filePath is the path of the file you want to be read by the file parser and return its lines in a List.
     * @return Returns a list containing all the country codes of the athletes who participated.
     */
    public static List<String> getAthletesCountry(String filePath) {
        return athletesResultsReader(filePath).stream()
                .flatMap(Arrays::stream)
                .filter(string -> string.matches("[a-zA-Z]{1,3}"))
                .toList();
    }

    /**
     * In this method I instantiate a list to contain total penalties for each athlete. I iterate through each array from
     * the file parser. Each array is a line here, and each line is an athlete's result from the competition. I instantiate
     * an int to store total values of penalties in it. Then I iterate through each element of each array and get only the
     * results from the shooting range. For each result I use the computeShootingPenalty method to calculate penalties and
     * increment by 10 the variable for each miss. After the whole line was read, I add the penalty variable to the List.
     * At the end I return the list with each penalty.
     * @param filePath is the path of the file you want to be read by the file parser and return its lines in a List.
     * @return returns a list with penalties from shooting range for each athlete.
     */
    public static List<Integer> getAthletesPenalties(String filePath) {
        List<Integer> totalPenalties = new ArrayList<>();

        for (String[] entryArray : athletesResultsReader(filePath)) {
            int penalty = 0;
            for (String elementInArray : entryArray) {
                if(elementInArray.matches("[xoXO]{5}")){
                    penalty += computeShootingPenalty(elementInArray);
                }
            }
            totalPenalties.add(penalty);
        }
        return totalPenalties;
    }

    /**
     * This method transforms a string to a char array and iterate through it to find the character "o". For each character
     * found the method increments a variable by 10 and returns the Integer variable at the end.
     * @param score is the string result you want to check and compute the penalties.
     * @return Returns the value of penalties as Integer.
     */
    public static Integer computeShootingPenalty(String score){
        int shootingPenalty = 0;
        char [] arrayScore = score.toCharArray();
        for (char c : arrayScore) {
            if(c == 'o'){
                shootingPenalty += 10;
            }
        }
        return shootingPenalty;
    }

    /**
     * In this method I create a stream from the List of String Arrays returned by the file parser. I filter them using a regex string in order to find
     * just the ski time obtained by the athletes. I map those results by adding "00:" at the beginning to have the agreed format
     * to parse the string to a Local Time variable. I then use that variable to create a duration variable from 0 to the local time computed previously.
     * Then I return that list of duration variables.
     * @param filePath is the path of the file you want to be read by the file parser and return its lines in a List.
     * @return Returns a list containing all the parsed ski times to duration.
     */
    public static List<Duration> getSkiTimeResult(String filePath){
        return athletesResultsReader(filePath).stream()
                .flatMap(Arrays::stream)
                .filter(string -> string.matches("\\d+:\\d+"))
                .map(timeResult -> "00:" + timeResult)
                .map(LocalTime::parse)
                .map(localTime -> Duration.between(LocalTime.MIN, localTime))
                .toList();
    }

    /**
     * In this method I create a list to store all the final time results after I added the penalties. I used the method
     * to get the ski time results and iterated through each element of the list and added the corresponding penalty in seconds
     * to each element. I get those penalties from the list returned by the getAthletesPenalties method. Then I return the updated
     * List of duration.
     * @param filePath is the path of the file you want to be read by the file parser and return its lines in a List.
     * @return Returns a list containing all the updated times after adding the penalties.
     */
    public static List<Duration> computeFinalTimeResult(String filePath){
        List<Duration> timeResults = new ArrayList<>();

        for (int i = 0; i < getSkiTimeResult(filePath).size(); i++) {
            timeResults.add(getSkiTimeResult(filePath).get(i).plusSeconds(getAthletesPenalties(filePath).get(i)));
        }
        return timeResults;
    }
}