class 코테1차4번 {
    public int solution (int n, int i, int j) {
        return recursion(0, n, i, j);
    }

    private int recursion(int count, int n, int i, int j) {
        if (n == 2) {
            if (i == 0 & j == 1) {    // 우상단
                return count + 1;
            } else if (i == 0 & j == 0) {    // 좌상단
                return count + 2;
            } else if (i == 1 & j == 0) {    // 좌하단
                return count + 3;
            } else {    // 우하단
                return count + 4;
            }
        }

        int m = n / 2;

        if (i < m & j >= m) {    // 우상단
            return recursion(count, m, i, j - m);
        } else if (i < m & j < m) {  // 좌상단
            count += m * m;
            return recursion(count, m, i, j);
        } else if (i >= m & j < m) {  // 좌하단
            count += m * m * 2;
            return recursion(count, m, i - m, j);
        } else {  // 우하단
            count += m * m * 3;
            return recursion(count, m, i - m, j - m);
        }
    }
}