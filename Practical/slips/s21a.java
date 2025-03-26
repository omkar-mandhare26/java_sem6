class MyThread extends Thread {
    public MyThread(String name) {
        super(name);
    }

    @Override
    public void run() {
        System.out.println("Thread Name: " + getName());
        System.out.println("Thread Priority: " + getPriority());
    }
}

public class s21a {
    public static void main(String[] args) {
        MyThread thread1 = new MyThread("Thread-1");
        thread1.setPriority(Thread.MIN_PRIORITY);
        
        MyThread thread2 = new MyThread("Thread-2");
        thread2.setPriority(Thread.MAX_PRIORITY);
        
        thread1.start();
        thread2.start();
    }
}