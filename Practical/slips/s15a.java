
public class s15a {
    public static void main(String[] args) {
        for(char ch = 'a'; ch<= 'z'; ch++){
            System.out.println(ch);
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    
    }
}