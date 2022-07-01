package siit.homework04;

public abstract class Volkswagen extends Car{
    public Volkswagen(String chassisNumber, int tireSize, float fuelTankSize, String fuelType, double availableFuel, int gears, double consumptionPer100Km) {
        super(chassisNumber, tireSize, fuelTankSize, fuelType, availableFuel, gears, consumptionPer100Km);
    }
}
