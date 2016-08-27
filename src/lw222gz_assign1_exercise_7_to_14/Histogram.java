package lw222gz_assign1_exercise_7_to_14;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;


/**
 * Created by Lucas on 2016-08-26.
 */
public class Histogram {

    //set this to null to have user input own path. Faster testing to have a preset path.
    private static String presetPath = null;//"C://Users/Lucas/Github/Java_assignments/integers.dat";
    private static Scanner reader = new Scanner(System.in);

    private static ArrayList<Integer> numbers = new ArrayList<Integer>();

    //TODO: Would like to make a Interval class, am I allowed?
    private static final String INTERVAL_ID_ONE = "1 - 10   ";
    private static final String INTERVAL_ID_TWO = "11 - 20  ";
    private static final String INTERVAL_ID_THREE = "21 - 30  ";
    private static final String INTERVAL_ID_FOUR = "31 - 40  ";
    private static final String INTERVAL_ID_FIVE = "41 - 50  ";
    private static final String INTERVAL_ID_SIX = "51 - 60  ";
    private static final String INTERVAL_ID_SEVEN = "61 - 70  ";
    private static final String INTERVAL_ID_EIGHT = "71 - 80  ";
    private static final String INTERVAL_ID_NINE = "81 - 90  ";
    private static final String INTERVAL_ID_TEN = "91 - 100 ";
    private static final String INTERVAL_ID_ELEVEN = "101 - 200";
    //LinkedHashMap contaning all intervals as strings and
    private static LinkedHashMap<String, Integer> histogram = new LinkedHashMap<String, Integer>();


    public static void main(String args[]){
        //adds all intervals to the LinkedHashMap and sets their value to 0.
        histogram.put(INTERVAL_ID_ONE, 0);
        histogram.put(INTERVAL_ID_TWO, 0);
        histogram.put(INTERVAL_ID_THREE, 0);
        histogram.put(INTERVAL_ID_FOUR, 0);
        histogram.put(INTERVAL_ID_FIVE, 0);
        histogram.put(INTERVAL_ID_SIX, 0);
        histogram.put(INTERVAL_ID_SEVEN, 0);
        histogram.put(INTERVAL_ID_EIGHT, 0);
        histogram.put(INTERVAL_ID_NINE, 0);
        histogram.put(INTERVAL_ID_TEN, 0);
        histogram.put(INTERVAL_ID_ELEVEN, 0);

        try{
            if(presetPath == null){
                System.out.println("Enter path:");
                readFile(getPathFromUser());
            }
            //if a presetPath is set then that path will be used.
            else{
                System.out.println("Preset path used.");
                Path path = Paths.get(presetPath);

                readFile(path);
            }
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    //reads a file path from the user, the file path can not only be whitespace.
    private static Path getPathFromUser(){
        String str = "";
        while(true){
            str = reader.nextLine();
            if(str.trim().length() > 0){
                break;
            }
            System.out.println("Please give a path input.");
        }

        return Paths.get(str);
    }

    //reads the file located at @path and displays the wanted statistics
    private static void readFile(Path path) throws IOException{
        if(!Files.exists(path)){
            throw new FileNotFoundException("File was not found.");
        }
        else{

            BufferedReader fileReader = new BufferedReader(new FileReader(path.toString()));
            String line = "";

            while(true) {

                line = fileReader.readLine();
                if (line == null) {
                    reader.close();
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

        //loop that sorts all numbers and adds to the counter in which interval the number is located in
        for(int i : numbers){
            if(i >= 1 && i <= 10){
                histogram.put(INTERVAL_ID_ONE, histogram.get(INTERVAL_ID_ONE) + 1);
            }
            else if(i >= 11 && i <= 20){
                histogram.put(INTERVAL_ID_TWO, histogram.get(INTERVAL_ID_TWO) + 1);
            }
            else if(i >= 21 && i <= 30){
                histogram.put(INTERVAL_ID_THREE, histogram.get(INTERVAL_ID_THREE) + 1);
            }
            else if(i >= 31 && i <= 40){
                histogram.put(INTERVAL_ID_FOUR, histogram.get(INTERVAL_ID_FOUR) + 1);
            }
            else if(i >= 41 && i <= 50){
                histogram.put(INTERVAL_ID_FIVE, histogram.get(INTERVAL_ID_FIVE) + 1);
            }
            else if(i >= 51 && i <= 60){
                histogram.put(INTERVAL_ID_SIX, histogram.get(INTERVAL_ID_SIX) + 1);
            }
            else if(i >= 61 && i <= 70){
                histogram.put(INTERVAL_ID_SEVEN, histogram.get(INTERVAL_ID_SEVEN) + 1);
            }
            else if(i >= 71 && i <= 80){
                histogram.put(INTERVAL_ID_EIGHT, histogram.get(INTERVAL_ID_EIGHT) + 1);
            }
            else if(i >= 81 && i <= 90){
                histogram.put(INTERVAL_ID_NINE, histogram.get(INTERVAL_ID_NINE) + 1);
            }
            else if(i >= 91 && i <= 100){
                histogram.put(INTERVAL_ID_TEN, histogram.get(INTERVAL_ID_TEN) + 1);
            }
            else if(i >= 101 && i <= 200){
                histogram.put(INTERVAL_ID_ELEVEN, histogram.get(INTERVAL_ID_ELEVEN) + 1);
            }
            else if (i > 200){
                break;
            }

        }

        //loop that adds together all of the values in the LinkedMap.
        int allValues = 0;
        for(Map.Entry<String, Integer> entry: histogram.entrySet()){
            allValues += entry.getValue();
        }
        System.out.println("Number of integers in the interval [1, 100]: " + (allValues - histogram.get(INTERVAL_ID_ELEVEN)));
        System.out.println("Number of integers in the interval [101, 200]: " + histogram.get(INTERVAL_ID_ELEVEN));

        //prints out the histogram.
        for(Map.Entry<String, Integer> entry: histogram.entrySet()){
            System.out.println(entry.getKey() + " | " + getStarsEqualToInt(entry.getValue()));
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
