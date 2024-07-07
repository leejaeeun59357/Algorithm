import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st =
            new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] distance = new int[n+1][n+1];
        
        for(int i = 1; i <= n; i++) {
            for(int j =1; j <=n; j++) {
                if(i == j) {
                    distance[i][j] = 0;
                } else {
                    distance[i][j] = 10000001;
                }
            }
        }
        
        for(int i = 0; i< m; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            distance[start][end] = 1;
            distance[end][start] = 1;
        }
        
        for (int k = 1; k <= n; k++) { // 플로이드 워셜 알고리즘 수행
      for (int i = 1; i <= n; i++) {
        for (int j = 1; j <= n; j++) {
          if (distance[i][j] > distance[i][k] + distance[k][j])
            distance[i][j] = distance[i][k] + distance[k][j];
        }
      }
    }
        int index= -1;
        int sum = Integer.MAX_VALUE;
        for(int i = 1; i <= n; i++) {
            int tmp = 0;
            for(int j = 1; j <=n; j++) {
                tmp += distance[i][j];
            }
            if(sum > tmp) {
                sum = tmp;
                index = i;
            }
        }
        System.out.print(index);
    }
}