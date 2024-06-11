class Solution5 {
    public int solution(String S) {
        int answer = 0;

        int num = Integer.parseInt(S, 2);
        while (num >= 0) {

            if (num == 0) {
                break;
            }

            if (num % 2 == 0) {
                answer += 1;
                num /= 2;
            } else {
                answer += 1;
                num -= 1;
            }
        }
        return answer;
    }
}