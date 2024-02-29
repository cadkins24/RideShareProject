import java.util.ArrayList;

public class RideShareTester {
    public static void main(String[] args) {
        //Creating a road
        Road r = new Road();
        
        //creating 32 stations
        System.out.println("Establishing 32 stations...");
        for(int i = 0; i < 32; i++) {
            Station station = new Station();
            r.addStation(station);
        }

        //creating cars with random stars and ends
        System.out.println("Generating random cars with locations and destinations...");
        for(int i = 0; i < 10; i++) {
            int random1 = (int)(Math.random() * 32);
            int random2 = (int)(Math.random() * 32);
            Car car = new Car(random1, random2);
            r.addCar(car);
        }
        
        //creating passengers with random starts and ends
        System.out.println("Generating random passengers with locations and destinations...");
        for(int i = 0; i < 40; i++) {
            int random1 = (int)(Math.random() * 32);
            int random2 = (int)(Math.random() * 32);
            Passenger pass = new Passenger(random1, random2);
            r.addPassenger(pass);
        }
        r.printInfo();
        System.out.println();
        System.out.println();
        
        //loop that moves cars 100 times
        for(int i = 1; i <= 100; i++) {
            System.out.println("Number of total moves: " + i);
            r.moveAllCars();
            r.printInfo();
            System.out.println();
            System.out.println();
        }

        //calculate total revenue
        System.out.println("Calculating average revenue generated...");
        System.out.println("Money made/Miles Driven: " + r.calculateRevenue() + " / " + r.calculateMiles() + " = " + ((double) r.calculateRevenue() / r.calculateMiles()));

    }

    
}
