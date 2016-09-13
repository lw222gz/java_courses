package lw222gz_assign2.exercise_2.Vehicles;

import lw222gz_assign2.exercise_2.Passenger;

/**
 * Created by Lucas on 2016-09-13.
 */
public class Bus extends Vehicle{

    public Bus(Passenger[] passengers)throws IllegalArgumentException{
        //A bus must at least have 1 passenger, the driver. Towing a bus is usually done with a lorry or a vehicle of the same size and therefore goes under lorry.
        if (passengers.length > 20 || passengers.length < 1){
            throw new IllegalArgumentException("A bus can't have more than 20 or less than 1 passengers.");
        }

        this.passengers = passengers;

        //initial fee of 200 + 10 for each passenger
        fee = 200 + 10 * passengers.length;

        //Takes up half the space of a lorry ( = 4 cars), 4 x 5 = 20
        size = 20;
    }
}
