public class s21a extends Thread {
    s21a(String name) {
        setName(name);
    }

    public void run() {
        System.out.println("Thread Name: " + getName());
        System.out.println("Thread Priority: " + getPriority());
    }

    public static void main(String[] args) {
        s21a thread1 = new s21a("Thread-1");
        thread1.setPriority(Thread.MIN_PRIORITY);
        thread1.start();
    }
}