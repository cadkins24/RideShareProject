import java.util.ArrayList;

public class Road {
    //fields
    private ArrayList<Station> totalStations;

    //constructors
    public Road() {
        totalStations = new ArrayList<Station>();
    }

    //methods
    public void addPassenger(Passenger a) {
        for(int j = 0; j < totalStations.size(); j++) {
            if(a.getStart() == totalStations.get(j).getNumber()) {
                totalStations.get(j).getWaiting().add(a); 
            }
                        
        }
    }

    public void addCar(Car a) {
        for(int l = 0; l < totalStations.size(); l++) {
            if(a.getStart() == totalStations.get(l).getNumber()) {
                totalStations.get(l).getDepot().add(a);
            }
        }
    }

    public void addStation(Station a) {
        totalStations.add(a);
    }


//This following method is to control the movement and exchange of objects
    public void moveAllCars() {
        //First moving all cars once
        for(int i = 0; i < totalStations.size(); i++) {
            for(int j = 0; j < totalStations.get(i).getDepot().size(); j++) {
                totalStations.get(i).getDepot().get(j).moveCar();
            }
        }

        //removing each car from past station
        for(int i = 0; i < totalStations.size(); i++) {
            Station s = totalStations.get(i);
            for(int j = 0; j < s.getDepot().size(); j++) {
                Car c = s.getDepot().get(j);
                if(c.getFinished() == false && c.getDirection() == 0) { //removing cars going left
                    totalStations.get(i-1).getDepot().add(c); //adding car to next station
                    s.getDepot().remove(c); //remove car from the station its currently at
                    j--;
                }
                if(c.getFinished() == false && c.getDirection() == 1) { //repeating for cars going right
                    totalStations.get(i+1).getDepot().add(c); //adding car to next station
                    s.getDepot().remove(c); //remove car from the station its currently at
                    j--;
                }
            }
        }
        for(int i = 0; i < totalStations.size(); i++) { //dropping off and picking up passengers
            totalStations.get(i).dropOff();
            totalStations.get(i).pickUp();
        }
    }


    public void printInfo() {
        for(int i = 0; i < totalStations.size(); i++) {
            System.out.println(totalStations.get(i).toString());
        }
        for(int i = 0; i < totalStations.size(); i++) {
            for(int j = 0; j < totalStations.get(i).getDepot().size(); j++) {
                System.out.println(totalStations.get(i).getDepot().get(j).toString());
            }            
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