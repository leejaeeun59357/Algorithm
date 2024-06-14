import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);
        int numCnt = sc.nextInt();
        int M = sc.nextInt();
        
        long[] S = new long[numCnt];
        long[] C = new long[M];
        
        S[0] = sc.nextInt();
        
        // 합 배열 설정
        for(int i =1; i<numCnt; i++) {
            S[i] = S[i-1] + sc.nextInt();
        }
        
        long answer = 0;
        
        for(int i = 0; i < numCnt ; i++) {
            int nameogi = (int) (S[i] % M);
            if(nameogi == 0) {
                answer++;
            }
            C[nameogi]++;
        }
        for(int i = 0; i< M ;i++) {
            if(C[i] > 1) {
                answer += (C[i] * (C[i] - 1) / 2);
            }
        }
        System.out.println(answer);
    }
}