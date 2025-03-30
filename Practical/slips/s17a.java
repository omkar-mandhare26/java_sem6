import java.util.Scanner;

public class s17a {
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter a string:");
            String input = scanner.nextLine();
            scanner.close();

            for (int i = 0; i < input.length(); i++) {
                char curr = input.toLowerCase().charAt(i);
                if (curr == 'a' || curr == 'e' || curr == 'i' || curr == 'o' || curr == 'u') {
                    Thread.sleep(3000);
                    System.out.println("Vowel: " + curr);
                }
            }
        } catch (InterruptedException e) {
        }
    }
}
