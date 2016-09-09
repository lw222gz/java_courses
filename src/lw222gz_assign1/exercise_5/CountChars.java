package lw222gz_assign1.exercise_5;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


/**
 * Created by Lucas on 2016-08-26.
 */
public class CountChars {

    //test path: "C://Users/Lucas/Github/Java_assignments/LoremIpsum.txt";

    private static BufferedReader fileReader;

    public static void main(String args[]){
        try{
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
        catch(Exception e){
            System.err.println(e.getMessage());
        }
    }

    //reads a .txt file with the given path and presents the wanted statistics
    private static void readFile(Path path) throws IOException {
        //checks that the file exists and that it's not a directory
        if(!Files.exists(path) || Files.isDirectory(path)){
            //if file was not found, throw an exception
            throw new IOException("File was not found at the given path. \nFUNCTION ABORTED!");
        }
        else{
            System.out.println("File found.");
        }

        String line;
        int amountOfBigLetters = 0;
        int amountOfSmallLetters = 0;
        int amountOfWhiteSpace = 0;
        int amountOfNumbers = 0;
        int amountOfOtherCharacters = 0;

        try{
            fileReader = new BufferedReader(new FileReader(path.toString()));

            while(true){

                line = fileReader.readLine();
                if(line == null){
                    fileReader.close();
                    break;
                }


                //loops each char in the current read line
                for(char c : line.toCharArray()){

                    //If and else statements to determine the type of the character.
                    if(Character.isAlphabetic(c)){
                        if(Character.isUpperCase(c)){
                            amountOfBigLetters++;
                        }
                        else{
                            amountOfSmallLetters++;
                        }
                    }
                    else if(Character.isDigit(c)){
                        amountOfNumbers++;
                    }
                    else if(Character.isWhitespace(c)){
                        amountOfWhiteSpace++;
                    }
                    else{
                        amountOfOtherCharacters++;
                    }
                }
            }
        }
        catch (IOException e){
            throw new IOException("An error occurred when trying to read the file.");
        }

        //prints out result read from the given .txt
        System.out.println("In the given text file the following was found:");
        System.out.println("Upper case letters: " + amountOfBigLetters);
        System.out.println("Lower case letters: " + amountOfSmallLetters);
        System.out.println("Whitespace: " + amountOfWhiteSpace);
        System.out.println("Other characters: " + amountOfOtherCharacters);
        System.out.println("Numbers: " + amountOfNumbers);


    }
}
