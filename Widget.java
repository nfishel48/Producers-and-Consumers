public class Widget {
    
    public static int handled;
    public int name;

    public Widget(int num){
        this.name = num;
        this.handled = 0;
    }


    public static void workUpon(){
        handled++;
    }

    public static String handledBy(){
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
