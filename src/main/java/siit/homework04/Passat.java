package siit.homework04;

import java.util.ArrayList;

public class Passat extends Volkswagen{
    public Passat(String chassisNumber, int tireSize, float fuelTankSize, String fuelType, double availableFuel, int gears, double consumptionPer100Km) {
        super(chassisNumber, tireSize, fuelTankSize, fuelType, availableFuel, gears, consumptionPer100Km);
    }

    static ArrayList<Integer> shiftedGears = new ArrayList();
    /**
     * This method checks if the selected gear is available in the car instance. In also creates an array list that stores
     * the previously shifted gears. If the array's size is 0, it automatically adds the shifted gear to the array and
     * applies the up shift consumed fuel. If the array's size is not 0, it checks if the last gear was bigger or smaller
     * than the one selected now and applies the appropriate consume.
     * @param gear is the gear you want to shift into.
     */

    @Override
    public void shiftGear(int gear) {
        if(gear > this.getGears()){
            System.out.println("Gear not available!");
        }else if(shiftedGears.size() == 0) {
            shiftedGears.add(gear);
        }else if(gear <= shiftedGears.get(shiftedGears.size() - 1)){
            setAvailableFuel(this.availableFuel - (this.availableFuel * 0.05));
            shiftedGears.add(gear);
        }else{
            setAvailableFuel(this.availableFuel - (this.availableFuel * 0.1));
            shiftedGears.add(gear);
        }
    }
}
