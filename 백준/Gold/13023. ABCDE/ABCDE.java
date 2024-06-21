import java.util.*;
import java.io.*;

public class Main {
    static ArrayList<Integer>[] A;
    static boolean[] visited;
    static boolean arrive;

    public static void main(String[] args) throws IOException {
        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st =
                new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());

        A = new ArrayList[n];
        visited = new boolean[n];
        arrive = false;

        // 리스트 초기화
        for (int i = 0; i < n; i++) {
            A[i] = new ArrayList<Integer>();
        }

        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            A[x].add(y);
            A[y].add(x);
        }

        for(int i = 0 ; i < n; i++) {
            DFS(i, 1);
            if(arrive) {
                break;
            }
        }
        if(arrive) {
            System.out.println("1");
        } else {
            System.out.println("0");
        }

    }

    private static void DFS(int n, int count) {
        if(count == 5 || arrive) {
            arrive = true;
            return;
        }

        visited[n] = true;
        
        for(int i : A[n]) {
            if(!visited[i]) {
                DFS(i, count + 1);
            }
        }
        visited[n] = false;
    }
}