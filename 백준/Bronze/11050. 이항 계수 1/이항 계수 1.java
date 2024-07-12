import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        
        int nPr = nPr(n,k);
        int r = 1;
        for(int i = 1; i <= k; i++) {
            r *= i;
        }
        System.out.print(nPr / r);
    }
    
    private static int nPr(int n, int r) {
        int answer = 1;
        for(int i = n; i >= n-r+1; i--) {
            answer *= i;
        }
        return answer;
    }
}