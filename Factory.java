public class Factory {
    
    public static void main(String[] args){
        
        Thread workerA = new Thread(new Producer()); //Create a worker that  will only produce widgets
        Thread workerB = new Thread(new Worker()); //Create worker that can consume and produce
        Thread workerC = new Thread(new Worker()); //Create worker that can consume and produce
        Thread workerD = new Thread(new Consumer()); //Create worker that will only consume widgets
    }
}
