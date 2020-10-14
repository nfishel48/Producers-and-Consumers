/**
 * Producer.java
 *
 * This class will be used to run a producer object.
 *
 * @author Nathaniel Fishel
 * @version 1.0 - October 13 2020
 *
 */
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
                    Widget item = createWidget();//Create new object.

                    item.workUpon();//Update the counter of the item.
                    String handled = item.handledBy();//get a value for printing.

                    System.out.println("Worker "+name+" is working on widget"+item.name+" "+handled);
                    Thread.sleep(rand = (int)(100 * Math.random() * range) + min );//Sleep for random time.

                    if(queue.size() == 3){
                        System.out.println("WARNING: Worker "+name+" is waiting to put widget"+item.name+" "+handled+" on conveyer");
                    }
                    
                    System.out.println("Worker "+name+" is placing widget"+item.name+" "+handled+" on the belt");
                    queue.enqueue(item);//Push item to buffer or block.
                    done--;
                }

            }
        
        catch (final Exception e) {
            // Throwing an exception
            System.out.println("Producer Exception is caught");
        }
    }
    private Widget createWidget(){
        Widget wig = new Widget(count);
        count++;
        return wig;
    }

}
