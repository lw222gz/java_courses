package lw222gz_assign1_exercise_7_to_14.exercise_8;

/**
 * Created by Lucas on 2016-09-02.
 */
public class Interval {

    //a static integer that will represent the highest interval value set.
    private static int highestValue = 0;

    private int low;
    private int high;
    private int count = 0;

    //initiates an interval,
    //if @high value is less than @low an error is thrown
    //if @high value is lager than @highestValue then it will overwrite that value to @highestValue
    public Interval(int low, int high) throws IllegalArgumentException {
        if (low >= high){
            throw new IllegalArgumentException("The second parameter value MUST be higher than the first value.");
        }

        this.low = low;
        this.high = high;

        if(this.high > highestValue){
            highestValue = this.high;
        }
    }


    //returns the highest interval value set.
    public static int getHighestIntervalValue(){
        return highestValue;
    }


    //returns the lowest value allowed in this interval.
    public int getLow(){
        return this.low;
    }

    //returns the highest value allowed in this interval
    public int getHigh(){
        return this.high;
    }

    //returns amount of numbers found in this interval
    public int getCount(){
        return count;
    }


    //returns true if @value is within the values of this interval object
    public boolean isWithinInterval(int value){
        if(value >= this.low && value <= this.high){
            return true;
        }
        return false;
    }

    //adds to the counter of numbers found in this interval.
    public void addCount(){
        count++;
    }
}
