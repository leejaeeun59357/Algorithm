class 코테1차3번 {
    // 반복문 사용
    public int solution1(int N) {

        // f(n) = f(n-1) + f(n-2)

        int a = 1, b = 2;
        if(N == 1) {
            return a;
        }

        for (int i = 3; i <= N; i++) {
            int temp = a+b;
            a = b;
            b = temp;
        }

        return b;
    }

    // 재귀 사용
    public int solution2(int N) {
        if(N <= 2) {
            return N;
        }

        return solution2(N-1) + solution2(N-2);
    }
}