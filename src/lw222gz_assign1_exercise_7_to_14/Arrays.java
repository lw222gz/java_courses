package lw222gz_assign1_exercise_7_to_14;

import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by Lucas on 2016-08-26.
 */
public class Arrays {

    //returns sum of all values in an array
    public int sum(int[] arr){
        int sum = 0;

        for(int value : arr){
            sum += value;
        }

        return sum;
    }

    //returns a string of all values in an int[]
    public String toString(int[] arr){

        String str = "| ";

        for(int value : arr){
            str += Integer.toString(value) + " | ";
        }

        return str;
    }

    //adds the value of parameter N to all values in int[] parameter arr
    public int[] addN(int[] arr, int N){

        for(int i = 0; i < arr.length; i++) {
            arr[i] += N;
        }

        return arr;
    }

    //Returns a new array where the positions have been reversed in the given array.
    public int[] reverse(int[] arr){

        int[] reversedArr = new int[arr.length];

        for(int i = 0; i < arr.length; i++){
            reversedArr[i] = arr[arr.length - i - 1];
        }

        return reversedArr;
    }


    //replaces all occurrences of @old in @arr with @nw
    public int[] replaceAll(int[] arr, int old, int nw){
        for(int i = 0; i < arr.length; i++){
            if(arr[i] == old){
                arr[i] = nw;
            }
        }
        return arr;
    }


    public int[] sort(int[] arr){
        int[] sortedArr = new int[arr.length];


        //key is the array element value, value is the occurrences of that value
        HashMap<Integer,Integer> noOfOccurences = new HashMap<>();


        for(int i = 0; i < arr.length; i++){
            if(noOfOccurences.containsKey(arr[i])){
                noOfOccurences.put(arr[i], noOfOccurences.get(arr[i])+1);
            }
            else{
                noOfOccurences.put(arr[i], 1);
            }
        }
        

        for(Map.Entry<Integer,Integer> entry : noOfOccurences.entrySet()) {
            int key = entry.getKey();
            int value = entry.getValue();

            System.out.println(key + " => " + value);
        }

        System.out.println(noOfOccurences.get(1));

        System.out.println(noOfOccurences);


        return sortedArr;
    }


}
