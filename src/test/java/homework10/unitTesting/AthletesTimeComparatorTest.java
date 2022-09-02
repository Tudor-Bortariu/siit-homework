package homework10.unitTesting;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import siit.homework10.BiathlonFinalResults;

public class AthletesTimeComparatorTest {
    String filePath = ".\\src\\test\\resources\\homework10.testFiles\\biathlonTestResults.csv";

    @Test
    public void first_Place_Holder_Test() {
        Assertions.assertEquals("29:22", BiathlonFinalResults.getFinalResults(filePath).get(0).getConvertedTime());
        Assertions.assertEquals("John Doe", BiathlonFinalResults.getFinalResults(filePath).get(0).getName());
    }

    @Test
    public void last_Place_Holder_Test() {
        Assertions.assertEquals("30:57", BiathlonFinalResults.getFinalResults(filePath).get(4).getConvertedTime());
        Assertions.assertEquals("Umar Jorgson", BiathlonFinalResults.getFinalResults(filePath).get(4).getName());
    }

    @Test
    public void single_Participant_Parser_Test() {
        String singleParticipantFilePath = ".\\src\\test\\resources\\homework10.testFiles\\biathlonTestResultsSingleParticipant.csv";

        Assertions.assertEquals(1, BiathlonFinalResults.getFinalResults(singleParticipantFilePath).size());
        Assertions.assertEquals("Umar Jorgson", BiathlonFinalResults.getFinalResults(singleParticipantFilePath).get(0).getName());
    }

    @Test
    public void total_Athletes_Reader_Test() {
        Assertions.assertEquals(5, BiathlonFinalResults.getFinalResults(filePath).size());
    }
}
