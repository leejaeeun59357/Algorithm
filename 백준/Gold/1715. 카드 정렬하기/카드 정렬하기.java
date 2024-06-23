import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 0; i < n; i++) {
            int num = sc.nextInt();
            pq.offer(num);
        }
        int answer = 0;
        while (pq.size() != 1) {
            int x = pq.poll();
            int y = pq.poll();
            answer += x + y;
            pq.offer(x + y);
        }

        System.out.println(answer);
    }
}