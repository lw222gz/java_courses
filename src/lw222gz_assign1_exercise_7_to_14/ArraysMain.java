package lw222gz_assign1_exercise_7_to_14;

/**
 * Created by Lucas on 2016-08-26.
 */
public class ArraysMain {

    private static Arrays arr = new Arrays();

    private static int[] myArr = { 2, 2, 3, 1, 3, 4, 5, 1, 1, 2, 3, 1, 1, 4, 4, 5,
                                   5, 5, 5, 5, 5, 5, 5, 5, 1, 1, 1, 2, 3, 4, 4, 5 };


    private static int[] myMainSubArr = { 1,1,1,1,1,1,3,1,3,1,2,2,5,5,15,2,61,61};
    private static int[] mySubArr = { 3,1,3 };

    private static int[] difArr1 = {3,4,5,6};
    private static int[] diffArr2 = {1,2,3,4};

    public static void main(String args[]){
        try{
            System.out.println(arr.sum(diffArr2));

            System.out.println(arr.toString(arr.addN(myArr, 1)));
            System.out.println(arr.toString(arr.reverse(myArr)));
            System.out.println(arr.toString(arr.replaceAll(myArr, 1, 7)));
            System.out.println(arr.toString(arr.sort(myArr)));
            if(arr.hasSubsequence(myMainSubArr, mySubArr)){
                System.out.println("JAMEN KOLLA DÄÖR!");
            }
            else{
                System.out.println("Jamen de va ju inte bra...");
            }
            System.out.println(arr.toString(arr.absDif(difArr1, diffArr2)));
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }

    }
}
