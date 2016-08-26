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
    private static String presetPath = "C://Users/Lucas/Github/Java_assignments/integers.dat";
    private static Scanner reader = new Scanner(System.in);

    private static ArrayList<Integer> numbers = new ArrayList<Integer>();


    public static void main(String args[]){
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
        if(Files.exists(path)){

            BufferedReader fileReader = new BufferedReader(new FileReader(path.toString()));
            String line = "";

            while(true) {

                line = fileReader.readLine();
                if (line == null) {
                    reader.close();
                    break;
                }
                try{
                    numbers.add(Integer.parseInt(line));
                }
                catch (NumberFormatException e){
                    //I throw a new exception to be abel to more clearly display an error message.
                    throw new NumberFormatException("The file contains data that was not parse able. " +
                            "\nPlease make sure the given file only contains numeric values." +
                            "\nThe following was not parse able " + e.getMessage());

                }

            }
        }
        else{
            throw new FileNotFoundException("File was not found.");
        }



        //TODO: the following is shit code that could use some refactoring.
        Collections.sort(numbers);

        int currentMinInterval = 1;
        int currentMaxInterval = 10;
        int currentIntervalAmount = 0;

        LinkedHashMap<String, Integer> histogram = new LinkedHashMap<String, Integer>();

        //loops read values from file and prints the statistics.
        for(int i = 0; i < numbers.size(); i++){

            //The array list is sorted so when a value has a
            //higher value than 200 then there is no need to collect anymore statistics
            if(numbers.get(i) > 200 && currentMaxInterval >= 200){
                break;
            }
            //if a number is below 0 then that loop iteration is skipped.
            if(numbers.get(i) < 0){
                continue;
            }

            if(numbers.get(i) >= currentMinInterval && numbers.get(i) <= currentMaxInterval){
                currentIntervalAmount++;
            }
            else{
                while(true){
                    histogram.put(currentMinInterval + " - " + currentMaxInterval + " | ", currentIntervalAmount);
                    //sets a new interval
                    currentMinInterval += 10;
                    currentMaxInterval += 10;
                    currentIntervalAmount = 0;

                    if(currentMaxInterval >= 110){
                        currentMaxInterval = 200;
                    }



                    if(numbers.get(i) >= currentMinInterval && numbers.get(i) <= currentMaxInterval){
                        currentIntervalAmount++;
                        break;
                    }
                    if(numbers.get(i) > 200){
                        break;
                    }



                }
            }
        }


        histogram.put(currentMinInterval + " - " + currentMaxInterval + " | ", currentIntervalAmount);

        //TODO: fix ugly string dependency
        String uglyDependency = "101" + " - " + "200" + " | ";
        int amountBelowHundredOne = 0;
        for(Map.Entry<String, Integer> entry: histogram.entrySet()){
            if(entry.getKey() != uglyDependency){
                amountBelowHundredOne += entry.getValue();
            }
        }
        if(histogram.containsKey(uglyDependency)){
            System.out.println("Number of integers in the interval [1,100]: " + (amountBelowHundredOne - histogram.get(uglyDependency)));
            System.out.println("Number of integers in the interval [101, 200]: " + histogram.get(uglyDependency));
        }
        else{
            System.out.println("Number of integers in the interval [1,100]: " + amountBelowHundredOne);
        }

        for(Map.Entry<String, Integer> entry: histogram.entrySet()){
            System.out.println(entry.getKey() + getStarsEqualToInt(entry.getValue()));
        }
        //prints out last iteration of the loop.
        //System.out.println(currentMinInterval + " - " + currentMaxInterval + " | " + currentIntervalAmount);

    }


    private static String getStarsEqualToInt(int amount){
        String str = "";
        for(int i = 0; i < amount; i++){
            str += "*";
        }
        return str;
    }
}
