package lw222gz_assign1_exercise_7_to_14.exercise_14;

/**
 * Created by Lucas on 2016-09-06.
 */
public class Iterator {

    private Node node = null;

    public Iterator(Node head){
        node = head;
    }

    //returns the next object value
    public Object next(){
        Object nextValue = node.getValue();
        node = node.getNextNode();
        return nextValue;
    }


    //returns true is the iterator can give a
    public boolean hasNext(){
        return node != null;
    }
}
