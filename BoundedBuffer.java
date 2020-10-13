import java.util.LinkedList;
import java.util.Queue;

public class BoundedBuffer {
    
    Queue<Widget> queue = new LinkedList<>();//declare a queue for widgets to be pushed into.


    public void send(Widget item) {
        if(queue.size() == 3)
            System.out.println("WARNING conveyer is full");
        else
            queue.add(item);
    }

    public Object receive() {
        Widget item;
        
        if (queue.size() == 0)
           return null;
        else {
           item = queue.remove();         
           return item;
        }
    }

    
}
