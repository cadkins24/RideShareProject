import java.util.ArrayList;

public class Station {
    //fields
    private static int idGen = 1;
    private int number;
    private ArrayList<Passenger> waiting;
    private ArrayList<Car> depot; //need to edit method so that each move(), the car leaves the past depots station and is added to the next
    

/**
 * add passenger fomr waiting to car (by finding the passenger, and runing car.addPassenger)
 * road runs the move method which includes: runs thorugh every car at the station, and checks their list of passengers, and adds any one of those to the waiting array
 * 
 * @param myNumber
 */

    //constructors
public Station() {
    number = idGen;
    idGen++;
    waiting = new ArrayList<Passenger>();
    depot = new ArrayList<Car>();

}
    //methods
public void dropOff() {
    for(int i = 0; i < depot.size(); i++) {
        for(int j = 0; j < depot.get(i).getPassengers().size(); j++) {
            Passenger a = depot.get(i).getPassengers().get(j);
            if(a.getDestination() == number || depot.get(i).getFinished()) {
                waiting.add(depot.get(i).removePassenger(j)); //this removes the passeger from car list, and adds it to station list
            j--;
            }

        }
    }
}

public void pickUp() {
    for(int i = 0; i < waiting.size(); i++) {
        for(int j = 0; j < depot.size(); j++) {
            if(waiting.get(i).getDirection() == depot.get(j).getDirection() && depot.get(j).getPassengers().size() < 3 && waiting.get(i).getDestination() != number) {
                depot.get(j).getPassengers().add(waiting.remove(i));//passenger is removed from waiting array list and added to cars array list. car load +1
                i--;
                depot.get(j).increaseLoad();
            }
        }
    }
}

    public void addPassenger(Passenger a) { //loop through each person in the same waiting array as car in road object
       //loop through every car in the depot and see if 
    }

    public void moveStation() { //this should be run in road method under umbrella move() method, run after moveCar()

    }

pubic passenger droOff() { //returns the passenger to be dropped off
    for(int i = 0; i < load.size(); i++) {
        if((load.get(i).getdestination() == pos) || finished) {
            

        }
    }
}

public void addCar() {
    
}



public void carUnload() {
    for(int i = 0; i < depot.size(); i++)
}

//have car in the station


}



/**
 * car arrives at station --> check to see if any of the passengers in the car array list are at their desitnation
 *          if so: remove those passengers at the staion level
 *          if not: and car is full --> keep going
 * if car has space:
 * check if passengers in station array list can go in car
 * remove those passengers fomr station array list
 * 
 * 
 * each move: check if finished = true
 * 
 */


