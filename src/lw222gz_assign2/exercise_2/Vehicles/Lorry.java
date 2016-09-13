package lw222gz_assign2.exercise_2.Vehicles;

import com.sun.javaws.exceptions.InvalidArgumentException;
import lw222gz_assign2.exercise_2.Passenger;

/**
 * Created by Lucas on 2016-09-13.
 */
public class Lorry extends Vehicle{

    public Lorry(Passenger[] passengers) throws IllegalArgumentException{

        //A lorry must at least have 1 passenger, the driver. And for the sake of simplicity no one can tow a lorry today.
        if(passengers.length > 2 || passengers.length < 1){
            throw new IllegalArgumentException("A lorry can't have more than 2 or less than 1 passengers.");
        }

        this.passengers = passengers;

        //initial fee of 300 + 15 for each passenger
        fee = 300 + this.passengers.length * 15;

        //takes up the space of 2 buses, 2 x 20 = 40;
        size = 40;
    }
}
