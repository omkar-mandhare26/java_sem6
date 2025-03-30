class SharedResource {
    synchronized void printNumbers(String threadName) {
        for (int i = 1; i <= 5; i++) {
            System.out.println(threadName + " prints: " + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class s28a extends Thread {
    private SharedResource resource;

    public s28a(SharedResource resource, String name) {
        this.resource = resource;
        setName(name);
    }

    public void run() {
        resource.printNumbers(getName());
    }

    public static void main(String[] args) {
        SharedResource obj = new SharedResource();
        s28a t1 = new s28a(obj, "Thread-1");
        s28a t2 = new s28a(obj, "Thread-2");

        t1.start();
        t2.start();
    }
}
