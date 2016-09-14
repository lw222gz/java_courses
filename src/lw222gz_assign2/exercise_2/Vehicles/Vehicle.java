package lw222gz_assign2.exercise_2.Vehicles;

import lw222gz_assign2.exercise_2.Passenger;

import java.util.ArrayList;

/**
 * Created by Lucas on 2016-09-13.
 */
public abstract class Vehicle {
    protected double size;
    protected Passenger[] passengers;
    protected int vehicleFee;

    public Vehicle(double size, int vehicleFee, int amountOfPassengers, int passengerCost){

        passengers = new Passenger[amountOfPassengers];
        for(int i = 0; i < amountOfPassengers; i++){
            passengers[i] = new Passenger(passengerCost);
        }

        this.size = size;
        this.vehicleFee = vehicleFee;

    }

    //returns the size the vehicle will take up on the ferry.
    public double getSize(){
        return this.size;
    }

    public int getVehicleFee(){
        return this.vehicleFee;
    }

    //returns vehicle passengers
    public Passenger[] getPassengers(){
        return passengers;
    }
}
