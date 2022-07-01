package siit.homework04;

public  abstract class Car implements Vehicle, CarBehaviour{
    private String chassisNumber;
    private int tireSize;
    private final float fuelTankSize;
    private final String fuelType;
    double availableFuel;
    private int gears;
    private final double consumptionPer100Km;
    private double initialFuel;
    private int shiftedGears;


    /**
     * This is a constructor of objects. In this case we create objects that will require 7 different
     * types of parameters to be entered in order to create an instance of the object.
     * @param chassisNumber is a String parameter which is final and its value cannot be changed.
     * @param tireSize is an int parameter whose value can be changed through a setter method.
     * @param fuelTankSize is a float parameter whose value is final and cannot be modified.
     * @param fuelType is a String parameter whose value is final and cannot be modified.
     * @param availableFuel is a double parameter whose value can be modified through a setter method.
     * @param gears is an int parameter whose value is final and cannot be changed.
     * @param consumptionPer100Km is a double parameter whose value is final and cannot be changed.
     */
    public Car(String chassisNumber, int tireSize, float fuelTankSize, String fuelType, double availableFuel, int gears, double consumptionPer100Km) {
        this.shiftedGears = 0;
        this.initialFuel = availableFuel;
        setChassisNumberOrThrow(chassisNumber);
        this.tireSize = tireSize;
        this.fuelTankSize = fuelTankSize;
        this.fuelType = fuelType;
        this.availableFuel = availableFuel;
        setGears(gears);
        this.consumptionPer100Km = consumptionPer100Km;
    }

    /**
     * This is a getter method.
     * @return returns the value of the available fuel from an instance of a Car object.
     */
    public double getAvailableFuel() {
        return availableFuel;
    }

    /**
     * This is a getter method.
     * @return returns the value of the average consumption from an instance of a Car object.
     */
    public double getConsumptionPer100Km() {
        return consumptionPer100Km;
    }

    /**
     * This is a getter method.
     * @return returns the maximum number of gears from an instance of a Car object.
     */
    public int getGears() {
        return gears;
    }
    public int getShiftedGears() {
        return shiftedGears;
    }

    public void setShiftedGears(int shiftedGears) {
        this.shiftedGears = shiftedGears;
    }

    static ChassisNumbersList chassisNumbers = new ChassisNumbersList();

    /**
     * In this method we check if an instance of an object already has the introduced chassis number. If the chassis number
     * is not in the array list, we create the new instance of Car. We add the new chassis number to the array list.
     * If the chassis number is in the list, we throw an exception specifying that the chassis number already exists.
     * We use this method in the constructor in order to check every new instance of Car's chassis number.
     * @param chassisNumber is a String variable which contains the unique chassis number of a car.
     */
    public void setChassisNumberOrThrow(String chassisNumber){
        if (chassisNumbers.listContainsNumber(chassisNumber)){
            throw new RuntimeException ("Chassis number " + chassisNumber + " already exists!");
        }else{
            this.chassisNumber = chassisNumber;
            chassisNumbers.addChassisNumber(chassisNumber);
        }
    }
    public void setAvailableFuel(double availableFuel) {
        this.availableFuel = availableFuel;
    }

    /**
     * This code checks if the number of gears of a Car instance is less than 6. If the number is bigger than
     * 6, an exception is thrown specifying that a car can have maximum 6 gears.
     * @param gears describes the maximum number of gears a model of a car has.
     */
    public void setGears(int gears) {
        if(gears <= 6){
            this.gears = gears;
        }else{
            throw new RuntimeException("Created cars can have maximum 6 gears!");
        }
    }

    public void start() {
        setAvailableFuel(this.initialFuel);
    }

    public void stop() {
    }

    /**
     * This overrides the drive method from the Vehicle interface. With this method we increase the average consumption
     * if the tire size is bigger than 18. We decrease the available fuel accordingly to the average consumption and
     * driven number of kilometers of the vehicle. We also check if the drive command does not require more fuel
     * than available in the car.
     * @param kilometers gives the number of kilometers the vehicle drives for.
     */
    @Override
    public void drive(double kilometers) {
        double estimatedConsumedFuel = (this.getConsumptionPer100Km() / 100) * kilometers;
        if(this.availableFuel == 0 || estimatedConsumedFuel > this.availableFuel){
            System.out.println("Not enough fuel!");
        }else if(this.tireSize <= 18){
            setAvailableFuel(this.availableFuel - ((this.getConsumptionPer100Km() / 100) * kilometers));
        }else{
            setAvailableFuel(this.availableFuel - (((this.getConsumptionPer100Km() + 1 ) / 100) * kilometers));
        }
    }
}
