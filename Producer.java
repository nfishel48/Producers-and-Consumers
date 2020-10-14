import java.lang.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.*; 
public class Producer implements Runnable {
    
    char name;
    int max = 10; 
    int min = 1; 
    int range = max - min + 1; 
    int done = 24;
    int rand;
    int count = 1;
    BoundedBuffer queue;
    public Producer(char letter, BoundedBuffer conveyer){
        this.name = letter;  
        this.queue = conveyer;
    }
    

    public void run() {
        try {
                while(done > 0){
                    Widget item = createWidget();
                    item.workUpon();
                    String handled = item.handledBy();
                    System.out.println("Worker "+name+" is working on widget"+item.name+" "+handled);
                    Thread.sleep(rand = (int)(500 * Math.random() * range) + min );
                    queue.enqueue(item);
                    done--;
                }

            }
        
        catch (final Exception e) {
            // Throwing an exception
            System.out.println("Exception is caught");
        }
    }
    private Widget createWidget(){
        Widget wig = new Widget(count);
        count++;
        return wig;
    }

}
