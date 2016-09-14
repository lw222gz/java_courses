package lw222gz_assign2.exercise_2;

/**
 * Created by Lucas on 2016-09-13.
 */
public class Passenger {
    private int passengerFee;

    //default constructor with the defualt cost of 20. This is for passengers with no vehicle.
    public Passenger(){ this(20); }

    public Passenger(int passengerFee){
        this.passengerFee = passengerFee;
    }

    public int getPassengerFee(){
        return passengerFee;
    }
}
