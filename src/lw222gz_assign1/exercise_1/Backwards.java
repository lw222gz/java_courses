package lw222gz_assign1.exercise_1;
import java.util.Scanner;

/**
 * Created by Lucas on 2016-08-26.
 */
public class Backwards {

    private static Scanner reader = new Scanner(System.in);

    public static void main(String args[]){
        System.out.println("Write a line of text: ");
        //prints out reversed string
        System.out.println("This is your text reversed: \n" + new StringBuilder(reader.nextLine()).reverse().toString());
    }
}
