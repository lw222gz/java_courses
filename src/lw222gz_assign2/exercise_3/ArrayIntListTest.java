package lw222gz_assign2.exercise_3;

import lw222gz_assign2.exercise_1.ArrayIntList;

import static org.junit.Assert.*;

/**
 * Created by Lucas on 2016-09-15.
 */
public class ArrayIntListTest {

    private ArrayIntList listTestObj;

    @org.junit.Before
    public void setUp() throws Exception {
        listTestObj = new ArrayIntList();
    }

    @org.junit.After
    public void tearDown() throws Exception {
    }

    @org.junit.Test
    public void add() throws Exception {
        //Test List.1.1: Add a value and make sure it's added.
        listTestObj.add(42);
        assertEquals(1, listTestObj.size());

        //Test List.1.2: Extreme case of adding a lot of values.
        for(int i = 0; i < 100000; i++){
            listTestObj.add(i);
        }
        assertEquals(100001, listTestObj.size());
    }

    @org.junit.Test
    public void addAt() throws Exception {

        listTestObj.add(42);
        listTestObj.add(2);

        int testValue = 1;
        int testIndex = 0;
        listTestObj.addAt(testValue, testIndex);

        //Test List.2.1: so that the addAt has added the value by checking the size
        //Note: dependent on method add()
        assertEquals(3, listTestObj.size());

        //Test List.2.2: so that addAt has put the value at index 0
        //Note: dependent on method indexOf() and add()
        assertEquals(testIndex, listTestObj.indexOf(testValue));

        //Test List.2.3: testing so that the first value added has been pushed back one spot after the addAt
        //Note: dependent on method indexOf() and add()
        assertEquals(1, listTestObj.indexOf(42));

        //Test List.2.4: to throw an error, tries to add a value at an invalid position (-1), should throw an error
        //IndexOutOfBoundsException is expected to be thrown.
        try{
            listTestObj.addAt(42, -1);
            fail("This line should not have been reached. Test List.2.4");
        }
        catch (IndexOutOfBoundsException e){
            assert(true);
        }



    }

    @org.junit.Test
    public void remove() throws Exception {
        int valueOne = 42;
        int valueTwo = 84;
        int valueThree = 168;
        listTestObj.add(valueOne);
        listTestObj.add(valueTwo);
        listTestObj.add(valueThree);

        listTestObj.remove(0);
        //Test List.3.1: Testing so that the size has been reduced after an element removal
        //Note: dependent on method add()
        assertEquals(2, listTestObj.size());

        //Test List.3.2: Test so that the second element is now first since the first should have been removed.
        //Note: dependent on method add()
        assertEquals(0, listTestObj.indexOf(valueTwo));

        //Test List.3.3: Trying to remove at an index that does not exist.
        //IndexOutOfBoundsException is expected to be thrown.
        try{
            listTestObj.remove(-1);
            fail("This line should not have been reached. Test List.3.3");
        }
        catch(IndexOutOfBoundsException e){
            assert(true);
        }

    }

    @org.junit.Test
    public void get() throws Exception {
        listTestObj.add(42);

        //Test List.4.1: Testing the method to get the first value.
        assertEquals(42, listTestObj.get(0));

        //reset the array before extreme case
        listTestObj = new ArrayIntList();

        //Test List.4.2: Extreme case, 100000 values added and checking so that they all are on their appropriate spots
        //Note: dependent on method add()
        for(int i = 0; i < 100000; i++){
            listTestObj.add(i);
        }
        for(int i = 0; i < 100000; i++){
            assertEquals(i, listTestObj.get(i));
        }


        //Test List.4.3: Trying to get at an index that does not exist.
        //IndexOutOfBoundsException is expected to be thrown.
        try{
            listTestObj.get(-1);
            fail("This line should not have been reached. Test List.4.3");
        }
        catch(IndexOutOfBoundsException e){
            assert(true);
        }
    }

    @org.junit.Test
    public void indexOf() throws Exception {
        listTestObj.add(42);
        listTestObj.add(43);
        listTestObj.add(44);
        listTestObj.add(45);

        //Test List.5.1: get index of a value that is in the array.
        //Note: dependent on method add()
        assertTrue(listTestObj.indexOf(42) != -1);

        //Test List.5.2: checking so that a value that does not exist in the array returns -1
        assertTrue(listTestObj.indexOf(9999999) == -1);
    }

}