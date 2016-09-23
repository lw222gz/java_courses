package lw222gz_assign2.exercise_5.exercise_5_2;

/**
 * Created by Lucas on 2016-09-20.
 */
public class Word implements Comparable<Word> {
    private String word;

    public Word(String str) {
        word = str;
    }

    public String toString() { return word; }

    /* Override Object methods */
    @Override
    public int hashCode() {
        int hc = 7;
        for(char c : word.toUpperCase().toCharArray()){
            hc = hc * 31 + Character.getNumericValue(c);
        }
        return hc;
    }

    //Checks if @other is a word object and if so if it's equal to this word object, if it is then true is returned
    //otherwise false.
    @Override
    public boolean equals(Object other) {
        if(other instanceof Word){
            Word otherWord = (Word)other;
            return word.toUpperCase().equals(otherWord.toString().toUpperCase());
        }
        return false;
    }

    /* compares this Word object to param @w Word object*/
    @Override
    public int compareTo(Word w) {
        return word.compareToIgnoreCase(w.toString());
    }
}
