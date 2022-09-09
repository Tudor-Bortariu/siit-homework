package siit.homework09;

import java.util.*;

public class FestivalGate {

    /**
     * I create a static Queue in order to store the tickets scanned at the gate. I chose linked list because my interest is to
     * be able to quickly add elements to the list.
     */
    private static final Queue<TicketType> ATTENDEE_REPOSITORY = new LinkedList<>();

    /**
     * I create a boolean to be able to notify the statistics thread when all the people have entered and the gate is closed.
     * In this way I have a method to close the stats thread too.
     */
    public boolean gateOpen = true;

    /**
     * I also created a method which returns a random ticket type from a list of all types from the enum created.
     * @return Returns a random ticket type.
     */
    public TicketType generateTicketType(){
        List<TicketType> ticketTypes = Arrays.asList(TicketType.values());
        Random random = new Random();
        return ticketTypes.get(random.nextInt(ticketTypes.size()));
    }

    /**
     * I created a synchronized method to get the size of the Queue at any given moment.
     * @return Returns the size of the static Queue.
     */
    public synchronized Integer getRepoSize(){
        return ATTENDEE_REPOSITORY.size();
    }

    /**
     * I created this method to be able to better test the Attendee Thread. I convert the Queue in an Array List to be
     * able to find rapidly elements in it.
     * @param index is the index of the ticket you want to show.
     * @return Returns a ticket type at the introduced index.
     */
    public synchronized TicketType getTicketAtIndex(int index){
        List<TicketType> ticketList = new ArrayList<>(ATTENDEE_REPOSITORY);
        return ticketList.get(index);
    }

    /**
     * I created a static synchronized method to add a ticket type to the Queue. The synchronized methods allow us
     * to ensure we will not have concurrent modifications on the repository between adding and reading methods.
     * @param ticket is the ticket type of each Attendee Thread's constructor param to be added to the repository.
     */
    public synchronized void addTicket(TicketType ticket){
        ATTENDEE_REPOSITORY.add(ticket);
    }

    /**
     * This is the stats reading method. I instantiate a different variable for every ticket type. I iterate through the Repo
     * using a stream and filter for a specific ticket type. After the filter I use a count method to attribute the number of
     * those ticket types to the specific variable. After that I print the values accordingly to the console.
     */
    public synchronized void readRepoStatistics(){
        System.out.println(" ");
        System.out.println(ATTENDEE_REPOSITORY.size() + " people have entered.");
        System.out.println(getCount(TicketType.FULL) + " people have full tickets.");
        System.out.println(getCount(TicketType.FREE_PASS) + " people have free passes.");
        System.out.println(getCount(TicketType.FULL_VIP) + " people have full VIP tickets.");
        System.out.println(getCount(TicketType.ONE_DAY) + " people have one-day passes.");
        System.out.println(getCount(TicketType.ONE_DAY_VIP) + " people have one-day VIP passes.");
    }

    private long getCount(TicketType ticketType) {
        return ATTENDEE_REPOSITORY.stream()
                .filter(ticket -> ticket.equals(ticketType))
                .count();
    }
}