class findNums {
    public synchronized void findOddNums(int n) {
        System.out.println("Odd numbers from 1 to " + n + ":");
        for (int i = 1; i <= n; i += 2) {
            System.out.println(i);
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public synchronized void findPrimeNums(int n) {
        System.out.println("Prime numbers from 1 to " + n + ":");
        for (int i = 2; i <= n; i++) {
            if (isPrime(i)) {
                System.out.println(i);
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private boolean isPrime(int num) {
        if (num < 2)
            return false;
        for (int j = 2; j <= (int) num / 2; j++) {
            if (num % j == 0)
                return false;
        }
        return true;
    }

}

class OddNumberThread extends Thread {
    private int n;
    private findNums obj;

    OddNumberThread(int n, findNums obj) {
        this.n = n;
        this.obj = obj;
    }

    public void run() {
        obj.findOddNums(n);
    }
}

class PrimeNumberThread extends Thread {
    private int n;
    private findNums obj;

    PrimeNumberThread(int n, findNums obj) {
        this.n = n;
        this.obj = obj;
    }

    public void run() {
        obj.findPrimeNums(n);
    }
}

public class s29a {
    public static void main(String[] args) {
        findNums obj = new findNums();
        OddNumberThread onObj = new OddNumberThread(10, obj);
        PrimeNumberThread pnObj = new PrimeNumberThread(100, obj);

        onObj.start();
        pnObj.start();
    }
}
