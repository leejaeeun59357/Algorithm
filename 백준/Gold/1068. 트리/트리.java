import java.util.*;
import java.io.*;

public class Main {
    static boolean[] visited;
    static ArrayList<ArrayList<Integer>> list;
    static int answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        // 변수 초기화
        list = new ArrayList<>();
        visited = new boolean[N];
        for(int i = 0; i<N; i++) {
            list.add(new ArrayList<Integer>());
        }
        int root = 0;
        int deletedNode = 0;
        answer = 0;

        StringTokenizer st =
                new StringTokenizer(br.readLine());
        for(int i =0 ; i<N;i++) {
            int num = Integer.parseInt(st.nextToken());
            if(num == -1) {
                root = i;
            } else{
                list.get(num).add(i);
                list.get(i).add(num);
            }
        }

        deletedNode = Integer.parseInt(br.readLine());

        if(root == deletedNode) {
            System.out.print("0");
        } else{
            BFS(root,deletedNode);
            System.out.println(answer);
        }


    }

    private static void BFS(int start, int deleteNode) {
        Stack<Integer> stack = new Stack<>();
        stack.push(start);
        visited[start] = true;
        while(!stack.isEmpty()) {
            int cur = stack.pop();
            boolean isChild = true;
            for(int x : list.get(cur)) {
                if(!visited[x] && x != deleteNode) {
                    stack.push(x);
                    visited[x] = true;
                    isChild = false;
                }
            }
            if (isChild) {
                answer++;
            }
        }
    }
}