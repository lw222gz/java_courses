package da1031;

import java.util.Iterator;

/**
 * Created by Lucas on 2016-09-13.
 */
public class CollectionMain {

    public static void main(String args[]){

        try{
            testArrayIntList();
            testArrayStackList();
        }
        catch(Exception e){
            System.out.println("Something went wrong.");
        }
    }

    //testing ArrayIntList
    public static void testArrayIntList(){
        System.out.println("1. Tests for the array int list:");

        ArrayIntList myArr = new ArrayIntList();
        int testValue;
        int testIndex;

        //Test 1.1
        System.out.println("\nTest 1.1: Print empty arr.");
        System.out.println(myArr);

        //Test 1.2
        testValue = 42;
        System.out.println("\nTest 1.2: Add a value ("+testValue+") to the array and print.");
        myArr.add(testValue);
        System.out.println(myArr);

        //Test 1.3
        System.out.println("\nTest 1.3: Add 8 more values to force a resize.");
        myArr.add(1);
        myArr.add(2);
        myArr.add(3);
        myArr.add(4);
        myArr.add(5);
        myArr.add(6);
        myArr.add(7);
        myArr.add(8);
        System.out.println(myArr);
        System.out.println("Arr size: " + myArr.size());

        //Test 1.4
        testValue = 0;
        testIndex = 1;
        System.out.println("\nTest 1.4: addAt method, testing to add a value ("+testValue+") at index ("+testIndex+")");
        myArr.addAt(testValue, testIndex);
        System.out.println(myArr);

        //Test 1.4.1
        System.out.println("\nTest 1.4.1: addAt method, testing the resize call via this method. (NEW OBJECT CREATED HERE)");
        myArr = new ArrayIntList();
        myArr.add(1);
        myArr.add(2);
        myArr.add(3);
        myArr.add(4);
        myArr.add(5);
        myArr.add(6);
        myArr.add(8);
        myArr.add(9);
        //resize will now be called from the addAt method
        myArr.addAt(7, 6);
        System.out.println(myArr);

        //Test 1.4.2 - Should throw an error
        try{
            testValue = 42;
            testIndex = -1;
            System.out.println("\nTest 1.4.2: addAt method, trying to add a value outside the boundary of the list");
            myArr.addAt(testValue, testIndex);

            System.out.println("Test failed. This line should not been reached.");
        }
        catch (Exception e){
            System.out.println("Test successful.");
        }


        //Test 1.5
        testIndex = 0;

        System.out.println("\nTest 1.5: remove method, removing the value at index ("+testIndex+")");
        myArr.remove(testIndex);
        System.out.println(myArr);
        System.out.println(myArr.size());

        //Test 1.5.1 - should throw and error.
        testIndex = -1;
        try{
            System.out.println("\nTest 1.5.1: remove method, trying to remove a value outside the index ("+testIndex+").");
            myArr.remove(testIndex);

            System.out.println("Test failed. This line should not have been reached.");
        }
        catch (Exception e){
            System.out.println("Test successful.");
        }


        //Test 1.6
        testIndex = 2;
        System.out.println("\nTest 1.6: get method, getting value at array index ("+testIndex+")");
        System.out.println(myArr);
        System.out.println("Result: " + myArr.get(testIndex));

        //Test 1.6.1 - should throw an error
        try{
            testIndex = -1;
            System.out.println("\nTest 1.6.1: get method, trying to get a value that is outside the possible index ("+testIndex+")");
            System.out.println(myArr.get(testIndex));
            System.out.println("Test failed.");
        }
        catch(Exception e){
            System.out.println("Test successful.");
        }

        //Test 1.7
        testIndex = 3;
        System.out.println("\nTest 1.7: indexOf method, trying to get array index position of value ("+myArr.get(testIndex)+").");
        System.out.println(myArr);
        System.out.println("Result: " + myArr.indexOf(myArr.get(testIndex)));

        //Test 1.7.1
        testValue = 810293;
        System.out.println("\nTest 1.7.1: indexOf method, trying to get array index position of a value ("+testValue+") that is not in the list.");
        System.out.println(myArr);
        System.out.println("Result (should be -1) : "+ myArr.indexOf(testValue));


    }

    public static void testArrayStackList(){
        System.out.println("\n2. Test for the stack int list:");

        ArrayIntStack myStack = new ArrayIntStack();
        int testValue;

        //Test 2.1
        System.out.println("\nTest 2.1: printing out an empty list.");
        System.out.println(myStack);

        //Test 2.2
        testValue = 42;
        System.out.println("\nTest 2.2: push method, Adding a value ("+testValue+") to the stack.");
        myStack.push(42);
        System.out.println(myStack);


        //Test 2.2.1
        testValue = 1;
        System.out.println("\nTest 2.2.1: push method, Adding another value ("+testValue+") to the stack, this new value should be listed first.");
        myStack.push(testValue);
        System.out.println(myStack);

        //Test 2.2.2
        System.out.println("\nTest 2.2.2: push method, Adding values until a resize is required.");
        myStack.push(2);
        myStack.push(3);
        myStack.push(4);
        myStack.push(5);
        myStack.push(6);
        myStack.push(7);
        myStack.push(8);
        System.out.println(myStack);

        //Test 2.4
        System.out.println("\nTest 2.4: pop method, testing to pop and display pop'ed value.");
        System.out.println(myStack);
        System.out.println("Pop'ed value : " + myStack.pop());
        System.out.println(myStack);

        //Test 2.4.1 - should throw an exception
        try{
            System.out.println("\nTest 2.4.1: pop method, testing to pop on an empty stack. (NEW OBJECT CREATED)");
            myStack = new ArrayIntStack();
            System.out.println(myStack);

            System.out.println(myStack.pop());
            System.out.println("Test failed. This line should not have been reached.");
        }
        catch (Exception e){
            System.out.println("Test success!");
        }

        //Test 2.5 - should throw an exception
        System.out.println("\nTest 2.5: peek method, testing to use peek method on a stack with values in it. The first value should be the result.");
        myStack.push(42);
        myStack.push(84);
        System.out.println(myStack);
        System.out.println("Result: " + myStack.peek());

        //Test 2.5.1
        try{
            System.out.println("\nTest 2.5.1: peek method, testing to peek on an empty stack.(NEW OBJECT CREATED)");
            myStack = new ArrayIntStack();
            System.out.println(myStack);
            System.out.println(myStack.peek());

            System.out.println("Test failed. This line should not have been reached.");
        }
        catch(Exception e){
            System.out.println("Test success!");
        }

    }
}
