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
    //METHODS
    /**
     * This method checks to see if any of the passengers aboard each car are at their 
     * destination, and if so, drops them off at the current station. It also drops off
     * everyone if the car is at its destination.  
     */
    public void dropOff() {  //WHY does this one not remove passenger from car???
    for(int i = 0; i < depot.size(); i++) {
        for(int j = 0; j < depot.get(i).getPassengers().size(); j++) {
            Passenger a = depot.get(i).getPassengers().get(j);
            if(a.getDestination() == depot.get(i).getLocation() || depot.get(i).getFinished()) {
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
                break;
            }
        }
    }
}

public String toString() {
    String lists = "";
    for(int i = 0; i < waiting.size(); i++) {
        lists += waiting.get(i).toString() + " ";
    }
    String carLists = "";
    for(int i = 0; i < depot.size(); i++) {
        carLists += depot.get(i).toString() + " ";
    }
    return super.toString() + "[sntNo=" + number + "\n" + "     passengers= [" + lists + "] \n" + "     cars= " + carLists + "]";
}

public ArrayList<Passenger> getWaiting() {
    return waiting;
}

public ArrayList<Car> getDepot() {
    return depot;
}

public int getNumber() {
    return number;
}
}