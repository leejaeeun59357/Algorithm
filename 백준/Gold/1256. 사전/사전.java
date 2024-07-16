import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[][] dp = new int[101][101];
    static int N, M, K;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        setUp();
        make();
    }

    private static void setUp() {
        dp[0][0] = 0;
        for (int i = 1; i <= 100; i++) {
            dp[i][0] = 1;
            dp[0][i] = 1;
        }
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                if (dp[i][j] > 1000000000) {
                    dp[i][j] = 1000000000;
                }
            }
        }
    }

    private static void make() {
        int aCnt = N;
        int zCnt = M;
        int as;

        if (K > dp[N][M]) {
            System.out.println(-1);
            return;
        }
        for (int i = 0; i < N + M; i++) {
            if (aCnt == 0) {
                System.out.print("z");
                zCnt--;
                continue;
            } else if (zCnt == 0) {
                System.out.print("a");
                aCnt--;
                continue;
            }
            as = dp[aCnt - 1][zCnt];
            if (K <= as) {
                System.out.print("a");
                aCnt--;
            } else {
                K -= as;
                System.out.print("z");
                zCnt--;
            }
        }
    }
}