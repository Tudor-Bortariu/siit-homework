package siit.homework07;

import java.util.List;

public class Hobby {
    private final String hobbyName;
    private int frequency;
    private List<HobbyAddress> hobbyAddressList;

    public Hobby(String hobbyName, int frequency, List<HobbyAddress> hobbyAddressList) {
        this.hobbyName = hobbyName;
        this.frequency = frequency;
        this.hobbyAddressList = hobbyAddressList;
    }

    @Override
    public String toString() {
        return "Hobby: " + this.hobbyName + " " + this.hobbyAddressList;
    }
}
