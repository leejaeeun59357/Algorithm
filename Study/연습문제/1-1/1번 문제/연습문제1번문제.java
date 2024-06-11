class 연습문제1번문제 {
    public int solution(int n) {
        int answer = 0;

        for (int i = 1; i <= n; i ++) {
            answer += i;
        }

        return answer;
    }
}