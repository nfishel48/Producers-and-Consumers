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
                    if(queue.size() == 0){
                        System.out.println("WARNING: Worker "+name+" is idle!");
                    }
                    Widget item = (Widget)queue.dequeue();
                    String handled = item.handledBy();
                    System.out.println("Worker "+name+" is retrieving widget"+item.name+" "+handled+" from the belt");
                    item.workUpon();
                    System.out.println("Worker "+name+" is working on widget"+item.name+" "+handled);
                    Thread.sleep(rand = (int)(500 * Math.random() * range) + min );
                    if(queue2.size() == 3){
                        System.out.println("WARNING: Worker "+name+" is waiting to put widget"+item.name+" "+handled+" on conveyer");
                    }
                    System.out.println("Worker "+name+" is placing widget"+item.name+" "+handled+" on the belt");
                    queue2.enqueue(item);
                    
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
