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

    private HashWordSet hashSetTestObj;
    @Before
    public void setUp() throws Exception {
        hashSetTestObj = new HashWordSet();
    }

    //Since verifying that one method works requires the use of another
    //(Ex: after using .add(), .contains() must be used to see if that value was added)
    //I only made one big method for all tests
    @Test
    public void HashWordSetTests(){
        //Test 1.1: .add() and .contains(), testing to add a Word object and then make sure it was added.
        Word w = new Word("LoremIpsum");
        hashSetTestObj.add(w);
        assertTrue(hashSetTestObj.contains(w));

        //Test 1.2: Adding several objects (forcing a resize of the bucket list) and check so that all elements are still contained.
        Word[] words = new Word[] {new Word("Very"), new Word("unique"),
                                new Word("Strings"), new Word("Be"),
                                new Word("All"), new Word("Up"),
                                new Word("In"), new Word("Here"),
                                new Word("With"), new Word("These"),
                                new Word("Awesome"), new Word("Tests"),
                                new Word("That"), new Word("Are"),
                                new Word("Being"), new Word("Preformed")};

        for(Word word : words){
            hashSetTestObj.add(word);
        }

        for(Word word: words){
            assertTrue(hashSetTestObj.contains(word));
        }

        //Test 1.3: .size(), testing to that the value size()
        //returns has been properly updated throughout previous tests
        //(+1 for test 1.1);
        assertEquals(words.length + 1, hashSetTestObj.size());


        //Test 1.4: .iterator(), testing so that the iterator provides the amount of elements
        //that .size() represents
        int counter = 0;
        Iterator<Word> it = hashSetTestObj.iterator();
        while(it.hasNext()){
            it.next();
            counter++;
        }

        assertEquals(counter, hashSetTestObj.size());

    }

}