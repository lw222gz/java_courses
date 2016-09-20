package lw222gz_assign2.exercise_5.exercise_5_1;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by Lucas on 2016-09-20.
 */
public class IdentifyWordsMain {

    public static void main(String[] args){
        try{
            if(args[0].length() <= 0){
                throw new IllegalArgumentException("Not a valid path was given as a program parameter.");
            }
            System.out.println("Path used: " + args[0]);
            IdentifyWordsFromFile(Paths.get(args[0]));

        }
        catch(Exception e){
            System.err.println(e.getMessage());
        }
    }


    //Reads a file at the given path, @p, and writes all words from that file into a new file words.txt
    public static void IdentifyWordsFromFile(Path p) throws IOException {
        if(!Files.exists(p) || Files.isDirectory(p)){
            throw new IOException("The file was not found. Please provide a path to a file.");
        }

        System.out.println("File found!");

        try{
            BufferedReader reader = new BufferedReader(new FileReader(p.toString()));
            //creates / overwrites the words.txt file at the location of the given file
            FileWriter writer = new FileWriter(new File(p.toString()).getParentFile().getPath() + "/words.txt");

            String line;
            String wordLine = "";

            //loops the lines from the given file.
            while((line = reader.readLine()) != null){
                //Loops each character in the current read line.
                for(char c : line.toCharArray()) {
                    //If the char is alphabetic or whitespace the char is added to the current word line
                    if (Character.isAlphabetic(c) || Character.isWhitespace(c)) {
                        wordLine += c;
                    }
                }

                //writes a new line
                writer.write(wordLine + "\r\n");
                wordLine = "";
            }

            //Close reader and writer
            reader.close();
            writer.close();

        }
        catch(Exception e){
            throw new IOException("Something went wrong when reading the file");
        }
    }
}
