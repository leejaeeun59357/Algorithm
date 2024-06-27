import java.io.*;
import java.util.*;

public class Main {
    static boolean visited[]  = new boolean[10001];
    static ArrayList<Integer> A[] = new ArrayList[10001];
    static int answer[] = new int[10001];
    static Queue<Integer> queue = new LinkedList<>();
    
    public static void main(String[] args) throws Exception {

        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st =
                new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());  // 노드수
        int m = Integer.parseInt(st.nextToken());  // 간선 수

        for(int i = 1; i <= n; i++) {
            A[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            A[start].add(end);
        }

        for (int i = 1; i <= n ; i++) {

            for (int j = 1; j <= n ; j++) {
                visited[j] = false;
            }

            bfs(i);
        }

        int max = Arrays.stream(answer).max().getAsInt();

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n ; i++) {
            if(answer[i] == max) {
                sb.append(i + " ");
            }
        }
        System.out.println(sb);

    }
    private static void bfs(int start) {
        queue.add(start);
        visited[start] = true;

        while(!queue.isEmpty()) {
            int curNum = queue.poll();
            for(int x : A[curNum]) {
                if(visited[x]) {
                    continue;
                }
                visited[x] = true;
                answer[x]++;
                queue.add(x);
            }
        }
    }
}