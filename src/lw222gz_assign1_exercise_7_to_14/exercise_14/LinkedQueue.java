package lw222gz_assign1_exercise_7_to_14.exercise_14;

/**
 * Created by Lucas on 2016-09-06.
 */
public class LinkedQueue implements QueueInterface {

    //int representing the size of the queue
    private int size = 0;
    //head Node represents the first node in the queue
    private Node head = null;
    //tail Node representing the last node in the queue
    private Node tail = null;

    //returns current queue size
    public int size() {
        return size;
    }

    //returns true if queue is empty
    public boolean isEmpty(){
        return head == null;
    }

    //add element at end of queue
    public void enqueue(Object element){
        //If the queue head is empty then the queue is empty and
        //the queue head and tail values are set to the new element
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

    //return and remove first element.
    public Object dequeue() throws IndexOutOfBoundsException{
        if(isEmpty()){
            throw new IndexOutOfBoundsException("The queue is empty.");
        }
        else{
            Node firstNode = head;
            head = head.getNextNode();
            //if the new head value is null then the list is empty.
            if(head == null){
                tail = null;
            }
            size--;
            return firstNode;
        }
    }

    //return (without removing) first element
    public Object first() throws IndexOutOfBoundsException{
        if(isEmpty()){
            throw new IndexOutOfBoundsException("The queue is empty");
        }
        return head.getValue();
    }

    //return (without removing) last element
    public Object last() throws IndexOutOfBoundsException{
        if(isEmpty()){
            throw new IndexOutOfBoundsException("The queue is empty");
        }
        return tail.getValue();
    }

    //return "true" if this queue contains the specified element
    public boolean contains(Object o){
        if(isEmpty()){
            return  false;
        }

        Node node = head;
        while(true){
            if(node.getValue() == o){
                return true;
            }

            node = node.getNextNode();
            //if the next node to check for it's value is null the
            //queue has been searched through and the Object was not found.
            if(node == null){
                return false;
            }
        }
    }

    //element iterator
    public Iterator iterator(){
        return new Iterator(head);
    }

    //inner class causes an edit in the interface, can this be avoided at any
    /*class Iterator {

        private Node node = head;



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
    }*/
}
