package lw222gz_assign2.exercise_3;

import da1031.ArrayIntStack;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Lucas on 2016-09-15.
 */
public class ArrayIntStackTest {
    ArrayIntStack stackTestObj;

    @Before
    public void setUp() throws Exception {
        stackTestObj = new ArrayIntStack();
    }

    @Test
    public void push() throws Exception {
        stackTestObj.push(42);
        //Test Stack.1.1: Testing so that a value was successfully added to the stack.
        assertEquals(stackTestObj.size(), 1);
        stackTestObj.push(84);
        assertEquals(stackTestObj.size(), 2);

        //Test Stack.1.2: Testing so that the latest pushed value is on top of the stack
        //Note: dependent on peek method
        stackTestObj.push(168);
        assertEquals(stackTestObj.peek(), 168);
    }

    @Test
    public void pop() throws Exception {
        //Test Stack.2.1: Test to pop on an empty stack.
        //IndexOutOfBoundsException is expected
        try{
            stackTestObj.pop();
            fail("This line was not supposed to be reached. Test stack.2.1");
        }
        catch (IndexOutOfBoundsException e){
            assert(true);
        }

        //Test Stack.2.2: Test to pop a list with 1 value, then check if the stack is empty.
        int testValue = 42;
        stackTestObj.push(testValue);
        assertEquals(stackTestObj.pop(), testValue);
        assertEquals(stackTestObj.size(), 0);

        //Test Stack.2.3: Extreme test, test to add 10000 elements and then pop them all.
        for(int i = 0; i < 10000; i++){
            stackTestObj.push(i);
        }

        assertEquals(stackTestObj.size(), 10000);

        for(int i = 0; i < 10000; i++){
            stackTestObj.pop();
        }
        assertEquals(stackTestObj.size(), 0);


    }

    @Test
    public void peek() throws Exception {
        //Test Stack.3.1: Testing to use peek on an empty stack
        try{
            stackTestObj.peek();
            fail("This line should not have been reached. Test Stack.3.1");
        }
        catch(IndexOutOfBoundsException e){
            assert(true);
        }

        //Test Stack.3.2: Testing to use peek on a stack with values. The last value added is the expected result.
        int lastValue = 200;
        stackTestObj.push(42);
        stackTestObj.push(84);
        stackTestObj.push(lastValue);
        assertTrue(stackTestObj.peek() == lastValue);

    }

}