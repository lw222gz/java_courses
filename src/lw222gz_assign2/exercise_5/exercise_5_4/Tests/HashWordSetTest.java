package lw222gz_assign2.exercise_5.exercise_5_4.Tests;

import lw222gz_assign2.exercise_5.exercise_5_2.Word;
import lw222gz_assign2.exercise_5.exercise_5_4.HashWordSet;
import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;

import static org.junit.Assert.*;

/**
 * Created by Lucas on 2016-09-23.
 */
public class HashWordSetTest {

    private HashWordSet hwsTestObj;
    @Before
    public void setUp() throws Exception {
        hwsTestObj = new HashWordSet();
    }

    //Since verifying that one method works requires the use of another
    //(Ex: after using .add(), .contains() must be used to see if that value was added)
    //I only made one big method for all tests
    @Test
    public void hws_Tests(){

        //Test 1.1: .add() and .size(), testing so that a word object can be added to the HashWordSet
        String value = "LoremIpsum";
        Word b = new Word(value);
        hwsTestObj.add(b);
        assertEquals(1, hwsTestObj.size());

        //Test 1.2: .add and .size(), testing so that 2 different word objects with the same value dont get both added.
        Word c = new Word(value);
        hwsTestObj.add(c);
        assertEquals(1, hwsTestObj.size());


        //Test 1.3: .add and .size(), Adding several objects (forcing a resize of the bucket list) and check so that all elements are still contained.
        Word[] words = new Word[] {new Word("Very"), new Word("unique"),
                new Word("Strings"), new Word("Be"),
                new Word("All"), new Word("Up"),
                new Word("In"), new Word("Here"),
                new Word("With"), new Word("These"),
                new Word("Awesome"), new Word("Tests"),
                new Word("That"), new Word("Are"),
                new Word("Being"), new Word("Preformed")};

        for(Word word : words){
            hwsTestObj.add(word);
        }

        assertEquals(words.length + 1, hwsTestObj.size());

        //Test 1.4: .contains(), testing to add a Word object and then make sure it was added.
        Word toFind = new Word("Hidden");
        hwsTestObj.add(toFind);
        assertTrue(hwsTestObj.contains(toFind));


        //Test 1.5: .iterator(), testing so that the iterator provides the amount of elements
        //that .size() represents
        int counter = 0;
        Iterator<Word> it = hwsTestObj.iterator();
        while(it.hasNext()){
            it.next();
            counter++;
        }

        assertEquals(counter, hwsTestObj.size());

    }

}