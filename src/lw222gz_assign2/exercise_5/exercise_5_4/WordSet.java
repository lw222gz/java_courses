package lw222gz_assign2.exercise_5.exercise_5_4;

import lw222gz_assign2.exercise_5.exercise_5_2.Word;

/**
 * Created by Lucas on 2016-09-21.
 */
public interface WordSet extends Iterable {
    void add(Word word); // Add word if not already added
    boolean contains(Word word); // Return true if word contained
    int size(); // Return current set size
    String toString(); // Print contained words
}
