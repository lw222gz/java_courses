package lw222gz_assign1_exercise_1_to_6;
import java.io.BufferedReader;
import java.io.FileReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

/**
 * Created by Lucas on 2016-08-26.
 */
public class CountChars {

    //change this string to wanted path for file to read.
    //set to null if you want the app to ask for a path.
    private static final String presetPath = null;//"C://Users/Lucas/Github/Java_assignments/LoremIpsum.txt";

    private static BufferedReader fileReader;
    private static Scanner reader = new Scanner(System.in);

    public static void main(String args[]){

        //if a presetPath is not set then the user will be requested to enter a path
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

    //reads a .txt file with the given path and presents the wanted statistics
    private static void readFile(Path path){
        if(!Files.exists(path)){
            System.out.println("Given file path was not found. \nFUNCTION ABORTED!");
            return;
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
                    reader.close();
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
        catch (Exception e){
            e.printStackTrace();
        }

        //displays stats from the given .txt file.
        System.out.println("In the given text file the following was found:");
        System.out.println("Upper case letters: " + amountOfBigLetters);
        System.out.println("Lower case letters: " + amountOfSmallLetters);
        System.out.println("Whitespace: " + amountOfWhiteSpace);
        System.out.println("Other characters: " + amountOfOtherCharacters);
        System.out.println("Numbers: " + amountOfNumbers);


    }
}
