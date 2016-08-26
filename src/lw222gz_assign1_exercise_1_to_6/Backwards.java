package lw222gz_assign1_exercise_1_to_6;
import java.util.Scanner;

/**
 * Created by Lucas on 2016-08-26.
 */
public class Backwards {

    static Scanner reader = new Scanner(System.in);

    public static void main(String args[]){
        System.out.println("Write a line of text: ");
        String str = reader.nextLine();

        String reversed = "";
        for (int i = 0; i < str.length(); i++){
            //-1 is included as str.length() is amount of chars in the string
            //and str.charAt() works as an array and the first value is 0.
            reversed += str.charAt(str.length() - i - 1);
        }
        System.out.println(reversed);


    }
}
