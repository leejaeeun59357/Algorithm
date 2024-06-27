import java.util.*;

public class Main {
    static ArrayList<Integer>[] A;
    static int[] visited;
    static ArrayList<Integer> answer;

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();  // 노드 수
        int m = sc.nextInt();  // 간선 수
        int k = sc.nextInt();  // 일치해야 할 최단경로 길이
        int x = sc.nextInt();  // 시작 노드

        A = new ArrayList[n+1];
        answer = new ArrayList<>();
        visited = new int[n+1];

        for (int i = 1; i <= n ; i++) {
            A[i] = new ArrayList<>();
            visited[i] = -1;
        }

        for (int i = 0; i < m; i++) {
            int from = sc.nextInt();
            int to = sc.nextInt();

            A[from].add(to);
        }

        bfs(x);

        for (int i = 1; i <= n; i++) {
            if(visited[i] == k) {
                answer.add(i);
            }
        }

        if(answer.size() == 0) {
            System.out.println("-1");
            return;
        }

        Collections.sort(answer);

        for (int answerVal : answer) {
            System.out.println(answerVal);
        }

    }

    private static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start]++;
        while(!queue.isEmpty()) {
            int cur = queue.poll();
            for(int x : A[cur]) {
                if(visited[x] == -1) {
                    queue.add(x);
                    visited[x] = visited[cur] + 1;
                }
            }
        }
    }

}