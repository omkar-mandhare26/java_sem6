public class s13a implements Runnable {
    public void run() {
        System.out.println("Currently executing thread: " + Thread.currentThread().getName());
    }

    public static void main(String[] args) {
        s13a runnableInstance = new s13a();
        
        Thread thread1 = new Thread(runnableInstance, "Thread1");
        Thread thread2 = new Thread(runnableInstance, "Thread2");
        
        thread1.start();
        thread2.start();
    }
}