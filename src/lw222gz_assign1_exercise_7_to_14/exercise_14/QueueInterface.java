
/**
 * QueueInterface.java
 * Updated with exceptions 9 sep 2015
 */

import java.util.Iterator;
import java.lang.IndexOutOfBoundsException;


public interface QueueInterface {

	    int size();                          // current queue size 
	    
	    boolean isEmpty();                   // true if queue is empty
	    
	    void enqueue(Object element);        // add element at end of queue
	    
	    Object dequeue() throws IndexOutOfBoundsException;     // return and remove first element.
	    
	    Object first() throws IndexOutOfBoundsException;       // return (without removing) first element
	    
	    Object last() throws IndexOutOfBoundsException;        // return (without removing) last element

	    boolean contains(Object o);			 // return "true" if this queue contains the specified element
	    
	    Iterator iterator();                 // element iterator
	
}

