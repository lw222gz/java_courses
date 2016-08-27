package lw222gz_assign1_exercise_7_to_14.exercise_12_13;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by Lucas on 2016-08-27.
 */

public class Deck {

    private ArrayList<Card> cards = new ArrayList<Card>();

    //Initiates a new deck with 52 cards. One of each kind of combination between suit and rank.
    public Deck(){
        for(Suite s : Suite.values()){
            for(Rank r: Rank.values()){
                cards.add(new Card(s, r));
            }
        }
    }

    //Shuffles the deck of cards if it contains 52 cards.
    public void shuffle() throws IllegalStateException{
        if(cards.size() < 52){
            throw new IllegalStateException("The deck must contain 52 cards to be abel to shuffle, right now it only contains: " + cards.size());
        }
        else{
            Collections.shuffle(cards);
        }
    }

    //returns an integer representing the current size of the deck.
    public int getDeckSize(){
        return cards.size();
    }

    //Returns the top card form the deck and removes it from the cards ArrayList
    public Card handOutNextCard(){
        Card c = cards.get(0);
        cards.remove(0);
        return c;
    }
}
