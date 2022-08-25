package siit.homework09;

public class FestivalAttendeeThread extends Thread{
    private final TicketType ticketType;
    private final FestivalGate gate;

    /**
     * This is the constructor for the attendee thread.
     * @param ticketType holds the type of the ticket for every attendee. This ticket type will be "scanned" at the gate.
     * @param gate is the gate at which the attendee passes.
     */
    public FestivalAttendeeThread(TicketType ticketType, FestivalGate gate) {
        this.ticketType = ticketType;
        this.gate = gate;
    }

    /**
     * This method adds the ticket type held by the instance of Attendee to the Repo of attendees, similar to the attendee scanning the ticket at the gate.
     */
    @Override
    public void run() {
            gate.addTicket(ticketType);
    }
}
