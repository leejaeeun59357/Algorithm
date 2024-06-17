import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        
        Queue<Integer> queue = new LinkedList<>();
        
        for(int i = 1; i <= n; i++) {
            queue.add(i);
        }
        
        while(queue.size() != 1) {
            queue.remove();
            int num = queue.remove();
            queue.add(num);
        }
        
        System.out.print(queue.remove());
    }
}