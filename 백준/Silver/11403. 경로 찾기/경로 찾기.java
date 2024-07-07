import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] distance = new int[n+1][n+1];
        
        for(int i = 1; i <= n; i++) {
            StringTokenizer st =
                new StringTokenizer(br.readLine());
            for(int j =1; j <= n; j++) {
                distance[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        // 플로이드-워셜 알고리즘 수행
        for(int k = 1; k <= n; k++) {
            for(int s = 1; s <=n; s++) {
                for(int e = 1; e <=n ; e++) {
                    if(distance[s][k] == 1 && distance[k][e] == 1) {
                        distance[s][e] = 1;
                    }
                }
            }
        }
        
        for(int i = 1; i <=n; i++) {
            for(int j =1; j <= n; j++) {
                System.out.print(distance[i][j] + " ");
            }
            System.out.println();
        }
    }
}