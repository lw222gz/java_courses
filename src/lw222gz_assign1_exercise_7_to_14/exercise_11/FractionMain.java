package lw222gz_assign1_exercise_7_to_14.exercise_11;

/**
 * Created by Lucas on 2016-08-27.
 */
public class FractionMain {

    public static void main(String args[]){

        try{
            Fraction fOne = new Fraction(-5, 4);
            Fraction fTwo = new Fraction(5, -4);
            Fraction fThree = new Fraction(-5, -4);
            Fraction fFour = new Fraction(5, 4);
            Fraction fFive = new Fraction(20, 16); //equal to fFour

            //NoteToSelf: automatic use of toString method? Nice job Java! <3
            System.out.println("\n.toString test.");
            System.out.println(fOne);

            //isNegative method tests
            System.out.println("\n.isNegative tests.");
            System.out.println(fOne + " => " + fOne.isNegative());
            System.out.println(fTwo + " => " + fTwo.isNegative());
            System.out.println(fThree + " => " + fThree.isNegative());
            System.out.println(fFour + " => " + fFour.isNegative());

            //addition method tests
            System.out.println("\n.add test.");
            System.out.println(fOne + " + " + fFour + " = " + fOne.add(fFour).toString());

            //multiplication method tests
            System.out.println("\n.multiply test.");
            System.out.println(fOne + " * " + fFour + " = " + fOne.multiply(fFour).toString());

            //divition method tests
            System.out.println("\n.divide test.");
            System.out.println(fOne + " % " + fFour + " = " + fOne.divide(fFour).toString());

            //isEqualTo method test
            System.out.println("\n.isEqualTo test.");
            System.out.println(fOne + " == " + fFour + " => " + fOne.isEqualTo(fFour));
            System.out.println(fFour + " == " + fFive + " => " + fFour.isEqualTo(fFive));

            //getGCD method tests
            System.out.println("\n.getGCD tests.");
            System.out.println(new Fraction(8, 90).toString());
            System.out.println(new Fraction(15, 90).toString());

        }
        catch (Exception e){
            System.err.println(e.getMessage());
        }
    }

}
