import java.lang.*;
public class Producer implements Runnable {
    
    char name;
     //define the range 
     int max = 10; 
     int min = 1; 
     int range = max - min + 1; 
     int rand;

    public Producer(char letter){
        this.name = letter;
        this.rand = (int)(Math.random() * range) + min; 
    }
    

    public void run() {
        try {
                Widget item = createWidget();
                Thread.sleep(rand);

            }
        
        catch (final Exception e) {
            // Throwing an exception
            System.out.println("Exception is caught");
        }
    }
    private Widget createWidget(){
        Widget wig = new Widget();
        return wig;
    }

}
