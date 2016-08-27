package lw222gz_assign1_exercise_7_to_14;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Lucas on 2016-08-27.
 */
public class CountJava {

    private static String presetPath = null;//"C://Users/Lucas/Github/Java_assignments/src";
    private static Scanner reader = new Scanner(System.in);


    //Using a HashMap would not work as if 2 files in different dirs have the same name the latter one would be overwritten.
    //TODO: Would like to make a JavaFile class, am I allowed?
    private static ArrayList<List> javaFiles = new ArrayList<List>();
    private static ArrayList<String> javaFileNames = new ArrayList<String>();
    private static ArrayList<Integer> javaFileLines = new ArrayList<Integer>();

    //used to read number of lines in a faile
    private static LineNumberReader lnr;

    //private static LinkedHashMap<String, Integer> javaFiles = new LinkedHashMap<String, Integer>();

    public static void main(String args[]){
        //ArrayList position 0 stores the file names, ArrayList position 1 stores the amount of lines for a file
        javaFiles.add(javaFileNames);
        javaFiles.add(javaFileLines);

        try{
            if(presetPath == null){
                System.out.println("Enter path:");
                readFolder(getPathFromUser());
                printResult();
            }
            //if a presetPath is set then that path will be used.
            else{
                System.out.println("Preset path used.");
                readFolder(Paths.get(presetPath));
                printResult();
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


    private static void readFolder(Path path) throws Exception{
        if(!Files.exists(path)){
            throw new FileNotFoundException("Folder was not found.");
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
                        javaFiles.get(1).add(lnr.getLineNumber() + 1); //line counting starts at 0 +1 is added
                        javaFiles.get(0).add(f.getName());
                        lnr.close();
                    }
                    catch (Exception e){
                        throw new Exception("Error occurred when trying to read the java files.");
                    }
                }
            }
        }
    }


    //prints the result from the files read
    private static void printResult(){
        System.out.println("Files found in given root directory and all of the sub-directories: ");
        for(int i = 0; i < javaFiles.get(0).size(); i++){
            System.out.println((i+1) + ". " + javaFiles.get(0).get(i) + "   lines = " + javaFiles.get(1).get(i));
        }
    }
}
