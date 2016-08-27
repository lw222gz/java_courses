package lw222gz_assign1_exercise_7_to_14.exercise_7;

/**
 * Created by Lucas on 2016-08-26.
 */
public class ArraysMain {

    private static Arrays arr = new Arrays();

    //Test arrays
    private static int addNValue = 1;
    private static int[] addNArr = { 2, 3, 4, 5 };

    private static int[] reverseArr = { 6,6,5,4,4,4,4,1,1,2,2,3};

    private static int old = 1;
    private static int nw = 7;
    private static int[] mySwitchArr = {old, old, old, old};

    private static int[] myMainSubArr = { 1,3,1,3,1,2,5,5,15,2,61,61};
    private static int[] myCorrectSubArr = { 3,1,3 };
    private static int[] myIncorrectSubArr = { 42, 42, 42};

    private static int[] mySortArr = { 2, 2, 3, 1, 3, 4, 5, 1, 1, 2, 3, 1, 1, 4, 4, 5,
                                        5, 5, 5, 5, 5, 5, 5, 5, 1, 1, 1, 2, 3, 4, 4, 5 };

    private static int[] difArr1 = {3,4,5,6};
    private static int[] diffArr2 = {1,2,3,4};

    public static void main(String args[]){
        try{
            System.out.println("\n.sum method test");
            System.out.println(arr.toString(diffArr2) + " => " + arr.sum(diffArr2));

            //Adds addNValue test.
            System.out.println("\n.addN method test, adds " + addNValue + " to all values in the array. The array will get changed.");
            System.out.println("Before: " + arr.toString(addNArr));
            arr.addN(addNArr, addNValue);
            System.out.println("After: " + arr.toString(addNArr));

            //Reverse method test
            System.out.println("\n.reverse method test. Reverses an array. The array will be left unchanged.");
            System.out.println("Normal: " + arr.toString(reverseArr));
            System.out.println("Reversed: " + arr.toString(arr.reverse(reverseArr)));
            System.out.println("Array used after reverse method: " + arr.toString(reverseArr));


            //.replaceAll method test
            System.out.println("\n.replaceAll test. Replaces all " + old + " values with " + nw + " values. The array will be changed.");
            System.out.println("Before: " + arr.toString(mySwitchArr));
            arr.replaceAll(mySwitchArr, old, nw);
            System.out.println("After: " + arr.toString(mySwitchArr));

            //.sort method test
            //TODO: did I interpret this one wrong? Was I just supposed to sort on least value?
            System.out.println("\n.sort test. The array will be sorted so the least occurring elements will be positioned first. nThe array should be left unchanged.");
            System.out.println("Result: " + arr.toString(arr.sort(mySortArr)));
            System.out.println("Array used after sort: " + arr.toString(mySortArr));


            //.hasSubsequence tests, this is split up into 2 test. One intended to fail and one intended to be a success.
            System.out.println("\n.hasSubsequence test. If the sequence of the second array is found in the first array then this should return true.");

            //.hasSubsequence test 1
            System.out.println("Test 1 should give success, Arrays used: \n1. " + arr.toString(myMainSubArr) + "\n2. " + arr.toString(myCorrectSubArr) + "\nRESULT: ");
            if(arr.hasSubsequence(myMainSubArr, myCorrectSubArr)){
                System.out.println("Sub-sequence found.");
            }
            else{
                System.out.println("No sub-sequence found.");
            }

            //.hasSubsequence test 2
            System.out.println("Test 2 should fail, Arrays used: \n1. " + arr.toString(myMainSubArr) + "\n2. " + arr.toString(myIncorrectSubArr) + "\nRESULT: ");
            if(arr.hasSubsequence(myMainSubArr, myIncorrectSubArr)){
                System.out.println("Sub-sequence found.");
            }
            else{
                System.out.println("No sub-sequence found.");
            }

            //.absDif test, this will finish off the testing since the last test intentionally will throw an error.
            System.out.println("\n.absDif test. Should return a new array with the values of arr1 - arr2, \nex: {1,2,3,4,5} and {1,1,1,1,1} should give the result {0,1,2,3,4}");
            System.out.println();
            System.out.println(arr.toString(difArr1) + " - " + arr.toString(diffArr2) + " => ");
            System.out.println(arr.toString(arr.absDif(difArr1, diffArr2)));

            //This should throw an error and a proper message should be displayed.
            System.out.println("\nIf the arrays don't have the same length, an error should be displayed.");
            System.out.println(arr.toString(myCorrectSubArr) + " - " + arr.toString(diffArr2) + " => ");
            System.out.println(arr.toString(arr.absDif(myCorrectSubArr, diffArr2)));
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }

    }
}
