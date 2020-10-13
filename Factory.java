public class Factory {
    
    public static void main(String[] args){
        
        Thread workerA = new Thread(new Producer('A')); //Create a worker that  will only produce widgets
        Thread workerB = new Thread(new Worker('B')); //Create worker that can consume and produce
        Thread workerC = new Thread(new Worker('C')); //Create worker that can consume and produce
        Thread workerD = new Thread(new Consumer('D')); //Create worker that will only consume widgets
    }
}
