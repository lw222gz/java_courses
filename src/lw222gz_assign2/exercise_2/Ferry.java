package lw222gz_assign2.exercise_2;

import lw222gz_assign2.exercise_2.Vehicles.Vehicle;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by Lucas on 2016-09-13.
 */
public class Ferry implements IFerry {

    //int representing the income of the ferry.
    private int income = 0;

    //the max amount of passengers are 200
    private final int MAX_AMOUNT_OF_PASSENGERS = 200;
    private ArrayList<Passenger> passengers = new ArrayList<Passenger>(MAX_AMOUNT_OF_PASSENGERS);

    //the max amount of vehicles that can be reached is 200, only bicycles (40/.2 = 200)
    private final int MAX_AMOUNT_OF_VEHICLES = 200;
    private ArrayList<Vehicle> boardedVehicles = new ArrayList<Vehicle>(MAX_AMOUNT_OF_VEHICLES);

    //
    private final int MAX_AMOUNT_OF_SPACE = 40;
    private double space = 0;


    // Number of passengers on board
    public int countPassengers(){
        return passengers.size();
    }

    // Used vehicle space. One car is 1.
    //TODO: this is probably not an acceptable way to do it?
    public int countVehicleSpace(){
        return (int)Math.ceil((Math.round(space * 10d)/10d));
    }

    // Earned money
    public int countMoney(){
        return income;
    }

    // Embark vehicle, warning if not enough space
    public void embark(Vehicle v){
        if(boardedVehicles.contains(v)){
            System.err.println("This vehicle has already boarded.");
            return;
        }
        //If the ferry don't have space for the vehicle
        //a waring is printed and the function is aborted.
        if(!hasSpaceFor(v)){
            System.err.println("There is not enough space for this vehicle.");
            return;
        }

        if(passengers.size() + v.getPassengers().length > MAX_AMOUNT_OF_PASSENGERS){
            System.err.println("There is not enough room for the passengers on this vehicle.");
            return;
        }

        //embarks the passengers of the vehicle and the vehicle itself.
        for(Passenger p : v.getPassengers()){
            embark(p);
        }
        //Boards the vehicle and adds the income
        boardedVehicles.add(v);
        income += v.getVehicleFee();
        space += v.getSize();

    }

    // Embark passenger, warning if not enough room
    public void embark(Passenger p){
        if(hasRoomFor(p)){
            //boards the passenger and adds their fee
            passengers.add(p);
            income += p.getPassengerFee();
        }
        else{
            System.err.println("There was not enough room for the passenger. Passenger not added.");
        }
    }

    // Clear (empty) ferry. The money earned remains,
    // i.e., is not reset to zero
    public void disembark(){
        boardedVehicles.clear();
        passengers.clear();
        space = 0;
    }

    // true if we can embark vehicle v
    public boolean hasSpaceFor(Vehicle v){
        //Need to remove trailing zeroes, src: http://stackoverflow.com/questions/153724/how-to-round-a-number-to-n-decimal-places-in-java
        if(Math.round(space * 10d)/10d + v.getSize() <= MAX_AMOUNT_OF_SPACE){
            return true;
        }
        return false;
    }

    // true if we can embark passenger p
    public boolean hasRoomFor(Passenger p){
        if(passengers.size() + 1 <= MAX_AMOUNT_OF_PASSENGERS){
            return true;
        }
        return false;
    }

    // Nice looking ferry status print out
    public String toString(){
        return "Current amount of passengers: " + countPassengers() +
                "\nCurrent amount of vehicles: "+ boardedVehicles.size() +
                "\nCurrent space ocupado: " + countVehicleSpace() + " / 40" +
                "\nCurrent income: " + countMoney();

    }

    public Iterator<Vehicle> iterator() { return new vehicleIterator();}

    private class vehicleIterator implements Iterator<Vehicle> {

        private int count = 0;
        public Vehicle next(){
            Vehicle v = boardedVehicles.get(count);
            count++;
            return v;
        }

        public boolean hasNext(){
            return count < boardedVehicles.size();
        }
    }
}
