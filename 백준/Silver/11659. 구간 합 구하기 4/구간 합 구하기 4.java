import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = 
            new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int numCnt = Integer.parseInt(st.nextToken());
        int quizCnt = Integer.parseInt(st.nextToken());
        
        int[] S = new int[numCnt + 1];
        
        st = new StringTokenizer(br.readLine());
        
        // 합 배열 구하기
        for(int i = 1;i<numCnt +1;i++) {
            S[i] = S[i-1] + Integer.parseInt(st.nextToken());
        }
        
        for(int i = 0; i < quizCnt ; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            System.out.println(S[y] - S[x-1]);
        }
    }
}