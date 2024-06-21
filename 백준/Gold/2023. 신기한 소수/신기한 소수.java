import java.util.*;
import java.io.*;

public class Main {
    static int n;
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int[] arr = {2,3,5,7};
        for(int x : arr) {
            DFS(x, 1);
        }
    }
    
    private static void DFS(int num, int jarisu) {
        if(jarisu == n) {
            if(isPrime(num)) {
                System.out.println(num);
            }
        }
        
        for(int i = 1; i <= 9; i++) {
            if(i % 2 == 0) {
                continue;
            }
            
            if(isPrime(num * 10 + i)) {
                DFS(num*10+i, jarisu+1);
            }
        }
        
        
    }
    private static boolean isPrime(int num) {
        for(int i = 2; i < num; i++) {
            if(num % i == 0) {
                return false;
            }
        }
        return true;
    }
}