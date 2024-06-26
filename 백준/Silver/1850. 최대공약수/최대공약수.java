import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        BufferedWriter bw =
                new BufferedWriter(new OutputStreamWriter(System.out));
        long a = sc.nextLong();
        long b = sc.nextLong();

        long answer = gcd(a,b);
        for(long i = 0; i < answer; i++) {
            bw.write("1");
        }
        bw.flush();
        bw.close();

    }

    private static long gcd(long a, long b) {
        long first = Math.max(a,b);
        long second = Math.min(a,b);

        while(true) {
            long nameogi = first % second;
            if(nameogi == 0) {
                return second;
            }
            first = second;
            second = nameogi;
        }
    }
}