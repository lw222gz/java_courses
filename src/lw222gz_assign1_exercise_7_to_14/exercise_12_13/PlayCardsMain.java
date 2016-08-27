package lw222gz_assign1_exercise_7_to_14.exercise_12_13;

/**
 * Created by Lucas on 2016-08-27.
 */
public class PlayCardsMain {

    public static void main(String args[]){

        try{
            //create a new deck and shuffles it.
            Deck d = new Deck();
            d.shuffle();

            //Prints out deck size after just being created to verify it contains 52 cards.
            System.out.println(d.getDeckSize());

            //deals the top 10 cards.
            for(int i = 0; i < 10; i++){
                System.out.println(d.handOutNextCard() + " was drawn");
                System.out.println(d.getDeckSize() + " cards are left in the deck.");
            }

            //will throw an error since the entire deck has been dealt
            d.shuffle();
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }


    }
}
