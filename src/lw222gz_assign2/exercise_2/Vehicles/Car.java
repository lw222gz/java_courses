package lw222gz_assign2.exercise_2.Vehicles;


/**
 * Created by Lucas on 2016-09-13.
 */
public class Car extends Vehicle{


    public Car(int amountOfPassengers)throws IllegalArgumentException{
        super(1, 100, amountOfPassengers, 15);
        //a car can have 0 passengers, someone might be towing a car and only one of the cars have passengers
        if(amountOfPassengers > 4){
            throw new IllegalArgumentException("A car can't have more than 4 passengers.");
        }
        //initial fee of 100 + 15 for each passenger
        //fee = 100;

        //car takes 5x amount of space that a bicycle does.
        //size = 5;
    }
}
