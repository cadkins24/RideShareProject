import java.util.ArrayList;

public class Road {
    //fields
    private ArrayList<Passenger> totalPassengers;
    private ArrayList<Car> totalCars;
    private ArrayList<Station> totalStations;

    //constructors
    public Road() {
        totalPassengers = new ArrayList<Passenger>();
        totalCars = new ArrayList<Car>();
        totalStations = new ArrayList<Station>();
    }

    //methods
    public void addPassenger(Passenger a) {
        totalPassengers.add(a);
    }

    public void addCar(Car a) {
        totalCars.add(a);
    }

    public void addStation(Station a) {
        totalStations.add(a);
    }
    
    public void initialize() {
        //adds each passenger to its correct starting station based on its start variable
        for(int i = 0; i < totalPassengers.size(); i++) {
            for(int j = 0; j < totalStations.size(); j++) {
                if(totalPassengers.get(i).getStart() == totalStations.get(j).getNumber()) {
                    totalStations.get(j).getWaiting().add(totalPassengers.get(i)); 
                }
                
            }
            
        }

        //adds each car to its beginning station's "depot" array list
        for(int k = 0; k < totalCars.size(); k++) {
            for(int l = 0; l < totalStations.size(); l++) {
                if(totalCars.get(k).getStart() == totalStations.get(l).getNumber()) {
                    totalStations.get(l).getDepot().add(totalCars.get(k));
                }
            }
        }
    }

//These following methods are to control the movement and exchange of objects
    public void moveAllCars() {
        for(int i = 0; i < totalCars.size(); i++) {
            totalCars.get(i).moveCar();
        }

        //***need to make sure the cars are also transfered to the next stations array list
        //removing each car from past station
        for(int i = 0; i < totalCars.size(); i++) {
            Car a = totalCars.get(i);
            if(a.getFinished() != true) {
                //remove car from current station and add to current statN - 1
                if(a.getDirection() == 0) { //might have to check later that the car is not currently at the first or last staion?
                    for(int j = 0; j < totalStations.size(); j++) {
                        int prevStatNo = a.getLocation()+1;
                        if(totalStations.get(j).getNumber() == prevStatNo) { //getting the station the car used to be at
                            int n = totalCars.indexOf((a.getidNo()));
                            if(n != -1) {
                                totalStations.get(j).getDepot().remove(n);
                                j--;
                            }
                            
                        }
                    }
                }
                //repeating for other direction
                if(a.getDirection() == 1) {
                    for(int j = 0; j < totalStations.size(); j++) {
                        int prevStatNo2 = a.getLocation()-1;
                        if(totalStations.get(j).getNumber() == prevStatNo2) {
                            int m = totalCars.indexOf((a.getidNo()));
                            if(m != -1) {
                                totalStations.get(j).getDepot().remove(m);
                                j--;
                            }
                        }
                    }
                }
            }
        }        
        for(int i = 0; i < totalStations.size(); i++) {
            totalStations.get(i).dropOff();
            totalStations.get(i).pickUp();
        }
    }


    public void printInfo() {
        for(int i = 0; i < totalStations.size(); i++) {
            System.out.println(totalStations.get(i).toString());
        }
        for(int i = 0; i < totalCars.size(); i++) {
            System.out.println(totalCars.get(i).toString());
        }
    }
    


}
//responsible for moving cars from one sttaion to another after each move method

/**
 * 1. loop thorugh totalCars array list and move each car
 * 2. add and take away cars from a station's array list/ add  
 * 2. run checks at each station to dropp off and pick up passengers
 */



/**QUESTIONS
 * what is the best way to move each car to a the next station's array list after the move method is called (and remove the car from the old depot)
 */