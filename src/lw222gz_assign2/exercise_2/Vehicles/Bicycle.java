package lw222gz_assign2.exercise_2.Vehicles;

import lw222gz_assign2.exercise_2.Passenger;

/**
 * Created by Lucas on 2016-09-13.
 */
public class Bicycle extends Vehicle{


    public Bicycle(Passenger p) throws IllegalArgumentException{
        if(p == null){
            throw new IllegalArgumentException("A bicycle must have a passenger.");
        }
        passengers = new Passenger[1];
        passengers[0] = p;

        //No info in the assignment was given to be abel to embark a bicycle without a passenger.
        //Bicycle can only have one passenger and is therefore at a static 40 fee cost.
        fee = 40;

        //smallest vehicle
        size = 1;
    }
}
