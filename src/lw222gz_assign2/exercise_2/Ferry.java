package lw222gz_assign2.exercise_2;

import lw222gz_assign2.exercise_2.Vehicles.Vehicle;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

/**
 * Created by Lucas on 2016-09-13.
 */
public class Ferry implements IFerry {

    //int representing the income of the ferry.
    private int income = 0;

    //the max amount of passengers are 200
    private Passenger[] passengers = new Passenger[200];

    //the max amount of vehicles that can be reached is 200, only bicycles
    private Vehicle[] boardedVehicles = new Vehicle[200];

    private int space = 0;
    //The ferry can take 40 cars at max, 1 car = 5 in size (bicycle = 1), 5 x 40 = 200.
    private final int MAX_AMOUNT_OF_SPACE = 200;

    // Number of passengers on board
    public int countPassengers(){
        return passengers.length;
    }
    // Used vehicle space. One car is 1.
    //TODO: this is probably not an acceptable way to do it?
    public int countVehicleSpace(){
        return (int)Math.ceil(space / 5);
    }

    // Earned money
    public int countMoney(){
        return income;
    }

    // Embark vehicle, warning if not enough space
    public void embark(Vehicle v){
        for(Vehicle vehicle: boardedVehicles){
            //same vehicle should not be abel to board twice
            if(vehicle.equals(v)){
                System.err.print("This vehicle has already boarded.");
                return;
            }
        }

        if(hasSpaceFor(v)){

        }
        else{
            System.err.print("There is not enough space for this vehicle.");
        }



    }

    // Embark passenger, warning if not enough room
    public void embark(Passenger p){
        throw new NotImplementedException();
    }

    // Clear (empty) ferry. The money earned remains,
    // i.e., is not reset to zero
    public void disembark(){
        throw new NotImplementedException();
    }

    // true if we can embark vehicle v
    public boolean hasSpaceFor(Vehicle v){

    }

    // true if we can embark passenger p
    public boolean hasRoomFor(Passenger p){

    }

    // Nice looking ferry status print out
    public String toString(){

    }
}
