package lw222gz_assign1_exercise_1_to_6;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Created by Lucas on 2016-08-26.
 */
public class LargestK {

    static Scanner reader = new Scanner(System.in);

    public static void main(String args[]){
        System.out.println("Enter a positive integer: ");

        int n = readInteger();

        //represents the k value that is being calculated.
        int k = 0;

        //represents the total value, this may not be higher than the value n
        int sum = 0;

        //Loops to calculate the k value.
        while(true){

            sum += k;
            if(sum + k + 2 > n){
                break;
            }
            k += 2;
        }

        System.out.println("K = " + k);

    }

    //reads an integer from the user and returns that value. Integer read is required to be positive.
    public static int readInteger(){
        int value;

        while(true){

            try {
                value = reader.nextInt();

                if(value < 0){
                    throw new IndexOutOfBoundsException("Value may not be under 0.");
                }
                else{
                    break;
                }
            }
            catch (InputMismatchException e){
                System.out.println("Invalid input.");
                reader.next();
            }
            catch (IndexOutOfBoundsException e){
                System.out.println(e.getMessage());
            }

        }

        return value;
    }
}
