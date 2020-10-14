import java.util.LinkedList;
import java.util.Queue;
import java.util.*; 

public class BoundedBuffer {
      
    private List queue = new LinkedList(); 
    private int limit = 3; 
      

    public synchronized void enqueue(Object item) 
        throws InterruptedException 
    { 
        while (this.queue.size() == this.limit) { 
            wait(); 
        } 
        if (this.queue.size() == 0) { 
            notifyAll(); 
        } 
        this.queue.add(item); 
    } 
      
    public synchronized Object dequeue() 
        throws InterruptedException 
    { 
        while (this.queue.size() == 0) { 
            wait(); 
        } 
        if (this.queue.size() == this.limit) { 
            notifyAll(); 
        } 
      
        return this.queue.remove(0); 
    } 
    
}
