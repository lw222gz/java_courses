package lw222gz_assign1.exercise_9;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

/**
 * Created by Lucas on 2016-08-27.
 */
public class CountJava {
    //test path: "C://Users/Lucas/Github/Java_assignments/src";

    private static ArrayList<File> javaFiles = new ArrayList<File>();

    //used to read number of lines in a file
    private static LineNumberReader lnr;

    public static void main(String args[]){
        try{
            if(args[0].length() > 0){
                System.out.println("Path used: " + args[0]);
                readFolder(Paths.get(args[0]));
                //after all the data has been gathered the result will be printed.
                printResult();
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

    //reads a folder, this method will call itself if it finds a folder within the given @path parameter.
    //If the path is not valid or it does not lead to a folder an exception is thrown.
    private static void readFolder(Path path) throws IOException{
        //checks if folder path exists and if the given path was a folder.
        if(!Files.exists(path)){
            throw new FileNotFoundException("Folder was not found.");
        }
        else if(!Files.isDirectory(path)){
            throw new IOException("Given path was not a folder.");
        }
        else{
            File file = new File(path.toString());

            //list all files in the directory
            File[] files = file.listFiles();

            for(File f : files){
                //If a file is a directory then that directory will also be read.
                if(f.isDirectory()){
                    readFolder(Paths.get(f.getPath()));
                }
                //Checks if file extension is java
                else if(f.getName().substring(f.getName().lastIndexOf('.') + 1).equals("java")){
                    //save file data in the lists.
                    javaFiles.add(f);
                }
            }
        }
    }


    //prints the result from the files read
    private static void printResult(){
        System.out.println("Files found in given root directory and all of the sub-directories: ");

        int counter = 1;

        for(File f: javaFiles){
            System.out.println((counter) + ". " + f.getName() + "   lines = " + readFileRows(f));
            counter++;
        }
    }

    //reads amount of rows in the @file parameter
    private static int readFileRows(File file){
        try{
            lnr = new LineNumberReader(new FileReader(file));
            //Skips to the last line
            //(assuming that file does not have more than 9,223,372,036,854,775,807 amount of rows)
            lnr.skip(Long.MAX_VALUE);

            //LineNumberRead starts counting at 0 so have to add +1 to the amount of rows
            int rows = lnr.getLineNumber() + 1;
            lnr.close();

            return rows;
        }
        catch (Exception e){
            System.err.println("Error occurred when trying to read the amount of lines in the java file: " + file.getName());
        }
        return 0;
    }
}
