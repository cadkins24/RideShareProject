import java.util.ArrayList;

public class Passenger {

//fields
private int start;
private int dest;
private static int idGen = 1;
private int idNo;
private int direction; //0 = left, 1 = right 

//constructors
public Passenger(int myStart, int myDest) {
    start = myStart;
    dest = myDest;
    idNo = idGen;
    idGen++;
    if(start < dest) {
        direction = 1;
    } else if(start > dest) {
        direction = 0;
    }
}

//Getter methods:
public int getStart() {
    return start;
}

public int getDestination() {
    return dest;
}

public int getDirection() {
    return direction;
}

public String toString() {
    return super.toString() + "[Start=" + start + ",dest=" + dest + ",id#=" + idNo + "]";
}

}
