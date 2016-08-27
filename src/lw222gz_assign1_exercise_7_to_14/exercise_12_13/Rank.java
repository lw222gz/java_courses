package lw222gz_assign1_exercise_7_to_14.exercise_12_13;

/**
 * Created by Lucas on 2016-08-27.
 */

public enum Rank{
    Ace(1),
    Two(2),
    Three(3),
    Four(4),
    Five(5),
    Six(6),
    Seven(7),
    Eight(8),
    Nine(9),
    Ten(10),
    Knight(11),
    Queen(12),
    King(13);

    private int value;

    Rank(int value){
        this.value = value;
    }

    public int getRankValue(){
        return this.value;
    }
}
