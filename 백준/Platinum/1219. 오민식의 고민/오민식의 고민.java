import java.util.*;
import java.io.*;

class Node {
    int start;
    int end;
    int price;

    Node(int start, int end, int price) {
        this.start = start;
        this.end = end;
        this.price = price;
    }
}

public class Main {
    static int N; // 도시 수
    static int sCity; //시작 도시
    static int eCity; // 도착 도시
    static int M; // 엣지 수
    static ArrayList<Node> list; //간선 저장 리스트
    static long[] cityMoney; // 비용 저장
    static long[] distance; // 최소 비용 저장

    public static void main(String[] args) throws IOException {
        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st =
                new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        sCity = Integer.parseInt(st.nextToken());
        eCity = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        // 변수 초기화
        list = new ArrayList<Node>();
        cityMoney = new long[N];
        distance = new long[N];
        Arrays.fill(distance, Long.MIN_VALUE);

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            list.add(new Node(s, e, w));
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            cityMoney[i] = Integer.parseInt(st.nextToken());
        }

        // 벨만-포드 알고리즘 수행
        distance[sCity] = cityMoney[sCity];
        for (int i = 0; i <= N + 100; i++) {
            for (int j = 0; j < M; j++) {
                Node cur = list.get(j);
                // 방문한적 없을 때
                if (distance[cur.start] == Long.MIN_VALUE) {
                    continue;
                } else if (distance[cur.start] == Long.MAX_VALUE) {
                    distance[cur.end] = Long.MAX_VALUE;
                } else if (distance[cur.end] <
                        distance[cur.start] + cityMoney[cur.end] - cur.price) {
                    distance[cur.end] =
                            distance[cur.start] + cityMoney[cur.end] - cur.price;
                    if(i >= N) {
                        distance[cur.end] = Long.MAX_VALUE;
                    }
                }
            }
        }

        if(distance[eCity] == Long.MAX_VALUE) {
            System.out.println("Gee");
        } else if(distance[eCity] == Long.MIN_VALUE) {
            System.out.println("gg");
        } else {
            System.out.println(distance[eCity]);
        }
    }
}