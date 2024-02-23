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



//constructors
public Car(int myStart, int myDest) {
    start = myStart;
    dest = myDest;
    location = start;
    load = 0;
    if(start < dest) {
        direction = 1;
    } else if(start >= dest) {
        direction = 0;
    }
    passengers = new ArrayList<Passenger>();
    idNo = idGen;
    idGen++;
}

//methods



/** This method moves the car forward 
 * 
 */
public void moveCar() {
    if(location != dest) {
        if(direction == 0) {
            location -= 1;
        } else {
            location += 1;
        }
    }if(location == dest) {
        finished = true;
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


}