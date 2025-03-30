import java.util.Random;

class s12b implements Runnable {
    private String threadName;

    public s12b(String name) {
        this.threadName = name;
    }

    public void run() {
        System.out.println(threadName + " is created.");
        int sleepTime = new Random().nextInt(2500);
        System.out.println(threadName + " will sleep for " + sleepTime + " ms.");
        try {
            Thread.sleep(sleepTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(threadName + " is dead.");
    }

    public static void main(String[] args) {
        Thread thread1 = new Thread(new s12b("Thread-1"));
        Thread thread2 = new Thread(new s12b("Thread-2"));

        thread1.start();
        thread2.start();
    }
}