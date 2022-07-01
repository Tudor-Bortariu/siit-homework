package siit.homework04;

public interface CarBehaviour {
    /**
     * This method allows a car to shift gears and adjust its fuel consumption accordingly to cruising gear.
     * This method is in a separate Interface because not all vehicles have gears, thus are unable to shift them.
     * @param gear is the gear you want to shift into.
     */
    void shiftGear(int gear);
}
