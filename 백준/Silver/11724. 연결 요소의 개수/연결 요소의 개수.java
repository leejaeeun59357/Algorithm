import java.util.*;
import java.io.*;

public class Main {
    static boolean[] visited;
    static ArrayList<Integer>[] A;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = 
            new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st =
            new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        A = new ArrayList[N+1];
        visited = new boolean[N+1];
        
        // 인접리스트 초기화
        for(int i =1; i<= N ; i++) {
            A[i] = new ArrayList<Integer>();
        }
        
        for(int i =0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            A[x].add(y);
            A[y].add(x);
        }
        int answer = 0;
        for(int i =1; i<= N; i++) {
            if(!visited[i]) {
                answer++;
                DFS(i);
            }
        }
        System.out.println(answer);
    }
    
    private static void DFS(int i) {
        if(visited[i]) {
            return;
        }
        visited[i] = true;
        for(int x : A[i]) {
            if(!visited[x]) {
                DFS(x);
            }
        }
    }
}