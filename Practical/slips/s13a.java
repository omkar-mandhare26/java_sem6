class s13a extends Thread {
    public void run() {
        System.out.println("Currently executing thread: " + Thread.currentThread().getName());
    }

    public static void main(String[] args) {
        Thread thread1 = new Thread(new s13a(), "Thread-1");
        Thread thread2 = new Thread(new s13a(), "Thread-2");

        thread1.start();
        thread2.start();
    }
}
