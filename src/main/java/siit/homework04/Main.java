package siit.homework04;

public class Main {
    public static void main(String[] args) {

        Golf car = new Golf("asnfuwansjsas", 19, 45, "Diesel", 38, 6, 8.2);
        Vehicle vehicle = new Passat("asdnwuabsudb", 17, 50, "Petrol", 45, 5, 7.8);

        //Car golf1 = new Golf("kghyrysdnjsd", 16, 40, "Petrol", 45, 5, 6);

        //Car newCar = new Car();
        //Dacia newDacia = new Dacia();

        car.start();

        car.shiftGear(1);

        car.shiftGear(2);

        car.drive(0.02);

        car.shiftGear(3);

        car.drive(0.5);

        car.shiftGear(4);

        car.drive(0.5);

        car.shiftGear(5);

        car.drive(10);

        car.shiftGear(4);

        car.drive(0.5);

        car.stop();

        vehicle.start();
        vehicle.drive(50);

        Car dacia = (Car) vehicle;

        dacia.shiftGear(7);
        dacia.stop();

        System.out.println(dacia.getAvailableFuel());
        System.out.println(car.getAvailableFuel());
    }
}
