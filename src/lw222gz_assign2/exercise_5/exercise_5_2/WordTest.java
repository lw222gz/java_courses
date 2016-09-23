package lw222gz_assign2.exercise_5.exercise_5_2;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Lucas on 2016-09-23.
 */
public class WordTest {

    @Test
    public void test_hashCode() throws Exception {
        //Test hashCode_1: testing so that a word object always returns the same value
        Word w = new Word("Juliet");
        int hc = w.hashCode();
        assertEquals(hc, w.hashCode());

        //Test hashCode_2: testing so that 2 different word objects with different values have different hash codes
        w = new Word("Romeo");
        Word m = new Word("Skakaspjutet");
        assertFalse(m.hashCode() == w.hashCode());

        //Test hashCode_3: testing so that 2 word object with equal value has the same hash code
        w = new Word("Ljus");
        m = new Word("ljus");
        assertTrue(w.hashCode() == m.hashCode());
    }

    @Test
    public void equals() throws Exception {
        //Test equals_1: testing 2 objects that are equal
        Word w = new Word("WordUno");
        Word o = new Word("worduno");

        assertTrue(w.equals(o));
        assertTrue(w.equals(w));

        //Test equals_2: testing 2 objects that are different values.
        w = new Word("Pikachu");
        o = new Word("Charmander");
        assertFalse(w.equals(o));
    }

    @Test
    public void compareTo() throws Exception {

        //Test compareTo_1: Testing to compare 2 words that are equal
        Word w = new Word("java");
        Word o = new Word("Java");

        assertEquals(0, w.compareTo(o));

        //Test compareTo_2: Testing to compare 2 word that are not equal
        w = new Word("A");
        o = new Word("B");
        //Since w is "smaller" than o (in alphabetic order) a number that is less than 0 is expected.
        assertTrue(w.compareTo(o) < 0);

        //Opposite tested here
        assertTrue(o.compareTo(w) > 0);

    }

}