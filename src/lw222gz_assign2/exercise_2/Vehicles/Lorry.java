package lw222gz_assign2.exercise_2.Vehicles;

import com.sun.javaws.exceptions.InvalidArgumentException;
import lw222gz_assign2.exercise_2.Passenger;

/**
 * Created by Lucas on 2016-09-13.
 */
public class Lorry extends Vehicle{

    public Lorry(int amountOfPassengers) throws IllegalArgumentException{
        super(8, 300, amountOfPassengers, 15);
        //A lorry must at least have 1 passenger, the driver. And for the sake of simplicity no one can tow a lorry today.
        if(passengers.length > 2 || passengers.length < 1){
            throw new IllegalArgumentException("A lorry can't have more than 2 or less than 1 passengers.");
        }
    }
}
