import java.util.ArrayList;

public class RideShareTester {
    public static void main(String[] args) {
        //Creating a road
        Road r = new Road();
        
        System.out.println("Establishing 3 stations...");
        Station stat1 = new Station();
        r.addStation(stat1);
        Station stat2 = new Station();
        r.addStation(stat2);
        Station stat3 = new Station();
        r.addStation(stat3);
    
        System.out.println("Generating non-random cars with locations and destination...");
        Car car1 = new Car(1, 3);
        r.addCar(car1);
        Car car2 = new Car(2, 1);
        r.addCar(car2);

        System.out.println("Generating non-random passengers with locations and destinations...");
        Passenger lilie = new Passenger(1, 3);
        r.addPassenger(lilie);
        r.initialize();
        r.printInfo();
        System.out.println();
        r.moveAllCars();
        r.printInfo();
        System.out.println();
        r.moveAllCars();
        r.printInfo();
        System.out.println();
        r.moveAllCars();
        r.printInfo();
    }
}
