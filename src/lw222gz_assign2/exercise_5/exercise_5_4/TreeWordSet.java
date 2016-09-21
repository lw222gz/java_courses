package lw222gz_assign2.exercise_5.exercise_5_4;

import lw222gz_assign2.exercise_5.exercise_5_2.Word;

import java.util.Iterator;

/**
 * Created by Lucas on 2016-09-21.
 */
public class TreeWordSet implements WordSet {

    int size = 0;

    private BST root = null;


    // Return current set size
    public int size(){
        return size;
    }

    // Returns a string contaning all words in alphabetic order
    public String toString(){
        Iterator<Word> it = iterator();

        String str = "";
        while(it.hasNext()){
            str += it.next().toString() + ", ";
        }

        return str;
    }

    // Add word if not already added
    public void add(Word word){
        if(root == null){
            root = new BST(word);
        }
        else{
            if(root.contains(word)){
                return;
            }
            root.add(word);
        }
        size++;
    }

    // Return true if word contained
    public boolean contains(Word word){
        if(root == null){
            return false;
        }
        return root.contains(word);
    }

    //returns an instance of the TreeWordSet iterator
    public Iterator iterator(){
        return new TreeWordSetIterator();
    }

    private class BST{
        Word value;
        BST left = null;
        BST right = null;
        BST parent = null;

        BST(Word value){
            this.value = value;
        }

        BST(Word value, BST parent){
            this.value = value;
            this.parent = parent;
        }

        //Adds a word to the BST
        public void add(Word w){
            //value is lower
            if(value.compareTo(w) > 0){
                if(left == null){
                    left = new BST(w, this);
                }
                else{
                    left.add(w);
                }
            }
            //value is larger
            else if(value.compareTo(w) < 0){
                if(right == null){
                    right = new BST(w, this);
                }
                else{
                    right.add(w);
                }
            }
        }

        //recursive method to check if a word is currently contained in the BST
        public boolean contains(Word w){
            //value is smaller
            if(value.compareTo(w) > 0){
                if(left == null){
                    return false;
                }
                return left.contains(w);
            }
            //value is larger
            else if(value.compareTo(w) < 0){
                if(right == null){
                    return false;
                }
                return right.contains(w);
            }
            return true;
        }
    }


    private class TreeWordSetIterator implements Iterator<Word>{
        private BST next;

        public TreeWordSetIterator(){
            next = root;
            if(next == null){
                return;
            }
            //get the lowest node as initiation
            while(next.left != null){
                next = next.left;
            }
        }

        //SRC: http://stackoverflow.com/questions/12850889/in-order-iterator-for-binary-tree
        @Override
        public Word next(){
            BST r = next;

            if(next.right != null){
                next = next.right;
                while(next.left != null){
                    next = next.left;
                }
                return r.value;
            }
            else{
                while(true){
                    if(next.parent == null){
                        next = null;
                        return r.value;
                    }
                    if(next.parent.left == next){
                        next = next.parent;
                        return r.value;
                    }
                    next = next.parent;
                }
            }

        }

        @Override
        public boolean hasNext(){
            return next != null;
        }
    }
}
