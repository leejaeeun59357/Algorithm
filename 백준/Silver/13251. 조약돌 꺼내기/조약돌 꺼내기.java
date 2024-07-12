import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int M = sc.nextInt();
        int T = 0; // 전체 조약돌의 갯수
        int[] D = new int[M];
        for(int i = 0; i < M; i++) {
            int num = sc.nextInt();
            T += num;
            D[i] = num;
        }
        int K = sc.nextInt();
        double answer = 0.0;
        for(int i = 0; i < M; i++) {
            int child = D[i];
            int parent = T;
            double tmp = 1.0;
            for(int j = 0; j < K; j++) {
                tmp *= (double)(child - j) / (parent - j);
            }
            answer += tmp;
        }
        System.out.println(answer);
    }
}