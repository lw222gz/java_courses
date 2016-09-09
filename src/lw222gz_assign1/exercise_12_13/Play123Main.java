package lw222gz_assign1.exercise_12_13;

/**
 * Created by Lucas on 2016-08-27.
 */
public class Play123Main {

    private static Deck d;

    public static void main(String args[]){
        int roundsWon = 0;
        int roundsToPlay = 10000;

        for(int i = 0; i < roundsToPlay; i++){
            if(PlayGame()){
                roundsWon++;
            }
        }

        System.out.println((float)roundsWon / (float)roundsToPlay + "% of the " + roundsToPlay + " rounds resulted in a win.");
    }


    //returns true if the round was won, otherwise false.
    private static boolean PlayGame(){
        d = new Deck();
        d.shuffle();

        //starts count at 1 at the begining of each game.
        int currentCount = 1;

        for(int j = 0; j < 52; j++){
            //if the current card has the same value as the current count then the round
            //was lost and false is returned.
            if(d.handOutNextCard().getRank().getRankValue() == currentCount){
                return false;
            }

            if(currentCount == 3){
                currentCount = 1;
            }
            else {
                currentCount++;
            }
        }


        return true;
    }
}
