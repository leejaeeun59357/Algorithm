import java.util.*;
import java.io.*;

class Node {
    int start;
    int end;
    int time;
    Node() {}
    Node(int start, int end, int time) {
        this.start = start;
        this.end = end;
        this.time = time;
    }
}

public class Main {
    static int N;
    static int M;
    static ArrayList<Node> list;
    static long[] dist;
    public static void main(String[] args) throws IOException {
        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st =
                new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        list = new ArrayList<>();
        dist = new long[N+1];
        Arrays.fill(dist, Long.MAX_VALUE);

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());
            list.add(new Node(s, e, t));
        }

        // 벨만-포드 알고리즘 수행
        dist[1] = 0;

        for(int i = 0; i < N-1; i++) {
            for (int j = 0; j < M; j++) {
                Node cur = list.get(j);
                if(dist[cur.start] != Long.MAX_VALUE &&
                dist[cur.end] > dist[cur.start] + cur.time) {
                    dist[cur.end] = dist[cur.start] + cur.time;
                }
            }
        }

        boolean cycle = false;
        for(int i = 0; i < M; i++) {
            Node tmp = list.get(i);
            if(dist[tmp.start] != Long.MAX_VALUE &&
                    dist[tmp.end] > dist[tmp.start] + tmp.time) {
                cycle = true;
            }
        }

        if(cycle) {
            System.out.println("-1");
        } else {
            for(int i = 2; i <= N; i++) {
                if(dist[i] == Long.MAX_VALUE) {
                    System.out.println("-1");
                } else {
                    System.out.println(dist[i]);
                }
            }
        }
    }
}