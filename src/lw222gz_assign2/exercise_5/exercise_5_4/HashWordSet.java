package lw222gz_assign2.exercise_5.exercise_5_4;

import lw222gz_assign2.exercise_5.exercise_5_2.Word;
import java.util.Iterator;

/**
 * Created by Lucas on 2016-09-21.
 */
public class HashWordSet implements WordSet {
    private int size = 0;
    private Node[] buckets = new Node[8];

    // Add word if not already added
    public void add(Word word){
        //if the value already exists then the method is aborted.
        if(contains(word)){
            return;
        }

        int pos = getBucketNumber(word);

        Node node = new Node(word);
        node.next = buckets[pos];
        buckets[pos] = node;
        size++;
        if(size >= buckets.length){
            rehash();
        }
    }

    // Return true if word contained within the bucket
    public boolean contains(Word word){
        int pos = getBucketNumber(word);
        Node node = buckets[pos];
        while(node != null){
            if(node.value.equals(word) && node.value.hashCode() == word.hashCode()){
                return true;
            }
            node = node.next;
        }

        return false;
    }

    // Return current set size
    public int size(){
        return size;
    }

    // Returns a string containing all of the words
    @Override
    public String toString(){
        String str = "";
        for(Node n : buckets){
            str += n.getValue() + "\n";
        }
        return str;
    }

    //Returns an instance of the iterator
    public Iterator iterator(){
        return new HashWordSetIterator();
    }

    //Returns a bucket number depending on the hashcode the Word object has
    private int getBucketNumber(Word w){
        int hc = w.hashCode();
        if(hc < 0){
            hc = -hc;
        }
        return hc % buckets.length;
    }

    //rehashes the bucket
    private void rehash(){
        Node[] temp = buckets;
        buckets = new Node[2*temp.length];
        size = 0;
        for(Node n : temp){
            if(n == null){
                continue;
            }
            while(n != null){
                add(n.value);
                n = n.next;
            }
        }
    }

    //Node class
    private class Node{
        private Word value;
        private Node next = null;

        public Node(Word value){
            this.value = value;
        }

        public Word getValue(){
            return value;
        }
    }

    //Dis needs to be tested mon
    private class HashWordSetIterator implements Iterator<Word>{
        private Node next = null;

        public HashWordSetIterator(){
            //Identifies the first value
            for(Node n: buckets){
                if(n != null){
                    next = n;
                    break;
                }
            }

        }

        @Override
        public Word next(){
            Node n = next;
            if(next.next != null){
                next = next.next;
            }
            else {
                //Starts looping through the buckets from the current node to find the next node.
                for(int i = getBucketNumber(next.value) + 1; i < buckets.length; i++){
                    if(buckets[i] != null){
                        next = buckets[i];
                        break;
                    }
                    //When the last index is reached the loop breaks and next is set to null to have hasNext() return false
                    if(i >= buckets.length -1){
                        next = null;
                        break;
                    }
                }
            }

            return n.value;
        }

        //returns true if the iterator still have nodes to provide
        @Override
        public boolean hasNext(){
            return next != null;
        }
    }
}
