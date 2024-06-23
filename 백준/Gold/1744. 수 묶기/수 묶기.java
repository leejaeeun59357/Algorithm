import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        PriorityQueue<Integer> plus =
                new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> minus =
                new PriorityQueue<>();
        int countOne = 0;
        int countZero = 0;
        int answer = 0;

        for (int i = 0; i < n; i++) {
            int num = sc.nextInt();
            if(num < 0) {
                minus.offer(num);
            } else if (num == 0) {
                countZero++;
            } else if (num==1) {
                countOne++;
            } else {
                plus.offer(num);
            }
        }

        // 양수 처리
        while(plus.size() > 1) {
            int x = plus.remove();
            int y = plus.remove();
            answer += x * y;
        }
        if(!plus.isEmpty()) {
            answer += plus.remove();
        }

        // 음수 처리
        while(minus.size() > 1) {
            int x = minus.remove();
            int y = minus.remove();
            answer += x * y;
        }
        if(!minus.isEmpty() && countZero == 0) {
            answer += minus.remove();
        }

        // 0 처리

        // 1 처리
        answer += countOne;

        System.out.println(answer);
    }
}