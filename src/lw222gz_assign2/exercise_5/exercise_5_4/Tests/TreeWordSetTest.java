package lw222gz_assign2.exercise_5.exercise_5_4.Tests;

import lw222gz_assign2.exercise_5.exercise_5_2.Word;
import lw222gz_assign2.exercise_5.exercise_5_4.TreeWordSet;
import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;

import static org.junit.Assert.*;

/**
 * Created by Lucas on 2016-09-23.
 */
public class TreeWordSetTest {
    private TreeWordSet twsTestObj;
    @Before
    public void setUp() throws Exception {
        twsTestObj = new TreeWordSet();
    }
    //TODO: write tests for this and the Word class.


    //Since verifying that one method works requires the use of another
    //(Ex: after using .add(), .contains() must be used to see if that value was added)
    //I only made one big method for all tests
    @Test
    public void tws_Tests(){
        //Test 1.1: .add() and .size(), testing so that 2 different object with the same value cannot be added twice.
        //.size() is tested and used to verify.
        String value = "LoremIpsum";
        twsTestObj.add(new Word(value));
        twsTestObj.add(new Word(value));

        assertEquals(1, twsTestObj.size());

        //Test 1.2: .add(), forcing a resize of the list by adding several elements
        Word[] words = new Word[] { new Word("Dad"),new Word("Jokes"),
                                    new Word("Are"),new Word("Always"),
                                    new Word("A"),new Word("PARENT"),
                                    new Word("GET"),new Word("IT"),
                                    new Word("?"), new Word("No?"),
                                    new Word("O"), new Word("k") };

        for(Word word: words){
            twsTestObj.add(word);
        }

        assertEquals(words.length + 1, twsTestObj.size());

        //Test 1.3: .contains(), testing to find a object added to the BST
        Word toFind = new Word("NotHidden");
        twsTestObj.add(toFind);
        assertTrue(twsTestObj.contains(toFind));



        //Test 1.4: .iterator(), testing to make sure the iterator returns values in alphabetic order and
        //iterates the same amount .size() represents
        int counter = 0;
        Iterator<Word> it = twsTestObj.iterator();
        Word previous = null;
        Word current = null;

        while(it.hasNext()){
            current = it.next();
            counter++;

            if(previous == null){
                previous = current;
            }
            else{
                if(previous.compareTo(current) > 0){
                    fail("previous value is larger than current value. Alphabetic order was not proper.");
                }
            }
        }

        assertEquals(counter, twsTestObj.size());

    }

}