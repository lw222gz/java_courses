package lw222gz_assign1_exercise_7_to_14.exercise_10;

/**
 * Created by Lucas on 2016-08-27.
 */
public class Point {

    private int x;
    private int y;

    //Calls second constructor with preset value 0 and 0
    public Point(){
        this(0,0);
    }

    //initiates a new point with a x and y value
    public Point(int x, int y){
        this.x = x;
        this.y = y;
    }

    //returns a String representing this Point objects value.
    public String toString(){
        return "(" + x + "," + y + ")";
    }

    //Compares @p with this objects values, returns true if they are equal.
    public boolean isEqualTo(Point p){
        if(x == p.x && y == p.y){
            return true;
        }
        return false;
    }

    //calculates the distance between this Point object and param Point object @p
    //Formula: Sqrt( (x1-x2)^2 + (y1-y2)^2 )
    public double distanceTo(Point p){
        return (Math.sqrt( Math.pow(this.x - p.x, 2) + Math.pow(this.y - p.y, 2) ));
    }

    //Moves this Point objects x and y values depending on values of param @x and @y values
    public void move(int x, int y){
        this.x += x;
        this.y += y;
    }

    //Moves this Point objects x and y values to the point of param @x and @y values.
    public void moveToXY(int x, int y){
        this.x = x;
        this.y = y;
    }

}
