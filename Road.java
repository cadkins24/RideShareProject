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
         //dropping off and picking up passengers
                for(int p = 0; p < totalStations.size(); p++) { 
                    totalStations.get(p).dropOff();
                    totalStations.get(p).pickUp();
                }
        
        

        //removing each car from past station
        for(int m = 0; m < totalStations.size(); m++) {
            Station s = totalStations.get(m);
            for(int n = 0; n < s.getDepot().size(); n++) {
                Car c = s.getDepot().get(n);
                if(c.getFinished() == false && c.getDirection() == 0) { //removing cars going left
                    totalStations.get(m-1).getDepot().add(c); //adding car to next station
                    s.getDepot().remove(c); //remove car from the station its currently at
                    n--;
                }
                
            }
        }
        for(int m = totalStations.size() - 1; m >= 0; m--) {
            Station s = totalStations.get(m);    
            for(int p = 0; p < s.getDepot().size(); p++) {
                Car c = s.getDepot().get(p);
                if(c.getFinished() == false && c.getDirection() == 1) { //repeating for cars going right //do another loop in the other direction -- do m loop twice and adjust indexes
                    totalStations.get(m+1).getDepot().add(c); //adding car to next station
                    s.getDepot().remove(c); //remove car from the station its currently at
                    p--;
                }
            }
        }
        //First moving all cars once
                for(int i = 0; i < totalStations.size(); i++) {
                    for(int k = 0; k < totalStations.get(i).getDepot().size(); k++) {
                        totalStations.get(i).getDepot().get(k).moveCar();
                    }
                }

       
    }


    
    
    public void printInfo() {
        for(int b = 0; b < totalStations.size(); b++) {
            System.out.println(totalStations.get(b).toString());
        }
        for(int f = 0; f < totalStations.size(); f++) {
            for(int g = 0; g < totalStations.get(f).getDepot().size(); g++) {
                System.out.println(totalStations.get(f).getDepot().get(g).toString());
            }            
        }
    }
    
    public int calculateRevenue() {
        int totalCount = 0;
        for(int i = 0; i < totalStations.size(); i++) {
            for(int j = 0; j < totalStations.get(i).getDepot().size(); j++) {
                totalCount += totalStations.get(i).getDepot().get(j).getRevenue();
            }
        }
        return totalCount;
    }

    public int calculateMiles() {
        int totalMiles = 0;
        for(int i = 0; i < totalStations.size(); i++) {
            for(int j = 0; j < totalStations.get(i).getDepot().size(); j++) {
                totalMiles += totalStations.get(i).getDepot().get(j).getMilesDriven();
            }
        }
        return totalMiles;
    }


}