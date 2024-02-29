import java.util.ArrayList;

public class Car{

//fields
private boolean finished;
private int load;
private int dest;
private int start;
private int location;
private int direction; //0 = left, 1 = right
private ArrayList<Passenger> passengers;
private static int idGen = 1;
private int idNo;
private int revenue;
private int milesDriven;



//constructor
public Car(int myStart, int myDest) {
    start = myStart;
    dest = myDest;
    location = start;
    load = 0;
    if(start < dest) { //establishes which direction the car is moving
        direction = 1;
    } else if(start > dest) {
        direction = 0;
    }
    passengers = new ArrayList<Passenger>();
    idNo = idGen;
    idGen++;
    revenue = 0;
    milesDriven = 0;
}

//METHODS

/**  
 * Moves car forward one mile if the car hasn't reached its destination yet.
 */
public void moveCar() {
    if(location != dest) {
        if(direction == 0) {
            location -= 1;
        } else {
            location += 1;
        }
        revenue += passengers.size(); //adding $1 per each passenger each time the car moves
        milesDriven += 1; //keeping track of the miles each car has driven
    }if(location == dest) {
        finished = true;
    }
}

/**
 * Removes passenger at specified index from Car's array list of current passengers
 * @param index
 * @return the removed passenger
 */
public Passenger removePassenger(int index) {
    return passengers.remove(index);
}

/**
 * Updates car's current load by 1
 */
public void increaseLoad() {
    load += 1;
}

/**
 * Checks to see if car is finished
 * @return true if the car is at it's destination
 */
public boolean isFinished() {
    if(location == dest) {
        finished = true;
    } else {
        finished = false;
    }
    return finished;
}

//Getter methods
public int getidNo() {
    return idNo;
}

public int getLocation() {
    return location;
}

public int getStart() {
    return start;
}

public int getDestination() {
    return dest;
}

public int getDirection() {
    return direction;
}

public int getCurrentLoad() {
    return load;
}

public ArrayList<Passenger> getPassengers() {
    return passengers;
}

public boolean getFinished() {
    return finished;
}

public int getRevenue() {
    return revenue;
}

public int getMilesDriven() {
    return milesDriven;
}

public String toString() {
    String lists = "";
    for(int i = 0; i < passengers.size(); i++) {
        lists += passengers.get(i).toString();
    }
    return super.toString() + "[loc=" + location + ", dest=" + dest + ", passengers: " + "(" + lists + ")";

}
}