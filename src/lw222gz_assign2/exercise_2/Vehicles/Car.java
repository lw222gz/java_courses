package lw222gz_assign2.exercise_2.Vehicles;

import lw222gz_assign2.exercise_2.Passenger;

/**
 * Created by Lucas on 2016-09-13.
 */
public class Car extends Vehicle{

    public Car(Passenger[] passengers)throws IllegalArgumentException{
        //a car can have 0 passengers, someone might be towing a car and only one of the cars have passengers
        if(passengers.length > 4){
            throw new IllegalArgumentException("A car can't have more than 4 passengers.");
        }

        this.passengers = passengers;

        //initial fee of 100 + 15 for each passenger
        fee = 100 + this.passengers.length * 15;

        //car takes 5x amount of space that a bicycle does.
        size = 5;
    }
}
