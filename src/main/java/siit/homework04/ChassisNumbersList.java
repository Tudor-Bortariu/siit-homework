package siit.homework04;

import java.util.ArrayList;

public class ChassisNumbersList {
    ArrayList<String> chassisNumbers = new ArrayList<>();

    /**
     * This method adds a chassis number to the array list created previously.
     * @param chassisNumber is a String variable with the unique chassis number of a car.
     */
    public void addChassisNumber(String chassisNumber){
        chassisNumbers.add(chassisNumber);
    }

    /**
     * This boolean returns true if a chassis number is already in
     * @param chassisNumber is a String variable with the unique chassis number of a car.
     * @return this method returns true if a chassis number is already in the previously created array list.
     */
    public boolean listContainsNumber(String chassisNumber){
        return chassisNumbers.contains(chassisNumber);
    }
}