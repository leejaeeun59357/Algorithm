import java.util.*;

class 코테1차1번 {
    /**
     * 첫번째 해결 방법
     * @param n
     * @return
     */
    public int solution1(int n) {
        int answer = 0;

        if (n <= 2) {
            return 0;
        } else {
            for (int i = 2; i < n; i++) {
                int cnt = 0;
                for (int j = 1; j <= i; j++) {
                    if (i % j == 0) {
                        cnt += 1;

                        if (cnt > 2) {
                            break;
                        }
                    }
                }
                if (cnt == 2) {
                    answer += 1;
                }
            }
        }

        return answer;
    }

    /**
     * 두번째 해결 방법 (에라토스테네스의 체 알고리즘 사용)
     * @param n
     * @return
     */
    public int solution2(int n) {
        int[] array = new int[n];

        // 0 -> 소수 아님, 1 -> 소수
        for (int i = 2; i < n; i++) {
            array[i] = 1;
        }

        for (int i = 0; i <= (int)Math.sqrt(n-1); i++) {
            if(array[i] == 0) {
                continue;
            }

            int num = i * 2;
            while(num < n) {
                array[num] = 0;
                num += i;
            }
        }
        return Arrays.stream(array).sum();
    }
}