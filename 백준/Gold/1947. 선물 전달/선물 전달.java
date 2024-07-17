import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long[] D = new long[1000001];
        D[1] = 0;
        D[2] = 1;
        for(int i = 3; i <= n; i++) {
            D[i] = ((i - 1) * (D[i-2] + D[i-1])) % 1000000000;
        }
        System.out.print(D[n]);
    }
}