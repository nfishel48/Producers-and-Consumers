/**
 * Widget.java
 *
 * This class creates a object to be passed between threads via the bounded buffer.
 *
 * @author Nathaniel Fishel
 * @version 1.0 - October 13 2020
 *
 */
public class Widget extends Object{
    
    public int handled;
    public int name;

    public Widget(int num){
        this.name = num;
        this.handled = 0;
    }


    public void workUpon(){
        handled++;
    }

    public String handledBy(){
        String convey;
        if(handled == 1)
            return convey ="<handled by A>";
        if(handled == 2)
            return convey ="<handled by A, B>";
        if(handled == 3)
            return convey ="<handled by A, B, C>";
        if(handled == 4)
            return convey ="<handled by A, B, C, D>";
        else{
            return convey = "ERROR";
        }
    }

    
}
