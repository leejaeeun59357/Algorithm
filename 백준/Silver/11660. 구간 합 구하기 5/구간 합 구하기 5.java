import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = 
            new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int size = Integer.parseInt(st.nextToken());
        int quizCnt = Integer.parseInt(st.nextToken());
        
        int[][] A = new int[size+1][size+1];
        
        // 초기 배열 생성 및 설정
        for(int i = 1; i<= size; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j =1; j<= size; j++) {
                A[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        int[][] D = new int[size+1][size+1];

        // 구간 합 배열 설정
        for(int i =1;i <= size; i++) {
            for(int j = 1; j <= size; j++) {
                D[i][j] = 
                    D[i-1][j] + D[i][j-1] - D[i-1][j-1] + A[i][j];
            }
        }
        
        // 질의에 대한 결과값 출력
        for(int i = 1; i<= quizCnt; i++) {
            st = new StringTokenizer(br.readLine());
            
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            
            int answer =
                D[x2][y2] - D[x1-1][y2] - D[x2][y1-1] + D[x1-1][y1-1];
            
            System.out.println(answer);
        }
    }
}