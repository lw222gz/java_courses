package lw222gz_assign2.exercise_4;

import java.util.Iterator;

/**
 * Created by Lucas on 2016-09-15.
 */
public class GenericQueue<E> implements Queue<E>{

    private int size = 0;
    private Node head;
    private Node tail;

    // current queue size
    public int size(){
        return size;
    }

    // true if queue is empty
    public boolean isEmpty(){
        return size == 0;
    }

    // add element at end of queue
    public void enqueue(E element){
        if(head == null){
            head = new Node(element);
            tail = head;
        }
        else{
            //sets the new Node to the current last element, aka tail
            tail.setNextNode(new Node(element));
            //sets the new node as the last element.
            tail = tail.getNextNode();
        }
        size++;
    }

    // return and remove first element.
    public E dequeue(){
        if(isEmpty()){
            throw new IndexOutOfBoundsException("The queue is empty.");
        }

        Node firstNode = head;
        head = head.getNextNode();
        //if the new head value is null then the list is empty.
        if(head == null){
            tail = null;
        }
        size--;
        return firstNode.getValue();
    }


    // return (without removing) first element
    public E first(){
        if(isEmpty()){
            throw new IndexOutOfBoundsException("The queue is empty");
        }
        return head.getValue();
    }

    // return (without removing) last element
    public E last(){
        if(isEmpty()){
            throw new IndexOutOfBoundsException("The queue is empty");
        }
        return tail.getValue();
    }

    //returns an iterator for the generic queue
    public Iterator iterator() { return new GenericQueueIterator();}

    //Node class for teh linked queue
    private class Node{
        private E value;
        private Node nextNode;

        public Node(E value){
            this.value = value;
        }

        //returns the node value.
        public E getValue(){
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

    //Iterator for the generic queue
    private class GenericQueueIterator implements Iterator<E> {
        private Node node = head;

        public E next(){
            E nextValue = node.getValue();
            node = node.getNextNode();
            return nextValue;
        }

        public boolean hasNext(){
            return node != null;
        }
    }
}
