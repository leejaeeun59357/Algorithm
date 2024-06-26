import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        for(int i = 0; i < t; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            System.out.println(a * b / gcd(a,b));
        }

    }

    private static int gcd(int a, int b) {
        int first = Math.max(a,b);
        int second = Math.min(a,b);

        while(true) {
            int nameogi = first % second;
            if(nameogi == 0) {
                return second;
            }
            first = second;
            second = nameogi;
        }
    }
}