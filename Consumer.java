/**
 * Consumer.java
 *
 * This class will be used to run a consumer object.
 *
 * @author Nathaniel Fishel
 * @version 1.0 - October 13 2020
 *
 */
public class Consumer implements Runnable{
    char name;
    int max = 10; 
    int min = 1; 
    int range = max - min + 1; 
    int done = 24;
    int rand;
    int count = 1;
    BoundedBuffer queue;
    
    public Consumer(char letter, BoundedBuffer conveyer){
        this.name = letter;  
        this.queue = conveyer;
    }
    

    public void run() {
        try {
                while(done > 0){
                    if(queue.size() == 0){
                        System.out.println("WARNING: Worker "+name+" is idle!");
                    }

                    Widget item = (Widget)queue.dequeue();//Pull item from buffer or block
                    String handled = item.handledBy();//Get value for ammount of workers that have acted on item.

                    System.out.println("Worker "+name+" is retrieving widget"+item.name+" "+handled+" from the belt");
                    item.workUpon();//Update item count

                    System.out.println("Worker "+name+" is working on widget"+item.name+" "+handled);
                    Thread.sleep(rand = (int)(500 * Math.random() * range) + min );//Sleep for random time.
                    done--;
                }
                System.out.println("Success! ALL WIDGETS CREATED");

            }
        
        catch (final Exception e) {
            // Throwing an exception
            System.out.println("Consumer Exception is caught");
        }
    }
    private Widget createWidget(){
        Widget wig = new Widget(count);
        count++;
        return wig;
    }
    
}
