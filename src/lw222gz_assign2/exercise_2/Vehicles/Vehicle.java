package lw222gz_assign2.exercise_2.Vehicles;

import lw222gz_assign2.exercise_2.Passenger;

import java.util.ArrayList;

/**
 * Created by Lucas on 2016-09-13.
 */
public abstract class Vehicle {
    protected int size;
    protected Passenger[] passengers;
    protected int fee;

    //returns the size the vehicle will take up on the ferry.
    public int getSize(){
        return this.size;
    }

    public int getFee(){
        return this.fee;
    }

    //returns vehicle passengers
    public Passenger[] getPassengers(){
        return passengers;
    }
}
