import java.util.*;
import java.io.*;

public class Main {
    static class Node {
        int start;
        int end;
        int weight;
        Node() {}
        Node(int start, int end, int weight) {
            this.start = start;
            this.end = end;
            this.weight = weight;
        }
    }
    static int[] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = 
            new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st =
            new StringTokenizer(br.readLine());
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        
        parent = new int[V+1];
        for(int i = 0; i <= V; i++) {
            parent[i] = i;
        }
        
        PriorityQueue<Node> pq = new PriorityQueue<>(
        (o1, o2) -> {
            return o1.weight - o2.weight;
        });
        
        int s, e, w;
        for(int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            s = Integer.parseInt(st.nextToken());
            e = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());
            pq.offer(new Node(s, e, w));
        }
        
        int weightSum = 0;
        int cnt = 0;
        
        while(!pq.isEmpty()) {
            Node cur = pq.poll();
            if(union(cur.start, cur.end)) {
                weightSum += cur.weight;
                cnt++;
            }
            
            if(cnt == V-1) {
                break;
            }
        }
        
        System.out.print(weightSum);
    }
    
    private static boolean union(int a, int b) {
        a = find(a);
        b = find(b);
        
        // 사이클이 존재하면 false 반환
        if(a == b) {
            return false;
        } else {
            // 사이클 X -> true
            parent[b] = a;
            return true;
        }
    }
    
    private static int find(int a) {
        if(parent[a] == a) {
            return a;
        } else {
            return parent[a] = find(parent[a]);
        }
    }
}