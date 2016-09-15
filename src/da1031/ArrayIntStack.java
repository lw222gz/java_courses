package da1031;

/**
 * Created by Lucas on 2016-09-13.
 */
public class ArrayIntStack extends AbstractIntCollection implements IntStack {

    /* Add integer at top of stack. */
    public void push(int n){
        if(size >= values.length){
            resize();
        }

        int[] temp = new int[values.length];
        System.arraycopy(values, 0, temp, 0, values.length);

        values[0] = n;
        for(int i = 0; i < size; i++){
            values[i + 1] = temp[i];
        }
        size++;
    }

    /* Returns and removes integer at top of stack  */
    public int pop() throws IndexOutOfBoundsException{
        if(isEmpty()){
            throw new IndexOutOfBoundsException("The stack is empty.");
        }

        int value = values[0];

        //pushes all the remaining numbers to the left.
        for(int i = 0; i < size; i++){
            values[i] = values[i + 1];
            values[i + 1] = 0;
        }

        size--;
        return value;
    }

    /* Returns without removing integer at top of stack */
    public int peek() throws IndexOutOfBoundsException{
        if(isEmpty()){
            throw new IndexOutOfBoundsException("The stack is empty.");
        }
        return values[0];
    }

    /* Number of integers currently stored. */
    //public int size();

    /* Returns true if collection is empty. */
    //public boolean isEmpty();

    /* String of type "[ 7 56 -45 68 ... ]" */
    //public String toString();
}
