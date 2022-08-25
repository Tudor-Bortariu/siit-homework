package siit.homework09;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class FestivalStatisticsThread extends Thread{
    private static final Logger LOGGER = LogManager.getLogger();
    private final FestivalGate gate;
    public FestivalStatisticsThread(FestivalGate gate) {
        this.gate = gate;
    }

    /**
     * This method uses Thread.sleep to wake up the thread and print out the stats from the Repo if the Queue is not empty.
     * I used a while method to make this thread run as long as there are attendees still being "scanned" at the gate.
     */
    @Override
    public void run(){
        while (gate.gateOpen) {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                try {
                    if (gate.getRepoSize().equals(0)) {
                        throw new NullPointerException("Gate server has no data.");
                    } else {
                        gate.readRepoStatistics();
                    }
                } catch (NullPointerException e) {
                    LOGGER.error("Null Pointer Exception", e);
                    throw e;
                }
            }
        }
}
