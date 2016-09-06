package lw222gz_assign1_exercise_7_to_14.exercise_14;

/**
 * Created by Lucas on 2016-09-06.
 */
public class Node {
    private Object value;
    private Node nextNode = null;

    public Node(Object value){
        this.value = value;
    }

    //returns the node value.
    public Object getValue(){
        return this.value;
    }

    //returns the Node following this one.
    public Node getNextNode(){
        return nextNode;
    }

    //sets a Node to follow this one.
    public void setNextNode(Node node){
        nextNode = node;
    }
}
