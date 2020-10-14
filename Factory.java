
public class Factory {
    
    public static void main(String[] args){
        
        BoundedBuffer conveyorAB = new BoundedBuffer();
        BoundedBuffer conveyorBC = new BoundedBuffer();
        BoundedBuffer conveyorCD = new BoundedBuffer();

        Thread workerA = new Thread(new Producer('A', conveyorAB)); //Create a worker that  will only produce widgets
        Thread workerB = new Thread(new Worker('B',conveyorAB, conveyorBC)); //Create worker that can consume and produce
        Thread workerC = new Thread(new Worker('C',conveyorBC, conveyorCD)); //Create worker that can consume and produce
        Thread workerD = new Thread(new Consumer('D', conveyorCD)); //Create worker that will only consume widgets

        workerA.start();
        workerB.start();
        workerC.start();
        workerD.start();
    }
}
