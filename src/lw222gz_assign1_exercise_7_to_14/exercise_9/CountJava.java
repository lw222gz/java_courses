package lw222gz_assign1_exercise_7_to_14.exercise_9;
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

    //Using a HashMap would not work as if 2 files in different dirs have the same name one would be overwritten by the other.
    //Therefore I created a class, JavaFile, to store the data.
    private static ArrayList<JavaFile> javaFiles = new ArrayList<JavaFile>();

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
            // && !(Files.isDirectory(path))
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

                    try{
                        lnr = new LineNumberReader(new FileReader(f));
                        //Skips to the last line
                        lnr.skip(Long.MAX_VALUE);

                        //save file data in the lists.
                        javaFiles.add(new JavaFile(f.getName(), lnr.getLineNumber() + 1));
                        //javaFiles.get(1).add(lnr.getLineNumber() + 1); //line counting starts at 0 +1 is added
                        //javaFiles.get(0).add(f.getName());
                        lnr.close();
                    }
                    catch (Exception e){
                        throw new IOException("Error occurred when trying to read the java files.");
                    }
                }
            }
        }
    }


    //prints the result from the files read
    private static void printResult(){
        System.out.println("Files found in given root directory and all of the sub-directories: ");

        int rowSum = 0;
        int counter = 1;

        for(JavaFile jf: javaFiles){
            System.out.println((counter) + ". " + jf.getName() + "   lines = " + jf.getRows());

            rowSum += jf.getRows();
            counter++;
        }

        System.out.println("Total amount of lines : " + rowSum);
    }
}
