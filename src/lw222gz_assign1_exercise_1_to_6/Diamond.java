package lw222gz_assign1_exercise_1_to_6;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Created by Lucas on 2016-08-26.
 */
public class Diamond {

    private static Scanner reader = new Scanner(System.in);

    public static void main(String args[]){
        printDiamond(readOddInteger());
    }


    //Takes a positive odd integer as parameter and prints out a diamond with the odd value as max width
    private static void printDiamond(int oddValue){

        int build = 2;
        int whiteSpace = (oddValue - 1) / 2;
        int amountOfStars = 1;
        String row = "";

        //oddValue also represents the amount of rows in the diamond.
        for (int i = 0; i < oddValue; i++){
            //adds whitespace
            for(int j = 0; j < whiteSpace; j ++){
                row += " ";
            }

            //adds stars
            for (int k = 0; k < amountOfStars; k++){
                row += "*";
            }

            //white space is only counted for one side, therefore it's split in 2.
            whiteSpace -= build / 2;

            //amount of stars is 2 per row
            amountOfStars += build;

            //When amount of stars is equal to the given value
            //then the mid point of the diamond has been reached and stars for each row is being reduced.
            if(amountOfStars == oddValue){
                build = -2;
            }

            //prints this row and resets the row value for the next row to be built.
            System.out.println(row);
            row = "";
        }

    }


    //reads and returns a positive odd integer.
    private static Integer readOddInteger(){
        System.out.println("Provide an odd integer:");

        int value;
        while(true){

            try {
                value = reader.nextInt();

                if(value % 2 == 0 || value < 0){
                    throw new IndexOutOfBoundsException("Value must be odd and higher than 0");
                }
                else{
                    break;
                }
            }
            catch (InputMismatchException e){
                System.err.println("Invalid input.");
                reader.next();
            }
            catch (IndexOutOfBoundsException e){
                System.err.println(e.getMessage());
            }

        }

        return value;
    }
}
