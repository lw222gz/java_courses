package lw222gz_assign2.exercise_2;

import lw222gz_assign2.exercise_2.Vehicles.*;

import java.beans.VetoableChangeListener;
import java.util.Iterator;

/**
 * Created by Lucas on 2016-09-14.
 */
public class FerryMain {

    public static void main(String args[]){
        Ferry ferry = new Ferry();

        //Test 1
        System.out.println("\nTest 1: Creating a vehicle object each type.");
        Vehicle a = new Bicycle();
        Vehicle b = new Car(2);
        Vehicle c = new Bus(10);
        Vehicle d = new Lorry(2);

        //Test 1.1 - should throw an error
        System.out.println("\nTest 1.1: Create a vehicle object of each type and add incorrect parameter values.");
        //1.1 car
        System.out.println("Car object:");
        try{
            b = new Car(5);
            System.out.println("Test failed. Car object created with too many passengers.");
        }
        catch (Exception e){
            System.out.println("Test successful!");
        }
        //1.1 bus
        System.out.println("bus object:");
        try{
            c = new Bus(-1);
            System.out.println("Test failed. Bus object created with too few passengers.");
        }
        catch (Exception e){
            System.out.println("Test successful!");
        }
        //1.1 lorry
        System.out.println("Lorry object:");
        try{
            d = new Lorry(3);
            System.out.println("Test failed. Lorry object created with too many passengers.");
        }
        catch (Exception e){
            System.out.println("Test successful!");
        }

        //Test 2
        System.out.println("\nTest 2: Adding one of each vehicle to the ferry.");
        a = new Bicycle();
        b = new Car(2);
        c = new Bus(10);
        d = new Lorry(2);

        ferry.embark(a);
        ferry.embark(b);
        ferry.embark(c);
        ferry.embark(d);

        System.out.println(ferry);

        //Test 2.1
        System.out.println("\nTest 2.1: Adding a passenger to the ferry (with no vehicle).");
        Passenger p = new Passenger();
        ferry.embark(p);
        System.out.println(ferry);



        //Test 2.2
        System.out.println("\nTest 2.2: Try to add a vehicle that has already boarded. This should give an error message and not board the vehicle.");
        ferry.embark(c);
        System.out.println(ferry);

        //Test 2.3
        System.out.println("\nTest 2.3: Trying to overload the space in the ferry.");
        ferry.embark(new Lorry(2));
        ferry.embark(new Lorry(2));
        ferry.embark(new Lorry(2));
        ferry.embark(new Lorry(2));
        System.out.println(ferry);
        ferry.embark(new Bus(20));
        System.out.println(ferry);

        //Test 3
        System.out.println("\nTest 3: disembark, clear the ferry, keep the income.");
        ferry.disembark();
        System.out.println(ferry);

        //Test 4
        System.out.println("\nTest 4: testing to add 201 bicycles to the ferry, the last one should not fit.");
        for(int i = 0; i < 201; i++){
            ferry.embark(new Bicycle());
        }
        System.out.println(ferry);

        //Test 5
        System.out.println("\nTest 5: testing to add 200 passengers to an empty ferry.");
        ferry.disembark();
        for(int i = 0; i < 201; i++){
            ferry.embark(new Passenger());
        }
        System.out.println(ferry);

        //Test 6
        System.out.println("\nTest 6: testing the iterator to iterate a couple of objects.");
        //empty ferry
        ferry.disembark();

        ferry.embark(new Car(4));
        ferry.embark(new Car(1));
        ferry.embark(new Car(0));
        ferry.embark(new Bicycle());
        ferry.embark(new Bus(16));
        ferry.embark(new Lorry(1));
        Iterator<Vehicle> it = ferry.iterator();

        System.out.println("Prints out the amount of passengers in each vehicle. Should be 4, 1, 0, 1, 16, 1");
        while(it.hasNext()){
            System.out.println(it.next().getPassengers().length);
        }



    }
}
