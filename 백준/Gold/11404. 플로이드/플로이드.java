import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        int[][] distance = new int[n+1][n+1];
        
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= n; j++) {
                if(i == j) {
                    distance[i][j] = 0;
                } else {
                    distance[i][j] = 10000001;
                }
            }
        }
        
        for(int i = 0; i < m; i++) {
            StringTokenizer st =
                new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            if(distance[start][end] > weight) {
                distance[start][end] = weight;
            }
        }
        
        for(int k = 1; k <= n; k++) {
            for(int s = 1; s <= n; s++) {
                for(int e = 1; e <= n; e++) {
                    if(distance[s][e] > distance[s][k] + distance[k][e]) {
                        distance[s][e] = distance[s][k] + distance[k][e];
                    }
                }
            }
        }
        
        for(int i = 1; i <=n; i++) {
            for(int j = 1; j <=n ; j++) {
                if(distance[i][j] == 10000001) {
                    System.out.print("0 ");
                } else {
                    System.out.print(distance[i][j] + " ");
                }
            }
            System.out.println();
        }
    }
}