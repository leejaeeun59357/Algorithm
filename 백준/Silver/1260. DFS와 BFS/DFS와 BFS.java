import java.util.*;
import java.io.*;

public class Main {
    static ArrayList<Integer>[] A;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int v = sc.nextInt();

        A = new ArrayList[n+1];

        for (int i = 1; i <= n; i++) {
            A[i] = new ArrayList<Integer>();
        }

        for (int i = 0; i < m; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            A[x].add(y);
            A[y].add(x);
        }
        for (int i = 1; i <= n ; i++) {
            Collections.sort(A[i]);
        }

        visited = new boolean[n+1];
        DFS(v);
        System.out.println();

        visited = new boolean[n+1];
        BFS(v);
    }
    private static void BFS(int start) {
        if(visited[start]) {
            return;
        }
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = true;

        while(!queue.isEmpty()) {
            int curNum = queue.remove();
            System.out.print(curNum + " ");
            for(int x : A[curNum]) {
                if(!visited[x]) {
                    queue.add(x);
                    visited[x] = true;
                }
            }
        }
    }

    private static void DFS(int start) {
        System.out.print(start + " ");

        visited[start] = true;

        for(int x : A[start]) {
            if(!visited[x]) {
                DFS(x);
            }
        }
    }
}