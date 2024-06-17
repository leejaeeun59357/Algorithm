import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st =
            new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        
        int[] A = new int[n];
        int[] answer = new int[n];
        
        st = new StringTokenizer(br.readLine());
        
        for(int i = 0; i < n; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        
        for(int i = 1; i < n; i++) {
            while(!stack.isEmpty() && A[stack.peek()] < A[i]) {
                answer[stack.pop()] = A[i];
            }
            stack.push(i);
        }
        
        while(!stack.isEmpty()) {
            answer[stack.pop()] = -1;
        }
        

        BufferedWriter bw = 
            new BufferedWriter(new OutputStreamWriter(System.out));
        for(int i =0; i < n; i++) {
            bw.write(answer[i] + " ");
        }
        bw.flush();
        bw.close();
    }
}