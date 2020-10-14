/**
 * Worker.java
 *
 * This class will be used to run a consumer and producer object.
 *
 * @author Nathaniel Fishel
 * @version 1.0 - October 13 2020
 *
 */

public class Worker implements Runnable{
    char name;
    int max = 10; 
    int min = 1; 
    int range = max - min + 1; 
    int done = 24;
    int rand;
    int count = 1;
    BoundedBuffer queue;
    BoundedBuffer queue2;
    
    public Worker(char letter, BoundedBuffer conveyer, BoundedBuffer conveyer2){
        this.name = letter;  
        this.queue = conveyer;
        this.queue2 = conveyer2;
    }
    

    public void run() {
        try {
                while(done > 0){
                    //Notify the user if the worker will be idle
                    if(queue.size() == 0){
                        System.out.println("WARNING: Worker "+name+" is idle!");
                    }

                    Widget item = (Widget)queue.dequeue(); //Pull an item from the buffer or block.
                    String handled = item.handledBy(); //Get a value for how many workers have acted on this item

                    System.out.println("Worker "+name+" is retrieving widget"+item.name+" "+handled+" from the belt");
                    item.workUpon(); //Update the item counter
                    System.out.println("Worker "+name+" is working on widget"+item.name+" "+handled);
                    Thread.sleep(rand = (int)(500 * Math.random() * range) + min ); //Sleep for a random time

                    //Notify user that the buffer is full 
                    if(queue2.size() == 3){
                        System.out.println("WARNING: Worker "+name+" is waiting to put widget"+item.name+" "+handled+" on conveyer");
                    }

                    System.out.println("Worker "+name+" is placing widget"+item.name+" "+handled+" on the belt");
                    queue2.enqueue(item); //Push item into the buffer or block.
                    
                    done--;
                }

            }
        
        catch (final Exception e) {
            // Throwing an exception
            System.out.println("Worker Exception is caught");
        }
    }
    private Widget createWidget(){
        Widget wig = new Widget(count);
        count++;
        return wig;
    }
}
