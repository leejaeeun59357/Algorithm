import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        ArrayList<ArrayList<Integer>> A = new ArrayList<>();
        
        for(int i = 0; i <= N; i++) {
            A.add(new ArrayList<>());
        }
        
        int[] indegree = new int[N+1];
        int[] selfBuild = new int[N+1];
        for(int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            selfBuild[i] = Integer.parseInt(st.nextToken());
            while(true) {
                int tmp = Integer.parseInt(st.nextToken());
                if(tmp == -1) {
                    break;
                }
                A.get(tmp).add(i);
                indegree[i]++;
            }
        }
        
        Queue<Integer> queue = new LinkedList<>();
        
        for(int i = 1; i<= N; i++) {
            if(indegree[i] == 0) {
                queue.offer(i);
            }
        }
        
        int[] result = new int[N+1];
        
        while(!queue.isEmpty()) {
            int cur = queue.poll();
            for(int x : A.get(cur)) {
                indegree[x]--;
                result[x] = Math.max(result[x], result[cur] + selfBuild[cur]);
                if(indegree[x] == 0) {
                    queue.offer(x);
                }
            }
        }
        
        for(int i = 1; i<= N; i++) {
            System.out.println(result[i] + selfBuild[i]);
        }
        
    }
}