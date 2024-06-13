class 코테2차5번 {
    public int[][] solution1(int[][] image, int K) {
        int height = image.length;
        int width = image[0].length;
        int[][] answer = new int[height][width];

        int N = K * K;
        int n = (K - 1) / 2;  // 중간을 기준으로 좌우 몇칸이 존재하는지

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                int sum = 0;

                for (int k = i - n; k < i - n + K; k++) {
                    for (int l = j - n; l < j - n + K; l++) {
                        int val = 0;
                        if (k >= 0 && k < height &&
                                l >= 0 && l < width) {
                            val = image[k][l];
                        }
                        sum += val;
                    }
                }
                answer[i][j] = sum / N;
            }
        }
        return answer;
    }
}