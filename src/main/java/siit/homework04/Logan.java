package siit.homework04;

public class Logan extends Dacia{

    public Logan(String chassisNumber, int tireSize, float fuelTankSize, String fuelType, double availableFuel, int gears, double consumptionPer100Km) {
        super(chassisNumber, tireSize, fuelTankSize, fuelType, availableFuel, gears, consumptionPer100Km);
    }

    /**
     * This method checks if the selected gear is available in the car instance. It also checks the parameter in the constructor that stores
     * the previously shifted gears for that instance. For every up shift the fuel consumption decreases because it gets closer to cruising
     * speed. For every down shift the consumption increases.
     * @param gear is the gear you want to shift into.
     */
    @Override
    public void shiftGear(int gear) {
        if(gear > this.getGears()){
            System.out.println("Gear not available!");
        }else if(this.getShiftedGears() == 0) {
            setAvailableFuel(this.availableFuel - (this.availableFuel * 0.1));
            setShiftedGears(gear);
        }else if(this.getShiftedGears() <= gear){
            setAvailableFuel(this.availableFuel - (this.availableFuel * 0.1));
            setShiftedGears(gear);
        }else{
            setAvailableFuel(this.availableFuel - (this.availableFuel * 0.05));
            setShiftedGears(gear);
        }
    }
}
