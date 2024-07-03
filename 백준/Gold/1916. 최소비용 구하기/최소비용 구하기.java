import java.util.*;
import java.io.*;

class Node implements Comparable<Node> {
    int end;
    int weight;
    Node() {};
    Node(int end, int weight) {
        this.end = end;
        this.weight = weight;
    }
    @Override
    public int compareTo(Node o) {
        return this.weight - o.weight;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());  // 도시 수 (노드 수)
        int M = Integer.parseInt(br.readLine());  // 버스 수 (엣지 수)
        int[] distance = new int[N+1];
        List<ArrayList<Node>> list = new ArrayList<>();
        for(int i = 0; i <= N; i++) {
            list.add(new ArrayList<>());
        }
        Arrays.fill(distance, Integer.MAX_VALUE);
        
        for(int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());
            list.get(start).add(new Node(end,value));
        }
        StringTokenizer st = new StringTokenizer(br.readLine());
        int startCity = Integer.parseInt(st.nextToken());
        int arrivedCity = Integer.parseInt(st.nextToken());
        
        distance[startCity] = 0;
        
        PriorityQueue<Node> queue = new PriorityQueue<>();
        boolean[] check = new boolean[N+1];
        queue.offer(new Node(startCity, 0));
        
        while(!queue.isEmpty()) {
            Node cur = queue.poll();
            if(check[cur.end]) {
                continue;
            }
            check[cur.end] = true;
            for(Node node : list.get(cur.end)) {
                if(distance[node.end] > distance[cur.end] + node.weight) {
                    distance[node.end] = distance[cur.end] + node.weight;
                    queue.offer(new Node(node.end, distance[node.end]));
                }
            }
        }
        System.out.print(distance[arrivedCity]);
    }
}