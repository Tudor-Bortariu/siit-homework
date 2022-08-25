package homework09.unitTesting;

import org.junit.jupiter.api.Test;
import siit.homework09.FestivalAttendeeThread;
import siit.homework09.FestivalGate;
import siit.homework09.TicketType;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FestivalAttendeeTest {
    @Test
    public void ticket_Add_Method_Test() {
        FestivalGate gate = new FestivalGate();

        FestivalAttendeeThread festivalAttendee = new FestivalAttendeeThread(TicketType.FULL, gate);
        festivalAttendee.run();

        Integer size = 1;

        assertEquals(size, gate.getRepoSize());
        assertEquals(TicketType.FULL, gate.getTicketAtIndex(0));
    }

    @Test
    public void multiple_Tickets_Added_Method_Test() {
        FestivalGate gate = new FestivalGate();

        for (int i = 0; i < 10; i++) {
            FestivalAttendeeThread festivalAttendee = new FestivalAttendeeThread(gate.generateTicketType(), gate);
            festivalAttendee.run();
        }

        Integer size = 10;

        assertEquals(size, gate.getRepoSize());
    }

}