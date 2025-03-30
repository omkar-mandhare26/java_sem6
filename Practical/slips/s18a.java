public class s18a {
    static int fact(int n) {
        if (n == 1 || n == 0)
            return 1;
        return n * fact(n - 1);
    }

    public static void main(String[] args) {
        try {
            int n = 5;
            System.out.println("Sleeping for 5s");
            Thread.sleep(5000);
            System.out.println("Factorial of " + n + ": " + fact(n));
        } catch (InterruptedException e) {
        }
    }
}
