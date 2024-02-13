public class Passenger {

//fields
private int start;
private int end;
private static int idGen = 1;
private int idNo;

//constructors
public Passenger(int myStart, int myEnd) {
    start = myStart;
    end = myEnd;
    idNo = idGen;
    idGen++;
}

//methods
public int getStart() {
    return start;
}

public int getEnd() {
    return end;
}

public String toString() {
    return "Starting location: " + start + ", destination: " + end + "id Number: " + idNo;
}

}
