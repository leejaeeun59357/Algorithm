import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        PriorityQueue<Node> pq = new PriorityQueue<>(
                (o1, o2) -> {
                    if (o1.end == o2.end) {
                        return o1.start - o2.start;
                    }
                    return o1.end - o2.end;

                });

        for (int i = 0; i < n; i++) {
            int start = sc.nextInt();
            int end = sc.nextInt();

            pq.offer(new Node(start, end));
        }

        int currentTime = -1;
        int answer = 0;

        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            if (currentTime <= cur.start) {
                currentTime = cur.end;
                answer++;
            }
        }
        System.out.println(answer);
    }


}

class Node {
    int start;
    int end;

    Node() {
    }

    Node(int start, int end) {
        this.start = start;
        this.end = end;
    }
}