package lw222gz_assign1_exercise_7_to_14.exercise_7;
import java.util.*;


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


    //returns a new int[] that is sorted based on @arr with the least occurrences first.
    //Example: param { 2,2,2,2,5,6,6,6,1,1,1,1} will return { 5,6,6,6,1,1,1,1,2,2,2,2}
    public int[] sort(int[] arr){
        int[] sortedArr = new int[arr.length];

        //NOTE: Did i misunderstand this exercise? If so the code to sort an array
        //based on the VALUES in the array is as the following out-commented code:
        /*sortedArr = arr;
        java.util.Arrays.sort(sortedArr);
        return sortedArr;*/


        //key is the array element value, value is the occurrences of that value
        TreeMap<Integer,Integer> nrOfOccurrences = new TreeMap<>();


        //creates a TreeMap containing:
        //key as each different value in @arr
        //value as the amount of occurrences for that key in @arr
        for(int i = 0; i < arr.length; i++){

            //if the entry already exists then it's value is increase by one.
            if(nrOfOccurrences.containsKey(arr[i])){
                nrOfOccurrences.put(arr[i], nrOfOccurrences.get(arr[i])+1);
            }
            //else a new entry is made
            else{
                nrOfOccurrences.put(arr[i], 1);
            }
        }


        int arrIndex = 0;
        //default first entry (lowest key)
        int lowestValue = nrOfOccurrences.firstEntry().getValue();
        int key = nrOfOccurrences.firstKey();
        int size = nrOfOccurrences.size();


        //TODO: this feels like it could use some refactoring.
        for(int i = 0; i < size; i++){
            //gets the current lowest value and it's key and stores those values.
            for(Map.Entry<Integer,Integer> entry : nrOfOccurrences.entrySet()) {

                if(entry.getValue() < lowestValue){
                    key = entry.getKey();
                    lowestValue = entry.getValue();
                }
            }

            //the values are added into the new array
            for (int j = 0; j < lowestValue; j++){
                sortedArr[arrIndex] = key;
                arrIndex++;
            }

            //the entry is removed since it's values has been added to the array
            nrOfOccurrences.remove(key, lowestValue);

            //if it's the last iteration of the loop it will break to avoid error.
            if(i + 1 == size){
                break;
            }
            //If the loop is not yet over default values are reset.
            lowestValue = nrOfOccurrences.firstEntry().getValue();
            key = nrOfOccurrences.firstKey();
        }

        return sortedArr;
    }


    //if the @sub has it's order as a sequence in @arr this method will return true, otherwise false.
    //NOTE: @sub cant be longer than @arr
    public boolean hasSubsequence(int[] arr, int[] sub) throws IllegalArgumentException{

        if(arr.length < sub.length){
            throw new IllegalArgumentException("The sub array cant be longer than the main array.");
        }

        for(int i = 0; i < arr.length; i++){
            if(arr[i] == sub[0]){

                for(int j = 0; j < sub.length; j++){
                    if(!(arr[i + j] == sub[j])){
                        break;
                    }
                    //if it's the last iteration of the loop and it hasn't broken then
                    //it truly is a subsequence of @arr.
                    if(j + 1 == sub.length){
                        return true;
                    }


                }
            }
        }

        return false;
    }


    //returns a new array containing the values @arr1[x] - @arr2[x]
    //EXCEPTION: Throws IllegalArgumentException if the parameters @arr1 and @arr2 does NOT have the same length.
    public int[] absDif(int[] arr1, int[] arr2) throws IllegalArgumentException{

        if(arr1.length != arr2.length){
            throw new IllegalArgumentException("The given Array parameters must be of the same array length.");
        }
        int[] arrDif = new int[arr1.length];

        for(int i = 0; i < arr1.length; i++){
            arrDif[i] = arr1[i] - arr2[i];
        }
        return arrDif;

    }


}
