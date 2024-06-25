import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[10000001];

        for (int i = 2; i < arr.length; i++) {
            arr[i] = i;
        }

        // 에라토스테네스의 체 사용
        for (int i = 2; i < Math.sqrt(arr.length); i++) {
            if (arr[i] == 0) {
                continue;
            }

            for (int j = i + i; j < arr.length; j = j + i) {
                arr[j] = 0;
            }
        }

        for (int i = n; i <arr.length; i++) {
            if (arr[i] != 0 && check(arr[i])) {
                System.out.println(arr[i]);
                break;
            }
        }
    }

    private static boolean check(int num) {
        char[] charArr = String.valueOf(num).toCharArray();
        int start = 0;
        int end = charArr.length - 1;

        while (start <= end) {
            if (charArr[start] != charArr[end]) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}