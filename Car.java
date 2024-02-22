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



//constructors
public Car(int myStart, int myDest, int myDirection) {
    start = myStart;
    dest = myDest;
    location = start;
    load = 0;
    direction = myDirection;
    passengers = new ArrayList<Passenger>();
}

//methods
public void addPassenger(Passenger a) {  //loop through each passenger in waiting array in road object to see if it can be added to car
    if((a.getDirection() == direction) && (load < 3)) {
        passengers.add(a);
    }
    //need more code here for removing passenger a from station (in sation method)
}

public void canDropOff() {
    for(int i = 0; i < passengers.size(); i++) {
        if(location == passengers.get(i).getDestination()) {
            passengers.remove(passengers.get(i));
            i--;
            return 
    }

}

/** This method moves the car forward and checks if any of its passengers are at their destination
 * 
 */
public void moveCar() {
    if(direction == 0) {
        location -= 1;
    } else {
        location += 1;
    }
}

public String toString() {
    String lists = "";
    for(int i = 0; i < passengers.size(); i++) {
        lists += passengers.get(i).toString() + " ";
    }
    return super.toString() + "[loc=" + location + ", dest=" + dest + ",passengers= " + lists;

}

public Passenger removePassenger(int index) {
    return passengers.remove(index);
}

public void increaseLoad() {
    load += 1;
}

public boolean isFinished() {
    if(location == dest) {
        finished = true;
    } else {
        finished = false;
    }
    return finished;
}

//need add funds method

//-----------Getter Methods
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


}