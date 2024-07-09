import java.util.*;
import java.io.*;

public class Main {
    static ArrayList<ArrayList<Integer>> list;
    static boolean[] visited;
    static int[] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        list = new ArrayList<>();
        visited = new boolean[N+1];
        parent = new int[N+1];

        for(int i = 0; i <= N; i++) {
            list.add(new  ArrayList<Integer>());
        }


        for(int i = 0; i < N-1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int first = Integer.parseInt(st.nextToken());
            int second = Integer.parseInt(st.nextToken());
            list.get(first).add(second);
            list.get(second).add(first);
        }

        BFS(1);

        for(int i = 2; i <= N; i++) {
            System.out.println(parent[i]);
        }
    }

    private static void BFS(int a) {
        Stack<Integer> stack = new Stack<>();
        stack.push(a);
        visited[a] = true;
        parent[a] = a;

        while(!stack.isEmpty()) {
            int cur = stack.pop();
            for(int x : list.get(cur)) {
                if(!visited[x]) {
                    parent[x] = cur;
                    stack.push(x);
                    visited[x] = true;
                }
            }
        }
    }
}