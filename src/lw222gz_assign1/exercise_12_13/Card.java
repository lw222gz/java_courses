package lw222gz_assign1.exercise_12_13;

public class Card {

    private Suite suite;
    private Rank rank;

    //Creates a new card with a Suite and Rank.
    public Card(Suite s, Rank r){
        this.suite = s;
        this.rank = r;
    }

    //returns the rank enum value of this card
    public Rank getRank(){
        return rank;
    }

    //returns a String representation of this card
    public String toString(){
        return rank.toString() + " of " + suite.toString();
    }

}
