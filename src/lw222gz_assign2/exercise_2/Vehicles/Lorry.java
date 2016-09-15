package lw222gz_assign2.exercise_2.Vehicles;


/**
 * Created by Lucas on 2016-09-13.
 */
public class Lorry extends Vehicle{

    public Lorry(int amountOfPassengers) throws IllegalArgumentException{
        super(8, 300, amountOfPassengers, 15);

        if(passengers.length > 2){
            throw new IllegalArgumentException("A lorry can't have more than 2 passengers.");
        }
    }
}
