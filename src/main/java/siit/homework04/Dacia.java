package siit.homework04;

public abstract class Dacia extends Car{

    public Dacia(String chassisNumber, int tireSize, float fuelTankSize, String fuelType, double availableFuel, int gears, double consumptionPer100Km) {
        super(chassisNumber, tireSize, fuelTankSize, fuelType, availableFuel, gears, consumptionPer100Km);
    }
}
