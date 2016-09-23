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

    // Returns a string containing all words in alphabetic order
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


        //returns the node left most to the node this method is called on.
        public BST getLeftMost(){
            BST bst = this;
            while(bst.left != null){
                bst = bst.left;
            }
            return bst;
        }

        //returns the next lowest node after the one that it is called on.
        //Ex: if values 5,6,7,8 are in the tree calling it on the node with value 5 returns 6 etc.
        public BST getNextLowestNode(){
            //If the current node has a right node linked to it, the next node
            //to return is the left most node of that one or that node if it has no left nodes linked to it.
           if(right != null){
               return right.getLeftMost();
           }
           //Else we need to go back up in the tree
           else{
               BST bst = this;
               //Loop that climbs back up.
               //If parent isn't null and the parents right node is this one
               //we can determine that we need to back up in the tree.
               while(bst.parent != null && bst == bst.parent.right){
                   bst = bst.parent;
               }
               return bst.parent;
           }

        }
    }


    private class TreeWordSetIterator implements Iterator<Word>{
        private BST current;

        public TreeWordSetIterator(){
            current = root;
            if(current == null){
                return;
            }
            //get the lowest node as initiation
            current = current.getLeftMost();
        }


        //returns the next node
        @Override
        public Word next(){
            BST bst = current;
            current = current.getNextLowestNode();
            return bst.value;
        }

        //returns true as long as there are still nodes to iterate over.
        @Override
        public boolean hasNext(){
            return current != null;
        }
    }
}
