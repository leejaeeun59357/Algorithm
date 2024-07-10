import java.util.*;
import java.io.*;

public class Main {
    static int[][] tree;

    public static void main(String[] args) throws IOException {
        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        tree = new int[26][2];

        // 배열에 값 저장
        for(int i = 0; i < N; i++) {
            StringTokenizer st =
                    new StringTokenizer(br.readLine());
            int index = st.nextToken().charAt(0) - 'A';
            char left = st.nextToken().charAt(0);
            char right = st.nextToken().charAt(0);

            if(left == '.') {
                tree[index][0] = -1;
            } else {
                tree[index][0] = left - 'A';
            }

            if(right == '.') {
                tree[index][1] = -1;
            } else {
                tree[index][1] = right - 'A';
            }
        }
        preOrder(0);
        System.out.println();
        inOrder(0);
        System.out.println();
        postOrder(0);
        System.out.println();
    }

    private static void preOrder(int start) {
        if(start == -1) {
            return;
        }
        System.out.print((char) (start + 'A'));
        preOrder(tree[start][0]);
        preOrder(tree[start][1]);
    }

    private static void inOrder(int start) {
        if(start == -1) {
            return;
        }
        inOrder(tree[start][0]);
        System.out.print((char) (start + 'A'));
        inOrder(tree[start][1]);
    }

    private static void postOrder(int start) {
        if(start == -1) {
            return;
        }

        postOrder(tree[start][0]);
        postOrder(tree[start][1]);
        System.out.print((char) (start + 'A'));
    }
}