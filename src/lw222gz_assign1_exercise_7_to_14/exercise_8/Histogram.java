package lw222gz_assign1_exercise_7_to_14.exercise_8;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;


/**
 * Created by Lucas on 2016-08-26.
 */
public class Histogram {

    //test path: "C://Users/Lucas/Github/Java_assignments/integers.dat";

    //ArrayList that will contain all of the numbers read
    private static ArrayList<Integer> numbers = new ArrayList<Integer>();

    //ArrayList that will contain all of the intervals
    private static ArrayList<Interval> intervals = new ArrayList<Interval>();

    public static void main(String args[]){

        try{
            //set all intervals
            intervals.add(new Interval(1, 10));
            intervals.add(new Interval(11, 20));
            intervals.add(new Interval(21, 30));
            intervals.add(new Interval(31, 40));
            intervals.add(new Interval(41, 50));
            intervals.add(new Interval(51, 60));
            intervals.add(new Interval(61, 70));
            intervals.add(new Interval(71, 80));
            intervals.add(new Interval(81, 90));
            intervals.add(new Interval(91, 100));
            intervals.add(new Interval(101, 200));

            if(args[0].length() > 0){
                System.out.println("Path used: " + args[0]);
                readFile(Paths.get(args[0]));
            }
            else{
                throw new IllegalArgumentException("The path was not valid.");
            }
        }
        catch(ArrayIndexOutOfBoundsException e){
            System.err.println("Argument to main was not found. Please provide a Path parameter to the program.");
        }
        catch (Exception e){
            System.err.println(e.getMessage());
        }
    }

    //reads the file located at @path and displays the wanted statistics
    private static void readFile(Path path) throws IOException{
        if(!Files.exists(path)){
            throw new FileNotFoundException("File was not found.");
        }
        else if(Files.isDirectory(path)){
            throw new IOException("The given path can NOT lead to a folder. It must be a specific file.");
        }
        else{


            BufferedReader fileReader = new BufferedReader(new FileReader(path.toString()));
            String line = "";

            while(true) {

                line = fileReader.readLine();
                if (line == null) {
                    fileReader.close();
                    break;
                }
                try{
                    //add a value to the numbers ArrayList, if the line is not parsable an error is thrown.
                    numbers.add(Integer.parseInt(line));
                }
                catch (NumberFormatException e){
                    //throw a new exception to be abel to more clearly display an error message.
                    throw new NumberFormatException("The file contains data that was not parsable. " +
                            "\nPlease make sure the given file only contains numeric values." +
                            "\nThe following was not parsable  " + e.getMessage());

                }

            }
        }


        //Sort the ArrayList so when a number higher than 200 is noticed then the loop can be aborted.
        Collections.sort(numbers);

        int amountBelowHundred = 0;
        int amountAboveHundred = 0;

        for(int i : numbers){
            //since the list is sorted, when i exceeds the highest interval value set, the loop can break.
            if(i > Interval.getHighestIntervalValue()){
                break;
            }

            for(Interval interval: intervals){
                //if the number is within the interval then it's count is increased and the loop is broken.
                if(interval.isWithinInterval(i)){
                    //adds to the interval count
                    interval.addCount();

                    //Counts the values within the 2 big intervals
                    if(i <= 100){
                        amountBelowHundred++;
                    }
                    else if(i <= Interval.getHighestIntervalValue()){
                        amountAboveHundred++;
                    }
                    break;
                }
            }
        }

        //prints out the 2 big intervals
        System.out.println("Number of integers in the interval [1,100]: "+ amountBelowHundred +
                            "\nNumber of integers in the interval [101," + Interval.getHighestIntervalValue() + "]: " + amountAboveHundred);

        //loops out and prints the histogram
        for(Interval interval: intervals){
            System.out.println(interval.getLow() + " - " + interval.getHigh() + " : " + getStarsEqualToInt(interval.getCount()));
        }

    }


    //returns a string with as many '*' equal to the @amount parameter.
    private static String getStarsEqualToInt(int amount){
        String str = "";
        for(int i = 0; i < amount; i++){
            str += "*";
        }
        return str;
    }
}
