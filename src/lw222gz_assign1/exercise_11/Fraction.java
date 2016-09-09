package lw222gz_assign1.exercise_11;

/**
 * Created by Lucas on 2016-08-27.
 */
public class Fraction {

    private int numerator;
    private int denominator;

    public Fraction(int n, int d) throws IllegalArgumentException{
        if(d == 0){
            throw new IllegalArgumentException("FRACTION INITIATION ERROR!\nA fraction can not have a denominator that is equal to 0.");
        }
        numerator = n;
        denominator = d;
    }

    //returns numerator
    public int getNumerator(){
        return numerator;
    }

    //returns denominator
    public int getDenominator(){
        return denominator;
    }

    //returns a string representation of this fraction.
    public String toString(){
        return numerator / getGCD(numerator, denominator) + "/" + denominator / getGCD(numerator, denominator);
    }

    //checks if this Fraction object is negative, if it is then true is returned.
    public boolean isNegative(){
        if((numerator < 0 || denominator < 0) && (numerator > 0 || denominator > 0)){
            return true;
        }
        return false;
    }

    //adds this Fraction object with the values of param Fraction object @f and returns a
    //new Fraction object representing the result
    //Formula: x1/x2 + y1/y2 = (x1*y2 + y1*x2) / (x2*y2)
    public Fraction add(Fraction f){
        return new Fraction(this.numerator * f.denominator + f.numerator * this.denominator,
                            this.denominator * f.denominator);
    }

    //multiplies this Fraction object with the values of param Fraction object @f and returns a
    //new Fraction object representing the result
    //Formula: x1/x2 * y1/y2 = x1*y1 / x2*y2
    public Fraction multiply(Fraction f){
        return new Fraction(this.numerator * f.numerator,
                            this.denominator * f.denominator);
    }

    //divides this Fraction object with the values of param Fraction object @f and returns a
    //new Fraction object representing the result
    //Formula: x1/x2 ÷ y1/y2 = (x1 * y2) / (x2 * y1)
    public Fraction divide(Fraction f){
        return new Fraction(this.numerator * f.denominator,
                            this.denominator * f.numerator);
    }


    //Check if this Fraction object is equal in value to the Fraction param @f object.
    //If they are equal true is returned, otherwise false.
    public boolean isEqualTo(Fraction f){
        return this.numerator * f.denominator == f.numerator * this.denominator;
    }

    //returns the greatest common divisor(GCD) between x and y
    public static int getGCD(int x, int y) {
        while (y != 0) {
            int temp = y;
            y = x % y;
            x = temp;
        }
        return x;
    }



}
