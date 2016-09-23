package lw222gz_assign2.exercise_1;

import da1031.AbstractIntCollection;
import da1031.IntList;

/**
 * Created by Lucas on 2016-09-13.
 */
public class ArrayIntList extends AbstractIntCollection implements IntList {

    /* Add integer n to the end of the list. */
    public void add(int n){
        if(size >= values.length){
            resize();
        }
        values[size] = n;
        size++;
    }

    /* Inserts integer n at position index. Shifts the element currently at that
     * position (if any) and any subsequent elements to the right.  */
    public void addAt(int n, int index) throws IndexOutOfBoundsException{
        if (!checkIndex(index, size)){
            throw new IndexOutOfBoundsException();
        }

        //resize the array if the value to add would go over the limit.
        if(size >= values.length){
            resize();
        }

        int[] temp = new int[values.length];
        System.arraycopy(values, 0, temp, 0, values.length);
        values[index] = n;

        //move each value still stored in temp 1 step to the right in values
        for(int i = index; i < size; i++){
            values[i + 1] = temp[i];
        }

        size++;
    }

    /* Remove integer at position index. */
    public void remove(int index) throws IndexOutOfBoundsException{
        if (!checkIndex(index, size)){
            throw new IndexOutOfBoundsException();
        }


        //pushes all remaining values after the removed one to the left.
        for(int i = index; i < size - 1; i++){
            values[i] = values[i + 1];
            values[i + 1] = 0;
        }

        size--;
    }

    /* Get integer at position index. */
    public int get(int index) throws IndexOutOfBoundsException{
        if (!checkIndex(index, size)){
            throw new IndexOutOfBoundsException();
        }

        return values[index];
    }


    /* Find position of integer n, otherwise return -1 */
    public int indexOf(int n){
        for(int i = 0; i < values.length; i++){
            if(values[i] == n){
                return i;
            }
        }
        return -1;
    }
}
