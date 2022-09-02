package homework10.unitTesting;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import siit.homework10.ConvertTime;
import siit.homework10.BiathlonResultsFileReader;

import java.time.Duration;
import java.time.LocalTime;
import java.util.Arrays;

public class BiathlonResultsFileReaderTest {

    String filePath = ".\\src\\test\\resources\\homework10.testFiles\\biathlonTestResults.csv";

    @Test
    public void file_Line_Reader_Test() {
        String firstLine = "11,Umar Jorgson,SK,30:27,xxxox,xxxxx,xxoxo";
        String[] splitLine = firstLine.split(",");

        Assertions.assertEquals(5, BiathlonResultsFileReader.athletesResultsReader(filePath).size());
        Assertions.assertEquals(Arrays.toString(splitLine), Arrays.toString(BiathlonResultsFileReader.athletesResultsReader(filePath).get(0)));
    }

    @Test
    public void athletes_Names_Reader_Test() {
        Assertions.assertEquals(5, BiathlonResultsFileReader.getAthletesNames(filePath).size());
        Assertions.assertEquals("Jimmy Smiles", BiathlonResultsFileReader.getAthletesNames(filePath).get(1));
    }

    @Test
    public void athletes_Numbers_Reader_Test() {
        Assertions.assertEquals(5, BiathlonResultsFileReader.getAthletesNumbers(filePath).size());
        Assertions.assertEquals(27, BiathlonResultsFileReader.getAthletesNumbers(filePath).get(2));
    }

    @Test
    public void athletes_Country_Reader_Test() {
        Assertions.assertEquals(5, BiathlonResultsFileReader.getAthletesCountry(filePath).size());
        Assertions.assertEquals("SK", BiathlonResultsFileReader.getAthletesCountry(filePath).get(0));
    }

    @Test
    public void athletes_Ski_Time_Reader_Test() {
        LocalTime timeRead = LocalTime.parse("00:30:27");
        Duration timeResult = Duration.between(LocalTime.MIN, timeRead);

        Assertions.assertEquals(5, BiathlonResultsFileReader.getSkiTimeResult(filePath).size());
        Assertions.assertEquals(timeResult, BiathlonResultsFileReader.getSkiTimeResult(filePath).get(0));
    }

    @Test
    public void athletes_Shooting_Penalties_Calculator_Test() {
        int penalty = 10;
        String shootingScore = "xxxox";

        Assertions.assertEquals(penalty, BiathlonResultsFileReader.computeShootingPenalty(shootingScore));
    }

    @Test
    public void athletes_Penalties_Calculator_Test() {
        Assertions.assertEquals(5, BiathlonResultsFileReader.getAthletesPenalties(filePath).size());
        Assertions.assertEquals(0, BiathlonResultsFileReader.getAthletesPenalties(filePath).get(3));
    }

    @Test
    public void athletes_Total_Time_Result_Calculator_Test() {
        LocalTime timeRead = LocalTime.parse("00:30:57");
        Duration timeResult = Duration.between(LocalTime.MIN, timeRead);

        Assertions.assertEquals(5, BiathlonResultsFileReader.computeFinalTimeResult(filePath).size());
        Assertions.assertEquals(timeResult, BiathlonResultsFileReader.computeFinalTimeResult(filePath).get(0));
    }

    @Test
    public void duration_To_String_Converter_Test() {
        String durationString = "30:57";
        LocalTime timeRead = LocalTime.parse("00:30:57");
        Duration timeResult = Duration.between(LocalTime.MIN, timeRead);

        Assertions.assertEquals(durationString, ConvertTime.convertTime(timeResult));
    }
}
