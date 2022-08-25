package homework09.unitTesting;

import org.junit.jupiter.api.Test;
import siit.homework09.FestivalGate;
import siit.homework09.FestivalStatisticsThread;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class FestivalStatisticsTest {

    @Test
    public void empty_List_Exception_Test() {
        FestivalGate gate = new FestivalGate();
        FestivalStatisticsThread festivalStatisticsThread = new FestivalStatisticsThread(gate);
        Exception exception = assertThrows(NullPointerException.class, festivalStatisticsThread::run);

        String expectedMessage = "Gate server has no data.";
        String actualMessage = exception.getMessage();

        assertEquals(actualMessage, expectedMessage);
    }
}
