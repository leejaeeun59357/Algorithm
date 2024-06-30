import java.util.*;
import java.io.*;

public class Main {
    static int n;
    static int m;
    static int[] parent;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        parent = new int[n + 1];

        // 자기 자신으로 초기화
        for (int i = 0; i <= n; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int first = Integer.parseInt(st.nextToken());
            int second = Integer.parseInt(st.nextToken());
            int third = Integer.parseInt(st.nextToken());

            if (first == 0) {
                union(second, third);
            } else {
                if(checkSame(second,third)) {
                    System.out.println("YES");
                } else {
                    System.out.println("NO");
                }
            }
        }

    }

    private static void union(int a, int b) {
        a = find(a);
        b = find(b);
        
        if(a != b) {
            parent[b] = a;
        }
    }
    
    private static int find(int a) {
        if(parent[a] == a) {
            return a;
        } else {
            return parent[a] = find(parent[a]);
        }
    }
    
    private static boolean checkSame(int a, int b) {
        a = find(a);
        b = find(b);
        
        if(a == b) {
            return true;
        }
        return false;
    }
}