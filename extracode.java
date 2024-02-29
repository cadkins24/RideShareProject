public class extracode {
     //***need to make sure the cars are also transfered to the next stations array list
        //removing each car from past station
        for(int i = 0; i < totalCars.size(); i++) {
            Car a = totalCars.get(i);
            if(a.getFinished() != true) {
                //remove car from current station and add to current statN - 1
                if(a.getDirection() == 0) { //might have to check later that the car is not currently at the first or last staion?
                    for(int j = 0; j < totalStations.size(); j++) {
                        int prevStatNo = a.getLocation()+1;
                        if(totalStations.get(j).getNumber() == prevStatNo) { //locating the station the car used to be at
                            int n = totalCars.indexOf((a.getidNo()));
                            if(n != -1) {
                                totalStations.get(j).getDepot().remove(n);
                                j--;
                            }
                            for(int k = 0; i < totalCars.size(); k++) {
                                totalCars.get(k).moveCar();
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
                             for(int k = 0; i < totalCars.size(); k++) {
                                totalCars.get(k).moveCar();
                            }
                        }
                    }
                }
            }
        }        
}




 for(int i = 0; i < totalCars.size(); i++) {
            Car a = totalCars.get(i);
            if(a.getFinished() == false) { //if car isn't finished
                //remove car from past station and add to current station
                if(a.getDirection() == 0) { //might have to check later that the car is not currently at the first or last staion?
                    for(int j = 0; j < totalStations.size(); j++) {
                        int prevStatNo = a.getLocation()+1;
                        if(totalStations.get(j).getNumber() == prevStatNo) { //locating the station the car used to be at
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



        //dropping off and picking up passengers
                for(int p = 0; p < totalStations.size(); p++) { 
                    totalStations.get(p).dropOff();
                    totalStations.get(p).pickUp();
                }