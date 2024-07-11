import java.util.*;
import java.io.*;

public class Main {
    static long N, M, K, k;
    static long[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st =
                new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 수의 갯수
        M = Integer.parseInt(st.nextToken()); // 변경 일어난 횟수
        K = Integer.parseInt(st.nextToken()); // 구간합 구하는 횟수

        while (true) {
            if (Math.pow(2, k) >= N) {
                break;
            }
            k++;
        }
        int start_index = (int) Math.pow(2, k);
        arr = new long[start_index * 2];

        // 입력받은 값 배열에 저장
        for (int i = 0; i < N; i++) {
            arr[start_index + i] = Long.parseLong(br.readLine());
        }

        // 부모 노드 값 계산해서 배열에 저장
        for (int i = start_index - 1; i > 0; i--) {
            arr[i] = arr[2 * i] + arr[(2 * i) + 1];
        }

        for(int i = 0; i < M + K; i++) {
            st = new StringTokenizer(br.readLine());
            long first = Long.parseLong(st.nextToken());
            long second = Long.parseLong(st.nextToken());
            long third = Long.parseLong(st.nextToken());

            if(first == 1) {
                changeVal((int)second, third);
            } else if(first == 2) {
                getSum((int)second, (int)third);
            }
        }

    }

    private static void changeVal(int index, long value) {
        index = index + (int)Math.pow(2,k) - 1;
        long diff = value - arr[index];
        while(index > 0) {
            arr[index] = arr[index] + diff;
            index /= 2;
        }
    }

    private static void getSum(int start, int end) {
        start = start + (int)Math.pow(2,k) - 1;
        end = end + (int)Math.pow(2, k) - 1;
        long answer = 0;
        while(start <= end) {
            if(start == end) {
                answer += arr[start];
                break;
            }
            if(start % 2 == 1) {
                answer += arr[start];
            }
            if (end % 2 == 0) {
                answer += arr[end];
            }
            start = (start + 1) / 2;
            end = (end - 1) / 2;
        }
        System.out.println(answer);
    }
}