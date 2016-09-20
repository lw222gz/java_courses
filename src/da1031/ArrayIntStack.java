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

        values[size] = n;
        size++;
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
