import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();  // 학생 수
        int M = sc.nextInt();  // 키 비교 횟수
        
        int[] indegree = new int[N+1];  // 진입 차수 배열
        List<Integer>[] list = new ArrayList[N+1]; 
        for(int i = 0; i <= N; i++) {
            list[i] = new ArrayList<Integer>();
        }
        
        for(int i = 0; i < M; i++) {
            int first = sc.nextInt();
            int second = sc.nextInt();
            list[first].add(second);
            indegree[second]++;  // 진입 차수 배열 데이터 저장하기
        }
        
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 1; i <= N; i++) {
            if(indegree[i] == 0) {
                queue.offer(i);
            }
        }
        
        while(!queue.isEmpty()) {
            int cur = queue.poll();
            System.out.print(cur + " ");
            for(int x : list[cur]) {
                indegree[x]--;
                if(indegree[x] == 0) {
                    queue.offer(x);
                }
            }
        }
    }
}