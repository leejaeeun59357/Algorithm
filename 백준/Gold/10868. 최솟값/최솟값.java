import java.util.*;

public class Main {
    static int k;
    static long[] arr;
    static long INF = 1000000001;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); // 숫자 갯수
        int M = sc.nextInt(); // 질의 갯수

        while(true) {
            if(Math.pow(2, k) >= N)
                break;
            k++;
        }
        int startIdx = (int)Math.pow(2,k);
        arr = new long[startIdx * 2];
        Arrays.fill(arr, INF);

        for(int i = 0; i < N; i++) {
            arr[startIdx + i] = sc.nextLong();
        }
        updateData(startIdx - 1);

        for(int i = 0; i < M; i++) {
            int start = sc.nextInt();
            int end = sc.nextInt();
            getMin(start, end);
        }

    }
    private static void updateData(int startIdx) {
        for(int i = startIdx; i > 0; i--) {
            arr[i] = Math.min(arr[2 * i] , arr[(2 * i) + 1]);
        }
    }
    
    private static void getMin(int start, int end) {
        start = start + (int)Math.pow(2, k) - 1;
        end = end + (int) Math.pow(2, k) - 1;
        long answer = Long.MAX_VALUE;
        while(start <= end) {
            if(start % 2 == 1) {
                answer = Math.min(answer, arr[start]);
            }
            if(end % 2 == 0) {
                answer = Math.min(answer, arr[end]);
            }
            start = (start + 1) / 2;
            end = (end - 1) / 2;
        }
        System.out.println(answer);
    }
}