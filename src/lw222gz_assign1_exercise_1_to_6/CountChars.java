package lw222gz_assign1_exercise_1_to_6;
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

                    //through testing .getType returns certain integers depending on the character.
                    // Ex. big letters always returns 1, small letters return 2, numbers returns 9, whitespace returns 12
                    // and other random characters like !,",§,½ etc. returns a set integer to that character.
                    switch (Character.getType(c)){

                        //big letter
                        case 1:
                            amountOfBigLetters++;
                            break;

                        //small letter
                        case 2:
                            amountOfSmallLetters++;
                            break;

                        //number
                        case 9:
                            amountOfNumbers++;
                            break;

                        //whitespace
                        case 12:
                            amountOfWhiteSpace++;
                            break;

                        //other character
                        default:
                            amountOfOtherCharacters++;
                            break;
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
