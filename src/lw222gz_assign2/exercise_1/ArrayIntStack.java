package lw222gz_assign2.exercise_1;

import da1031.AbstractIntCollection;
import da1031.IntStack;

/**
 * Created by Lucas on 2016-09-13.
 */
public class ArrayIntStack extends AbstractIntCollection implements IntStack {

    /* Add integer at top of stack. */
    public void push(int n){
        values[size] = n;
        size++;

        if(size >= values.length){
            resize();
        }
    }

    /* Returns and removes integer at top of stack  */
    public int pop() throws IndexOutOfBoundsException{
        if(isEmpty()){
            throw new IndexOutOfBoundsException("The stack is empty.");
        }

        int value = values[size - 1];
        size--;
        return value;
    }

    /* Returns without removing integer at top of stack */
    public int peek() throws IndexOutOfBoundsException{
        if(isEmpty()){
            throw new IndexOutOfBoundsException("The stack is empty.");
        }
        return values[size - 1];
    }
}
