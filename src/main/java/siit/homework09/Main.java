package siit.homework09;

public class Main {

    public static void main(String[] args) {

        FestivalGate gate = new FestivalGate();

        FestivalStatisticsThread festivalStatisticsThread = new FestivalStatisticsThread(gate);
        festivalStatisticsThread.start();

        /**
         * I used a for loop inside which I created an instance of an Attendee Thread, which will start and add the randomly generated ticket
         * to the repository. I also used the Thread.sleep method to slow down the process. In this way I was able to instantiate 101 Attendee
         * Threads to scan the tickets.
         */
        for (int i = 0; i <= 100; i++) {
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            FestivalAttendeeThread festivalAttendeeThread = new FestivalAttendeeThread(gate.generateTicketType(), gate);
            festivalAttendeeThread.start();
        }

        /**
         * After the loop we can "close" the gate and thus end the program.
         */
        gate.gateOpen = false;

    }
}

