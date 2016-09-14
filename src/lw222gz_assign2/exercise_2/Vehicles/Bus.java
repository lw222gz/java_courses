package lw222gz_assign2.exercise_2.Vehicles;

import lw222gz_assign2.exercise_2.Passenger;

/**
 * Created by Lucas on 2016-09-13.
 */
public class Bus extends Vehicle{

    public Bus(int amountOfPassengers)throws IllegalArgumentException{
        super(4, 200, amountOfPassengers, 10);
        //A bus must at least have 1 passenger, the driver. Towing a bus is usually done with a lorry or a vehicle of the same size and therefore goes under lorry.
        if (passengers.length > 20 || passengers.length < 1){
            throw new IllegalArgumentException("A bus can't have more than 20 or less than 1 passengers.");
        }
    }
}
