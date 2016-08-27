package lw222gz_assign1_exercise_1_to_6;
import static lw222gz_assign1_exercise_1_to_6.LargestK.readInteger;

/**
 * Created by Lucas on 2016-08-26.
 */


public class CountDigits {

    public static void main(String args[]){

        System.out.println("Enter a positive integer:");

        //using same method in LargestK exercise since they share they same requirements.
        int value = readInteger();

        //parse the integer to a string to easily split up the values.
        String valueAsString = Integer.toString(value);


        int amountOfZeroes = 0;
        int amountOfOdds = 0;
        int amountOfEvens = 0;
        int sum = 0;


        //loops each character in the string
        for(int i = 0; i < valueAsString.length(); i++){

            int number = Character.getNumericValue(valueAsString.charAt(i));

            if(number == 0){
                amountOfZeroes += 1;
            }
            else if(number % 2 == 0){
                amountOfEvens += 1;
            }
            else {
                amountOfOdds += 1;
            }

            sum += number;
        }

        System.out.println("Zeroes: " + amountOfZeroes);
        System.out.println("Odd: " + amountOfOdds);
        System.out.println("Even: " + amountOfEvens);
        System.out.println("Sum: " + sum);

    }
}
