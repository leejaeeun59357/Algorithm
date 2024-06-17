import java.util.*;
import java.io.*;

public class Main {
    // 비밀번호 체크 배열
    static int[] checkArr;
    
    // 현재 상태 배열
    static int[] myArr;
    
    // 몇 개의 문자에 대한 개수를 충족했는지 판단하는 변수
    static int checkSecret;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st =
            new StringTokenizer(br.readLine());
        // 전체 문자열 길이
        int S = Integer.parseInt(st.nextToken());
        
        // 슬라이딩 윈도우 크기
        int P = Integer.parseInt(st.nextToken());
        
        char[] A = new char[S];
        checkArr = new int[4];
        myArr = new int[4];
        checkSecret = 0;
        int answer = 0;
        
        A = br.readLine().toCharArray();
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < 4; i++) {
            checkArr[i] = Integer.parseInt(st.nextToken());
            if(checkArr[i] == 0) {
                checkSecret++;
            }
        }
        
        for(int i = 0; i < P; i++) {
            Add(A[i]);
        }
        if(checkSecret == 4) {
            answer++;
        }
        
        // 슬라이딩 윈도우 처리
        for(int i = P; i < S; i++) {
            int j = i - P;
            Add(A[i]);
            Remove(A[j]);
            if(checkSecret == 4) {
                answer++;
            }
        }
        System.out.print(answer);
        br.close();
        
    }
    
    private static void Add(char c) {
        switch(c) {
            case 'A':
                myArr[0]++;
                if(myArr[0] == checkArr[0]) {
                    checkSecret++;
                }
                break;
            case 'C':
                myArr[1]++;
                if(myArr[1] == checkArr[1]) {
                    checkSecret++;
                }
                break;
            case 'G':
                myArr[2]++;
                if(myArr[2] == checkArr[2]) {
                    checkSecret ++;
                }
                break;
            case 'T':
                myArr[3]++;
                if(myArr[3] == checkArr[3]) {
                    checkSecret++;
                }
                break;
        }
    }
    
    private static void Remove(char c) {
        switch(c) {
            case 'A':
                if(myArr[0] == checkArr[0]) {
                    checkSecret--;
                }
                myArr[0]--;
                break;
            case 'C':
                if(myArr[1] == checkArr[1]) {
                    checkSecret--;
                }
                myArr[1]--;
                break;
            case 'G':
                if(myArr[2] == checkArr[2]) {
                    checkSecret--;
                }
                myArr[2]--;
                break;
            case 'T':
                if(myArr[3] == checkArr[3]) {
                    checkSecret--;
                }
                myArr[3]--;
                break;
        }
    }
}