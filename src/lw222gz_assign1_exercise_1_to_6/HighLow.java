package lw222gz_assign1_exercise_1_to_6;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

/**
 * Created by Lucas on 2016-08-26.
 */
public class HighLow {

    private static final int MAX_AMOUNT_OF_GUESSES = 10;
    private static int playerGuesses;
    private static int secretNumber;
    static Random rand = new Random();
    static Scanner reader = new Scanner(System.in);

    public static void main(String args[]){

        //game loop
        while(true){
            //initiate a game and a secret number
            startGame();

            //runs the game and method will return true if the player won.
            if(playGame()){
                System.out.println("YOU WON! It took you " + playerGuesses + " guesses.");
            }
            else{
                System.out.println("You lost, the correct number was " + secretNumber);
            }

            //if the player wants to play again the loop will continue, otherwise it will break
            System.out.println("Enter 'Y' if you wish to restart, any other key will close.");
            if(playerWantsToRestart()){
                break;
            }

        }

    }

    //initiates a new game with a new secret number and resets player guesses.
    private static void startGame(){
        secretNumber = rand.nextInt(100 + 1);
        playerGuesses = 0;
        System.out.println("A random number between 1-100 has been generated, make a guess!");
    }

    //returns true if the player won, otherwise false. Also displays hints to the player
    private static boolean playGame(){

        for(int i = 0; i < MAX_AMOUNT_OF_GUESSES; i++){
            playerGuesses++;
            int guess = readInteger(0, 100);

            if(guess == secretNumber){
                return true;
            }
            else if(guess < secretNumber){
                System.out.println("Hint: Higher");
            }
            else{
                System.out.println("Hint: Lower");
            }
        }

        return false;
    }

    //reads an integer between the given parameters min and max.
    private static int readInteger(int min, int max){
        int value;

        while(true){

            try {
                value = reader.nextInt();

                if(value < min || value > max){
                    throw new IndexOutOfBoundsException("Value may not be under 0 or higher than 100.");
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

    //returns true if the player wants to keep playing, otherwise false.
    private static boolean playerWantsToRestart(){
        reader.next();
        if(reader.nextLine().toUpperCase().equals("Y")){
            return true;
        }
        return false;
    }
}
