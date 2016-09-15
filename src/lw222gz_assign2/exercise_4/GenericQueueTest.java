package lw222gz_assign2.exercise_4;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;

import static org.junit.Assert.*;

/**
 * Created by Lucas on 2016-09-15.
 */
public class GenericQueueTest {
    private GenericQueue queueTestObj;

    @Before
    public void setUp() throws Exception {
        queueTestObj = new GenericQueue();
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void size() throws Exception {
        //Test Queue.1.1: Tests to get size of empty queue.
        assertEquals(queueTestObj.size(), 0);

        //Test Queue.1.2: Test to get the size of a queue with elements in it.
        //Note: dependent on enqueue method
        queueTestObj.enqueue("Hasta");
        assertEquals(queueTestObj.size(), 1);

        //Test Queue.1.3: Extreme case, 10000 elements added.
        //Note: Dependent on enqueue() method
        for(int i= 0; i < 10000; i++){
            queueTestObj.enqueue("la vista");
        }
        assertEquals(queueTestObj.size(), 10001);

    }

    @Test
    public void isEmpty() throws Exception {
        //Test Queue.2.1: Testing so that isEmpty() returns true with no elements in queue
        assertTrue(queueTestObj.isEmpty());

        //Test Queue.2.2: Testing so that isEmpty() returns false with elements in queue
        //Note: dependent on method enqueue
        queueTestObj.enqueue("ARCANITE REAPER! HYAAAAAAAA!");
        assertTrue(!queueTestObj.isEmpty());
    }

    @Test
    public void enqueue() throws Exception {
        //Test Queue.3.1: Testing to add an element to the queue, then check so that it was added
        String value = "Did you know a bear has 42 teeth";
        queueTestObj.enqueue(value);
        assertEquals(queueTestObj.size(), 1);

        //Test Queue.3.2: Extreme test, testing to add another 10000 elements
        for(int i = 0; i < 10000; i++){
            queueTestObj.enqueue("Did you know rabbits like licorice");
        }

        assertEquals(queueTestObj.size(), 10001);

    }

    @Test
    public void dequeue() throws Exception {
        //Test Queue.4.1: Testing to dequeue an empty queue
        //Expecting IndexOutOfBoundsException
        try{
            queueTestObj.dequeue();
            fail("This line should not have been reached. Test Queue.4.1");
        }
        catch (IndexOutOfBoundsException e){
            assert(true);
        }


        //Test Queue.4.2: Testing to add several elements and then dequing, the first element added should be the one to be dequeued
        //Note: dependent on method enqueue()
        String first = "Did you know birds need gravity to swallow";
        queueTestObj.enqueue(first);
        queueTestObj.enqueue("Did you know the most commonly used letter in the alphabet is E");
        queueTestObj.enqueue("Did you knowCoca-Cola originally contained cocaine");
        queueTestObj.enqueue("Did you knowKoalas sleep around 18 hours a day");

        assertEquals(queueTestObj.dequeue(), first);

        //Test Queue.4.3: Testing to see the reduction of of the queue size when dequeue'ing
        int currentSize = queueTestObj.size();
        if(currentSize <= 0){
            throw new IllegalStateException("The current size of the queue must be higher than 0 for this test.");
        }
        queueTestObj.dequeue();
        assertEquals(queueTestObj.size(), currentSize - 1);
    }

    @Test
    public void first() throws Exception {
        //Test Queue.5.1: Testing to get the first element on an empty queue
        //IndexOutOfBoundsException expected
        try{
            queueTestObj.first();
            fail("This line should not have been reached. Test Queue.5.1");
        }
        catch(IndexOutOfBoundsException e){
            assert(true);
        }

        //Test Queue.5.2: Testing to get the first element in a queue with several elements added.
        //Note: Dependent on enqueue() method
        String first = "Did you know sponges hold more cold water than hot";
        queueTestObj.enqueue(first);
        queueTestObj.enqueue("Did you know camel's milk doesn't curdle");
        queueTestObj.enqueue("Did you know a 1 minute kiss burns 26 calories");

        assertEquals(queueTestObj.first(), first);
    }

    @Test
    public void last() throws Exception {
        //Test Queue.6.1: Testing to get the last element on an empty queue
        //IndexOutOfBoundsException expected
        try{
            queueTestObj.first();
            fail("This line should not have been reached. Test Queue.5.1");
        }
        catch(IndexOutOfBoundsException e){
            assert(true);
        }

        //Test Queue.6.2: Testing to get the last element in a queue with one element
        //Note: Dependent on enqueue() method
        String element = "Did you know at birth dalmations are always white";
        queueTestObj.enqueue(element);
        assertEquals(queueTestObj.last(), element);

        //Test Queue.6.3: Testing to get the last element in a queue with several elements
        //Note: Dependent on enqueue() method
        String last = "Did you know a duck can't walk without bobbing its head";
        queueTestObj.enqueue("Did you know cows don't have upper front teeth");
        queueTestObj.enqueue("Did you know the brand Nokia is named after a place in Southern Finland");
        queueTestObj.enqueue(last);
        assertEquals(queueTestObj.last(), last);

    }

    @Test
    public void iterator() throws Exception {
        //Test Queue.7.1: Testing to iterate on an empty queue.
        Iterator it = queueTestObj.iterator();
        while(it.hasNext()){
            fail("This line should not have been reached. Test Queue.7.1");
            it.next();
        }

        //Test Queue.7.2: Testing to add elements to the queue then iterating them out in the correct order.
        //Note: dependent on enqueue method.
        String[] myFacts = new String[] {"Did you know Jamaica has 120 rivers",
                "Did you know a cats urine glows under a blacklight",
                "Did you know paper originated from China",
                "Did you know tree hugging is forbidden in china",
                "Did you know instant coffee was invented in 1901",
                "Did you know Pearls melt in vinegar",
                "Did you know there is no butter in buttermilk",
                "Did you know tennis was originally played with bare hands",
                "Did you know Porsche also builds tractors",
                "Did you know Hawaii was originally called the Sandwich Islands",
                "Did you know Americans throw away 44 million newspapers a day",
                "Did you know Einstein slept 10 hours a night",
                "Did you know Germany borders 9 other countries"
        };

        for(String fact: myFacts){
            queueTestObj.enqueue(fact);
        }

        it = queueTestObj.iterator();

        int count = 0;
        while(it.hasNext()){
            assertTrue(it.next() == myFacts[count]);
            count++;
        }
    }

}