package lw222gz_assign1.exercise_14;

import java.util.Iterator;

/**
 * Created by Lucas on 2016-09-06.
 */
public class LinkedQueueTester {

    private static LinkedQueue queue = new LinkedQueue();

    public static void main(String args[]){
        DummyClass a1 = new DummyClass("Jasper");
        DummyClass a2 = new DummyClass("Suzaku");
        DummyClass a3 = new DummyClass("Cowabunga");
        DummyClass a4 = new DummyClass("Tetris");
        DummyClass a5 = new DummyClass("Kandi");
        DummyClass a6 = new DummyClass("Imagination");
        DummyClass a7 = new DummyClass("Running");
        DummyClass a8 = new DummyClass("Low");

        DummyClass tester;



        //-------------------------------
        //#START SECTION - ERROR HANDLING
        //-------------------------------

        //Test #1
        try{
            System.out.println("\nTest 1: Trying to get first element with nothing in queue, an error message should be displayed:");
            tester = (DummyClass)queue.first();
            System.out.println(tester.getValue());
        }
        catch(Exception e){
            System.err.println(e.getMessage());
        }

        //Test #2
        try{
            System.out.println("\nTest 2: Trying to get last element with nothing in queue, an error message should be displayed:");
            tester = (DummyClass)queue.last();
            System.out.println(tester.getValue());
        }
        catch(Exception e){
            System.err.println(e.getMessage());
        }

        //Test #3
        try{
            System.out.println("\nTest 3: Trying to dequeue first element with nothing in queue, an error message should be displayed:");
            tester = (DummyClass)queue.dequeue();
            System.out.println(tester.getValue());
        }
        catch(Exception e){
            System.err.println(e.getMessage());
        }

        //-----------------------------
        //#END SECTION - ERROR HANDLING
        //-----------------------------


        //-------------------------------
        //#START SECTION - QUEUE TESTING
        //-------------------------------

        //Test #4
        System.out.println("\nTest 4: Trying to check if an element is in the queue when the queue is empty:");
        if(queue.contains(new DummyClass("\"Rule number one of halloween: Don't try to kill anyone over candy. \n"+
                "Now we all know candy is delicious, and worth dying for. But since everyone \n"+
                "is giving out free candy on a day like today, people will undoubtedly try to kill you.\n"+
                "But think about this, imagine if everyone killed everyone else. Then that would mean there \n"+
                "would be none to enjoy that delicious candy.\" \nSrc: https://www.youtube.com/watch?v=Drj8MlixOUQ")))
        {
            System.err.println("This text should not appear. Test to find element in an empty queue failed.");
        }
        else{
            System.out.println("Success.");
        }



        //Test #5
        System.out.println("\nTest 5: Testing to add an object to the queue and then de-queuing that object and the queue size should be 0.");
        queue.enqueue(a1);
        queue.dequeue();
        if(queue.size() == 0){
            System.out.println("Success");
        }
        else{
            System.out.println("The test failed. Size of queue: " + queue.size());
        }

        //Test #6
        System.out.println("\nTest 6: Add several elements to the queue and then deque some of them and finally print out the queue:");
        queue.enqueue(a1);
        queue.enqueue(a2);
        queue.enqueue(a3);
        queue.enqueue(a4);

        //de-queues the 2 first objects, a1 and a2.
        queue.dequeue();
        queue.dequeue();

        System.out.println("The following string should be in the queue: " + a3.getValue() + ", " + a4.getValue());
        printQueue();



        //Test #7
        System.out.println("\nTest 7: Check the contains() method.");
        System.out.println("\nCurrent contents:");
        printQueue();
        System.out.println("\nComparing if the following element value is in the queue: " + a3.getValue());
        if(queue.contains(a3)){
            System.out.println("The element value was found in the queue.");
        }
        else{
            System.out.println("The element value was not found in the queue.");
        }

        System.out.println("\nComparing if the following element value is in the queue: " + a7.getValue());
        if(queue.contains(a7)){
            System.out.println("The element value was found in the queue.");
        }
        else{
            System.out.println("The element value was not found in the queue.");
        }

        //-----------------------------
        //#END SECTION - QUEUE TESTING
        //-----------------------------

    }

    //prints out everything in the given Iterator parameter
    public static void printQueue(){
       int counter = 1;
       Iterator<Object> it = queue.iterator();
       while(it.hasNext()){
           System.out.println(counter + ". " + ((DummyClass)it.next()).getValue());
           counter++;
       }
    }

    //an inner dummy class for testing
    static class DummyClass{
        private String value;

        public DummyClass(String value){
            this.value = value;
        }

        public String getValue(){
            return value;
        }
    }
}
