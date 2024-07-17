import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] T = new int[n+1];
        int[] P = new int[n+1];
        int[] dp = new int[n+2];

        for(int i = 1; i <= n; i++) {
            int t = sc.nextInt();
            int p = sc.nextInt();
            T[i] = t;
            P[i] = p;
        }

        for(int i = n; i > 0; i--) {
            if(i + T[i] > n+1) {
                dp[i] = dp[i+1];
            } else {
                dp[i] = Math.max(
                        P[i] + dp[i + T[i]], dp[i+1]
                );
            }
        }
        System.out.print(dp[1]);
    }
}