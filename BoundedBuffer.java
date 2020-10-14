/**
 * BoundedBuffer.java
 *
 * This program implements the bounded buffer using Java synchronization.
 *
 * @author Nathaniel Fishel
 * @version 1.0 - October 13 2020
 * 
 */

import java.util.LinkedList;
import java.util.*; 

public class BoundedBuffer {
      
    private List queue = new LinkedList(); //Create a list to hold all the Widgets
    private int limit = 3; //Set the limit of the Bounded Buffer
      

    public synchronized void enqueue(Object item) 
        throws InterruptedException 
    { 
        //Block the thread if the buffer is at its limit.
        while (this.queue.size() == this.limit) { 
            wait(); 
        } 
        //When room opens on the buffer wake the thread.
        if (this.queue.size() == 0) { 
            notifyAll(); 
        } 
        this.queue.add(item); 
    } 
      
    public synchronized Object dequeue() 
        throws InterruptedException 
    { 
        //When the buffer is empty block the thread.
        while (this.queue.size() == 0) { 
            wait(); 
        } 
        //When the buffer has somthing in it wake the thread.
        if (this.queue.size() == this.limit) { 
            notifyAll(); 
        } 
      
        return this.queue.remove(0); 
    } 

    //Return the size of the buffer to simplify print statements for user.
    public int size(){
        return this.queue.size();
    }
    
}
